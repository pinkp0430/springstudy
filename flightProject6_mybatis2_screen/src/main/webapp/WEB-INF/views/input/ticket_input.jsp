<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ticket_input</title>
</head>
<body>
	  
    <table width="550" cellpadding="0" cellspacing="0" border="1">
    <form action="inputTicket" method="post">
      <tr>
        <td> 항공편-코드 </td>
        <td> <input type="text" name="flight_code" size = "30"> </td>
      </tr>
      <tr>
        <td> 출발지 </td>
        <td> <input type="text" name="departure" size = "30"> </td>
      </tr>
      <tr>
        <td> 도착지 </td>
        <td> <input type="text" name="arrive" size = "30"> </td>
      </tr>
      <tr>
        <td> 출발시간 (yyyy-mm-dd hh:mi:ss) </td>
        <td> <input type="text" name="dep_time" size = "30"> </td>
      </tr>
      <tr>
        <td> 비행시간 (yyyy-mm-dd hh:mi:ss)  </td>
        <td> <input type="text" name="flight_time" size = "30"> </td>
      </tr>
      <tr>
        <td> 도착시간 (yyyy-mm-dd hh:mi:ss)  </td>
        <td> <input type="text" name="arri_time" size = "30"> </td>
      </tr> 
      <tr>     
         <td> 가격 </td>
         <td> <input type="text" name="price" size = "30"> </td> 
      </tr>
      <tr>     
         <td> 잔여석 </td>
         <td> <input type="text" name="seat_able" size = "30"> </td> 
      </tr>
      <tr>   
      	 <td> 추천  </td>
         <td> <input type="text" name="md" size = "30"> </td>      
		 <td>&nbsp;&nbsp;<input type="submit" value="입력"></td>
  	  </tr>
    </form> 


  	</table>
  	

  
  
</body>
</html>