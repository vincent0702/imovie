<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="zh-TW">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Accordion - No auto height</title>
<!-- 以下日期選取 -->
  <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<link
	href="https://fonts.googleapis.com/css2?family=Nunito:ital@1&display=swap"
	rel="stylesheet">
<!-- 以下font-style -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Serif+TC:wght@600&display=swap"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@700&display=swap" rel="stylesheet">
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap" rel="stylesheet">

<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+TC:wght@700&display=swap" rel="stylesheet">

 <script> 
 
	$(function() {
		$("#tabs").tabs();
	});
</script> 
<style>
* {
	padding: 0px;
	margin: 0px;
}
 .ui-spinner-input { 
 	width: 70px; 
 	border: 1px solid black; 
 	border-radius: 10%; 
 } 

/* --------------------Big Block-----------------------------     */
#Header {
	height: 120px;
	background-color: gray;
}

.titletag {
	font-family: 'Noto Serif TC', serif;
}

.bigcontainer {
	display: inline-flex;
	margin: 15px;
}

.firstdiv {
	width: 80%;
	float: left;
	/* border: 1px solid 	#E0E0E0; */
	margin-top: 20px;
	margin-left: 70px;
	margin-right: 40px;
}

.seconddiv {
	margin: 20px 0px 40px 10px;
	padding: 0px;
	width: 25%;
	height: 600px;
	overflow: auto;
	border: 3px solid #669dcc;
	border-radius: 20px;
}

.test {
	justify-content: space-around;
	justify-content: center;
	align-items: center;
}
/* --------------------Room -----------------------------     */
.tagRoomContent {
	display: flex;
	/* padding: 50px; */
	/* margin: 100px; */
	flex-wrap: wrap;
	justify-content: center;
	background-color: white;
}

.roomPer { /*   每個包廂方塊 */
	display: flex;
	margin: 10px 15px;
	text-align: center;
	justify-content: space-around;
	background-color: #FFFAF4;
	padding: 10px;
	border-radius: 15px;
	border: 1px solid #E0E0E0;
}

.roomImg {
	height: 270px;
	width: 380px;
	border-radius: 15px;
}

.roomlist {
	font-size: 15px;
}

.roomprice {
	font-family: 'Nunito', sans-serif;
	font-weight: 600;
	color: #990000;
}
/* --------------------movie-----------------------------     */
.movieimg {
	height: 200px;
	width: 140px;
	margin: 15px;
}

.movsp { /*  每部電影方塊       */
	margin: 10px;
	border: 0px solid #000;;
	background-color: ghostwhite;
	display: inline-block;
	max-width: 350px;
	width: 240px;
	justify-content: space-around;
}

.movsp2 { /*  撐版面用的電影方塊       */
	margin: 10px;
    visibility:hidden;
	display: inline-block;
	max-width: 350px;
	width: 240px;
	justify-content: space-around;
}

.movsp p1 { /*   電影名稱       */
	text-align: center;
	font-family: 微軟正黑體;
	font-weight: bolder;
	padding-left: 10px;
}

.movsp p4 { /*   電影英文名稱       */
	text-align: center;
	font-family: 微軟正黑體;
	font-weight: bolder;
	padding-left: 10px;
}

.movsp p2 { /*  電影分級       */
	text-align: center;
	font-size: 10px;
	padding-left: 10px;
}

.movsp p3 { /*   電影長度       */
	text-align: center;
	font-size: 14px;
	padding-left: 10px;
}

.tagContext {
	display: flex;
	justify-content: space-around;
	flex-wrap: wrap;
}
/* -------------------time--------------------------------     */

.date_time {            /*  整個日期時間區塊  */
    height:100%;
	width: 100%;
	margin-top:40px;
	margin: 20px;
	text-align: center;
	display: inline-table;
}
.times{                         /*  下拉選單  */
    border: 0; 					/*  取消邊框  */
    width: 200px;
    height: 50px;
    background-color: white;			/*  背景可以改為一張圖片  */
    color: black;
    font-size: 30px;
    webkit-appearance: none;			/*  取消小三角的顯示*/
    text-indent: 0.01px;             		/*  僅僅為了美觀*/
    background-repeat: no-repeat;		
    margin: 0 40px;
    padding-left: 20px;
}
.ampm{                          /*  時間方塊  */

    display: flex;
	margin: 10px 15px;
	text-align: center;
	justify-content: space-around;
	background-color: #FFFAF4;
	padding: 10px;
	border-radius: 15px;
	border: 1px solid #E0E0E0;
}

.miss{                          /*  隱藏  */
  display: none;
}
.timetext{
font-family: 'Nunito', sans-serif;
font-weight: 600;

}
#warning{
color:red;
margin-left: 15px;
}
#timeOkk{
color:blue;
margin-left: 17px;
}

/* --------------------food-----------------------------     */
.foodtype { /* 食物分類 */
	font-family: 微軟正黑體;
	font-weight: 800;
	font-size: 30px;
	background-color: rgb(252, 169, 146 ,0.8);
}

.foodPer { /* 每個食物方塊 */
	margin: 20px 10px;
	height: 290px;
	width: 240px;
	text-align: center;
	justify-content: space-around;
	box-shadow: 0px 0px 80px #E0E0E0;
	padding: 10px;
	border: 0px solid #000;
	display: inline-block;
}

.foodimg {
	height: 180px;
	width: 220px;
}

#foodFooter {
	background-color: darkorchid;
	height: 100px;
}

.fontBold {
	/* font-family: 標楷體; */
	font-weight: 900;
}

.form-control-s {
	height: 30px;
	width: 45px;
	border-radius: 8px;
}

.foodprice {
	font-family: 'Nunito', sans-serif;
	font-weight: 600;
	color: #990000;
}

.tabs-3,tabs-4 {
	width: 100%;
	margin-left: 15px;
	
}


/* --------------------cart----------------------------     */
#roomchoose, #roommoney, #moviename, #movieEname, #movieLength,#checktime,#checkday,#total,#cartendtime
	{
	margin-left: 15px;
	font-size: 20px; 
	font-weight: 500;
}

