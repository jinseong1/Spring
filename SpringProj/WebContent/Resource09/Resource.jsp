
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Resource.jsp</title>
</head>
<body>
	<!-- 
		리소스파일:.properties로 끝나는 파일로
		스프링 프레임웍에서 자원으로 사용하는 파일
		키값= 값의 쌍으로 자원(상수)을 등록한다.
		주석처리는 #으로
	
		리소스 파일은 이클립스의 classpath인 
		src폴더 밑 어디에든 위치하면 된다.
		(생성시 new->File로 생성.확장자는 .properties 로)		
	 -->
   	<fieldset>
   		<legend>${value}리소스(.properties)${resource}</legend>
   		<c:url var="url" value="/Resource/Resource.do"/>
   		<a href="${url}">리소스</a>
   	</fieldset>
   	
</body>
</html>