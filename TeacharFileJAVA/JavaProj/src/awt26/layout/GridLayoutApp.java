package awt26.layout;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.service.LayoutService;

public class GridLayoutApp extends Frame implements LayoutService {
	//[멤버 변수]
	private Button buttons[] = new Button[6];
	private String[] labels  = {"가","나","다","라","마","바"};
	
	
	public GridLayoutApp() {
		//1]원도우 타이틀 설정
		//super("GridLayout연습");
		setTitle("GridLayout연습");
		//2]레이아웃 변경:BorderLayout에서 GridLayout으로 변경
		//기본 생성자 사용]-행은 무조건 1행 열은 컴포넌트 수만큼
		//GridLayout layout = new GridLayout();	
		//layout.setRows(2);
		//layout.setColumns(3);
		//인자 생성자 사용 1]GridLayout(int rows,int  cols)
		//GridLayout layout = new GridLayout(3,2);
		//인자 생성자 2]GridLayout(rows, cols, hgap, vgap)
		/*
		 * 역시 수평 및 수직 여백은 컴포넌트와 컴포넌트 사이에만 적용됨
		 * 컴포넌트와 컨테이너와의 바깥 여백을 설정하기위해서
		 * getInsets()오버라이딩
		 * 
		 */
		GridLayout layout = new GridLayout(2,3,30,30);
		setLayout(layout);
		//3]컴포넌트 생성		
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
	}/////////////////////	
	@Override
	public void createComponent() {
		//버튼 컴포넌트 생성]
		for(int i=0;i < buttons.length;i++)
			buttons[i] = new Button(labels[i]);
		//아래 두 메소드는 레이아웃의 영향으로
		//적용이 안됨.
		//왜냐하면 그리드 레이아웃는 특징이 컴포넌트 크기가
		//동일함.
		buttons[0].setSize(100,100);
		buttons[1].setPreferredSize(new Dimension(100, 100));
	}
	@Override
	public void addComponent() {
		//버튼 컴포넌트 부착]
		for(int i=0;i < buttons.length;i++) add(buttons[i]);
	}
	@Override
	public void addListener() {
		//원도우 종료 처리를 위한 프레임에 윈도우 리스너 부착
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});		
	}////////////////////////////////////////
	//프레임과 버튼과의 여백주기]
	@Override
	public Insets getInsets() {	
		return new Insets(40, 18, 18, 18);
	}////////////////////////////////////////
	
	public static void main(String[] args) {
		GridLayoutApp gridLayout=new GridLayoutApp();
		//메인에서 크기및 보이기 설정]
		gridLayout.setSize(400,400);
		gridLayout.setVisible(true);
	}//////////main


}/////////////class
