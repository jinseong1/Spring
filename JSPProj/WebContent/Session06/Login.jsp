<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login.jsp</title>
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
                        <h2>대문 페이지</h2>
                        <fieldset style="padding:20px 0 50px 20px">
			                <legend>로그인 페이지</legend>  
			                   <span style="color:red;font-weight:bold"><%=request.getAttribute("ERROR")==null?"":request.getAttribute("ERROR") %></span>
			                    <form method="post" action="LoginProcess.jsp" > 
			                    <!-- 로그인에 된다면 세션영역에 저장시켜주고 로그 아웃은 없에야함 -->
			                     <table style="width:300px;border-spacing:1px;background-color:green">
			                      <tr style="background-color:white">
			                       <td style="width:25%">아이디</td>
			                       <td><input type="text" name="user" value="<%=request.getParameter("user")==null?"":request.getParameter("user")%>"/></td>
			                      </tr>
			                      <tr style="background-color:white">
			                       <td>비밀번호</td>
			                       <td><input type="password" name="pass" value="<%=request.getParameter("pass")==null?"":request.getParameter("pass")%>"/></td>
			                      </tr>
			                      <tr style="background-color:white;text-align:center">     
			                       <td colspan="2"><input type="submit" value="로그인"/></td>
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
