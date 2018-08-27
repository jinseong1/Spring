<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>ValidationComplete.jsp</title>
</head>
<body>
   	<fieldset>
   		<legend>유횽성 검증 결과 페이지</legend>
      <table bgcolor="gray" cellspacing="1" width="60%" >
       <tr bgcolor="white">
        <td>이름</td>
        <td>${command.name}</td>
       </tr>
       <tr bgcolor="white">
        <td>나이</td>
        <td>${command.years} </td>
       </tr>
       <tr bgcolor="white">
        <td>성별</td>
        <td>${command.gender}</td>
       </tr>
       <tr bgcolor="white">
        <td>관심사항</td>
        <td>${command.inters} <br/>
        	${paramValues.inters}
        </td>
       </tr>
       <tr bgcolor="white">
        <td>학력</td>
        <td>${command.grade}</td>
       </tr>
       <tr bgcolor="white">
        <td>자기소개</td>
        <td>${command.self}</td>
       </tr>
      </table> 
   	</fieldset>
</body>
</html>