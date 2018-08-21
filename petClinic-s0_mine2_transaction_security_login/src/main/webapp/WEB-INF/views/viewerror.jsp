<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>viewerror</title>
</head>
<body>

<%@ page isErrorPage = "true" %>
..
요청 처리 과정에서 에러가 발생하였습니다.<br>
빠른 시간 내에 문제를 해결하도록 하겠습니다.
<p>
에러 타입: <%= exception.getClass().getName() %> <br>
에러 메시지: <b><%= exception.getMessage() %></b>
<hr>
<a href="${pageContext.request.contextPath}">Home</a>

</body>
</html>
