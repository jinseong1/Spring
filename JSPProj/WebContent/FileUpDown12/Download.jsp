<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Download.jsp -->
<%
	/*
	다운로드 원리]
	1]웹브라우저가 인식하지 못하는 컨텐트 타입을 응답헤더에 
	설정해주면 웹브라우저는 자체 다운로드 창을 띄운다
	2]서버에 저장된 파일을 출력스트림을 통해 웹브라우저에 출력한다.	
	*/
	//1]파라미터로 넘어오는 파일명 받기
	String filename = request.getParameter("filename");
	//2]파일이 저장된 서버의 물리적 경로 얻기 
	String saveDirectory = application.getRealPath("/Upload");
	//3]파일크기를 얻기 위한 파일 객체 생성
	//다운로드시 프로그래스바를 표시하기 위함.
	File file = new File(saveDirectory+File.separator+filename);
	long length = file.length();
	//다운로드를 위한 응답 헤더 설정
	//4]다운로드창을 보여주기 위한 응답헤더 설정
	//4-1]웹브라우저가 인식하지 못하는 컨텐츠 타입(MIME)타입 설정.
	response.setContentType("application/octect-stream");
	//4-2]다운로드 시 프로그래스바를 표시하기 위한 컨텐츠 길이 설정
	response.setContentLengthLong(length);
	//4-3]응답헤더명:Content-Disposition
	boolean isIe = request.getHeader("user-agent").toUpperCase().indexOf("MSIE")!= -1 ||
					request.getHeader("user-agent").indexOf("11.0") != -1;
	if(isIe){
		filename = URLEncoder.encode(filename,"UTF-8");
	}
	else{
		filename = new String(filename.getBytes("UTF-8"),"8859_1");
	}
	response.setHeader("Content-Disposition","attachment; filename="+filename);
	
	//5]
	BufferedInputStream bis = 
		 new BufferedInputStream(new FileInputStream(file));
	out.clear();
	out = pageContext.pushBody();
	///6]
	BufferedOutputStream bos = 
		new BufferedOutputStream(response.getOutputStream());
	//7
	int data;
	while ((data = bis.read())!= -1){
		bos.write(data);
		bos.flush();
	}
	///8]
	bis.close();
	bos.close();
	
%>