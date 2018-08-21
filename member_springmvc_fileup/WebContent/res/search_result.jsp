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
<jsp:include page="/menu.jsp"/>
<h2>${requestScope.title }</h2>
<h3>검색 조건 : ${requestScope.search_value }</h3>
<table width="500">
	<tr>
		<td>ID</td>
		<td>Password</td>
		<td>이름</td>
		<td>주민번호</td>
		<td>마일리지</td>
	</tr>
	<c:forEach items="${requestScope.member_list }" var="mto">
		<tr>
			<td>${mto.id }</td>
			<td>${mto.password}</td>
			<td>${mto.name}</td>
			<td>${mto.registerNumber1}-${mto.registerNumber2}</td>
			<td>${mto.mileage}</td>
		</tr> 
	</c:forEach>
</table>
</body>
</html>