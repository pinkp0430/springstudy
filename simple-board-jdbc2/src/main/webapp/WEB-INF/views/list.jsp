<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 한글 깨짐 방지 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <!-- 한글 깨짐 방지 설정 -->
<title>Insert title here</title>
</head>
<body>

<table width="600" cellpadding="0" cellspacing="0" border="1">
	<tr>
	<td>번호</td>
	<td>이름</td>
	<td>제목</td>
	<td>날짜</td>
	<td>HIT</td>
	<td>그룹</td>
	<td>Indent</td>
	<td>Step</td>
	</tr>
	
	<c:forEach items="${list}" var="dto"> <!-- list값을 받아 dto에 넣어주고, 행을 반복 출력 -->
	<tr>
	<td>${dto.bId}</td>
	<td>${dto.bName}</td>
	<td>
		<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
		<a href="content_view?bId=${dto.bId}">${dto.bTitle}</a>
	</td>
	<td>${dto.bDate}</td>
	<td>${dto.bHit}</td>
	<td>${dto.bGroup}</td>
	<td>${dto.bIndent}</td>
	<td>${dto.bStep}</td>
	</tr>
	</c:forEach>
	
	<tr>
	<td colspan="5"><a href="write_view">글작성</a></td>
	</tr>
	
</table>

</body>
</html>