<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table width="600" cellpadding="0" cellspacing="0" border="1">

	<tr>
	<td>번호</td>
	<td>${view.id}</td>
	</tr>
	<tr>
	<td>이름</td>
	<td>${view.name}</td>
	</tr>
	<tr>
	<td>제목</td>
	<td>${view.title}</td>
	</tr>
	<tr>
	<td>내용</td>
	<td>${view.content}</td>
	</tr>
	<tr>
	<td colspan="2">
        <a href="list">목록보기</a>
        <a href="delete?id=${view.id}">삭제</a> <!-- BController의 RequestMapping("/delete")이 호출되는데, 이 페이지의 bId 값을 가지고 간다  -->
	</td>
	</tr>
</body>
</html>