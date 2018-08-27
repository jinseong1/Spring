<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 어느 컨트롤러에서 왔는지에 따라 분기 -->
<c:choose>
	<c:when test="${WHERE eq 'INS' }">
		<c:set var="successMessage" value="입력 성공했어요"/>
		<c:set var="failMessage" value="입력 실패했어요"/>
		<c:set var="successMoveUrl" value="/DataRoom/List.kosmo"/>
	</c:when>
	<c:when test="${WHERE eq 'EDT' }">
		<c:set var="successMessage" value="수정 성공했어요"/>
		<c:set var="failMessage" value="수정 실패했어요"/>
		<c:set var="successMoveUrl" value="/DataRoom/View.kosmo?no=${no}"/>
	</c:when>
	<c:otherwise>
		<c:set var="successMessage" value="삭제 성공했어요"/>
		<c:set var="failMessage" value="삭제 실패했어요"/>
		<c:set var="successMoveUrl" value="/DataRoom/List.kosmo"/>
	</c:otherwise>
</c:choose>
<script>
	<c:choose>
		<c:when test="${successFail==1}">
			alert('${successMessage}');
			location.replace("<c:url value='${successMoveUrl}'/>");
		</c:when>
		<c:when test="${successFail==0}">
			alert("${failMessage}");
			history.back();
		</c:when>
		<c:otherwise>
			alert("파일 업로드 용량을 초과했어요");
			history.back();
		</c:otherwise>
	</c:choose>
</script>