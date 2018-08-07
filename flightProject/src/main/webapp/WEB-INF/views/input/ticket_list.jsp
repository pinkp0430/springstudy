<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>airport_list.jsp</title>
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

  <c:forEach items="${ticket_list}" var="dto">
  <tr>
    <td>${dto.ticket_id}</td>
    <td>${dto.airline}</td>
    <td>${dto.flight_name }</td>
    <td>${dto.departure }(${dto.dName })</td>
    <td>${dto.arrive}</td>
    <td>${dto.dep_time}</td>
    <td>${dto.arri_time }</td>
    <td>${dto.seat_able }</td>
    <td>${dto.seat_price }</td>
<%--<td>${dto.dtime}${dto.stime}</td>  --%> 
    <td><a href = "ticket_delete?ticket_id=${dto.ticket_id}">X</a></td>
  </tr>
  </c:forEach>
  <tr>
    <td colspan="5"> <a href="ticket_input">티켓 입력</a></td>
  </tr>    
</table>

</body>
</html>