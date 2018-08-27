<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>OutTag.jsp</title>
</head>
<body>
	<fieldset>
		<legend>out태그</legend>
		<!--  -->
				
		<%--
		<c:redirect url="SetTagIndex.jsp" />
		 --%>
		 
		<c:set  var="htmlString" ><h3>HTML태그로 감싼 문자열</h3></c:set>
		<h2>escapeXml="true"(디폴트):html태그 그대로 출력</h2>
		<c:out value="${htmlString}" escapeXml="true"/> 
		<h2>escapeXml="false":html태그 실행(EL과 동일)</h2>
		<c:out value="${htmlString}" escapeXml="false"/> <br/>
		\${htmlString} : ${htmlString}
		<h2>default속성</h2>
		<!-- out태그의 value속성의 값이 없을때
			default속성에 지정한 값을 출력함	
		 -->
		 <h3>빈 문자열인 경우: 값이 있는 경우로 판단됨</h3>
		 <c:out value="" default="빈 문자열"/>
		  <h3>null인 경우: 값이 없는 경우임</h3>
		 <c:out value="${param.name}" default="파라미터가 없음"/>
		 <h3>페이지 링크에 응용</h3>
		 <c:url value="/BBS08/List.jsp?nowPage="/><br/>
		 <c:out value="${param.nowPage }" default="1" /><br/>
		 
		 <a href='<c:url value="/BBS08/List.jsp?nowPage="/><c:out value="${param.nowPage }" default="1"/>'><c:out value="${param.nowPage }" default="1"/>페이지로 링크</a>
			
	
	</fieldset>
</body>
</html>