<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% pageContext.setAttribute("newline", "\n"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath }/add" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="contents" cols=60 rows=5></textarea></td>
		</tr>
		
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE="확인 "></td>
		</tr>
	</table>
	</form>
	<br>
	<c:set var="count" value="${fn:length(list) }" />
	<c:forEach items="${list }" var="vo" varStatus="status">
		<br>
		<table width=510 border=1>
		<tr>
			<td>[${count-status.index }]</td>
			<td>${vo.name }</td>
			<td>${vo.reg_date }</td>
			<td><a href="${pageContext.servletContext.contextPath }/delete/${vo.no}">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4>${fn:replace(vo.contents,newline,"<br>") }</td>
		</tr>
		</table>
	</c:forEach>
</body>
</html>