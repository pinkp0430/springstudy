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


<table width="600" cellpadding="0" cellspacing="0" border="1">
	<tr>
	<td>번호</td>
	<td>이름</td>
	<td>제목</td>
	<td>삭제</td>
	</tr>
	
	<c:forEach items="${list}" var="dto">
	<tr>
	<td>${dto.id}</td>
	<td>${dto.name}</td>
	<td><a href="view?id=${dto.id}">${dto.title}</td>
	<td><a href="delete?id=${dto.id}">X</a></td> <!-- BController의 RequestMapping("/delete")이 호출되는데, 이 페이지의 bId 값을 가지고 간다  -->
	</tr>
	</c:forEach>
	
	<tr>
	<td colspan="5"><a href="write_view">글작성</a></td>
	</tr>
</table>

</body>
</html>