.foodtip { /*   食物新增項目       */
	margin-left: 15px;
	margin-bottom: 15px;
	font-size: 20px;
}

#totalprice,#total { /*   購物車合計       */
 	font-family: 微軟正黑體; 
 	font-size: 20px; 
 	font-weight: bolder; 
	margin: 20px;
}

.panel-title { /*   購物車抬頭       */
    font-family: 'Noto Sans TC', sans-serif;
	padding: 0px;
	margin: 0px;
	background-color: #347AB7;
	text-align: center;
	color: #FCFCFC;
}

.secondPerHeader { /*   包廂+電影+食物抬頭       */
	font-family: 'Noto Sans TC', sans-serif ;
	color: #3277B3;
	margin: 10px;
}
/* -------------------按鈕----------------------------     */
#sumit { /*   送出&重新選擇       */
	text-align: center;
	margin: 20px;
	margin-top:30px;
	margin-bottom: 30px;

}
.btn{
margin-bottom: 20px;
}

.gototop.close {
 display:none
}

/* -------------------TEST----------------------------     */
.testAnime {
	-webkit-animation: slide-in-fwd-center 1.6s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
	        animation: slide-in-fwd-center 1.6s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
}

/* ----------------------------------------------
 * Generated by Animista on 2020-7-22 12:58:48
 * Licensed under FreeBSD License.
 * See http://animista.net/license for more info. 
 * w: http://animista.net, t: @cssanimista
 * ---------------------------------------------- */

/**
 * ----------------------------------------
 * animation slit-in-vertical
 * ----------------------------------------
 */
@-webkit-keyframes slide-in-fwd-center {
  0% {
    -webkit-transform: translateZ(-1400px);
            transform: translateZ(-1400px);
    opacity: 0;
  }
  100% {
    -webkit-transform: translateZ(0);
            transform: translateZ(0);
    opacity: 1;
  }
}
@keyframes slide-in-fwd-center {
  0% {
    -webkit-transform: translateZ(-1400px);
            transform: translateZ(-1400px);
    opacity: 0;
  }
  100% {
    -webkit-transform: translateZ(0);
            transform: translateZ(0);
    opacity: 1;
  }
}



.font07232{
	font-family: 'Noto Sans TC', sans-serif;
}

.font07230506{
	font-family: 'Noto Serif TC', serif;
}


</style>

</head>
 
<body>
	<div id="Header">
		<a href="<c:url value='/' />" ><h1 style="color:white;">Imovie</h1></a>
	</div>
	
