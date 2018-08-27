<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>DynamicPage.jsp</title>
</head>
<body>
	<fieldset>
	  <legend>페이지 선택해서 동적으로 페이지 포함하기</legend>
	  <form>
	   <select name="pageName">
	    <option value="DirectivePage.jsp">DirectivePage.jsp</option>
	    <option value="ActionTagPage.jsp">ActionTagPage.jsp</option>
	   </select>
	   <input type="submit" value="페이지 선택"/>
	  </form>
	  <!-- 아래에 위에서 선택한 페이지 삽입 -->
	  <%
	  String pageName = request.getParameter("pageName");
	  if(pageName!=null){
	  %>
	  	<jsp:include page="<%=pageName %>"/>
	  <%}//if %>
	 
	 </fieldset>
	 
	 <fieldset>
	  <legend>계절에 따른 페이지 변화</legend>  
	  <%
	  /* Date date = new Date();
	  int month = date.getMonth()+1;
	  //345/678/91011/12 1 2
	  String seasons ="";
	  if(month>=3 && month<=5 ){
		  seasons="Spring.jsp";
	  }
	  else if(month>=6 && month<=8){
		  seasons="Summer.jsp";
	  }
	  else if(month>=9 && month<=11){
		  seasons="Autumn.jsp";
	  }
	  else seasons="Winter.jsp"; */
	  
	  String season="";
	  Calendar cal = Calendar.getInstance();
	  switch(cal.get(Calendar.MONTH)+1){
	  case 3:
	  case 4:
	  case 5: season="Spring.jsp";break;
	  case 6:
	  case 7:
	  case 8: season="Summer.jsp";break;
	  case 9:
	  case 10:
	  case 11: season="Autumn.jsp";break;
	  default: season="Winter.jsp";
		  
	  }
	  
	  
	  %>
	  
	  
	  <jsp:include page="<%=season %>"/>
	 </fieldset>
	
</body>
</html>