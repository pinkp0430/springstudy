<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:authorize ifAnyGranted="ROLE_USER">
<p> <b>USER</b> "<s:authentication property="name"/>" is Log-In</p>
<!-- USER가 들어오면 바로  index_search화면으로 이동 -->
<%  
	response.sendRedirect("index_search"); 
%>
</s:authorize>

<s:authorize ifAnyGranted="ROLE_ADMIN">
<p> <b>ADMIN</b> "<s:authentication property="name"/>" is Log-In
<!-- ADMIN이 들어오면 바로  index_input화면으로 이동 -->
 <% response.sendRedirect("index_input");  %>
</s:authorize>

<!--  
<a href="${pageContext.request.contextPath}/j_spring_security_logout">로그아웃</a>
-->

</body>
</html>