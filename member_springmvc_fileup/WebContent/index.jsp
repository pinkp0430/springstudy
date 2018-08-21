<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인페이지</title>
</head>
<body>
<h1>회원관리</h1>
<a href='/${initParam.context_root }/register_form.jsp'>회원가입폼</a><br>
<a href="/${initParam.context_root }/login_form.jsp">로그인폼</a><br>
<a href="/${initParam.context_root }/controller?command=getAllMemberInfo">전체 회원정보 조회</a><br>
<a href="/${initParam.context_root }/search_form.jsp">검색</a>&nbsp;&nbsp;
</body>
</html>