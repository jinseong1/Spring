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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import awt26.service.LayoutService;

public class ChildWindow extends Frame implements LayoutService {
	//[멤버 변수]
	TextField text;
	Button btnSend;
	
	SuperWindow superWindow;
	
	public ChildWindow(SuperWindow superWindow) {		
		//1]타이틀 설정
		super("자식창");
		//2] 레이아웃 변경
		setLayout(new FlowLayout());
		//3]컴포넌트 생성		
		//4]컴포넌트 부착(생성과 동시에 부착)
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정
		//컨테이너에 올려진 컴포넌트들의 사이즈만큼 컨테이너의 크기를 설정하는 메소드:pack()
		pack();
		setVisible(true);
		
		this.superWindow = superWindow;
	}////////////////생성자
	@Override
	public void createComponent() {}//////////////
	@Override
	public void addComponent() {
		//생성과 동시에부착]
		add(text=new TextField(20));
		add(btnSend=new Button("전송"));

	}///////////////
	@Override
	public void addListener() {
		//원도우 종료 처리]
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				/*1]
				 *System.exit(0):프로그램 전체가 종료 됨 
				 *실행중인 JVM이 종료됨
				 */
				 //System.exit(0);
				//2]사용자에게 화면만 안 보일뿐 
				//  메모리(heap영역)에 존재 함
				//setVisible(false);
				//3]
				/* 메모리(자원)을 OS에게 모두 반납함 
				 * 보이지 않음 
				 * 부모에서 setVisible(true)시 OS에게 반납한 
				 * 메모리를 다시 heap영역으로
				 * 가져오게 됨.
				 * 여러개 프렘임중 특정 프레임만 
				 * 종료시키고자 할때 주로 사용. 
				 * dispose();
				 */
				dispose();
			}
		});
		btnSend.addActionListener(listener);		
		text.addActionListener(listener);
	}///////////////	
	private ActionListener listener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			superWindow.text.setText(text.getText());
			text.setText("");
			text.requestFocus();
		}
	};
	
}
