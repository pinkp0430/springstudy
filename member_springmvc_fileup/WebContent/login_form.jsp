<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${sessionScope.login_info != null}">
	<jsp:forward page="/res/member_detail.jsp"/>
</c:if>
 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<jsp:include page="/menu.jsp"/>
로그인 폼<br>   
<hr noshade="noshade" width="30%" align="left"> 
<c:if test="${requestScope.error_message != null}">
	<font color="red" size="2">${requestScope.error_message}</font>
</c:if>

<form action="/${initParam.context_root }/login.do" method="post" >
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" size="20"/></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="password" name="password" size="20"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인"/>
				<input type="reset" value="초기화"/>
			</td>
		</tr>
	</table>	
</form>
</body>
</html>