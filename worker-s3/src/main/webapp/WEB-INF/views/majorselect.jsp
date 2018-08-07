<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table width="600" cellpadding="0" cellspacing="0" border="1">
<%--     
  <c:forEach items="${vetselect}" var="dto">
  <tr>
    <td>vetid = 
    <td>${dto.vet_id }</td>
  </tr>
  </c:forEach>

 --%>
	<tr>
	<td>이름</td>
	<td>전화번호</td>
	<td>월급</td>
	</tr>
  <c:forEach items="${majorselect}" var="dto2">
	  <tr>
	    <td>${dto2.e_name}</td>
	    <td> ${dto2.phone}</td>
	    <td> ${dto2.salary}</td>
	  </tr>
  </c:forEach>

<tr>

</tr>

</table>

</body>
</html>