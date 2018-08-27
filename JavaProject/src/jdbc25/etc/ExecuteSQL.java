package jdbc25.etc;

import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import jdbc25.service.IConnectImpl;

public class ExecuteSQL extends IConnectImpl {
	Scanner sc = new Scanner(System.in);
	Date today = new Date();
	SimpleDateFormat date = new SimpleDateFormat("M"+"월"+" dd HH:mm:ss yyyy");
	Calendar cal = Calendar.getInstance();
	int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
	
	
	
	
	/*
	사용자로부터 명령문을 입력 받아 ; or conn을 확인하는 장치입니다.
	*/
	@Override
	public String getQueryString() {
	String sql="";
	int count=1;
	System.out.print("SQL> ");
	 
	while(!(sql+=sc.nextLine()).trim().endsWith(";")) {
		if(sql.trim().toUpperCase().startsWith("CONN") || sql.trim().toUpperCase().startsWith("EXIT")) {
			if(sql.contains("/")) {
			sql+=";";
			break;
			}
		sql+=";";
		break;
		}
		else if(!sql.endsWith(" ")) {sql+=" ";}
		count++;
		System.out.printf("%-4s",count);
	}//while
	return sql.substring(0, sql.length()-1);
	}
	
	@Override
	public void execute() throws Exception {
		while(true) {
			try {
				System.out.println("Microsoft Windows [Version 10.0.17134.112]");
				System.out.println("(c) 2018 Microsoft Corporation. All rights reserved.");
				System.out.println();
				System.out.print("SQL*Plus: Release 11.2.0.1.0 Production on ");
				switch (dayWeek) {
					case 1:System.out.print("일 ");	break;
					case 2:System.out.print("월 ");	break;
					case 3:System.out.print("화 ");	break;
					case 4:System.out.print("수 ");	break;
					case 5:System.out.print("목 ");	break;
					case 6:System.out.print("금 ");	break;
					default:System.out.print("토 ");}
				System.out.println(date.format(today));
				System.out.println();
				System.out.println("Copyright (c) 1982, 2010, Oracle.  All rights reserved.");
				System.out.println();
				
				
				System.out.print("사용자명 입력 : ");
				String id = sc.nextLine();
				System.out.print("비밀번호 입력 : ");
				String pass = sc.nextLine();
				conn=DriverManager.getConnection(ORACLE_URL, id, pass);
				System.out.println("다음에 접속됨 :");
				System.out.println("Oracle Database 11g Enterprise Edition Release 11.2.0.1.0 - 64bit Production");
				System.out.println("With the Partitioning, OLAP, Data Mining and Real Application Testing options");
				break;
			}
			catch (Exception e) {
				System.out.println("ERROR:");
				System.out.println("ORA-01017: invalid username/password; logon denied");
				System.out.println();
			}
		}

		while(true) {
		try {
			while(true) {
					//1]쿼리문 준비
					String query = getQueryString();
					if("EXIT".equalsIgnoreCase(query.trim())) {
						System.out.println("Oracle Database 11g Enterprise Edition Release 11.2.0.1.0 - 64bit Production\r\n" + 
								"With the Partitioning, OLAP, Data Mining and Real Application Testing options에서 분리되었습니다.");
						close();
						System.exit(0);
						
					}
//					conn or conn id/pass 접속 시도
					  if(query.trim().toUpperCase().startsWith("CONN")) {
						  try {
//							  conn으로 검색 후 "/"가 있을 경우 아이디 및 비밀번호 찾아 접속시도
							  if(query.contains("/")) {
										 int name =query.indexOf(" ")+1;
										 int endIndex =query.indexOf("/");
										 String connid= query.substring(name, endIndex);
										 String connpass= query.substring(endIndex+1,query.length());
										 conn=DriverManager.getConnection(ORACLE_URL, connid, connpass);
										 System.out.println("연결되었습니다.");
										 continue;
							  }
							  System.out.print("사용자명 입력 : ");
							  String id = sc.nextLine();
							  System.out.print("비밀번호 입력 : ");
							  String pass = sc.nextLine();
							  conn=DriverManager.getConnection(ORACLE_URL, id, pass);
							  System.out.println("연결되었습니다.");
						  }
						  catch (Exception e) {
							  System.out.println("ERROR:");
							  System.out.println("ORA-01017: invalid username/password; logon denied");
							  System.out.println();
							  System.out.println("경고: 이제는 ORACLE에 연결되어 있지 않습니다.");
						  }
						  continue;
					  }

					psmt = conn.prepareStatement(query);
					boolean bFlag=psmt.execute();
					if(bFlag) {
						rs=psmt.getResultSet();
						ResultSetMetaData rsmd= rs.getMetaData();
						int columnCount =rsmd.getColumnCount();
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
							 for(int i=0; i<dash ; i++) {	 
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
						}////while
					}
					else {//기타 쿼리문
						  //영향받은 행의 수 얻기]
						  int affected=psmt.getUpdateCount();
						  if(query.trim().toUpperCase().startsWith("UPDATE")) {
							  System.out.println(affected+"개의 행이 수정되었습니다");
						  }
						  else if(query.trim().toUpperCase().startsWith("DELETE")) {
							  System.out.println(affected+"개의 행이 삭제되었습니다");
						  }
						  else if(query.trim().toUpperCase().startsWith("INSERT")) {
							  System.out.println(affected+"개의 행이 만들어졌습니다");
						  }
						  
					}///////else		
			}////////////while
		}//in try
			catch(Exception e) {
				System.out.println(e.getMessage());
			}//catch
		}//out try
		//finally {close();}//한번 실행할때 
	}///////////
	public static void main(String[] args) throws Exception {
		new ExecuteSQL().execute();
	}///////////////main

}///////////////////class
