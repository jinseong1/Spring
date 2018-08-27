<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8 />
<title>ErrorIndex.jsp</title>
</head>
<body>
	<fieldset>
		<legend>web.xml의 설정을 통한 예외처리</legend>
		<%
		/*
		//방법1 try catch
		try{
		out.println("파라미터 길이"+request.getParameter("name").length());
		 }
		catch(Exception e){
			out.println("관리자에게 문의하세요");
		}
		*/
		//방법 2 errorpage 사용
		
		//방법 3 web.xml의 설정으로 예외처리 
		//개발 완료 후 범용적인 에러 처리시
		//
		out.println("파라미터 길이"+request.getParameter("name").length());
		
		
		
		
		
		%>
		
		
		
	</fieldset>
</body>
</html>