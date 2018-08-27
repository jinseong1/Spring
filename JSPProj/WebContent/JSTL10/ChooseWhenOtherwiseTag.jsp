<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 코어 태그 라이브러리 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 내가 만든 태그 라이브러리 사용 -->
<%@ taglib prefix="my" uri="/WEB-INF/tlds/mytag.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>ChooseWhenOtherwiseTag.jsp</title>
</head>
<body>
	<fieldset>
		<legend>choose ~ when ~ otherwise태그</legend>
		<!-- EL에서 사용할 변수 설정 -->
		<c:set var="numvar" value="101"/>	
		<c:set var="strvar" value="자바"/>	
		<h2>if태그로 짝홀수 판단</h2>
		<c:if test="${numvar mod 2 eq 0 }" var="result">
		
			${numvar }는 짝수
		</c:if>
		<c:if test="${!result }">
			<!-- html 주석입니다 -->
			${numvar }는 홀수
		</c:if>
		<h2>choose~when~otherwise태그로 짝홀수 판단</h2>
		<!-- choose태그 안에 주석시 에러. 반드시 when~otherwise절만.. -->
		<c:choose>
			<c:when test="${numvar mod 2 eq 0 }">
				${numvar }는 짝수
			</c:when>
			<c:otherwise>
				<!-- HTML주석입니다 -->
				${numvar }는 홀수
			</c:otherwise>
		</c:choose>
		<h2>choose~when~otherwise태그로 문자열 비교</h2>
		<c:choose>
			<c:when test="${strvar == 'JAVA' }">
				${strvar }는 "JAVA"다
			</c:when>
			<c:when test="${strvar == 'java' }">
				${strvar }는 "java"다
			</c:when>
			<c:when test="${strvar == '자바' }">
				${strvar }는 "자바"다
			</c:when>
		</c:choose>
	</fieldset>
	<fieldset>
		<legend>점수확인</legend>
		<form>
			국어<input type="text" name="kor"/>
			영어<input type="text" name="eng"/>
			수학<input type="text" name="math"/>
			<input type="submit" value="확인">		
		</form>
		<!-- 국영수 점수를 파라미터(kor,math,eng)로 받아 
			90점 이상이면 a학점 출력
			80점 이상이면
			60점 미만인면 f
			를 출력하여라  -->
			
			<c:set var="kor" value="${param.kor}" />
			<c:set var="eng" value="${param.eng}" />
			<c:set var="math" value="${param.math}" />
			<c:if test="${! empty param.kor && ! empty param.eng && !empty param.math }">
				<!-- 숫자인지 체크 -->
				<c:if var="result" test="${my:isNumber(kor) && my:isNumber(eng) && my:isNumber(math)}" >
					<c:set var="avg" value="${(kor+eng+math)/3}"/>
				<c:choose>
					<c:when test="${avg ge 90 }">
						A학점
					</c:when>
					<c:when test="${avg ge 80 }">
						B학점
					</c:when>
					<c:when test="${avg ge 70 }">
						C학점
					</c:when>
					<c:when test="${avg ge 60 }">
						D학점
					</c:when>
					<c:otherwise>
						F학점
					</c:otherwise>
				</c:choose>
				</c:if>
				<c:if test="${! result}">
					<span style="color:red;font-size: 2em">점수는 숫자만</span>
				</c:if>
			</c:if> 
			
			
			
	</fieldset>
	<fieldset>
		<legend>로그인</legend>
		<form>
			아이디<input type="text" name="user" />
			비밀번호<input type="password" name="pass" />
			<input type="submit" value="로그인">
		</form>
		<!-- 
			회원인 경우 "?님 반갑습니다"
			아닌 경우"로그인 후 이용하세요"출력.
			단, 자신만의 태그 라이브러리를 만ㄴ들어 EL식으로 호출하여라 
			그리고 실제 멤버 테이블을 연동하여라 
		-->
		<c:set var="user" value="${param.user }" />
		<c:set var="pass" value="${param.pass }" />
		<c:set var="scope" value="${pageContext.servletContext }"/>
		<c:if test="${! empty param.user && ! empty param.pass}">
			<c:if test="${my:isMember(user,pass,scope) }" var="result">
				${user}님 반갑습니다
			</c:if>	
			<c:if test="${! result}">
				로그인 후 이용하세요
			</c:if>
		</c:if>
	</fieldset>
</body>
</html>