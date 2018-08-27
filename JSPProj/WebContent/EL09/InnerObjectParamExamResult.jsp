<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<% 
	//한글처리
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>InnerObjectParamExamResult.jsp</title>
</head>
<body>
	<fieldset>
		<legend>자바코드(스크립팅요소)로 받기</legend>
		<ul style="list-style-type: upper-roman;">
			<li>이름: <%=request.getParameter("name") %></li>
			<li>성별: <%=request.getParameter("gender") %></li>
			<%
				String[] values = request.getParameterValues("inter");
				String interString="";
				for(String value: values){
					interString+=value+" ";
				}
			%>
			<%--String values[]=request.getParameterValues("inter");
           for(String value:values){
           --%><%--=value --%>
           <%-- }--%>
			<li>관심사항: <%=interString %></li>
			<li>학력: <%=request.getParameter("grade") %></li>			
		</ul>
	</fieldset>
	<fieldset>
		<legend>EL(표현언어)로 받기</legend>
		<ul style="list-style-type: upper-roman;">
			<li>이름: ${param.name }</li>
			<li>성별: ${param["gender"] }</li>
			<li>관심사항: 
			<c:forEach var="item" items="${paramValues.inter }">
				${item}
			</c:forEach>
			</li>
			<li>학력: ${param.grade }</li>			
		</ul>
	</fieldset>
</body>
</html>