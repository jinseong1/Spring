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
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import awt26.service.LayoutService;
import swing27.MyPanel;

public class UDPClient extends JFrame implements LayoutService {
	//UI용 컴포넌트]
	JTextArea textHistory;
	
	//통신용 컴포너트]
	DatagramPacket packet;
	DatagramSocket socket;
	byte[] buf = new byte[1024];
	
	public UDPClient() {
		//타이틀 설정]
		super("UDP 클라이언트");
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
		//통신용 컴포넌트]			
		//생성시 어느 포트로 데이타를 받을지 설정]
		/*※서버에서 보내는 곳의 IP를 설정했기때문에
		  클라이언트는 무조건 받기만 하면된다.
		  즉 서버쪽 주소를 알필요 없다.*/
		packet = new DatagramPacket(buf, buf.length);
		try {
			socket = new DatagramSocket(UDPServer.PORT);
			//데이타를 읽는 스레드 start]
			new ReadSocket().start();
		} catch (SocketException e) {
			JOptionPane.showMessageDialog(this,"소켓 생성 실패");
		}
		
		
	}/////////////////
	@Override
	public void addComponent() {
		JPanel pnlCenter = new MyPanel(new BorderLayout());
		pnlCenter.setBorder(new TitledBorder("메시지 목록창"));
		pnlCenter.add(new JScrollPane(textHistory));	
		
		//프레임에 패널 부착
		add(pnlCenter);
		
	}////////////////
	@Override
	public void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}			
		});
		
	}//////////////addListener	
	class ReadSocket extends Thread{
		
		@Override
		public void run() {
			read();
		}

		private void read() {
			if(socket !=null) {
				
				while(true) {
					buf = new byte[1024];
					packet.setData(buf);
					//DatagramSocket의 receive()메소드로 데이타 받기
					try {
						socket.receive(packet);
						//패킷에 저장된 데이타를 가져오자
						byte[] bytes=packet.getData();
						textHistory.append(new String(bytes)+"\r\n");
						SingleChatServer.autoScroll(textHistory);
					} catch (IOException e) {
						JOptionPane.showMessageDialog(UDPClient.this,"데이타 읽기 오류");
					}
					
				}
				
			}
			
		}///////////
		
	}//////////////
	public static void main(String[] args) {
		new UDPClient();
	}/////////////////////////////

}
