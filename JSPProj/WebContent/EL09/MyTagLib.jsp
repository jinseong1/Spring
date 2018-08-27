<%@page import="eltag.MyTagLibrary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="my" uri="/WEB-INF/tlds/mytag.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>MyTagLib.jsp</title>
</head>
<body>
	<fieldset>
		<legend>내가 만든 태그 라이브러리 사용하기</legend>
		<h2>자바코드로 메소드 호출하기</h2>
		<%=MyTagLibrary.isNumber("100사") %><br/>
		<%=MyTagLibrary.getGender("123-123455") %>
		<h2>EL표현식에서 사용하기(스크립팅 요소 사용안함)</h2>
		\${my:isNumber("100사") } : ${my:isNumber("100사") }<br/>
		\${my:isNumber("1004") } : ${my:isNumber("1004") }<br/>
		\${my:elGetGender('23546-2354968') } : ${my:elGetGender('23546-2354968') }
	</fieldset>
	
</body>
</html>