<!-----------------------------回到頂端按鈕------------------------------------->		
<div style="position: fixed; top: 90%; right: 0%; z-index: 999;">
<a class="gototop close" href="#" title="回頂端" alt="回頂端" >
<img id="topimg" style="height:10%;width:10%;opacity:0.5" src="img\cart\totop.png">
</a></div>
<!-----------------------------回到頂端按鈕------------------------------------->		

	<div class="bigcontainer">

		<div class="firstdiv" id="tabs">
			<div>
				<ul style="background-color: white;">
					<li style="border-radius: 5px;"><a class="titletag" id="tag1"
						href="#tabs-1">包廂</a></li>
					<li style="border-radius: 5px;"><a class="titletag" id="tag2"
						href="#tabs-2">電影</a></li>
					<li style="border-radius: 5px;"><a class="titletag" id="tag4"
						href="#tabs-4">時間</a></li>	
					<li style="border-radius: 5px;"><a class="titletag" id="tag3"
						href="#tabs-3">餐點</a></li>
				</ul>
			</div>
			<!-------------------------------room ---------------------------------------->
			<div id="tabs-1">
				<div class="tagRoomContent" id="tagRoom">

					<c:forEach var='product2' items='${room}'>
						<div class="roomPer" id="cartr${product2.roomId}">
							<div>
								<img class="roomImg"
									src="<c:url value='/getPicture2/${product2.roomId}' />" /><br>
								<h3>${product2.roomName}</h3>
								<br>
								<h4 class="roomprice" style="color: #990000">NT.${product2.roomPrice}</h4>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-------------------------------movie ---------------------------------------->
			<div id="tabs-2" class="tagContext">
			<br>
		<div style="font-size:20px" class="font07232">
		電影類型: <select style="border-radius:10px" id='publish'>
			<option value='全部'>全部</option>
			<c:forEach var='category' items='${categoryList}'>
				<option value='${category.mGenreName}'>${category.mGenreName}</option>
			</c:forEach>
			</select>
		</div>
		<div style="font-size:20px;margin-top:5px;" class="font07232">
		查詢 : <input id='fuzzySearch' style="border-radius:5px" value="" type="text" autocomplete="off">
		</div>
			<br><!-- style='padding:0px;margin:0px' -->
			<div class='111' id='forTypeMovie'>
				<c:forEach var='product1' items='${movie}'>
					<div class="movsp hiTime" id="${product1.movieId}">
						<img class=movieimg
							src="<c:url value='/getPicture1/${product1.movieId}' />" />
							<div>
						<c:choose>	
						<c:when test="${product1.movieRated== '普遍級'}">
						<p2 class="rate" style="background-color: #01B468">${product1.movieRated}</p2> 
						</c:when>
						<c:when test="${product1.movieRated== '保護級6+'}">
						<p2 class="rate" style="background-color: #66B3FF">${product1.movieRated}</p2>
						</c:when>
						<c:when test="${product1.movieRated== '輔12級'}">
						<p2 class="rate" style="background-color: yellow">${product1.movieRated}</p2>
						</c:when>
						<c:when test="${product1.movieRated== '輔15級'}">
						<p2 class="rate" style="background-color: orange">${product1.movieRated}</p2>
						</c:when>
						<c:otherwise>
						<p2 class="rate" style="background-color: #FF5151">${product1.movieRated}</p2>
						</c:otherwise>
						</c:choose>
						</div>
						<div>
							<p1>${product1.movieName}</p1>
						</div>
						<div>
						<c:choose>
						<c:when test="${fn:length(product1.movieEName)>20}" >
							<p4 style="font-size: 10px">${product1.movieEName}</p4>
						</c:when>
						<c:otherwise>
							<p4>${product1.movieEName}</p4>
						</c:otherwise>
						</c:choose>
						</div>
						<p3>${product1.movieLength}</p3>
					</div>
				</c:forEach>
				</div>
			</div>
			<!-------------------------------time ---------------------------------------->
			<div id="tabs-4" class="tagContext">
			<div class="font07232 date_time">  
                       <p style="font-weight: bolder;font-size: 25px">選擇日期： <input type="text" name="fname" id="datepicker" class="hiTime" value="" autocomplete="off"></p>
                       <p style="font-size:20px">預約日期限制為三天以內</p>
                        <p style="font-size:20px">可預約時間為每三十分鐘，預約時間如在三十分鐘內不開放預約</p><br>
                       <span style="font-size:20px">目前時間：</span > <span  id="now" style="font-size:20px"></span ><br>
                       <span style="font-size:20px">目前最近可預約時間為：</span > <span  id="booknow" style="font-size:20px"></span ><br>
                       <span  id="lastendtime" style="font-size:20px"></span ><br>
                      <div class="tagRoomContent" id="tagRoom">
						<div class="ampm hiTime">
							<div>
							  <img  class="roomImg" src="img/cart\morning.jpg"/><br>
							  							
								<h3 class="timetext">上午</h3>
								<br>
						 <select name="Yourtime" id="morning" class="times">
						    <option>09:00</option>
							<option>09:30</option>
                            <option>10:00</option>
                            <option>10:30</option>
                            <option>11:00</option>
                            <option>11:30</option>
                            <option>12:00</option>
                         </select>
							</div>
						</div>
						<div class="ampm hiTime">
							<div>
								 <img  class="roomImg" src="img\cart\afternoon.jpg"/><br>
								<h3 class="timetext">下午</h3>
								<br>
						  <select name="Yourtime" id="afternoon" class="times">
                                <option>12:30</option>
                                <option>13:00</option>                            　	
                                <option>13:30</option>
                                <option>14:00</option>
                                <option>14:30</option>
                                <option>15:00</option>
                                <option>15:30</option>
                                <option>16:00</option>
                                <option>16:30</option>
                                <option>17:00</option>
                                <option>17:30</option>
                         </select>
							</div>
						</div>
						<div class="ampm hiTime">
							<div>
								 <img  class="roomImg" src="img\cart\night.jpg"/><br>
								<h3 class="timetext">晚上</h3>
								<br>
						      <select name="Yourtime" id="night "class="times">
                                <option>18:00</option>
                                <option>18:30</option>                            　	
                                <option>19:00</option>
                                <option>19:30</option>
                                <option>20:30</option>
                                <option>21:00</option>
                             </select> 
							</div>
						</div>
				     </div>
                       
                       <br> 
                 </div>
			
			</div>
			<!-------------------------------food ---------------------------------------->
			<div id="tabs-3" class="tagContext">
				<div class="foodtype">主食區</div>
				<c:forEach var='food' items='${main}'>

					<div class="foodPer">
						<div>
							<img class="foodimg"
								src="<c:url value='/getFoodImg/${food.foodId}' />" />
						</div>
						<div class="foodname">
							<div class="fontBold">${food.foodName}</div>
							<div class="foodprice" >NT ${food.foodPrice}</div>
<%-- 				<FORM  action="<c:url value='addFood' />" method="POST"> --%>
							<select name='qty' class="form-control-s hiAjax" id="cartf${food.foodId}">
								<option selected="selected" value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
							</select>
			                <Input type='hidden' name='foodPrice' value='${food.foodPrice}'>
							<Input type='hidden' name='foodId' value='${food.foodId}'>
<!-- 							<button type="button" class="btn btn-secondary" class='hiAjax' value='加入'></button> -->
<!-- 							<Input style="border-radius: 15x;" class='hiAjax' type='button' value='加入'> -->
<!-- 						</FORM> -->
						</div>
					</div>
				</c:forEach>

				<div class="foodtype">點心區</div>
				

				<c:forEach var='food' items='${dessert}'>

					<div class="foodPer">
						<div>
							<img class="foodimg"
								src="<c:url value='/getFoodImg/${food.foodId}' />" />
						</div>
						<div class="foodname">
							<div class="fontBold">${food.foodName}</div>
							<div class="foodprice">NT
								${food.foodPrice}</div>
<%-- 								<FORM  action="<c:url value='addFood' />" method="POST"> --%>
							<select name='qty' class="form-control-s hiAjax" id="cartf${food.foodId}">
								<option selected="selected" value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
							</select>
			                <Input type='hidden' name='foodPrice' value='${food.foodPrice}'>
							<Input type='hidden' name='foodId' value='${food.foodId}'>
<!-- 							<button type="button" class="btn btn-secondary" class='hiAjax' value='加入'></button> -->
<!-- 							<Input style="border-radius: 15x;" class='hiAjax' type='button' value='加入'> -->
<!-- 						</FORM> -->
						</div>
					</div>
				</c:forEach>
				

				<div class="foodtype">飲料區</div>
				
				<c:forEach var='food' items='${drink}'>

					<div class="foodPer">
						<div>
							<img class="foodimg"
								src="<c:url value='/getFoodImg/${food.foodId}' />" />
						</div>
						<div class="foodname">
							<div class="fontBold">${food.foodName}</div>
							<div class="foodprice">NT
								${food.foodPrice}</div>
<%-- 								<FORM  action="<c:url value='addFood' />" method="POST"> --%>
							<select name='qty' class="form-control-s hiAjax" id="cartf${food.foodId}">
								<option selected="selected" value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
							</select>
			                <Input type='hidden' name='foodPrice' value='${food.foodPrice}'>
							<Input type='hidden' name='foodId' value='${food.foodId}'>
