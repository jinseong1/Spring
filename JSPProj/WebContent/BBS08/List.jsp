<%@page import="model.PagingUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.BbsDTO"%>
<%@page import="java.util.List"%>
<%@page import="model.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Common/IsMember.jsp" %>
<%
	//한글처리
	request.setCharacterEncoding("utf-8");
	//검색과 관련된 파라미터 받기]
	String searchColumn = request.getParameter("searchColumn");
	String searchWord = request.getParameter("searchWord");
	
	Map<String,Object> map = new HashMap<String,Object>();
	String queryString="";
	if(searchColumn!=null){
		//검색시 나타난 페이징 번호 클릭시 처리하기 위한 추가 쿼리 스트링
		queryString+="searchColumn="+searchColumn+"&searchWord="+searchWord+"&";
		map.put("column", searchColumn);
		map.put("word", searchWord);
	}
	BbsDAO dao = new BbsDAO(application);
	//페이징을 위한 로직 시작 ]
	//전체 레코드 수
	int totalRecordCount = dao.getTotalRecordCount(map);
	//페이지 사이즈
	int pageSize =Integer.parseInt(application.getInitParameter("PAGE_SIZE"));
	//블락 페이지
	int blockPage = Integer.parseInt(application.getInitParameter("BLOCK_PAGE"));
	//전체페이지 수
	int totalPage = (int)Math.ceil(((double)totalRecordCount/pageSize));
	//현재 페이지를 파라미터로 받기]
	int nowPage = request.getParameter("nowPage") ==null?1:Integer.valueOf(request.getParameter("nowPage"));
	//시작 및 끝 rownum구하기]
	int start =(nowPage-1)*pageSize+1;
	int end = nowPage*pageSize;
	map.put("start", start);
	map.put("end", end);
	//페이징을 위한 로직 끝]	
	List<BbsDTO> list = dao.selectList(map);
	dao.close();


%>
<!DOCTYPE html>
<html>
<head>
    <title>List.jsp</title>
	<meta charset="utf-8" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/Styles/divLayout.css" type="text/css" />
</head>
<body>
    <div class="allWrap">
        <div class="partWrap">
            <!--탑메뉴 및 로고 감싸는 div시작-->
            <div class="header">
                <div class="logo">
                    <img src="${pageContext.request.contextPath }/Images/logo.gif" alt="로고이미지" />
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
			               <legend>회원제 게시판 목록(<%=nowPage %>/<%=totalPage %>)</legend>
				               <table width="100%" >
	                            <tr align="right">
	                             <td><a href="Write.jsp">글작성</a></td>
	                            </tr>
	                          </table>
	                     
	                     
	                         <table width="100%" bgcolor="gray" cellspacing="1">
	                           <tr bgcolor="white" align="center">
	                            <th width="10%">번호</th>
	                            <th width="45%">제목</th>
	                            <th width="15%">작성자</th>
	                            <th width="10%">조회수</th>
	                            <th >작성일</th>
	                          </tr>
	                         	<%if(list.size()==0){ %>
	                             <tr bgcolor="white" align="center">
	                              <td colspan="5">등록된 글이 없어요</td>
	                             </tr>
	                             <%}else{ %>
	                              <!-- 아래 반복 --> 
	                         	<%
		                         	int loop=0;
		                         	for(BbsDTO record:list){ %>
		                             <tr bgcolor="white" align="center">
		                               <td><%=totalRecordCount - (((nowPage - 1) * pageSize) + loop) %></td>
		                               <td align="left"><a href="View.jsp?no=<%=record.getNo()%>&nowPage=<%=nowPage %>&<%=queryString%>"> <%=record.getTitle() %></td>
		                               <td><%=record.getName() %></td>
		                               <td><%=record.getVisitCount() %></td>
		                               <td><%=record.getPostDate() %></td>
		                             </tr>       
	                                <%
	                                loop++;
		                         	}//for %>                 
	                       		<%}//else%>
	                         </table> 
	                        <!-- 페이징 -->
	                        <table width="100%">
	                          <tr align="center">
	                            <td><%=PagingUtil.pagingText(totalRecordCount, pageSize, blockPage, nowPage, "List.jsp?"+queryString) %></td>
	                          </tr>
	                        </table>
	                       <!-- 검색UI -->
	                        <form method="post">
	                          <table width="100%">
	                           <tr align="center">
	                            <td>
	                            <select name="searchColumn">
	                             <option value="title">제목</option>
	                             <option value="name">작성자</option>
	                             <option value="content">내용</option>
	                            </select>
	                            <input type="text" name="searchWord"/>
	                            <input type="submit" value="검색"/>
	                            </td>
	                           </tr>
	                          </table>
	                        </form> 
				                             
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
