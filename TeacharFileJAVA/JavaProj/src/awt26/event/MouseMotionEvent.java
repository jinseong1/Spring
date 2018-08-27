package awt26.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.service.LayoutService;

public class MouseMotionEvent extends Frame implements LayoutService {
	//상수]
	public static final int MINTHICKNESS =5;
	public static final int MAXTHICKNESS =40;
	//[멤버변수]
	private Button[] buttons = new Button[7];
	private String[] labels = {"RED","GREEN","BLUE","THIN","THICK","ERASER","CLEAR"};
	private Canvas canvas;
	//캔바스와 관련된 변수들]
	private Color color = Color.BLACK;
	private int width=MINTHICKNESS,height=MINTHICKNESS;
	private int xpos=-40,ypos=-40;
	private boolean isClear;
	
	
	public MouseMotionEvent() {
		//1]타이틀 설정
		super("마우스모션(MouseEvent) 연습");
		setBackground(Color.BLACK);
		//2]레이아웃 변경		
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정	
		setSize(600, 550);
		setVisible(true);
	}////////////////////////
	@Override
	public void createComponent() {
		//버튼 생성]
		for(int i=0; i< buttons.length;i++)
			buttons[i] = new Button(labels[i]);
		//캔바스 생성]
		canvas = new Canvas() {
			
			@Override
			public void paint(Graphics g) {
				if(!isClear) {
					g.setColor(color);
					g.fillOval(xpos,ypos, width,height);
				}
				else {
					g.clearRect(0,0,getWidth(),getHeight());
					isClear=false;
				}
			}/////////////////////
			//배경색으로 지우지 못하도록 오버라이딩
			@Override
			public void update(Graphics g) {
				paint(g);
			}
			
		};
		canvas.setBackground(Color.YELLOW);
	}///////////////////

	@Override
	public void addComponent() {
		//버튼 부착]
		Panel pnlWest = new Panel(new GridLayout(7, 1,0,5));
		for(int i=0; i< buttons.length;i++)
			pnlWest.add(buttons[i]);
		//캔바스 부착]
		Panel pnlCenter = new Panel(new BorderLayout()) {
			@Override
			public Insets getInsets() {				
				return new Insets(0, 10, 0, 0);
			}
		};
		pnlCenter.add(canvas);
		//프레임에 패널 부착]
		add("West",pnlWest);
		add(pnlCenter);

	}/////////////////////

	@Override
	public void addListener() {
		//프레임에 윈도우 리스너 부착-종료처리]
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});////////////////////////////
		//버튼에 액션 리스너 부착]
		for(int i=0; i< buttons.length;i++)
			buttons[i].addActionListener(handler);
		//캔바스에 마우스모션리스너부착]
		canvas.addMouseMotionListener(handler);
	}/////////////////
	private EventHandler handler = new EventHandler();
	class EventHandler extends MouseMotionAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();
			if(source == buttons[0]) {//RED
				color = Color.RED;
			}
			else if(source == buttons[1]) {//GREEN
				color = Color.GREEN;
			}
			else if(source == buttons[2]) {//BLUE
				color = Color.BLUE;
			}
			else if(source == buttons[3]) {//THIN
				if(width > MINTHICKNESS) {
					width-=5;
					height-=5;
				}
			}
			else if(source == buttons[4]) {//THICK
				if(width < MAXTHICKNESS)
				{
					width+=5;
					height+=5;
				}
			}
			else if(source == buttons[5]) {//ERASER
				color = canvas.getBackground();
			}
			else {//CLEAR
				isClear=true;
				canvas.repaint();
			}////else
			
			
		}////////actionPerformed
		//마우스이벤트와 관련된 콜백 메소드들]
		//영역안에서 클릭후 드래그시
		@Override
		public void mouseDragged(MouseEvent e) {
			//System.out.println("mouseDragged");			
			//드래그한 지점의 좌표를 캔바스의
			//X,Y좌표로 설정
			xpos=e.getX();
			ypos=e.getY();
			setTitle(String.format("X좌표:%d,Y좌표:%d", xpos,ypos));
			canvas.repaint();
		}/////////////////////////
		//영역안에서 마우스 움직일때마다
		@Override
		public void mouseMoved(MouseEvent e) {
			//System.out.println("mouseMoved");
		}/////////////////////////
		
		
		
	}//////////////EventHandler
	
	@Override
	public Insets getInsets() {		
		return new Insets(40, 18, 18, 18);
	}
	public static void main(String[] args) {
		new MouseMotionEvent();
	}//////////////////////////

}
