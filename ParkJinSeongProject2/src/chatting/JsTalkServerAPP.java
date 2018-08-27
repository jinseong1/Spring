package chatting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import chatting.service.ChattingPanel;
import chatting.service.LayoutService;


public class JsTalkServerAPP extends JFrame implements LayoutService {
	//UI용 컴포넌트]
	private JTextArea textHistory;
	public static final int PORT=9090;
	private HashMap client;
	
	public JsTalkServerAPP() {
		//타이틀 설정]
		super("다중채팅 서버");
		client = new HashMap();
		Collections.synchronizedMap(client);
		//컴포넌트 생성]
		createComponent();
		//컴포넌트 부착]
		addComponent();
		//리스너 부착]
		addListener();
		setSize(600,500);
		setResizable(false);
		setVisible(true);
		ServerReceiver();
	}/////////////////////////

	@Override
	public void createComponent() {
		//UI용 컴포넌트]
		textHistory = new JTextArea();
		textHistory.setEditable(false);
	}/////////////////
	
	@Override
	public void addComponent() {
		JPanel pnlCenter = new ChattingPanel(new BorderLayout());
		pnlCenter.setBorder(new TitledBorder("서버 내용"));
		pnlCenter.add(new JScrollPane(textHistory));
		JPanel pnlSouth = new ChattingPanel(new BorderLayout());
		add(pnlCenter);
		add("South",pnlSouth);
	}////////////////
	
	@Override
	public void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		});//addWindowListener
	}/////////addListener

	private void ServerReceiver() {
		ServerSocket serverSocket=null;
		Socket socket=null;
		try {
			serverSocket = new ServerSocket(PORT);
			textHistory.append("서버가 준비되었습니다\r\n");
			while(true) {
				socket = serverSocket.accept();//클라이언트와 서버 연결
				textHistory.append(socket.getInetAddress()+"님이 접속하였습니다\r\n");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}//while
		}//try
		catch (IOException e) {}//catch
	}//ServerReceiver
	
	void sendToAll(String msg) {//모든 클라이언트들에게 메세지를 보내는 메소드
		Iterator it = client.keySet().iterator();
		while(it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream)client.get(it.next());
				out.writeUTF(msg);
			} catch (IOException e) {}
		}//while
	}//sendToAll
	
	
	class ServerReceiver extends Thread{
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		ArrayList<Object> list = new ArrayList<>();
		
		ServerReceiver(Socket socket){
			this.socket=socket;
			try {
				in=new DataInputStream(socket.getInputStream());
				out=new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {}
		}//ServerReceiver
		
		public void run() {
			String name = "";
			try {
				name = in.readUTF();
				textHistory.append(name+"님이 들어오셨습니다\r\n");
				sendToAll(name+"님이 들어오셨습니다\r\n");
				//아이디 키값에 저장
				client.put(name, out);
				//////채팅방에 접속 중인 친구 리스트 클라이언트에게 뿌리기
				Iterable itb = client.keySet();				
				sendToAll("!#a2gyk3491"+itb.toString());
				
				textHistory.append("현재 서버 접속자 수는 "+client.size()+"입니다\r\n");
				while(in!=null) {
					String message = in.readUTF();
					if(message.contains("@!>")){//귓속말일시
						int startIndex = message.indexOf(":")+2;
						int lastIndex = message.indexOf("@");
						String whisper = message.substring(startIndex, lastIndex);
						lastIndex = message.indexOf(":")-1;
						String sendPerson = message.substring(0,lastIndex);
						startIndex = message.indexOf(">")+1;
						lastIndex = message.length();
						String whisperMessage = message.substring(startIndex, lastIndex);
						Set<Object> keys= client.keySet(); // 키값이 저장된 컬렉션을 반환해줌
						for(Object key : keys) {
							if(key.toString().contains(whisper)) {///////////찾음
								DataOutputStream out = (DataOutputStream)client.get(key);
								out.writeUTF(sendPerson+"님의 귓속말 : "+whisperMessage);
								//
								//out = new DataOutputStream((OutputStream)key);
								//out.writeUTF(whisperMessage);
							}////////////////////////////////////////////////찾음
							if(key.toString().contains(sendPerson)) {///////////찾음
								DataOutputStream out = (DataOutputStream)client.get(key);
								out.writeUTF(sendPerson+"→"+whisper+" : "+whisperMessage);
								//
								//out = new DataOutputStream((OutputStream)key);
								//out.writeUTF(whisperMessage);
							}////////////////////////////////////////////////찾음
						}
					}//if
					else {//귓속말이 아닐시
						sendToAll(message);	
					}//else
				}//while
			}//try
			catch (IOException e) {}
			finally {
				//퇴장한 클라이언트 name에서 제거
				client.remove(name);
				//퇴장하고 남은 친구리스트 클라이언트에게 보내기
				Iterable it = client.keySet();	
				sendToAll("!#a2gyk3491"+it.toString());
				//서버 텍스트에 출력
				textHistory.append(name+"님이 나갔습니다\r\n");
				textHistory.append(socket.getInetAddress()+"에서 접속을 종료하였습니다\r\n");
				textHistory.append("현재 서버 접속자 수는 "+client.size()+"입니다\r\n");
				//클라이언트들에게 입장 퇴장 메세지 전달
				sendToAll(name+"님이 나갔습니다\r\n");
				sendToAll(socket.getInetAddress()+"에서 접속을 종료하였습니다\r\n");
				sendToAll("현재 서버 접속자 수는 "+client.size()+"입니다\r\n");						
			}//finally
		}//run
	}/////ServerReceiver	
	
	public static void main(String[] args) {
		new JsTalkServerAPP();
	}
	
	
	
}//class