package calculating;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
 

public class Calculating extends JFrame implements LayoutService {

	

	private JLabel mathText, outPutText, leftText;

	private JMenuBar menuBer;

	private JMenu menuView, menuEdit, menuHelp;

	private JButton btnMc,btnMr,btnMs,btnMPlus,btnMMinus;

	private JButton btnOneEraser,btnCe,btnC,btnPlusMinus,btnCheck;

	private JButton btnSlash, btnPerCent,btnStar,btnXSlash,btnMinus,btnPlus;

	private JButton btnOne,btnTwo,btnThree,btnFour,btnFive;

	private JButton btnSix,btnSeven,btnEigth,btnNine,btnZero,btnPeriod,btnOutput;

	GridBagLayout bagLayout;

 

 

	

	public Calculating() {

		super("계산기");

		createComponent();

		addComponent();

		addListener();

		setSize(400,600);

//		setResizable(false);

		setVisible(true);

		

	}//ParkJinSeong20180709

	

	

	

	public static void main(String[] args) {

		new Calculating();

	}//main

 

 

 

	@Override

	public void createComponent() {

//		MenuBar 생성

		menuBer = new JMenuBar();

		menuView = new JMenu("보기(V)");

		menuEdit = new JMenu("편집(E)");

		menuHelp = new JMenu("도움말(H)");

//		Label 생성

		mathText = new JLabel("12");
		
		outPutText = new JLabel("0");

		leftText = new JLabel("M");

//		Button 생성

		btnMc = new JButton("MC");

		btnMr = new JButton("MR");

		btnMs = new JButton("MS");

		btnMPlus = new JButton("M+");

		btnMMinus = new JButton("M-");

		btnOneEraser = new JButton("←");

		btnCe = new JButton("CE");

		btnC = new JButton("C");

		btnPlusMinus = new JButton("±");

		btnCheck = new JButton("V");

		btnSlash = new JButton("/");

		btnPerCent = new JButton("%");

		btnStar = new JButton("*");

		btnXSlash = new JButton("1/x");

		btnPlus = new JButton("+");

		btnMinus = new JButton("-");

		btnOne = new JButton("1");

		btnTwo = new JButton("2");

		btnThree = new JButton("3");

		btnFour = new JButton("4");

		btnFive = new JButton("5");

		btnSix = new JButton("6");

		btnSeven = new JButton("7");

		btnEigth = new JButton("8");

		btnNine = new JButton("9");

		btnZero = new JButton("0");

		btnPeriod = new JButton(".");

		btnOutput = new JButton("=");

		

	}

 

 

 

	@Override

	public void addComponent() {

		setJMenuBar(menuBer);

		menuBer.add(menuView);

		menuBer.add(menuEdit);

		menuBer.add(menuHelp);

//		텍스트필더 장착할 2행 1열 JPanel 생성

		JPanel pnlAll = new JPanel(new GridLayout(4,1));

		

//		1행

		JPanel pnlCanvas = new JPanel(new GridLayout(2, 1));

		pnlCanvas.add(mathText);
		mathText.setFont(new Font("맑은고딕", Font.BOLD, 20));
		mathText.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel pnlLeft = new JPanel(new BorderLayout());
		pnlLeft.add("West",leftText);
		leftText.setFont(new Font("맑은고딕", Font.BOLD, 20));
		pnlLeft.add(outPutText);
		outPutText.setFont(new Font("맑은고딕", Font.BOLD, 60));
		outPutText.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlCanvas.add(pnlLeft);


		pnlAll.add(pnlCanvas);

//		2행

		JPanel pnlNorthBtn = new JPanel(new GridLayout(2, 5,10,10)) {

			@Override

			public Insets getInsets() {

				return new Insets(0, 0, 10, 0);

			}

		};

		pnlNorthBtn.add(btnMc);

		pnlNorthBtn.add(btnMr);

		pnlNorthBtn.add(btnMs);

		pnlNorthBtn.add(btnMPlus);

		pnlNorthBtn.add(btnMMinus);

		pnlNorthBtn.add(btnOneEraser);

		pnlNorthBtn.add(btnCe);

		pnlNorthBtn.add(btnC);

		pnlNorthBtn.add(btnPlusMinus);

		pnlNorthBtn.add(btnCheck);

		pnlAll.add(pnlNorthBtn);

//		3행

		JPanel pnlCenterbtn = new JPanel(new GridLayout(2, 5,10,10)) ;

		pnlCenterbtn.add(btnSeven);

		pnlCenterbtn.add(btnEigth);

		pnlCenterbtn.add(btnNine);

		pnlCenterbtn.add(btnSlash);

		pnlCenterbtn.add(btnPerCent);

		pnlCenterbtn.add(btnFour);

		pnlCenterbtn.add(btnFive);

		pnlCenterbtn.add(btnSix);

		pnlCenterbtn.add(btnStar);

		pnlCenterbtn.add(btnXSlash);		

		pnlAll.add(pnlCenterbtn);

//		4행

		JPanel pnlSouthbtn = new JPanel(null);

		btnOne.setBounds(0, 10, 66, 56);

		pnlSouthbtn.add(btnOne);

		btnTwo.setBounds(76, 10, 66, 56);

		pnlSouthbtn.add(btnTwo);

		btnThree.setBounds(152, 10, 66, 56);

		pnlSouthbtn.add(btnThree);

		btnZero.setBounds(0, 76, 142, 56);

		pnlSouthbtn.add(btnZero);

		btnPeriod.setBounds(152, 76, 66, 56);
		
		pnlSouthbtn.add(btnPeriod);
		
		btnPlus.setBounds(228, 76, 66, 56);
		
		pnlSouthbtn.add(btnPlus);
		
		btnOutput.setBounds(304, 10, 66, 122);
		
		pnlSouthbtn.add(btnOutput);
		
		btnMinus.setBounds(228, 10, 66, 56);
		
		pnlSouthbtn.add(btnMinus);

		

		

		pnlAll.add("South",pnlSouthbtn);

		add(pnlAll);

	}

 

 

	@Override

	public void addListener() {

//		종료

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		

	}

	@Override

	public Insets getInsets() {

		return new Insets(35, 14, 14, 14);

	}

	

}

