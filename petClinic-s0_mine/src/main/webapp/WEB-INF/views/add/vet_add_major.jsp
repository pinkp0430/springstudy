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
vet_add_major.jsp

<!-- 의사정보(vets - VetsDao) 정보 노출 & 선택 -->
	<tr>
		<td>
			<form action="vet_add_major_mod" method="get">
				<select name="vet_id">
					<c:forEach items="${vetslist}" var="dto">
						<option value="${dto.id}">${dto.id} : ${dto.first_name}, ${dto.last_name} </option>				
					</c:forEach>
				</select>
		</td>
<!-- 전공(vet_specialties - Vets) 정보 노출 & 선택 -->
		<td>
			<c:forEach items="${specialtieslist}" var="dto">	
				<input type="checkbox" id="major" name="major" value="${dto.id}">
				<label for="specialty_id">${dto.name}</label>
<!--		    	<input type="checkbox" name="specialties" value="1" checked="checked">physician
			    <input type="checkbox" name="specialties" value="2" >surgery
			    <input type="checkbox" name="specialties" value="3" >dentistry
			    <input type="checkbox" name="specialties" value="4" >radiology    -->
		    </c:forEach>
		</td>
		<td>
			<input type="submit" value="subscribe">
		</td>
			</form>
	</tr>


</body>
</html>