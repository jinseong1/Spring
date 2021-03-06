﻿<%@page import="model.BbsDTO"%>
<%@page import="java.util.List"%>
<%@page import="model.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Common/IsMember.jsp" %>
<%
	String no = request.getParameter("no");
	//현재 페이지 번호 받기
	String nowPage = request.getParameter("nowPage");
	BbsDAO dao = new BbsDAO(application);
	BbsDTO record = dao.selectOne(no);	
	dao.close();

%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit.jsp</title>
	<meta charset="utf-8" />
    <link rel="stylesheet" href="../Styles/divLayout.css" type="text/css" />
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
			               <legend>글 수정 페이지</legend>
			               <form action="EditOk.jsp" method="post">
			               	<input type="hidden" name="no" value="<%=record.getNo()%>"/>
			              	<input type="hidden" name="nowPage" value="<%=nowPage%>"/>
			               	
		                      <table width="75%" bgcolor="gray" cellspacing="1">                   
		                       <tr bgcolor="white" >
		                        <td width="30%" align="center">제목</td>
		                        <td >
		                        <input type="text"  name="title" style="width:98%" value="<%=record.getTitle() %>"/>
		                        </td>
		                       </tr>
		                       <tr bgcolor="white" >
		                        <td align="center">내용</td>
		                        <td>
		                        <textarea rows="10" style="width:98%" name="content" ><%=record.getContent() %></textarea>
		                        </td>
		                        
		                       </tr>
		                       <tr bgcolor="white" align="center">
		                        <td colspan="2">
		                        <input type="submit" value="수정"/>
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
