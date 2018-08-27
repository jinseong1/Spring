package awt26.component;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import awt26.service.LayoutService;

public class ListComponentApp extends Frame implements LayoutService {
	private List listSrc,listDest;
	private Button btnRight,btnLeft,btnOk;
	private TextArea taResult;	
	
	public ListComponentApp() {
		//1]타이틀 설정
		super("ListComponent 연습");
		//2]레이아웃 변경		
		
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정	
		setSize(400, 600);
		setVisible(true);
	}////////////////////////////

	@Override
	public void createComponent() {
		
		
//		listSrc = new List();
		listSrc = new List(5, true);
		
		listSrc.add("첫번째");
		listSrc.add("두번째");
		listSrc.add("세번째");
		listSrc.add("네번째");
		listSrc.add("다섯째");
		listSrc.add("여섯째");
		listSrc.add("일곱째");
		listSrc.add("여덜째");
		
		listDest = new List();
//		버튼]
		btnLeft = new Button("<<");
		btnRight = new Button(">>");		

	}

	@Override
	public void addComponent() {
//		복쪽
		Panel pnlNorth = new Panel(new GridLayout(1, 3));
//		1행 1열
		pnlNorth.add(listSrc);
//		1행 2열
//		레이아웃 해제
		Panel pnlNull = new Panel(null);
		btnRight.setBounds(45,10,30,30);
		btnLeft.setBounds(45,40,30,30);
		pnlNull.add(btnLeft);
		pnlNull.add(btnRight);
		pnlNorth.add(pnlNull);
//		1행 3열
		pnlNorth.add(listDest);	
//		가운데
		Panel pnlCenter = new Panel(new BorderLayout()) {

			@Override
			public Insets getInsets() {
				return new Insets(10, 0, 10, 0);
			}
		
		};
		
		
		pnlCenter.add(taResult = new TextArea());
		
		
		
//		남쪽
		Panel pnlSouth = new Panel();
		pnlSouth.add(btnOk=new Button("확인"));
		
		
//		프레임 패널 부착
		add("North",pnlNorth);
		add(pnlCenter);
		add("South",pnlSouth);

	}

	@Override
	public void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		listSrc.addItemListener(handler);
		listSrc.addActionListener(handler);
		btnLeft.addActionListener(handler);
		btnRight.addActionListener(handler);
		btnOk.addActionListener(handler);
		

	}
	
	private Eventhandler handler = new Eventhandler();
	
	class Eventhandler implements ItemListener,ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==listSrc) {
//			더블클릭, 아이템선택,아이템해제 후 엔터 
//				taResult.append("ActionEvent발생\r\n");
				
				
				
			}
			else {//버튼일 경우
				if(e.getSource()==btnRight) {
					if(listSrc.getSelectedIndexes().length==0) {
						JOptionPane.showMessageDialog(btnRight,"왼쪽에서 먼저 아이템을 선택하세요");
						return;
					}
					String[] items= listSrc.getSelectedItems();
					for(String item:items) {
						listDest.add(item);
						listSrc.remove(item);
					}
				}//if
				else if(e.getSource()==btnLeft) {
						if(listDest.getSelectedIndexes().length==0) {
							JOptionPane.showMessageDialog(btnLeft,"오른쪽에서 먼저 아이템을 선택하세요");
							return;
						}
						String[] items= listDest.getSelectedItems();
						for(String item:items) {
							listSrc.add(item);
							listDest.remove(item);
						}
				}//else if
				else {
					if(listSrc.getItemCount()==0) {
						JOptionPane.showMessageDialog(btnRight,"아이템이 없어요");
						return;
					}//if
					String items[]= listSrc.getItems();
					taResult.setText("");
					for(String item:items) {
						taResult.append(item+"\r\n");						
					}
				}//else
			}
			
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			System.out.println("ItemEvent Genderated : "+e.getItem());
//			단일모드인지 다중모드인지 확인			
			System.out.println("MultipleMode : "+listSrc.isMultipleMode());
			
			if(listSrc.isMultipleMode()) {//다중모드 일때
				
				/*
				taResult.setText("[선택된 인덱스들]\r\n");
				int[] indexes = listSrc.getSelectedIndexes();
				for(int index : indexes) {
					taResult.append(index+"\r\n");}
				*/
					/*
					taResult.setText("[선택된 Items]\r\n");
					listSrc.getSelectedItems();
					String[] items=listSrc.getSelectedItems();
					for(String item:items) {
						taResult.append(item+"\r\n");
					}//for
					*/
					
//				}//for
			}//if
			else {//단일 선택 모드일때
				/*
				taResult.setText(String.format("인덱스:%d,아이템:%s", listSrc.getSelectedIndex(),listSrc.getSelectedItem()));
				*/
				
				
			}//else
		}//method
	}//inner class
	
	
	@Override
	public Insets getInsets() {
		return new Insets(40, 18, 18, 18);
	}
	
	
	public static void main(String[] args) {
		new ListComponentApp();

	}//main

}//class
