<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>airline_list.jsp</title>
</head>
<body>

<table width="600" cellpadding="0" cellspacing="0" border="1">
  <tr>
	  <td>항공편-코드</td>
	  <td>항공사</td>
	  <td>삭제</td>
  </tr>
	  <c:forEach items="${airline_list}" var="dto">
		<tr>
		    <td>${dto.a_code }</td>
		    <td>${dto.a_name }</td>
		    <td><a href = "airline_delete?a_code=${dto.a_code}">X</a></td>
		</tr>
	  </c:forEach>
  <tr>
  	  <td colspan="5"> <a href="airline_input">항공사 입력</a></td>
  </tr>    
</table>

<br>
<a href="index_input">입력HOME</a><br><br>

</body>
</html>