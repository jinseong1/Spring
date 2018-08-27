package swing27.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import awt26.service.LayoutService;
import jdbc25.service.IConnect;
import swing27.MyPanel;
import swing27.model.MemberDTO;
import swing27.service.IMemberService;
import swing27.service.IMemberServiceImpl;

public class MemberView extends JFrame implements LayoutService {
	//[멤버변수]
	private JButton[] buttons = new JButton[6];
	private String[] labels= {"입력","수정","삭제","검색","전체보기","아이디 중복"};
	private JTextField textUser,textName,textTel;
	private JPasswordField textPass;
	
	//테이블 관련]
	private JTable table;
	private DefaultTableModel model;
	
	Vector<Vector> dataVector = new Vector<Vector>();
	Vector<String> columnVector = new Vector<String>();
	
	//데이타베이스 관련]
	private IMemberService service;
	
	//JTable 레코드 선택여부 판단용]
	int selectedRow=-1;
	//비밀번호 저장용 컬렉션]
	Vector passwordVector = new Vector();
	//검색 및 전체보기용 상수]
	public static final int ALL=1;
	public static final int SEARCH=10;
	
	
	//아이디 중복 체크용]
	boolean isDuplicatedClicked;
	
	//[생성자]
	public MemberView() {
		//타이틀 설정]
		super("회원 관리 시스템");
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout(10, 0));		
		//컴포넌트 생성]
		createComponent();
		//컴포넌트 부착]
		addComponent();
		//리스너 부착]
		addListener();
	}////////////////////////////////	
	@Override
	public void createComponent() {
		//버튼]
		for(int i=0;i <buttons.length;i++)
			buttons[i] = new JButton(labels[i]);
		
		//텍스트 필드]
		textName = new JTextField(20);
		textTel  = new JTextField(20);
		textUser = new JTextField(20);
		//패스워드]
		textPass = new JPasswordField(20);
		//테이블]
		table = new JTable();
		
		table.setBackground(Color.WHITE);
		
		JTableHeader tableHeader=table.getTableHeader();
		tableHeader.setReorderingAllowed(false);
		tableHeader.setResizingAllowed(false);
		tableHeader.setBackground(Color.GREEN);
		tableHeader.setPreferredSize(new Dimension(0, 40));
		
		//행의 높이 설정]
		table.setRowHeight(30);
		//테이블의 데이타로 사용할 모델]
		model = new DefaultTableModel();
		//컬럼명 설정]
		columnVector.add("아이디");
		columnVector.add("비밀번호");
		columnVector.add("이름");
		columnVector.add("전화번호");
		columnVector.add("가입일");
		
		
		//데이타 베이스 연결]
		service = new IMemberServiceImpl(IConnect.ORACLE_URL,"SAMPLE","SAMPLE");
		//모델에 데이타 및 컬럼 설정]
		//model.setDataVector(dataVector, columnVector);
		//테이블과 모델 바인딩]
		//table.setModel(model);
		
		//프로그램 최초 실행시 오라클의 데이타를
		//JTable에 뿌려주기
		setJTableData(ALL);
		
	}
	@Override
	public void addComponent() {
		JPanel pnlWest = new MyPanel(new BorderLayout());
		pnlWest.setBorder(new TitledBorder("입력화면"));
		JPanel pnlNorthInWest = new MyPanel(new GridLayout(4, 1));
		
		
		FlowLayout mgr = new FlowLayout(FlowLayout.LEFT);
		
		JPanel pnlUser = new MyPanel(mgr);
		pnlUser.add(new JLabel("아  이  디"));
		pnlUser.add(textUser);
		pnlUser.add(buttons[buttons.length-1]);
		pnlNorthInWest.add(pnlUser);
		
		JPanel pnlPass = new MyPanel(mgr);
		pnlPass.add(new JLabel("비밀번호"));
		pnlPass.add(textPass);		
		pnlNorthInWest.add(pnlPass);
		
		JPanel pnlName = new MyPanel(mgr);
		pnlName.add(new JLabel("이         름"));
		pnlName.add(textName);		
		pnlNorthInWest.add(pnlName);
		
		JPanel pnlTel = new MyPanel(mgr);
		pnlTel.add(new JLabel("전화번호"));
		pnlTel.add(textTel);		
		pnlNorthInWest.add(pnlTel);
		
		
		pnlWest.add("North",pnlNorthInWest);
		
		JPanel pnlSouthInWest = new MyPanel();
		for(int i=0; i < buttons.length-1;i++)
			pnlSouthInWest.add(buttons[i]);
		pnlWest.add("South", pnlSouthInWest);
		
		
		JPanel pnlCenter = new MyPanel(new BorderLayout());
		JScrollPane pane = new JScrollPane(table);
		pane.getViewport().setBackground(Color.WHITE);
		pnlCenter.add(pane);
		//프레임에 부착]
		add("West",pnlWest);
		add(pnlCenter);
	}
    
	@Override
	public void addListener() {		
		//윈도우 종료]
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//데이타베이스 자원반납
				service.close();
				
				System.exit(0);
			}
		});
		//버튼에 리스너 부착]
		for(int i=0;i < buttons.length;i++) buttons[i].addActionListener(handler);
		//테이블에 마우스 리스너 부착]
		table.addMouseListener(handler);
		
		//아이디 입력창에 키 리스너 부착]
		textUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				isDuplicatedClicked=false;
			}
		});
	}////////////////////addListener
	EventHandler handler = new EventHandler();
	class EventHandler extends MouseAdapter implements ActionListener{
		
		//[유효성 체크용 메소드]
		private boolean isValidate() {
			if(textUser.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(MemberView.this,"아이디를 입력하세요");
				textUser.requestFocus();
				return false;
			}
			else if(String.valueOf(textPass.getPassword()).trim().length()==0) {
				JOptionPane.showMessageDialog(MemberView.this,"비밀번호를 입력하세요");
				textPass.requestFocus();
				return false;
			}
			else if(textName.getText().trim().length()==0) {
				JOptionPane.showMessageDialog(MemberView.this,"이름을 입력하세요");
				textName.requestFocus();
				return false;
			}
			else if(textTel.getText().trim().length()==0) {
				JOptionPane.showMessageDialog(MemberView.this,"전화번호를 입력하세요");
				textTel.requestFocus();
				return false;
			}
			
			return true;
		}///////////////isValidate
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == buttons[0]) {//입력
				if(!isValidate()) return;
				//제대로 입력했다면 아이디 중복체크 여부 판단]
				if(!isDuplicatedClicked) {
					JOptionPane.showMessageDialog(MemberView.this,"아이디 중복체크 요망!!!");
					return;
				}
				//입력처리]
				//사용자 입력값]
				String id = textUser.getText().trim();
				String pwd = String.valueOf(textPass.getPassword()).trim();
				String name = textName.getText().trim();
				String tel  = textTel.getText().trim();
				MemberDTO dto = new MemberDTO(id, pwd, name, tel, null);
				try {
					int affected=service.insert(dto);
					JOptionPane.showMessageDialog(MemberView.this,affected+"행 입력 성공");
					//JTable에 데이타 뿌리기
					setJTableData(ALL);
					//텍스트 클리어
					textClear();
					//아이디 중복 버튼 클릭 체크용 변수를 다시 false로 설정
					isDuplicatedClicked =false;
				} 
				catch (Exception e1) {
					JOptionPane.showMessageDialog(MemberView.this,"입력 실패 :"+e1.getMessage());
				}
			}////buttons[0]
			else if(source == buttons[1]) {//수정
				//레코드 선택여부 체크]
				if(selectedRow == -1) {
					JOptionPane.showMessageDialog(MemberView.this,"수정할 레코드를 오른쪽 테이블에서 선택하세요");
					return;
				}
				//유효성 체크]
				if(!isValidate()) return;
				//레코드를 선택했다면 수정처리]
				MemberDTO dto = new MemberDTO();
				dto.setId(textUser.getText().trim());
				dto.setName(textName.getText().trim());
				dto.setPwd(String.valueOf(textPass.getPassword()).trim());
				dto.setTel(textTel.getText().trim());
				try {
					int affected=service.update(dto);
					JOptionPane.showMessageDialog(MemberView.this,affected+"행이 수정되었어요");
					//JTable에 데이타 뿌리기
					setJTableData(ALL);
					//텍스트 클리어
					textClear();
					//수정 성공시]
					//레코드 선택용 변수 다시 -1로 초기화
					selectedRow=-1;
				} 
				catch (Exception e1) {
					JOptionPane.showMessageDialog(MemberView.this,"수정 실패 :"+e1.getMessage());
				}
			}///////////buttons[1]
			else if(source == buttons[2]) {//삭제
				//레코드 선택여부 체크]
				if(selectedRow == -1) {
					JOptionPane.showMessageDialog(MemberView.this,"삭제할 레코드를 오른쪽 테이블에서 선택하세요");
					return;
				}
				//레코드를 선택했다면 삭제처리]
				MemberDTO dto = new MemberDTO();
				dto.setId(textUser.getText().trim());
				try {
					int affected=service.delete(dto);
					JOptionPane.showMessageDialog(MemberView.this,affected+"행이 삭제되었어요");
					//JTable에 데이타 뿌리기
					setJTableData(ALL);
					//텍스트 클리어
					textClear();
					//삭제 성공시]
					//레코드 선택용 변수 다시 -1로 초기화
					selectedRow=-1;
				} 
				catch (Exception e1) {
					JOptionPane.showMessageDialog(MemberView.this,"삭제 실패 :"+e1.getMessage());
				}
			}//////////buttons[2]
			else if(source == buttons[3]) {//검색
				//아이디나 이름으로 검색
				if(textUser.getText().trim().length()==0 && textName.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(MemberView.this,"아이디 혹은 이름을 입력하세요");
					return;
				}
				setJTableData(SEARCH);
			}
			else if(source == buttons[4]) {//전체보기
				setJTableData(ALL);
			}
			else {//아이디 중복
				if(textUser.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(MemberView.this,"아이디를 입력하세요");
					return;
				}
				
				
				try {
					MemberDTO dto=service.selectOne(new MemberDTO(textUser.getText().trim(), null,null,null,null));
					if(dto !=null) {
						JOptionPane.showMessageDialog(MemberView.this,"사용중인 아이디 입니다");
					}
					else {
						//아이디 입력시 중복 체크	
						isDuplicatedClicked=true;
						JOptionPane.showMessageDialog(MemberView.this,"사용가능한 아이디 입니다");
					}
				} 
				catch (Exception e1) {e1.printStackTrace();}
			}
			
		}///////actionPerformed
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(e.getButton()== MouseEvent.BUTTON1) {
				selectedRow=table.getSelectedRow();
				//System.out.println(selectedRow);
				//클릭한 레코드의 각 컬럼값을 텍스트필드에 설정]	
				textUser.setText(table.getValueAt(selectedRow, 0).toString());
				//비밀번호는 실제 값으로 설정:passwordVector
				textPass.setText(passwordVector.get(selectedRow).toString());
				textName.setText(table.getValueAt(selectedRow, 2).toString());
				textTel.setText(table.getValueAt(selectedRow, 3).toString());
				//아이디 수정 불가토록 설정]
				textUser.setEditable(false);
			}
			else if(e.getButton() == MouseEvent.BUTTON3) {
				//선택 해제]
				table.clearSelection();
				textClear();
			}
		}////////////////mousePressed

		private void textClear() {
			//아이디 입력필드를 수정 가능토록 변경
			if(!textUser.isEditable()) textUser.setEditable(true);
			//클리어
			textUser.setText("");
			textPass.setText("");
			textTel.setText("");
			textName.setText("");	
			//아이디 입력창에 포커스 주기
			textUser.requestFocus();
		}/////////////////textClear
		
	}//////////////EventHandler
	@Override
	public Insets getInsets() {		
		return new Insets(40, 18, 18, 18);
	}/////////////////////////
	//JTable에 실제 데이타베이스의 SELECT 쿼리결과 연동]
	public void setJTableData(int searchOrAll) {
		
		try {
			if(searchOrAll == ALL)//전체 보기
				dataVector=service.selectList(null);
			else//검색
				dataVector=service.selectList(new MemberDTO(textUser.getText().trim(), null, textName.getText().trim(), null, null));
			//비밀번호만 별도로 저장]
			for(Vector vector:dataVector) {
				passwordVector.add(vector.get(1));
			}
			//dataVector에 있는 비밀번호를 *로 처리하기]
			for(Vector vector:dataVector) {
				String password=vector.get(1).toString();
				String asterisk="";
				for(int i=0;i <password.length();i++) asterisk+="●";
				vector.set(1, asterisk);
			}			
			//모델에 데이타 및 컬럼 설정]
			model.setDataVector(dataVector, columnVector);
			//테이블과 모델 바인딩]
			table.setModel(model);
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(this,"전체 레코드 쿼리 실패 : "+e.getMessage());
		}
		
	}/////////setJTableData
	
	

}
