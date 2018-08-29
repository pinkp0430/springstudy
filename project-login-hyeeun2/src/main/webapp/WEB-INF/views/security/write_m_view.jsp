<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<tr>회원가입 입력 확인</tr>
<table width="600" cellpadding="0" cellspacing="0" border="1">
  <tr>
    <td width="20">아이디</td>
    <td width="20">이름</td>
    <td width="40">연락처</td>
  </tr>
  
  <tr>
    <td>${mdto.username}</td>
    <td>${mdto.m_name}</td>
    <td>${mdto.m_call }</td>
      
  </tr>
  
  <tr>
  <p>
   <a href="write_c?username=${mdto.username}">가입하기</a><P>
   
   <a href="delete?username=${mdto.username}">취소하기</a>
  </tr>    
</table>

</body>
</html>