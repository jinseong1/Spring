<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:import url="https://www.nate.com" var="nate"/>
${fn:replace(nate, "/css/","https://www.nate.com/css/") }
<!-- ImportedDaum.jsp -->