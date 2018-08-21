<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정결과</title>
</head>
<body>
<h2>회원 정보</h2>
ID : ${sessionScope.login_info.id }<br>
Password : ${sessionScope.login_info.password}<br>
이름 : ${sessionScope.login_info.name}<br>
주민번호 : ${sessionScope.login_info.registerNumber}<br>
마일리지 : ${sessionScope.login_info.mileage}
</body>
</html>