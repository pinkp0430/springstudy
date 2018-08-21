<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<a href='/${initParam.context_root }/index.jsp'>메인페이지</a>&nbsp;&nbsp;
<c:choose>
	<c:when test="${sessionScope.login_info == null }">
		<a href='/${initParam.context_root }/register_form.jsp'>회원가입폼</a>&nbsp;&nbsp;
		<a href="/${initParam.context_root }/login_form.jsp">로그인폼</a>&nbsp;&nbsp;
	</c:when>
	<c:otherwise>
		<a href='/${initParam.context_root }/logout.do'>로그아웃</a>&nbsp;&nbsp;
		<a href="/${initParam.context_root }/getLoginMemberInfo.do">회원정보조회</a>&nbsp;&nbsp;
		<a href="/${initParam.context_root }/modifyForm.do">회원정보 수정</a>&nbsp;&nbsp;
		<a href="/${initParam.context_root }/controller?command=removeMember">회원 탈퇴</a>&nbsp;&nbsp;
	</c:otherwise>
</c:choose>
<a href="/${initParam.context_root }/getAllMemberInfo.do">전체 회원정보 조회</a>&nbsp;&nbsp;
<a href="/${initParam.context_root }/search_form.jsp">검색</a>&nbsp;&nbsp;

<hr width="700" align="left" noshade="noshade">