<!-- 							<button type="button" class="btn btn-secondary" class='hiAjax' value='加入'></button> -->
<!-- 							<Input style="border-radius: 15x;" class='hiAjax' type='button' value='加入'> -->
<!-- 						</FORM> -->
						</div>
					</div>
				</c:forEach>
				
				<div class="foodtype">套餐</div>
				
				<c:forEach var='food' items='${packa}'>

					<div class="foodPer">
						<div>
							<img class="foodimg"
								src="<c:url value='/getFoodImg/${food.foodId}' />" />
						</div>
						<div class="foodname">
							<div class="fontBold">${food.foodName}</div>
							<div class="foodprice">NT.${food.foodPrice}</div>
<%-- 							<FORM  action="<c:url value='addFood' />" method="POST"> --%>
							<select name='qty' class="form-control-s hiAjax" id="cartf${food.foodId}">
								<option selected="selected" value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
							</select>
			                <Input type='hidden' name='foodPrice' value='${food.foodPrice}'>
							<Input type='hidden' name='foodId' value='${food.foodId}'>
<!-- 							<button type="button" class="btn btn-secondary" class='hiAjax' value='加入'></button> -->
<!-- 							<Input style="border-radius: 15x;" class='hiAjax' type='button' value='加入'> -->
<!-- 						</FORM> -->
						</div>
					</div>
				</c:forEach>
				
				<!-------------------------------隱藏參數-------------------------------------->
					  
			    	<Input id='hiddRoomPrice' type='hidden' name='roomPrice' value='0'>	 	                
			         <Input id='hiddMovieLen' type='hidden' name='movieLen' value='0'>                  

			</div>
		</div>

		<!------------------------------------------購物車------------------------------------->

		<table  class="seconddiv inner font07230506" id="idtable">
			<tr>
				<th class="panel-title" style="padding: 5px;"><h3>您的購物車</h3></th>
			</tr>
			<tr>
				<th class="panel-title" style="padding: 5px;"><h3>Shopping Cart</h3></th>
			</tr>

			<tr>
				<td>
					<h3 style='font-weight:600' class="secondPerHeader">包廂</h3>
				</td>
			</tr>
			<tr>
				<td>
					<span id="roomchoose"></span><span id="roommoney"></span>
				</td>
			</tr>
			<tr>
				<td>
					
					<hr>
				</td>
			</tr>

			<tr>
				<td>
					<h3 style='font-weight:600' class="secondPerHeader">電影</h3>
				</td>
			</tr>
			<tr>
				<td>
					<h5 id="moviename"></h5>
				</td>
			</tr>
			<tr>
				<td>
					<h5 id="movieEname"></h5>
				</td>
			</tr>
			<tr>
				<td>
					<h5 id="movieLength"></h5>
					<hr>
				</td>
			</tr>
			<tr>
				<td>
					<h3 style='font-weight:600' class="secondPerHeader">時間</h3>
				</td>
			</tr>
			<tr>
				<td>
					<h5 id="checkday"></h3>
				</td>
			</tr>
			<tr>
				<td>
					<span id="checktime"></span><span id="cartendtime"></span>
					<div id='warning'></div> <div id="timeOkk"></div>
					<hr>
				</td>
			</tr>
			<tr>
				<td>
					<h3 style='font-weight:600' class="secondPerHeader">餐點</h3>
				</td>
			</tr>
			<tr>
				<td>
				<div id='test226'></div>
				<c:forEach var='food' items='${allFood}'>
					<div id="cartff${food.foodId}" style="display:none"></div>
				</c:forEach>
					
				</td>				
			</tr>
			<tr>
				<td><hr>
					<span style="padding: 15px" id='totalprice'>合計：  NT.</span><span id="total">0</span><br>
				</td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr id="sumit">
				<td>
					<FORM style="display:inline-block" action="<c:url value='confirm' />" method="POST">
						<Input id='hiddRoodId' type='hidden' name='roodId' value='0'>
			            <Input id='hiddMovieId' type='hidden' name='movieId' value='0'>
			            <Input id='hiddTotal' type='hidden' name='total' value='0'>
			            <Input id='hiddTimeStart' type='hidden' name='timeStart' value='0'>
			            <Input id='hiddTimeEnd' type='hidden' name='timeEnd' value='0'>  
			            <Input id='hiddTimeDate' type='hidden' name='TimeDate' value='0'>  
						<Input  id='hi' type='submit' class="btn btn-secondary" name='send' value='確認'>		
					</FORM>
				<FORM  style="display:inline-block" action="<c:url value='/reset.do' />" method="GET">
					<Input type="submit" class="btn btn-secondary" id="reset" value='重新選擇'>
				</FORM>
					<Input type="hidden"   id="oldPrice" value='0'>
					<Input type="hidden"   id="checkForDB" value='0'>
				</td>
			</tr>
			<tr>
				<td></td>
			</tr>

		</table>
        <br>

		<!-------------------------------------------Script--------------------------------------->

		<script>
		
		
		  
		
		
	 <!------------------------ ------- 包廂放入 購物車  ----------------------------------->   
		$(".roomPer").click(function() {

			let text = $(this).find("h3").text();
			document.getElementById("roomchoose").innerHTML = text;

			let money = $(this).find("h4").text();
			document.getElementById("roommoney").innerHTML = money;
			
			let roomP = money.substr(3);
	        $("#hiddRoomPrice").val(roomP);
	        console.log("RoomPrice="+$("#hiddRoomPrice").val()); //console顯示用
	    	let val = $(this).attr("id").substr(5);
	        $("#hiddRoodId").val(val);
	        console.log("RoomId="+$("#hiddRoodId").val());  //console顯示用
	        calltimecheck();
		
		 <!-------- --- -----計算總和-------- ---- ----->	
		 	
		 
		 	var totalHi = document.getElementById("total");
	        let count = 0;
	        let oldRoomPrice = parseInt($("#oldPrice").val());
	        let newRoomPrice = parseInt(roomP);
	        count = newRoomPrice - oldRoomPrice;
	        console.log(count);
	        let newTotal = parseInt($("#total").text()) + count;
	        totalHi.innerHTML = newTotal; 
	        
	        $("#oldPrice").val(roomP);  //確認加總完更新為 oleRoomPrice
	        $("#hiddTotal").val(newTotal);
// 			 total9 = parseInt($("#hiddRoomPrice").val());
// 		     $("#hiddTotal").val(total9);
//              console.log("hiddTotal="+$("#hiddTotal").val());
		
// 		     document.getElementById("total").innerHTML = $("#hiddTotal").val();

		})

 <!-- ----- ------------- --- ------ 電影放入購物車    ------- ------------------------------>
			
		$(".movsp").click(function() {

				let Length = $(this).find("p3").text();
				document.getElementById("moviename").innerHTML = $(this).find("p1").text();
				document.getElementById("movieEname").innerHTML = $(this).find("p4").text();
				document.getElementById("movieLength").innerHTML = Length;
				
				let val = $(this).attr("id");
				let len = Length.substring(0,Length.length-1);
				$("#hiddMovieId").val(val);//放入電影id
		        $("#hiddMovieLen").val(len);//放入電影長度
		        console.log("MovieId="+$("#hiddMovieId").val());  //console顯示用
		        console.log("MovieLen="+$("#hiddMovieLen").val());  //console顯示用
		        if($("#hiddTimeStart").val()!=0)  calculation();calltimecheck();//若有先點選時間，則計算結束時間	
		        
			})
			
 <!------------------------------ -時間放入購物車--------- -------------------------->
			
		$("#datepicker").change(function() {
				let day1 = $(this).val();
				console.log(day1);
				document.getElementById("checkday").innerHTML = day1;
				$("#hiddTimeDate").val(day1); 
				console.log("TimeDate="+$("#hiddTimeDate").val());  //console顯示用	
				calltimecheck();
			})
			
			$(".ampm").click(function() {
			
				let day2 = $(this).find("div h3").text();
				let time = $(this).find("div select").val();
				console.log(day2+time);
				document.getElementById("checktime").innerHTML =day2+" "+time;
				$("#hiddTimeStart").val(time);//放入預約時間
				console.log("TimeStart="+$("#hiddTimeStart").val());  //console顯示用				
							
			})
			
 <!-------------------------------食物放入購物車----------------------------------->
			
		$("#tabs-3 .form-control-s")
					.change(
							function() {
								var num = $(this).val();
								let foodname = $(this).siblings(".fontBold")
										.text();
								let price = $(this).siblings(".foodprice")
										.text();
								let foodtotal = parseInt(num)
										* parseInt(price.slice(-2));

					 <!----------------計算總和----------------->					 				 
// 								 total9 += foodtotal;
// 							     $("#hiddTotal").val(total9);
// 					             console.log("hiddTotal="+$("#hiddTotal").val());
//   				 		    	 document.getElementById("total").innerHTML = $("#hiddTotal").val();

//					 			$("#ampm").change(function() {
//					 				var k = $(this).val();
//					 				$(this).siblings().not(mydate).not().removeClass("times");
					 			});
	
			
 <!-----------------------------區塊hover效果------------------------------------->

			$(".movsp").hover(function() {
				$(this).css("background", "#dce8f2");
			}, function() {
				$(this).css("background", "white");
			})
			$(".foodPer").hover(function() {
				$(this).css("background", "#dce8f2");
			}, function() {
				$(this).css("background", "white");
			})
			$(".roomPer").hover(function() {
				$(this).css("background", "#dce8f2");
			}, function() {
				$(this).css("background", "white");
			})
			$(".ampm").hover(function() {
				$(this).css("background", "rgb(252, 226, 146, 0.8)");
			}, function() {
				$(this).css("background", "white");
			})
			
