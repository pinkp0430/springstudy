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
    <td>항공사</td>
    <td>항공편명</td>
    <td>출발지</td>
    <td>도착지</td>
    <td>출발시간</td>
    <td>도착시간</td>
    <td>잔여석</td>
    <td>가격</td>
<%--<td>시간</td>  --%>  
    <td>삭제</td>
  </tr>

  <tr>
    <td>${lowP.ticket_id}</td>
    <td>${lowP.airline}</td>
    <td>${lowP.flight_name }</td>
    <td>${lowP.departure }</td>
    <td>${lowP.arrive}</td>
    <td>${lowP.dep_time}</td>
    <td>${lowP.arri_time }</td>
    <td>${lowP.seat_able }</td>
    <td>${lowP.seat_price }</td>
<%--<td>${dto.dtime}${dto.stime}</td>  --%> 
    <td><a href = "ticket_delete?ticket_id=${lowP.ticket_id}">X</a></td>
  </tr>

  <tr>
    <td colspan="5"> <a href="index">INDEX</a></td>
  </tr>    
</table>

</body>
</html>