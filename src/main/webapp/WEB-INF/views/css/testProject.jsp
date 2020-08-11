<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-TW">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jQuery UI Accordion - No auto height</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <link href="https://fonts.googleapis.com/css2?family=Nunito:ital@1&display=swap" rel="stylesheet">
    <!-- 以下font-style -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Serif+TC:wght@600&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
 <!-- <link rel="stylesheet" href="jqueryui/style.css"> -->

    <script>

        $(function () {
            $("#tabs").tabs();
        });

        $(function () {
            $("input").checkboxradio();
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
    	
        #Headerr {
            height: 80px;
            background-color:gray;
        }

        #Navv {
            height: 50px;
            background-color: gray;
        }

        #footer{
            height: 100px;
            background-color: gray;
            margin-top: 20px;
        }

        .titletag {
            font-family: 'Noto Serif TC', serif;
        }
        .bigcontainer {
            display: inline-flex;
            margin: 15px;
        }
        
        .firstdiv {
            /* width: 900px; */
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
            /* width: 400px; */
            height: 600px;
            overflow: auto
        }
        .test {
            justify-content: space-around;
            justify-content: center;
            align-items: center;
        }
     /* --------------------Room & time-----------------------------     */
        .tagRoomContent {
            display: flex;
            /* padding: 50px; */
            /* margin: 100px; */
            flex-wrap: wrap;
            justify-content: center;
            background-color: white;
        }

        .date_time{
            width: 80%;
            margin: 20px;
        }

        .times{
            display: none;
            /* margin: 20px; */
        }
        .roomPer {       /*   每個包廂方塊 */
            display: flex;
            margin: 10px 15px;
            text-align: center;
            justify-content: space-around;
            background-color: #FFFAF4;
            padding: 20px;
            border-radius: 20px;
            border: 1px solid #E0E0E0;
        }
        .roomImg {
            height: 300px;
            width: 450px;
            border-radius: 20px;
        }
       
        .roomlist{
            font-size: 15px;
        } 
        
        .roomprice{
         font-family: 'Nunito', sans-serif;
         style:"color": "#990000";
         font-weight: 600;
        }
        
    /* --------------------food-----------------------------     */
    
    	.foodtype{
    
             font-weight: 800;
             font-size: 35px;
             background-color:#EBEBEB;
    
   		 }
    
        .foodPer {           /* 每個食物方塊 */
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
        
        .foodimg{
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
        }
        .tabs-3{
            width:80%;
        }
    
        
    /* --------------------movie-----------------------------     */
        .movieimg {
            height: 200px;
            width: 140px;
            margin: 15px;
        }

        .movsp {        /*  每部電影方塊       */
            margin: 10px;
            border: 0px solid #000;
            ;
            background-color: ghostwhite;
            display: inline-block;
            max-width: 350px;
            width: 240px;
            justify-content: space-around;             
        }

        .movsp p1 {    /*   電影名稱       */
            text-align: center;
            font-family: 微軟正黑體;
            font-weight: bolder;
            padding-left: 10px;
        }

        .movsp p2 {        /*  電影分級       */
            text-align: center;
            font-size: 10px;
            padding-left: 10px;
        }

        .movsp p3 {        /*   電影長度       */
            text-align: center;
            font-size: 14px;
            padding-left: 10px;
        }
        .tagContext {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
        }
        /* --------------------cart----------------------------     */
        #sumit{
        text-align: center;
        }
        .listtotal {
            height: 30px;
            width: 40px;
            padding-left: 12px;
            font-weight: 900px;
            font-size: 20px;
        }
        #totalprice{
            font-family: 微軟正黑體;
            font-weight: bolder;
        }
        .panel-title {
            padding: 0px;
            margin: 0px;
            background-color: #347AB7;
            text-align: center;
            color: #FCFCFC;
        }

        .secondPerHeader {
            font-family: 'Noto Sans TC', sans-serif;
            color: #3277B3;
        }
        
        .tagFood{
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
    </style>

</head>

<body>
    <div id="Headerr">
        <h1></h1>
    </div>
    <div id="Navv">
        <h3></h3>
    </div>


    <div class="bigcontainer">

        <div class="firstdiv" id="tabs">
            <div>
                <ul style="background-color: white;">
                    <li style="border-radius: 5px;"><a class="titletag" id="tag3" href="#tabs-1">包廂</a></li>
                    <li style="border-radius: 5px;"><a class="titletag" id="tag1" href="#tabs-2">電影</a></li>
                    <li style="border-radius: 5px;"><a class="titletag" id="tag2" href="#tabs-3">餐點</a></li>
                </ul>
            </div>
            <div id="tabs-1">
                <div class="tagRoomContent" id="tagRoom">

                    <div class="date_time">
                        <h3>請選擇日期、時間：</h3>
                        <input type="date" name="fname" id="mydate" class="" >
                        <select name="ampm" id="ampm" class="ampm">
                            　	<option value="am">上午</option>
                                <option value="pm">下午</option>
                                <option value="night">晚上</option>
                             </select>
                        <select name="Yourtime" id="am" class="times">
                        　	<option value="0930">09:30-10:00</option>
                            <option value="0930">10:00-10:30</option>
                            <option value="0930">10:30-11:00</option>
                            <option value="0930">11:00-11:30</option>
                            <option value="0930">11:30-12:00</option>
                            <option value="0930">12:00-12:30</option>
                         </select>
                            <select name="Yourtime" id="pm" class="times">
                                <option value="0930">12:30-13:00</option>
                                <option value="0930">13:00-13:30</option>                            　	
                                <option value="0930">09:30-10:00</option>
                                <option value="0930">13:30-14:00</option>
                                <option value="0930">14:00-14:30</option>
                                <option value="0930">14:30-15:00</option>
                                <option value="0930">15:00-15:30</option>
                                <option value="0930">15:30-16:00</option>
                                <option value="0930">16:00-16:30</option>
                                <option value="0930">16:30-17:00</option>
                                <option value="0930">17:00-17:30</option>
                                <option value="0930">17:30-18:00</option>
                             </select>
                             <select name="Yourtime" id="night "class="times">
                                <option value="0930">18:00-18:30</option>
                                <option value="0930">18:30-19:00</option>                            　	
                                <option value="0930">09:30-10:00</option>
                                <option value="0930">19:00-19:30</option>
                                <option value="0930">19:30-20:00</option>
                                <option value="0930">20:30-21:00</option>
                                <option value="0930">21:00-21:30</option>
                             </select>
                    </div>                   
            <c:forEach var='product2' items='${room}'>
                    <div class="roomPer">
                        <div><img class="roomImg" 
                        src="<c:url value='/getPicture2/${product2.roomId}' />" /><br>
                            <h3>${product2.roomName}</h3>
                            <br>
                            <h4 class="roomprice" style="color:#990000">NT.${product2.roomPrice}</h4>
                            <label for="room${product2.roomId}">選擇此包廂</label>
                            <input class="roomB" type="radio" name="room" id="room${product2.roomId}">
                        </div>
                    </div>
			</c:forEach>
                </div>
            </div>
            <div id="tabs-2" class="tagContext">
             <c:forEach var='product1' items='${movie}'>
                <div class="movsp">
                    <img class=movieimg src="<c:url value='/getPicture1/${product1.movieId}' />" />
                    <div>
                        <p2>${product1.movieRated}</p2>
                    </div>
                    <div>
                        <p1>${product1.movieName}</p1>
                    </div>
                    <div>
                        <p1>${product1.movieEName}</p1>
                    </div>
                    <p3>${product1.movieLength}</p3>
                </div>
            </c:forEach>
            </div>
             <div id="tabs-3" class="tagContext"> 
	             <div class="foodtype">主食區</div>
	            <c:forEach var='food' items='${main}'>
	            
	                <div class="foodPer">
	                    <div>
	                      <img class="foodimg" src="<c:url value='/getFoodImg/${food.foodId}' />" />
	                     </div>
		                <div class="foodname">
		                    <div class="fontBold">${food.foodName}</div>
		                    <div class="foodprice" style="color: #990000;font-weight: 600;">NT ${food.foodPrice}</div>
		                    <select class="form-control-s" id="cartf${food.foodId}" >
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
		                </div>
	                </div>
	                </c:forEach>
	                
	                <div class="foodtype">點心區</div>
	                
	                <c:forEach var='food' items='${dessert}'>
	            
		                <div class="foodPer">
		                    <div>
		                      <img class="foodimg" src="<c:url value='/getFoodImg/${food.foodId}' />" />
		                     </div>
			                <div class="foodname">
			                    <div class="fontBold">${food.foodName}</div>
			                    <div class="foodprice" style="color: #990000;font-weight: 600;">NT ${food.foodPrice}</div>
			                    <select class="form-control-s" id="cartf${food.foodId}" >
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
			                </div>
		                </div>
	                </c:forEach>
	                
	                
	                <div class="foodtype">飲料區</div>
					<c:forEach var='food' items='${drink}'>
	            
		                <div class="foodPer">
		                    <div>
		                      <img class="foodimg" src="<c:url value='/getFoodImg/${food.foodId}' />" />
		                     </div>
			                <div class="foodname">
			                    <div class="fontBold">${food.foodName}</div>
			                    <div class="foodprice" style="color: #990000;font-weight: 600;">NT ${food.foodPrice}</div>
			                    <select class="form-control-s" id="cartf${food.foodId}" >
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
			                </div>
		                </div>
	                </c:forEach>
	                <div class="foodtype">套餐</div>
						<c:forEach var='food' items='${packa}'>
		            
			                <div class="foodPer">
			                    <div>
			                      <img class="foodimg" src="<c:url value='/getFoodImg/${food.foodId}' />" />
			                     </div>
				                <div class="foodname">
				                    <div class="fontBold">${food.foodName}</div>
				                    <div class="foodprice" style="color: #990000;font-weight: 600;">NT ${food.foodPrice}</div>
				                    <select class="form-control-s" id="cartf${food.foodId}" >
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
				                </div>
			                </div>
		                </c:forEach>
            </div>
        </div>

 <!------------------------------------------購物車------------------------------------->

        <div style="border: 2px solid #347AB7;border-radius: 5px;" class="seconddiv inner" id="">
            <div class="panel-title" style="padding: 10px;">
                <h3>您的購物車</h3>
                <h3> Shopping Cart</h3>
            </div>
           <div style="padding: 15px;">
                <h3 class="secondPerHeader">包廂</h3><br>
                <hr>
            </div>
            <div>

            </div>
            <div style="padding: 15px;">
                <h3 class="secondPerHeader">電影</h3><br>
                <hr>
            </div>
            <div>

            </div>
            <div style="padding: 15px;">
            <h3 style="padding:5px" class="secondPerHeader">餐點</h3><br>
            <c:forEach var='food' items='${allFood}'>
            	<div id='cartf${food.foodId}a' style="display:none;">
            		<h3 style="color:brown;padding: 5px;display:inline">${food.foodName}</h3>
            		<input readonly='true' style="left: 100em;" class="listtotal" id='cartf${food.foodId}b' type="text">
            	</div>
            </c:forEach>
            <hr>
            <br>
            </div>
            </div>
            <div>
                    <p id='totalprice'>合計:</p>
                </div>
             <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
            <div id="sumit">
            <button type="button" class="btn btn-primary">確認</button>
			<button type="button" class="btn btn-secondary">重新選擇</button>
            </div>
            </div>
			
        </div>
    
    <div id="footer">
        <h3></h3>
    </div>
<!-------------------------------------------Script--------------------------------------->

    <script>
//包廂    
    $(".roomB").click(function () {

        let id = $(this).attr("id") + 1;
        $("#"+id).siblings("div").attr("style", "display:none");
        $("#"+id).attr("style", "display:inline");
    })
    
    
    
//食物
    $("#tabs-3 .form-control-s").change(function () {

        let b = $(this).val();
        let id =$(this).attr("id")+"a";
        let NumId = $(this).attr("id")+"b";
        console.log(id);
        $("#"+NumId).val(b);

        if ($(this).val() == 0) {
            $("#"+id).attr("style", "display:none");
        } else {
            $("#"+id).removeAttr("style");
        }
    })
//         $(".roomB").click(function () {
//             let idO = $(this).attr("id")
//             let id = $(this).attr("id") + 1;
//             $(`#${id}`).siblings("div").attr("style", "display:none");
//             $(`#${id}`).attr("style", "display:inline");
//         })
//         $(".cancelB").click(function () {
//             $(this).parent().attr("style", "display:none");
//         })

//         $(".form-control-s").change(function () {
//             let a = $(this).prev().prev().text();
//             let b = $(this).val();
//             let idO = $(this).attr("id")
//             let id = $(this).attr("id") + 1;

//             $(`#${idO}Num`).val(`${b}`);

//             let idNum = 0;

//             if ($(".form-control-s").val() == 0) {
//                 $(`#${id}`).attr("style", "display:none");
//             } else {
//                 $(`#${id}`).removeAttr("style");
//             }
          
//         })

        $("#t").on({
            keyup: function () {
                if ($("#t").val() < 0) $("#t").val("0");
                console.log("wtf=" + $("#t").val());
            },
            mouseup: function () {
                if ($("#t").val() < 1) {
                    $("#t").val("0");
                    console.log("mouseup=" + $("#t").val());
                }
            }
        });

        $("#ampm").change(function(){
            var k= $(this).val();
             $(this).siblings().not(mydate).not( ).removeClass("times");
            // $("#ampm~ :not(${k})").css("display","none");
            // if($(this).id()==k)
            // $(this).removeClass("times");

        })
        $(".movsp").hover(function(){
            $(this).css("background","#FFEEDD");
        },function(){
            $(this).css("background","white");
        })
        $(".foodPer").hover(function(){
            $(this).css("background","#FFEEDD");
        },function(){
            $(this).css("background","white");
        })
         $(".roomPer").hover(function(){
            $(this).css("background","#FFEEDD");
        },function(){
            $(this).css("background","white");
        })
         
    </script>

</body>

</html>