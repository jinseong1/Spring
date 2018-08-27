<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>Out.jsp</title>
</head>
<body>
	<fieldset>
		<legend>out 내장객체</legend>
		<h2>버퍼와 관련된 메소드</h2>
		<%
		
			out.println("버퍼에 저장될 문자열 <br/>");
			//버퍼에 저자오딘 내용이 웹브라우저로 바로 전송됨.]
			out.flush();
			out.println("웹브라우저에 출력 안될 문자열");
			//버퍼에 저장된 내용을 지운다
			//out.clearBuffer();
			//아래는 버퍼에 저장됬다가 응답이 되면 바로 웹브라우저로 전송됨.
			out.println("마지막으로 저장될 문자열");
		%>
		<h2>기타 메소드</h2>
		<ul style="list-style-type: upper-latin;">
			<li>자동 플러쉬 여부: <%=out.isAutoFlush() %></li>
			<li>버퍼 크기: <%=out.getBufferSize() %>바이트</li>
			<li>남은 버퍼 크기: <%=out.getRemaining() %>바이트</li>
		</ul>
		<h2>print와 println메소드 차이</h2>
		<h4>print메소드</h4>
		<%
			out.print("<table style='border-spacing:1px;background-color:Red'>");
			out.print("<tr style='background-color:white'>");
			out.print("<td>가</td><td>나</td>");
			out.print("</tr>");
			out.print("</table>");
		%>
		<h4>println메소드</h4>
		<!-- 소시보기시 줄바꿈 처리 되어 있음 (소스 보기 시 가독성이 높다) 브라우저상은 차이가 없다 -->
		<%
			out.println("<table style='border-spacing:1px;background-color:Red'>");
			out.println("<tr style='background-color:white'>");
			out.println("<td>가</td><td>나</td>");
			out.println("</tr>");
			out.println("</table>");
		%>
	</fieldset>
</body>
</html>