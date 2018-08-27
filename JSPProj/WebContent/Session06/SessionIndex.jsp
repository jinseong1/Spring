<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>SessionIndex.jsp</title>
</head>
<body>
	<fieldset>
		<legend>session(HttpSession타입)내장객체의 주요 메소드</legend>
		<ul style="list-style-type: upper-roman;">
			<li>세션의 유효시간 얻기(web.xml:분단위):
				<%=session.getMaxInactiveInterval() %>
			</li>
			<% session.setMaxInactiveInterval(3600); %>
			<li>메소드로 유효시간 설정(초단위): <%=session.getMaxInactiveInterval() %></li>
			<li>세션 아이디: <a href="SessionResult.jsp"> <%=session.getId() %></a></li>
			<%
				//세션의 최초 생성시간 
				long creationTime = session.getCreationTime();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String creationTimeString = dateFormat.format(new Date(creationTime));
				//서버로 클라이언트가 마지막으로 요청한 시간
				long accessedTime = session.getLastAccessedTime();
				String accessedTimeString = dateFormat.format(new Date(accessedTime));
			%>
			<li>세션의 최초 생성시간:<%=creationTimeString %></li>
			<li>클라이언트의 마지막 요청 시간:<%=accessedTimeString %></li>		
		</ul>
		<h2>세션 및 리퀘스트 영역에 저장</h2>
		<%
			request.setAttribute("requestScope", "리퀘스트 영역 입니다");
			session.setAttribute("sessionScope", "세션 영역 입니다");
		%>
	</fieldset>
	
</body>
</html>