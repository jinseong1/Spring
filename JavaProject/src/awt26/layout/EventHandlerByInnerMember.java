package awt26.layout;

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

import awt26.service.LayoutService;
//내부클래스로 이벤트 핸들러구현 하나의 이벤트에 대해서 이벤트 소스가 여러개인 경우 유리[계산기]
public class EventHandlerByInnerMember extends Frame implements LayoutService {
	
	private TextField text;
	private Button btnOk,btnExit;
	private Label lblMessage;
	
	public EventHandlerByInnerMember() {
		super("내부 멤버클래스로 이벤트핸들러 구현");

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
	public void createComponent() {}
	
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
		addWindowListener(handler);
		btnOk.addActionListener(handler);
		btnExit.addActionListener(handler);
//		텍스트필드에 액션리스너 부착
		text.addActionListener(handler);
	}
	
	
	private EventHandler handler = new EventHandler();
	
//	내부멤버클래스
	class EventHandler extends WindowAdapter implements ActionListener{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
//		윈도우,액션 이벤트 처리 가능함
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
	}
	
	
	
	
	
	public static void main(String[] args) {
		new EventHandlerByInnerMember();

	}


}
