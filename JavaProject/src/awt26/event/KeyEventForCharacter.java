package awt26.event;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.service.LayoutService;

public class KeyEventForCharacter extends Frame implements LayoutService {
	private Canvas canvas;
	public static final int MOVE_DISTANCE = 50;
	public KeyEventForCharacter() {
	      // 1] 타이틀 설정
	      setTitle("KeyEvent 연습");
	      // 2] 레아이웃 변경
	      // 3] 컴포넌트 생성
	      createComponent();
	      // 4] 컴포넌트 부착
	      addComponent();
	      // 5] 리스너 부착
	      addListener();
	      // 6] 크기 및 보이기
//	      setResizable(false);
	      setSize(416, 538);
	      setVisible(true);
	      
	      
	}

	@Override
	public void createComponent() {
		canvas = new CanvasForKeyEvent();
//		캔버스에 포커스 가도록 설정
		canvas.setFocusable(true);

	}

	@Override
	public void addComponent() {
		
		add(canvas);
	}

	@Override
	public void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
//		캔버스에 키리스너 부착
		canvas.addKeyListener(handler);
		
	}
	
	private KeyListener handler = new KeyListener() {
		
		
		@Override
		public void keyTyped(KeyEvent e) {
//			System.out.println("keyTyped");
			
		}
//		키를 눌렀다가 땟을때
		@Override
		public void keyReleased(KeyEvent e) {
//			System.out.println("keyReleased");
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println("keyPressed");
//			클릭한 키보드 자판의 아스키코드값
			int keyCode = e.getKeyCode();
//			클릭한 키보드 자판 문자
			char keyChar = e.getKeyChar();
			setTitle(String.format("코드값 : %d, 문자 : %c", keyCode,keyChar));
			
			CanvasForKeyEvent canvasChar = (CanvasForKeyEvent)canvas;
			
			if(keyCode==KeyEvent.VK_UP) {
				if(canvasChar.yPos>0) {
				canvasChar.yPos-=MOVE_DISTANCE;
				}
			}
			else if(keyCode==KeyEvent.VK_DOWN) {
//				
				if(canvasChar.yPos<canvas.getHeight()-MOVE_DISTANCE) {
				canvasChar.yPos+=MOVE_DISTANCE;
				}
			}
			else if(keyCode==KeyEvent.VK_LEFT) {
				if(canvasChar.xPos>0) {
				canvasChar.xPos-=MOVE_DISTANCE;
				}
			}
			else if(keyCode==KeyEvent.VK_RIGHT) {
//				
				if(canvasChar.xPos<canvas.getWidth()-MOVE_DISTANCE) {
				canvasChar.xPos+=MOVE_DISTANCE;
				}
			}
			canvasChar.repaint();
		}
	};
	

	public static void main(String[] args) {
		new KeyEventForCharacter();

	}

}
