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
//	이미지 복사하는 프로그램을 생성하면서 
public class Component03 extends JFrame implements LayoutService {
	private	JButton btnOpen,btnCopy;
	private JTextField txtPath;
	private JLabel lblImage;
	private JProgressBar progressBar;
	private JFileChooser fileChooser;
//	오픈한 파일객체 저장용
	File selectedFile;
	String extenstion;
	
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
		setSize(600, 700);
		setVisible(true);
	}

	@Override
	public void createComponent() {
//		버튼 생성
		btnOpen = new JButton("열기");
		btnCopy = new JButton("복사");
		
//		TextField Create
		txtPath = new JTextField();
		txtPath.setPreferredSize(new Dimension(418, 30));
		
		
		txtPath.setEditable(false);
		
		progressBar = new JProgressBar();
		progressBar.setPreferredSize(new Dimension(550, 30));
		progressBar.setStringPainted(true);
//		progressBar.setMaximum(200);
		progressBar.setMinimum(0);
//		progressBar.setValue(100);
		lblImage = new JLabel();
//		lblImage.setOpaque(true);
//		lblImage.setBackground(Color.BLACK);
//		파일 확장자 설정

		
		
		
	}

	@Override
	public void addComponent() {
		JPanel pnlNorth = new MyPanel(new GridLayout(2, 1));
		pnlNorth.setBackground(Color.WHITE);
//		북쪽 1행
		pnlNorth.setBorder(new TitledBorder("이미지 복사"));
		JPanel pnlTextButton = new JPanel();
		pnlTextButton.add(txtPath);
		pnlTextButton.add(btnOpen);
		pnlTextButton.add(btnCopy);
		
		
		pnlNorth.add(pnlTextButton);
//		북쪽 2행
		JPanel pnlProgress = new MyPanel();
		pnlProgress.add(progressBar);
		pnlNorth.add(pnlProgress);
		
		
//		가운데
		JPanel pnlCenter = new MyPanel(new BorderLayout());
		pnlCenter.add(lblImage);
		pnlCenter.setBorder(new TitledBorder("복사된 이미지"));
		add(pnlCenter);
		
//		프레임에 부착
		add("North",pnlNorth);
		
		
		
//		파일 대화상자
		fileChooser = new JFileChooser("D:/PJS");
//		파일 확장자 설정
		FileNameExtensionFilter filter = new FileNameExtensionFilter("이미지 파일", "bmp","jpg","gif","PNG");
		fileChooser.setFileFilter(filter);
//		파일 확장자 추가
		filter =  new FileNameExtensionFilter("텍스트파일(*.txt)", "txt");
		fileChooser.addChoosableFileFilter(filter);
		
		
	}

	@Override
	public void addListener() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnCopy.addActionListener(handler);
		btnOpen.addActionListener(handler);
		
	}//addListener
	
	ActionListener handler = new ActionListener() {
		String extnames = "gif,jpg,png";
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source==btnOpen) {//열기
				int option = fileChooser.showOpenDialog(Component03.this);
//				System.out.println(option); // 선택시 0 취소시 1번
				if(option==JFileChooser.APPROVE_OPTION) {
//					선택한 파일
					selectedFile = fileChooser.getSelectedFile();
//					확장자 구하기
					int index = selectedFile.getName().lastIndexOf(".")+1;
					extenstion = selectedFile.getName().substring(index).toUpperCase();
					if(extenstion.indexOf(extnames)==-1) {
						JOptionPane.showMessageDialog(btnOpen, "이미지파일이 아닙니다");
						return;
					}///if
					txtPath.setText(selectedFile.getAbsolutePath());
				}//if
				else {
					
				}//else
				
			}//if
			else {//복사
				if(txtPath.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(btnCopy, "복사할 이미지 파일을 먼저 선택하세요");
				}//
				new ImageCopy().start();
				
				
			}//else
			
			
		}//action
	};//inner 
	
	class ImageCopy extends Thread{
		
		@Override
		public void run() {
			copy();
		}//run

		private void copy() {
//			프로그래스바 최대값을 파일 크기로 설정
			progressBar.setMaximum((int)selectedFile.length());
			try {
				
				BufferedInputStream bis =
						new BufferedInputStream(new FileInputStream(selectedFile));
				
				BufferedOutputStream bos = 
						new BufferedOutputStream(new FileOutputStream("src/swiong27/Copy."+extenstion));
				int data;
				int totalByte = 0;
				
				while((data=bis.read())!=-1) {
					bos.write(data);
					bos.flush();
//					진행률 표시
					progressBar.setValue(totalByte);
				}//while
//				이미지 아이콘 
				
//				Image image = Toolkit.getDefaultToolkit().getImage("src/swiong27/Copy."+extenstion);
				Image image = ImageIO.read(new File("src/swiong27/Copy."+extenstion));
				image = image.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_DEFAULT);
				ImageIcon icon = new ImageIcon(image);
				
				lblImage.setIcon(icon);
				
			}//try
			catch (Exception e) {
				e.printStackTrace();
			}//catch
			
			
			
			
			
			
		}
	}//class
	
	
	@Override
	public Insets getInsets() {
		return new Insets(40, 18, 18, 18);
	}
	
	public static void main(String[] args) {
		new Component03();
	}//main
}//class
