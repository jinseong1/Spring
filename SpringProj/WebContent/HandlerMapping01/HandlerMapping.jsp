<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>HandlerMapping.jsp</title>
</head>
<body>
   	<fieldset>
   		<legend>핸들러 매핑<span style="color:red;font-size:1.4em">${message}</span></legend>
   		<h2>디폴트(기본) 핸들 매핑</h2>
   		<ul style="list-style-type: upper-roman;">
   			
   			<li><a href="<c:url value='/HandleMapping/BeanNameUrl.do'/>">BeanNameUrlHandlerMapping</a></li>
   			<li><a href="<c:url value='/HandleMapping/Annotation.do'/>">DefaultAnnotationHandlerMapping</a></li>
   		</ul>
   		<h2>SimpleUrlHandlerMapping(기본 핸들러 매핑이 아님)</h2>
   		<ul style="list-style-type: upper-roman;">   			
   			<li><a href="<c:url value='/HandleMapping/SimpleUrlFirst.do'/>">SimpleUrlFirst.do</a></li>
   			<li><a href="<c:url value='/HandleMapping/SimpleUrlSecond.do'/>">SimpleUrlSecond.do</a></li>
   		</ul>
   		
   		
   	</fieldset>
</body>
</html>