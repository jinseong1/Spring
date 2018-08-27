<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="model.MemberDTO"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>ELError.jsp</title>
</head>
<body>
	<fieldset>
		<legend>EL에서 에러가 나거나 혹은 에러는 안나지만 값이 출력이 안되는 경우</legend>
		<h2>+를 숫자형식이 아닌 문자열에 적용시(에러)</h2>
		<ul>
			<li>\${"100"+100 }[정상-200] : ${"100"+100 }</li>
			<li>\${"백"+100 }[에러] : \${"백"+100 }</li>
			<li>\${"HELLO"+'EL' }[에러] : \${"HELLO"+'EL' }</li>
		</ul>
		<h2>특수문자가 포함된 속성에 .으로 접근시(에러는 안나지만 정상적인 출력이 안됨)</h2>
		<ul>
			<li>\${header.user-agent } : ${header.user-agent }</li>
			<li>\${header['user-agent'] }[정상] : ${header['user-agent'] }</li>
		</ul>
		<h2>.인덱스 형식으로 배열이나 리스트계열 컬렉션의 요소에 접근시 에러</h2>
		<%
			String[] mountains = {"설악산","소백산","비슬산","덕유산"};
			out.println(mountains[0]+"<br/>");
			List collection = new Vector();
			for(String mountain: mountains)	collection.add(mountain);
			out.println(collection.get(0));	
		%>
		<c:set var="mountains" value="<%=mountains %>"/>
		<c:set var="collection" value="<%=collection %>"/>
		<ul>
			<li>\${mountains } : ${mountains }</li>
			<li>\${collection } : ${collection }</li>
		</ul>
		<ul>
			<li>\${mountains.0 }[에러] : \${mountains.0 }</li>
			<li>\${mountains[0] }[정상] : ${mountains[0] }</li>
			<li>\${collection.0 }[에러] : \${collection.0 }</li>
			<li>\${collection[0] }[정상] : ${collection[0] }</li>
		</ul>
		<h2>배열과 리스트 계열 컬렉션 출력하기</h2>
		<h4>배열</h4>
		<c:forEach var="item" items="${mountains }">
			${item } 
		</c:forEach>
		<h4>리스트 계열 컬렉션</h4>
		<c:forEach var="item" items="${collection }">
			${item } 
		</c:forEach>
		<h2>배열이나 리스트 계열 컬렉션에 익덱스를 벗어난 경우(에러 NO 출력 NO)</h2>
		<ul>
			<li>\${mountains[4] } : ${mountains[4] }</li>
			<li>\${collection[4] } : ${collection[4] }</li>
		</ul>
		<h2>없는 속성이거나, 자바빈인 경우 속성은 존재하지만 getter가 없는 경우 에러</h2>
		<c:set var="member" value='<%=new MemberDTO("KIM","1234","김길동",null,null) %>'/>
		<ul>
			<li>존재하지 않는 속성[PropertyNotFoundException에러발생]: \${member.addr }</li>
			<li>속성은 존재, getter가 없음: ${member.id }</li>
			<li>.이전의 객체를 담은 el변수가 틀린경우[에러 NO, 출력 NO]:${mem.id }</li>
		</ul>
		<h2>EL 내장객체에 없는 속성으로 접근시</h2>
		\${null } : ${null }
		<%
			//리퀘스트 영역에 저장]
			request.setAttribute("myrequest", "리퀘스트 영역입니다");
			//맵컬렉션 객체 생성]
			Map map = new HashMap();
			map.put("mymap","맵 컬렉션입니다");
					
		%>
		<c:set var="elMap" value="<%=map %>"/>
		<ul>
			<li>\${requestScope.myrequest }[정상] : ${requestScope.myrequest }</li>
			<li>\${elMap.mymap }[정상] : ${elMap.mymap }</li>
			<li>\${requestScope.yourrequest }[에러 NO, 출력 NO] : ${requestScope.yourrequest }</li>
			<li>\${elMap.yourmap }[에러 NO, 출력 NO] : ${elMap.yourmap }</li>
			
			<!-- Scope계열 내장객체는 에러ㄴㄴ, 출력 ㄴㄴ- 속성명은 개발자 마음대로 이기 때문에 -->
			<li>\${requestScope.noproperty } : ${requestScope.noproperty }</li>
			<!-- 컴파일 오류 발생- 속성명이 정해져 있기 때문에, 즉 게터 호출과 같다 -->
			<%-- <li>\${pageContext.noproperty } : \${pageContext.noproperty }</li>--%>
		</ul>
		<h2>숫자를 0으로 나누면 Infinity</h2>
		\${100 /0 } : ${100 /0 }
		<h2>EL변수에 값 할당시[톰캣 8.0이상부터는 정상. 그 이전버전은 에러]</h2>
		<c:set var="num" value="100"/>
		\${num } : ${num }<br/>
		\${num=3.14 } : ${num=3.14 }
		<h2>임의이ㅡ 변수로 .을 통해서 접근시- NO출력 NO에러</h2>
		<ul>
			<li>\${kosmo } : ${fn:length(kosmo) }</li>
			<li>\${kosmo.name } : ${kosmo.name }</li>
		</ul>
	</fieldset>
</body>
</html>