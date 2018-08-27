package test.component;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.service.LayoutService;
import jdbc25.callable.InsertProCall;
import polymorphism14.InstanceOfOP;

public class CheckboxRadioChoice extends Frame implements LayoutService {
//	멤버변수
	private Checkbox cbEco, cbEnt, cbSpo, cbPol;
	private Checkbox rbMan, rbWoman, rbTrans;
	private Choice choice;
	private TextArea taResult;
	private Button btnOk;	
	
//	생성자
	public CheckboxRadioChoice() {
		setTitle("Checkbox, Choice Component Test");
		createComponent();
		addComponent();
		addListener();
		setSize(400,600);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new CheckboxRadioChoice();

	}

	@Override
	public void createComponent() {
		cbEco = new Checkbox();
		cbEco.setLabel("경제");
		cbEnt = new Checkbox("연예");
		cbPol = new Checkbox("정치", true);
		cbSpo = new Checkbox("스포츠");
		
//		체크박스를 라디오박스로 만들어주기 위한 클래스
		CheckboxGroup group = new CheckboxGroup();
		rbMan = new Checkbox("남자",false, group);
		rbWoman = new Checkbox("여자", true, group);
		rbTrans = new Checkbox("트랜스젠더", false, group);
//		Choice
		choice = new Choice();
		choice.add("초등학교");
		choice.add("중학교");
		choice.add("고등학교");
		choice.add("대학교");
//		TextArea
		taResult  = new TextArea();		
	}

	@Override
	public void addComponent() {
		Panel pnlNorth = new Panel(new GridLayout(6, 1));
//		1행
		pnlNorth.add(new Label("당신이 좋아하는 관심분야"));
//		2행
		Panel pnlCheck = new Panel(new FlowLayout(FlowLayout.LEFT));
		pnlCheck.add(cbEco);
		pnlCheck.add(cbEnt);
		pnlCheck.add(cbPol);
		pnlCheck.add(cbSpo);
		pnlNorth.add(pnlCheck);
//		3행
		pnlNorth.add(new Label("당신의 성별은?"));
//		4행 라디오 버튼
		Panel pnlRadio = new Panel(new FlowLayout(FlowLayout.LEFT));
		pnlRadio.add(rbMan);
		pnlRadio.add(rbMan);
		pnlRadio.add(rbWoman);
		pnlNorth.add(pnlRadio);
//		5행
		pnlNorth.add(new Label("당신의 학력은?"));
//		6행 초이스
		Panel pnlChoice = new Panel(new FlowLayout(FlowLayout.LEFT));
		pnlChoice.add(choice);
		pnlNorth.add(pnlChoice);
//		가운데
		Panel pnlCenter = new Panel(new BorderLayout());		
		pnlCenter.add(taResult);
//		남쪽패널
		Panel pnlSouth = new Panel();
		pnlSouth.add(btnOk = new Button("확인"));
//		프레임에 부착
		add("North",pnlNorth);
		add(pnlCenter);
		add("South", pnlSouth);
	}

	@Override
	public void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		cbEco.addItemListener(handler);
		cbEnt.addItemListener(handler);
		cbPol.addItemListener(handler);
		cbSpo.addItemListener(handler);
		
		rbMan.addItemListener(handler);
		rbTrans.addItemListener(handler);
		rbWoman.addItemListener(handler);
		
		choice.addItemListener(handler);
		//버튼에 액션 리스너 부착]
		btnOk.addActionListener(handler);
	}
	
	
	
	
	
	private EventHandler handler = new EventHandler();	
	class EventHandler implements ItemListener, ActionListener{
		StringBuffer buffer = new StringBuffer("[관심사항]정치");
		String gender="[성별]여자";
		String grade ="[학력]초등학교";
		
		@Override
		public void actionPerformed(ActionEvent e) {
			taResult.setText(String.format("%s%n%s%n%s",buffer,gender,grade));			
		}//action

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.SELECTED) {
				if(e.getSource() instanceof Checkbox) {
					if(e.getSource()==rbMan || e.getSource()==rbTrans || e.getSource()==rbWoman) {
						gender="[성별]"+e.getItem();
					}//if
					else {
						buffer.append(e.getItem());
					}//else
				}//if
				else {
					grade="[학력]"+e.getItem();
				}//else
			}//if
			else if(e.getStateChange()==ItemEvent.DESELECTED) {
				int start = buffer.indexOf(e.getItem().toString());
				int end = start+e.getItem().toString().length();
				buffer.delete(start, end);
			}
		}//item
		
	}//innerClass
	@Override
		public Insets getInsets() {
			return new Insets(40, 20, 20, 20);
		}

}
