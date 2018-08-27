<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page 
	info="JSP 첫시간 수업"
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    %>
<%
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateString = dateFormat.format(new Date());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>HelloWorld.jsp</title>
</head>
<body>
	<h2>Hello JSP(조현아)<h2>
	<fieldset>
		<legend>JSP테스트</legend>
		<h3>오늘은 <%=dateString %>일 입니다.</h3>
	</fieldset>
	<fieldset>
		<legend>Servlet테스트</legend>
		<h3><a href="HelloServlet.do">HELLO SERVLET</a></h3>
		<span style="color:red;font-size:1.2em;font-weight:bold">${message}</span>
		<h2>계산기</h2>
	    <form action="Calculate.kosmo" >
	      	<input type="text" name="firstNum" size="10" maxlength="10"/>
	      	<select name="operator">
	       		<option value="+">+</option>
	       		<option value="-">-</option>
	       		<option value="*">*</option>
	       		<option value="/">/</option>   
	     	</select>
	      	<input type="text" name="secondNum" size="10" maxlength="10"/>
	      	<input type="submit" value="결과는"/>
	      	<span style="font-size:1.4em;color:green;font-weight:bold">${result}</span>
	   	</form>  
	</fieldset>	
</body>
</html>