<!-----------------------------區塊click效果------------------------------------->
			
			$(".movsp").click(function() {
				$(this).css("background", "#B3D9D9");
			})
			$(".roomPer").click(function() {
				$(this).css("background", "#B3D9D9");
			})
			$(".ampm").click(function() {
				
// 				if($("#hiddTimeDate").val()==0){
// 					alert("請先選擇日期");
// 				}else{
				
			
				$(this).css("background", "#edbf37");
				$(this).find("select").removeClass("miss");
				$(this).siblings().find("select").addClass("miss");
								
				
			
  
	<!------------------判定允許預約的時間------------------------------>	
			
			var today=new Date();
			var todaymouth=today.getMonth()+1;
			var todayday=today.getDate();
			var todayhour=parseInt(today.getHours());
			var todaymin=parseInt(today.getMinutes());				
			document.getElementById("now").innerHTML =todaymouth+"月"+todayday+"日"+todayhour+"點"+todaymin+"分";
		    
			if(todayhour<=8  || todayhour>21){
				document.getElementById("booknow").innerHTML="目前非營業時間，最早可預約時間為上午09點00分";
			}else{
				if (todaymin==0){
				document.getElementById("booknow").innerHTML=todayhour+"點30分";
				}
				else if( 1<todaymin && todaymin<=30 ){
		        document.getElementById("booknow").innerHTML=(todayhour+1)+"點00分";
				}
				else if( 31<todaymin && todaymin<59 ){
		        document.getElementById("booknow").innerHTML=(todayhour+1)+"點30分";
				}
				else{
					document.getElementById("booknow").innerHTML="目前無法預約";
				}
			}
			calculation();
// 			}
			})
			
			
			//由 開始預約時間+電影長度 算出結束時間
			function calculation(){
			var v = parseInt($("#hiddMovieLen").val());
			var hour1 = parseInt(($("#hiddTimeStart").val()).substr(0,2));
			var min = parseInt(($("#hiddTimeStart").val()).substr(3));
			var hour2 = parseInt(Math.floor(v/60));
			var cell = parseInt(v%60);
			if((min+cell)>60 ){  //超過60分需換算
				var newmin=('0'+((min+cell)-60)).substr(-2);   //補0後取兩位數
				var newhour=('0'+((hour1+hour2)+1)).substr(-2);
				var timeend = newhour+":"+newmin;
			}else{
				var timeend = ('0'+(hour1+hour2)).substr(-2)+":"+('0'+(min+cell)).substr(-2);
			}
	        console.log("開始時間 小時="+hour1+" 電影時間 小時="+hour2+" 開始時間 分="+min+"  電影時間 分="+cell);
	        console.log("結束時間"+timeend);
			$("#hiddTimeEnd").val(timeend);
			
			document.getElementById("lastendtime").innerHTML="您選擇的時間："+$("#hiddTimeStart").val()+"  電影長度："+v+"分"+"  結束時間："+$("#hiddTimeEnd").val();
			document.getElementById("cartendtime").innerHTML=" 結束時間："+$("#hiddTimeEnd").val();
			
 			}
			
