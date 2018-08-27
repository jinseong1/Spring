<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="model.BbsDTO"%>
<%@page import="model.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Delete.jsp -->
<%
	//1]파라미터 받기
	String no = request.getParameter("no");
	//현재 페이지 번호 받기
	int nowPage = Integer.parseInt(request.getParameter("nowPage"));
	//2]크루드 작업용  DAO계열 객체 생성
	BbsDAO dao = new BbsDAO(application);
	int affected = dao.delete(no);
	
	//마지막 레코드 삭제시 페이지가 하나 줄어드는 경우에 대비한 코딩
	//전체 레코드 수
	int total = dao.getTotalRecordCount(new HashMap());
	//페이지 사이즈
	int pageSize =Integer.parseInt(application.getInitParameter("PAGE_SIZE"));
	//전체페이지 수
	int totalPage = (int)Math.ceil(((double)total/pageSize));
	//현재 페이지를 파라미터로 받기]
	//3]자원반납
	dao.close();
	
	/* if(affected!=0){
		//삭제후 목록으로 이동 		
		if(totalRecordCount%totalPage==0){
			response.sendRedirect("List.jsp?nowPage="+(Integer.parseInt(nowPage)-1));
		}
		else{
		response.sendRedirect("List.jsp?nowPage="+nowPage);
		}
	} */
	if(totalPage<nowPage){nowPage=totalPage;}
	if(affected!=0){
		//삭제후 목록으로 이동 		
		response.sendRedirect("List.jsp?nowPage="+nowPage);
	}
	else{
%>
	<script>
	alert('삭제 실패했어요');
	history.back();	
	</script>
<%}//else%>