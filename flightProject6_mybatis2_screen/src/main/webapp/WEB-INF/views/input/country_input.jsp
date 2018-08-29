<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>country_input</title>
</head>
<body>

    <table width="400" cellpadding="0" cellspacing="0" border="1">

	    <form action="inputCountry" method="post">
	      <tr>
	        <td> 나라코드 </td>
	        <td> <input type="text" name="c_code" size = "30"> </td>
	      </tr>
		  <tr> 
	        <td> 나라이름 </td>
	        <td> <input type="text" name="c_name" size = "30"> </td>
	      </tr>
	      <tr>
	        <td> 대륙 </td>
	        <td> <input type="text" name="continent" size = "30"> </td>
			<td>&nbsp;&nbsp;<input type="submit" value="입력"></td>
	       </tr>   
	    </form> 

  	</table>
  
</body>
</html>