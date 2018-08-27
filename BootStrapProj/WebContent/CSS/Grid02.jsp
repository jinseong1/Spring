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
    <title>Grid02.jsp</title>
	
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
  			outline:1px red solid;
  			height:100px;
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
   
   <!--  
   <div class="container">고정폭 -->
 	
   <div class="container-fluid"><!-- 유동적으로 너비가 변함-화면에 꼭참
   
		
		<div class="row">
		  <div class="col-xs-12 col-md-8">.col-xs-12 .col-md-8</div>
		  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
		</div>
		
		<!-- 컬럼들은 모바일에서 50% 너비로 시작하고 데스크탑에서는 33.3% 너비가 됩니다 -->
		<div class="row">
		  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
		  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
		  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
		</div>
		
		<!-- 컬럼들은 모바일과 데스크탑에서 항상 50% 너비가 됩니다 -->
		<div class="row">
		  <div class="col-xs-6">.col-xs-6</div>
		  <div class="col-xs-6">.col-xs-6</div>
		</div>
		<!--  응용 --> 
		<div class="row">
			<div class="col-xs-12 col-md-4">컨텐츠1</div>
			<div class="col-xs-12 col-md-4">컨텐츠2</div>
			<div class="col-xs-12 col-md-4">컨텐츠3</div>
		</div>  
    </div>
    
    
  </body>
</html>