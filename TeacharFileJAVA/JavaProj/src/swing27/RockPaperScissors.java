package swing27;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import awt26.service.LayoutService;



public class RockPaperScissors extends JFrame implements LayoutService {
	//[멤버 상수]
	public static final int SCISSORS=1;
	public static final int ROCK=2;
	public static final int PAPER=3;	
	//[멤버변수]
	JButton btnRock,btnPaper,btnScissors;
	
	JLabel lblUserImage,lblCompImage;
	JLabel lblJumsu;
	
	//[아이콘 저장용 변수]
	Icon rockIcon,paperIcon,scissorsIcon;
	
	Font font = new Font("굴림체",Font.BOLD,40);
	
	public RockPaperScissors() {
		super("가위바위보 게임");
		setLayout(new GridLayout(6, 1));
		createComponent();
		addComponent();
		addListener();
		setSize(550,550);
		setResizable(false);
		setVisible(true);
	}///////////////////////////
	@Override
	public void createComponent() {
		//버튼]
		btnPaper = new JButton("보");
		btnRock  = new JButton("바위");
		btnScissors=new JButton("가위");
		//아이콘]
		Image rockImage=Toolkit.getDefaultToolkit().getImage("src/swing27/바위.jpg").getScaledInstance(50,50, Image.SCALE_DEFAULT);
		rockIcon = new ImageIcon(rockImage);
		
		Image paperImage=Toolkit.getDefaultToolkit().getImage("src/swing27/보.jpg").getScaledInstance(50,50, Image.SCALE_DEFAULT);
		paperIcon = new ImageIcon(paperImage);
		
		Image scissorsImage=Toolkit.getDefaultToolkit().getImage("src/swing27/가위.jpg").getScaledInstance(50,50, Image.SCALE_DEFAULT);
		scissorsIcon = new ImageIcon(scissorsImage);
		
		//레이블]
		lblCompImage = new JLabel(rockIcon);
		lblUserImage = new JLabel();
		lblUserImage.setIcon(rockIcon);
		
		lblJumsu= new JLabel(String.format("%-5s:%5s",0,0));
		
		lblJumsu.setFont(font);
		lblJumsu.setForeground(Color.RED);
	}//////////////////
	@Override
	public void addComponent() {
		//1행]
		JPanel pnlOne = new MyPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTitle = new JLabel("가위바위보 게임");
		lblTitle.setFont(font);
		pnlOne.add(lblTitle);
		//2행]
		JPanel pnlTwo = new MyPanel();
		pnlTwo.add(btnScissors);
		pnlTwo.add(btnRock);
		pnlTwo.add(btnPaper);
		//3행]
		JPanel pnlThree = new MyPanel();
		JLabel lblVersus = new JLabel("사용자  :  컴퓨터");
		lblVersus.setFont(font);
		pnlThree.add(lblVersus);
		//4행]
		JPanel pnlFour = new MyPanel();
		pnlFour.add(lblUserImage);
		pnlFour.add(new JLabel(String.format("%50s","")));
		pnlFour.add(lblCompImage);
		//5행]
		JPanel pnlFive = new MyPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblResult = new JLabel("게임 결과");
		lblResult.setFont(font);
		pnlFive.add(lblResult);
		//6행]
		JPanel pnlSix = new MyPanel();
		pnlSix.add(lblJumsu);
		//프레임에 패널 배치]
		add(pnlOne);
		add(pnlTwo);
		add(pnlThree);
		add(pnlFour);
		add(pnlFive);
		add(pnlSix);
	}////////////////////
	@Override
	public void addListener() {
		//종료]
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//버튼에 리스너 부착]
		btnPaper.addActionListener(listener);
		btnRock.addActionListener(listener);
		btnScissors.addActionListener(listener);
	}/////////////////////////
	ActionListener listener = new ActionListener() {		
		private int userScore,compScore;		
		//랜덤하게 숫자(1~3사이)를 발생시키는 메소드]
		private int setComputerImage() {		
			int comp=(int)(Math.random()*3)+1;
			switch(comp) {
				case SCISSORS:
					lblCompImage.setIcon(scissorsIcon);
					break;
				case ROCK:
					lblCompImage.setIcon(rockIcon);
					break;
				default:lblCompImage.setIcon(paperIcon);
			}
			return comp;
		}/////////////////////////getComputerNumber()
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			int user;
			if(source == btnPaper) {//보
				user=PAPER;
				lblUserImage.setIcon(paperIcon);
			}
			else if(source == btnRock) {//비위
				user=ROCK;
				lblUserImage.setIcon(rockIcon);
			}
			else {//가위
				user=SCISSORS;
				lblUserImage.setIcon(scissorsIcon);
			}
			//컴퓨터 이미지 교체]
			int comp=setComputerImage();
			//게임 승패 여부 판단
			process(comp,user);
			//레이블에 점수 표시]
			lblJumsu.setText(String.format("%-5s:%5s",userScore,compScore));
			
		}////////////actionPerformed
		private void process(int computer, int user) {				
			if(computer==SCISSORS && user==PAPER    ||
			   computer==ROCK     && user==SCISSORS ||	
			   computer==PAPER    && user==ROCK
					)
				compScore++;
			else if(computer == user);
			else userScore++;
			
		}////////////////////process		
	};///////////////listener

	public static void main(String[] args) {
		new RockPaperScissors();
	}///////////////////////////

}
