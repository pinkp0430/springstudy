<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입폼</title>
<script type="text/javascript">
	function checkInput(){
		var form = document.registerForm;
		if(!form.id.value){
			alert("ID는 필수 입력사항 입니다.");
			form.id.focus();
			return false;
		}
		if(!form.password.value){
			alert("패스워드는 필수 입력사항 입니다.");
			form.password.focus();
			return false;
		}
		if(!form.name.value){
			alert("이름은 필수 입력사항 입니다.");
			form.name.focus();
			return false;
		}
		if(!form.registerNumber1.value){
			alert("주민번호는 필수 입력사항 입니다.");
			form.registerNumber1.focus();
			return false;
		}
		if(form.registerNumber1.value.length!=6){
			alert("주민번호 앞자리는 6글자입니다.");
			form.registerNumber1.focus();
			return false;
		}
		if(!form.registerNumber2.value){
			alert("주민번호는 필수 입력사항 입니다.");
			form.registerNumber2.focus();
			return false;
		}
		if(form.registerNumber2.value.length!=7){
			alert("주민번호 뒷자리는 7글자입니다.");
			form.registerNumber2.focus();
			return false;
		}
		//사진 파일 체크
		var fileName = form.upfile.value;
		if(fileName!=""){
			var ext = fileName.substring(fileName.lastIndexOf(".")+1);
			if(ext!="jpg"&&ext!="png"&&ext!="jpeg"&&ext!="bmp"&&ext!="gif"){
				alert("그림파일만 업로드 가능합니다.");
				return false;
			}
		}
	}
</script>
</head>
<body>
<jsp:include page="menu.jsp"/>
<h2>가입양식</h2>
<form method="post"
		  enctype="multipart/form-data" 
		  action="/${initParam.context_root }/registerMember.do" 
		  name="registerForm" onsubmit="return checkInput();">
	<table width='500'>
		<tr>
			<td>ID</td>
			<td>
				<input type="text" name="id">
			</td>
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
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<td>주민번호</td>
			<td>
				<input type="text" name="registerNumber1" maxlength="6">-
				<input type="text" name="registerNumber2" maxlength="7">
			</td>
		</tr>
		<tr>
			<td>사진</td>
			<td>
				<input type="file" name="upfile">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="가입">
				<input type="reset" value="다시작성">
			</td>
		</tr>
		
	</table>
</form>
</body>
</html>