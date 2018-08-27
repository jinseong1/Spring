<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL코어 라이브러리 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 날짜나 숫자 포맷용 라이브러리 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 문자열이나 컬렉션등을 처리하기위한 함수 라이브러리 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>FunctionOfJSTL.jsp</title>
</head>
<body>
	<fieldset>
		<legend>JSTL의 함수 라이브러리</legend>
		<!-- JSTL에서 제공하는 함수들은 EL식에서 호출해야한다
			호출방법: \${접두어:함수명([매개변수들])}
			JSTL의 모든 함수는 항상 값을 반환한다.	
		 -->
		 <%String[] mountains={"한라산","성인봉","태백산","덕유산"}; %>
		 <!-- EL에서 사용할 변수들 선언 -->
		 <fmt:formatDate value="<%=new Date() %>" pattern="yyyy년 MM월 dd일" var="today"/>
		 <c:set var="todaystring">Today는 ${today}입니다</c:set>
		 <c:set var="interstring">Politics,Economics,Entertainments,Sports</c:set>
		 <c:set var="array" value="<%=mountains %>" />
		 <c:set var="collection" value="<%=new HashMap() %>" />
		 <c:set target="${collection}" property="user" value="KIM"/>
		 <c:set target="${collection}" property="pass" value="1234"/>
		 <h2>int length(Object)</h2>
		 <!-- 
		 	문자열인 경우는 문자열의 길이 반환
		 	(한글 1자도 길이1로 처리)
		 	배열인 경우는 배열의 크기(즉 메모리 개수) 반환
		 	컬렉션인 경우는 컬렑션에 저장된 객체의 수 반환	 
		  -->
		  <ul style="list-style-type: upper-roman;">
		  	<li>문자열의 길이:${fn:length(todaystring)}</li>
		  	<li>배열의 크기:${fn:length(array)}</li>
		  	<li>컬렉션에 저장된 객체 수(JSTL함수 이용):${fn:length(collection)}</li>
		  	<li>컬렉션에 저장된 객체 수(EL함수 이용):${collection.size()}</li>
		  </ul>
		  <h5>JSTL함수 이용</h5>
		  <c:if test="${fn:length(collection)!=0}" var="result">
		  	<c:forEach var="item" items="${collection}">
		  		${item} &nbsp;&nbsp;
		  	</c:forEach>
		  </c:if>
		  <c:if test="${! result}">
		  	저장된 객체가 없어요
		  </c:if>
		  <h5>EL함수 이용-size() 혹은 empty연산자</h5>
		  <c:if test="${collection.size()!=0 or not empty collection}" var="result">
		  	<c:forEach var="item" items="${collection}">
		  		${item} &nbsp;&nbsp;
		  	</c:forEach>
		  </c:if>
		  <c:if test="${! result}">
		  	저장된 객체가 없어요
		  </c:if>
		  <h2>String toUpperCase(String) 및 String toLowerCase(String)</h2>
		  <ul style="list-style-type: upper-roman;">
		  	<li>대문자로 변경: ${fn:toUpperCase(interstring)}</li>
		  	<li>소문자로 변경: ${fn:toLowerCase(interstring)}</li>
		  </ul>
		  <h2>String substring(문자열,시작인덱스,끝인덱스)</h2>
		  <!--
		  	문자열에서 시작인덱스부터 끝인덱스 -1 까지 추출,
		  	끝인덱스가 -1인 경우 시작인덱스부터
		  	문자열 끝까지 추출
		  	인덱스는 0부터 시작
		  -->
		  \${todaystring } : ${todaystring }
		  <ul style="list-style-type: upper-roman;">
		  	<li>0부터 5: ${fn:substring(todaystring,0,5) }</li>
		  	<li>7부터 끝까지: ${fn:substring(todaystring, 7,-1) }</li>
		  </ul>
		  <h2>String substringAfter(문자열, str):str이후의 문자열 반환</h2>
		  ${fn:substringAfter(todaystring,"Today")}
		  <h2>String substringBefore(문자열, str):str이전의 문자열 반환</h2>
		  ${fn:substringBefore(todaystring,"는")}
		  <h2>String trim(String):좌우의 공백 제거</h2>
		  \${"       J           S  T            L  " }(트림 미적용) : X${"       J           S  T            L   " }X<br/>
		  \${"       J           S  T            L  " }(트림 적용) : X${fn:trim("       J           S  T            L   ") }X<br/>
		  <h2>String replace(문자열,src,dest):문자열에서 src를 dest로 대체</h2>
		  \${fn:replace(todaystring,'Today','Tomorrow')} : ${fn:replace(todaystring,'Today','Tomorrow')}
		  <h4>방법1</h4>
		  <c:set var="temp" value="${fn:replace(todaystring,'Today','Tomorrow')}" /> 
		  ${fn:replace(temp,'6','7') }
		  <h4>방법2</h4>
		  ${fn:replace(fn:replace(todaystring,'Today','Tomorrow'),'6','7') }
		  <h2>boolean startsWith(문자열,str): 문자열이  str로 시작하면 true, 아니면 false</h2>
		  ${fn:startsWith(todaystring,'To')}
		  <h2>boolean endsWith(문자열,str): 문자열이  str로 끝나면 true, 아니면 false</h2>
		  ${fn:endsWith(todaystring,'다')}
		  <h2>String[] split(문자열,delim):문자열에서 delim(구분자)으로  문자열 분리</h2>
		  <c:set var="inter" value="${fn:split(interstring,',')}"/>
		  <c:forEach var="item" items="${inter}">
		  	 ${item} 
		  </c:forEach>
		  <h2>String join(배열,str):모든 배열 요소를 str로 연결해서 하나의 문자열로 반환</h2>
		  	\${fn:join(array,"▲")} : ${fn:join(array,"▲")}
		  <h2>String escapeXml(문자열): HTML태그를 그대로 출력하고자 할때</h2>
		    함수 라이브러리 사용: ${fn:escapeXml("<h3>함수 라이브러리 사용</h3>")}<br/>
		    코어 태그 사용: <c:out value='<h3>코어 태그 사용</h3>'/>
		  <h2>int indexOf(str1,str2): str1에서 str2의 인덱스 위치 반환</h2>
		  \${fn:indexOf(todaystring,'day')} : ${fn:indexOf(todaystring,'day')}<br/>
		  \${fn:indexOf(todaystring,'Day')} : ${fn:indexOf(todaystring,'Day')}<br/>
		  <h2>boolean contains(str1,str2): str1에 str2가 포함되었으면 true 아니면 false</h2>
		  \${fn:contains(todaystring,'day')} : ${fn:contains(todaystring,'day')}<br/>
		  \${fn:contains(todaystring,'Day')} : ${fn:contains(todaystring,'Day')}<br/>
		  <h2>boolean containsIgnoreCase(str1,str2): 대소문자 구분하지 않고 str1에 str2가 포함되었으면 true 아니면 false</h2>
		  \${fn:containsIgnoreCase(todaystring,'day')} : ${fn:containsIgnoreCase(todaystring,'day')}<br/>
		  \${fn:containsIgnoreCase(todaystring,'Day')} : ${fn:containsIgnoreCase(todaystring,'Day')}<br/>
	</fieldset>
</body>
</html>