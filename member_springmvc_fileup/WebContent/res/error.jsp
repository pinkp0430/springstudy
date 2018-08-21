<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>에러페이지</title>
</head>
<body>
<jsp:include page="/menu.jsp"/>
 
실행 도중 오류가 발생했습니다.<br>
<c:if test="${not empty requestScope.error_message }">
	오류 내용 ${requestScope.error_message }
</c:if>
<p>
	<a href='/${initParam.context_root }/index.jsp'>메인페이지로 이동</a>
</p>
</body>
</html>







