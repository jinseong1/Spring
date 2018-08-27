<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="jdk.internal.org.objectweb.asm.tree.IntInsnNode"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
커넥션 풀을 이용한 커넥션 객체 사용]
-톰캣 서버가 커넥션 pool에 미리 생성해 놓은 
connection객체를 갖다 사용하는것
*/
	//1]InitialContext객체 생성(Context>InitialContext)
	Context ctx= new InitialContext();
	//2]
	//Context envctx = (Context)ctx.lookup("java:comp/env");
	//3]context.xml에 등록한 네이밍을 lookup
	//DataSource source = (DataSource)envctx.lookup("jdbc/jsp");
	DataSource source = (DataSource)ctx.lookup("java:comp/env/jdbc/jsp");
	
	//4]
	Connection conn = source.getConnection();
	
	String connectionString;
	if(conn!=null) connectionString = "<h3>데이타 베이스 연결 성공:"+ conn+"</h3>";
	else connectionString="<h3>데이타 베이스 연결 실패</h3>";
	//5]커넥션 풀에 사용한 커넥션 객체 다시 반납 (메모리 해제가 아님)
	if(conn!=null) conn.close();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>ConnectionPool.jsp</title>
</head>
<body>
	<fieldset>
		<legend>커넥션 풀</legend>
		<%=connectionString %>
	</fieldset>
</body>
</html>