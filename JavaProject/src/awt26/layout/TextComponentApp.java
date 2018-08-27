package awt26.layout;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.layout.CardLayoutApp.EventHandler;
import awt26.service.LayoutService;

public class TextComponentApp extends Frame implements LayoutService {
	
	private Button btnCopy,btnReset;
	private TextField textSrcUser,textDestUser,textSrcPass,textDestPass;	
	
	
//	생성자
	public TextComponentApp() {
		//1]타이틀 설정
		super("TextField 컴포넌트 연습");
		//2]레이아웃 변경		
		setLayout(new GridLayout(3,1));
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정	
		setSize(430, 200);
		setVisible(true);
	}////////////////////////////
	

	@Override
	public void createComponent() {
		textSrcUser = new TextField();
//		메소드 컬럼수 지정
		textSrcUser.setColumns(15);
//		메소드로 기본 텍스트 설정
		textSrcUser.setText("아이디");
//		인자생성자로 텍스트 컬럼수 설정
		textSrcPass = new TextField("비밀번호",15);
//		텍스트 폰트 설정
		Font font = new Font("굴림체", Font.BOLD, 15);
		textSrcUser.setFont(font);
//		글자색 변경
		textSrcUser.setForeground(Color.RED);
		
//		textSrcPass.setEchoChar('*');
		textDestUser = new  TextField(15);
		textDestPass = new TextField(15);
		textDestPass.setEchoChar('*');
		
//		기본생성자로 버튼 생성
		btnCopy = new Button();
		btnCopy.setLabel("복사");
		btnReset = new Button("초기화");

	}

	@Override
	public void addComponent() {
//		1행
		Panel pnlFirst = new  Panel();
		pnlFirst.add(new Label("아이디"));
		pnlFirst.add(textSrcUser);
		pnlFirst.add(new Label("비밀번호"));
		pnlFirst.add(textSrcPass);
		
//		2행
		Panel pnlSecond = new Panel();
		pnlSecond.add(btnCopy);
		pnlSecond.add(btnReset);
		
		
		
		
//		3행
		Panel pnlThird = new Panel();
		pnlThird.add(new Label("아이디"));
		pnlThird.add(textDestUser);
		pnlThird.add(new Label("비밀번호"));
		pnlThird.add(textDestPass);
		
		
//		프레임에 부착
		add(pnlFirst);
		add(pnlSecond);
		add(pnlThird);
	}
	
	
	

	@Override
	public void addListener() {
		addWindowListener(handler);
//		버튼에 액션리스너 부착
		btnCopy.addActionListener(handler);
		btnReset.addActionListener(handler);
//		텍스트필드에 포커스 리스너 부착
		textSrcUser.addFocusListener(handler);
		textSrcPass.addFocusListener(handler);
		
		
		
		
		

	}
	
	private EventHandlerApp handler = new EventHandlerApp();	
	
//	InnerClass
	class EventHandlerApp extends WindowAdapter implements ActionListener, FocusListener{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
		@Override
		public void windowOpened(WindowEvent e) {
//			포커스를 버튼에...
			btnCopy.requestFocus();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnCopy) {
				textDestPass.setText(textSrcPass.getText());
				textDestUser.setText(textSrcUser.getText());
			}
			else {
				textSrcPass.setText("비밀번호");
				textSrcUser.setText("아이디");
				textDestPass.setText("");
				textDestUser.setText("");
			}

			
		}

//		얻었을때 자동으로 호출
		@Override
		public void focusGained(FocusEvent e) {
			setTitle("포커스를 얻다");
			Object source = e.getSource();
			if(source==textSrcUser && textSrcUser.getText().trim().equals("아이디")) {
				textSrcUser.setText("");
			}
			else if(source==textSrcPass && textSrcPass.getText().trim().equals("비밀번호")) {
				textSrcPass.setText("");
			}
			
			
		}
//		포커스를 잃었을때 자동으로 호출
		@Override
		public void focusLost(FocusEvent e) {
			setTitle("포커스를 잃다");
			Object source = e.getSource();
			if(source==textSrcUser && textSrcUser.getText().trim().equals("")) {
				textSrcUser.setText("아이디");
			}
			else if(source==textSrcPass && textSrcPass.getText().trim().equals("")) {
				textSrcPass.setText("비밀번호");
			}
		}
		
		
		
		
		
	}//InnerClass
	
	
	
	
	
	public static void main(String[] args) {
		new TextComponentApp();

	}//main
}//class
