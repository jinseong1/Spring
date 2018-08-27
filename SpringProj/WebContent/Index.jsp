<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Index.jsp</title>
</head>
<body>
   	<fieldset>
   		<legend>스프링 프레임워크 테스트 하기</legend>
   		<!--		
			빈 설정파일명:서블릿명-servlet.xml
			빈 설정파일의 위치:web.xml하고 같은 위치 즉 WEB-INF 바로 밑.
			그래야 프레임워크가 설정파일을 읽을 수 있다.
		 -->
		 <h2>[기본 DispatcherServlet 사용]${requestScope.message}</h2>
		 <ul style="list-style-type: upper-roman;">
		 	
		 	<li><a href="<c:url  value='/Basic/Controller.do?message=Hello Spring Controller Interface!!!'/>">Controller인터페이스로 컨트롤러 구현</a></li>
		 	<li><a href="<c:url  value='/Basic/AbstractController.do?message=Hello Spring AbstractController Class!!!'/>">AbstractController클래스로 컨트롤러 구현</a></li>
		 	<li><a href="<c:url  value='/Basic/Annotation.do?message=Hello Spring Annotation!!!'/>">어노테이션으로 컨트롤러 구현</a></li>
		 
		 
		 </ul>
		 <h2>[또 다른 디스패처 서블릿 사용]</h2>
		 <c:url var="url" value="/Basic/AnotherDispatcher.kosmo?message=Hello Spring Another DispatcherServlet"/>
		 <a href="${url}">또 다른 디스패처 서블릿</a>
		 <h2>DispatcherServlet과 관련된 설정 파일 이름 및 위치 변경</h2>
		 <!-- 서블릿 초기화 파라미터 사용]
            -설정파일의 이름 및 위치 변경 가능
     
     		1]WEB-INF인 경우 : /로 시작  
		    <param-value>
		     /WEB-INF/폴더/임의의 이름.xml    
		    </param-value>
    
		    2]src 밑에 위치한 경우:classpath: 
		           패키지 구분은 /로
		      예]
		      classpath:a/b/c/config.xml
    	-->
    	<ul style="list-style-type:upper-latin;">
    	
    		<li><a href="<c:url value='/Basic/WEB-INF.nate?message=Hello Spring WEB-INF!!!'/>">WEB-INF에 폴더 생성후 설정 파일 위치시키기</a></li>
    		<li><a href="<c:url value='/Basic/SRC.daum?message=Hello Spring SRC!!!'/>">src(클래스 패스)에 패키지 생성후 설정 파일 위치시키기</a></li></li>
    	</ul>
   	</fieldset>
</body>
</html>