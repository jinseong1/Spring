package swing27;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import awt26.service.LayoutService;

public class Component05 extends JFrame implements LayoutService {
//	멤버변수
	JTable table;
//	테이블에 표시할 데이터
	Object[][] rowData = {
			{"김길동",20,"가산동",new Date()},
			{"나길동",30,"나산동",new Date()},
			{"다길동",50,"다산동",new Date()},
			{"라길동",25,"라산동",new Date()}};
	
//	컬럼명으로 시작할 데이터
	Object[] columnNames = {"이름","나이","주소","가입일"};
//	Model에 해당하는 클래스
	DefaultTableModel model;
	
//	테이블의 데이터로 사용할 컬렉션
	Vector<Vector> dataVector = new Vector<Vector>();
//	테이블의 컬럼명으로 사용할 컬렉션
	Vector<String> columnVector = new Vector<String>();
//	
	
	
	
	
	public Component05() {
		//1]타이틀 설정
		super("Swing컴포넌트 연습05");	
		//2]레이아웃 변경	
		//3]컴포넌트 생성
		createComponent();
		//4]컴포넌트 부착
		addComponent();
		//5]리스너 부착
		addListener();
		//6]크기 및 보이기 설정	
		setSize(500, 300);
		setVisible(true);
	}

	@Override
	public void createComponent() {
//		데이블 객체 생성 방법 1 가장 많이 사용함
		table = new JTable(rowData, columnNames);
//		테이블 객체 생성 방법 2
//		table = new JTable();
//		table.setBackground(Color.YELLOW);
//		model = new DefaultTableModel();
//		model.setDataVector(rowData, columnNames);
//		table.setModel(model);
//		데이블 객체 생성 방법 3
//		table = new JTable();
//		table.setBackground(Color.YELLOW);
//		데이터 준비
//		Vector firstVec = new Vector();
//		firstVec.add("가길동");
//		firstVec.add(20);
//		firstVec.add("가산동");
//		firstVec.add(new Date());
//		
//		Vector secondVec = new Vector();
//		secondVec.add("나길동");
//		secondVec.add(25);
//		secondVec.add("나산동");
//		secondVec.add(new Date());
//		
//		Vector thirdVec = new Vector();
//		thirdVec.add("다길동");
//		thirdVec.add(35);
//		thirdVec.add("다산동");
//		thirdVec.add(new Date());
//		
//		dataVector.add(firstVec);
//		dataVector.add(secondVec);
//		dataVector.add(thirdVec);
//		컬럼데이터
//		columnVector.addElement("이름");
//		columnVector.addElement("나이");
//		columnVector.addElement("주소");
//		columnVector.addElement("가입일");
//		
//		model.setDataVector(dataVector, columnVector);
//		table.setModel(model);
		
		JTableHeader tableHeader = table.getTableHeader();
//		테이블 배경색
		table.setBackground(Color.YELLOW);
//		컬럼 배경색
		tableHeader.setBackground(Color.RED);
//		컬럼명 색갈 변경
		tableHeader.setForeground(Color.GREEN);
//		글씨체
		Font font = new Font("굴림체",Font.BOLD,16);
		tableHeader.setFont(font);
//		컬럼명 드레그로 변경 금지하기
		tableHeader.setReorderingAllowed(false);
//		컬렴명의 컬럼 가로 폭 변경 못하게
		tableHeader.setResizingAllowed(false);
//		컬럼 가로세로 폭 지정 가로는 지정 안되나 세로는 지정 됨
		tableHeader.setPreferredSize(new Dimension(1000, 50));
		
		TableColumnModel columnModel = table.getColumnModel();
//		컴럼폭 조정
		System.out.println("총 컬럼 수 : "+table.getColumnCount());
		int columnCount = columnModel.getColumnCount();
		TableColumn tableColumn[] = new TableColumn[columnCount];
		for(int i=0;i<columnCount;i++) {
			tableColumn[i] = columnModel.getColumn(i);
		}
//		컬럼 가로 폭 지정 방법 1
//		tableColumn[0].setPreferredWidth(90);//name
//		tableColumn[1].setPreferredWidth(50);//age
//		tableColumn[3].setPreferredWidth(200);//가입일
//		컬럼 가로 폭 지정 방법 2
		tableColumn[0].setWidth(90);
		tableColumn[1].setWidth(50);
		tableColumn[3].setWidth(200);
		tableHeader.setResizingColumn(tableColumn[0]);
		tableHeader.setResizingColumn(tableColumn[1]);
		tableHeader.setResizingColumn(tableColumn[3]);
//		데이터 가운데, 중앙, 오른쪽 정령 방법
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(JLabel.CENTER);
		for(int i=0;i<columnCount;i++) {
			if(i != 2) {
				tableColumn[i].setCellRenderer(dtcr);
			}
		}
//		데이터 칸 높이 조정 보기 좋음 많이 사용함
		table.setRowHeight(30);
		setTitle(table.getValueAt(1, 2).toString());
//		※※단 모델로 사용한 컬렉션의 데이타는 수정되 있다※※
		table.setValueAt("세종시", 1, 2);
		
	}

	@Override
	public void addComponent() {
		add(new JScrollPane(table));
		
		
	}

	@Override
	public void addListener() {
//		종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Component05();
	}//main
}//class
