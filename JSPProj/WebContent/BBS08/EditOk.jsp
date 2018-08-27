<%@page import="model.BbsDTO"%>
<%@page import="model.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- EditOk.jsp -->
<%
	//1]한글처리
	request.setCharacterEncoding("utf-8");
	//2]파라미터 받기
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String no = request.getParameter("no");
	//현재 페이지 받기
	String nowPage = request.getParameter("nowPage");
	//3]데이터를 전달할 DTO객체 생성 및 데이타 설정


	BbsDTO dto = new BbsDTO();	

	dto.setTitle(title);
	dto.setContent(content);
	dto.setNo(no);
	
	//4]크루드 작업용  DAO계열 객체 생성
	BbsDAO dao = new BbsDAO(application);
	int affected = dao.update(dto);
	dao.close();
	
	if(affected==1){
		response.sendRedirect("View.jsp?no="+no+"&nowPage="+nowPage);
	}
	else{
		out.println("<script>");
		out.println("alert('수정 실패했어요');");
		out.println("history.back();");
		out.println("</script>");
	}
%>