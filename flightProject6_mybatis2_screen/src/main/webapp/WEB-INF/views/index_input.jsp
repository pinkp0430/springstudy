<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>

<a href="country_list">나라입력</a><br><br>
<a href="airline_list">항공사입력</a><br><br>
<a href="airport_list">공항입력</a><br><br>
<a href="ticket_list">항공권입력</a><br><br>

<hr>

<br>
<a href="low_price">최소금액</a><br><br>

<!-- <a href="continent_tickets">america대륙내 티켓</a><br><br>  -->
<form action="continent_tickets" method="post">
<select name="continent">
    <option value="Asia" selected="selected">Asia</option>
    <option value="America">America</option>
    <option value="Europe" >Europe</option>
    <option value="Africa">Africa</option>
</select>
<input type="submit" value = "선택">
</form>


</body>
</html>