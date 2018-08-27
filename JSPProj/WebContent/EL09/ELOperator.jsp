<%@page import="java.util.Vector"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL(Java Standard Tag Library)사용시 
	taglib지시어를 이요해서 선언해야 한다. 
	단, 필요한 jar파일을 WEB-INF디렉토리 밑에 
	 lib에 넣어줘야 한다.
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>ELOperator.jsp</title>
</head>
<body>
	<fieldset>
		<legend>EL연산자들</legend>
		<h2>EL에서의 null연산</h2>
		<!--EL에서 null이 연산에 참여시 0으로 처리된다  -->
		<div>
			\${null + 10 } : ${null + 10 }<br/>
			\${null * 10 } : ${null * 10 }<br/>	
			\${param } : ${param }<br/>
			\${param.myparam + 10 } : ${param.myparam +10 }<br/>	
			\${param.myparam > 10 } : ${param.myparam >10 }<br/>	
			<% String varInScriptlet="스크립틀릿 안에서 선언한 변수"; %>	
			<!-- EL표현식 \${}에서는  jsp의 스크립팅 요소에서 선언한 
			변수를 직접 사용 못한다. 값이 출력 안됨. -->
			<!-- null로 처리됨 -->
			\${varInScriptlet} : ${varInScriptlet}<br/>
			<!-- 고로 EL식에서 사용할 변수는 JSTL을 이용해서 서언해야 한다. -->
			<h2>JSTL에서 EL에서 사용할 변수 선언 </h2>
			<c:set var="elVar" value="<%=varInScriptlet%>"/>
			\${elVar } : ${elVar }
			<h2>EL변수에 값 할당 불가(출력용이니까)</h2>
			<!-- 톰캣 8.0부터는 할당 가능(비권장): el-api.jar변경됨 -->
			<c:set var="fnum" value="9"/>
			<c:set var="snum" value="5"/>
			\${fnum=100 } : ${fnum=100 }
			<h2>EL의 산술 연산자</h2>
			<ul style="list-style-type: upper-roman;">
				<li>\${fnum + snum } : ${fnum + snum }</li>
				<li>\${fnum - snum } : ${fnum - snum }</li>
				<li>\${fnum * snum } : ${fnum * snum }</li>
				<li>\${fnum / snum } : ${fnum / snum }</li>
				<li>\${fnum % snum } : ${fnum % snum }</li>
				<li>\${fnum / snum } : ${fnum div snum }</li>
				<li>\${fnum % snum } : ${fnum mod snum }</li>
				<!-- EL에서는 숫자형식의 문자열을 자동으로 숫자로 형변환 -->
				<li>\${"100" + 100 } : ${"100" + 100  }</li>
				<!-- EL에서 +는 숫자 연산에만 사용가능. 문잦열 연결시 에러 -->
				<li>\${'Hello' + ' EL!!!' } : \${'Hello' + ' EL!!!' }</li>
			</ul>
			<h2>EL의 비교 연산자</h2>
			<c:set var="fnum" value="100"/>
			<c:set var="snum" value="9"/>
			<ul style="list-style-type: upper-roman;">
				<li>\${fnum > snum } : ${fnum > snum }</li>
				<li>\${100 gt 9 } : ${100 gt 9 }</li>
				<!-- 자바에서는 문자열 비교시 equals()메소드로 
				비교하나  EL에서는 ==로 비교 -->
				<li>\${'JSP' == 'JSP' } : ${'JSP' == 'JSP' } </li>
				<li>\${'JSP' eq 'JSP' } : ${'JSP' eq 'JSP' } </li>
				<li>\${'JSP' != 'JSP' } : ${'JSP' != 'JSP' } </li>
				<li>\${'JSP' ne 'JSP' } : ${'JSP' ne 'JSP' } </li>
			</ul>
			<h2>EL의 논리 연산자</h2>
			<ul style="list-style-type: upper-roman;">
				<li>\${5 > 2 && 10 != 10 } : ${5 > 2 && 10 != 10  }</li>		
				<li>\${5 > 2 && 10 != 10 } : ${5 ge 2 and 10 ne 10 }</li>
				<li>\${5 >= 2 || 10 <= 10 } : ${5 >= 2 || 10 <= 10  }</li>
				<li>\${5 >= 2 || 10 <= 10 } : ${5 ge 2 or 10 le 10  }</li>
			</ul>
			<h2>EL의 삼항 연산자</h2>
			\${ 10 gt 9 ? '10은 9보다 크다' : '10은 9보다 크지 않다' } : 
			${ 10 gt 9 ? '10은 9보다 크다' : '10은 9보다 크지 않다' } 
			<h2>EL의 empty연산자</h2>
			<!--  -->
			<%
			String nullString = null;
			String emptyString ="";
			Integer[] zeroLength = new Integer[0];
			Collection zeroSize = new Vector();			
			%>
			<!-- JSTL로 EL에서 사용할 변수 선언 -->
			<c:set var="elnullString" value="<%=nullString %>"/>
			<c:set var="elemptyString" value="<%=emptyString %>"/>
			<c:set var="elzeroLength" value="<%=zeroLength %>"/>
			<c:set var="elzeroSize" value="<%=zeroSize %>"/>
			<ul style="list-style-type: decimal;">
				<li>\${empty elnullString } : ${empty elnullString }</li>
				<li>\${ not empty elemptyString } : ${not empty elemptyString }</li>
				<li>\${empty elzeroLength } : ${empty elzeroLength? '크기가 0인 배열이다': '크기가 0이 아닌 배열이다' }</li>
				<li>\${! empty elzeroSize } : ${! empty elzeroSize? '객체가 저장되어있다': '객체가 저장되어 있지 않다' }</li>
			</ul>
		</div>
	</fieldset>
</body>
</html>