<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>low_price.jsp</title>
</head>
<body>

<table width="1000" cellpadding="0" cellspacing="0" border="1">
  <tr>
    <td>티켓넘버</td>
    <td>항공편명</td>
    <td>출발지</td>
    <td>도착지</td>
    <td>출발시간</td>
    <td>비행시간</td>
    <td>도착시간</td>
    <td>가격</td>
    <td>추천</td>
  </tr>

  <tr>
	  <c:forEach items="${low_price}" var="dto">
	  	 <tr>	
		    <td>${dto.ticket_id}</td>
		    <td>${dto.flight_code }</td>
		    <td>${dto.departure }</td>
		    <td>${dto.arrive}</td>
		    <td>${dto.dep_time}</td>
		    <td>${dto.flight_time}</td>    
		    <td>${dto.arri_time }</td>
		    <td>${dto.price }</td>
		    <td>${dto.md }</td>
		 </tr>
	   </c:forEach>
  </tr>

</table>

<br>
    <td colspan="5"> <a href="index_search">INDEX_SEARCH</a></td>
    
</body>
</html>