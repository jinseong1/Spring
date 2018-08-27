<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>UrlTag.jsp</title>
</head>
<body>
	<fieldset>
		<legend>url태그</legend>
		<!-- url 생성시 사용]
			-절대경로로 생성시에는 역시 
			컨텍스트 루트 제외 즉 컨텍스트 루트 신경쓸 필요 없다
			-var 속성 미지정시에는 
		
		 -->
		 <h2>var속성 미 지정</h2>
		 <c:url value="/JSTL10/ImportedPage.jsp">
		 	<c:param name="user" value="KIM" />
		 	<c:param name="pass" value="1234" />
		 </c:url>
		 <h2>var속성 지정</h2>
		 <c:url value="/JSTL10/ImportedPage.jsp" var="url">
		 	<c:param name="user" value="KIM" />
		 	<c:param name="pass" value="1234" />
		 </c:url>
		 <!-- var속성에  지정한 변수에 url이 저장됨
		 	해당 위치에 출력되지 않음
		 -->
		 <h2>내가 원하는 위치에 URL출력</h2>
		 <a href="${url}">ImportedPage.jsp</a>
		 <h2>HTML태그 안에서 JSTL로 절대경로 지정</h2>
		
		 <a href =' <c:url value="/JSTL10/ImportedPage.jsp?user=KIM&pass=8989"/>'>ImportedPage.jsp</a>
	</fieldset>
	
</body>
</html>