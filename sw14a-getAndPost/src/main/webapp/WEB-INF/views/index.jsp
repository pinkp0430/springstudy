<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

index.jsp

<p>

<!-- GET 방식이닷, 주소창에 id & pw 값이 다 나옴 
<form action="student" > -->
<form action="student" method="get"> 
	Get Student ID : <input type="text" name="id"><br>
	Get Student ID : <input type="text" name="pw"><br>
	<input type="submit" value="전송">
</form>

<form action="student" method="post"> 
	Post Student ID : <input type="text" name="id"><br>
	Post Student ID : <input type="text" name="pw"><br>
	<input type="submit" value="전송">
</form>

</p>

</body>
</html>