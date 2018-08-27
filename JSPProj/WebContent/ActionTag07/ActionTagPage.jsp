<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ActionTagPage.jsp -->
<%
	//이 페이지는 서블릿으로 변환 
	//즉 다른 페이지다
	//시행결과가 페이지에 포함 됨
	//request영역 공유 
	String actionTagString = "액션태그로 삽입된 페이지 안에서 선언한 변수";


%>
<h3>actionTagPage.jsp 페이지 입니다</h3>
<ul style="list-style-type: upper-roman;">
	<li>페이지 영역:<%=pageContext.getAttribute("pageVar") %></li>
	<li>리퀘스트 영역:<%=request.getAttribute("requestVar") %></li>
</ul>





