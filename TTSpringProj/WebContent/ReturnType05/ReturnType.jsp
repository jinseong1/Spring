<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>ReturnType.jsp</title>
</head>
<body>
   	<fieldset>
   		<legend>컨트롤러 메소드의 반환타입${requestScope.message!=null ? requestScope.message:""}<span style="color:red;font-size:1.8em">${returnType==null ? "" : returnType}</span></legend>
   		<ul style="list-style-type:decimal;">
   			<c:url var="url" value="/ReturnType/ModelAndView.do?returnType=ModelAndView!!!"/>
   			<li><a href="${url}">ModelAndView반환</a></li>
   			<c:url var="url" value="/ReturnType/String.do?returnType=String!!!"/>
   			<li><a href="${url}">String반환</a></li>
   			<c:url var="url" value="/ReturnType/Void.do?returnType=void!!!"/>
   			<li><a href="${url}">void(Ajax에서 주로 활용)</a></li>
   		</ul>
   	</fieldset>
</body>
</html>