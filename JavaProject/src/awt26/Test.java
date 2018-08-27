package awt26;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.service.LayoutService;

public class Test extends Frame implements LayoutService{
	TextArea text1;
	Button btnOk,btnC;
	

	public Test() {
		super("테스트 화면");
		createComponent();
		addComponent();
		addListener();
		setSize(400, 600);
		setVisible(true);
		
		
	}
	
	
	@Override
	public void createComponent() {
		
		
		
		
	}
	
	
	
	
	
	@Override
	public void addComponent() {
		
		
	}
	
	
	
	
	
	@Override
	public void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
	}
	
	
	
	public static void main(String[] args) {
		new Test();
	}//main





}//class
