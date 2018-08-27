<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!

	private String getProductName(String code){
	
		int beginIndex="product".length();
		String numbering = code.substring(beginIndex);
		return "상품"+numbering;	
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>CookieExamCartResult.jsp</title>
</head>
<body>
	<fieldset>
		<legend>장바구니 예제: 장바구니에 담은 상품들</legend>
		<ul style="list-style-type: upper-roman;">
		<% 
			// 쿠키값 읽어오기
			Cookie[] cookies = request.getCookies();
			if(cookies!=null){
				for(Cookie cookie:cookies){
					//쿠키명 얻기
					String name = cookie.getName();
					//쿠키값 얻기
					String value = cookie.getValue();
					
					if(name.indexOf("product")!= -1){
		%>
			<li><%=getProductName(name) %></li>
		<%	
					}//if
				}//for
			}///if
		%>	
		</ul>
		<a href="CookieExamIndex.jsp">쇼핑계속하기</a>
	</fieldset>
	
</body>
</html>