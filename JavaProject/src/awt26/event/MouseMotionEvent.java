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
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.service.LayoutService;

public class MouseMotionEvent extends Frame implements LayoutService {
	public static final int MINTHICKNESS = 5;
	public static final int MAXTHICKNESS = 40;
	private Button[] buttons = new Button[7];
	private String[] labels = {"RED","GREEN","BLUE","THIN","THICK","ERASER","CLEAR"};
	private Canvas canvas;
	private Color color = Color.BLACK;
	private int width=MINTHICKNESS,heigth=MINTHICKNESS;
	private int xPos=-40, yPos=-40;
	private boolean isClear;
	
	
	
		
	
	public MouseMotionEvent() {
	      // 1] 타이틀 설정
	      setTitle("Mouse Event 연습");
	      setBackground(Color.BLACK);
	      // 2] 레아이웃 변경
	      // 3] 컴포넌트 생성
	      createComponent();
	      // 4] 컴포넌트 부착
	      addComponent();
	      // 5] 리스너 부착
	      addListener();
	      // 6] 크기 및 보이기
//	      setResizable(false);
//	      pack();
	      setSize(600, 550);
	      setVisible(true);	
	}

	@Override
	public void createComponent() {
		for(int i=0;i<buttons.length;i++) {
			buttons[i]= new Button(labels[i]);			
		}//for
		canvas = new Canvas() {
			@Override
			public void paint(Graphics g) {
				if(!isClear) {
					g.setColor(color);
					g.fillOval(xPos, yPos, width, heigth);
					
				}
				else {
					g.clearRect(0, 0, getWidth(), getHeight());
					isClear = false;
				}
			}
//			배경색이 지워지지 않도록 오버라이딩
			@Override
			public void update(Graphics g) {
				paint(g);
			}
		};
		canvas.setBackground(Color.WHITE);
		
		
	}//createComponent

	@Override
	public void addComponent() {
		Panel pnlWest = new Panel(new GridLayout(7, 1,0,5)) {
			@Override
			public Insets getInsets() {
				return new Insets(0, 0, 0, 10);
			}
		};
		for(int i=0;i<buttons.length;i++) {
			pnlWest.add(buttons[i]);			
		}//for
//		Canvas 부착
		
		Panel pnlcenter = new Panel(new BorderLayout());
		pnlcenter.add(canvas);
		
		
//		프레임에 패널 부착
		add("West",pnlWest);
		add(canvas);
	}

	@Override
	public void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});//Closing
		for(int i=0;i<buttons.length;i++) {
			buttons[i].addActionListener(Handler);
		}//for
		canvas.addMouseMotionListener(Handler);
	}//addListener
	private EventHandler Handler = new EventHandler();
	class EventHandler implements MouseMotionListener,ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == buttons[0]) {//red
				color = Color.RED;
			}
			else if(source == buttons[1]) {//green
				color = Color.GREEN;
			}
			else if(source == buttons[2]) {//blue
				color = Color.BLUE;
			}
			else if(source == buttons[3]) {//thin
				if(width > MINTHICKNESS) {
					width-=5;
					heigth-=5;
				}//if
			}
			else if(source == buttons[4]) {//thick
				if(width < MAXTHICKNESS) {
					width+=5;
					heigth+=5;
				}//if
			}
			else if(source == buttons[5]) {//eraser(지우개)
				color = canvas.getBackground();
			}
			else { 
				isClear = true;
				canvas.repaint();
			}//else
//			canvas.repaint();
			
		}
//		클릭 후 드레그시 호출됨
		@Override
		public void mouseDragged(MouseEvent e) {
//			System.out.println("mouseDragged");
			xPos = e.getX();
			yPos = e.getY();
			setTitle(String.format("X : %d y : %d", xPos,yPos));
			canvas.repaint();
			
			
			
			
			
		}
		
		
		
		
		
		
//		마우스가 움직일때 호출 됨
		@Override
		public void mouseMoved(MouseEvent e) {
//			System.out.println("mouseMoved");
			
		}
	}
	
	
	
	
	@Override
	public Insets getInsets() {
		return new Insets(40, 18, 18, 18);
	}//getInsets
	public static void main(String[] args) {
		new MouseMotionEvent();

	}

}
