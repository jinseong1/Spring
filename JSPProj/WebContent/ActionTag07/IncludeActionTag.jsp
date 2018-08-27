<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
include 지시어의 file 속성과 include액션태그의 page속성에 절대경로로 페이지 


 -->
<%
	//페이지명 변수에 저장]
	String directivePath = "DirectivePage.jsp";
	String actionTagPath = "ActionTagPage.jsp";
	//페이지 및 리퀘스트 영역에 속성저장]
	pageContext.setAttribute("pageVar", "페이지 영역 입니다");
	request.setAttribute("requestVar", "리퀘스트 영역 입니다");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8 " />
<title>IncludeActionTag.jsp</title>
</head>
<body>
	<fieldset>
		<legend>include 지시어와 &lt;jsp:include&gt;액션태그</legend>
		<h2>include 지시어로 페이지 포함</h2>
		<!--file속성에 표현식 사용불가 -->
		<%--<%@ includefile="<%=directivePath %>"%> --%>
		<%@ include file ="DirectivePage.jsp" %>
		<h2>include 액션태그로 페이지 포함</h2>
		<!-- page속성에 표현식 가능  -->
		<jsp:include page="<%=actionTagPath%>" />
		<h2>삽입된 페이지에서 선언한 변수 사용하기</h2>
		<ul style="list-style-type: upper-alpha;">
			<li>directiveString:<%=directiveString %></li>
			<li>actionTagString:<%--=actionTagString --%></li>
		</ul>
		
		
	</fieldset>
</body>
</html>