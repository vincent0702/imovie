<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
	*{
	font-family: 微軟正黑體;
	}
	#answer{
	align:center;
	margin-left:auto;
	margin-right:auto;
	margin-top:40px;
	margin-bottom:50px;
	text-align: left;
	font-family: 微軟正黑體;
	font-size: 25px;
	border: 3px solid rgb(252, 198, 141);
	border-radius: 15px;
 	width:55%; 

	}
	#title{
	font-size: 30px;
	text-align:right;
	background-color: rgb(252, 198, 141,0.8);
	text-align: center;
	border: 0px solid rgb(252, 198, 141);
	}
	.btn{
	float:right;
	margin-left:10px;
	 }

	
</style>
<head>
<meta charset="UTF-8">
<title>My Order</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<!-----------------------------回到頂端按鈕------------------------------------->		
<div style="position: fixed; top: 87%; right:-10%; z-index: 999;">
<a class="gototop close" href="#" title="回頂端" alt="回頂端" >
<img id="topimg" style="height:10%;width:10%;opacity:0.4" src="img\cart\totop.png">
</a></div>
<!-----------------------------回到頂端按鈕------------------------------------->	

<h3 style="font-family:微軟正黑體"><a href="<c:url value='//allmyorder' />" >回上頁</a></h3>

	<table id="answer" class="table table-bordered">
		<tr id="title" >
			<td>${memberid.name}的訂單</td>
		</tr>
		<tr>
			<th style="text-align:center">訂單資訊</th>
		</tr>
		<tr>
			<td>1.會員ID：&nbsp;***${memberID}***</td>
		</tr>
		<tr>
			<td>2.訂單編號：${OrderNo}</td>
		</tr>
		<tr>
			 <td>3.訂單狀態：<span style="color:green">訂單成立</span></td>
		</tr>
		<tr>	 
		     <th style="text-align:center"><br>商品清單</th>
		</tr>
		<tr>
		     <td>1.包廂： ${roomproduct.roomName}&nbsp;&nbsp;${roomproduct.roomSize}&nbsp;&nbsp;NT.${roomproduct.roomPrice}</td>
		</tr>
		<tr>
			 <td>2.電影：${movieproduct.movieName}&nbsp;&nbsp;${movieproduct.movieEName} </td>
		</tr>
		<tr>
			 <td>3.電影分級：${movieproduct.movieRated} &nbsp;&nbsp;&nbsp;&nbsp;電影長度：${movieproduct.movieLength} </td>
		</tr>
		<tr>
			 <td>4.預約日期：${OrderDate}</td>
		</tr>
		<tr>
			 <td>5.預約時間：${OrderDateStart}&nbsp;-&nbsp;${OrderDateEnd}</td>
		</tr>
		<tr>
			 <td>6.餐點：</td>
		</tr>
		<c:forEach var='food' items='${OrderFood}'>
				<tr>
 				<td>&nbsp;&nbsp;&nbsp;&nbsp;${food.foodTitle} 
 				<span style="text-align:right">&nbsp;&nbsp;&nbsp;&nbsp; 
					NT.${food.foodPrice}&nbsp;&nbsp;X&nbsp;&nbsp;${food.qty}&nbsp;&nbsp;=&nbsp;&nbsp;NT.${food.foodPrice*food.qty}</span></td>
 				</tr> 
			</c:forEach>	
		
		<tr>
		    <td style="text-align:right">餐點金額：NT.${Ordertotal-roomproduct.roomPrice} </td> 
		</tr>
		<tr>
		    <td style="text-align:right">包廂金額：NT.${roomproduct.roomPrice}</td> 
		</tr>
		<tr>
		    <td style="text-align:right">總金額：NT.${Ordertotal} </td> 
		</tr>
		<tr>
			<td><br></td>
		</tr>
		<tr>	
     		<th style="text-align:center">備 註</th>
		</tr>
		<tr>
			<td>為維護預約消費者權益，預約時間未到者，視同取消預約。<br></td>
		</tr>
		<tr>
			<td>後續退費相關請洽詢門市人員。<br></td>
		</tr>
		<tr>
			<td><br></td>
		</tr>
		<tr>
		<td><span text-align:right;>
		<span><Input type='submit' class="btn btn-default btn-lg" onclick="self.location.href='mailto:admin@mobiled.tw'" value='聯絡我們'></span>	
		<span><Input type='submit' class="btn btn-danger btn-lg cancel"  value='取消訂單' >	</span>
		</span></td>
		</tr>
	</table>
<script>
<!-----------------------------回到頂端按鈕------------------------->			
$(window).scroll(function(event){
  var scroll = $(window).scrollTop();
    if (scroll >= 100) {
       $(".gototop").removeClass("close");
    }else {
    	$(".gototop").addClass("close");
    }
});	
<!-----------------------------回到頂端按鈕------------------------->	

$(".cancel").click(function(){
alert("如欲取消訂單，最晚請於預約前一天來電取消\n聯絡電話：02-6631-6666");
});

</script>
</body>
</html>