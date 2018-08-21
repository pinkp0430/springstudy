<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인성공</title>
</head>
<body>
<jsp:include page="/menu.jsp"/>
${sessionScope.login_info.id }, ${sessionScope.login_info.name}님이 로그인 하셨습니다.<br>
<br>
<a href='/${initParam.context_root }/logout.do'>로그아웃</a><br>
<a href="/${initParam.context_root }/getLoginMemberInfo.do">회원정보조회(로그인한 회원의정보)</a><br>
<a href="/${initParam.context_root }/removeMember.do">회원 탈퇴</a>
<p>
</body>
</html>










