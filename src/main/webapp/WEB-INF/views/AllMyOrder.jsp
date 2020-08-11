<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<style>

table{
	margin-left:auto;
	margin-right:auto;
	text-align: center;
	font-family: 微軟正黑體;
	font-size: 20px;
	border: 3px solid rgb(252, 198, 141);
	border-radius: 15px;
	width:55%; 
}
#title{
margin-top:50px;
margin-bottom:30px;
text-align:center;
font-size: 25px;
font-family: 微軟正黑體;
}
td,td{
height:30px;
text-align:center;
line-height:30px;
}

.thh{
height:20px;
text-align:center;
line-height:40px;
margin:5px;
font-size: 25px;
}

</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<h3 style="font-family:微軟正黑體"><a href="<c:url value='/' />" >回上頁</a></h3>
<h3 id="title">${memberid.name} 您好，以下是您的訂單：</h3>
<table>
<tr>
<th class="thh">訂單編號<hr></th>
<th class="thh">預約時間<hr></th>
<th class="thh">總金額<hr></th>
<th class="thh">查看訂單<hr></th>
<th class="thh">給評價<hr></th>
</tr>
<c:forEach var='Orders' items='${memberOrders}'>	
<tr>
<td>${Orders.orderNo}<hr></td>
<td>${Orders.orderDate}<hr></td>
<td>NT.${Orders.totalAmount}<hr></td>
<td>
<form action="<c:url value='lookorder' />" method="POST">
<button type='submit' class="btn btn-danger"  name='look' value="${Orders.orderNo}">查看</button><hr>
<Input type='hidden' id="ans" name='looks' value='0'>
</form>
</td>
<td>
<form action="<c:url value='/survey153' />" method="GET">
<Input type="hidden" name='orderNumber' value='${Orders.orderNo}'>
<Input type="hidden" name='orderDate' id='orderDate' value='${Orders.orderDate}'>
<Input type="hidden" name='movie' value='${Orders.movieId}'>
<Input type="hidden" name='room' value='${Orders.roomId}'>
<button type='submit' class="btn btn-primary" id="${Orders.orderDate}" name='rate' value="${Orders.orderNo}">評價</button><hr>
<Input type='hidden' id="ratee" name='rates' value='0'>
</form>
</td>
</tr>
</c:forEach>
</table>

<script>
$(".btn-danger").click(function() {
		var no = $(this).val();		
		$("#ans").val(no); 
		console.log("ans="+$("#ans").val()); 
});

$(".btn-primary").click(function() {
	var no2 = $(this).val();		
	$("#ratee").val(no2); 
	console.log("ratee="+$("#ratee").val()); 
});


$(".btn-primary").on("mouseenter",function(){
	//不可評論未來訂單   
  	var today=new Date();
	var odrdate = $(this).attr("id"); //預約時間
	var todayval = Date.parse(today).valueOf();
	var odrval = Date.parse(odrdate).valueOf();
	console.log("today="+today+"odrdate="+odrdate)
	console.log("today==="+Date.parse(today).valueOf()); 
	console.log("odrdate==="+Date.parse(odrdate).valueOf()); 
	if (todayval < odrval){
	alert("尚未到來的訂單無法給予評價");
	}
});
	
	
	




</script>
</body>
</html>