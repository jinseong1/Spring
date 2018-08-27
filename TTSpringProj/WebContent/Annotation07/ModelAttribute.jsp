<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>ModelAttribute.jsp</title>
</head>
<body>
   	<fieldset>
	  <legend>@ModelAttribute어노테이션 결과 페이지</legend>  
	  <table bgcolor="gray" cellspacing="1" width="60%" >
	        <tr bgcolor="white">
	         <td>이름</td>
	         <td><input type="text" name="name" value="${name}${command.name}"/></td>
	        </tr>
	        <tr bgcolor="white">
	         <td>나이</td>
	         <td><input type="text" name="years" value="${years}${command.years}"/></td>
	        </tr>
	        <tr bgcolor="white">
	         <td>성별</td>
	         <td>
	        
	         <input type="radio" name="gender" value="남자"   <c:if test="${gender=='남자' or command.gender=='남자' }">checked</c:if>/>남자
	         <input type="radio" name="gender" value="여자"   <c:if test="${gender=='여자' or command.gender=='여자'}">checked</c:if>/>여자
	         </td>
	        </tr>
	        <tr bgcolor="white">
	         <td>관심사항</td>
	         <td>
	         
	         <input type="checkbox" name="inters" value="정치" <c:if test="${fn:contains(inters,'정') or fn:contains(fn:join(command.inters,','),'정') }">checked</c:if> />정치
	         <input type="checkbox" name="inters" value="경제" <c:if test="${fn:contains(inters,'경') or fn:contains(fn:join(command.inters,','),'경') }">checked</c:if>/>경제
	         <input type="checkbox" name="inters" value="스포츠" <c:if test="${fn:contains(inters,'스') or fn:contains(fn:join(command.inters,','),'스') }">checked</c:if>/>스포츠
	         </td>
	        </tr>
	        <tr bgcolor="white">
	         <td>학력</td>
	         <td>
	         
	         <select name="grade">
	          <option value="초등학교" <c:if test="${fn:indexOf(grade,'초') !=-1 or fn:indexOf(command.grade,'초') !=-1 }">selected</c:if>>초등학교</option>
	          <option value="중학교" <c:if test="${fn:indexOf(grade,'중') !=-1 or fn:indexOf(command.grade,'중') !=-1}">selected</c:if>>중학교</option>
	          <option value="고등학교" <c:if test="${fn:indexOf(grade,'고') !=-1 or fn:indexOf(command.grade,'고') !=-1}">selected</c:if>>고등학교</option>
	          <option value="대학교" <c:if test="${fn:indexOf(grade,'대') !=-1 or fn:indexOf(command.grade,'대') !=-1}">selected</c:if>>대학교</option>
	         </select>
	         </td>
	        </tr>
	        <tr bgcolor="white">
	         <td>자기소개</td>
	         <td>
	         <textarea name="self" cols="30" rows="10">${self}${command.self}</textarea>
	         </td>
	        </tr>
	        <tr bgcolor="white" align="center">
	         <td colspan="2">
	          <input type="submit" value="확인"/>
	         </td>
	        </tr> 
	       </table> 
	 </fieldset>
</body>
</html>