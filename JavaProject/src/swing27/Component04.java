package swing27;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import awt26.service.LayoutService;

public class Component04 extends JFrame implements LayoutService {
	//[멤버변수]
	JList listLeft,listRight;
	JButton btnLeft,btnRight,btnOk;
	JTextArea taResult;
	
	Vector vecLeft = new Vector();
	Vector vecRight = new Vector();
	public Component04() {
		//1]타이틀 설정
		super("Swing컴포넌트 연습04");			
		//2]레이아웃 변경	
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정	
		setSize(500,650);
		setVisible(true);
	}////////////////
	@Override
	public void createComponent() {
		//리스트]
		listLeft = new JList();
		vecLeft.add("지리산");
		vecLeft.add("덕유산");
		vecLeft.add("소백산");
		vecLeft.add("태백산");
		vecLeft.add("비슬산");
		vecLeft.add("치악산");
		vecLeft.add("설악산");
		vecLeft.add("한라산");
		vecLeft.add("성인봉");
		vecLeft.add("대둔산");
		vecLeft.add("북한산");
		//리스트와 컬렉션 연결:setListData()]
		listLeft.setListData(vecLeft);
		//단일 선택시:디폴트가 다중 선택(ctrl키와 함께 선택)
		//listLeft.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listRight = new JList();
		//버튼]
		btnLeft = new JButton("<<");
		btnRight= new JButton(">>");
		btnOk= new JButton("확인");
		//텍스트 에리어
		taResult = new JTextArea();
	}//////////////

	@Override
	public void addComponent() {
		JPanel pnlNorth = new MyPanel(new GridLayout(1, 3));
		pnlNorth.setBorder(new TitledBorder("아이템 목록"));
		//북쪽 1열]
		pnlNorth.add(new JScrollPane(listLeft));
		//북쪽 2열]
		JPanel pnlButton = new MyPanel(null);
		btnRight.setBounds(50, 30, 50, 35);
		pnlButton.add(btnRight);
		btnLeft.setBounds(50, 65, 50, 35);
		pnlButton.add(btnLeft);
		pnlNorth.add(pnlButton);
		//북쪽 3열]
		pnlNorth.add(new JScrollPane(listRight));
		
		 JPanel pnlCenter = new MyPanel(new BorderLayout());
		 pnlCenter.setBorder(new TitledBorder("결과창"));
		 pnlCenter.add(new JScrollPane(taResult));
		
		 JPanel pnlSouth = new MyPanel();
		 pnlSouth.add(btnOk);
		
		//프레임에 패널 부착]
		add("North",pnlNorth);
		add(pnlCenter);
		add("South",pnlSouth);
	}///////////////////////

	@Override
	public void addListener() {
		//종료]
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//버튼에 액션 리스너 부착]
		btnLeft.addActionListener(handler);
		btnRight.addActionListener(handler);
		btnOk.addActionListener(handler);
		//JList에는 ItemEvent가 아니라 ListSelectionEvent가 발생한다
		listLeft.addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {				
				//System.out.println("ListSelectionEvent발생");
				//System.out.println(e.getValueIsAdjusting());
				if(e.getValueIsAdjusting()) {					
					System.out.println("방법1.선택한 아이템: "+listLeft.getSelectedValue());
					System.out.println("방법2.선택한 아이템: "+vecLeft.get(listLeft.getSelectedIndex()));
				}
			}
		});
	}//////////////
	ActionListener handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();
			if(source== btnLeft) {
				if(listRight.isSelectionEmpty()) {				
					JOptionPane.showMessageDialog(btnRight,"오른쪽에서 먼저 아이템 선택");
					return;
				}
				//아이템 선택시]
				//오른쪽으로 아이템 이동
				List values=listRight.getSelectedValuesList();					
				for(Object value:values) {
					//오른쪽용 벡터에 아이템 추가
					vecLeft.add(value);
					//왼쪽용 벡터에서 아이템 제거
					vecRight.remove(value);
				}
				//벡터와 리스트 연결]
				listLeft.setListData(vecLeft);
				listRight.setListData(vecRight);
				
			}
			else if(source == btnRight) {
				//if(listLeft.isSelectionEmpty()) {
				if(listLeft.getSelectedIndices().length==0) {
					JOptionPane.showMessageDialog(btnRight,"왼쪽에서 먼저 아이템 선택");
					return;
				}
				//아이템 선택시]
				//오른쪽으로 아이템 이동
				List values=listLeft.getSelectedValuesList();				
				//Object[] values=listLeft.getSelectedValues();//deprecated
				for(Object value:values) {
					//오른쪽용 벡터에 아이템 추가
					vecRight.add(value);
					//왼쪽용 벡터에서 아이템 제거
					vecLeft.remove(value);
				}
				//벡터와 리스트 연결
				listLeft.setListData(vecLeft);
				listRight.setListData(vecRight);
			}
			else {
				if(vecLeft.size()==0) {
					JOptionPane.showMessageDialog(btnRight,"표시할 아이템이 없어요");
					return;
				}
				taResult.setText("");
				for(Object item:vecLeft) {
					taResult.append(item.toString()+"\r\n");
				}/////////////////
				
				
			}
		}//////////////actionPerformed
	};////////////////////ActionListener
	
	@Override
	public Insets getInsets() {
		
		return new Insets(40, 18, 18, 18);
	}
	public static void main(String[] args) {
		new Component04();
	}////////////

}
