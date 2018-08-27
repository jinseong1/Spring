package awt26.component;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxMenuItem;
import java.awt.Choice;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.PrintJob;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.InvalidDnDOperationException;
import java.awt.dnd.peer.DragSourceContextPeer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.awt.im.InputMethodHighlight;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.peer.ButtonPeer;
import java.awt.peer.CanvasPeer;
import java.awt.peer.CheckboxMenuItemPeer;
import java.awt.peer.CheckboxPeer;
import java.awt.peer.ChoicePeer;
import java.awt.peer.DesktopPeer;
import java.awt.peer.DialogPeer;
import java.awt.peer.FileDialogPeer;
import java.awt.peer.FontPeer;
import java.awt.peer.FramePeer;
import java.awt.peer.LabelPeer;
import java.awt.peer.ListPeer;
import java.awt.peer.MenuBarPeer;
import java.awt.peer.MenuItemPeer;
import java.awt.peer.MenuPeer;
import java.awt.peer.PanelPeer;
import java.awt.peer.PopupMenuPeer;
import java.awt.peer.ScrollPanePeer;
import java.awt.peer.ScrollbarPeer;
import java.awt.peer.TextAreaPeer;
import java.awt.peer.TextFieldPeer;
import java.awt.peer.WindowPeer;
import java.awt.print.PrinterException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import javax.swing.JEditorPane;

import awt26.service.LayoutService;

public class MenuComponent extends Frame implements LayoutService {
   // 멤버변수]
   private MenuBar menuBar;
   private Menu mFile, mEdit, mHelp, mSubmenu;
   // 파일 메뉴에 붙일 메뉴아이템
   private MenuItem miOpen, miSave, miPrint, miExit;

   private MenuItem miCopy, miPaste, miCut, miAll;
   // Help메뉴에 붙일 메뉴아이템
   private MenuItem miVersion;
   // 텍스트 편집창용
   private TextArea taMemo;
   // 파일 열기/저장용 파일 다이얼로그
   private FileDialog fileDialog;
   // 버전 정보에 사용될 다이얼로그
   private Dialog dialog;
   // 버전 정보 다이얼 로그에 붙일 버튼
   private Button btnOk;

   public MenuComponent() {
      // 1]타이틀 설정
      super("메뉴관련 Component 연습");
      // 2]레이아웃 변경
      // 3]컴포넌트 생성
      createComponent();
      // 4]컴포넌트 부착
      addComponent();
      // 5]리스너 부착
      addListener();
      // 6]크기 및 보이기 설정
      setSize(560, 650);
      setVisible(true);
   }/////////////

   @Override
   public void createComponent() {
      // Menu를 붙일 MenuBar생성]
      menuBar = new MenuBar();
      // Menu컴포넌트 생성]
      mFile = new Menu();
      mFile.setLabel("파일");
      mEdit = new Menu("편집");
      mHelp = new Menu("도움말", true);
      mSubmenu = new Menu("서브메뉴");

      // MenuItem컴포넌트 생성]
      miOpen = new MenuItem();
      miOpen.setLabel("열기");
      miSave = new MenuItem("저장", new MenuShortcut(KeyEvent.VK_S));
      miPrint = new MenuItem("인쇄");
      miExit = new MenuItem("끝내기", new MenuShortcut(KeyEvent.VK_X, true));

      miCopy = new MenuItem("복사");
      miPaste = new MenuItem("붙여넣기");
      miCut = new MenuItem("잘라내기");
      miAll = new MenuItem("전체선택");

      miVersion = new MenuItem("버전 정보");

      dialog = new Dialog(this, "메모장 정보", true);
      dialog.setLayout(new FlowLayout());
      dialog.add(new Label("버전 1.0"));
      dialog.add(btnOk = new Button("확인"));
      dialog.setSize(200, 200);

   }//////////////

   @Override
   public void addComponent() {
      // 프레임에 메뉴바 부착]
      setMenuBar(menuBar);
      // 메뉴바에 메뉴 부착
      menuBar.add(mFile);
      menuBar.add(mEdit);
      menuBar.add(mHelp);

      // 메뉴에 메뉴아이템 부착]
      mFile.add(miOpen);
      mFile.add(miSave);
      mFile.add(miPrint);
      // 메뉴에 분리선 추가
      mFile.addSeparator();
      mFile.add(miExit);
      //
      mEdit.add(miCopy);
      mEdit.add(miPaste);
      mEdit.add(miCut);
      mEdit.add(miAll);
      mEdit.addSeparator();
      // Menu에 Menu를 붙이면 서뷰메뉴를 만들 수 있다.
      mEdit.add(mSubmenu);
      mSubmenu.add(new MenuItem("서브메뉴1"));
      mSubmenu.add(new MenuItem("서브메뉴2"));
      mSubmenu.add(new MenuItem("서브메뉴3"));
      mSubmenu.add(new MenuItem("서브메뉴4"));

      mHelp.add(miVersion);
      // 프레임에 텍스트에어리어 추가
      add(taMemo = new TextArea());
   }/////////////

