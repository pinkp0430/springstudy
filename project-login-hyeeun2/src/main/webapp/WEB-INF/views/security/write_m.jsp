<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 입력하기</title>
</head>
<body>

  <table width="600" cellpadding="0" cellspacing="0" border="1">
    <form action="write_m_view" method="post">
      <tr>
        <td width="70"> 아이디 </td>
        <td> <input type="text" name="username" size = "30"> </td>
      </tr>
      <tr>
        <td width="70"> 비밀번호 </td>
        <td> <input type="text" name="password" size = "30"> </td>
      </tr>
      <tr>
        <td width="70"> 이름 </td>
        <td> <input type="text" name="m_name" size = "30"> </td>
      </tr>
       <tr>
        <td width="70"> 연락처 </td>
        <td> <input type="text" name="m_call" size = "30"> </td>
      </tr>
      <tr >
        <td colspan="2"> <input type="submit" value="가입하기"></td>
      </tr>
    </form>
  </table>


</body>
</html>