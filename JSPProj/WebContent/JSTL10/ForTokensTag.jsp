<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>ForTokensTag.jsp</title>
</head>
<body>
	<fieldset>
		<legend>forTokens태그</legend>
		<%
		String colors="red,green,blue,#ab77df";
		StringTokenizer tokenizer = new StringTokenizer(colors,",");
		out.println("<h2>StringTokenizer클래스</h2>");
		out.println("토큰의 수: "+tokenizer.countTokens());
		//out.println("<br/>토큰: "+tokenizer.nextToken());
		//hasMoreTokens():꺼내올 토큰이 있으면 true, 없으면 false반환
		while(tokenizer.hasMoreTokens()){
			//토큰을 꺼내올때는 nextToken()
			String token = tokenizer.nextToken();
			out.println("<h4 style ='color:"+token+"'>"+token+"</h4>");
		}//while
		out.println("<h2>String클래스</h2>");	
		String[] colorsString = colors.split(",");	
		for(String color:colorsString){
			out.println("<h4 style ='color:"+color+"'>"+color+"</h4>");
		}
		%>
		<h2>JSTL의 forTokens태그</h2>
		<c:set var="colors" value="<%=colors %>" />
		<c:forTokens items="${colors}" delims="," var="color">
			<h4 style="color:${color}">${color}</h4>
		</c:forTokens>
	</fieldset>
</body>
</html>