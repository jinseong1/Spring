<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.MemberDTO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//
	MemberDTO first = new MemberDTO("KIM","1234","김길동", null, "20");
	MemberDTO second = new MemberDTO("LEE","5678","이길동",null,"10");
	MemberDTO third = new MemberDTO("PARK","9999","박길동",null,"30");
	//
	List<MemberDTO> list = new Vector<MemberDTO>();
	list.add(first);
	list.add(second);
	list.add(third);
	//
	Map<String,MemberDTO> map = new HashMap<String,MemberDTO>();
	map.put("first",first);
	map.put("second",second);
	map.put("third",third);
	//application 영역에 컬렛견들 저장
	application.setAttribute("list", list);
	application.setAttribute("map", map);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>ApplicationScopeIndex.jsp</title>
</head>
<body>
	<fieldset>
		<legend>어플리케이션 영역</legend>
		<h2>링크에 의한 페이지 이동</h2>
		//<a href="ApplicationScopeResult.jsp">사용자 클릭에 의한 이동</a>
		
		<h2>포워드로 자동 페이지 이동</h2>
		<%
		/*
		절대경로로 지정시]
		 포워드 방식:컨텍스트 루트 제외
		 리다이렉트방식:컨텍스트 루트 포함
		 
		 
		
		
		*/
		//request.getRequestDispatcher("/InnerObjectScope04/ApplicationScopeResult.jsp").forward(request, response);
		
		
		%>
		<h2>리다이렉트로 자동 페이지 이동</h2>
		<%
		//response.sendRedirect(request.getContextPath()+"/InnerObjectScope04/ApplicationScopeResult.jsp");

		
		
		%>
	</fieldset>
</body>
</html>