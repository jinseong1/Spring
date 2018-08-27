<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>ForwardedPage.jsp</title>
</head>
<body>
	<fieldset>
		<legend>포워드된 페이지(<%=request.getMethod() %>)</legend>
		<h2>파라미터로 전달된 데이타</h2>
		<ul>
			<li>name: <%=request.getParameter("name") %></li>
			<li>id: <%=request.getParameter("id") %></li>
			<li>query: <%=request.getParameter("query") %></li>
		</ul>
		<h2>영역에 저장된 데이타</h2>
		<%=request.getAttribute("member") %>
	</fieldset>
</body>
</html>