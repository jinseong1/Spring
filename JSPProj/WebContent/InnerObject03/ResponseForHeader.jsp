<%@page import="java.util.Collection"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//[응답헤더 설정]
	//HTTP/1.0에 적용시킬때
	response.setHeader("pragma", "no-cache");
	//HTTP/1.1에 적용시킬때
	response.setHeader("cache-control", "no-cache");

	//response.setContentType("binary/octect-stream");
	//응답헤더 두가지 계열  - add/set
	//set계열
	Date date =new Date();
	long currentTime = date.getTime();
	response.setDateHeader("currentDate", currentTime);
	//특정 날짜를 add계열로
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	long endTime = dateFormat.parse("2018-11-15").getTime();
	response.addDateHeader("currentDate", endTime);
	//response.setDateHeader("currentDate", endTime);
	//add계열로 numberofstudnet라는 헤더명 생성
	response.addIntHeader("NumberOfStudent", 30);
	//set계열로 numberofstudnet라는 헤더명 change
	response.setIntHeader("NumberOfStudent", 0);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>ResponseForHeader.jsp</title>
</head>
<body>
	<fieldset>
		<legend>응답헤더</legend>
		<ul style="list-style-type:upper-latin;">
		<%
			//1]응답 헤더 명 얻기:getHeaderNames()
			Collection<String> names = response.getHeaderNames();
			for(String name:names){
				//2]응답헤더값 얻기: getHeader("헤더명")
				String headerValue= response.getHeader(name);
				out.println(String.format("<li>%s: %s</li>", name, headerValue));
			}
		%>
		
		</ul>
		<h2>응답헤더명 존재여부 판단: boolean containsHeader("응답헤더명")</h2>
		<h4>Content-Type존재여부 판단</h4>
		<%=response.containsHeader("Content-Type")?"Content-Type 헤더존재" : "Content-Type 헤더 미존재"%>
		<h4>currentDate존재 여부 판단</h4>
		<%=response.containsHeader("currentDate")?"currentDate 헤더존재" : "currentDate 헤더 미존재"%>
	</fieldset>
</body>
</html>