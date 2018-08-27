<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>ApplicationIO.jsp</title>
</head>
<body>
	<fieldset>
		<legend>application내장객체의 getResourceAsStream()</legend>
		<h2>자바IO를 사용해서 파일 내용을 웹브라우저에 출력</h2>
		<%
		/*
			데이타 소스:파일-노드 스트림:FileInputStream
						브릿지 스트림: InptStreamReader
			데이타 목적지:웹브라우저-out 내장객체
		*/
		//1]물리적 경로 얻어오기]
		String realPath = application.getRealPath("/InnerObject03/Sample.txt");
		//2]입력스트림 생성-서버의 파일에 빨대 꽂기
		BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(
									new FileInputStream(realPath)));
		
		//3]br로 읽고 out 내장객체로 출력
		String data;
		while((data=br.readLine())!=null){
			out.println(data+"<br/>");
		}
		//스트림 닫기
		br.close();
		%>
		<h2>getResourceAsStream()을 사용해서 파일 내용을 웹 브라우저에 출력</h2>
		<%
		/*
		InputStream getREouserceAsStream("컨텍스트 루트를 제외한 /로 시작하는 웹상의 경로")
		-웹 어플맄메이션 안의 모든 자원(이미지,텍스트파일,동영상)
		에 빨대를 꽂을 수 있는 입력스트림을 반환해주는 메소드	
		-물리적 경로 불필요
		-웹상의 경ㄹ로만 알면됨
		*/
		//1]입력스트림 생성
		InputStream is =application.getResourceAsStream("/InnerObject03/Sample.txt");
		br = 
			new BufferedReader(
					new InputStreamReader(is));
	
		//3]br로 읽고 out 내장객체로 출력
		
		while((data=br.readLine())!=null){
			out.println(data+"<br/>");
		}
		//스트림 닫기
		br.close();
		%>
	</fieldset>
</body>
</html>