package awt26.layout;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//한글이 깨질때
//-Dfile.encoding=MS949추가
public class FlowLayoutApp {
//	멤버변수
	private Frame frame; //컨테이너
	private Button btnFirst,btnSecond,btnThid;
	private TextField text;
	
//	생성자
	public FlowLayoutApp() {
		
//		Frame컨테이너  - 독립적인 컨테이너(기본 레이아웃 -BorderLayout)
		frame = new Frame();
//		윈도우 타이틀 설정
		frame.setTitle("flowlayout연습");
//		레이아웃 변경
//		기본생성자
//		LayoutManager mgr = new FlowLayout();
//		인자생성자1
//		LayoutManager mgr = new FlowLayout(FlowLayout.CENTER);
//		인자생성자2                                                        
		LayoutManager mgr = new FlowLayout(FlowLayout.CENTER,30,50);
//		Panel panel = new  Panel();
		Panel panel = new Panel(mgr);
		panel.setBackground(Color.YELLOW);
		
		
//		frame.setLayout(mgr);
//		컨퍼런트 생성
		btnFirst = new Button("첫번째 버튼");
		btnSecond = new Button();
		btnSecond.setLabel("두번째 버튼");
		btnThid = new Button("세번째버튼");
//		컴포넌트 부착 add 메소드
		text = new TextField();
//		text.setColumns(25);
		
		
//		Flowlayout의 영향으로 사이즈 변경 불가능함
//		btnFirst.setSize(100,100);
//		text.setSize(200,100);
//		Flowlayout 사이즈 변경은 이렇게 해야함
		Dimension preferredSize = new Dimension(100, 100);
		btnFirst.setPreferredSize(preferredSize);
		text.setPreferredSize(new Dimension(100,100));
		/*
		frame.add(btnFirst);
		frame.add(btnSecond);
		frame.add(btnThid);
		frame.add(text);
		*/
//		패널에 부착
		panel.add(btnFirst);
		panel.add(btnSecond);
		panel.add(btnThid);
		panel.add(text);
//		패널을 프레임에 부착
		frame.add(panel);
		
		
		
		
//		윈도우 종료 처리하기 위한 프레임에 윈도우리스너 부착
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
//		프레임 크기 설정
		frame.setSize(600, 200);
//		프레임 보이기
		frame.setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
		new FlowLayoutApp();
		
		
		
		
		
		
		
	}//main
}//class
