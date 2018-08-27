<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login.jsp</title>
	
    <!-- 부트스트랩 -->
    <link href="<c:url value='/Bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="<c:url value='/Bootstrap/js/bootstrap.min.js' />"></script>
  </head>
  <body>
	<jsp:include page="/WEB-INF/replyBbs/template/Top.jsp"/>
  	<div class="container">
	  	<!-- 네비게이션 바 -->
	  	<!-- 네비게이션 바 -->
	  	<div class="container" >
			<div class = "page-header">
	  			<h1>답변형게시판  <small>로그인페이지</small></h1>
	  		</div>
			<div class="row">
				<div class="col-md-12">
					<form class="form-horizontal" method="post" action="<c:url value='/ReplyBBS/Member/LoginProcess.bbs'/>">
					  <div class="form-group">
					    <label for="id" class="col-sm-2 control-label">아이디</label>
					    <div class="col-sm-3">
					      <input type="text" class="form-control" name="id" id="id" placeholder="아이디를 입력하세요">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="pwd" class="col-sm-2 control-label">비밀번호</label>
					    <div class="col-sm-5">
					      <input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호을 입력하세요">
					    </div>
					  </div>
					   <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-danger">로그인</button>
					    </div>
					  </div>
					</form>
				</div>
			</div>	
	  	</div><!-- 내용끝 -->
	  		<jsp:include page="/WEB-INF/replyBbs/template/Footer.jsp"/>
    </div><!-- container -->
  </body>
</html>