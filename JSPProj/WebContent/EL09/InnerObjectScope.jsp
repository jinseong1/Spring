<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//
	pageContext.setAttribute("scopeVar", "페이지 영역입니다");
	request.setAttribute("scopeVar", "리퀘스트 영역입니다");
	session.setAttribute("scopeVar", "세션 영역입니다");
	application.setAttribute("scopeVar", "어플리케이션 영역입니다");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>InnerObjectScope.jsp</title>
</head>
<body>
	<fieldset>
		<legend>EL의 xxxScope계열 내장 객체</legend>
		
		<h2>각 영역에 저장된 속성 읽기(xxxScope지정)</h2>
		<ul style="list-style-type: upper-roman;">
			<li>\${pageScope.scopeVar } : ${pageScope.scopeVar }</li>
			<li>\${requestScope.scopeVar } : ${requestScope.scopeVar }</li>
			<li>\${sessionScope['scopeVar'] } : ${sessionScope['scopeVar'] }</li>
			<li>\${applicationScope["scopeVar"] } : ${applicationScope["scopeVar"] }</li>
		</ul>
		<h2>각 영역에 저장된 속성 읽기(xxxScope 미 지정)</h2>
		<ul style="list-style-type: upper-roman;">
			<li>\${scopeVar } : ${scopeVar }</li>
			<li>\${scopeVar } : ${scopeVar }</li>
			<li>\${scopeVar } : ${scopeVar }</li>
			<li>\${scopeVar } : ${scopeVar }</li>
		</ul>
	</fieldset>
	<jsp:forward page="InnerObjectScopeForwarded.jsp"/>
</body>
</html>