   @Override
   public void addListener() {
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });

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
   }//////////////

   private ActionListener handler = new ActionListener() {
      
	   
	   
      private void openFile(String pathname) {
    	  
    	  File file = new File(pathname);
    	  
			try {
				char[] cbuf = new char[(int)file.length()];			
				BufferedReader br = new BufferedReader(new FileReader(file));
				br.read(cbuf);
				br.close();
				taMemo.setText(String.valueOf(cbuf));
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
      }

      @Override
      public void actionPerformed(ActionEvent e) {
    	 String copyNcut;
         Object source = e.getSource();
         if (source == miExit)
            System.exit(0);
         else if (source == miOpen) {
            if (fileDialog == null || fileDialog.getMode() == FileDialog.SAVE) {
               fileDialog = new FileDialog(MenuComponent.this, "열기", FileDialog.LOAD);
            }
            // 메소드로 타이틀 및 모드 설정]
            fileDialog.setTitle("Open File");
            fileDialog.setMode(FileDialog.LOAD);
            fileDialog.setDirectory("D:\\CSU");
            // 크기적용이 안됨
            // fileDialog.setSize(1000,1000);

            fileDialog.setVisible(true);

            setTitle("디렉토리명: " + fileDialog.getDirectory() + "파일명: " + fileDialog.getFile());
            String directory = fileDialog.getDirectory();
            String filename = fileDialog.getFile();
            if (directory != null)
               openFile(directory + filename);
         } ///////// else if miopen
         else if(source == miSave) {
        	 if (fileDialog == null || fileDialog.getMode() == FileDialog.LOAD) {
                 fileDialog = new FileDialog(MenuComponent.this);
                 fileDialog.setTitle("저장");
                 fileDialog.setMode(FileDialog.SAVE);
              }
        	 fileDialog.setVisible(true);
             setTitle("디렉토리명: " + fileDialog.getDirectory() + "파일명: " + fileDialog.getFile());
             String directory = fileDialog.getDirectory();
             String filename = fileDialog.getFile();
             if (directory != null) {
            	 saveFile(directory+filename);
             }
             
         }////////miSave
         else if(source==miPrint) {
        	 JEditorPane pane = new JEditorPane("text/plain",taMemo.getText());
        	 try {
				pane.print();
			} catch (PrinterException e1) {e1.printStackTrace();}
         }///////miPint
         else if(source ==miAll) {
        	 taMemo.setSelectionStart(0);
        	 taMemo.setSelectionEnd(taMemo.getText().length());
         }/////////////miAll
         else if(source==miCopy) {
        	 
        	 copyNcut = taMemo.getSelectedText();
        	 if(copyNcut!=null ||!"".equals(copyNcut)) {
        		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        		StringSelection contains = new StringSelection(copyNcut);
        		clipboard.setContents(contains, null);
        		
        		
        	 }
 	 
        	 
         }////////miCopy
         else if(source==miPaste) {
        	 
         	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
         	Transferable contents = clipboard.getContents(clipboard);
         	if (contents!=null) {
         		try {
				String pasetStirng = (String)(contents.getTransferData(DataFlavor.stringFlavor));
				int start = taMemo.getSelectionStart();
				int end = taMemo.getSelectionEnd();
				StringBuffer buffer = new StringBuffer(taMemo.getText());
					if(start==end) {
						buffer.insert(start,pasetStirng);
					}
					else {
						buffer.replace(start, end, pasetStirng);
					}
					taMemo.setText(buffer.toString());
         		}
         		catch (Exception e1) {
					e1.getMessage();
				}
			}
         	
		
         	
     	}////////mipaste
         else if(source==miCut) {
				int start = taMemo.getSelectionStart();
				int end = taMemo.getSelectionEnd();
				
				copyNcut = taMemo.getSelectedText();
	        	 if(copyNcut!=null ||!"".equals(copyNcut)) {
	        		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        		StringSelection contains = new StringSelection(copyNcut);
	        		clipboard.setContents(contains, null);
	        	 }
	        	 
	        	 StringBuffer buffer = new StringBuffer(taMemo.getText());
	        	 taMemo.setText(buffer.delete(start, end).toString());
        	 
         }///////miCut
         
         else if(source==miVersion) {
        	 if(!dialog.isVisible()) dialog.setVisible(true);
        	 
        	 
         }///////miVersion
         
         
      }///////// actionPerformed

	private void saveFile(String pathname) {
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(pathname),true);
			out.write(taMemo.getText());
			out.close();
		}
		catch (IOException e) {
		}
		
	}

   };//////////// 익명 클래스

   public static void main(String[] args) {
      new MenuComponent();

   }//////// main

}/////////// class