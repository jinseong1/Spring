package chatting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chatting.service.LayoutService;

public class JsTalkInfomation extends JFrame implements LayoutService {
	private JLabel lblMainImage;
	
	
	public JsTalkInfomation() {
		super("다중채팅 서버");
		//컴포넌트 생성]
		createComponent();
		//컴포넌트 부착]
		addComponent();
		//리스너 부착]
		addListener();
		setSize(300,400);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void createComponent() {
		Image image=Toolkit.getDefaultToolkit().getImage("src/chatting/텔레그램이미지.jpg");
		image=image.getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		Icon icon = new ImageIcon(image);
		lblMainImage = new JLabel(icon, JLabel.CENTER);
		lblMainImage.setPreferredSize(new Dimension(300, 400));
		lblMainImage.setOpaque(true);
	}

	@Override
	public void addComponent() {
		JPanel pnlAll = new JPanel();
		pnlAll.setBackground(Color.WHITE);
		pnlAll.add(lblMainImage);
		add(pnlAll);
	}

	@Override
	public void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
}////class
