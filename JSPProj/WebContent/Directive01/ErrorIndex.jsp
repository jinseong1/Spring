<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="ErrorInfo.jsp"
    %>
    
    
<%
	//사용자가 입력한 값 받기]
	String stringAge = request.getParameter("age");
	//out.println("stringAge="+stringAge);
	int after10Years = -1;
	//에러메시지 저장용]
	String message="";
	if(stringAge !=null){
		/* 
		//방법1]try catch
		try{
		after10Years= Integer.parseInt(stringAge)+10;
		}
		catch(Exception e){
			message="나이는 숫자만...";
		} */
		//방법2] page지시어의 errorPAge속성 사용
		after10Years= Integer.parseInt(stringAge)+10;
	}
	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>ErrorIndex.jsp</title>
</head>
<body>
	<fieldset>
   <legend>에러가 발생할 페이지</legend>
   <form>
     나이를 입력하세요?
     <input type="text" name="age"/>
     <input type="submit" value="확인"/> 
   </form>
   <span style="font-size:1.4em;color:green;font-weight:bold">
   <%if(after10Years!=-1){ %>
  		 당신의 10년후 나이는 <%=after10Years %>살 이군요!!!   
   <%} %>
   <%=message %>
   </span>
  
 </fieldset>
</body>
</html>