<!--------------------------清空購物車---------------------------------------->
			
			$("#reset").click(function() {
	
	  <!---------------清空隱藏參數----------------->
				
	 		 	$("#hiddFoodId").val(0);
				$("#hiddFoodPrice").val(0);
				$("#hiddRoomPrice").val(0);
				$("#hiddRoodId").val(0);
				$("#hiddMovieId").val(0);
				$("#hiddTotal").val(0);
				
			})

<!-----------------------------限制只能點選之後三天日期------------------------------------->
			
			$(function() {
			 $( "#datepicker" ).datepicker({ minDate: -0, maxDate: "+3D" });
			 });

<!--------------------------滑鼠移入確認按鈕，需確認包廂&電影&時間後才可送出------------------------->

$("#hi").mouseover(function() {
	  //判斷是否有值
	  if(
	  $("#hiddRoodId").val() !=0 && $("#hiddRoomPrice").val()!=0 && $("#hiddTimeDate").val() !=0 && $("#hiddTimeStart").val() !=0 &&  $("#hiddTimeEnd").val() !=0 
	  && $("#hiddMovieId").val() !=0 &&  $("#hiddMovieLen").val() !=0 && $("#hiddTotal").val()!=0  && $("#checkForDB").val()!=0 
	  ){					 
	   $("#hi").addClass("btn-primary");//藍色可送出 ****
	   $("#hi").removeClass("btn-secondary");  
	 
	   } else{ 
	   $("#hi").addClass("btn-secondary");//灰色不可送出
	   $("#hi").removeClass("btn-primary");  
	       alert("請確認已選擇包廂、電影及日期時間");
	  }	
	  	  
<!--------------限制不可選擇過去時間--------------------->	 
	  	
	  	//現在時間  
	  	var today=new Date();
		var todayday=today.getDate();  
		//選擇的日期
		var day1 = $("#datepicker").val();
		var day2 = day1.substr(3,2);//日期
		//最早可預約時間
		var hour=(document.getElementById("booknow").innerHTML).substr(0,2);
		var min=(document.getElementById("booknow").innerHTML).substr(3,2);
		//選擇的時間
		var hour2=($("#hiddTimeStart").val()).substr(0,2);
		var min2=($("#hiddTimeStart").val()).substr(3,2);
	    console.log("todayday="+todayday+"datepicker"+day2);	 
	    if(todayday==day2){ //今天日期跟選擇日期相同
	    	 console.log("same");
	    	 console.log("  可預約的時間"+hour+":"+min+"  選擇的時間"+hour2+":"+min2);
	    	 if(hour2<hour){
	    		 alert("無法選擇過去的時間或預約的時間低於三十分鐘");
	    	 	if(hour2=hour && min<min2){
	    	 		alert("無法選擇過去的時間或預約的時間低於三十分鐘");
	    	 	}
	    	 } 
	    }else{
	    	console.log("different");
	    }  	  				  	  
	});
	
<!-----------------------------回到頂端按鈕------------------------------------->			
			
			$(window).scroll(function(event){
			  var scroll = $(window).scrollTop();
			    if (scroll >= 150) {
			       $(".gototop").removeClass("close");
			    }else {
			    	$(".gototop").addClass("close");
			    }
			});
			
		</script>
		
<!----------------------------Ajax------------------------------------->			
		
