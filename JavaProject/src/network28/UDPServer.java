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
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import awt26.service.LayoutService;
import swing27.MyPanel;

public class UDPServer extends JFrame implements LayoutService {
	//UI용 컴포넌트]
	JTextArea textHistory;
	JTextField textMessage;
	//통신용 컴포너트]
	/*
	 * 자바로 UDP통신을 하려면 DatagramPacket과 DatagramSocket사용
	 * 
	 * DatagramPacket:데이타를 보내줄때나 혹은 받을때
	 *                사용하는 클래스로
	 *                이 클래스에 데이타를 바이트 형태로 저장한다.
	 *                
	 * DatagramSocket:DatagramPacket에 저장된 바이트 형태의
	 *                데이타를 보내때는 
	 *                DatagramSocket의 send(DatagramPacket)메소드
	 *                
	 *                데이타를 받을때는
	 *                DatagramSocket의 receive(DatagramPacket)메소드 호출
	 *                이때 받은 데이타를 담을 바이트형 배열을 마련해놓고
	 *                DatagramPacket에 설정해야 한다.
	 */
	DatagramPacket packet;
	DatagramSocket socket;
	byte[] buf;
	
	public static final int PORT=9898;
	
	
	public UDPServer() {
		//타이틀 설정]
		super("UDP 서버");
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
	public void createComponent()  {
		//UI용 컴포넌트]
		textHistory = new JTextArea();
		textHistory.setEditable(false);
		textMessage = new JTextField();
		
		//통신용 컴포넌트]		
		try {
			socket = new DatagramSocket();
			buf = new byte[1024];
			//데이타를 담을 DatagramPacket생성]
			//new DatagramPacket(보낼 데이타의 byte형 배열,
			//배열의 길이,보낼 아이피,보낼 포트)
			InetAddress inet = InetAddress.getByName("localhost");
			packet = new DatagramPacket(buf,buf.length,inet, PORT);
			
		} catch (SocketException | UnknownHostException e) {
			JOptionPane.showMessageDialog(this, "소켓 생성 실패 혹은 알수 없는 호스트");
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
			
				//1]보낼 데이타.
				buf = textMessage.getText().getBytes();
				//데이타 그램 패킷에 보낼 데이터 설정]		
				packet.setData(buf);
				
				//3]DatagramSocket의 send()메소드로 DatagramPacket에
				//  저장된 데이타를 전송
				try {
					socket.send(packet);
					textHistory.append("보낸 메시지>"+textMessage.getText()+"\r\n");
					SingleChatServer.autoScroll(textHistory);
					textMessage.setText("");
					textMessage.requestFocus();
				} 
				catch (IOException e1) {
					JOptionPane.showMessageDialog(UDPServer.this,"데이타 전송 오류");
				}
				
			}
		});
		
	}//////////////addListener	
	public static void main(String[] args) {
		new UDPServer();
	}/////////////////////////////

}
