package test.event;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JEditorPane;

import awt26.service.LayoutService;
/*
 * MenuBar는 프레임에 부착,단 프레임에 부착시
 * add()가 아니라 
 * setMenuBar()메소드로 프레임에 부착  
 * Menu는 MenuBar에 add()메소드로 부착 
 * MenuItem은 Menu에 add()메소드로 부착
 * 
 */
public class MenuComponent extends Frame implements LayoutService {
	//[멤버변수]
	private MenuBar menuBar;
	private Menu mFile,mEdit,mHelp,mSubmenu;
	//파일 메뉴에 붙일 메뉴아이템
	private MenuItem miOpen,miSave,miPrint,miExit;
	//편집 메뉴에 붙일 메뉴아이템
	private MenuItem miCopy,miPaste,miCut,miAll;
	//Help메뉴에 붙일 메뉴아이템
	private MenuItem miVersion;
	//텍스트 편집창용
	private TextArea taMemo;
	//파일 열기/저장용 파일 다이얼로그
	private FileDialog fileDialog;
	//버전정보에 사용할 다이얼로그
	private Dialog dialog;
	//버전정보 다이얼 로그에 붙일 버튼
	private Button btnOk;
	
	
	public MenuComponent() {
		//1]타이틀 설정
		super(" 메뉴관련 컴포넌트 연습");
		//2]레이아웃 변경		
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정	
		setSize(650, 650);
		setVisible(true);
	}///////////////////////////////
	@Override
	public void createComponent() {
		//Menu를 붙일 MenuBar생성]
		menuBar = new MenuBar();
		//Menu컴포넌트 생성]
		mFile = new Menu();
		mFile.setLabel("파일");
		mEdit = new Menu("편집");
		mHelp = new Menu("도움말");
		mSubmenu = new Menu("서브메뉴");
		
		//MenuItem컴포넌트 생성]
		miOpen= new MenuItem();
		miOpen.setLabel("열기");
		miSave= new MenuItem("저장",new MenuShortcut(KeyEvent.VK_S));
		miPrint = new MenuItem("인쇄");
		miExit  = new MenuItem("끝내기", new MenuShortcut(KeyEvent.VK_X,true));
		
		miCopy = new MenuItem("복사");
		miPaste = new MenuItem("붙여넣기");
		miCut = new MenuItem("잘라내기");
		miAll = new MenuItem("전체선택");
		
		miVersion = new MenuItem("버전 정보");
		//다이얼그 생성]
		/* Dialog(Frame owner, String title, boolean modal) 
		 * modal이 true이면 모달,
		 * false이면 모달리스(modalless)
		 * 
		 * 모달로 띄우면 해당 다이얼로그를 닫기 
		 * 전까지 다른 UI를 클릭하거나
		 * 접근할수 없음.		
		 */
		dialog = new Dialog(this, "메모장 정보", true);
		dialog.setLayout(new FlowLayout());
		dialog.add(new Label("버전 1.0"));
		dialog.add(btnOk=new Button("확인"));
		dialog.setSize(200, 200);
		
	}

	@Override
	public void addComponent() {
		//프레임에 메뉴바 부착]
		setMenuBar(menuBar);
		//메뉴바에 메뉴부착]
		menuBar.add(mFile);
		menuBar.add(mEdit);
		menuBar.add(mHelp);
		
		//메뉴에 메뉴아이템 부착]
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.add(miPrint);		
		//메뉴에 분리선 추가
		mFile.addSeparator();
		mFile.add(miExit);
		
		mEdit.add(miCopy);
		mEdit.add(miPaste);
		mEdit.add(miCut);
		mEdit.add(miAll);
		//Menu에 Menu를 붙이면 서브메뉴를 만들 수 있다.
		mEdit.add(mSubmenu);
		mSubmenu.add(new MenuItem("서브메뉴1"));
		mSubmenu.add(new MenuItem("서브메뉴2"));
		mSubmenu.add(new MenuItem("서브메뉴3"));
		mSubmenu.add(new MenuItem("서브메뉴4"));
		
		mHelp.add(miVersion);
		
		//프레임에 텍스트에리어 부착]
		add(taMemo=new TextArea());
	}///////////////////

