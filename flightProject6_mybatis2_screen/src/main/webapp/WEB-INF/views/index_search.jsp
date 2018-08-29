<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>title</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

<style>

.frame {width:900px;margin:0 auto;}
.list-unstyled > li {float:left;width:24%;padding:5px;}
.form-submit {float:none;clear:both;margin-top:30px;text-align:center;}
.card {position:relative;}
.order-qty {position:absolute;right:10px;bottom:10px;}

.modal {}
.modal .card-submit {display:none;}

</style>
</head>
<body>

<div class="nav">
</div>

<div class="frame">
		<div class="form-group">
			<label for="" class="control">인기지역</label>
			<ul class="">
				<li><a href="">일본</a></li>
				<li><a href="">중국</a></li>
				<li><a href="">대만</a></li>
			</ul>
		</div>
	<c:forEach items="${low_price_list}" var="dto0">
		<ul class="list-unstyled">
			<li style="float:left;">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">
							<span class="departure">
								<strong>${dto0.dep_name}</strong><em>${dto0.departure}</em>
							</span>
							<span class="arrive">
								<strong>${dto0.arri_name}</strong><em>${dto0.arrive}</em>
							</span>
						</h5>
						<p class="card-text price">
							<span class="price"><fmt:formatNumber value="${dto0.price}" pattern="#,###.##"/>원</span>
						</p>
						<p class="card-text datetime">
							<span class="departure" title="출발시각">${dto0.dep_time}</span>
						</p>
						<div class="card-submit">
							<button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#modal-order">주문</button>
							<button type="button" class="btn btn-sm btn-info" data-toggle="collapse" data-target="#collapse-info${dto0.ticket_id}">자세한정보</button>
						</div>
					</div>

					<div class="card-footer collapse" id="collapse-info${dto0.ticket_id}">
						<dl class="dl-horizontal">
							<dt>출발시각</dt>
							<dd>${dto0.dep_time}</dd>
							<dt>도착예정시각</dt>
							<dd>${dto0.arri_time}</dd>
							<dt>소요시간</dt>
							<dd>${dto0.flight_time}</dd>
							<dt>소아 운임</dt>
							<dd>${dto0.price}(50%할인)</dd>
						</dl>
						
						
						<input type="hidden" name="id" value="${dto0.ticket_id}">
						<input type="hidden" name="tk-qty" value="1">
					</div>
				</div>
			</li>
		</ul>
	</c:forEach>	
</div>

<!-- Modal -->

<div class="modal fade" id="modal-order" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">티켓 구입</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
	<form name="order-form" method="post" class="form-order" >
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" id="ticket_port" >결제하기</button>
      </div>
	</form>
    </div>
  </div>
</div>

<script>

function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};
    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

//modal-order

$('#modal-order').on('show.bs.modal', function (event) {
	var button = $(event.relatedTarget);
	var recipient = button.data('tk-id');
	var card = button.closest('.card');
	var info1 = card.find('.card-body');
	var info2 = card.find('.card-footer');
	var info = info1.html() + info2.html();
	var modal = $(this);
	modal.find('.modal-body').html(info);
});


$(document).on('submit', '.form-order', function(e){
	console.log('submit:', e);
	e.preventDefault();
	e.stopPropagation();
	//console.log( $( this ).serialize() );
	var data = getFormData($(this));
	console.log(data);
	//alert(data);
});

$(document).on('click', '.menu-qty .btn', function(e){
	//console.log('click:', e);
	console.log('click:', e.target.dataset.qty, e.target.dataset.target);
	$('#'+e.target.dataset.target).val( e.target.dataset.qty );
	//$(e.target).value = $(e.target).
});

</script>



<center>

<a href="loginForm.html">로그인</a>&nbsp&nbsp<a href="write_m.html">회원가입</a>&nbsp&nbsp<a href="loginform.html">로그인</a><br><br>
<br> <br> <br> 
<table width="800" border="1">
	<tr>
		<c:forEach items="${low_price_list}" var="dto0">
			<tr>
				<td>${dto0.dep_name}</td>
				<td>${dto0.arri_country}</td>
				<td>${dto0.price}</td>	
				<td>${dto0.dep_time}</td>
				<td>${dto0.seat_able}</td>	
				<td><a href="ticket_port?id=${dto0.ticket_id}">예매</a>
			</tr>
	    </c:forEach>				
		<!-- 		<c:forEach items="${low_price_list}" var="dto0">
	<c:forEach items="${low_price_list_name}" var="dto1">	
				<tr>		
				<td>${dto1.name}</td>  
			    	<td>${dto0.price}</td>	
			    	<td>${dto0.dep_time}</td>
			    </tr>	
					</c:forEach>  
	    </c:forEach>-->
	</tr>	
</table>
<br><br>  
<br><br> 

<!-- <a href="continent_tickets">america대륙내 티켓</a><br><br>  -->

<form action="continent_tickets" method="get">
	<select name="continent">
		<c:forEach items="${continent_list}" var="dto2">
	    	<option value="${dto2.continent}">${dto2.continent}</option>
	    </c:forEach>
	</select>
<!-- 
	<select name="country">
		<c:forEach items="${country_list}" var="dto3">
	    	<option value="${dto2.code}">${dto2.name}</option>
	    </c:forEach>
	</select>
 -->	
	<input type="submit" value = "선택">
</form>

<br>

<a href="low_price">최소금액</a><br><br>



</center>
</body>
</html>