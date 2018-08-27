<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>RequestForHeader.jsp</title>
</head>
<body>
	<fieldset>
		<legend>요청 헤더명: 요청 헤더값</legend>
		<ul style="list-style-type: upper-roman;">
		<%
		//request객체의 메소드
		//1]getHeaderNames
		//2]getHEader
		Enumeration<String> names = request.getHeaderNames();
		while(names.hasMoreElements()){
			//헤더 명 얻기]
			String headerName=names.nextElement();
			//헤더 값 얻기]
			String headerValue = request.getHeader(headerName);
			
		
		%>
		<li><%=headerName %>:<%=headerValue %></li>
		<%}///while %>
		</ul>
	</fieldset>
	<fieldset>
		<legend>요청헤더명에 따른 브라우저 종류 알아내기</legend>
		<%
			String browser = request.getHeader("user-agent");
			out.println(browser);
            if (browser.toUpperCase().indexOf("MSIE") == -1) {//키타 혹은 IE11/12
               out.println("<h2>IE 11/12 혹은 기타 웹브라우저</h2>");

            }
            else if (browser.toUpperCase().indexOf("MSIE 6.0") != -1 ||
                     browser.toUpperCase().indexOf("MSIE 7.0") != -1 ||
                     browser.toUpperCase().indexOf("MSIE 8.0") != -1)
                out.println("<h2>IE 6/7/8</h2>");
            else//IE9/10
            	out.println("<h2>IE 9/10<h2>");
		%>
	
	
	</fieldset>
</body>
</html>