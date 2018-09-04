<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<font size="2">
<s:authorize ifAnyGranted="ROLE_USER">
	<b><s:authentication property="name"/></b>님 좋은 여행되세요~^^ &nbsp&nbsp&nbsp
	<a href="${pageContext.request.contextPath}/j_spring_security_logout">로그아웃</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
</s:authorize>

<a href="loginForm.html">로그인</a>&nbsp&nbsp<a href="write_m.html">회원가입</a>&nbsp&nbsp


</font>
</center>
</body>
</html>

<!--  
<s:authorize ifAnyGranted="ROLE_ADMIN">
<p> <b>ADMIN</b> "<s:authentication property="name"/>" is Log-In
</s:authorize>
-->