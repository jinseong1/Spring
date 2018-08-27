package chatting.service;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class ChattingPanel extends JPanel{
	public ChattingPanel() {
		setBackground(new Color(76, 174, 221));
	}
	
	public ChattingPanel(LayoutManager mrg) {
		super(mrg);
		setBackground(new Color(76, 174, 221));
	}	
	
	
}
