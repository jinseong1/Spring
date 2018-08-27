package chatting;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import chatting.service.ChattingPanel;
import chatting.service.IMemberService;
import chatting.service.LayoutService;



public class JsTalkClient extends JFrame implements LayoutService {
	//UI용 컴포넌트]
	private JMenuBar menuBar;
	private JMenu menuView;
	private JMenuItem menuVersion, menuMemberout;
	private JTextArea textHistory;
	private JTextField textMessage;
	private JLabel listLaybel;
	private JList list;
	private IMemberService service;
	//통신용 컴포너트]
    //※Socket클래스를 사용하면 이는 TCP통신이다.
	//※클라이언트는 서버와 연결할 한 개의 Socket만 필요하다	 
	//1]서버와 접속시 통신을 담당하는 소켓
	private Socket socket;
	//서버와 연결된 소켓(socket)에 데이타를 읽고 쓰기위한
    //입출력 필터 스트림]
	private DataInputStream dis;
	private DataOutputStream dos;
	
	JsTalkLogin login;
	String id;
	String type;
	String flnlist;
	
	public JsTalkClient(String id, IMemberService service) {
		this.id=id;
		this.service=service;
		//타이틀 설정]		
		//컴포넌트 생성]
		setTitle("ID : "+id+" 님의 채팅");
		createComponent();
		//컴포넌트 부착]
		addComponent();
		//리스너 부착]
		addListener();
		setSize(600,500);
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void createComponent() {
		//UI용 컴포넌트]
		menuBar = new JMenuBar();
		menuView = new JMenu("♒");
		menuVersion = new JMenuItem("JS Talk 정보");
		menuMemberout = new JMenuItem("회원가입 탈퇴");
		textHistory = new JTextArea();
		textHistory.setEditable(false);
		textMessage = new JTextField();
		listLaybel = new JLabel("현재 접속List");  
		list = new JList();
		
		try {
			socket = new Socket("127.0.0.1",JsTalkServerAPP.PORT);
			textHistory.append("서버에 연결됨...\r\n");
			//연결된 소켓에서 데이타를 읽어 오기위한 스트림 생성]
			dis = new DataInputStream(socket.getInputStream());
			//연결된 소켓에 데이타를 쓰기위한 스트림 생성]
			dos = new DataOutputStream(socket.getOutputStream());
			//연결된 소켓에서 서버가 전송한 데이타 읽는
			//스레드 스타트]
			new ReadSocket().start();
			//접속한 아이디를 서버에 보냄
			dos.writeUTF(id);
			}
		catch (Exception e) {}
	}/////////////////
	
	@Override
	public void addComponent() {
		//메뉴바 붙이기
		setJMenuBar(menuBar);
		menuBar.add(menuView);
		menuView.add(menuVersion);
		menuView.add(menuMemberout);
		JPanel pnlEast = new ChattingPanel(new BorderLayout());
		pnlEast.add("North",listLaybel);
		pnlEast.add(list);
		
		JPanel pnlNorth = new ChattingPanel(new FlowLayout(FlowLayout.LEFT));
		
		JPanel pnlCenter = new ChattingPanel(new BorderLayout());
		pnlCenter.setBorder(new TitledBorder("메시지 목록창"));
		pnlCenter.add(new JScrollPane(textHistory));
		
		JPanel pnlSouth = new ChattingPanel(new BorderLayout());
		pnlSouth.setBorder(new TitledBorder("메시지 입력창"));
		pnlSouth.add(textMessage);
		//프레임에 패널 부착
		add(pnlCenter);
		add("East",pnlEast);
		add("South",pnlSouth);
		add("North",pnlNorth);
	}////////////////
	
	@Override
	public void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//텍스트필드 와 버튼에 액션 리스너부착
		textMessage.addActionListener(handler);
		menuVersion.addActionListener(handler);
		menuMemberout.addActionListener(handler);
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {//귓속말을 보내기 위해 클리이언트가 아이디를 클릭하였을 시
				if(e.getValueIsAdjusting()) {					
					Object whisper = list.getSelectedValue();
					//아이디 클릭시 메세지 창에 세팅 됨
					textMessage.setText(whisper.toString()+"@!>");
					list.requestFocus(false);
					textMessage.requestFocus();
					
				}//if
			}//valueChanged
		});//ListSelectionListener
	}///////////////addListener()
	
	
	ActionListener handler = new ActionListener() {	
		JsTalkInfomation jsInfo;
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
				//연결된 소켓에 데이타 쓰기]
			if(source==menuVersion) {//버전 정보를 눌렀을 시
				if(jsInfo==null) {//최초생성
					jsInfo = new JsTalkInfomation();
					return;
					}//if
					if(!jsInfo.isVisible()) {//보이지 않을때
						jsInfo.setVisible(true);
					}//if
			}
			else if(source==menuMemberout) {//회원가입 탈퇴를 눌렀을 시
				new JsTalkSingOutMember(id, service);
			}
			else if(socket !=null) {
					try {
						//연결된 소켓에 데이타 쓰기]
						dos.writeUTF(id+" : "+textMessage.getText().trim()+"\r\n");
					} 
					catch (IOException e1) {
						//※연결된 소켓에 데이타 쓸때 소켓이 끊어지면
						//  즉 서버가 나가면 예외발생.
						JOptionPane.showMessageDialog(JsTalkClient.this,"연결이 끊어졌어요");
					}
					finally {
						//텍스트 클리어 및 포커스 주기
						autoScroll(textHistory);
						textMessage.setText("");
						textMessage.requestFocus();
					}
				}////////////

				
			}//if
		
		
	};////////////////////////////ActionListener
	
	//서버와 연결된 소켓에 쓰여진 데이타를 읽기 위한 스레드]
	class ReadSocket extends Thread{
		@Override
		public void run() {
			read();
		}///////////////
		private void read() {
			if(socket !=null) {//클라이언트와 연결된 경우]
				while(true) {

					try {
						String textno = dis.readUTF();

						if(textno.trim().contains("!#a2gyk3491")) {//서버에서 친구 리스트를 보냈을 시
							int beginIndex = textno.indexOf("1")+2;
							int lastIndex = textno.lastIndexOf("]");
							String fid = textno.substring(beginIndex, lastIndex);
							String fidArry[] = fid.trim().split(", ");
							Vector fidData = new Vector();
							//친구 리스트 리셋
							list.setListData(fidData);
							for(int i=0;i<fidArry.length;i++) {
								//친구  리스트 추가
								if(!fidArry[i].trim().equals(id.trim())) {
									fidData.add(fidArry[i]);
									list.setListData(fidData);
								}
								else {}
							}//for
						}////////////////////////if
						else {//서버에서 정상적인 메세지를 보냈을시
						textHistory.append(textno);
						}
					} 
					catch (IOException e) {
						textHistory.append("서버가 중지되었어요\r\n");
						break;
					}
					finally {
						autoScroll(textHistory);
					}
				}///while
			}
		}//////////////////////
	}/////////////////////////////////
	public static void autoScroll(JTextArea textArea) {
		//1.텍스트에리어의 모든 텍스트 길이 얻기
		int length=textArea.getText().length();
		//텍스트 끝에 캐롯 추가
		textArea.setCaretPosition(length);
		//텍스트에리어에 포커스 주기
		textArea.requestFocus();
	}////////////////////////////
	
}//class
