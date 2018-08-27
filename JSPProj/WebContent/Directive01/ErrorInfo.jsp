<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>ErrorInfo.jsp</title>
</head>
<body>
	<fieldset>
		<legend>에러발생</legend>
		<h2>관리자에게 문의하세요</h2>
		<h3>에러 내용</h3>
		<!-- 
			exception내장객체는 page지시어의 isErrorPage
		 -->
		<%=exception.getMessage() %>	
	</fieldset>
</body>
</html>