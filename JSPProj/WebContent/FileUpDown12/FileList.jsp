<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>FileList.jsp</title>
</head>
<body>
	<fieldset>
		<legend>업로드된 파일 목록</legend>
		<ul style="list-style-type: upper-roman;">
		<%
		String saveDirectory = application.getRealPath("/Upload");
		File file = new File(saveDirectory);
		File[] files = file.listFiles();
		for(File f:files){
		%>
			<li>파일명:<a href='Download.jsp?filename=<%=URLEncoder.encode(f.getName(),"utf-8") %>'><%=f.getName() %></a>,파일크기:<%=(int)Math.ceil(f.length()/1024.0) %>KB</li>
		<%} %>
		
		</ul>
	</fieldset>
</body>
</html>