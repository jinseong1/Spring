<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Index.jsp</title>
	
    <!-- 부트스트랩 -->
    <link href="<c:url value='/Bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="<c:url value='/Bootstrap/js/bootstrap.min.js' />"></script>
    <script>
    	$(function(){
    		
    		$('form').on('submit', function(){
    			if($("#writer").val()==""){
    				alert("아이디를 입력하세요");
    				$("#writer").focus();
    				return false;
        		}
    			if($("#title").val()==""){
    				alert("제목을 입력하세요");
    				$("#title").focus();
    				return false;
        		}
    			if($("#attachedfile").val()==""){
    				alert("파일을 첨부하세요");
    				$("#attachedfile").focus();
    				return false;
        		}
    			/* else{//파일을 첨부한 경우:최대 파일 업로드 용량 체크
    				
    				if($("#attachedfile").get(0).files[0].size > 1024*500){
    					alert("업로드 최대 용량(500KB)을 초과 했어요");
    					$("#attachedfile").focus();
    					return false;
    				}	
    			} */
    			if($("#pass").val()==""){
    				alert("비밀번호를 입력하세요");
    				$("#pass").focus();
    				return false;
        		}
    			if($("#content").val()==""){
    				alert("내용을 입력하세요");
    				$("#content").focus();
    				return false;
        		}
    		});
    	});
    
    </script>
  </head>
  <body>
  	<div class="container">
	  	<!-- 네비게이션 바 -->
	  	<jsp:include page="/Template/DataRoomTop.jsp" />
	  	<!-- 네비게이션 바 -->
	  	<!-- 내용 시작 -->
		<div class="container" >
			<div class = "page-header">
	   			<h1>자료실  <small>입력폼</small></h1>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form class="form-horizontal" method="post" action="<c:url value='/DataRoom/Write.kosmo'/>" enctype="multipart/form-data">
					  <div class="form-group">
					    <label for="name" class="col-sm-2 control-label">작성자</label>
					    <div class="col-sm-3">
					      <input type="text" class="form-control" name="name" id="name" placeholder="작성자를 입력하세요">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="title" class="col-sm-2 control-label">제목</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="attachedfile" class="col-sm-2 control-label">파일 업로드</label>
					    <div class="col-sm-5">
						    <input type="file" id="attachedfile" name="attachedfile">
						    <p class="help-block">파일을 첨부하세요</p>
					    </div>
					  </div>
					   <div class="form-group">
					    <label for="password" class="col-sm-2 control-label">비밀번호</label>
					    <div class="col-sm-3">
						    <input type="password" class="form-control" id="password" name="pass" placeholder="비밀번호를 입력하세요">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="content" class="col-sm-2 control-label">내용</label>
					    <div class="col-sm-5">
						    <textarea rows="10" type="password" class="form-control" id="content" name="content" placeholder="비밀번호를 입력하세요"></textarea>
					    </div>
					  </div>
					   <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-danger">등록</button>
					    </div>
					  </div>
					</form>
				</div>
			</div>	
		</div>
		<!-- 내용 끝 -->
    </div>
  </body>
</html>