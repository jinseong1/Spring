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
    <title>List.jsp</title>
	
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
    		$(".downfile").click(function(){
    			var numbering=$(this).attr("title");
    			$("#downcount"+numbering).html(parseInt($("#downcount"+numbering).html())+1);
    			
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
	   			<h1>자료실  <small>목록</small></h1>
			</div>
			<div class="row" style="margin-bottom: 10px">
				<div class="col-md-11 text-right">
					<a href="<c:url value='/DataRoom/Write.kosmo'/>" class="btn btn-success">등록</a>
				</div>
			</div>	
			<div class="row">
				<!-- 테이블 전체 가로폭은  테이블을 감싸는 div의 col-*-*로 조정-->
				<div class="col-md-11">
			    	<table class="table table-hover table-bordered text-center">
			    		<tr >
			    			<!-- 각 컬럼의 폭은 <td>계열에 class="col-*-*"추가 -->
			    			<th class="col-md-1 text-center">번호</th>
			    			<th class="text-center">제목</th>
			    			<th class="col-md-1 text-center">작성자</th>
			    			<th class="col-md-2 text-center">첨부파일</th>
			    			<th class="col-md-1 text-center">다운로드수</th>
			    			<th class="col-md-1 text-center">등록일</th>
			    		</tr>
			    		<c:if test="${empty list}" var="isEmpty">
				    		<tr>
				    			<td colspan="6" >등록된 게시물이 없어요</td>
				    		</tr>
			    		</c:if>
			    		<c:if test="${not isEmpty}">
			    			<c:forEach var="record" items="${list}" varStatus="loop">
					    		<tr>
					    			<td>${totalRecordCount - (((nowPage - 1) * pageSize) + loop.index)}</td>
					    			<td class="text-left"><a href="<c:url value='/DataRoom/View.kosmo?no=${record.no}'/>">${record.title}</a></td>
					    			<td>${record.name}</td>
					    			<td><a class="downfile" title="${loop.count}"href="<c:url value='/DataRoom/Download.kosmo?no=${record.no}&filename=${my:urlEncoding(record.attachedfile) }'/>">${record.attachedfile}</a></td>
					    			<td id="downcount${loop.count}">${record.downcount}</td>
					    			<td>${record.postdate}</td>
					    		</tr>
				    		</c:forEach>
				    	</c:if>	
			    	</table>
		    	</div>	
			</div>
			<div class="row">
				<div class="col-md-11" >
					${pagingString}
				</div>
			</div>
		</div>
		<!-- 내용 끝 -->
    </div>
  </body>
</html>