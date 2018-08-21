<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkMileage(){
	var mileage1= document.searchForm1.sMileage;
	var mileage2= document.searchForm1.eMileage;
	if(mileage1.value==""||mileage2.value==""){
		alert("검색할 마일리지를 입력하세요");
		return false;
	}
	if(isNaN(mileage1.value)||isNaN(mileage2.value)){
		alert("마일리지는 숫자를 입력하십시요");
		return false;
	}	
	if(parseInt(mileage1.value) > parseInt(mileage2.value)){
		alert("마일리지 입력시 뒤의 것이 더 커야 합니다.");
		return false;
	}
}
</script>
</head>
<body>
<jsp:include page="menu.jsp"/>
<font color="red" size="2">${requestScope.error_message }</font>
<form action="/${initParam.context_root }/searchMemberByMileageRange.do" method="post" 
			name="searchForm1" onsubmit="return checkMileage()">
마일리지 범위 : <input type="text" name="sMileage">~<input type="text" name="eMileage">
<input type="submit" value="마일리지 범위로 조회">
</form>
<br>

<form action="/${initParam.context_root }/searchMemberByName.do" method='post'>
이름 : <input type="text" name="name">
<input type="submit" value="이름으로 검색">
</form>
</body>
</html>










