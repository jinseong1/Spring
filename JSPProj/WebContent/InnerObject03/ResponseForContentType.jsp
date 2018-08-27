<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ResponseForContentType.jsp</title>
</head>
<body>
	<fieldset>
		<legend>Content-Type응답헤더</legend>
		<h3>서블릿에서 직접 웹브라우저로 출력
		(이때는 반드시 setContentType()메소드 사용해라)</h3>
		
		<a href="<%=request.getContextPath() %>/AniDir/SomeDir/SetContentsType.kosmo">서블릿으로 요청</a>
	</fieldset>
</body>
</html>