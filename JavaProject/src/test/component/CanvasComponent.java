package test.component;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import awt26.component.CustomCanvas;
import awt26.service.LayoutService;

public class CanvasComponent extends Frame implements LayoutService {
//	멤버변수
	private Canvas canvas;
	private Button btnFont, btnColor;
//	캔바스의 가로폭 세로폭 저장 변수
	private int width, height;
	
	private Color color = Color.BLACK;
	private Font font = new Font("굴림체", Font.BOLD, 20);
	
	public CanvasComponent() {
		super("Canvas Component Test");
		createComponent();
		addComponent();
		addListener();
		setSize(550, 400);
		setVisible(true);
		System.out.println("After setSize : width of canvas : "+canvas.getWidth());
		width = canvas.getWidth();
		height = canvas.getHeight();

	}
	
	
	public static void main(String[] args) {
		new CanvasComponent();

	}

	@Override
	public void createComponent() {
		canvas = new CustomCanvas();
		canvas.setBackground(Color.YELLOW);
		System.out.println("createComponent : width of Canvas : "+canvas.getWidth());
		
	}

	@Override
	public void addComponent() {
		Panel pnlCenter = new Panel(new BorderLayout());
		pnlCenter.add(canvas);
		Panel pnlSouth = new Panel() {
			@Override
			public Insets getInsets() {
				return new Insets(10, 0, 10, 0);
			}
		};
		pnlSouth.add(btnColor= new Button("색상 변경"));
		pnlSouth.add(btnFont=new Button("글꼴 변경"));
		
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
		btnColor.addActionListener(new ActionListener() {
			boolean toggle;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!toggle) ((CustomCanvas)canvas).setColor(Color.RED);
				else ((CustomCanvas)canvas).setColor(Color.BLACK);
				toggle  = !toggle;
				canvas.repaint();
				
			}
		});
		btnFont.addActionListener(new ActionListener() {
			boolean toggle;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!toggle) ((CustomCanvas)canvas).setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 30));
				else ((CustomCanvas)canvas).setFont(new Font("굴림체", Font.PLAIN, 30));
				toggle = !toggle;
				canvas.repaint();			
			}
		});
	}
	@Override
	public Insets getInsets() {
		return new Insets(40, 18,18,18);
	}

}
