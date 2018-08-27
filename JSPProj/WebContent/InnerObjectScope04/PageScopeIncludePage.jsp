<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<fieldset>
	<legend>삽입된 페이지 </legend>
	<ul style="list-style-type: upper-roman;">
			<li>Integer타입: <%=pageContext.getAttribute("pageInteger") %></li>
			<li>String타입: <%=pageContext.getAttribute("pageString") %></li>
			<li>Date타입: <%=dateString %></li>
			<li>MemberDTO타입1: <%=firstMemberString %></li>
			<li>MemberDTO타입2: <%=pageContext.getAttribute("pageMemberSecond") %></li>
		
		</ul>

</fieldset>