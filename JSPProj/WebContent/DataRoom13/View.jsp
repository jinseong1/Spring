<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/WEB-INF/tlds/mytag.tld" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>View.jsp</title>
	
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
			$("#tabMenu a").click(function(){
				$(this).tab('show');
				if($(this).html()=='수정'){
					console.log("수정 클릭");
					$("input[name=mode]").val('UPDATE');
					$(".modal-title").html("수정용 비밀번호 입력창");
				}
				else if($(this).html()=='삭제'){
					console.log("삭제 클릭");
					if(confirm("정말로 삭제 하시겠습니까?")){
						$(".modal-title").html("삭제용 비밀번호 입력창");
						$("input[name=mode]").val('DELETE');
						$("#passwordModal").modal("show");
					}///////if
				}///else
			});
		});
	</script>
  </head>
  <style>
  	
  </style>
  <body>
  	<div class="container">
	  	<!-- 네비게이션 바 -->
	  	<jsp:include page="/Template/DataRoomTop.jsp" />
	  	<!-- 네비게이션 바 -->
	  	<!-- 내용 시작 -->
		<div class="container" >
			<div class = "page-header">
	   			<h1>자료실  <small>상세보기 페이지</small></h1>
			</div>
				
			<div class="row">
				<!-- 테이블 전체 가로폭은  테이블을 감싸는 div의 col-*-*로 조정-->
				<div class="col-md-11">
			    	<table class="table table-hover table-striped table-bordered ">
			    		<tr>
			    			<th class="col-md-2 text-center">번호</th>
			    			<td>${record.no }</td>
			    		</tr>
			    		<tr>
			    			<th class="col-md-2 text-center">제목</th>
			    			<td>${record.title }</td>
			    		</tr>
			    		<tr>
			    			<th class="col-md-2 text-center">작성자</th>
			    			<td>${record.name }</td>
			    		</tr>
			    		<tr>
			    			<th class="col-md-2 text-center">첨부파일</th>
			    				<c:url value="/DataRoom/Download.kosmo?filename=${filename}&no=${no }"/>
			    			<td><a href="<c:url value='/DataRoom/Download.kosmo?filename=${my:urlEncoding(record.attachedfile)}&no=${record.no}'/>">${record.attachedfile}</a></td>
			    		</tr>
			    		<tr>
			    			<th class="col-md-2 text-center">다운로드 수</th>
			    			<td>${record.downcount }</td>
			    		</tr>
			    		<tr>
			    			<th class="col-md-2 text-center">등록일</th>
			    			<td>${record.postdate }</td>
			    		</tr>
			    		<tr>
			    			<th colspan="2" class="text-center">내용</th>			    			
			    		</tr>
			    		<tr>
			    			<td colspan="2">
			    				${record.content }
			    			</td>			    			
			    		</tr>
			    		
			    	</table>
		    	</div>	
			</div><!-- row -->
			<div class="row">
				<div class="col-md-11">	
					<!-- .center-block사용시 해당 블락의 크기를 지정하자  -->
			    	<ul id="tabMenu" class="nav nav-pills center-block" style="width:195px">
					  <li><a href="#" data-toggle="modal" data-target="#passwordModal">수정</a></li>
					  <!-- 삭제 취소시에는 모달창이 뜨지 않도록 자스로 제어하기 위해: data-toggle="modal" 삭제 -->
					  <li><a href="#" data-target="#passwordModal">삭제</a></li>
					  <li><a href="<c:url value='/DataRoom/List.kosmo'/>">목록</a></li>
					</ul>
			    </div>	
			</div>
		</div>
		<!-- 내용 끝 -->
    </div>
    <div class="modal fade" id="passwordModal">
		<div class="modal-dialog ">
			<div class="modal-content">
				<div class="modal-header">
				<button class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title"></h4>
					
				</div>
				<div class="modal-body">
					<form id="passwordForm"class="form-inline" method="post" action="<c:url value='/DataRoom/Password.kosmo'/>">
					<input type="hidden" name="EDIT_FORM" value="YES"/>
					<!-- 키값 -->
					<input type="hidden" name="no" value="${record.no}"/>
					<!-- 파일명 -->
					<input type="hidden" name="originalfilename" value="${record.attachedfile}"/>
					<!-- 수정/삭제 판단용 -->
					<input type="hidden" name="mode" />
					  <div class="form-group">
					    <label for="pass">비밀번호</label>
					    <input  style="width:420px" type="password" class="form-control" id="pass" name="pass" placeholder="비밀번호 입력">
					  </div>
					  <button type="submit" class="btn btn-primary">확인</button>
					</form>	
				</div>
				
			</div>
		</div>
	</div>
  </body>
  
</html>