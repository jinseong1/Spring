package awt26.event;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import awt26.service.LayoutService;







//	처리할 이벤트가 적은 경우 
public class EventHandlerByAnonymous extends Frame implements LayoutService {
	
	private TextField text;
	private Button btnOk,btnExit;
	private Label lblMessage;
	
	
	
	public EventHandlerByAnonymous() {

		super("익명 클래스로 이벤트 핸들러 구현");

		setLayout(new FlowLayout());

		addComponent();

		addListener();

		pack();
		setVisible(true);
		
//		화면해상도 얻어서 어플 가운데 배치
		GraphicsEnvironment ge = 
		GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd= ge.getDefaultScreenDevice();
		DisplayMode dm= gd.getDisplayMode();
		int screenWidth=dm.getWidth();
		int screenHeigth= dm.getHeight();
		int xPos = screenWidth/2 -this.getWidth()/2;
		int yPos = screenHeigth/2 - this.getHeight()/2;
		this.setLocation(xPos, yPos);
		
	}

	@Override
	public void createComponent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addComponent() {
		add(text=new TextField(20));
		add(btnOk=new Button("확인"));
		add(btnExit=new Button("종료"));
		lblMessage = new Label();
		lblMessage.setBackground(new Color(255,255,0));
		lblMessage.setPreferredSize(new Dimension(300, 30));
		add(lblMessage);

	}

	@Override
	public void addListener() {
		/*
//		방법 1 각 이벤트 소스별로 익명 클래스 작성 프레임 윈도우 이벤트 발생
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				텍스트필드에 있는 문자열을 레이블에 설정
				lblMessage.setText(text.getText());
//				텍스트필드 문자열 삭제
				text.setText("");
				text.requestFocus();
				
			}
		});
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
//		텍스트 필드
		text.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				텍스트필드에 있는 문자열을 레이블에 설정
				lblMessage.setText(text.getText());
//				텍스트필드 문자열 삭제
				text.setText("");
				text.requestFocus();				
			}
		});
		*/
		addWindowListener(windowListener);
		btnOk.addActionListener(actionListener);
		btnExit.addActionListener(actionListener);
		text.addActionListener(actionListener);
	}
	
	private WindowListener windowListener= new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	} ;
	private ActionListener actionListener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnOk || e.getSource()==text) {
//				텍스트필드에 있는 문자열을 레이블에 설정
				lblMessage.setText(text.getText());
//				텍스트필드 문자열 삭제
				text.setText("");
				text.requestFocus();	
			}
			else {
				System.exit(0);
			}
			
		}
	};
	
	

	public static void main(String[] args) {
		new EventHandlerByAnonymous();

	}//main
}//class
