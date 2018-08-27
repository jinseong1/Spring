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
    <title>Button.jsp</title>
	
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
    	<h2>버튼들:button태그</h2>
    	<div class="row">
    		<div class="col-md-offset-1">
	    		<!-- Standard button -->
				<button type="button" class="btn btn-default" >Default</button>
				
				<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
				<button type="button" class="btn btn-primary">Primary</button>
				
				<!-- Indicates a successful or positive action -->
				<button type="button" class="btn btn-success">Success</button>
				
				<!-- Contextual button for informational alert messages -->
				<button type="button" class="btn btn-info">Info</button>
				
				<!-- Indicates caution should be taken with this action -->
				<button type="button" class="btn btn-warning">Warning</button>
				
				<!-- Indicates a dangerous or potentially negative action -->
				<button type="button" class="btn btn-danger">Danger</button>
				
				<!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
				<button type="button" class="btn btn-link">Link</button>
	    		
    		
    		</div>
    		<h2>버튼들:input type="button"태그 혹은 a태그 혹은 span태그</h2>
	    	<div class="row">
	    		<div class="col-md-offset-1">
		    		
					
					<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
					<input type="button" value="Primary" class="btn btn-primary"/>
					
					<!-- Indicates a successful or positive action -->
					<a class="btn btn-success">Success</a>
					
					<!-- Contextual button for informational alert messages -->
					<span class="btn btn-info">Info</span>
					<p class="btn btn-danger">P태그 입니다</p>
	    		</div>   		
    		</div>
    		<h2>버튼크기 및 활성화 비활성화:.btn-lg,.btn-sm,.btn-xs,.active ,.disabled</h2>
	    	<div class="row">
	    		<div class="col-md-offset-1">
		    		
					
					<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
					<input type="button" value="Primary" class="btn btn-primary btn-lg"/>
					
					<!-- Indicates a successful or positive action -->
					<a class="btn btn-success btn-sm">Success</a>
					
					<!-- Contextual button for informational alert messages -->
					<span class="btn btn-info btn-xs disabled">Info</span>
					<p class="btn btn-danger btn-lg active">P태그 입니다</p>
	    		</div>   		
    		</div>
    
    </div>
  </body>
</html>