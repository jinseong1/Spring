<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.MemberDTO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//한글-포워드
	request.setCharacterEncoding("UTF-8");
	/*
	모든 영역(페이지,리퀘스트,세션,어플리케이션)에는 모든 타입의 객체 저장 가능
	파라미터로 값을 전달할떄는 문자열만 가능
	
	페이지 영역에 저장한 속성은 해당 페이지를 벗어나면 사라진다.
	page영역에는 request객체(request 타입) 존재
	*/
	//리퀘스트 영역에 속성 저장]
	request.setAttribute("requestInteger", new Integer(1000));
	request.setAttribute("requestString", "리퀘스트 영역에 저장된 문자열");
	request.setAttribute("requestDate", new Date());
	request.setAttribute("requestMemberFirst", new MemberDTO("KIM","1234","김길동", null,"20"));
	
	MemberDTO member = new MemberDTO();
	member.setAge("30");
	member.setId("PARK");
	member.setName("박길동");
	member.setPwd("1234");
	request.setAttribute("requestMemberSecond", member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>RequestScopeIndex.jsp</title>
</head>
<body>
	<fieldset>
		<legend>리퀘스트 영역</legend>
		<h2>리퀘스트 영역에 저장된 속성값 읽기</h2>
		<%
		Object object =request.getAttribute("requestDate");
		String dateString="";
		if(object instanceof Date){
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
			dateString = dateFormat.format((Date)object);
		}
		
		MemberDTO firstMember = (MemberDTO)request.getAttribute("requestMemberFirst");
		String firstMemberString = String.format(
				"이름: %s, 아이디: %s, 비번: %s, 나이: %s",
				firstMember.getName() ,
				firstMember.getId(),
				firstMember.getPwd(),
				firstMember.getAge());
		%>
		
		<ul style="list-style-type: upper-roman;">
			<li>Integer타입: <%=request.getAttribute("requestInteger") %></li>
			<li>String타입: <%=request.getAttribute("requestString") %></li>
			<li>Date타입: <%=dateString %></li>
			<li>MemberDTO타입1: <%=firstMemberString %></li>
			<li>MemberDTO타입2: <%=request.getAttribute("requestMemberSecond") %></li>
		
		</ul>
		<h2>리퀘스트 영역에 저장된 속성 삭제후 출력</h2>
		<%
		///속성명이 틀린 경우 삭제가 안됨. 에러는 안남.
		request.removeAttribute("NOKEY");
		//존제하는 키값(속성명)으로 삭제
		request.removeAttribute("requestInteger");
		request.removeAttribute("requestString");
		
		%>	
		<ul style="list-style-type: upper-roman;">
			<li>Integer타입: <%=request.getAttribute("requestInteger") %></li>
			<li>String타입: <%=request.getAttribute("requestString") %></li>
			<li>Date타입: <%=dateString %></li>
			<li>MemberDTO타입1: <%=firstMemberString %></li>
			<li>MemberDTO타입2: <%=request.getAttribute("requestMemberSecond") %></li>
		
		</ul>
		<h2>페이지 이동</h2>
		<a href="RequestScopeResult.jsp">사용자 클리에 의한 페이지 이동</a>
	</fieldset>
	<%
		//사용자 클릭이 아니니 자동으로 페이지 이동하는 방법]
		//forward방식]
		/*
		-최초 요첯ㅇ시 생성된 request객체를 포워드 되는 페이지로 전달한다.
		-고로 포워드 되는 페이지와 리크ㅔ스트 영역을 공유한다
		-URL주소창에는 최초 요청한 URL이 보인다 (포워드 된 URL아님)
		
		*/
		//자동으로 이동할 페이지 설정]-절대경로 지정시 컨텍스트 루트 제외
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/InnerObjectScope04/RequestScopeResult.jsp?param=포워드");
		//dispatcher.forward(request, response);
	
		//redirect방식]
		/* 
		location.href로 이동한 것과 같다
		-즉 새로운 요청이다
		-고로 리퀘스트 영역이 공유가 안된다.
		-URL주소창에는 리다이렉트된 최종 url이 보인다
		-절대경로 지정시 반드시 컨텍스트 루트 포함 		
		*/
		response.sendRedirect(request.getContextPath()+"/InnerObjectScope04/RequestScopeResult.jsp?param="+URLEncoder.encode("리다이렉트", "utf-8"));
		
	
	%>
</body>
</html>