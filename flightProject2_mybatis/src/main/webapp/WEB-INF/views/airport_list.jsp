<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>airport_list.jsp</title>
</head>
<body>

<table width="600" cellpadding="0" cellspacing="0" border="1">
  <tr>
    <td>대륙</td>
    <td>나라</td>
    <td>공항코드</td>
    <td>공항이름</td>
    <td>삭제</td>

  </tr>
  <c:forEach items="${airport_list}" var="dto">
  <tr>
    <td>${dto.port_continent}</td>
    <td>${dto.port_country}</td>
    <td>${dto.port_code }</td>
    <td>${dto.port_name }</td>
    <td><a href = "airport_delete?port_code=${dto.port_code}">X</a></td>
  </tr>
  </c:forEach>
  <tr>
    <td colspan="5"> <a href="airport_input">공항 입력</a></td>
  </tr>    
</table>

</body>
</html>