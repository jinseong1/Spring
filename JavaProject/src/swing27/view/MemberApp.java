package swing27.view;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class MemberApp {

	public static void main(String[] args) {
		MemberView view = new MemberView();
		view.setResizable(false);
		view.setSize(850,550);
		view.setVisible(true);
		
	//화면 중앙에 배치하기  
		GraphicsEnvironment ge = 
		GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd= ge.getDefaultScreenDevice();
		DisplayMode dm= gd.getDisplayMode();
		
		int screenWidth=dm.getWidth();
		int screenHeigth= dm.getHeight();
		int xPos = screenWidth/2 -view.getWidth()/2;
		int yPos = screenHeigth/2 - view.getHeight()/2;
		view.setLocation(xPos, yPos);
//		view.setVisible(true);
		
		
	}/////////////////////////////

}
