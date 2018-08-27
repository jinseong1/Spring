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

import javax.swing.JOptionPane;

import awt26.service.LayoutService;

public class SuperWindow extends Frame implements LayoutService {
	//[멤버 변수]
	TextField text;
	Button btnSend,btnChildCreate;
	
	
	public SuperWindow() {
		//1]타이틀 설정
		super("부모창");
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
	}////////////////생성자
	@Override
	public void createComponent() {}//////////////
	@Override
	public void addComponent() {
		//생성과 동시에부착]
		add(text=new TextField(20));
		add(btnSend=new Button("전송"));
		add(btnChildCreate=new Button("자식창 띄우기"));		

	}///////////////
	@Override
	public void addListener() {
		//원도우 종료 처리]
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//버튼과 텍스트 필드에 액션 리스너 부착]
		btnSend.addActionListener(listener);
		btnChildCreate.addActionListener(listener);
		text.addActionListener(listener);
		
	}///////////////
	private ChildWindow childWindow;
	//이벤트 핸들러]
	private ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnChildCreate) {//자식창 띄우기]
				if(childWindow == null) {//최초 생성
					childWindow=new ChildWindow(SuperWindow.this);
					return;
				}
				if(!childWindow.isVisible())//안보일때
					childWindow.setVisible(true);
			}
			else {//전송버튼 클릭 혹은 텍스트 필드에서 엔터
				if(childWindow !=null && childWindow.isVisible()) {
					childWindow.text.setText(text.getText());
					
					text.setText("");
					text.requestFocus();
					return;
				}
				JOptionPane.showMessageDialog(SuperWindow.this,"자식창을 먼저 띄우세요");
			}
			
		}
	};//////////////////////////
	
	
	public static void main(String[] args) {
		new SuperWindow();
	}///////////////

}
