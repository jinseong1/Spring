<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>PageContextNPage.jsp</title>
</head>
<body>
	<fieldset>
		<legend>pageContext 및 page 내장객체</legend>
		<h2>pageContext내장객체</h2>
		<hr/>
		<h4>request내장객체로 전송방식 얻기</h4>
		<%=request.getMethod() %>
		<h4>pageContext내장객체로 전송방식 얻기</h4>
		<%
			//
			ServletRequest req = pageContext.getRequest();
			//형변환
			String method = ((HttpServletRequest)req).getMethod();
			out.println(method);
		%>
		<h4>pageContext내장객체로 out내장객체 얻기</h4>
		<%pageContext.getOut().println("메소드 체인"); %>
		
		<!--※getRealPath(경로명) 는 ServeltContext의 메소드- 물리적 경로를 얻어온다
			-경로명은 /로 시작하는 절대경ㄹ로(단, 컨텍스트 루트(프로젝트명)는 제외)
		 -->
		 <h4>application내장객체로 서버의 물리적 경로 얻기</h4>
		 <%=application.getRealPath("/Images") %>
		 <h4>pageContext내장객체로 서버의 물리적 경로 얻기</h4>
		 <%=pageContext.getServletContext().getRealPath("/Images") %>
		 <h2>page내장객체</h2>
		 <%
		 /**/
		 out.println("page내장객체의 클래스명: "+page.getClass().getName()+"<br/>");
		 out.println("this의 클래스명: "+this.getClass().getName()+"<br/>");	
		 out.println(this instanceof HttpServlet?"page는 서블릿이다":"page는 서브릿이 아니다");
		 
		 
		 %>
	</fieldset>
</body>
</html>