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
<br><br>
<table width="800" border="1">
	<tr>
		<td colspan="2"> 수의사 전공입력 </td>
	</tr>
	<tr>
		<td>
			<form action="vet_specialties_add" method="get">
				<select name="vet_id">
					<c:forEach items="${vetslist}" var="dto">
						<option value="${dto.id}"> ${dto.first_name}, ${dto.last_name} </option>				
					</c:forEach>
				</select>
		</td>
		<td>
		    <input type="checkbox" name="specialties" value="1" checked="checked">physician
		    <input type="checkbox" name="specialties" value="2" >surgery
		    <input type="checkbox" name="specialties" value="3" >dentistry
		    <input type="checkbox" name="specialties" value="4" >radiology
		</td>
		<td>
			<input type="submit" value="선택">
		</td>
			</form>
	</tr>
</table>

<p><a href="list">FreeBoard</a>
<p><a href="vetslist">Pet-Clinic</a>
<p><a href="vetselect_view">수의사 전공별 열람</a>
<p><a href="vet_add_view">수의사 등록</a>

</body>
</html>