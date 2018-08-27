<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ParamActionTagInForward.jsp -->
<%
//포워드된 페이지나 인클루드된 페이지로 파라미터 전달시 한글이 포함된 경우 한글 처리는 반드시 포워드 시키는 최초페이지나 인클루드 시키는 페이지에서 설정한다
	request.setCharacterEncoding("UTF-8");
	/*
	page="<%=url% >?query=쿼리스트링"
	즉 page="<%=url% >"만 가능
	
	파라미터 전달시 
	파라미터 값을 표현식으로 처리하고자 할때는 
	param액션 태그를 이용한다.
	단, 파라미터명은 표현식 사용불가
	*/
	String pageUrl="ForwardedPage.jsp?query=쿼리스트링";
	String paramValue = "Hong";
	
	/*
	파라미터로는 문자열만 전달 가능
	객체를 전달하고자 할떄는 기본 내장 객체의 
	영역에 저장해서 전달한다.	
	*/
	request.setAttribute("member", new MemberDTO("KIM","1234","김길동",null,"20"));
%>

<jsp:forward page="<%=pageUrl %>">
	<jsp:param value="홍길동" name="name"/>
	<jsp:param value="<%=paramValue %>" name="id"/>
</jsp:forward>