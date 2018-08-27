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
    <title>ScrollSpy.jsp</title>
	
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
  		/* 네비바 크기 50임으로 패딩으로 내용을 네비바 밑으로..안그러면 먹는다*/
  		body{
  			padding-top:70px;
  		}
  		/* 테스트 용*/
  		.scrollspy-content{
  			overflow:auto;
  			position:relative;
  			height:100px;
  		}  	
  	</style>
  </head>
  <body>
    <div class="container">  
    
    		<!-- 네비게이션 바  시작-->
		    <nav id="navbar" class="navbar navbar-default navbar-fixed-top">
		      <div class="container">
		        <div class="navbar-header">
		          <button class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-scrollspy">
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		          <a class="navbar-brand" href="#">회사로고 이미지</a>
		        </div>
		        <div class="collapse navbar-collapse navbar-scrollspy">
		          <ul class="nav navbar-nav navbar-right">
		            <li><a href="#menu1">메뉴1</a></li>
		            <li><a href="#menu2">메뉴2</a></li>
		            <li><a href="#menu3">메뉴3</a></li>
		          </ul>
		        </div>
		      </div>
		    </nav>
		    <!-- 네비게이션 바  끝-->
		    <!-- 내용 시작 -->
		    <div class="scrollspy-content" data-spy="scroll" data-target="#navbar" data-offset="10">
		      <h4 id="menu1">메뉴1 소개글</h4>
		      <p>Ad leggings keytar, brunch id art party dolor labore. Pitchfork yr enim lo-fi before they sold out qui. Tumblr farm-to-table bicycle rights whatever. Anim keffiyeh carles cardigan. Velit seitan mcsweeney's photo booth 3 wolf moon irure. Cosby sweater lomo jean shorts, williamsburg hoodie minim qui you probably haven't heard of them et cardigan trust fund culpa biodiesel wes anderson aesthetic. Nihil tattooed accusamus, cred irony biodiesel keffiyeh artisan ullamco consequat.</p>
		      <h4 id="menu2">메뉴2 소개글</h4>
		      <p>Veniam marfa mustache skateboard, adipisicing fugiat velit pitchfork beard. Freegan beard aliqua cupidatat mcsweeney's vero. Cupidatat four loko nisi, ea helvetica nulla carles. Tattooed cosby sweater food truck, mcsweeney's quis non freegan vinyl. Lo-fi wes anderson +1 sartorial. Carles non aesthetic exercitation quis gentrify. Brooklyn adipisicing craft beer vice keytar deserunt.</p>
		      <h4 id="menu3">메뉴3 소개글</h4>
		      <p>Occaecat commodo aliqua delectus. Fap craft beer deserunt skateboard ea. Lomo bicycle rights adipisicing banh mi, velit ea sunt next level locavore single-origin coffee in magna veniam. High life id vinyl, echo park consequat quis aliquip banh mi pitchfork. Vero VHS est adipisicing. Consectetur nisi DIY minim messenger bag. Cred ex in, sustainable delectus consectetur fanny pack iphone.</p>
     	    </div>
		 	<!-- 내용 끝 -->
    
    </div>
  </body>
</html>