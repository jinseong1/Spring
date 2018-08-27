<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>ViewResolver.jsp</title>
</head>
<body>
   	<fieldset>
   		<legend>뷰리졸버<span style="color:red;font-size:1.6em">${message}${param.message}</span></legend>
   		
   		<a href='<c:url value="/ViewResolver/ViewResolver.vrv"/>'>InternalResourceViewResolver(기본 뷰 리졸버)</a>
   	</fieldset>
</body>
</html>