<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>

<a href="http://localhost:8181/web/airport_list">공항입력</a><br><br>
<a href="http://localhost:8181/web/ticket_list">항공권입력</a><br><br>

<a href="low_price">최소금액</a><br><br>

<!-- <a href="continent_tickets">america대륙내 티켓</a><br><br>  -->
<form action="continent_tickets" method="post">
<select name="continent">
    <option value="asia" selected="selected">Asia</option>
    <option value="america">America</option>
    <option value="europe" >Europe</option>
    <option value="africa">Africa</option>
</select>
<input type="submit" value = "선택">
</form>


</body>
</html>