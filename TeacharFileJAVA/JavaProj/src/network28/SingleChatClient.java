package network28;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import awt26.service.LayoutService;
import swing27.MyPanel;

public class SingleChatClient extends JFrame implements LayoutService {
	//UI용 컴포넌트]
	JTextArea textHistory;
	JTextField textMessage,textAddress;
	JButton btnConnect;
	//통신용 컴포너트]
    //※Socket클래스를 사용하면 이는 TCP통신이다.
	//※클라이언트는 서버와 연결할 한 개의 Socket만 필요하다	 
	//1]서버와 접속시 통신을 담당하는 소켓
	Socket socket;
	//서버와 연결된 소켓(socket)에 데이타를 읽고 쓰기위한
    //입출력 필터 스트림]
	DataInputStream dis;
	DataOutputStream dos;
	
	
	
	public SingleChatClient() {
		//타이틀 설정]
		super("일대일 채팅 클라이언트");
		//컴포넌트 생성]
		createComponent();
		//컴포넌트 부착]
		addComponent();
		//리스너 부착]
		addListener();
		
		setSize(600,500);
		setResizable(false);
		setVisible(true);
		
		
	}/////////////////////////
	@Override
	public void createComponent() {
		//UI용 컴포넌트]
		textHistory = new JTextArea();
		textHistory.setEditable(false);
		textMessage = new JTextField();
		textAddress = new JTextField("127.0.0.1", 30);
		btnConnect  = new JButton("서버연결");
		
	}/////////////////
	@Override
	public void addComponent() {
		JPanel pnlNorth = new MyPanel(new FlowLayout(FlowLayout.LEFT));
		pnlNorth.add(textAddress);
		pnlNorth.add(btnConnect);
		
		JPanel pnlCenter = new MyPanel(new BorderLayout());
		pnlCenter.setBorder(new TitledBorder("메시지 목록창"));
		pnlCenter.add(new JScrollPane(textHistory));
		
		JPanel pnlSouth = new MyPanel(new BorderLayout());
		pnlSouth.setBorder(new TitledBorder("메시지 입력창"));
		pnlSouth.add(textMessage);
		//프레임에 패널 부착
		add(pnlCenter);
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
		btnConnect.addActionListener(handler);
		textMessage.addActionListener(handler);
		
	}///////////////addListener()
	ActionListener handler = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == btnConnect) {//서버 연결
				try {
					socket = new Socket(textAddress.getText().trim(),SingleChatServer.PORT);
					textHistory.append("서버에 연결됨...\r\n");
					//연결된 소켓에서 데이타를 읽어 오기위한 스트림 생성]
					dis = new DataInputStream(socket.getInputStream());
					//연결된 소켓에 데이타를 쓰기위한 스트림 생성]
					dos = new DataOutputStream(socket.getOutputStream());
					//연결된 소켓에서 서버가 전송한 데이타 읽는
					//스레드 스타트]
					new ReadSocket().start();
				} 
				catch (Exception e1) {
					JOptionPane.showMessageDialog(SingleChatClient.this,"서버 연결 실패");
				}	
				
			}/////if
			else {//메시지 입력			
				//연결된 소켓에 데이타 쓰기]
				if(socket !=null) {
					
					try {
						//연결된 소켓에 데이타 쓰기]
						dos.writeUTF(textMessage.getText().trim());
						//확인용-텍스트에리어에 다시 출력]
						textHistory.append("CLIENT>"+textMessage.getText().trim()+"\r\n");
						
					} 
					catch (IOException e1) {
						//※연결된 소켓에 데이타 쓸때 소켓이 끊어지면
						//  즉 서버가 나가면 예외발생.
						JOptionPane.showMessageDialog(SingleChatClient.this,"연결이 끊어졌어요");
					}
					finally {
						SingleChatServer.autoScroll(textHistory);
						//텍스트 클리어 및 포커스 주기
						textMessage.setText("");
						textMessage.requestFocus();
					}
					
				}////////////
				
			}
		}
	};////////////////////////////
	
	
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
						textHistory.append("SERVER>"+dis.readUTF()+"\r\n");
					} 
					catch (IOException e) {
						textHistory.append("서버가 중지되었어요\r\n");
						break;
					}
					finally {
						SingleChatServer.autoScroll(textHistory);
					}
				}///while
				
			}
		}//////////////////////
	}/////////////////////////////////
	public static void main(String[] args) {
		new SingleChatClient();
	}/////////////////////////////

}
