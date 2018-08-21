<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정</title>
</head>
<body>
<jsp:include page="/menu.jsp"/>

<h2>회원정보 수정 폼</h2>

<form 	method="post"
			action="/${initParam.context_root }/modifyMember.do"
			enctype="multipart/form-data">
<input type="hidden" name="id" value="${sessionScope.login_info.id }">
	<table width='500'>
		<tr>
			<td>ID</td>
			<td>${sessionScope.login_info.id }</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>
				<input type="password" name="password">
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" value="${sessionScope.login_info.name }">
			</td>
		</tr>
		<tr>
			<td>주민번호</td>
			<td>
				<input type="text" name="registerNumber1"  value="${sessionScope.login_info.registerNumber1 }" maxlength="6">-
				<input type="text" name="registerNumber2"  value="${sessionScope.login_info.registerNumber2 }" maxlength="7">
			</td>
		</tr>
		<tr>
			<td>사진</td>
			<td>
				<c:choose>
					<c:when test="${empty sessionScope.login_info.pictureFilename}">
						<input type="file" name="upfile">
					</c:when>
					<c:otherwise>
						<a href="/${initParam.context_root }/deleteFile.do">파일삭제</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr> 
			<td colspan="2" >
				<input type="submit" value="수정">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
</body>
</html>