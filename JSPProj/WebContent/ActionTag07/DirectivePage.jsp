<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- DirectivePage.jsp -->
<%
	//서블릿으로 변환 아노딤
	//즉 페이지에 포함디서 서블릿으로 변환됨으로 같은 페이지다
	//변수선언]
	String directiveString = "지시어로 삽입된 페이지 안에서 선언한 변수";


%>
<h3>DirectivePage.jsp 페이지 입니다</h3>
<ul style="list-style-type: upper-roman;">
	<li>페이지 영역:<%=pageContext.getAttribute("pageVar") %></li>
	<!-- 
		include 액션태그로 포함된 페이지에서 선언한 변수는 사용불가
		(실행결과(HTML결과)만 포함됨으로)	
	 -->
	<li>리퀘스트 영역:<%=request.getAttribute("requestVar") %></li>
</ul>
