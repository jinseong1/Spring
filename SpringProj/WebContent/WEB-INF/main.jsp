<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Main.jsp</title>	
    <link href="<c:url value='/Bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">   
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="<c:url value='/Bootstrap/js/bootstrap.min.js'/>"></script>
  	
  </head>
  <body>
  	<div class="container">
	    <!-- 네비게이션바 -->
	    <jsp:include page="/WEB-INF/replyBbs/template/Top.jsp"/>
	    <!-- 네비게이션바 -->	    
	    <div class="container"><!-- 내용 시작 -->
	    	<div class="page-header">
		  		<h1>답변형 게시판 프로젝트<small>메인 페이지</small></h1>
			</div>			
			<div class="row">
				<div class="col-md-11">
					<a href="#">타일즈 테스트</a>
				</div>
			</div>
    	</div><!-- 내용 끝 -->
    	<jsp:include page="/WEB-INF/replyBbs/template/Footer.jsp"/>
    </div><!-- container -->
    
    
  </body>
</html>