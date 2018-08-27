package network28;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import awt26.service.LayoutService;
import swing27.MyPanel;

public class SingleChatServer extends JFrame implements LayoutService {
	//UI용 컴포넌트]
	JTextArea textHistory;
	JTextField textMessage;
	//통신용 컴포너트]
    //※Socket클래스를 사용하면 이는 TCP통신이다.
    //※서버는 두개의 Socket이 필요하다	 
	//1]클라이언트의 연결(접속)을 기다리는 역할을 담당하는 소켓
	ServerSocket listenSocket;
	//2]클라이언트 접속시 통신을 담당하는 소켓
	Socket socket;
	//클라이언트와 연결된 소켓(socket)에 데이타를 읽고 쓰기위한
	//입출력 필터 스트림]
	DataInputStream dis;
	DataOutputStream dos;
	//서버용 포트
	public static final int PORT=9090;
	
	
	public SingleChatServer() {
		//타이틀 설정]
		super("일대일 채팅 서버");
		//컴포넌트 생성]
		createComponent();
		//컴포넌트 부착]
		addComponent();
		//리스너 부착]
		addListener();
		
		setSize(600,500);
		setResizable(false);
		setVisible(true);
		/*
		 * ※윈도우 화면 보이기(setVisible(true))이후에
		 * ServerSocket의 accept()메소드 호출
		 * accept()메소드는 클라이언트가 접속하게되면
		 * 클라이언트와 연결된 Socket 을 반환한다
		   아래는 클라이언트가 한번만 접속할때 사용
		   즉 접속했다가 다시 접속은 불가.
		   왜냐하면 아래코드는 한번 만 실행된 후 다시 실행불가
		   고로 사용자의 접속을 또 다시 받기위해서는 스레드로 구성
		   해야 한다.
		*/	
		/*
		try {
			//클라이언트의 연결을 기다림(Listen)]
			socket = listenSocket.accept();
			//클라이언트 연결 성공시 아래코드가 진행됨]
			textHistory.append(socket.getInetAddress().getHostAddress()+"가 접속함...\r\n");
			//연결된 소켓에서 데이타를 읽어 오기위한 스트림 생성]
			dis = new DataInputStream(socket.getInputStream());
			//연결된 소켓에 데이타를 쓰기위한 스트림 생성]
			dos = new DataOutputStream(socket.getOutputStream());
			//연결된 소켓에서 클라이언트가 전송한 데이타 읽는
			//스레드 스타트]
			new ReadSocket().start();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this,"클라이언트 연결실패");
		}
		finally {
			autoScroll(textHistory);
		}
		*/
		//위 코드를 스레드로 대체]
		new ListenSocket().start();
	}/////////////////////////
	@Override
	public void createComponent() {
		//UI용 컴포넌트]
		textHistory = new JTextArea();
		textHistory.setEditable(false);
		textMessage = new JTextField();
		
		try {
			/*
			ServerSocket 생성
	       -port만 지정하면 됨.
	       -클라이언트는 9090 port로 접속

	        1]ServerSocket 생성
	        ServerSocket생성만으로 클라이언트와 
	        	통신을 하기 위한 Server가 생성됨.
	        	생성시 클라이언트와 통신할 Port만 
	        	지정해주면 됨.
			 */
			listenSocket = new ServerSocket(PORT);
			textHistory.append("Server Started....\r\n");
			/*
		        ※ServerSocket의 accept()메소드는
		    프레임의 setVisible(true)이후에 호출해라
		    왜냐하면 이전에 호출하면 불락상태가
		    됨으로 코드의 진행이 안됨.
			accept()는 클라이언트의 접속을 기다리는 메소드로
		    클라이언트가 접속하기 전까지 accept()메소드 이후가 
		    실행 안되고 블락상태에 빠진다.		    
		    */
			//socket=listenSocket.accept();
			
		} 
		catch (IOException e) {
			JOptionPane.showMessageDialog(this,"서버소켓 생성 실패");
		}

	}/////////////////
	@Override
	public void addComponent() {
		JPanel pnlCenter = new MyPanel(new BorderLayout());
		pnlCenter.setBorder(new TitledBorder("메시지 목록창"));
		pnlCenter.add(new JScrollPane(textHistory));
		
		JPanel pnlSouth = new MyPanel(new BorderLayout());
		pnlSouth.setBorder(new TitledBorder("메시지 입력창"));
		pnlSouth.add(textMessage);
		//프레임에 패널 부착
		add(pnlCenter);
		add("South",pnlSouth);
	}////////////////
	@Override
	public void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			//프로그램 처음 실행시 메시지 입력 텍스트 필드에 포커스 주기
			@Override
			public void windowOpened(WindowEvent e) {
				textMessage.requestFocus();
			}
		});
		//텍스트필드에 액션 리스너부착
		textMessage.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					//연결된 소켓에 데이타 쓰기]
					dos.writeUTF(textMessage.getText());
					//확인용-텍스트에리어에 다시 출력]
					textHistory.append("SERVER>"+textMessage.getText()+"\r\n");
					
				} 
				catch (IOException e1) {
					//※연결된 소켓에 데이타 쓸때 소켓이 끊어지면
					//  즉 클라이언트가 나가면 예외발생.
					textHistory.append("연결이 끊어졌어요\r\n");
				}
				finally {
					autoScroll(textHistory);
					//텍스트 클리어 및 포커스 주기
					textMessage.setText("");
					textMessage.requestFocus();
					
				}
				
			}
		});//////////////////////////////
		
		

	}/////////////////////////////
	
	
	//클라이언트와 연결된 소켓에 쓰여진 데이타를 읽기 위한 스레드]
	class ReadSocket extends Thread{
		
		@Override
		public void run() {
			read();
		}///////////////

		private void read() {
			if(socket !=null) {//클라이언트와 연결된 경우]
				while(true) {
					
					try {
						textHistory.append("CLIENT>"+dis.readUTF()+"\r\n");
					} 
					catch (IOException e) {
						textHistory.append("클라이언트가 연결을 끊었어요\r\n");
						break;
					}
					finally {
						autoScroll(textHistory);
					}
				}///while
				
			}
		}//////////////////////
	}/////////////////////////////////
	
	//사용자 접속을 기다리(Listen)는 스레드]
	class ListenSocket extends Thread{
		@Override
		public void run() {
			listen();
		}
		private void listen() {
			if(listenSocket !=null) {
				while(true) {
					try {
						//클라이언트의 연결을 기다림(Listen)]
						socket = listenSocket.accept();
						//클라이언트 연결 성공시 아래코드가 진행됨]
						textHistory.append(socket.getInetAddress().getHostAddress()+"가 접속함...\r\n");
						//연결된 소켓에서 데이타를 읽어 오기위한 스트림 생성]
						dis = new DataInputStream(socket.getInputStream());
						//연결된 소켓에 데이타를 쓰기위한 스트림 생성]
						dos = new DataOutputStream(socket.getOutputStream());
						//연결된 소켓에서 클라이언트가 전송한 데이타 읽는
						//스레드 스타트]
						new ReadSocket().start();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(SingleChatServer.this,"클라이언트 연결실패");
					}
					finally {
						autoScroll(textHistory);
					}
				}//while				
			}//if			
		}
	}//////////////////////////	
	//대화 메시지 증가시 자동으로 내용을 위로 올리는 메소드]
	public static void autoScroll(JTextArea textArea) {
		//1.텍스트에리어의 모든 텍스트 길이 얻기
		int length=textArea.getText().length();
		//텍스트 끝에 캐롯 추가
		textArea.setCaretPosition(length);
		//텍스트에리어에 포커스 주기
		textArea.requestFocus();
	}////////////////////////////	
	public static void main(String[] args) {
		new SingleChatServer();
	}/////////////////////////////

}
