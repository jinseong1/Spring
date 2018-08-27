<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>ForwardExamMyPage.jsp</title>
</head>
<body>
	<fieldset>
		<legend>forward액션태그-마이 페이지</legend>
		<h2>세션 영역에서 가져오기</h2>
		<ul style="list-style-type: upper-roman;">
			<li>아이디: <%=session.getAttribute("USER") %></li>
			<li>비밀번호: <%=session.getAttribute("PASS") %></li>
		</ul>
		<h2>파라미터로 가져오기</h2>
		<ul style="list-style-type: upper-roman;">
			<li>아이디: <%=request.getParameter("user") %></li>
			<li>비밀번호: <%=request.getParameter("pass") %></li>
		</ul>
	</fieldset>
</body>
</html>