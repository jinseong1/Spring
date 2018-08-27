<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
private String getInter(String[] value){
	
	String interString="";
	for(String li:value){
		switch(li){
			case "eco": return "경제";
			case "pol": return "정치";
			case "spo": return "스포츠";
			default: return "연예";
		}
	}
	return interString;
}
private String getGender(String word){
	switch(word){
		case "man": return "남자";
		case "woman": return "여자";
		default: return "트렌스젠더";
	}
}
private String getGrade(String word){
	switch(word){
		case "ele": return "초등학교";
		case "mid": return "중학교";
		case "high": return "고등학교";
		default: return "대학교";
	}
}


%>
<%
	//한글처리
	request.setCharacterEncoding("UTF-8");
	if(!"POST".equals(request.getMethod())){
	%>
		<script>
			alert("잘못된 접근입니다");
			self.close();
		</script>
	<%	
		return;//void _jspService()메소드 빠져나가기
	}
	//파라미터 받기]
	String id = request.getParameter("id");
	//아이디 미 입력시 
	if(id.trim().equals("")){
		out.println("<script>");
		out.println("alert('아이디를 입력하세요');");
		out.println("history.back();");
		out.println("</script>");
	}////////
	String pwd = request.getParameter("pwd");
	String gender = request.getParameter("gender");
	String[] inters = request.getParameterValues("inter"); 
	String grade = request.getParameter("grade");
	String file = request.getParameter("file");
	String self = request.getParameter("self");
	
	
	
%>    
<!DOCTYPE html>
<html>
<head>
    <title>IncludeMemberComplete.jsp</title>
	<meta charset="utf-8" />
    <link rel="stylesheet" href="../Styles/divLayout.css" type="text/css" />
</head>
<body>
    <div class="allWrap">
        <div class="partWrap">
            <!--탑메뉴 및 로고 감싸는 div시작-->
            <div class="header">
                <div class="logo">
                    <img src="../Images/logo.gif" alt="로고이미지" />
                </div>
                <div class="topMenu">
                   <%@ include file="/Template/Top.jsp" %>
                </div>
            </div>
            <!--탑메뉴 및 로고 감싸는 div끝-->
            <!--Left메뉴 및 실제 내용 감싸는 div시작-->
            <div class="section">
                <div class="leftMenu">
                    <%@ include file="/Template/Left.jsp" %>
                </div>
                <div class="body">
                    <div class="content">
                        
                         <h2>회원가입 완료 페이지</h2>
                         <%@ include file="IncludePage.jsp" %>
						 <h3>회원가입을 축하합니다</h3>      
						 <ul style="list-style-type: upper-roman; list-style-position: inside">
						 	<li>아이디:<%= id%></li>
						 	<li>비밀번호:<%=pwd %></li>
						 	<li>성별:<%= getGender(gender)%></li>
						 	<li>관심사항:<%for(String inter:inters){%><%= getInter(inters)+" "%><%} %></li>
						 	<li>학력사항:<%= getGrade(grade)%></li>
						 	<li>첨부파일:<%= file%></li>
						 	<li>자기소개<br/>
						 		<% self.replace("\r\n", "<br/>");%>
						 		
						 	</li>
						 
						 </ul>       
					        <table style="width:75%;border-spacing:1px;background-color:green">
					
					            <tr style="background-color:white">
					                <td>아이디</td>
					                <td><input type="text" name="id" size="20" value=<%=id %>/></td>
					            </tr>
					            <tr style="background-color:white">
					                <td>비밀번호</td>
					                <td><input type="password" name="pwd" size="20" value=<%=pwd %>/> </td>
					            </tr>
					            <tr style="background-color:white">
					                <td>성별</td>
					                <td>
					                    <input type="radio" name="gender" value="man" <%if(gender.equals("man")){ %>checked<%} %>/>남
					                    <input type="radio" name="gender" value="woman" <%if(gender.equals("woman")){ %>checked<%} %>/>녀
					                    <input type="radio" name="gender" value="trans" <%if(gender.equals("trans")){ %>checked<%} %>/>트랜스젠더
					                </td>
					            </tr>
					            <tr style="background-color:white">
					                <td>관심사항</td>
					                <td>
					                    <input type="checkbox" name="inter" value="pol" <%if(Arrays.toString(inters).indexOf("pol")!=-1){ %>checked<%} %>/>정치
					                    <input type="checkbox" name="inter" value="eco" <%if(Arrays.toString(inters).indexOf("eco")!=-1){ %>checked<%} %>/>경제
					                    <input type="checkbox" name="inter" value="spo" <%if(Arrays.toString(inters).indexOf("spo")!=-1){ %>checked<%} %>/>스포츠
					                    <input type="checkbox" name="inter" value="ent" <%if(Arrays.toString(inters).indexOf("ent")!=-1){ %>checked<%} %>/>연예
					                </td>
					            </tr>
					            <tr style="background-color:white">
					                <td>학력사항</td>
					                <td>
					                    <select name="grade">
					                        <option value="ele" <%if(grade.equals("ele")){ %>selected<% }%>>초등학교</option>
					                        <option value="mid" <%if(grade.equals("mid")){ %>selected<% }%>>중학교</option>
					                        <option value="hig" <%if(grade.equals("high")){ %>selected<% }%>>고등학교</option>
					                        <option value="uni" <%if(grade.equals("uni")){ %>selected<% }%>>대학교</option>
					                    </select>
					                </td>
					            </tr>
					            <tr style="background-color:white">
					                <td>첨부파일</td>
					                <td>
					                    <input type="file" name="file" size="40" /> <%=file %>
					                </td>
					            </tr>
					            <tr style="background-color:white">
					                <td>자기소개</td>
					                <td>
					                    <textarea cols="60" rows="5" name="self" ><%= self %></textarea>
					                </td>
					            </tr>
					           
					        </table>
						    
                    </div>
                </div>
            </div>
            <!--Left메뉴 및 실제 내용 감싸는 div끝-->
            <!--footer를 감싸는 div시작-->
            <div class="footer">
                <%@ include file="/Template/Footer.jsp" %>
            </div>
            <!--footer를 감싸는 div끝-->
        </div>
    </div>
</body>
</html>
