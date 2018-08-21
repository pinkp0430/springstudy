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

vetslistall.jsp

<table width="400" border="1">
	<tr>
		<td >ID</td><td>NAME</td><td>PART</td>
	</tr>
	<c:forEach items="${vetslist}" var="dto">
		<tr>
			<td> ${dto.id}</td>
			<td> ${dto.first_name}, ${dto.last_name}</td>
			<td> 
				<c:forEach items="${vetspeslist}" var="vsdto" varStatus="vstatus">
					<c:if test="${vsdto.vet_id == dto.id}">
						${specialtieslist[vsdto.specialty_id-1].name},
					</c:if>
			 	</c:forEach>
			</td>
		</tr>
	</c:forEach>
</table>

<pre>
	//model:
	//vetslist - 의사정보 (id, first_name, last_name)
	//vetspeslist - 의사ID 와 전공ID 매핑 (vet_id, specialty_id)
	//specialtieslist - 전공 (id, name)

</pre>


<p><a href="list">FreeBoard</a>
<p><a href="vetslist">Pet-Clinic</a>
<p><a href="vetselect_view">수의사 전공별 열람</a>
<p><a href="vet_add_view">수의사 등록</a>
<p><a href="vet_add_major">수의사 등록</a>

</body>
</html>