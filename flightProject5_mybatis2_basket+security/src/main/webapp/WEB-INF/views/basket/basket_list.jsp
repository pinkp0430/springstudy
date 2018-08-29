<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>basket_list</title>
</head>
<body>
<center>

<br> <br> <br> 
<table width="800" border="1">



<form action="pay_confirm" method="get">
<tr>

	<c:forEach items="${basket_list}" var="dto">
		<tr>		
			<td>id ${dto.ticket_id}</td>  
			<td>${dto.arrive}</td>	
			<td>${dto.dep_time}</td>
			<td>${dto.price}</td>			
			<td>${dto.seat_buy}</td>
			<td><a href="basket_delete?id=${dto.ticket_id}">삭제</a></td>
			<td><a href="pay_confirm?id=${dto.ticket_id}&count=${dto.seat_buy}">결제</a></td>
		</tr>	
	</c:forEach>

<input type="submit" value = "선택">
<input type="hidden" name="count" value="${count}">
		
</tr>	
</form>			


</table>

<br> <br> <br>





</center>
</body>
</html>