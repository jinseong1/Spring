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
    <title>Carousel.jsp</title>
	
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
    <script>
    	$(function(){
    		$('.carousel').carousel({
    			  interval: 3000
    			});    		
    	});
    
    </script>
  </head>
  <body>
    <div class="container">
    	<div id="carousel" class="carousel slide" data-ride="carousel">
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#carousel" data-slide-to="0" class="active"></li>
		    <li data-target="#carousel" data-slide-to="1"></li>
		    <li data-target="#carousel" data-slide-to="2"></li>
		  </ol>
  		  <!-- Wrapper for slides -->
		  <div class="carousel-inner">
		    <div class="item active">
		      <img src="../Images/sumnail.jpg" alt="슬라이드1" style="width:100%;height:200px">
		      <div class="carousel-caption">
		        <h2>첫번째 슬라이드</h2>
		      </div>
		    </div>
		    <div class="item">		    
		      <img src="../Images/sumnail.jpg" alt="슬라이드2" style="width:100%;height:200px">		      
		      <div class="carousel-caption">
		        <h2>두번째 슬라이드</h2>
		      </div>
		    </div>
		    <div class="item">
		      <a href="http://www.nate.com"><img src="../Images/sumnail.jpg" alt="슬라이드3" style="width:100%;height:200px"></a>
		      <div class="carousel-caption">
		        <h2>세번째 슬라이드</h2>
		      </div>
		    </div>		    
		  </div>
	
	  <!-- Controls -->
	  <a class="left carousel-control" href="#carousel" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left"></span>	   
	  </a>
	  <a class="right carousel-control" href="#carousel" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" ></span>	   
	  </a>
	</div> <!-- ccarousel -->   
    </div><!-- container -->
  </body>
</html>