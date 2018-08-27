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
    <title>NavigationBar.jsp</title>
	
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
  			/*body의 최소 크기를 2000px로 하여 컨텐츠의 영역을  일부러
  		  확장하여 스크롤바가 생기도록 css를 설정함-네비게이션바가 상단에 고정되는지 테스트 하기 위함
  		  */ 
  		body { 
  		min-height:2000px;  		
  		 }
  	</style>
  </head>
  <body>
    
    	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		    <!-- 화면크기가 작을때 보여지는 메뉴버튼 -->
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapseMenu">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>		        
		      </button>		    
		      <a class="navbar-brand" href="#">
		         	회사로고이미지
		      </a>
		    </div><!-- navbar-header -->
		    <!-- 화면 크기가 클때 상단에 보이는 메뉴 -->
		    <div class="collapse navbar-collapse" id="collapseMenu">
		    	<!-- 메뉴에 폼 추가 -->
		    	 <form class="navbar-form navbar-right" >
			        <div class="form-group">
			          <input type="text" class="form-control" placeholder="검색">
			        </div>
			        <button type="submit" class="btn btn-default">확인</button>
			      </form>
		    	<ul class="nav navbar-nav navbar-right">
		    		<li class="active"><a href="#">메뉴1</a></li>
        			<li><a href="#">메뉴2</a></li>
        			<li class="dropdwon ">
				    	<a data-toggle="dropdown" class="dropdown-toggle" id="dropdownButton">
				    		드랍다운<span class="caret"></span>
				    	</a>
				    	<ul class="dropdown-menu dropdown-menu-right">
				    	 	<li class="dropdown-header">메뉴 리스트</li>
						    <li ><a  href="#">메뉴1</a></li>
						    <li ><a  href="#">메뉴2</a></li>
						    <li ><a  href="#">메뉴3</a></li>
						    <li class="divider"></li>
						    <li ><a  href="#">메뉴4</a></li>
						</ul>
				      </li>
		    	</ul>
		    	
		    </div>
		  </div><!-- div:container-fluid -->
		</nav>
		<div class="container">
			<h2>테이블</h2>
	    	<div class="row">
	    		<div class="col-md-offset-1 col-md-5">
			    	<table class="table">
			    		<tr>
			    			<th>번호</th><th>제목</th><th>작성자</th><th>조회수</th>
			    		</tr>
			    		<tr>
			    			<td>1</td><td>제목1</td><td>김길동1</td><td>100</td>
			    		</tr>
			    		<tr>
			    			<td>2</td><td>제목2</td><td>김길동2</td><td>200</td>
			    		</tr>
			    		<tr>
			    			<td>3</td><td>제목3</td><td>김길동3</td><td>300</td>
			    		</tr>
			    		<tr>
			    			<td>4</td><td>제목4</td><td>김길동4</td><td>400</td>
			    		</tr>  
			    			
			    	</table>
		    	</div>
		    	<div class="col-md-offset-1 col-md-4">
			    	<table class="table table-hover">
			    		<tr>
			    			<th>번호</th><th>제목</th><th>작성자</th><th>조회수</th>
			    		</tr>
			    		<tr>
			    			<td>1</td><td>제목1</td><td>김길동1</td><td>100</td>
			    		</tr>
			    		<tr>
			    			<td>2</td><td>제목2</td><td>김길동2</td><td>200</td>
			    		</tr>
			    		<tr>
			    			<td>3</td><td>제목3</td><td>김길동3</td><td>300</td>
			    		</tr>
			    		<tr>
			    			<td>4</td><td>제목4</td><td>김길동4</td><td>400</td>
			    		</tr>  
			    			
			    	</table>
		    	</div>    	
	    	</div>		
		</div>

  </body>
</html>