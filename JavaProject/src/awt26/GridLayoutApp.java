package awt26;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.service.LayoutService;

public class GridLayoutApp extends Frame implements LayoutService {
	
	private Button buttons[] = new Button[6];
	private String[] lables= {"가","나","다","라","마","바"};
	
//	
	public GridLayoutApp() {
//		타이틀 이름
//		방법1
//		super("GridLayout 연습");
//		방법2
		setTitle("GridLayout 연습");
//		GridBagLayout layout = new GridLayout();
//		GridLayout layout = new GridLayout(3,3);
		
		GridLayout layout = new GridLayout(2,3,30,30);

		setLayout(layout);
//		컴포넌트 생성
		
		createComponent();
		addComponent();
		
//		리스너부착
		addListener();
	}
	
	
	@Override
	public void createComponent() {
		for(int i=0;i<buttons.length;i++) {
			buttons[i]=new Button(lables[i]);
		}
		buttons[0].setSize(100,100);
		buttons[1].setPreferredSize(new Dimension(100, 100));
	}
	
	@Override
	public void addComponent() {
//		버튼 컴포넌트 부착
		for(int i=0;i<buttons.length;i++) {
			add(buttons[i]);
		}
	}
	
	@Override
	public void addListener(){		
		addWindowListener(new WindowAdapter() {
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
		GridLayoutApp gridLayout = new GridLayoutApp();
		gridLayout.setSize(400,400);
		gridLayout.setVisible(true);
		
		
		
		
		
	}//main
}//class
