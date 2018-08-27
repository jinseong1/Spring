package swing27;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import awt26.service.LayoutService;

public class Component01 extends JFrame implements LayoutService {
	//[멤버변수]
	private JLabel lblNoImage,lblImage,lblTextImage;
	private JButton btnNoImage,btnImage,btnTxetImage;
	private JTextField txtLeftRight,txtRightLeft;
	private JPasswordField password;


	private JDialog dialog;
	private JLabel lblDialog;
	
	public Component01() {
		//1]타이틀 설정
		super("Swing컴포넌트 연습01");		
		//2]레이아웃 변경		
		setLayout(new GridLayout(3, 1));
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정	
		setSize(600, 350);
		setVisible(true);
	}/////////////////
	@Override
	public void createComponent() {
		//레이블 생성]
		//텍스트는 왼쪽배치가 디폴트
		lblNoImage = new JLabel("No Image",JLabel.CENTER);
		lblNoImage.setPreferredSize(new Dimension(150, 50));
		/*
	    * Awt에서는 Label의 백그라운드가 바로 적용되나
	    * Swing에서는  JLabel의 setOpaque(true)메소드를
	    * 호출해야 백그라운드가 설정됨
	    * setOpaque(true)
	    */
		lblNoImage.setOpaque(true);
		lblNoImage.setBackground(Color.YELLOW);
		//AWT와는 다르게 JLabel에는 이미지도
		//올려 놓을 수 있다.
		//방법1] ImageIcon(String filename)사용
		//Icon icon = new ImageIcon("src/awt26/event/terran.jpg");
		//방법2] ImageIcon(Image image) 사용
		Image image=Toolkit.getDefaultToolkit().getImage("src/awt26/event/terran.jpg");
		//이미지 크기 조정]Image타입의 메소드로
		image=image.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		Icon icon = new ImageIcon(image);
		//이미지는 가운데 배치가 디폴트
		lblImage = new JLabel(icon,JLabel.RIGHT);
		lblImage.setPreferredSize(new Dimension(150, 50));
		lblImage.setOpaque(true);
		lblImage.setBackground(Color.GREEN);
		lblImage.setToolTipText("이미지 레이블");
		
		lblTextImage = new JLabel("Image&Text", icon, JLabel.LEFT);
		lblTextImage.setPreferredSize(new Dimension(200, 50));
		lblTextImage.setOpaque(true);
		lblTextImage.setBackground(Color.CYAN);
		lblTextImage.setToolTipText("Image&Text");
		//이미지와 텍스트 동시 배치시 이미지 오른쪽에 텍스트 배치가 디폴트
		//아래는 이미지왼쪽에 텍스트배치하는 설정
		lblTextImage.setHorizontalTextPosition(JLabel.LEFT);
		
		//텍스트 필드 및 패스워드 생성]
		txtLeftRight = new JTextField("왼쪽에서 오른쪽", 15);
		txtLeftRight.setBorder(new LineBorder(Color.GREEN));
		//자바 swing textfield underline로 검색
		Font font = txtLeftRight.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		txtLeftRight.setFont(font.deriveFont(attributes));
		
		
		txtRightLeft = new JTextField("오른쪽에서 왼쪽",15);
		//텍스트를 오른쪽에서 부터 채워지도록 설정
		txtRightLeft.setHorizontalAlignment(JLabel.RIGHT);
		txtRightLeft.setBorder(new LineBorder(Color.RED,3));
		//패스워드 필드]
		/*
		 * Awt에서는 비밀번호 입력용 컴포넌트를 
		 * 제공하지 않음
		 * 그래서 TextField컴포넌트의 
		 * setEchoChar(char)메소드로 
		 * JPasswordField컴포넌트 효과를 냄
		 */
		password = new JPasswordField(15);
		password.setBorder(new LineBorder(Color.CYAN,3,true));
		//디폴트 ●로 표시됨. 다른	문자로 변경시
		password.setEchoChar('*');
		password.setToolTipText("비밀번호를 입력하세요?");
		//버튼 생성]
		btnNoImage = new JButton("No Image");
		//버튼에 LineBorder
		//btnNoImage.setBorder(new LineBorder(Color.RED));
		//버튼에 BevelBorder
		//btnNoImage.setBorder(new BevelBorder(BevelBorder.RAISED,Color.RED,Color.GREEN));
		btnImage = new JButton(icon);
		//버튼을 이미지 크기에 맞게 조정
		btnImage.setPreferredSize(new Dimension(50, 50));
		btnImage.setToolTipText("클릭하세요?");
		
		btnTxetImage = new JButton("테란", icon);
		btnTxetImage.setBackground(Color.WHITE);
		btnTxetImage.setPreferredSize(new Dimension(180, 50));
		//이미지 왼쪽에 텍스트 배치
		btnTxetImage.setHorizontalTextPosition(JLabel.LEFT);
		btnTxetImage.setToolTipText("이미지와 텍스트");
		
		//다이얼로그 생성]
		dialog = new JDialog(this, "다이얼로그",true);
		dialog.setLayout(new FlowLayout());
		dialog.add(lblDialog=new JLabel());
		dialog.setSize(300, 100);
	}/////////////////

	@Override
	public void addComponent() {
		JPanel pnlLabel = new JPanel();
		pnlLabel.setBorder(new TitledBorder("레이블 연습"));
		pnlLabel.add(lblNoImage);
		pnlLabel.add(lblImage);
		pnlLabel.add(lblTextImage);
		add(pnlLabel);
		
		JPanel pnlText = new JPanel();
		pnlText.setBorder(new TitledBorder("텍스트 필드 연습"));
		pnlText.add(txtLeftRight);
		pnlText.add(txtRightLeft);
		pnlText.add(password);
		add(pnlText);
		
		JPanel pnlButton = new JPanel();
		pnlButton.setBorder(new TitledBorder("버튼 연습"));
		pnlButton.add(btnNoImage);
		pnlButton.add(btnImage);
		pnlButton.add(btnTxetImage);
		add(pnlButton);
	}

	@Override
	public void addListener() {
		//Awt방식으로 원도우 종료-프로그램 종료할때 처리할 일이 있는 경우]
		/*
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {				
				System.exit(0);
			}
		});*/
		//스윙에 추가된 원도우 종료방식]
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//버튼에 리스너 부착]
		btnNoImage.addActionListener(handler);
		btnImage.addActionListener(handler);
		
	}
	//이벤트 핸들러
	private ActionListener handler = new ActionListener() {
		private boolean toggle;
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();
			if(source == btnImage) {
				if(!dialog.isVisible()) {//다이얼로그창 띄워서 비밀번호 출력]
					char[] pass=password.getPassword();					
					lblDialog.setText(String.valueOf(pass));
					dialog.setVisible(true);
				}
			}
			else {//JPasswordField 테두리 설정 및 해제 토글링	
				if(!toggle) {
					password.setBorder(null);					
				}
				else {
					password.setBorder(new LineBorder(Color.CYAN,3,true));
				}
				toggle = !toggle;
			}
		}/////////
	};///////////////////

	public static void main(String[] args) {
		new Component01();
	}///////////////

}
