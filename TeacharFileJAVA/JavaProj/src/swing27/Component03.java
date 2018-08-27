package swing27;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import awt26.service.LayoutService;
/*
이미지를 복사하는 프로그램]

JFileChooser(AWT의 FileDialog)를 이용해서 
이미지파일 을 열고
Copy.확장자 로 저장하는 프로그램

저장시 JProgressBar(AWT에는 없음)를 이용해서
진행율을 보이기.
JProgressBar주요메소드]
setStringPaintted(boolean):진행율 문자열로 표시
setMaxinum():최대값 설정
setMinimun();최소값 설정
getValue():현재까지 진행된 진행값 얻는다
setValue();프로그래바 진행 값  설정

*이미지 복사시 스레드 이용


 AWT에서 파일대화상자는 FileDialog이나
 SWING에서는 JFileChooser임
 또한 JFileChooser는 보여주기위해서
 setVisible(true)가 아니라
 showXXXXDialog()계열 메소드를 호출하면된다.
 JFileChooser주요 메소드]
 int showOpenDialog(Component parent):파일 열기
 int showSaveDialog(Component parent):파일 저장 
 String getName(File f) :파일명 반환
 File getSelectedFile() :선택된 파일반환(File타입)

*/
public class Component03 extends JFrame implements LayoutService {
	//[멤버변수]
	JButton btnOpen,btnCopy;
	JTextField txtPath;
	//이미지 표시할 레이블
	JLabel lblImage;
	//프로그래스 바]
	JProgressBar progressBar;
	//파일대화상자]
	JFileChooser fileChooser;
	//오픈한 파일객체 저장용
	File selectedFile;
	//확장자 저장용
	String extension;
	public Component03() {
		//1]타이틀 설정
		super("Swing컴포넌트 연습03");	
		
		//2]레이아웃 변경	
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정	
		setSize(600,700);
		setVisible(true);
	}/////////////////////////
	@Override
	public void createComponent() {
		//버튼]
		btnCopy = new JButton("복사");
		btnOpen = new JButton("열기");
		//텍스트 필드]
		txtPath = new JTextField();
		txtPath.setPreferredSize(new Dimension(416,30));
		//텍스트 수정 불가토록 설정]
		txtPath.setEditable(false);
		//프로그레스바]
		progressBar = new JProgressBar();
		progressBar.setPreferredSize(new Dimension(550,30));
		//진행율 텍스트로 표시]
		progressBar.setStringPainted(true);
		//최대값은 파일 크기에 따라 결정됨
		//progressBar.setMaximum(200);
		progressBar.setMinimum(0);
		//progressBar.setValue(100);
		
		progressBar.setBackground(Color.WHITE);
		//레이블]
		lblImage= new JLabel();
		//lblImage.setOpaque(true);
		//lblImage.setBackground(Color.YELLOW);
		
		//파일 대화상자]
		//유닉스(/)나 윈도우식(\) 디렉토리 표기 둘다 가능
		fileChooser = new JFileChooser("G:/CCH");
		//파일 확장자 설정
		FileNameExtensionFilter filter = new FileNameExtensionFilter("이미지 파일","bmp","jpg","gif","png");
		fileChooser.setFileFilter(filter);
		//파일 확장자 추가
		filter = new FileNameExtensionFilter("텍스트 파일(*.txt)","txt");
		fileChooser.addChoosableFileFilter(filter);
	}///////////////
	@Override
	public void addComponent() {
		JPanel pnlNorth = new MyPanel(new GridLayout(2, 1));
		
		pnlNorth.setBorder(new TitledBorder("이미지 복사"));
		//북쪽 1행]
		JPanel pnlTextButton = new MyPanel();
		pnlTextButton.add(txtPath);
		pnlTextButton.add(btnOpen);
		pnlTextButton.add(btnCopy);
		pnlNorth.add(pnlTextButton);
		//북쪽 2행]
		JPanel pnlProgress = new MyPanel();
		pnlProgress.add(progressBar);
		pnlNorth.add(pnlProgress);
		
		//가운데
		JPanel pnlCenter = new MyPanel(new BorderLayout());
		pnlCenter.setBorder(new TitledBorder("복사된 이미지"));
		pnlCenter.add(lblImage);
		//프레임에 패널 부착]
		add("North",pnlNorth);
		add(pnlCenter);
	}/////////////
	@Override
	public void addListener() {
		//프로그램 종료처리]
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//버튼에 리스너 부착]
		btnCopy.addActionListener(handler);
		btnOpen.addActionListener(handler);
		
	}//////////////////////////
	ActionListener handler = new ActionListener() {	
		String extnames = "GIF,JPG,BMP,PNG";
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();
			if(source == btnOpen) {//열기
				int option=fileChooser.showOpenDialog(Component03.this);
				//System.out.println("option : "+option);
				if(option == JFileChooser.APPROVE_OPTION) {
					selectedFile=fileChooser.getSelectedFile();
					//확장자 구하기]
					int index=selectedFile.getName().lastIndexOf(".")+1;
					extension = selectedFile.getName().substring(index).toUpperCase();
					if(extnames.indexOf(extension) ==-1) {
						JOptionPane.showMessageDialog(btnOpen,"이미지 파일이 아닙니다");
						return;
					}////
					//텍스트 필드에 파일경로 뿌리기]
					txtPath.setText(selectedFile.getAbsolutePath());
					
				}
			}
			else {//복사
				
				if(txtPath.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(btnCopy,"복사할 이미지 파일을 먼저 선택하세요");
					return;
				}
				//이미지 복사 - 스레드로 구현]
				new ImageCopy().start();
				
			}////////////////else
		}//////////////actionPerformed
	};///////////////////////////////////////////////////
	//이미지를 복사하는 스레드]
	class ImageCopy extends Thread{
		
		@Override
		public void run() {
			copy();
		}/////////////////
		private void copy() {
			//1]프로그레스바 최대값을 파일 크기로 설정
			progressBar.setMaximum((int)selectedFile.length());
			try {
				//2]이미지 복사(src/swing27/Copy.확장자)
				//  프로그레스바 진행율도 표시
				//입력 스트림 생성]
				BufferedInputStream bis =
						new BufferedInputStream(new FileInputStream(selectedFile));
				//출력 스트림 생성]
				BufferedOutputStream bos =
						new BufferedOutputStream(new FileOutputStream("src/swing27/Copy."+extension));
				
				//bis로 읽고 bos로 출력]
				int data;
				int totalByte=0;
				while((data=bis.read()) !=-1) {
					totalByte++;
					bos.write(data);
					bos.flush();
					//진행율 표시]
					progressBar.setValue(totalByte);
				}
				//복사완료]
				//3]레이블에 복사된 이미지 뿌리기]
				// Toolkit을 이용해서 이미지를 메모리에 로딩시
				// BMP파일은 로드불가
				//Image image=Toolkit.getDefaultToolkit().getImage("src/swing27/Copy."+extention);
				//image=image.getScaledInstance(lblImage.getWidth(),
				//		                      lblImage.getHeight(),Image.SCALE_DEFAULT);
				/* BMP파일도 로드할 수 있도록 수정 
		         * javax.imageio패키지의 ImageIO클래스의
		         * static BufferedImage read(File input)  
		         * 이용 
		         */
				
				//Image image = Toolkit.getDefaultToolkit().getImage("src/swing27/Copy."+extension);
				
				Image image=ImageIO.read(new File("src/swing27/Copy."+extension));
				image=image.getScaledInstance(lblImage.getWidth(),lblImage.getHeight(), Image.SCALE_DEFAULT);				
				ImageIcon icon = new ImageIcon(image);
				lblImage.setIcon(icon);
				
				
			}
			catch(Exception e) {e.printStackTrace();}
			
		}/////////////////
	}//////////////////////////	
	@Override
	public Insets getInsets() {		
		return new Insets(40, 18, 18, 18);
	}
	public static void main(String[] args) {
		new Component03();

	}

}
