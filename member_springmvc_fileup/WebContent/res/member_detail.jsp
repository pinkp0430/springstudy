<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보상세</title>
</head>
<body>
<jsp:include page="/menu.jsp"/>

<h2>회원 정보</h2>
<c:if test="${not empty sessionScope.login_info.pictureFilename}">
	<img width="300px" src='/${initParam.context_root }/pictures/${sessionScope.login_info.pictureFilename}'><br>
</c:if>
	
ID : ${sessionScope.login_info.id }<br>
Password : ${sessionScope.login_info.password}<br>
이름 : ${sessionScope.login_info.name}<br>
주민번호 : ${sessionScope.login_info.registerNumber1}-${sessionScope.login_info.registerNumber2}<br>
마일리지 : ${sessionScope.login_info.mileage}
<p>
<a href="/${initParam.context_root }/modifyForm.do">회원정보 수정</a>
<a href="/${initParam.context_root }/removeMember.do">회원 탈퇴</a>
</p>
</body>
</html>












