<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ForwardExamProcess.jsp -->
<%
	//1]파라미터 받기
	String user = request.getParameter("user");
	String pass = request.getParameter("pass");
	//2]아이디가 KIM이고 비번이 1234인 경우 회원이라고 가정
	//회원인 경우 로그인 처리 
	//로그인 처리후 액션태그를 이용해서 forwardExamMyPage.jsp로 포워드 하여라
	//forwardExamMyPage.js에서 아이디와 비번을 출력하고 로그아웃 처리하여라
	if("KIM".equals(user.trim())&& "1234".equals(pass.trim())){//회원
		//로그인 처리
		session.setAttribute("USER", user);
		session.setAttribute("pass", pass);
	%>
		<jsp:forward page="ForwardExamMyPage.jsp"/>
	<%
	}
	else{//비회원
		//3]비회원인 경우는 리크ㅔ스트 영역에 "회원이 아닙니다"라는 에러메시지를 저장하고 다시 로그인 페이지로 액션태그를 이용해서 포워드 하여라
		//
		//리퀘스트 영역에 에러메시지 저장
		request.setAttribute("ERROR", "아이디와 비번이 틀려요");		
	%>
		<jsp:forward page="ForwardExamLogin.jsp"/>
	
	<%	
	}

%>