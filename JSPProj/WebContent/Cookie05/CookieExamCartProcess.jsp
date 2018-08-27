<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- CookieExamCartProcess.jsp -->
<%
	//장바구니에 담은 상품 코드 받기]
	String[] carts = request.getParameterValues("cart");
	for(String cart:carts){
		Cookie cookie = new Cookie(cart,cart);
		cookie.setPath(request.getContextPath());
		// 응답헤더에 설정
		response.addCookie(cookie);
	}

	response.sendRedirect("CookieExamCartResult.jsp");
	
	
	
%>