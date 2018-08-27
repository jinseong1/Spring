<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>Grid04.jsp</title>
	
    <!-- 부트스트랩 -->
    <link href="<c:url value='/Bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="<c:url value='/Bootstrap/js/bootstrap.min.js'/>"></script>
  	<style>
  		.row div{
  			background-color:gray;
  			border:1px red solid;  			
  		}
  	
  	</style> 
  	<script>
  		$(function(){
  			
  			window.onresize= function(){
  				$("#display_width").html(window.innerWidth);
  				  				
  			};
  			
  		});  	
  	</script> 
  </head>
  <body>
   
   <div class="page-header" ><h1 id="display_width">해상도</h1></div>
   
   <div class="container-fluid">
   		<h2>반응형유틸리티:visible-*-*</h2>
   		<h3>행에 적용하기</h3>
   		<div class="row">
   			<div class="col-xs-4">.col-xs-4</div>
   			<div class="col-xs-4">.col-xs-4</div>
   			<div class="col-xs-4">.col-xs-4</div>
   		</div>
   		<!-- 
   		visible-md-block visible-lg-block
   		md모드와 lg모두에서만 보이도록 설정
   		 -->
   		<div class="row visible-md-block visible-lg-block">
   			<div class="col-md-4">.col-md-4</div>
   			<div class="col-md-4">.col-md-4</div>
   			<div class="col-md-4">.col-md-4</div>
   		</div>
   		<h3>컬럼에 적용하기</h3>
   		<div class="row">
   			<div class="col-xs-4">.col-xs-4</div>
   			<div class="col-xs-4">.col-xs-4</div>
   			<div class="col-xs-4">.col-xs-4</div>
   		</div>
   		<div class="row">
   			<div class="col-md-4">.col-md-4:1번 컨텐츠</div>
   			<div class="col-md-4">.col-md-4:2번 컨텐츠</div>
   			<div class="col-md-4 visible-md-block">.col-md-4:3번 컨텐츠</div>
   		</div>
   		<h2>반응형 컬럼 초기화:clearfix</h2>
   		<div class="row">
		  <div class="col-xs-6 col-sm-3">.col-xs-6<br/> .col-sm-3</div>
		  <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3</div>
		  <!--  xs모들일때만 clearfix가 적용되도록  visible-xs-block추가-->
		  <div class="clearfix visible-xs-block"></div>		
		  <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3</div>
		  <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3</div>
		</div>
   </div>
   
    
    
  </body>
</html>