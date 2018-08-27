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
    <title>Table01.jsp</title>
	
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
  </head>
  <body>
    <div class="container-fluid">
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
	    	<!-- 테이블 컬럼폭은 col-*-*계열로 설정 -->
	    	<div class="col-md-offset-1 col-md-4">
		    	<table class="table table-hover">
		    		<tr>
		    			<th class="col-md-1">번호</th><th >제목</th><th class="col-md-3">작성자</th><th class="col-md-2">조회수</th>
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