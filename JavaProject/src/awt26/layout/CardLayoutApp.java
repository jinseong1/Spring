package awt26.layout;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import awt26.service.LayoutService;

public class CardLayoutApp extends Frame implements LayoutService {

   // 멤버변수
   private CardLayout card;
   private Panel pnlRed, pnlGreen, pnlBlue;
   private Button btnPrevious, btnNext;
   private TextField textSsn1, textSsn2;

   public CardLayoutApp() {
      // 1.타이틀 설정
      setTitle("카드레이아웃/마우스 및 텍스트 이벤트 연습");
      //2.레이아웃 변경
      setLayout(card=new CardLayout());
      //3.컴퍼넌트 생성
      createComponent();
      //4.컴퍼넌트 부착
      addComponent();
      //5.리스너 부착
      addListener();
      //6.크기 및 보이기 설정
      setSize(400, 400);
      setVisible(true);
      
   }//////////////////////////

   @Override
   public void createComponent() {
      //패널 생성
      pnlRed = new Panel();
      pnlRed.setBackground(Color.RED);
      pnlGreen = new Panel(null);//레이아웃 해제
      pnlGreen.setBackground(new Color(0,255,0));
      pnlBlue = new Panel();
      pnlBlue.setBackground(Color.BLUE);
      //버튼 생성
      btnPrevious = new Button("이전");
      btnNext = new Button("다음");
      //텍스트 필드
      textSsn1 = new TextField();
      textSsn2 = new TextField();
      
      
   }

   @Override
   public void addComponent() {
      //프레임에 패널부착
      add(pnlRed);
      textSsn1.setBounds(70,90,120,30);
      textSsn2.setBounds(200,90,120,30);
      pnlGreen.add(textSsn1);
      pnlGreen.add(textSsn2);
      
      btnPrevious.setBounds(70, 300, 120, 30);
      btnNext.setBounds(195,300,120,30);
      pnlGreen.add(btnPrevious);
      pnlGreen.add(btnNext);
      
      add(pnlGreen);
      add(pnlBlue);
      
      
   }

   @Override
   public void addListener() {
      //프레임에 윈도우 리스너 부착
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
      //패널에 마우스 부착
      pnlRed.addMouseListener(handler);
      pnlGreen.addMouseListener(handler);
      pnlBlue.addMouseListener(handler);
      
      btnPrevious.addActionListener(handler);
      btnNext.addActionListener(handler);
      
      textSsn1.addTextListener(handler);
   }//////////////////////////////
   
         
   private EventHandler handler = new EventHandler();
   class EventHandler implements MouseListener,ActionListener,TextListener{
      //MouseEvent발생시 자동으로 호출되는 콜백 메소드들
      //마우스를 눌렀다 떼는데 누른 지점에서 뗏을 때만 호출됨
      @Override
      public void mouseClicked(MouseEvent e) {
         //System.out.println("mouseClicked");
         
      }

      @Override
      public void mousePressed(MouseEvent e) {
         //System.out.println("mousePressed");
         int which=e.getButton();
         if(which == MouseEvent.BUTTON1) {
            setTitle("마우스 왼쪽 버튼 클릭");
            card.next(CardLayoutApp.this);
         }
         else if(which == MouseEvent.BUTTON2) {
            setTitle("휠 버튼 클릭");
            card.first(CardLayoutApp.this);
         }
         else if(which == MouseEvent.BUTTON3) {
            setTitle("마우스 오른쪽 버튼 클릭");
            card.previous(CardLayoutApp.this);
         }
      }/////////////////////마우스 프레스

      @Override
      public void mouseReleased(MouseEvent e) {//마우스를 눌렀다가 뗏을 때
         //System.out.println("mouseReleased");
         
      }

      @Override
      public void mouseEntered(MouseEvent e) {//컴퍼넌트 영역에 들어왔을 때
         //System.out.println("mouseEntered");
         
      }

      @Override
      public void mouseExited(MouseEvent e) {//컴퍼넌트 영역에서 벗어났을 때
         if(e.getSource()==btnNext)
        	 card.next(CardLayoutApp.this);
         
      }

      @Override
      public void textValueChanged(TextEvent e) {
         if(textSsn1.getText().length()==6) {
        	 textSsn2.requestFocus();
         }
         
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         
      }
      
   }////////////////////////
   
   public static void main(String[] args) {
      new CardLayoutApp();

   }////////////////////////// main


}///////////////////////////// class