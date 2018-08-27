package chatting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import chatting.model.MemberDTO;
import chatting.service.ChattingPanel;
import chatting.service.IMemberService;
import chatting.service.LayoutService;


//회원가입 창
public class JsTalkSingUp extends JFrame implements LayoutService {
//	이름, 나이, 성별, 아이디, 비밀번호 
	private JLabel lblName, lblAge, lblGender, lblId, lblPassword,lblTel,lblimformation;
	private JRadioButton rbMan,rbWoman;
	private JComboBox jcomAge;
	private JTextField textName, textId,textTel;
	private JPasswordField textPass;
	private JButton btnSingleUp, btnCancel;
	private IMemberService service;
	private String gender = "남자";
	private String age = "";
	
	
	
	public JsTalkSingUp(IMemberService service) {
		super("JS Talk Sing Up");
		this.service = service;
		createComponent();
		addComponent();
		addListener();
		setSize(400,500);
		setVisible(true);
		
		
	}

	@Override
	public void createComponent() {
//		lbl생성
		lblimformation = new JLabel("    가입하실 정보를 기입해주세요");
		lblimformation.setFont(new Font("HY견고딕", Font.BOLD, 20));
		lblName = new JLabel("이름");
		lblName.setFont(new Font("맑은고딕", Font.PLAIN,20));
		lblAge = new JLabel("나이");
		lblAge.setFont(new Font("맑은고딕", Font.PLAIN,20));
		lblGender = new JLabel("성별");
		lblGender.setFont(new Font("맑은고딕", Font.PLAIN,20));
		lblId = new JLabel("Id");
		lblId.setFont(new Font("맑은고딕", Font.PLAIN,20));
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("맑은고딕", Font.PLAIN,20));
		lblTel = new JLabel("전화번호");
		lblTel.setFont(new Font("말은고딕", Font.PLAIN, 20));
//		텍스트 생성
		textId = new JTextField();
		textName = new JTextField();
		textPass = new JPasswordField();
		textTel = new JTextField();
		
//		버튼 생성
		btnSingleUp = new JButton("회원가입");
		btnCancel = new JButton("취소");
//		콤보박스 생성
		Vector items = new Vector();
		items.add(">>나이선택<<");
		for(int i=10;i<=99;i++) {
		items.add(i);
		
		}	
		jcomAge = new JComboBox(items);
//		라디오 생성
		rbMan = new JRadioButton("남자",true);
		rbWoman=new JRadioButton("여자");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbMan);
		group.add(rbWoman);
