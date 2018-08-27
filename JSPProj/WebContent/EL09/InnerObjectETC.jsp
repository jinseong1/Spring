<%@page import="java.util.Set"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>InnerObjectETC.jsp</title>
</head>
<body>
	<fieldset>
		<legend>EL의 기타 내장 객체들</legend>
		<h2>1.EL의 pageContext내장객체</h2>
		<!-- jsp의 pageContext내장객체와 같다. 단,
			자바빈 규칙으로 접근 가능한 메소드만 접근 가능하다
		 -->
		 <h4>자바코드로 컨텍스트 루트 얻기</h4>
		 <ul>
		 	<li>방법1:request 내장객체:<%=request.getContextPath() %></li>
			 <%
			 	ServletRequest req= pageContext.getRequest();
			 	String contextPath=((HttpServletRequest)req).getContextPath();
			 %>
		 	<li>방법2:pageContext내장객체:<%=contextPath %> </li>
		 </ul>
		 <h4>EL로 컨텍스트 루트 얻기</h4>
		 \${pageContext.request.contextPath } : ${pageContext.request.contextPath }
		 <h4>자바코드로 URL얻기</h4>
		 <%=request.getRequestURL() %>
		 <h4>EL로 URL얻기</h4>
		 \${pageContext.request.requestURL } : ${pageContext.request.requestURL }
		 \${pageContext['request']["requestURL"] } : ${pageContext['request']["requestURL"] }
		 <h4>자바코드로 세션유효시간 얻기</h4>
		 <%=session.getMaxInactiveInterval() %>초<br/>
		 <%=request.getSession().getMaxInactiveInterval() %>초<br/>
		 <%=pageContext.getSession().getMaxInactiveInterval() %>초<br/>
		 <%=((HttpServletRequest)(pageContext.getRequest())).getSession().getMaxInactiveInterval() %>초<br/>
		 <h4>EL로 세션 유효시간 얻기</h4>
		 \${pageContext.session.maxInactiveInterval }:
		 ${pageContext.session.maxInactiveInterval }<br/>
		 \${pageContext.request.session.maxInactiveInterval } : 
		 ${pageContext.request.session.maxInactiveInterval } <br/> 
		 <h2>2.EL의 header내장객체</h2>
		 <!-- jsp로 요청 헤더 정보를 얻어 오려면 
		 	request.getHeader("user-agent")식으로 얻는다 -->
		 <h4>자바코드로 요청헤더 값 얻기</h4>
		 request.getHeader("user-agent") : <%=request.getHeader("user-agent") %>
		 <h4>EL로 요청헤더 값 얻기</h4> 
		 \${header.user-agent } : ${header.user-agent }	<br/>
		 \${header['user-agent'] } : ${header['user-agent'] }	<br/>
		 <h2>3.EL의 쿠키 내장객체</h2>
		 <!-- 		 
		 	※ EL에서는 값을 설정하거나 영역에 
		 	속성을 저장하지는 못한다.
		 	단지 저장된 값을 출력만 할 수 있다.
		 -->
		<%
		//쿠키설정
			Cookie cookie = new Cookie("kosmo","java");
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);		
		%> 
		<h4>자바코드로 쿠키 읽어오기</h4>
		<%
			Cookie[] cookies =request.getCookies();
			if(cookies != null ){
				for(Cookie cook:cookies){
					//쿠키명 얻기
					String name = cook.getName();
					//쿠키값 얻기
					String value = cook.getValue();
					out.println(name+" : "+value+"<br/>");
				}//for	
			}//if
		%>
		<h4>EL로 쿠키 읽어오기</h4>
		\${cookie.kosmo.value } : ${cookie.kosmo.value }<br/>
		\${pageContext.request.cookies } : ${pageContext.request.cookies }
		<h4>JSTL을 이용해서 쿠키배열 출력</h4>
		<c:forEach var="cook" items="${pageContext.request.cookies }"><br/>
			${cook.name } : ${cook.value }<br/>
		</c:forEach>
		<h2>4.EL의 initParam내장 객체 </h2>
		<h4>자바코드로 컨텍스트 초기화 파라미터 얻기</h4>
		<ul>
			<li>ORACLE_URL: <%=application.getInitParameter("ORACLE_URL") %></li>
			<li>ORACLE_DRIVER: <%=application.getInitParameter("ORACLE_DRIVER") %></li>
			<li>PAGE_SIZE: <%=application.getInitParameter("PAGE_SIZE") %></li>
			<li>BLOCK_PAGE: <%=application.getInitParameter("BLOCK_PAGE") %></li>
		</ul>
		<h4>EL로 컨텍스트 초기화 파라미터 얻기</h4>
		<ul>
			<li>ORACLE_URL: ${initParam.ORACLE_URL }</li>
			<li>ORACLE_DRIVER: ${initParam.ORACLE_DRIVER} </li>
			<li>PAGE_SIZE: ${initParam.PAGE_SIZE}</li>
			<li>BLOCK_PAGE: ${initParam.BLOCK_PAGE}</li>
		</ul>
		<h2>컬렉션에 저장된 객체를 EL로 출력</h2>
		<%
		//자바코드로 컬렉션에 저장할 객체 저장 생성]
		MemberDTO first=new MemberDTO("KIM","1234","김길동", null,null);
		MemberDTO second=new MemberDTO("LEE","5678","이길동", null,null);
		//리스트 계열 컬렉션에 객체 저장
		List<MemberDTO> list = new Vector<MemberDTO>();
		list.add(first);
		list.add(second);
		//맵 계열 컬렉션에 객체 저장]
		Map<String, MemberDTO> map = new HashMap<String, MemberDTO>();
		map.put("first", first);
		map.put("second", second);
		%>
		<h4>자바코드로 출력</h4>
		<h5>리스트 계열 컬렉션</h5>
		<h6>일반 for문</h6>
		<ul>
			<% for(int i=0; i<list.size(); i++){%>
				<li><%=list.get(i) %></li>
			<%} //for%>
		
		</ul>
		<h6>확장 for문</h6>
		<ul>
		
			<% for(MemberDTO member:list){ %>
				<%=member %><br/>
			<%} %>
		</ul>
		<h5>맵 계열 컬렉션 </h5>
		<%
			Set<String> keys = map.keySet();
			for(String key: keys){
				MemberDTO member = map.get(key);
				out.println(key+" : "+member+"<br/>");
			}
		
		%>
		<h4>EL로 출력</h4>
		<c:set var="elList" value="<%=list %>"/>
		<c:set var="elMap" value="<%=map %>"/>
		<h5>리스트 계열 컬렉션</h5>
		<h6>JSTL미사용</h6>
		<ul>
		\${elList[0] } : ${elList[0] }
			<li>이름-${elList[0].name }, 아이디-${elList[0].id }, 비번-${elList[0].pwd }</li>
			<li>이름-${elList[1].name }, 아이디-${elList[1].id }, 비번-${elList[1].pwd }</li>
		</ul>
		<h6>JSTL사용</h6>
		<ul>
			<c:forEach var="item" items="${elList }">
				<li>이름-${item.name }, 아이디-${item.id }, 비번-${item.pwd }</li>
			</c:forEach>
		</ul>
		<h5>맵 계열 컬렉션</h5>
		<h6>JSTL미사용</h6>
		\${elMap.first } : ${elMap.first } 
		<ul>
			<li>이름-${elMap.first.name }, 아이디-${elMap.first.id }, 비번-${elMap.first.pwd }</li>
			<li>이름-${elMap.second.name }, 아이디-${elMap.second.id }, 비번-${elMap.second.pwd }</li>
		</ul>
		<h6>JSTL사용</h6>
		<ul>
			<c:forEach var="item" items="${elMap }">
				<li>이름-${item.value.name }, 아이디-${item.value.id }, 비번-${item.value.pwd }</li>
			</c:forEach>
		</ul>
		<h5>컬렉션에 저장된 객체 수 : EL변수.size()</h5>
		<ul>
			<li>\${elList.size() } : ${elList.size() }</li> 
			<li>\${elMap.size() } : ${elMap.size() }</li> 
		</ul>
	</fieldset>
</body>
</html>