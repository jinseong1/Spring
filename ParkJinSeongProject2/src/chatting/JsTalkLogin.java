package chatting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import chatting.model.MemberDAO;
import chatting.model.MemberDTO;
import chatting.service.IConnect;
import chatting.service.IMemberService;
import chatting.service.IMemberServiceImpl;
import chatting.service.LayoutService;
//로그인 창
public class JsTalkLogin extends JFrame implements LayoutService {
	private JLabel lblMainImage;
	private JMenuBar menuBar;
	private JMenu menuView;
	private JMenuItem menuVersion;
	private JTextField textId, textPass;
	private JButton btnLogin, btnSingUp;
	private IMemberService service;
	public String id;
	
//	생성자
	public JsTalkLogin() {
		super("JS talk");
		createComponent();
		addComponent();
		addListener();
		setBackground(Color.WHITE);
//		창 사이즈
		setSize(400,500);
//		창 크기 변경 불가
		setResizable(false);
//		창 보이기
		setVisible(true);
//		가운데 정렬
		GraphicsEnvironment ge = 
		GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd= ge.getDefaultScreenDevice();
		DisplayMode dm= gd.getDisplayMode();
		int screenWidth=dm.getWidth();
		int screenHeigth= dm.getHeight();
		int xPos = screenWidth/2 -this.getWidth()/2;
		int yPos = screenHeigth/2 - this.getHeight()/2;
		this.setLocation(xPos, yPos);
		new LoginColor().start();
	}// Constructor ChatTingLogin

	@Override
	public void createComponent() {
		menuBar = new JMenuBar();
		menuView = new JMenu("♒");
		menuVersion = new JMenuItem("JS Talk 정보");
		textId = new JTextField();
		textPass = new JTextField();
		btnLogin = new JButton("로그인");
		btnSingUp = new JButton("회원가입");
//		이미지
		Image image=Toolkit.getDefaultToolkit().getImage("src/chatting/element3d_paper_plane.jpg");
		image=image.getScaledInstance(200, 150, Image.SCALE_DEFAULT);
		Icon icon = new ImageIcon(image);
		lblMainImage = new JLabel(icon, JLabel.CENTER);
		lblMainImage.setPreferredSize(new Dimension(200, 150));
		lblMainImage.setOpaque(true);
		service = new IMemberServiceImpl(IConnect.ORACLE_URL,"SAMPLE","SAMPLE");
		
		
		
		
	}

	@Override
	public void addComponent() {
//		메뉴바 붙이기
		setJMenuBar(menuBar);
		menuBar.add(menuView);
		menuView.add(menuVersion);
//		3행 1열 패널 생성
		JPanel pnlAll = new JPanel(new GridLayout(3, 1));
		
//		1행 패널
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(76, 174, 221));
		pnlNorth.add(lblMainImage);
//		2행 패널
		JPanel pnlCenter = new JPanel(null);
		pnlCenter.setBackground(new Color(76, 174, 221));
		textId.setBounds(50, 10, 300, 40);
		pnlCenter.add(textId);
		textPass.setBounds(50, 50, 300, 40);
		pnlCenter.add(textPass);
		btnLogin.setBounds(50, 90, 300, 40);
		btnLogin.setBackground(Color.GRAY);
		pnlCenter.add(btnLogin);
//		3행 패널
		JPanel pnlSouth = new JPanel(null);
		pnlSouth.setBackground(new Color(76, 174, 221));
		btnSingUp.setBounds(150, 90, 100, 28);
		btnSingUp.setBackground(new Color(76, 174, 221));
		pnlSouth.add(btnSingUp);
		
		
//		패널에 모두 부착
		pnlAll.add(pnlNorth);
		pnlAll.add(pnlCenter);
		pnlAll.add(pnlSouth);
//		JFrame에 부착
		add(pnlAll);
		
	}

	@Override
	public void addListener() {
		//종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				service.close();
			}
		});
		
		btnLogin.addActionListener(handler);
		btnSingUp.addActionListener(handler);
		menuVersion.addActionListener(handler);
		menuView.addActionListener(handler);
		textId.addActionListener(handler);
		
		
	}//addListener
	private JsTalkSingUp chattingSingUp;
	private JsTalkInfomation jsInfo;
	
	ActionListener handler = new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			id = textId.getText();
			if(source==btnLogin) {//로그인 버튼을 눌렀을 경우
				if(id.length()!=0 && textPass.getText().length()!=0) {//아이디 및 비밀번호를 정상적으로 입력하였을 시
					MemberDTO dto = new MemberDTO(id, textPass.getText(), null, null, null, null, null);
					try {
						if(service.selectOne(dto)!=null) {//아이디 및 비밀번호가 모두 일치할 경우
							new JsTalkClient(id, service);
							dispose();
						}
						else {//아이디랑 비밀번호가 일치하지 않은 경우
							JOptionPane.showMessageDialog(JsTalkLogin.this, "아이디랑 비밀번호가 일치하지 않습니다");
						}
					} catch (Exception e1) {}
					
				}//if 아이디 및 비밀번호를 정상적으로 입력하였을 시
				else {//아이디 및 비밀번호는 정상적으로 입력하지 않았을시 
					JOptionPane.showMessageDialog(JsTalkLogin.this,"아이디 및 비밀번호를 입력하여주세요");
				}
			}//if 로그인 버튼을 눌렀을 경우
			
			else if(source==btnSingUp) {//회원가입을 눌렀을 경우
				if(chattingSingUp==null) {//최초생성
				chattingSingUp = new JsTalkSingUp(service);
				return;
				}//if
				if(!chattingSingUp.isVisible()) {//보이지 않을때
					chattingSingUp.setVisible(true);
				}//if
			}//if
			else if(source==menuVersion) {//버전정보를 눌렀을 시
				if(jsInfo==null) {//최초생성
					jsInfo = new JsTalkInfomation();
					return;
				}//if
				if(!jsInfo.isVisible()) {//보이지 않을때
					jsInfo.setVisible(true);
				}//if
			}//else if 버전정보를 눌렀을 시
			
		}//actionPerformed
	};/////////////handler

	class LoginColor extends Thread{//아이디 입력시 로그인 버튼 변경을 위한 클래스
		@Override
		public void run() {
			while(true) {
				if(textId.getText().length()==0) {
					System.out.println("");
					btnLogin.setBackground(Color.DARK_GRAY);
				}
				else {
					System.out.println("");
					btnLogin.setBackground(Color.WHITE);
				}
			}
		}
	}

	public String StringId() {
		return textId.getText();
	}//StringId
	public static void main(String[] args) {
		new JsTalkLogin();
	}
	
	
}//class
