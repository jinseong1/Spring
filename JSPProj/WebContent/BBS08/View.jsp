<%@page import="java.util.Map"%>
<%@page import="model.BbsDTO"%>
<%@page import="java.util.List"%>
<%@page import="model.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Common/IsMember.jsp" %>
<%
	//1]파라미터(키값)받기
	String no = request.getParameter("no");
	//현재 페이지 번호 받기
	String nowPage = request.getParameter("nowPage");
	//검색과 관련된 파라미터 - 검색 후 페이징시 처리용
	String searchColumn = request.getParameter("searchColumn");
	String searchWord = request.getParameter("searchWord");
	String queryString="";
	if(searchColumn!=null){
		//검색시 나타난 페이징 번호 클릭시 처리하기 위한 추가 쿼리 스트링
		queryString+="searchColumn="+searchColumn+"&searchWord="+searchWord+"&";
	}
	//2]크루드 작업용  bbsDAO생성
	BbsDAO dao = new BbsDAO(application);
	//조회수 업데이트
	dao.updateVisitCount(no);
	//상세보기용 메소드 호출
	BbsDTO record = dao.selectOne(no);
	//이전글 /다음글 조회
	Map<String,BbsDTO> map = dao.prevNext(no);
	
	dao.close();



%>
<!DOCTYPE html>
<html>
<head>
    <title>View.jsp</title>
	<meta charset="utf-8" />
    <link rel="stylesheet" href="../Styles/divLayout.css" type="text/css" />
    <script>
    function isDelete(){
    	if(confirm('정말로 삭제하시겠습니까?')){
    		location.replace('Delete.jsp?no=<%=record.getNo()%>&nowPage=<%=nowPage%>');
    	}
    }
    
    
    </script>
</head>
<body>
    <div class="allWrap">
        <div class="partWrap">
            <!--탑메뉴 및 로고 감싸는 div시작-->
            <div class="header">
                <div class="logo">
                    <img src="../Images/logo.gif" alt="로고이미지" />
                </div>
                <div class="topMenu">
                   <jsp:include page="/Template/Top.jsp"/>
                </div>
            </div>
            <!--탑메뉴 및 로고 감싸는 div끝-->
            <!--Left메뉴 및 실제 내용 감싸는 div시작-->
            <div class="section">
                <div class="leftMenu">
                    <jsp:include page="/Template/Left.jsp"/>
                </div>
                <div class="body">
                    <div class="content">
                        <fieldset style="padding:20px 0 50px 20px">
			               <legend>글 상세보기 페이지</legend>
		                      <table width="75%" bgcolor="gray" cellspacing="1">
		                      <tr bgcolor="white" >
		                        <td width="30%" align="center">작성자</td>
		                        <td >
		                        	<%=record.getName() %>
		                        </td>
		                       </tr>        
		                       <tr bgcolor="white" >
		                        <td width="30%" align="center">작성일</td>
		                        <td >
		                        	<%=record.getPostDate() %>
		                        </td>
		                       </tr>           
		                       <tr bgcolor="white" >
		                        <td width="30%" align="center">조회수</td>
		                        <td >
		                        	<%=record.getVisitCount() %>
		                        </td>
		                       </tr>
		                       <tr bgcolor="white" >
		                        <td width="30%" align="center">제목</td>
		                        <td >
		                        	<%=record.getTitle() %>
		                        </td>
		                       </tr>
		                       <tr bgcolor="white" >
		                        <td align="center">내용</td>
		                        <td>
		                       		<%=record.getContent().replace("\r\n", "<br/>") %>
		                        </td>
		                        
		                       </tr>
		                       <tr bgcolor="white" align="center">
		                        <td colspan="2">
		                        <%if(session.getAttribute("USER_ID").toString().equals(record.getId())){ %>
		                        	<a href="Edit.jsp?no=<%=record.getNo()%>&nowPage=<%= nowPage%>">수정</a> | 
		                        	<a href = "javascript:isDelete()">삭제</a> | 
		                        <%}//if %>
		                        	<a href="List.jsp?nowPage=<%= nowPage%>&<%=queryString%>">목록</a>
		                        </td>
		                       </tr>                   
		                      </table> 
		                     <!-- 이전글/다음글 -->
	                        <table width="75%" >
	                              <tr>
	                               <td width="15%">이전글:</td>
	                               <td><%=map.get("PREV")==null?"이전글이 없습니다":String.format("<a href='View.jsp?no=%s'>%s</a>",map.get("PREV").getNo(),map.get("PREV").getTitle()) %></td>
	                              </tr>
	                              <tr>
	                               <td>다음글:</td>
	                               <td><%=map.get("NEXT")==null?"다음글이 없습니다":String.format("<a href='View.jsp?no=%s'>%s</a>",map.get("NEXT").getNo(),map.get("NEXT").getTitle()) %></td>
	                              </tr>
	                        </table> 
			           </fieldset>  
                    </div>
                </div>
            </div>
            <!--Left메뉴 및 실제 내용 감싸는 div끝-->
            <!--footer를 감싸는 div시작-->
            <div class="footer">
                 <jsp:include page="/Template/Footer.jsp"/>
            </div>
            <!--footer를 감싸는 div끝-->
        </div>
    </div>
</body>
</html>
