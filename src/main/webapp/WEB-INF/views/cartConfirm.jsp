<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
	#answer{
	margin-top: 50px;
	margin-left: 50px;
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
	}
	
</style>
<head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<table id=answer class="table table-bordered">
		<tr>
			<td id="title">您的訂單</td>
		</tr>
<!-- 		<tr> -->
<%-- 			<td>1.訂單編號： ${OrderCart.orderNo}</td> --%>
<!-- 		</tr> -->
		<tr>
			<td>1.會員ID :   ***${OrderCart.memberId}***</td>
		</tr>
		<tr>
		    <td>2.包廂名稱：${OrderCart.room.roomName}&nbsp;&nbsp;&nbsp;&nbsp;NT. ${OrderCart.room.roomPrice}</td>
		</tr>
		<tr>
			 <td>3.電影名稱：${OrderCart.movie.movieName}&nbsp;&nbsp;${OrderCart.movie.movieEName}</td>
		</tr>
		<tr>	 
		     <td>4.電影長度：${OrderCart.movie.movieLength}&nbsp;&nbsp;&nbsp;&nbsp;電影分級：${OrderCart.movie.movieRated} </td>
		</tr>
		<tr>
		     <td>5.電影分類：${OrderCart.movie.movieGenre1}</td>
		</tr>
		<tr>
			 <td>6.日期：${OrderCart.orderDate}&nbsp;&nbsp;開始時間：${OrderCart.orderDateStart}&nbsp;&nbsp;結束時間：${OrderCart.orderDateEnd} </td>
		</tr>
		<tr>
			 <td>7.餐點：</td>
		</tr>
		<c:set var="row_total" value="0"></c:set>
			<c:forEach var='food' items='${OrderCart.orderFood}'>
				<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;${food.foodTitle}
				<span style="text-align:right">&nbsp;&nbsp;&nbsp;&nbsp;
					NT.${food.foodPrice}&nbsp;&nbsp;X&nbsp;&nbsp;${food.qty}&nbsp;&nbsp;=&nbsp;&nbsp;NT.${food.foodPrice*food.qty}</span></td>
<%-- 				 <c:set var="row_total" value="${row_total + (food.foodPrice*food.qty) }" /> --%>
				</tr>
			</c:forEach>		
		<tr>
			
     		 <td style="text-align:center">總金額：NT. ${OrderCart.totalAmount}</td> 
		</tr>
		<tr>
		<td style="text-align:center">
<%-- 		<FORM style="display:inline-block" action="<c:url value='/insert.do' />" method="GET"> --%>
		<FORM style="display:inline-block" action="<c:url value='/opay' />" method="GET">
			<Input type='hidden' name='finalTotal' value='${OrderCart.totalAmount}'>
			<Input type='hidden' name='orderDate' value='${OrderCart.orderDate}'>
			<Input type='hidden' name='timeStart' value='${OrderCart.orderDateStart}'>
			<Input type='hidden' name='timeEnd' value='${OrderCart.orderDateEnd}'>
			<Input type='hidden' name='orderNum' value='${OrderCart.orderNo}'>

			
			<Input type='submit' class="btn btn-danger"  value='確認'>
		</FORM>
		<FORM style="display:inline-block" action="<c:url value='/reset.do'/>"  method="GET">
			<Input type="submit" class="btn btn-default" id="re" value='回上一步'>
		</FORM>
<%-- 		<FORM style="display:inline-block" action="<c:url value='/opay' />" method="GET"> --%>
<!-- 			<Input type='submit' class="btn btn-default"  value='綠界'> -->
<!-- 		</FORM> -->
		</td>
		</tr>
		
		
	</table>
</div>
</body>
</html>