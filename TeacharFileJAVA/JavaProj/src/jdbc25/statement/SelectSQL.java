package jdbc25.statement;

import java.sql.SQLException;

import jdbc25.service.IConnectImpl;

public class SelectSQL extends IConnectImpl {

	public SelectSQL(String url,String user,String password) {
		//super(url,user,password);
		connect(url,user,password);
	}/////////////////// SelectSQL()	
	@Override
	public void execute() throws Exception {
		try {
			//1]Statement 객체 생성
			stmt = conn.createStatement();
			//2]쿼리문 작성
			//2-1]여러개 레코드를 반환하는 SELECT문
			//String sql="SELECT * FROM emp ORDER BY hiredate desc";
			//2-2]한 개의 레코드를 반환하거나 '선택된 레코드가 없습니다'라고
			//    반환하는 경우 - 주로 PK로 검색하는 경우
			//String sql="SELECT * FROM emp WHERE empno="+getValue("사원번호");
			//2-3]무조건 레코드 하나 반환하는 경우-그룹함수 사용시
			//String sql ="SELECT AVG(sal) FROM emp";
			//2-4]LIKE 연산자를 포함한  SELECT문
			 /*
			 * 자바코드에서 like연산자 사용법
			 * ※[PreparedStatement객체 사용시]
			 * -오라클
			 *  
			 *  LIKE '%A%' :A로 시작하거나 A로끝나거나 A가 중간에 포함되거나
			 *  LIKE '%A' :A로 끝나는 경우
			 *  LIKE 'A%' :A로 시작
			 *  
			 * -자바
			 *  LIKE  '%' || 'A' || '%'
			 *  LIKE '%' || 'A'
			 *  LIKE 'A' || '%'
			 * 
			 */
			//String sql="SELECT * FROM emp WHERE ename LIKE '%"+getValue("찾는 문자열")+"%'";
			String sql ="SELECT * FROM emp WHERE ename LIKE '%' || '"+getValue("찾는 문자열")+"' || '%'";
			//3]쿼리 실행
			rs=stmt.executeQuery(sql);
			/*
			SELECT문 실행시 실행결과는 ResultSet타입의 객체에
			저장됨. 최초 커서는 첫번째 레코드 바로 위에 가 있다.
			ResultSet객체의 next()메소드로 커서를 아래로 이동시키면서
			더이상 꺼내올 레코드가 없을때까지 반복하면서 추출			
			
			ResultSet객체의 getXXX()계열 메소드로
			해당 레코드의 각 컬럼에 저장된 값을 읽어 온다.
			예를들면
			
		  	----------------------+------------------------------
		     ORACLE자료형         |       ResultSet
		     ---------------------+----------------------------
		     NUMBER               |     getInt(인덱스 혹은 컬럼명)
		     ---------------------+-------------------------------
		     CHAR/NCHAR           |
		     VARCHAR2/NVARCHAR2   |     getString(인덱스 혹은 컬러명)
		     ---------------------+---------------------------------
		     DATE                 |     getDate(인덱스 혹은 컬러명)
		     ---------------------+---------------------------------
		 	 인덱스는 SQL에서는 1부터 시작
		            ※단,ORACLE의 자료형에 상관없이 getString(인덱스 혹은 컬러명)
		            으로 읽어와도 무방하다.			     
			 */
		
			/*
			
			 * 오라클에 저장된 데이타가 없는 경우 즉 null 인 경우			 * 
			 * rs.getInt(인덱스번호 혹은 컬럼명) 는 0 반환
			 * rs.getString(인덱스번호 혹은 컬럼명)는 null 반환
			 */
			
			//3-1]여러개 레코드를 반환하는 경우	
			while(rs.next()) {//더 이상 꺼내올 레코드가 없을때까지 반복
				int empno = rs.getInt(1);
				String ename = rs.getString("ename");
				String job   = rs.getString("job");
				//오라클의 Date타입을 getDate()로 가져오는 경우]
				//-년월일만 반환
				//java.sql.Date hiredate= rs.getDate(5);
				
				//오라클의 Date타입을 getString()로 가져오는 경우]
				//-시분초까지 반환.
				String hiredate = rs.getString(5) !=null ? rs.getString(5).substring(0, 10):"";
				
				System.out.println(String.format(
						"%-5d%-10s%-10s%s",empno,ename,job,hiredate));
				
			}//////////////while

			/*
			//3-2]한 개의 레코드를 반환하거나 '선택된 레코드가 없습니다'라고
			//    반환하는 경우
			if(rs.next()) {				
				System.out.println(String.format(
						"%-5s%-10s%-10s%s",rs.getString(1),
						                   rs.getString("ename"),
						                   rs.getString("job"),
						                   rs.getDate(5)
						));
			}
			else System.out.println("해당 사원번호가 없습니다");
			*/
			/*
			//3-3]무조건 레코드 하나 반환하는 경우
			rs.next();
			System.out.println("평균 연봉:"+rs.getFloat(1));
			*/
		}////////////////////try 
		catch (SQLException e) {e.printStackTrace();}
		finally {close();}
		
	}////////////////////////////execute()
	
	public static void main(String[] args) throws Exception {
		new SelectSQL(ORACLE_URL, "SCOTT", "scott").execute();
	}//////////////////main

}/////////////////////class
