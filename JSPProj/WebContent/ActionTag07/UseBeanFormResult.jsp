<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//1]포스트 방식으로 파라미터 전달시 한글 처리
	request.setCharacterEncoding("UTF-8");
	//2]폼의 하위요소값 받기 
	String id = request.getParameter("id")==null? request.getParameter("user"):request.getParameter("id");
	String pwd = request.getParameter("pwd")==null? request.getParameter("pass"):request.getParameter("pwd");
	String name = request.getParameter("name");
	//3]받은 값을 MemberDTO객체의 속성에 설정
	MemberDTO member= new MemberDTO();
	member.setId(id);
	member.setPwd(pwd);
	member.setName(name);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>UseBeanFormResult.jsp</title>
</head>
<body>
	<fieldset>
		<legend>useBean액션 태그로 form의 하위 요소 값 받기</legend>
		<h2>자바코드로 받기</h2>
		<%=member %>
		<h2>액션태그로 받기</h2>
		<!-- 1]액션태그로 자바빈 객체 생성 -->
		<jsp:useBean id="action" class="model.MemberDTO" />
		<h3> 파라미터명과 자바빈의 속성명(멤버변수) 일치시</h3>
		<jsp:setProperty property="*" name="action"/>
		<%=action %>
		<h3>파라미터명과 자바빈의 속성명(멤버변수) 불일치시</h3>
		<!--
			
		
		  -->
		<jsp:setProperty property="id" name="action" param="user"/>  
		<jsp:setProperty property="pwd" name="action" param="pass"/>  
		
		  
	</fieldset>
</body>
</html>