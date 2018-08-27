<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>UseBeanActionTagForward.jsp</title>
</head>
<body>
	<!-- 
		자바코드에서 사용한 인스턴스 변수는 액션태그에서 사용불가
		단, 액션 태그에서 사용한 변수(id속성에 지정한 값)는 자바코드에서도 사용 가능
	 -->
	 <!-- 자바코드로 영역에 있는 객체 얻기 -->
	<%-- MemberDTO member =(MemberDTO)request.getAttribute("member");--%>
	<%--=member.getName() --%>
	<%-- 
	아래는 에러
	<jsp:getProperty property="id" name="member"/>
	 --%>
	<jsp:useBean id="member" type="model.MemberDTO" scope="request"/>
	<h2>액션태그로 읽어오기</h2>
	<ul style="list-style-type: upper-roman;">
		<li>아이디: <jsp:getProperty property="id" name="member"/> </li>
		<li>비밀번호: <jsp:getProperty property="pwd" name="member"/></li>
		<li>이름: <jsp:getProperty property="name" name="member"/></li>
		<li>나이: <jsp:getProperty property="age" name="member"/></li>	
	</ul>
	<h2>자바코드로 읽어오기</h2>
	<ul style="list-style-type: upper-roman;">
		<li>아이디: <%=member.getId() %> </li>
		<li>비밀번호: <%=member.getPwd() %></li>
		<li>이름: <%=member.getName() %></li>
		<li>나이: <%=member.getAge() %></li>	
	</ul>
	 
</body>
</html>