<%@page import="model.MemberDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>RequestScopeResult.jsp</title>
</head>
<body>
	<fieldset>
		<legend>이전 페이지(RequestScopeIndex.jsp)에서 페이지 영역에 저장한 속성 읽기</legend>
		<%
		Object object =request.getAttribute("requestDate");
		String dateString="";
		if(object instanceof Date){
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
			dateString = dateFormat.format((Date)object);
		}
		
		MemberDTO firstMember = (MemberDTO)request.getAttribute("requestMemberFirst");
		String firstMemberString="";
		if(firstMember != null){
			firstMemberString = String.format(
					"이름: %s, 아이디: %s, 비번: %s, 나이: %s",
					firstMember.getName() ,
					firstMember.getId(),
					firstMember.getPwd(),
					firstMember.getAge());
		}
		%>
		
		<ul style="list-style-type: upper-roman;">
			<li>Integer타입: <%=request.getAttribute("requestInteger") %></li>
			<li>String타입: <%=request.getAttribute("requestString") %></li>
			<li>Date타입: <%=dateString %></li>
			<li>MemberDTO타입1: <%=firstMemberString %></li>
			<li>MemberDTO타입2: <%=request.getAttribute("requestMemberSecond") %></li>
		
		</ul>
	</fieldset>
	<fieldset>
		<legend>파라미터로 전달된 값</legend>
		<%=request.getParameter("param") %>
	</fieldset>
</body>
</html>