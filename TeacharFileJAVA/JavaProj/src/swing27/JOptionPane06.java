package swing27;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import awt26.service.LayoutService;
/*
Swing에서는 JOptionPane클래스를 통해서

사용자에 반응하는 다양한 대화상자(Dialog)를 제공한다
JOptionPane의 showXXX계열 메소드를 통해서
사용자로부터 확인(Confirm)을 받고자 한다면
showConfirmDialog메소드
사용자로부터 대화상자를 이용해 어떤 값을 입력 받고자 한다면
showInputDialog메소드
사용자에게 경고 메시지등을 보여주고자 할때는
showMessageDialog()메소드를 사용한다.
 
*/
public class JOptionPane06 extends JFrame implements LayoutService {

	JButton btnConfirm,btnMessage,btnInput;
	public JOptionPane06() {
		//1]타이틀 설정
		super("JOptionPane연습");			
		//2]레이아웃 변경	
		setLayout(new FlowLayout());
		//3]컴포넌트 생성		
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정	
		pack();
		setVisible(true);
	}////////////////////////////
	@Override
	public void createComponent() {}////////////////
	@Override
	public void addComponent() {
		add(btnConfirm=new JButton("확인 대화상자"));
		add(btnInput=new JButton("입력 대화상자"));
		add(btnMessage=new JButton("메시지 대화상자"));

	}//////////////
	@Override
	public void addListener() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//버튼에 리스너 부착]
		btnConfirm.addActionListener(handler);
		btnInput.addActionListener(handler);
		btnMessage.addActionListener(handler);
		
	}///////////
	ActionListener handler = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == btnConfirm) {//확인 대화상자
				/*
				 * static int showConfirmDialog(
				 * Component parentComponent, -- 대화상자를 뜨울 부모컴포넌트
				 * Object message, --대화상자에 보여줄 메시지
				 * String title, -- 대화상자의 제목
				 * int optionType, -- 버튼의 종류
				 * int messageType, --아이콘 모양
				 * Icon icon -- 직접 디자인한  아이콘 사용시 )  
				 */
				/*
				//인자가 두개인 메소드]- 세개의 버튼 표시
				int option=JOptionPane.showConfirmDialog(JOptionPane06.this,"정말로 삭제할래?");
				//System.out.println("option : "+option);
				if(option == JOptionPane.YES_OPTION) setTitle("예를 눌렀군요");
				else if(option == JOptionPane.NO_OPTION) setTitle("아니오를 눌렀군요");
				else if(option == JOptionPane.CANCEL_OPTION) setTitle("취소를 눌렀군요");
				*/
				/*
				//내가 만든 아이콘 사용]
				Image image=Toolkit.getDefaultToolkit().getImage("src/awt26/event/terran.jpg");
				image=image.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
				ImageIcon icon = new ImageIcon(image);
				JOptionPane.showConfirmDialog(
						btnConfirm, 
						"정말로 삭제할래?", 
						"삭제 확인창", 
						JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.WARNING_MESSAGE, 
						icon);*/
				
				//가장 많이 사용하는 메소드]
				int option=JOptionPane.showConfirmDialog(
						btnConfirm, 
						"정말로 회원 탈퇴 하시겠습니까?", 
						"회원탈퇴", 
						JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION)
					setTitle("회원 탈퇴처리");
				
			}///
			else if(source == btnInput) {
				/*
			     * static String showInputDialog(
			     *  Component parentComponent,
			     *  Object message, 
			     *  String title, 
			     *  int messageType) 
			     */
				/*
				String inputString= JOptionPane.showInputDialog(btnInput,
						"나이를 입력하세요?", "나이 입력창",JOptionPane.ERROR_MESSAGE);
				setTitle("당신의 나이 : "+ inputString);*/
				 //기본]-가장 활용빈도가 높다
				/*
			     * 취소버튼 혹은  X버튼 누르면 무조건 null반환:null반환
			     * 입력 안하고 확인버튼: 빈문자열("")
			     * 
			     */	
				String inputString= JOptionPane.showInputDialog("나이를 입력하세요?");
				if(inputString==null || inputString.trim().length()==0) {
					JOptionPane.showMessageDialog(btnInput,"나이를 입력하세요...");
				}
				else {
					
					try {
						JOptionPane.showMessageDialog(btnInput,"당신의 10년후 나이는 "+(Integer.parseInt(inputString)+10));
					} 
					catch (Exception e2) {
						JOptionPane.showMessageDialog(btnInput,"나이는 숫자만...");
					}
					
				}
				
			}///////////
			else {				
				//메시지 대화상자
				/* -아래 두 개 인자를 가진 메소드를 주로 사용
				 * static void showMessageDialog(
				 * Component parentComponent, 
				 * Object message) 
				 * 
				 * static void showMessageDialog(
				 * Component parentComponent, 
				 * Object message, 
				 * String title, 
				 * int messageType) 
				 */
				JOptionPane.showMessageDialog(btnMessage,"아이디를 입력하세요?");
			}
			
		}
	};/////////////////////////////////
	public static void main(String[] args) {
		new JOptionPane06();
	}//////////////////////////

}
