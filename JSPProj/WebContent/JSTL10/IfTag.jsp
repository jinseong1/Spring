<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>IfTag.jsp</title>
</head>
<body>
	<fieldset>
		<legend>if태그</legend>
		<c:set var="numvar" value="100"></c:set>
		<c:set var="strvar" value="JSTL"/>
		<!-- if태그는 시작 태그와 종료 태그를 사용해서 판단해라.
		 	else문이 없다 -->
		<c:if test="${numvar mod 2 eq 0 }" var="result">
			${numvar }는 짝수<br/>
		</c:if> 
		\${result } : ${result }<br/>
		<c:if test="${not result }">
			${numvar }는 홀수다<br/>
		</c:if>
		<c:if test="${numvar % 2 != 0 }" var="result">
			${numvar }는 홀수
		</c:if>
		\${result } : ${result }<br/>
		<h2>위의 if문(JSTL)을 EL의 삼항 연산자로 변경</h2>
		${numvar }${numvar mod 2 eq 0 ? '는 짝수' : '는 홀수' }
		<h2>문자열 비교</h2>
		<c:if test="${strvar=='제이에스티엘' }">
			${strvar }는 "제이에스티엘"이다
		</c:if>
		<c:if test="${strvar=='jstl' }">
			${strvar }는 "jstl"이다
		</c:if>
		<c:if test="${strvar=='JSTL' }">
			${strvar }는 "JSTL"이다
		</c:if>
		<h2>항상 출력 혹은 출력 안되는 조건식</h2>
		<c:if test="${     true    }">
			항상 출력되는 조건식
		</c:if>
		<c:if test="${false}">
			항상 출력안되는 조건식
		</c:if>
		<!-- 
		※test속성에 EL식이 아닌 일반 값을 넣으면 무조건 거짓
		또한 EL식이더라도 {}양쪽에 빈 공백이 들어가면 무조건 거짓
		단, 일반 값이라도 true(TRUE)인 (대소문자 상관없이) 경우는  true로 판단됨 
		 -->
		 <h2>test속성에 일반값으로 조건설정</h2>
		 <c:if test="100" var="result">
		 	100은 참이다
		 </c:if>
		 \${result } : ${result }<br/>
		 <c:if test="100 > 10" var="result">
		 	100 > 10 은 참이다
		 </c:if>
		 \${result } : ${result }<br/>
		  <c:if test="TruE" var="result">
		 	TruE은 참이다<br/>
		 </c:if>
		 \${result } : ${result }<br/>
		<c:if test="false" var="result">
		 	false은 참이다<br/>
		 </c:if>
		 \${result } : ${result }<br/>
		<h2>※EL로 조건 설정시 {}바깥 양쪽에 공백이 있으면 조건이 참이라도 무조건 거짓</h2>
		\${       100>10        } : ${       100>10        }<br/>
		\${    true  } : ${    true  }<br/>
		<c:if test="  ${       100>10        }" >
			참이다<br/>		
		</c:if>
		<c:if test="${       true      }  " >
			참이다<br/>		
		</c:if>
		 <h2>표현식으로 조건식 설정</h2>
		<!-- 
		표현식으로 조건식을 구성할떄는 %>이후에
		바로""를 붙여야한다.(안그러면 500에러)
		< %= 앞쪽에 빈 공백이 붙으면 조건식이 true라도 결과값은 무조건 false
		 -->
		<%=100 > 10 %><br/>
		<c:if test="  <%=100 > 10 %>">
			참이다<br/>
		</c:if>	
		<h2>if태그 연습</h2>
		<!--
		문]파라미터로 아이디(user)와 비밀번호(pass)를 받아서 아이디가 
		"KIM"이고 비밀번호가 "1234"인 경우 회원이라고 가정하자.
		회원인 경우 "$ { EL로 출력}님 즐감하세요"출력
		비회원인 경우는 "아이디와 비번이 틀려요" 출력
		단, EL과 JSTL만 사용해서 구현하라
		 --> 
		 <c:set var="id" value="${param.user }" />
		 <c:set var="pwd" value="${param.pass }" />
		 <c:if test="${! empty id and not empty pwd }">
		 	<c:if test="${id=='KIM' && pwd eq '1234' }" var="result">
		 		<span style="color:green;font-size: 1.8em">${id }</span>님 즐감하세요
		 	</c:if>
		 	<c:if test="${!result }">
			 	<span style="color:red;font-size: 1.4em">아이디와 비번</span>이 틀려요	 	
		 	</c:if>
		 </c:if>
		 	
		 
	</fieldset>
	
	<h2>set태그로 EL에서 사용할 변수 설정</h2>
		 <ul style="list-style-type: upper-roman;">
		 	<li></li>
		 </ul>
</body>
</html>