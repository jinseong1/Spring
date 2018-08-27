package awt26;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.service.LayoutService;

public class EmailLayout extends Frame implements LayoutService {
//	멤버변수 텍스트 필드  = 한줄만 입력 가능
	private TextField textWriter,textTitle,textEmail;
//	텍스트 에리어 - 여러줄 입력 가능
	private TextArea textArea;
//	button
	private Button btnOk,btnCancel;
	
	public EmailLayout() {
//		타이틀 설정
		super("이메일 폼");
		setBackground(Color.ORANGE);
//		레이아웃 변경
//		컴포넌트 생성
		createComponent();
//		컴포넌트부착
		addComponent();
//		리스너 부착
		addListener();
//		크기및 보이기
		setSize(450, 600);
		setVisible(true);
	}
	
	
	
	
	
	@Override
	public void createComponent() {
//		
		textWriter = new TextField();
		textEmail = new TextField();
		textTitle = new TextField();
//		텍스트 에리어 생성
		textArea = new TextArea();
//		button
		btnCancel=new Button("취소");
		btnOk=new Button("확인");
		
		
		
		
		
	}
	
	@Override
	public void addComponent() {
//		배치 북쪽
		Panel pnlNorth = new Panel(new BorderLayout());
		Panel pnlWestInPnlorth = new Panel(new GridLayout(4, 1, 0, 5));
		pnlWestInPnlorth.add(new Label("작 성 자"));
		pnlWestInPnlorth.add(new Label("이 메 일"));
		pnlWestInPnlorth.add(new Label("제     목"));
		pnlWestInPnlorth.add(new Label("내     용"));
		
		Panel pnlCenterInPnlNorth = new Panel(new GridLayout(4, 1, 0, 5)); 
		pnlCenterInPnlNorth.add(textWriter);
		pnlCenterInPnlNorth.add(textEmail);
		pnlCenterInPnlNorth.add(textTitle);
		
		
		
		pnlNorth.add("West", pnlWestInPnlorth);
		pnlNorth.add(pnlCenterInPnlNorth);
		
//		가운데 
		Panel pnlCenter = new Panel(new BorderLayout());
		pnlCenter.add(textArea);
		
		
//		패널 
		Panel pnlSouth = new Panel() {
			@Override
			public Insets getInsets() {
				return new Insets(10, 0, 5, 0);
			}
		};
		
		pnlSouth.add(btnOk);
		pnlSouth.add(btnCancel);
		
//		프레임에 부착
		add("North",pnlNorth);
		add(pnlCenter);
		add("South",pnlSouth);
		
		
		
	}
	
	@Override
	public void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	
	
	
	@Override
		public Insets getInsets() {
			return new Insets(40, 18, 18, 18);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new EmailLayout();

	}//main

}//class
