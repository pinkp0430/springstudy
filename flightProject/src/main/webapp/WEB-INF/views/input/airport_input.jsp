<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>airport_input</title>
</head>
<body>

    <table width="400" cellpadding="0" cellspacing="0" border="1">
    <form action="inputAirport" method="post">
      <tr>
        <td width="70"> 대륙 </td>
        <td> <input type="text" name="port_continent" size = "30"> </td>
      </tr>
      <tr>
        <td> 나라 </td>
        <td> <input type="text" name="port_country" size = "30"> </td>
      </tr>
      <tr>
        <td> 공항코드 </td>
        <td> <input type="text" name="port_code" size = "30"> </td>
      </tr>

        <td> 공항이름 </td>
        <td> <input type="text" name="port_name" size = "30"> </td>        
		<td>&nbsp;&nbsp;<input type="submit" value="입력"></td>
  
    </form> 


  	</table>
  	

  
  
</body>
</html>