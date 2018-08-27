<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- IncludePage.jsp -->
<!-- 여러 JSP페이지에서 공통으로 사용할 변수나 상수, 메소드 정의 -->
<%
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm::ss");
	String todayString =dateFormat.format(new Date());%>
	<h4>오늘은 <span style="color:green;font-weight: bold;font-size: 1.5em"><%=todayString %></span>일 입니다.</h4>