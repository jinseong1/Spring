package awt26.event;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class CanvasForKeyEvent extends Canvas {
	
	public static final int CHACECTER_WIDTH=50;
	public static final int CHACECTER_HEIGTH=50;
	
	
	int xPos,yPos;
	
	@Override
	public void paint(Graphics g) {
//		이미지 메모리 로딩
		Image img = Toolkit.getDefaultToolkit().getImage("src/awt26/event/terran.jpg");
//		이미지 표시
		g.drawImage(img, xPos, yPos,CHACECTER_WIDTH,CHACECTER_HEIGTH,this);
	}




	
	
	
}
