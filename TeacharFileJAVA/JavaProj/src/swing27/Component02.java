package swing27;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import awt26.service.LayoutService;
/*
AWT에서는 e.getItem()(Checkbox나 Choice인 경우)나
List인스턴스변수.getSelectedItem()으로
텍스트를 얻어 올 수 있다

그러나 Swing에서는
[ItemEvent발생시 텍스트 얻기]

-JCheckBox : SELECTED와 DESELECTED를 구분해줘야 함
       JCheckBox cb=(JCheckBox)e.getItem();
       cb.getText()로 얻어 옴 
       
       혹은 ((JCheckBox)e.getItem()).getText()
     
-JRadioButton :
    JRadioButton cb=(JRadioButton)e.getItem();
        cb.getText()로 얻어 옴 
      SELECTED만 따져주면 됨
      AWT에서는 제공 안함(Checkbox를 이용해서 생성)
      
-JComboBox :AWT의 Choice컴포넌트와 동일
     컴포넌트 인스턴스변수명.getSelectedItem()
     혹은 e.getItem()
     SELECTED만 따져주면 됨
     

*/
public class Component02 extends JFrame implements LayoutService {
	//[멤버변수]
	JCheckBox cbEnt,cbEco,cbPol,cbSpo;
	JRadioButton rbMan,rbWoman,rbTrans;
	JComboBox cBox;
	JTextArea taResult;
	JButton btnOk;
	
	public Component02() {
		//1]타이틀 설정
		super("Swing컴포넌트 연습02");		
		//2]레이아웃 변경	
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정	
		setSize(400, 550);
		setVisible(true);
	}///////////////////////
	@Override
	public void createComponent() {
		//체크박스]
		cbEco = new JCheckBox("경제",true);
		cbEnt = new JCheckBox("연예");
		cbPol = new JCheckBox("정치");
		cbSpo = new JCheckBox("스포츠");
		//라디오 버튼]
		rbMan = new JRadioButton("남자");
		rbWoman=new JRadioButton("여자",true);
		rbTrans= new JRadioButton("트랜스젠더");
		/*
		 * ButtonGroup클래스로 JRadioButton을 
		 * 그룹핑해줘야
		 * 진정한 라디오버튼이 된다.
		 * 즉 여러개중 한개만 선택 가능
		 */
		ButtonGroup group = new ButtonGroup();
		group.add(rbMan);
		group.add(rbTrans);
		group.add(rbWoman);
		//콤보박스]
		//addItem()메소드로 아이템 추가
		/*
		cBox = new JComboBox();		
		cBox.addItem(">>학력선택<<");
		cBox.addItem("초등학교");
		cBox.addItem("중학교");
		cBox.addItem("고등학교");
		cBox.addItem("대학교");*/
		//컬렉션 사용해서 아이템 추가]
		Vector items = new Vector();
		items.add(">>학력선택<<");
		items.add("초등학교");
		items.add("중학교");
		items.add("고등학교");
		items.add("대학교");		
		cBox = new JComboBox(items);
		
	}////////////////////
	@Override
	public void addComponent() {
		JPanel pnlNorth = new JPanel(new GridLayout(3,1));
		JPanel pnlInter = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlInter.setBorder(new TitledBorder("당신의 관심사항은?"));
		pnlInter.add(cbEco);
		pnlInter.add(cbEnt);
		pnlInter.add(cbPol);
		pnlInter.add(cbSpo);
		pnlNorth.add(pnlInter);
		
		JPanel pnlGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlGender.setBorder(new TitledBorder("당신의 성별은?"));
		pnlGender.add(rbMan);		
		pnlGender.add(rbWoman);
		pnlGender.add(rbTrans);
		pnlNorth.add(pnlGender);
		
		JPanel pnlGrade = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlGrade.setBorder(new TitledBorder("당신의 학력은?"));	
		pnlGrade.add(cBox);
		pnlNorth.add(pnlGrade);
		
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.setBorder(new TitledBorder("결과창"));
		/*
	    * Swing에서는 해당 컴포넌트에 내용을
	    * 많이 
	    * 입력한 경우 자동으로 스크롤바가 생기지 않음
	    * 그래서 해당 컴포넌트에 JScrollPane를 
	    * 이용해서
	    * 스크롤바를 붙여줘야 함.
	    * 
	    */ 
		pnlCenter.add(new JScrollPane(taResult=new JTextArea()));
		taResult.setBorder(new LineBorder(Color.GREEN));
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnOk=new JButton("확인"));
		//프레임에 패널 부착]
		add("North",pnlNorth);
		add(pnlCenter);
		add("South",pnlSouth);
	}/////////////////////////////

	@Override
	public void addListener() {
		//윈도우 종료 처리]
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//아이템리스너 부착]
		cbEco.addItemListener(handler);
		cbEnt.addItemListener(handler);
		cbPol.addItemListener(handler);
		cbSpo.addItemListener(handler);
		cBox.addItemListener(handler);
		rbMan.addItemListener(handler);
		rbTrans.addItemListener(handler);
		rbWoman.addItemListener(handler);
		//액션리스너 부착]
		btnOk.addActionListener(handler);
		
	}///////////////
	EventHandler handler = new EventHandler();
	private class EventHandler implements ActionListener,ItemListener{
		List checks = new Vector();
		String gender="여자";
		String grade="";
		
		public EventHandler() {checks.add("경제");}
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			Object source = e.getSource();
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(source instanceof JCheckBox) {
					//System.out.println(((JCheckBox)e.getItem()).getText()+" 선택");
					checks.add(((JCheckBox)e.getItem()).getText());
				}
				else if(source instanceof JRadioButton) {
					//System.out.println(((JRadioButton)e.getItem()).getText()+" 선택");
					gender=((JRadioButton)e.getItem()).getText();
				}
				else {
					//System.out.println(e.getItem()+" 선택");
					//System.out.println(cBox.getSelectedItem()+" 선택");
					if(cBox.getSelectedIndex() !=0)
						grade = e.getItem().toString();
				}
			}///
			else if(e.getStateChange()==ItemEvent.DESELECTED) {
				//System.out.println("해제 : "+e.getItem());
				if(source instanceof JCheckBox) {
					//System.out.println(((JCheckBox)e.getItem()).getText()+" 해제");
					checks.remove(((JCheckBox)e.getItem()).getText());
				}
			}///
			
		}////////////////
		@Override
		public void actionPerformed(ActionEvent e) {		
			/*
			String strInter="";
			for(Object inter:checks) strInter+=inter.toString();
			*/
			//리스트 컬렉션을 배열로 변환]
			Object[] arrays=checks.toArray();
			//Arrays클래스의 toSting()메소드로 배열에 저장된 요소들을
			//[요소1,요소2,...]형태의 문자열로 변환]
			String strInter=  Arrays.toString(arrays);			
			taResult.setText(String.format("[관심사항]%s%n[성별]%s%n[학력]%s",
					strInter,gender,grade
					
					));
			
			
		}///////////////////////
		
	}//////////////////////////////
	public static void main(String[] args) {
		new Component02();
	}//////////////////

}
