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
    <title>Modal.jsp</title>
	
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
  	<div class="container">
	    <h2>모달</h2>
	    <h3>모달 띄우기 기본</h3>
	    <button class="btn btn-primary" data-toggle="modal" data-target="#basicModal">
	  		모달 띄우기
		</button>
		<!-- 모달 창 -->
		<div class="modal fade" id="basicModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<!-- 모달닫기:data-dismiss="modal" -->
						<button class="close" data-dismiss="modal" >
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">모달창 입니다</h4>
					</div>
					<div class="modal-body">
						<h2>모달 바디 영역입니다</h2>
						<p>
							안녕하세요<br/>
							기본 모달 창입니다<br/>
							참 재미 있네요					
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn btn-primary" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>	
		</div>
		<h3>크기 옵션</h3>
		<h4>.modal-lg .modal-sm</h4>
		<button class="btn btn-primary" data-toggle="modal" data-target="#largeModal" >
	  		큰 모달
		</button>
		<button class="btn btn-primary" data-toggle="modal" data-target="#smallModal">
	  		작은 모달
		</button>
		<!-- 큰 모달 -->
			<div class="modal fade" id="largeModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						
						<button class="close" data-dismiss="modal" >
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">모달창 입니다</h4>
					</div>
					<div class="modal-body">
						<h2>모달 바디 영역입니다</h2>
						<p>
							안녕하세요<br/>
							기본 모달 창입니다<br/>
							참 재미 있네요					
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn btn-primary" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>	
		</div>
		<!-- 작은 모달 -->
		
		<!-- 배경 클릭해도 안닫히기:data-backdrop="static" -->
		<div class="modal fade " data-backdrop="static" id="smallModal">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						
						<button class="close" data-dismiss="modal" >
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">모달창 입니다</h4>
					</div>
					<div class="modal-body">
						<h2>모달 바디 영역입니다</h2>
						<p>
							안녕하세요<br/>
							기본 모달 창입니다<br/>
							참 재미 있네요					
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn btn-primary" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>	
		</div>
		<h2> 자바스크립트로 모달을 수동으로 띄우고 닫기</h2>
		<script>
			$(function(){
				
				$("#btnJsModal").click(function(){					
					$("#largeModal").modal("show");
					//2초에 자동으로 닫기]
					setTimeout(function(){
						$("#largeModal").modal("hide");
					},2000);
				});	
				
				$("#largeModal").on("show.bs.modal",function(e){
					console.log("show.bs.modal이벤트 발생:"+e);
					
				});
				$("#largeModal").on("shown.bs.modal",function(e){
					console.log("shown.bs.modal이벤트 발생:"+e);
					
				});
				$("#largeModal").on("hide.bs.modal",function(e){
					console.log("hide.bs.modal이벤트 발생:"+e);
					
				});
				$("#largeModal").on("hidden.bs.modal",function(e){
					console.log("hidden.bs.modal이벤트 발생:"+e);
					
				});
				
				
			});
		
		</script>
		<button class="btn btn-primary" id="btnJsModal">
	  		자바스크립트로 띄우기
		</button>
	</div>
	
  </body>
</html>