//		service = new IMemberServiceImpl(IConnect.ORACLE_URL,"SAMPLE","SAMPLE");
		
	}

	@Override
	public void addComponent() {
		JPanel pnlAll = new ChattingPanel(new BorderLayout());
		
		JPanel pnlSouth = new ChattingPanel();
		pnlSouth.add(btnSingleUp);
		pnlSouth.add(btnCancel);
		pnlAll.add("South",pnlSouth);
		
		JPanel pnlCenter = new ChattingPanel(null);
		
		lblimformation.setBounds(10,5,340,40);
		pnlCenter.add(lblimformation);
		lblId.setBounds(80,50,150,40);
		pnlCenter.add(lblId);
		textId.setBounds(120, 60, 130, 25);
		pnlCenter.add(textId);
		
		
		lblPassword.setBounds(10,90,150,40);
		pnlCenter.add(lblPassword);
		textPass.setBounds(120, 100, 130, 25);
		pnlCenter.add(textPass);
		
		lblName.setBounds(60,130,150,40);
		pnlCenter.add(lblName);
		textName.setBounds(120, 140, 130, 25);
		pnlCenter.add(textName);
		
		lblAge.setBounds(60, 170, 150, 40);
		pnlCenter.add(lblAge);
		jcomAge.setBounds(120, 180, 130, 25);
		pnlCenter.add(jcomAge);
		
		
		lblGender.setBounds(60, 210, 150, 40);
		pnlCenter.add(lblGender);
		JPanel pnlGender = new ChattingPanel();
		rbMan.setBackground(new Color(76, 174, 221));
		pnlGender.add(rbMan);	
		rbWoman.setBackground(new Color(76, 174, 221));
		pnlGender.add(rbWoman);
		pnlGender.setBounds(120, 215, 130, 25);
		pnlCenter.add(pnlGender);
		lblTel.setBounds(20, 250, 150, 40);
		pnlCenter.add(lblTel);
		textTel.setBounds(120, 260, 130, 25);
		pnlCenter.add(textTel);
		
		pnlAll.add(pnlCenter);
		
		add(pnlAll);
		
		
		
	}

	@Override
	public void addListener() {
		dispose();
		btnCancel.addActionListener(handler);
		btnSingleUp.addActionListener(handler);
		rbMan.addItemListener(handler);
		rbWoman.addItemListener(handler);
		jcomAge.addItemListener(handler);
		
	}//addListener
	
	EventHandler handler = new EventHandler();
	private class EventHandler implements ActionListener,ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			Object source = e.getItem();
			if(source.toString().contains("남자")) {//radio 남자버튼 클릭시
				gender="남자";
			}//if
			else if(source.toString().contains("여자")) {//radio 남자버튼 클릭시
				gender="여자";
			}//else if	
			else {//나이를 선택하였을 때
				age=e.getItem().toString();
			}//else
		}//itemStateChanged

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == btnSingleUp) {//회원가입을 눌렀을 때
				notVisi();
			}//if
			else if(source == btnCancel) {//취소를 눌렀을 때
				dispose();
			}//else if
		}//actionPerformed
	}//EventHandler
	
	
	public void notVisi() {
		if(textId.getText().trim().length()==0) {//아이디를 입력하지 않았을 경우
			JOptionPane.showMessageDialog(this, "아이디를 입력하여 주세요");
			textId.requestFocus();
		}//if
		else if(String.valueOf(textPass.getPassword()).trim().length()==0) {//비밀번호를 입력하지 않았을 경우
			JOptionPane.showMessageDialog(this, "비밀번호를 입력하여주세요");
			textPass.requestFocus();
		}//else if
		else if(textName.getText().trim().length()==0) {//이름을 입력하지 않았을 경우
			JOptionPane.showMessageDialog(this, "이름을 입력하여 주세요");
			textName.requestFocus();
		}//else if
		else if(jcomAge.getSelectedIndex()==0) {//나이를 선택하지 않았을 경우
			JOptionPane.showMessageDialog(this, "나이를 선택하여 주세요");
			jcomAge.requestFocus();
		}//else if
		else if(textTel.getText().trim().length()==0) {//전화번호를 입력하지 않았을시
			JOptionPane.showMessageDialog(this, "나이를 선택하여 주세요");
			textTel.requestFocus();
		}
		
		
		else {//모두 정상적으로 입력하였을 경우
			
			
			String id = textId.getText().trim();
			String pwd = String.valueOf(textPass.getPassword());
			String name = textName.getText().trim();
			String tel = textTel.getText().trim();
			
			MemberDTO dto = new MemberDTO();
			
			dto.setId(id);
			dto.setPwd(pwd);
			dto.setName(name);
			dto.setAge(age);
			dto.setGender(gender);
			dto.setTel(tel);
			dto.setDate(null);
			
			
			try {
				service.insert(dto);
				JOptionPane.showMessageDialog(JsTalkSingUp.this, "회원가입이 완료되었습니다");
				textId.setText("");
				textPass.setText("");
				textName.setText("");
				textTel.setText("");
				dispose();
			}//try
			
			catch (Exception e) {
				JOptionPane.showMessageDialog(JsTalkSingUp.this, "이미 있는 아이디입니다");
			}//catch
		}//else
	}//notVisi
}//class
