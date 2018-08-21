<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index_search</title>
</head>
<body>
<center>

<br> <br> <br> 
<table width="800" border="1">

<form action="pay_confirm" method="get">
<tr>
		<td>${pay_check.arrive}</td>
		<td>${pay_check.price}</td>	
		<td>${pay_check.dep_time}</td>
		<td>${count}장( ${pay_check.price} * ${count} )원을
			예매하시겠습니까?</td>
		<td>
			<input type="submit" value = "선택">
			<input type="hidden" name="count" value="${count}">
			<input type="hidden" name="arrive" value="${pay_check.arrive}">
			<input type="hidden" name="flight_code" value="${pay_check.flight_code}">
			<input type="hidden" name="dep_time" value="${pay_check.dep_time}">
		</td>
	</tr>	
</form>			
		<!-- 		<c:forEach items="${low_price_list}" var="dto0">
	<c:forEach items="${low_price_list_name}" var="dto1">	
				<tr>		
				<td>${dto1.name}</td>  
			    	<td>${dto0.price}</td>	
			    	<td>${dto0.dep_time}</td>
			    </tr>	
					</c:forEach>  
	    </c:forEach>-->

</table>

<br> <br> <br>

<!-- <a href="continent_tickets">america대륙내 티켓</a><br><br>  -->

<form action="continent_tickets" method="get">
	<select name="continent">
		<c:forEach items="${continent_list}" var="dto2">
	    	<option value="${dto2.continent}">${dto2.continent}</option>
	    </c:forEach>
	</select>
<!-- 
	<select name="country">
		<c:forEach items="${country_list}" var="dto3">
	    	<option value="${dto2.code}">${dto2.name}</option>
	    </c:forEach>
	</select>
 -->	
	<input type="submit" value = "선택">
</form>

<br>

<a href="low_price">최소금액</a><br><br>



</center>
</body>
</html>