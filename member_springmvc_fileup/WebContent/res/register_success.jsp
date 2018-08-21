<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입결과</title>
</head>
<body>
<jsp:include page="/menu.jsp"/>
<h2>가입 환영합니다.</h2>
<h3>가입 시 입력하신 정보입니다.</h3>
<c:if test="${not empty requestScope.mdto.pictureFilename }">
	<img src="/${initParam.context_root }/pictures/${requestScope.mdto.pictureFilename }" width="300px"><br>
</c:if>
ID : ${requestScope.mdto.id }<br>
Password : ${requestScope.mdto.password}<br>
이름 : ${requestScope.mdto.name}<br>
주민번호 : ${requestScope.mdto.registerNumber1}-${requestScope.mdto.registerNumber2}<br>
마일리지 : ${requestScope.mdto.mileage}<p>
<a href="/${initParam.context_root }/login_form.jsp">로그인</a>
<a href="/${initParam.context_root }/index.jsp">메인페이지</a>
</body>
</html>











