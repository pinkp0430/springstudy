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
<jsp:include page="../security/login_status.jsp" flush="false"></jsp:include>

<center>

<br> <br> <br> 
<table width="800" border="1">

<form action="basket_input" method="get">
	<tr>
		<td>${ticket_port.arrive}</td>
		<td>${ticket_port.price}</td>	
		<td>${ticket_port.dep_time}</td>
		<td>${ticket_port.seat_able}</td>		
	
		<td>
			<select name="count">
	    		<option value="1">1</option>
	    		<option value="2">2</option>
	    		<option value="3">3</option>
	    		<option value="4">4</option>
			</select>
			<input type="submit" value = "장바구니">
			<input type="hidden" name="id" value="${ticket_port.ticket_id}">
		</td>
<!--  		<td>
			<a href="bastet?id=${ticket_port.ticket_id}&count=count.value" >장바구니</a>
-->		</td>
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