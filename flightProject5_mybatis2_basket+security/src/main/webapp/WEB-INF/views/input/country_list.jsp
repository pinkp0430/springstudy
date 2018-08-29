<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>country_list.jsp</title>
</head>
<body>

<table width="600" cellpadding="0" cellspacing="0" border="1">
  <tr>
	  <td>나라코드</td>
	  <td>나라이름</td>
	  <td>대륙</td>
	  <td>삭제</td>
  </tr>
  <tr>
	  <c:forEach items="${country_list}" var="dto">
	    <tr>
		    <td>${dto.c_code }</td>
		    <td>${dto.c_name }</td>
		    <td>${dto.continent}</td>    
		    <td><a href = "country_delete?c_code=${dto.c_code}">X</a></td>
		</tr>
	  </c:forEach>
  </tr>	
  <tr>
  	  <td colspan="5"> <a href="country_input">나라 입력</a></td>
  </tr>    
</table>

<br>
<a href="index_input">입력HOME</a><br><br>

</body>
</html>