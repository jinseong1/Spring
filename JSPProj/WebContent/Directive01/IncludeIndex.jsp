<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>IncludeIndex.jsp</title>
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
                   <%@ include file="/Template/Top.jsp" %>
                </div>
            </div>
            <!--탑메뉴 및 로고 감싸는 div끝-->
            <!--Left메뉴 및 실제 내용 감싸는 div시작-->
            <div class="section">
                <div class="leftMenu">
                   <%@ include file="/Template/Left.jsp" %>
                </div>
                <div class="body">
                    <div class="content">
                        <h2>대문 페이지</h2>
                        <%@ include file="IncludePage.jsp" %>
                        <%=todayString %>
                    </div>
                </div>
            </div>
            <!--Left메뉴 및 실제 내용 감싸는 div끝-->
            <!--footer를 감싸는 div시작-->
            <div class="footer">
                <%@ include file="/Template/Footer.jsp" %>
            </div>
            <!--footer를 감싸는 div끝-->
        </div>
    </div>
</body>
</html>
