package awt26.component;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.service.LayoutService;

public class ScrollbarCompofernent extends Frame implements LayoutService {
//	멤버변수
	private Scrollbar sbRed,sbGreen,sbBlue;
	private Canvas canvas;
	
	
	
//	기본생성자
	public ScrollbarCompofernent() {
	      // 1] 타이틀 설정
	      setTitle("Scrollbar 컴포넌트 및 AdjistmentEvent 연습");
	      // 2] 레아이웃 변경
	      // 3] 컴포넌트 생성
	      createComponent();
	      // 4] 컴포넌트 부착
	      addComponent();
	      // 5] 리스너 부착
	      addListener();
	      // 6] 크기 및 보이기
	      setSize(600, 450);
	      setVisible(true);
	      
	      
	}

	@Override
	public void createComponent() {
		canvas = new Canvas();
		sbRed = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
//		양쪽 화살표를 마우스 클릭시 시동 거리 단위
		sbRed.setUnitIncrement(10);
		
		
		
		
		sbGreen = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
		sbBlue = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
//		캔버스의 배경색 지정
		canvas.setBackground(Color.BLACK);

	}

	@Override
	public void addComponent() {
		Panel pnlCenter = new Panel(new BorderLayout());
		pnlCenter.add(canvas);
		
		
		Panel pnlSouth = new Panel(new BorderLayout()) {
			@Override
				public Insets getInsets() {
					return new Insets(10, 0, 10, 0);
				}
		};
		
		
		Panel pnlWestInSouth = new Panel(new GridLayout(3, 1,0,5));
		pnlWestInSouth.add(new Label("빨강"));
		pnlWestInSouth.add(new Label("녹색"));
		pnlWestInSouth.add(new Label("파랑"));
		
		pnlSouth.add("West", pnlWestInSouth);
		
		Panel pnlCenterInSouth = new Panel(new GridLayout(3, 1,0,5));
		pnlCenterInSouth.add(sbRed);
		pnlCenterInSouth.add(sbGreen);
		pnlCenterInSouth.add(sbBlue);
		pnlSouth.add(pnlCenterInSouth);
		
//		프레임에 패널 부착
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
//		스크롤바에 리스너 부착
		sbRed.addAdjustmentListener(handler);
		sbGreen.addAdjustmentListener(handler);
		sbBlue.addAdjustmentListener(handler);
	}
	private AdjustmentListener handler = new AdjustmentListener() {
		
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			setTitle(String.format("R:%d, G:%d, B:%d", sbRed.getValue(),sbGreen.getValue(),sbBlue.getValue()));
			canvas.setBackground(new Color(sbRed.getValue(), sbGreen.getValue(), sbBlue.getValue()));
			
		}
	};
	
	
	@Override
		public Insets getInsets() {
			
			return new Insets(45, 25, 25, 25);
		}
	
	public static void main(String[] args) {
		new ScrollbarCompofernent();

	}

}
