package innerclass22;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InnerMemberEvent extends JFrame {
	JButton button1,button2,button3,botton4;
	EventHandler handler = new EventHandler();//내부클래스 인스턴스화
//	외부클래스 생성자
	public InnerMemberEvent() {
		setTitle("내부 멤버 클래스로 이벤트 처리");
		setLayout(new FlowLayout());
		add(button1=new JButton("첫번째 버튼"));
		add(button2=new JButton("두번째 버튼"));
		add(button3=new JButton("세번째 버튼"));
		add(botton4=new JButton("네번째 버튼"));
		
		addWindowListener(handler);
		button1.addActionListener(handler);
		button2.addActionListener(handler);
		button3.addActionListener(handler);
		
		pack();
		setVisible(true);
	}
	
	
	
//	내부 멤버 클래스 
	class EventHandler extends WindowAdapter implements ActionListener{
		
		
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button1)
				JOptionPane.showMessageDialog(button1,"첫번째 버튼 클릭");
			else if(e.getSource()==button2)
				JOptionPane.showMessageDialog(button2,"두번째 버튼 클릭");
			else
				JOptionPane.showMessageDialog(button3,"세번째 버튼 클릭");
		}
		
	}
	public static void main(String[] args) {
		new InnerMemberEvent();
		
		
		
		

	}
}
