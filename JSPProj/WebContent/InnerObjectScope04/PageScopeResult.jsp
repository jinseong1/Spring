<%@page import="model.MemberDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>PageScopeResult.jsp</title>
</head>
<body>
	<fieldset>
		<legend>이전 페이지(PageScopeIndex.jsp)에서 페이지 영역에 저장한 속성 읽기</legend>
		<%
		Object object =pageContext.getAttribute("pageDate");
		String dateString="";
		if(object instanceof Date){
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
			dateString = dateFormat.format((Date)object);
		}
		
		MemberDTO firstMember = (MemberDTO)pageContext.getAttribute("pageMemberFirst");
		String firstMemberString=null;
		if(firstMember!=null){
			firstMemberString = String.format(
					"이름: %s, 아이디: %s, 비번: %s, 나이: %s",
					firstMember.getName(),
					firstMember.getId(),
					firstMember.getPwd(),
					firstMember.getAge());
		}
		%>
		
		<ul style="list-style-type: upper-roman;">
			<li>Integer타입: <%=pageContext.getAttribute("pageInteger") %></li>
			<li>String타입: <%=pageContext.getAttribute("pageString") %></li>
			<li>Date타입: <%=dateString %></li>
			<li>MemberDTO타입1: <%=firstMemberString %></li>
			<li>MemberDTO타입2: <%=pageContext.getAttribute("pageMemberSecond") %></li>
		
		</ul>
	</fieldset>
</body>
</html>