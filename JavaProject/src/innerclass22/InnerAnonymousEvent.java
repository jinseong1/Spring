package innerclass22;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InnerAnonymousEvent extends JFrame {
	JButton button1,button2,button3,botton4;
//	외부클래스 생성자
	public InnerAnonymousEvent() {
		setTitle("내부 멤버 클래스로 이벤트 처리");
		setLayout(new FlowLayout());
		add(button1=new JButton("첫번째 버튼"));
		add(button2=new JButton("두번째 버튼"));
		add(button3=new JButton("세번째 버튼"));
		
		
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		/* 방법 1
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(button1, "첫번째 버튼");
				
			}
		});
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(button2, "두번째 버튼");
				
			}
		});
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(button3, "세번째 버튼");
				
			}
		});
		*/
		
//		방법2
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		button3.addActionListener(listener);
		
		
		
		
		
		
		pack();
		setVisible(true);
	}
	ActionListener listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button1)
				JOptionPane.showMessageDialog(button1,"첫번째버튼");
		}
	};
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button2)
				JOptionPane.showMessageDialog(button2,"첫번째버튼");
		}
		public void actionPerformed1(ActionEvent e) {
			if(e.getSource()==button3)
				JOptionPane.showMessageDialog(button3,"첫번째버튼");
		}
	
	
	
//	내부 멤버 클래스 

	public static void main(String[] args) {
		new InnerAnonymousEvent();
		
		
		
		

	}
}
