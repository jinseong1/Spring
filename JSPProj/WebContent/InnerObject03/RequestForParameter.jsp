<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	private String getValue(String word){
		switch(word){
			case "eco": return "경제";
			case "pol": return "정치";
			case "spo": return "스포츠";
			default: return "연예";
		}
	}




%>
    
<%
	//post방식일때 아래 코드 추가 (한글 처리용)]
	request.setCharacterEncoding("UTF-8");
	/*
	getParameter계열 메소드가 
	
	*/		
	//파라미터 받기]
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String[] inters = request.getParameterValues("inter"); 
	//out.println(String.format("name:%s, gender:%s, inters:%s",name,gender,inters)); //처음 요청할땐 다 널 
	String values = "";
	if(name!=null && name.trim().equals("") && gender!=null && inters!=null){
		values = String.format("이름: %s, 성별: %s, 관심사항:", name,gender);
		for(String inter: inters){
			values+=getValue(inter)+"";
		}
	}///////////
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>RequestForParameter.jsp</title>
</head>
<body>
	<fieldset>
    	<legend>사용자가 전송한 파라미터와 관련된 request객체의 메소드</legend>
		     <h3>form태그를 이용한 값 전송</h3>
		     <form method="post">
			     <table cellspacing="1" bgcolor="gray">
				      <tr bgcolor="white">
					       <td>이름</td>
					       <td><input type="text" name="name"/></td>
				      </tr>
				      <tr bgcolor="white">
					       <td>성별</td>
					       <td>
					       	남<input type="radio" name="gender" value="남자"/>
				          	여<input type="radio" name="gender" value="여자"/>
				       		</td>
				      </tr>
				      <tr bgcolor="white">
				       <td>관심사항</td>
				       <td>
					              경제<input type="checkbox" name="inter" value="eco"/>
					              정치<input type="checkbox" name="inter" value="pol"/>
					              스포츠<input type="checkbox" name="inter" value="spo"/>
					              연예<input type="checkbox" name="inter" value="ent"/>       
				       </td>
				      </tr>
				      <tr bgcolor="white" align="center">
				       <td colspan="2"><input type="submit" value="확인"/></td>
				         </tr>
			     </table>
		     </form>
    		<%=values%>
     <h3>A태그를 이용한 값 전송</h3> 
     <a href="RequestForParameter.jsp?name=홍길동&gender=남&inter=spo&inter=ent">GET</a>
     <h3>모든 파라미터명 얻기</h3>
     <!--
      -request객체의 getParameterNames()메소드로
       얻는다
      -파라미터명 존재 여부판단
     -->
     <ul style="list-style-type:upper-roman;">
      <%
      
      	Enumeration<String>names = request.getParameterNames();
      	while(names.hasMoreElements()){
      		//파라미터명 얻기
      		String parameterName = names.nextElement();
      		//파라미터 값 얻기
      		String parameterValue =request.getParameter(parameterName);
      		
      	
      
      %>
       <li><%=parameterName %>:<%=parameterValue %></li>
       
    	<%}//while %>
    </ul>
 </fieldset> 
</body>
</html>