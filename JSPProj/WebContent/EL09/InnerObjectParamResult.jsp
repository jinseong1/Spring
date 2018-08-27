<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>InnerObjectParamResult.jsp</title>
</head>
<body>
	<fieldset>
		<legend>EL의 param 내장 객체</legend>
		<h2>자바코드로 영역에 저장된 값 및 파라미터에 전달된 값 읽기</h2>
		<h4>영역에 저장된 값</h4>
		<%
			MemberDTO member = (MemberDTO)request.getAttribute("dtoObject");
		%>
		<ul>
			<li>memberDTO객체: <%=String.format("name-%s,id-%s,pwd-%s",member.getName(), member.getId(), member.getPwd()) %></li>
			<li>String객체:<%=request.getAttribute("stringObject") %></li>
			<li>Integer객체:<%=request.getAttribute("integerObject") %></li>
		</ul>
		<h4>파라미터로 전달된 값</h4>
		<%
		int first = Integer.parseInt(request.getParameter("first"));
		int second = Integer.parseInt(request.getParameter("second"));		
		%>
		두 파라미터의 합:<%=first+second %>
		<h2>EL로 영역에 저장된 값 및 파라미터에 전달된 값 읽기</h2>
		<h4>영역에 저장된 값</h4>
		<ul>
			<li>memberDTO객체: name-${dtoObject.name }, id-${dtoObject.id }, pwd-${dtoObject.pwd }</li>
			<li>String객체: ${requestScope.stringObject }</li>
			<li>Integer객체: ${integerObject }</li>
		</ul>
		<h4>파라미터로 전달된 값</h4>
		두 파라미터의 합: ${param.first+param['second'] }
	</fieldset>
</body>
</html>