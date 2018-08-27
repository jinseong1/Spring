<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글처리]
	request.setCharacterEncoding("UTF-8");
	//2]업로드를 위한 MultipartRequest객체 생성
	//※MultipartRequest객체 생성만으로 파일 업로드가 이루어짐	
	//3]
	String saveDirectory = application.getRealPath("/Upload");
	//out.println("saveDirectory: "+saveDirectory);
	int maxPostSize = 1024 * 500;//500KB
	String encoding = "UTF-8";
	FileRenamePolicy policy = new DefaultFileRenamePolicy();
	//4]MultipartRequest객체 생성
	MultipartRequest mr = null;
	String name = null;
	String title = null;
	StringBuffer buffer = new StringBuffer();
	try{
		mr= new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
		//5]기타 폼의 하위 요소 받기(파라미터 받기)
		name =mr.getParameter("name");
		title = mr.getParameter("title");
		String[] inters = mr.getParameterValues("inter");
		for(String inter:inters) buffer.append(inter+" ");
	}
	catch(Exception e){//파일 용량 초과 에러
		//에러 내용을 리퀘스트 영역에 저장
		request.setAttribute("error", "최대 파일 용량(500KB)를 초과했어요");
		//uploadform으로 포워드
		request.getRequestDispatcher("UploadForm.jsp").forward(request, response);
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>UploadComplete.jsp</title>
</head>
<body>
	<fieldset>
   <legend>파일 업로드 결과</legend>
   <h2>type="file" 요소를 제외한 폼 요소</h2>
   <ul style="list-style-type:decimal; ">
    <li>이름:<%=name %></li>
    <li>제목:<%=title %></li>
    <li>관심사항:><%=buffer %></li>
   </ul>
   <h2>업로드된 파일 관련 정보</h2>
   <h3>첫번째 파일</h3>
   <ul style="list-style-type:decimal; ">
    <li>원본 파일명:<%=mr.getOriginalFileName("attachedFile1") %></li>
    <li>실제 서버에 저장된 파일명:<%=mr.getFilesystemName("attachedFile1") %></li>
    <li>컨텐츠 타입:<%=mr.getContentType("attachedFile1") %></li>
    <li>파일 크기:<%=(int)Math.ceil(mr.getFile("attachedFile1").length()/1024.0) %>KB</li>
   </ul>
   <h3>두번째 파일</h3>
   <ul style="list-style-type:decimal; ">
   	<li>원본 파일명:<%=mr.getOriginalFileName("attachedFile2") %></li>
    <li>실제 서버에 저장된 파일명:<%=mr.getFilesystemName("attachedFile2") %></li>
    <li>컨텐츠 타입:<%=mr.getContentType("attachedFile2") %></li>
    <li>파일 크기:<%=(int)Math.ceil(mr.getFile("attachedFile2").length()/1024.0) %>KB</li>
   </ul>
  </fieldset>
</body>
</html>