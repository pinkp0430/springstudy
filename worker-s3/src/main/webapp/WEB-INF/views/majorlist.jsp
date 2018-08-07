<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

majorlist.jsp

<table width="200" border="1">
	<c:forEach items="${majorlist}" var="dto">
		<tr>
			<td>id = </td>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<td>name = </td>
			<td>${dto.m_name}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>