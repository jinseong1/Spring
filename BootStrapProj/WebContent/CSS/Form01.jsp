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
    <title>Form01</title>
	
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
    	<h2>기본 폼</h2>
    	<form>
		  	<div class="form-group">
		    	<label for="exampleInputEmail1" >이메일 주소</label>
		    	
		    	<input type="email" class="form-control"  id="exampleInputEmail1" placeholder="이메일을 입력하세요">
		  		
		  	</div>
		 	<div class="form-group">
		    	<label for="exampleInputPassword1">암호</label>
		    	<input type="password" class="form-control"  id="exampleInputPassword1" placeholder="암호">
		 	</div>
		 	<div class="form-group">
		    	<label for="exampleInputFile">파일 업로드</label>
		    	<input type="file" id="exampleInputFile"  >
		    	<p class="help-block">여기에 블록레벨 도움말 예제</p>
		 	</div>
		  	<div class="form-group">
			    <label>
			      <input type="checkbox" > 입력을 기억합니다
			    </label>
		 	</div>
		  <button type="submit" class="btn btn-primary" >제출</button>
		</form>
		<h2>인라인 폼</h2>
		<form class="form-inline">
		  <div class="form-group">
		    <label for="exampleInputName2">Name</label>
		    <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputEmail2">Email</label>
		    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
		  </div>
		  <button type="submit" class="btn btn-default">Send invitation</button>
		</form>
		<h2>수평 폼</h2>
		<!-- 
		
		폼의 가로폭은 <div >로 감싼후 col-*-*계열로 설정
		폼의 세로폭는 .input-lg 또는 .input-sm 선택자를 .form-control 선택자와 함께 입력
		 -->
		<form class="form-horizontal">
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2  control-label">Email</label>
			   	<div class="col-sm-5">
			      <input type="email" disabled class="form-control input-lg" id="inputEmail3" placeholder="Email">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
			    <div class="col-sm-5">
			      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
			    </div>
			  </div>
			  <div class="form-group">
			  	<div class="col-sm-offset-2 col-sm-10">
			  		<div class="radio">
				  		<label>
				          <input type="radio" name="gender"> 남자
				        </label>
				        <label>
				          <input type="radio" name="gender"> 여자
				        </label>
				     </div>
			  	</div>
			  </div>
			  
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="checkbox">
			        <label>
			          <input type="checkbox"> Remember me
			        </label>
			      </div>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Sign in</button>
			    </div>
			  </div>
			</form>
		
		
		
    </div>
  </body>
</html>