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

vetslist.jsp

<table width="400" border="1">
	<tr>
		<td >id</td><td>name</td>
	</tr>
	<c:forEach items="${vetslist}" var="dto">
		<tr>
			<td> ${dto.id}</td>
			<td> ${dto.first_name}, ${dto.last_name}</td>
		</tr>
	</c:forEach>
</table>

<p><a href="list">FreeBoard</a>
<p><a href="vetslist">Pet-Clinic</a>
<p><a href="vetselect_view">Pet-Clinic 수의사 전공별 열람</a>
<p><a href="vet_add_view">수의사 등록</a>
<LI><a href="vet_spe_add_view"> 의사 전공 정보 추가/수정 </a></LI>
<LI><a href="vetslistall"> 의사 전공 정보 추가된 리스트 </a></LI>
</body>
</html>