<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ResponseForRedirectProcess.jsp -->
<%
	//post방식으로만 받자
	if(!request.getMethod().equals("POST")){
		out.println("<script>");
		out.println("alert('잘못된 접근입니다')");
		out.println("history.back();");
		out.println("</script>");
		
		return;
	}/////////

	
	/*
	사용자가 입력한 아이ㅣ디와 비번을 받아서 회원인지 판단한 후 회원인 경우 마잉페이지로 이동
	아닌경우 다시 로그인 페이지로 이동
	가정] 아이디가 kim 비번이 1234
	*/
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	if("kim".equalsIgnoreCase(id.trim())&& "1234".equals(pwd.trim())){
		//방법1] sendRedirect
		//response.sendRedirect(request.getContextPath()+"/InnerObject03/ResponseForSelfPage.jsp?id="+id+"&pwd="pwd");
		//방법2]
		/* out.println("<script>");
		out.println("alert('"+id+"님 반갑습니다')");
		out.println("location.href='"+request.getContextPath()+"/InnerObject03/ResponseForSelfPage.jsp?id="+id+"&pwd="+pwd+"';");
		out.println("</script>"); */
		//방법3]URL에 노출이 안되도록 post방식으로 
		%>
		<form action="ResponseForSelfPage.jsp" method="post">
			<input type="hidden" name="id" value="<%=id%>"/>
			<input type="hidden" name="pwd" value="<%=pwd%>"/>
		</form>
		<script>
			alert('<%=id%>님 즐 쇼핑하세요');
			document.forms[0].submit();
		</script>
		<%
		
		
		
	}
	else{//비회원인경우
		//response.sendRedirect("ResponseForRedirectIndex.jsp");//sendRedirect(바로그페이지로 이동함 ))와 자바스크립트(alert)는 같이 못씀
%>
	<script>
		alert("아이디와 비번이 틀려요");
		//기존값이 그대로 유지
		history.back();
		//기존값이 사라짐
		location.replace('ResponseForSelfPage.jsp');
	</script>

<%
	
	}
	
%>