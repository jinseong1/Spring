<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>RequestForServerNClient.jsp</title>
</head>
<body>
	<fieldset>
		<legend>요청한 서버와 클라이언트에 대한 정보</legend>
		<form method="post">
			<input type="submit" value="전송"/>		
		</form>
		<ul style="list-style-type: upper-alpha;">
			<li>전송방식: <%=request.getMethod() %></li>
			<li>전체 URL: <%=request.getRequestURL() %></li>
			<li>도메인을 제외한 URL: <%=request.getRequestURI() %>
			<li>요청 프로토콜: <%=request.getProtocol() %></li>
			<li>요청 서버명:<%=request.getServerName() %></li>
			<li>요청 서버 포트: <%=request.getServerPort() %></li>
			
			<li>클라이언트의 IP주소: <%=request.getRemoteHost() %></li>
			<li>클라이언트의 IP주소: <%=request.getRemoteAddr() %></li>
			
			<li>요청과 관련된 세션객체 얻기: <%=request.getSession() %></li>
			<li>세션 내장 객체:<%=session %></li>
		</ul>
	</fieldset>
	<fieldset>
		<legend>Context Root얻기</legend>
		<h3>프로젝트 생성 후 server.xml의 Context태그의 path속성 미 변경시</h3>
		Context Root(프로젝트명): <%=request.getContextPath() %>
		<h3>프로젝트 생성 후 server.xml의 Context태그의 path속성 미 변경시(""혹은 "/")</h3>
		Context Root(빈문자열): <%=request.getContextPath() %>
	</fieldset>
</body>
</html>