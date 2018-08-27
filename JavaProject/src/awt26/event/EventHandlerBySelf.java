package awt26.event;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import awt26.service.LayoutService;

public class EventHandlerBySelf extends Frame implements LayoutService,WindowListener,ActionListener {
	
	private TextField text;
	private Button btnOk,btnExit;
	private Label lblMessage;
	
	
//	�깮�꽦�옄
	public EventHandlerBySelf() {
//		���씠�� �꽕�젙
		super("자기자신");
//		�젅�씠�븘�썐 蹂�寃�
		setLayout(new FlowLayout());
//		而댄띁�윴�듃 �깮�꽦
//		而댄띁�윴�듃 遺�李�
		addComponent();
//		由ъ뒪�꼫 遺�李�
		addListener();
//		�겕湲� 諛� 蹂댁씠湲� �꽕�젙
//		而⑦뀒�씠�꼫�뿉 �삱�젮吏� 而댄룷�꼳�듃�뱾�쓽 �궗�씠利덈쭔�겮 而⑦뀒�씠�꼫�쓽 �겕湲곕�� �꽕�젙�븯�뒗 硫붿냼�뱶:pack()
		pack();
		setVisible(true);
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
//		활성화	
		System.out.println("windowActivated(WindowEvent e)");
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
//		비활성화
		System.out.println("windowDeactivated(WindowEvent e)");
	}
	
	
	@Override
	public void windowIconified(WindowEvent e) {
//		아이콘화되었을때 즉 시스템 메뉴 중 최소화 버튼 클릭시 시스템 트레이버에 아이콘으로 존재할때
		System.out.println("windowIconified(WindowEvent e)");
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
//		아이콘화되었다가 다시 윈도우가 보일때, 즉 트레이바에 아이콘 클릭시
		System.out.println("windowDeiconified(WindowEvent e)");		
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
//		프로그램 처음 실행 시 한번만 호출됨 아주 유용하니 잘 알아둬야함
		System.out.println("windowOpened(WindowEvent e)");
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing(WindowEvent e)");		
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {
//		개발자가 dispose() 메소드 호출후 윈도우가 닫혔을때
		System.out.println("windowClosed(WindowEvent e)");
	}
	
	@Override
	public void createComponent() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addComponent() {
//		�깮�꽦怨� �룞�떆�뿉 遺�李�
		add(text=new TextField(20));
		add(btnOk=new Button("확인"));
		add(btnExit=new Button("종료"));
		lblMessage = new Label("안녕하세요");
		lblMessage.setBackground(new Color(255,255,0));
		lblMessage.setPreferredSize(new Dimension(300, 30));
		add(lblMessage);
		
	}
	
	@Override
	public void addListener() {
		addWindowListener(this);
//		버튼에 액션리스터 부착
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);
		text.addActionListener(this);
		
	}

	
	public static void main(String[] args) {
		new EventHandlerBySelf();
		
		
		
	}//main
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("Button Close");
		/*
		String command = e.getActionCommand();
		if("확인".equals(command))
			lblMessage.setText("확인 버튼 클릭 !!!");
		else if("종료".equals(command))
			lblMessage.setText("종료 버튼 클릭 !!!");
		else 
			lblMessage.setText("텍스트 필드에서 발생 !!!"+text.getText());
		*/
		/*
		Object source= e.getSource();
		if(source instanceof Button)
			lblMessage.setText("버튼클릭");
		else
			lblMessage.setText("텍스트 필드에서 발생 !!!"+text.getText());
		*/
//		가장 많이 사용하는 방법 주소 비교
		Object source= e.getSource();
		if(source == btnOk)
			lblMessage.setText("확인버튼 클릭");
		else if(source == btnExit) {
			lblMessage.setText("종료버튼 클릭");
			dispose();
		}
		else
			lblMessage.setText("텍스트 필드에서 발생 !!!"+text.getText());
		
		
		
		
		
		
	}


}//class