	@Override
	public void addListener() {
		//프레임에 윈도우 리스너 부착
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				System.exit(0);
				
			}
		});/////////
		
		
		//메뉴아이템에 액션 리스너 부착]
		miAll.addActionListener(handler);
		miCopy.addActionListener(handler);
		miCut.addActionListener(handler);
		miExit.addActionListener(handler);
		miOpen.addActionListener(handler);
		miPaste.addActionListener(handler);
		miPrint.addActionListener(handler);
		miSave.addActionListener(handler);
		miVersion.addActionListener(handler);
		
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.dispose();
			}
		});
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();				
			}
		});
	}////////////////////
	private ActionListener handler = new ActionListener() {	
		private String copyNcut;
		private void saveFile(String pathname) {
			try {
				PrintWriter out = 
						new PrintWriter(new FileWriter(pathname),true);
				out.write(taMemo.getText());
				out.close();
			}
			catch(Exception e) {e.printStackTrace();}
		}////////////saveFile
		
		private void openFile(String pathname) {
			File file = new File(pathname);
			
			try {
				char[] cbuf = new char[(int)file.length()];
				BufferedReader br = new BufferedReader(new FileReader(file));
				br.read(cbuf);
				br.close();
				taMemo.setText(String.valueOf(cbuf));
				//모든 파일 읽은 후 파일 첫번째에 캐롯주기]
				//taMemo.requestFocus();
				//taMemo.setCaretPosition(0);
			}
			catch(Exception e) {e.printStackTrace();}
		}///////////openFile
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();
			if(source == miExit) System.exit(0);
			else if(source == miOpen) {
				/*
				 * FileDialog도 Window계열임으로 보이려면
				 * setSize()와 setVisible(true)를 해주어야 함 
				 * 단, FileDialog는 운영체제에서 제공하는 
				 * 다이얼로그를 사용함으로 크기는 설정해봤자 적용 안됨
				 * FileDialog(Frame parent, String title, int mode) 
				 * 
				 * -사용자가 FileDialog의 X버튼이나 취소버튼 클릭시
				 *  dispose됨.
				 */	
				if(fileDialog==null || fileDialog.getMode()==FileDialog.SAVE) {
					fileDialog = new FileDialog(MenuComponent.this,"열기",FileDialog.LOAD);
				}
				//메소드로 타이틀 및 모드 설정]
				fileDialog.setTitle("Open File");
				//fileDialog.setMode(FileDialog.LOAD);
				//초기 디렉토리 설정]
				fileDialog.setDirectory("G:\\CCH");
				//크기적용이 안됨
				//fileDialog.setSize(1000,1000);
				fileDialog.setVisible(true);
				
				setTitle("디렉토리명:"+fileDialog.getDirectory()+",파일명:"+fileDialog.getFile());
				String directory = fileDialog.getDirectory();
				String filename  = fileDialog.getFile();
				if(directory !=null) openFile(directory+filename);
				
			}///miOpen
			else if(source == miSave) {
				if(fileDialog==null || fileDialog.getMode()==FileDialog.LOAD) {
					fileDialog = new FileDialog(MenuComponent.this);
					fileDialog.setTitle("저장");
					fileDialog.setMode(FileDialog.SAVE);
				}
				fileDialog.setVisible(true);
				setTitle("디렉토리명:"+fileDialog.getDirectory()+",파일명:"+fileDialog.getFile());
				String directory = fileDialog.getDirectory();
				String filename  = fileDialog.getFile();
				if(directory !=null) saveFile(directory+filename);
				
			}///miSave
			else if(source == miPrint) {
				JEditorPane pane = new JEditorPane("text/plain",taMemo.getText());
				try {
					pane.print();
				} catch (PrinterException e1) {	e1.printStackTrace();}
			}/////miPrint
			else if(source == miAll) {
				taMemo.setSelectionStart(0);
				taMemo.setSelectionEnd(taMemo.getText().length());
			}///////////////miAll
			else if(source == miCopy) {
				
				copyNcut= taMemo.getSelectedText();
				if(copyNcut !=null || !"".equals(copyNcut)) {
					Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
					StringSelection contents= new StringSelection(copyNcut);
					clipboard.setContents(contents, null);
				}
				
			}/////////////miCopy
			else if(source == miPaste) {
				//클립보드 사용
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				Transferable contents= clipboard.getContents(clipboard);
				if(contents !=null) {
					try {
						String pasteString=(String)(contents.getTransferData(DataFlavor.stringFlavor));
						 //붙여넣을 위치 구하기
						int start = taMemo.getSelectionStart();
						int end   = taMemo.getSelectionEnd();
						//먼저 모든 내용을 버퍼에 담기]
						StringBuffer buffer = new StringBuffer(taMemo.getText());
						//커서가 위치한 곳에 붙여넣기
						if(start==end) {//즉 특정 텍스트를 선택 안한 경우
							buffer.insert(start,pasteString);
						}
						else {//특정 텍스트를 선택한 경우
							 //즉 선택한 텍스트를 복사한 텍스트로 교체
							buffer.replace(start, end, pasteString);
						}
						taMemo.setText(buffer.toString());
					}
					catch(Exception e1) {e1.printStackTrace();}
				}
				
			}/////////////miPaste
			else if(source == miCut) {
				//자를 시작점
				int start = taMemo.getSelectionStart();
				int end   = taMemo.getSelectionEnd();
				//자른 내용 저장
				copyNcut= taMemo.getSelectedText();
				//클립보드에 복사]
				if(copyNcut !=null || !"".equals(copyNcut)) {
					Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
					StringSelection contents= new StringSelection(copyNcut);
					clipboard.setContents(contents, null);
				}
				//자른 내용 반영
				StringBuffer buffer = new StringBuffer(taMemo.getText());
				taMemo.setText(buffer.delete(start, end).toString());
				
			}///////////////////////miCut
			else if(source == miVersion) {
				if(!dialog.isVisible()) dialog.setVisible(true);
			}
			
		}///////////actionPerformed

		

		
	};/////////////클래스

	public static void main(String[] args) {
		new MenuComponent();
	}

}
