<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@page import="model.MemberDTO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>SetTagIndex.jsp</title>
</head>
<body>
	<fieldset>
		<legend>set태그</legend>
		<!-- 
			var속성: 문자열만
			value속성: 값,표현식,el식 모두 가능
			scope속성: 문자열만(page,request,session,appliction중 하나 page가 기본값 )
		 -->
		 <h2>set태그로 EL에서 사용할 변수 설정</h2>
		 <ul style="list-style-type: upper-roman;">
		 	<li>value속성에 직접 값 설정:<c:set var="directvar" value="100"/></li>
		 	<!-- 위 JSTL코드는 아래의 자바 코드와 같다 -->
		 	<%-- pageContext.setAttribute("directvar", "100"); --%>
		 	<li>value속성에 EL표현식으로 값 설정:<c:set var="elvar" value="${directvar }"/></li>
		 	<li>value속성에 표현식으로 값 설정:<c:set var="expvar" value="<%=new Date() %>"/></li>
		 	<li>시작태그와 종료 태그 사이에 값 설정: <c:set var="betweenvar">시작태그와 <h2>종료태그</h2> 사이에 값 설정</c:set></li>
		 </ul>
	</fieldset>
	<fieldset>
		<legend>set태그로 설정한 값 출력하기</legend>
		<h2>스크립팅 요소를 사용한 자바코드로 출력</h2>
		<ul style="list-style-type: upper-roman;">
			<li>directvar: <%=pageContext.getAttribute("directvar") %></li>
			<li>elvar: <%=pageContext.getAttribute("elvar") %></li>
			<li>expvar: <%=pageContext.getAttribute("expvar") %></li>
			<li>betweenvar: <%=pageContext.getAttribute("betweenvar") %></li>
		</ul>
		<h2>EL로 출력</h2>
		<ul style="list-style-type: upper-roman;">
			<li>directvar: ${directvar }</li>
			<li>elvar: ${elvar }</li>
			<li>expvar: ${expvar }</li>
			<li>betweenvar: ${betweenvar }</li>
		</ul>
	</fieldset>
	<fieldset>
		<legend>set태그로 각 영역에 객체 저장</legend>
		<c:set var="pagevar" value="페이지 영역입니다"/>
		<c:set var="requestvar" value="리퀘스트 영역입니다" scope="request"/>
		<c:set var="sessionvar" value="세션 영역입니다" scope="session"/>
		<c:set var="applicationvar" value="어플리케이션 영역입니다" scope="application"/>
		<h2>스크립팅 요소를 사용한 자바코드로 출력</h2>
		<ul style="list-style-type: upper-roman;">
			<li>pagevar: <%=pageContext.getAttribute("pagevar") %></li>
			<li>requestvar: <%=request.getAttribute("requestvar") %></li>
			<li>sessionvar: <%=session.getAttribute("sessionvar") %></li>
			<li>applicationvar: <%=application.getAttribute("applicationvar") %></li>
		</ul>
		<h2>EL로 출력</h2>
		<ul style="list-style-type: upper-roman;">
			<li>pagevar: ${pagevar }</li>
			<li>requestvar: ${requestScope.requestvar }</li>
			<li>sessionvar: ${sessionScope.sessionvar }</li>
			<li>applicatonvar: ${applicationScope.applicationvar }</li>
		</ul>
	</fieldset>
	<fieldset>
		<legend>set태그로 자바빈 객체 설정</legend>
		<h2>기본 생성자로 설정</h2>
		<c:set scope="request" var="defaultMember" value='<%=new MemberDTO() %>' />
		<h4>자바코드로 출력</h4>
		<ul style="list-style-type: upper-roman;">
			<li>아디:<%=((MemberDTO)request.getAttribute("defaultMember")).getId() %></li>
			<li>비번:<%=((MemberDTO)request.getAttribute("defaultMember")).getPwd() %></li>
			<li>이름:<%=((MemberDTO)request.getAttribute("defaultMember")).getName()%></li>
		</ul>
		<h4>EL로 출력</h4>
		<ul style="list-style-type: upper-roman;">
			<li>아디: ${defaultMember.id }</li>
			<li>비번: ${defaultMember.pwd }</li>
			<li>이름: ${defaultMember.name }</li>
		</ul>
		<h2>인자 생성자로 설정</h2>
		<c:set var="argsMember" value='<%=new MemberDTO("KIM","1234","김길동",null,null) %>' scope="request" />
		<h4>자바코드로 출력</h4>
		<ul style="list-style-type: upper-roman;">
			<li>아디:<%=((MemberDTO)request.getAttribute("argsMember")).getId() %></li>
			<li>비번:<%=((MemberDTO)request.getAttribute("argsMember")).getPwd() %></li>
			<li>이름:<%=((MemberDTO)request.getAttribute("argsMember")).getName()%></li>
		</ul>
		<h4>EL로 출력</h4>
		<ul style="list-style-type: upper-roman;">
			<li>아디: ${argsMember.id }</li>
			<li>비번: ${argsMember.pwd }</li>
			<li>이름: ${argsMember.name }</li>
		</ul>
		<!--  -->
		<c:set target="${defaultMember}" property="id" value="PARK"/>
		<c:set target="${defaultMember}" property="pwd" value="5678"/>
		<c:set target="${defaultMember}" property="name" value="박길동"/>
		<h4>target및 property속성으로 값 설정 후 EL로 출력</h4>
		<ul style="list-style-type: upper-roman;">
			<li>아디: ${defaultMember.id }</li>
			<li>비번: ${defaultMember.pwd }</li>
			<li>이름: ${defaultMember.name }</li>
		</ul>
		<%
		//리스트 계열 컬렉션]
		List list = new Vector();
		list.add(request.getAttribute("defaultMember"));
		list.add(request.getAttribute("argsMember"));
		%>
		<h2>set태그로 리스트계열 컬렉션 설정</h2>
		<c:set var="list" value="<%=list %>" scope="request"/>
		<h4>속성값 변경전 출력</h4>
		<ul style="list-style-type: upper-roman;">
			<li>아디: ${list[0].id }</li>
			<li>비번: ${list[0].pwd }</li>
			<li>이름: ${list[0].name }</li>
		</ul>
		<h4>target및 property속성으로 값 변경</h4>
		<c:set target="${list[0] }" property="id" value="kosmo"/>
		<c:set target="${list[0] }" property="pwd" value="1234"/>
		<c:set target="${list[0] }" property="name" value="한소인"/>
		<h4>속성값 변경후 출력</h4>
		<ul style="list-style-type: upper-roman;">
			<li>아디: ${list[0].id }</li>
			<li>비번: ${list[0].pwd }</li>
			<li>이름: ${list[0].name }</li>
		</ul>
		<%
		//맵 계열 컬렉션]
		Map map = new HashMap();
		map.put("default",request.getAttribute("defaultMember") );		
		map.put("args",request.getAttribute("argsMember") );		
		%>
		<h2>set태그로 맵 계열 컬렉션 설정</h2>
		<c:set var="map" value="<%=map %>" scope="request"/>
		<h4>속성값 변경전 출력</h4>
		<ul style="list-style-type: upper-roman;">
		<!-- default는 EL스펙의 예약어 고로 map["default"].id방식으로 접근 -->
			<li>아디: ${map['default'].id }</li>
			<li>비번: ${map['default'].pwd }</li>
			<li>이름: ${map['default'].name }</li>
		</ul>
		<c:set target="${map['default'] }" property="id" value="kosmo2" />
		<c:set target="${map['default'] }" property="pwd" value="9999" />
		<c:set target="${map['default'] }" property="name" value="한소인2" />
		<!-- map.put("addProperty",new MemberDTO()); 랑 같음 -->
		<c:set target="${map }" property="addProperty" value="<%=new MemberDTO() %>"/> 
		<h4>속성값 변경후 출력</h4>
		<ul style="list-style-type: upper-roman;">
		<!-- default는 EL스펙의 예약어 고로 map["default"].id방식으로 접근 -->
			<li>아디: ${map['default'].id }</li>
			<li>비번: ${map['default'].pwd }</li>
			<li>이름: ${map['default'].name }</li>
		</ul>
		<h4>addProperty키값으로 추가한 객체</h4>
		<ul style="list-style-type: upper-roman;">
			<li>아디: ${map.addProperty.id }</li>
			<li>비번: ${map.addProperty.pwd }</li>
			<li>이름: ${map.addProperty.name }</li>
		</ul>
	</fieldset>
	<jsp:forward page="setTagResult.jsp">
		<jsp:param value="android" name="subject"/>
	</jsp:forward>
</body>
</html>