<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- DataRoomTop.jsp -->
<style>
    	body{
    		padding-top:60px;
    	}
    	@media all and (min-width: 768px) {
			  .navbar-fixed-width {
			    width: 768px;
			    margin: 0 auto;
			 }
		}

		@media all and (min-width: 992px) {
		  .navbar-fixed-width {
		    width: 992px;
		    margin-left: auto;
		    margin-right:auto;
		  }

		}

		@media all and (min-width: 1200px) {
		  .navbar-fixed-width {
		    width: 1200px;
		    margin-left: auto;
		    margin-right:auto;
		  }
		}
		
		.active{
			font-weight: bold;
			font-size: 1.2em;
		}  
		  
</style>
<script>
	$(function(){
	      $(".navbar-right li a").click(function(){
	       
	        $('.navbar-right li').each(function(){
	         $(this).removeClass("active");
	        });       
	        
	        $(this).parent().addClass("active");
	    });
	});
 </script>
<!-- 네비게이션 바 시작  -->
  	<nav class="navbar navbar-default navbar-fixed-top navbar-fixed-width navbar-inverse">
	  <div class="container">
	    <div class="navbar-header">
	    <!-- 화면 크기가 작을때 보여지는 메뉴버튼  -->
	    	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapseMenu">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#" style="color:white;font-weight: bold">
		        	자료실 프로젝트
		      </a>
	    </div><!-- navbar-header -->
	    <!-- 화면 크기가 클때 상단에 보이는 메뉴 -->
	     <div class="collapse navbar-collapse" id="collapseMenu">
	     	 <ul class="nav navbar-nav navbar-right">
	     	 	
	     	 	<li <c:if test="${active=='INDEX'}" >class="active"</c:if>><a href="<c:url value='/DataRoom/Index.kosmo'/>">HOME</a></li>
       			<li><a href="#">로그인</a></li>
       			<li <c:if test="${active=='DATAROOM'}" >class="active"</c:if>><a href="<c:url value='/DataRoom/List.kosmo'/>">자료실</a></li> 
       			<li><a href="#">Q&A</a></li> 
	     	 </ul>
	     	 
	     </div>
	  </div><!-- div:contianer-fluid -->
	</nav>	
<!-- 네비게이션 바 끝  -->