package jdbc25.etc;


import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.List;
import java.util.Vector;
import jdbc25.service.IConnectImpl;

public class ResultSetMetaDataSQL extends IConnectImpl{

	@Override
	public void execute() throws Exception {
		try {
			//0]데이타베이스 연결
			connect(ORACLE_URL, "SAMPLE","SAMPLE");
			//1]쿼리문 준비
			String sql=this.getQueryString();
			//2]PreparedStatement객체 생성
			psmt = conn.prepareStatement(sql);
			//3]쿼리 실행
			rs=psmt.executeQuery();
			/* SELECT쿼리 실행시 컬럼에 대한 정보 얻기*/
			//가]ResultSet객체의 getMetaData()로 ResultSetMetaData얻기
			ResultSetMetaData rsmd= rs.getMetaData();
			//나]총 컬럼수 얻기-ResultSetMetaData의 int getColumnCount()
			int columnCount =rsmd.getColumnCount();
			System.out.println("총 컬럼 수 :"+columnCount);
			//다]컬럼명 얻기-ResultSetMetaData의 String getColumnName(int column)
			for(int index =1 ; index <= columnCount ;index++) {
				String columnName=rsmd.getColumnName(index);
				int length = columnName.length()+2;//2씩 여백 
				System.out.print(String.format("%-"+length+"s",columnName));
			}////////////for
			//라]컬럼타입 얻기-int getColumnType(int column)
			//   타입과 관련된 상수는 java.sql.Types클래스에 정의됨.
			System.out.println("\r\n[자바의 컬럽타입으로 얻기]");
			for(int index =1 ; index <= columnCount ;index++) {
				int columnType=rsmd.getColumnType(index);
				switch(columnType) {
					case Types.VARCHAR:
						System.out.println("오라클의 VARCHAR2");break;
					case Types.NVARCHAR:
						System.out.println("오라클의 NVARCHAR2");break;
					case Types.CHAR:
						System.out.println("오라클의 CHAR");break;
					case Types.NCHAR:
						System.out.println("오라클의 NCHAR");break;
					case Types.NUMERIC:
						System.out.println("오라클의 NUMBER");break;
					case Types.TIMESTAMP:
						System.out.println("오라클의 DATE");break;
					default:System.out.println("오라클의 기타 자료형");
				
				}//////switch
			}////////////////for
			//마]String getColumnTypeName(int column)
			//오라클의 타입명으로 반환
			System.out.println("[오라클의 컬럽타입으로 얻기]");
			for(int index =1 ; index <= columnCount ;index++) {
				String columnTypeName=rsmd.getColumnTypeName(index);
				System.out.println(columnTypeName);				
			}//for
			//바]컬럼의 NULL허용여부 :int isNullable(int column) 
			//   NULL허용 :1,NOT NULL:0
			System.out.println("[컬럼의 널 여부 얻기]");
			for(int index =1 ; index <= columnCount ;index++) {
				int isNull=rsmd.isNullable(index);
				System.out.println(isNull==1 ?"널 허용":"NOT NULL");
			}////////////for
			//사]컬럼의 크기 얻기 -getPrecision(int colimn)
			//()괄호 없는 자료형은 0반환
			System.out.println("[컬럼의 크기 얻기-()안의 숫자]");
			for(int index =1 ; index <= columnCount ;index++) {
				int columnSize=rsmd.getPrecision(index);
				System.out.println("컬럼 크기:"+columnSize);				
			}
			//각 컬럼의 자리수 설정하기
			/*
			 * 오라클처럼
			 * NUMBER타입은 10자리
			 * DATE타입은 10자리(단,오라클은 8자리)
			 * CHAR게열는 해당 자리수로 설정하는데
			 * 단 NCHAR계열은 자리수의 2배로 설정
			 * 오라클 처럼 컬럼명 밑에  ---------  를 표시하기위한 작업
			 */
			 List<Integer> columnDash = new Vector<Integer>();
			 for(int index =1 ; index <= columnCount ;index++) {
				//컬럼타입]
				 int types = rsmd.getColumnType(index);
				//컬럼의 자리수]
				 int length = rsmd.getPrecision(index);
				 switch(types) {
				 	case Types.NCHAR:
				 	case Types.NVARCHAR:
				 		columnDash.add(length*2);break;
				 	case Types.TIMESTAMP:
				 	case Types.NUMERIC:
				 		columnDash.add(10);break;
				 	default:columnDash.add(length);
				 }//switch			 
			 }//for
			//컬럼명 출력]
			 for(int index =1 ; index <= columnCount ;index++) {
				 String columnName =rsmd.getColumnName(index).length() > columnDash.get(index-1)
						            ? rsmd.getColumnName(index).substring(0,columnDash.get(index-1)) 
						            :rsmd.getColumnName(index);
				 System.out.print(String.format(
						 "%-"+(columnDash.get(index-1)+1)+"s", 
						 columnName ));
			 }////////////for
			 System.out.println();//줄바꿈
			//(-)DASH출력]
			 for(Integer dash : columnDash) {
				 for(int i=0; i < dash;i++) {	 
					 System.out.print("-");
				 }
				 System.out.print(" ");				
			 }//////////////////////////
			 System.out.println();//줄바꿈
			//레코드 출력]
			while(rs.next()) {
				//각 컬럼값 뽑아오기]
				 for(int index =1 ; index <= columnCount ;index++) {
					 int type=rsmd.getColumnType(index);
					 if(type == Types.TIMESTAMP) {
						System.out.print(String.format("%-10s",rs.getDate(index)==null ? "" :rs.getDate(index))); 
					 }
					 else {
						 System.out.print(String.format("%-"+(columnDash.get(index-1)+1)+"s",rs.getString(index)==null ? "":rs.getString(index) ));  
					 }
				 }/////////////for
				 System.out.println();//줄바꿈
			}/////////////////////////
			 
		}///try
		finally {close();}
	}/////////
	public static void main(String[] args) throws Exception {
		new ResultSetMetaDataSQL().execute();

	}///////////main
	
}//////////////class
