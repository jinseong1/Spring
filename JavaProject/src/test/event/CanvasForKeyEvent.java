package test.event;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class CanvasForKeyEvent extends Canvas {
	public static final int CHARACTER_WIDTH=50;
	public static final int CHARACTER_HEIGHT=50;
	
	int xPos, yPos;
	
	@Override
	public void paint(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("src/awt26/event/terran.jpg");
		g.drawImage(img, xPos, yPos, CHARACTER_WIDTH, CHARACTER_HEIGHT, this);
	}
}