<script type="text/JavaScript">
console.log(document.getElementById("forTypeMovie"));
// window.onload = function(){
$(function(){ 
// 	var btn = document.querySelectorAll(".hiAjax");
 	var result = document.getElementById("test226"); //測試塞資料用
    console.log("hi1");
    var totalp = document.getElementById("total");
 	$("#tabs-3 .hiAjax").change(function() {
    	console.log("hi2");
//         var foodIdStr = $(this).prev().val();
//         var qtyStr = $(this).prev().prev().prev().val();
// 	   	var foodPriceStr = $(this).prev().prev().val();
	   	var foodIdStr = $(this).next().next().val();
        var foodTitle = $(this).prev().prev().text();
	   	var foodPriceStr = $(this).next().val();
	   	var qtyStr = $(this).val();
	   	var rId = $("#hiddRoodId").val();
	   	var thisText = document.getElementById("cartff"+foodIdStr);
	   	
	   	console.log("foodIdStr="+foodIdStr+" foodTitle="+foodTitle+"foodPriceStr="+foodPriceStr+"qtyStr="+qtyStr);
	   	
	   	if (qtyStr == 0) {
            $("#cartff"+foodIdStr).attr("style", "display:none");
        } else {
            $("#cartff"+foodIdStr).removeAttr("style");
        }
            
	   	
		   	var xhr = new XMLHttpRequest();
	        xhr.open("POST","<c:url value='addFood' />",true);
	        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        xhr.send("foodId=" + foodIdStr + "&foodNum=" + qtyStr + "&foodP=" +foodPriceStr +"&foodTitle=" + foodTitle + "&rId=" + rId);
	
	        xhr.onreadystatechange = function(){
	        	if(xhr.readyState === 4){
	                if(xhr.status === 200){
	                    var type = xhr.getResponseHeader("Content-Type");
	                    
	                    if(type.indexOf("application/json") === 0){
	                        var obj = JSON.parse(xhr.responseText);
	                        if(obj.foodName){
	                        	console.log("hi3");
	                        	
	                        	//測試
// 	                        	$($('table > tbody > tr')[13]).after("<tr><td><h5 class='foodtip'>"+obj.foodName+"</h5></td></tr><br>"
// 	                        	 +"<tr><td><h5 class='foodtip'>NT. "+ obj.foodP +" x "+obj.foodQty+" = "+(obj.foodP*obj.foodQty)+"</h5></td></tr>"			
	                        	
// 	                        	);
	                        	totalp.innerHTML = obj.foodTotal; 
	                        	thisText.innerHTML = "<tr><td><h5 class='foodtip'>"+obj.foodName+"</h5></td></tr>" 
	                        	 +"<tr><td><h5 class='foodtip'>NT. "+ obj.foodP +" x "+obj.foodQty+" = "+(obj.foodP*obj.foodQty)+"</h5></td></tr>"
	
	//                            result.innerHTML = "<font color='red'>" + obj.foodName + 
	//              			   '數量為 : ' + obj.foodQty + "<br>" + 
	//              			   '價格為 : ' + obj.foodP + "<br>";
	                        }else{
	                        	result.innerHTML = "資料錯誤";
	                        }
	                    }else{
	                    	alert("發生錯誤type : "+xhr.status + ", "+xhr.responseText);
	                    }
	                }
	            }
	        }
	   	
	});
 	
 	$(".hiTime").click(function() {
 		calltimecheck();
//  		if(
//  		$("#hiddTimeDate").val() !=0 && $("#hiddTimeStart").val() !=0 &&  $("#hiddTimeEnd").val() !=0  
//  		 && $("#hiddMovieId").val() !=0 &&  $("#hiddMovieLen").val()!=0//
// 			){
//  			var start = document.getElementById("hiddTimeStart").value;
// 	 		var end = document.getElementById("hiddTimeEnd").value;
// 	 		var date = document.getElementById("hiddTimeDate").value;
// 	 		var idRoom = document.getElementById("hiddRoodId").value;
//  		console.log("TimeStart="+start);
//  		console.log("hiddTimeEnd="+end);
//  		console.log("hiddTimeDate="+date);
//  		console.log("roomId = "+ idRoom);
//  		var warning = document.getElementById("warning");
//  		var timeOkk = document.getElementById("timeOkk");
 		
// //	 		var checkForDB = document.getElementById("checkForDB");
 		
//  		var xhr2 = new XMLHttpRequest();
//         xhr2.open("POST","<c:url value='checkOrder' />",true);
//         xhr2.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//         xhr2.send("tStart=" + start + "&tEnd=" + end + "&tDate=" + date + "&roomID=" + idRoom);

//         xhr2.onreadystatechange = function(){
//         	if(xhr2.readyState === 4){
//                 if(xhr2.status === 200){
//                     var type2 = xhr2.getResponseHeader("Content-Type");
                    
//                     if(type2.indexOf("application/json") === 0){
//                         var obj2 = JSON.parse(xhr2.responseText);
//                         if(obj2.OK){
//                         	console.log("hiOK");
//                         	timeOkk.innerHTML = obj2.OK;
//                         	warning.innerHTML = "";
//                         	$("#checkForDB").val(1);
//                         	console.log("check的值 = "+$("#checkForDB").val())
//                         	console.log($("#warning").text());
// //	                        	totalp.innerHTML = obj.foodTotal; 
// //	                        	thisText.innerHTML = "<tr><td><h5 class='foodtip'>"+obj.foodName+"</h5></td></tr><br>" 
// //	                        	 +"<tr><td><h5 class='foodtip'>NT. "+ obj.foodP +" x "+obj.foodQty+" = "+(obj.foodP*obj.foodQty)+"</h5></td></tr>"

//                         }else if(obj2.warning){
//                         	warning.innerHTML = obj2.warning;
//                         	timeOkk.innerHTML = "";
//                         	$("#checkForDB").val(0);
//                         	console.log("check的值 = "+$("#checkForDB").val())
//                         }else{
//                         	console.log("這行應該不可能發生 !!");
//                         }
//                     }else{
//                     	alert("發生錯誤type : "+xhr2.status + ", "+xhr2.responseText);
//                     }
//                 }
//             }
//         }
// 		}
	});
 	
 	$("#publish").change(function() {
 		var typeStr = $("#publish").val();
 		var xhr3 = new XMLHttpRequest();
        xhr3.open("POST","<c:url value='searchMovieType' />",true);
        xhr3.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhr3.send("typeStr=" + typeStr);
        
//         $("#forTypeMovie").removeAttr("class");
        
        xhr3.onreadystatechange = function(){
        	if (xhr3.readyState == 4 && xhr3.status == 200) {
        		console.log("hi_OK");
				var movieType = JSON.parse(xhr3.responseText);
				displayPageMovies(movieType);
			}
        }
 	});
 	
	$("#fuzzySearch").keyup(function(){
		var movieStr = $("#fuzzySearch").val();
 		var xhr4 = new XMLHttpRequest();
        xhr4.open("POST","<c:url value='fuzzy.do' />",true);
        xhr4.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhr4.send("fuzzyStr=" + movieStr);
        
        
        xhr4.onreadystatechange = function(){
        	if (xhr4.readyState == 4 && xhr4.status == 200) {
        		console.log("hi_OK");
				var movie = JSON.parse(xhr4.responseText);
				if(movie.length!=0){
					displayPageMovies(movie);
				}else{
					fuzzyNoResult();
				}
			}
        }
	});
});
	function fuzzyNoResult(){
		var movieResult = document.getElementById("forTypeMovie");
		movieResult.innerHTML = "<div class='movsp2'></div><div class='movsp2'></div><div class='movsp2'></div><div class='movsp2'></div><div class='movsp2'></div>";
	}
	function displayPageMovies(movies){

	 	var movieResult = document.getElementById("forTypeMovie");
		var contentMovies ="";
		for(var i=0;i<movies.length;i++){
			contentMovies += "<div class='movsp hiTime testAnime' id='"+movies[i].movieId+"'>" + 
			"<img class=movieimg src=" + '"'+" <c:url value = '/getPicture1/"+movies[i].movieId+"' /> " + '"' + "/ "+"> " + "<div>";
			switch(movies[i].movieRated){
				case '普遍級':
					contentMovies += '<p2 class="rate" style="background-color: #01B468">'+movies[i].movieRated+'</p2></div>';
					break;
				case '保護級6+':
					contentMovies += '<p2 class="rate" style="background-color: #66B3FF">'+movies[i].movieRated+'</p2></div>';
					break;
				case '輔12級':
					contentMovies += '<p2 class="rate" style="background-color: yellow">'+movies[i].movieRated+'</p2></div>';
					break;
				case '輔15級':
					contentMovies += '<p2 class="rate" style="background-color: orange">'+movies[i].movieRated+'</p2></div>';
					break;
				default:
					contentMovies += '<p2 class="rate" style="background-color: #FF5151">${product1.movieRated}</p2></div>';
					break;
			}
			contentMovies += "<div><p1>"+movies[i].movieName+"</div></p1>";
			
			if((movies[i].movieEName).length>20){
				contentMovies += "<div><p4 style='font-size: 10px'>"+movies[i].movieEName+"</p4></div><p3>"+movies[i].movieLength+"</p3></div>";
			}else{
				contentMovies += "<div><p4>"+movies[i].movieEName+"</p4></div><p3>"+movies[i].movieLength+"</p3></div>";
			}
		}
		
		
		movieResult.innerHTML = contentMovies+"<div class='movsp2'></div><div class='movsp2'></div><div class='movsp2'></div><div class='movsp2'></div><div class='movsp2'></div>";
		
		$(".movsp").hover(function() {
			$(this).css("background", "#dce8f2");
		}, function() {
			$(this).css("background", "white");
		});
		
		$(".movsp").click(function() {
				$(this).css("background", "#B3D9D9");
		});
		
		$(".movsp").click(function() {

			let Length = $(this).find("p3").text();
			document.getElementById("moviename").innerHTML = $(this).find("p1").text();
			document.getElementById("movieEname").innerHTML = $(this).find("p4").text();
			document.getElementById("movieLength").innerHTML = Length;
			
			let val = $(this).attr("id");
			let len = Length.substring(0,Length.length-1);
			$("#hiddMovieId").val(val);//放入電影id
	        $("#hiddMovieLen").val(len);//放入電影長度
	        console.log("MovieId="+$("#hiddMovieId").val());  //console顯示用
	        console.log("MovieLen="+$("#hiddMovieLen").val());  //console顯示用
	        if($("#hiddTimeStart").val()!=0)  calculation();calltimecheck();//若有先點選時間，則計算結束時間	
	        
	        
		});
		
// 		$( "#publish" ).change(function() {
//         	//     $("#forTypeMovie").effect( "slide", 1000 );
// //         		$("#forTypeMovie").removeAttr("class");
//         	    $("#forTypeMovie").attr("class", "testAnime");
//         	  //highlight
//         });
	}
	
	$(".times").change(function(){
		calltimecheck();
	});
	
	
	//--------------------------------------------------------------------

	//--------------------------------------------------------------------

 	function calltimecheck() {
 		
 		if(
 		$("#hiddTimeDate").val() !=0 && $("#hiddTimeStart").val() !=0 &&  $("#hiddTimeEnd").val() !=0  
 		 && $("#hiddMovieId").val() !=0 &&  $("#hiddMovieLen").val()!=0//
			){
 			var start = document.getElementById("hiddTimeStart").value;
	 		var end = document.getElementById("hiddTimeEnd").value;
	 		var date = document.getElementById("hiddTimeDate").value;
	 		var idRoom = document.getElementById("hiddRoodId").value;
 		console.log("TimeStart="+start);
 		console.log("hiddTimeEnd="+end);
 		console.log("hiddTimeDate="+date);
 		console.log("roomId = "+ idRoom);
 		var warning = document.getElementById("warning");
 		var timeOkk = document.getElementById("timeOkk");
 		
//	 		var checkForDB = document.getElementById("checkForDB");
 		
 		var xhr2 = new XMLHttpRequest();
        xhr2.open("POST","<c:url value='checkOrder' />",true);
        xhr2.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhr2.send("tStart=" + start + "&tEnd=" + end + "&tDate=" + date + "&roomID=" + idRoom);

        xhr2.onreadystatechange = function(){
        	if(xhr2.readyState === 4){
                if(xhr2.status === 200){
                    var type2 = xhr2.getResponseHeader("Content-Type");
                    
                    if(type2.indexOf("application/json") === 0){
                        var obj2 = JSON.parse(xhr2.responseText);
                        if(obj2.OK){
                        	console.log("hiOK");
                        	timeOkk.innerHTML = obj2.OK;
                        	warning.innerHTML = "";
                        	$("#checkForDB").val(1);
                        	console.log("check的值 = "+$("#checkForDB").val())
                        	console.log($("#warning").text());
//	                        	totalp.innerHTML = obj.foodTotal; 
//	                        	thisText.innerHTML = "<tr><td><h5 class='foodtip'>"+obj.foodName+"</h5></td></tr><br>" 
//	                        	 +"<tr><td><h5 class='foodtip'>NT. "+ obj.foodP +" x "+obj.foodQty+" = "+(obj.foodP*obj.foodQty)+"</h5></td></tr>"

                        }else if(obj2.warning){
                        	warning.innerHTML = obj2.warning;
                        	timeOkk.innerHTML = "";
                        	$("#checkForDB").val(0);
                        	console.log("check的值 = "+$("#checkForDB").val())
                        }else{
                        	console.log("這行應該不可能發生 !!");
                        }
                    }else{
                    	alert("發生錯誤type : "+xhr2.status + ", "+xhr2.responseText);
                    }
                }
            }
        }
	}
};
	
</script>
	</body>

</html>