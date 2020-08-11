
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
		<script src='https://kit.fontawesome.com/a076d05399.js'></script>
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<title>包廂維護</title>
	<style type="text/css">
		h1 {
			text-align: center;
			font-size: 60px;
		}
		
		h2 {
			text-align: center;
			color: blue font-size: 60px;
		}
		#AddRoom{    
			font-size: 20px;
		    color: #019858;
		    float: right;
		    padding-left: 0px;
		    padding-right: 0px;
		    padding-bottom: 0px;
		 }
	</style>
	</head>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#productImage').change(function() {//圖片預覽
				  var file = $('#productImage')[0].files[0];
				  var reader = new FileReader;
				  reader.onload = function(e) {
				    $('#roomImgUp').attr('src', e.target.result);
				    $("#roomImgUp").show();
				  };
				  reader.readAsDataURL(file);
				});
		})
		function addRoom() {//開啟新增包廂表單
			$("#roomId").val("");
			$("#roomName").val("");
			$("#roomPrice").val("");
			$("#roomSize").val("");
			$("#roomImgUp").attr("src", "");
			$("#roomImgUp").hide();
			$("#productImage").val("");
			$("#Header").html("新增包廂");
			$("#AddRoom_modal").show();
			$("#UpRoom").hide();
		}
		function AddRoomAjax() {//新增包廂AJAX送出表單
			var xhr = new XMLHttpRequest();
			var form = document.getElementById('roomBean');  
			var formData = new FormData(form);
			var table = document.getElementById("roomTable");
			var tr = table.insertRow(1);
			var roomId = tr.insertCell(0);
			var roomImg = tr.insertCell(1);
			var roomName = tr.insertCell(2);
			var roomSize = tr.insertCell(3);
			var roomPopulation = tr.insertCell(4);
			var roomPrice = tr.insertCell(5);
			var roomDateString = tr.insertCell(6);
			var roomButton = tr.insertCell(7);
			var Updatabtn = document.createElement("I");
			var Delectbtn = document.createElement("I");
			$.ajax({//AJAX開始
		        url : "<c:url value='AddRoomAjax' />",
		        type : "POST",
		        data : formData,
		        contentType: false,
		        cache: false,
		        processData: false,
		        success : function(data) 
		        {
		        	tr.setAttribute("id","tr"+data[0].roomId);
		        	tr.setAttribute("name","tr");
		        	roomId.setAttribute("id","roomId"+data[0].roomId);
		        	roomImg.setAttribute("id","roomImg"+data[0].roomId);
		        	roomName.setAttribute("id","roomName"+data[0].roomId);
		        	roomSize.setAttribute("id","roomSize"+data[0].roomId);
		        	roomPopulation.setAttribute("id","roomPopulation"+data[0].roomId);
		        	roomPrice.setAttribute("id","roomPrice"+data[0].roomId);
		        	roomDateString.setAttribute("id","roomDateString"+data[0].roomId);
		        	roomButton.setAttribute("id","roomButton"+data[0].foodId);
		        	roomId.innerHTML=data[0].roomId;
		        	roomImg.innerHTML="<img height='100' width='80' src='<c:url value='/getRoomImg/"+data[0].roomId+"' />'>";
		        	roomName.innerHTML=data[0].roomName;
		        	roomSize.innerHTML=data[0].roomSize;
		        	roomPopulation.innerHTML=data[0].roomPopulation;
		        	roomPrice.innerHTML=data[0].roomPrice;
		        	roomDateString.innerHTML=data[0].roomDateString;
		        	$(Updatabtn).attr({
						"id":"updata"+data[0].roomId,
						"class":"fas fa-edit btn btn-link",
						"style":"font-size:25px;color:blue;",
						"data-toggle":"modal",
						"data-target":"#RoomModal",
						"onclick":"RoomUpdate('"+data[0].roomId+"','<c:url value='/getRoomImg/"+data[0].roomId+"' />','"+data[0].roomName+"','"+data[0].roomSize+","+data[0].roomPopulation+"','"+data[0].roomPrice+"')"
					});	
		        	$(Delectbtn).attr({
						"id":"delet"+data[0].roomId,
						"class":"fa fa-trash btn btn-link",
						"style":"font-size:25px;color:red",
						"onclick":"RoomDelete('"+data[0].roomName+"','"+data[0].roomId+"')"
					});
		        	roomButton.appendChild(Updatabtn);
		        	roomButton.appendChild(Delectbtn);
		            console.log(data);
		            console.log(data[0].foodDateString);
		            
		        },error: function(data) 
		        {
		            console.log('無法送出');
		        }
		    });
		}
		function RoomUpdate(roomId,roomImg,roomName,roomSize,roomPrice) {//開啟修改包廂AJAX
			$("#roomId").val(roomId);
			$("#roomName").val(roomName);
			$("#roomPrice").val(roomPrice);
			$("#roomSize").val(roomSize);
			$("#roomImgUp").attr("src", roomImg);
			$("#roomImgUp").show();
			$("#productImage").val("");
			$("#Header").html("修改包廂");
			$("#UpRoom").show();
			$("#AddRoom_modal").hide();
		}
		function UpRoomAjax() {//修改包廂AJAX送出表單
			var form = document.getElementById('roomBean');  
			var formData = new FormData(form);
			$.ajax({//AJAX開始
		        url : "<c:url value='UpRoomAjax' />",
		        type : "POST",
		        data : formData,
		        contentType: false,
		        cache: false,
		        processData: false,
		        success : function(data) 
		        {
		        	$("#roomName"+data[0].roomId).html(data[0].roomName);
		        	$("#roomSize"+data[0].roomId).html(data[0].roomSize);
		        	$("#roomPopulation"+data[0].roomId).html(data[0].roomPopulation);
		        	$("#roomPrice"+data[0].roomId).html(data[0].roomPrice);
		        	$("#roomDateString"+data[0].roomId).html(data[0].roomDateString);
		        	//$("#roomImg"+data[0].roomId).html(data[0].roomName);
		        	//roomImg.innerHTML="<img height='100' width='80' src='<c:url value='/getRoomImg/"+data[0].roomId+"' />'>";
		        	$.ajax({//AJAX開始
				        url : "<c:url value='/getRoomImg/"+data[0].roomId+"' />",
				        type : "GET",
				        success : function() 
				        {
				        	$("#roomImg"+data[0].roomId).html("<img height='100' width='80' src='<c:url value='/getRoomImg/"+data[0].roomId+"' />'>");
				        }
				        
		        	})
		        },error: function(data) 
		        {
		            console.log('無法送出');
		        }
		    });
		}
		function RoomDelete(Name,Id) {//刪除包廂AJAX
			if (confirm("確定刪除此項包廂資料(包廂:"+Name+")?") ) {
				var xhr = new XMLHttpRequest();
				xhr.open("POST", "<c:url value='RoomDelete?RoomId="+Id+"' />", true);
				xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhr.send();
				$("#tr"+Id).remove();
			} else {
			}
		}
	
	function UpdataCancel() {
		$("#updata").hide();
	}
	</script>
	<body class="bg-theme bg-theme1">
		<c:set var="funcName" value="Room" scope="session"/>
		<div id="wrapper">
			<jsp:include page="../Manager/Manager.jsp" />
			<div class="content-wrapper">
			<div class="container-fluid">
				<div id='c3' class="clearfix">
					<div class="row">
						<div class="col-12 col-lg-12">
							<div class="card">
								<div class="card-header" align="center">
			<h1 style="display:inline">包廂維護</h1>
<!-- 			<div class="btn" data-toggle="modal" data-target="#RoomModal" id="AddRoom" onclick="addRoom()"> -->
<!-- 			   	<i class="material-icons" style="font-size:30px;color:blue;">add_box</i> -->
<!-- 			</div> -->
			<div data-toggle="modal" data-target="#RoomModal" id="AddRoom" class="btn btn-link" onclick="addRoom()">			
				<img style="color:blue;" src="assets/images/add_icon/add-icon-green.png" class="logo-icon" alt="logo icon"/>新增包廂			
			</div>
			<div class="table-responsive">
			<table id="roomTable" class="table align-items-center" style="font-size:20px;">
				<tr style="font-size:20px;" class="thead-dark">
					<th>RoomID</th>
					<th>圖片</th>
					<th>包廂名稱</th>
					<th>包廂大小</th>
					<th>包廂人數</th>
					<th>包廂價錢</th>
					<th>最後更新時間</th>
					<th>&ensp;修改&ensp;&emsp;刪除</th>
				</tr>
				<c:forEach var="room"  items="${rooMap}">
					<tr name="tr" id="tr${room.value.roomId}">
						<td>${room.value.roomId}</td>
						<td id="roomImg${room.value.roomId}">
							<img height='100' width='80' src='<c:url value="/getRoomImg/${room.value.roomId}" />'>
						</td>
						<td id="roomName${room.value.roomId}">${room.value.roomName}</td>
						<td id="roomSize${room.value.roomId}">${room.value.roomSize}</td>
						<td id="roomPopulation${room.value.roomId}">${room.value.roomPopulation}</td>
						<td id="roomPrice${room.value.roomId}">${room.value.roomPrice}</td>
						<td id="roomDateString${room.value.roomId}">${room.value.roomDateString}</td>
						<td id="roomButton${room.value.roomId}">
							<i id="updata${room.value.roomId}" class="fas fa-edit btn btn-link" style="font-size:25px;color:blue;" data-toggle="modal" data-target="#RoomModal" onclick="RoomUpdate('${room.value.roomId}','<c:url value="/getRoomImg/${room.value.roomId}" />','${room.value.roomName}','${room.value.roomSize},${room.value.roomPopulation}','${room.value.roomPrice}')"></i>
							<i id="delet${room.value.roomId}" class="fa fa-trash btn btn-link" onclick="RoomDelete('${room.value.roomName}',${room.value.roomId})" style="font-size:25px;color:red"></i>		
						</td>
					</tr>
				</c:forEach>
			</table></div>
			<form:form id="roomBean" method='POST' modelAttribute="roomBean" enctype='multipart/form-data'>
			<div class="modal" id="RoomModal">
			    <div class="modal-dialog">
				    <div class="modal-content" style="background-image: url(assets/images/bg-themes/5.png); "><!-- Modal (開啟) -->
				    	<!-- Modal Header (標頭)-->
				      	<div class="modal-header">
					        <h1 id="Header" class="modal-title" id="modal_title">新增包廂</h1>
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
				        </div>
				        <!-- Modal body (內容形式)-->
				        <div class="modal-body" align="left">
				        	<div class="form-group">
					            <label for="recipient-name" class="col-form-label" style="font-size:20px;">包廂名稱</label>
								<form:input id="roomName" path="roomName" name="roomName" type='text' class="form-control" />
					         </div>
				        	<div class="form-group">
					            <label for="recipient-name" class="col-form-label" style="font-size:20px;">包廂大小(人數)</label><br>
					            <form:select path="roomSize" class="form-control" style="font-size:15px;">
					            	<form:option value="">請選擇</form:option>
					            	<form:option value="大型包廂,9~12人">大型包廂 (9~12)人</form:option>
					            	<form:option value="中型包廂,5~8人">中型包廂 (5~8)人</form:option>
					            	<form:option value="小型包廂,2~4人">小型包廂 (2~4)人</form:option>
					            </form:select>
					        </div>
				        	<div class="form-group">
					            <label for="recipient-name" class="col-form-label" style="font-size:20px;">包廂價錢</label>
								<form:input style="font-size:20px;" type="number" id="roomPrice" path="roomPrice" name="roomPrice" class="form-control" />
					         </div>
				        	<div class="form-group">
					            <label class="btn btn-info" style="font-size:20px;">
									<form:input id="productImage" path="productImage" type='file' style="display:none;" />
									<i class="fa fa-photo"></i> 上傳圖片
								</label>
								<img id="roomImgUp" height='100' width='80' src="">
					         </div>
				        </div>
				        <!-- Modal footer (結尾)-->
				        <div class="modal-footer">
				        	<form:input type="hidden" id="roomId" path="roomId" name="roomId" />
							<input type="button" id="UpRoom" class="btn btn-primary" data-dismiss="modal" onclick="UpRoomAjax()" value="修改" />
							<input type="button" id="AddRoom_modal" class="btn btn-primary" data-dismiss="modal" value="新增" onclick="AddRoomAjax()" />
							<input type="button" class="btn btn-danger" data-dismiss="modal" value="取消">					
				        </div>
				    
				    </div>
			    </div>
			</div>
			</form:form>
		</div></div></div></div></div></div></div></div>
		<script type="text/javascript">
			$("#Search").keyup(function(){
				 var search = this.value;
				 var form = document.getElementById('roomBean');  
					var formData = new FormData(form);
					var table = document.getElementById("roomTable");
					$("tr[name='tr']").remove();
					$.ajax({//AJAX開始
				        url : "<c:url value='SearchRoomAjax' />",
				        type : "POST",
				        data : {name:search},
				        success : function(data) 
				        {
				        	//console.log(data[0].roomId);
				        	for (var i = 0; i < data.length; i++) {
				        		var tr = table.insertRow(i+1);
								var roomId = tr.insertCell(0);
								var roomImg = tr.insertCell(1);
								var roomName = tr.insertCell(2);
								var roomSize = tr.insertCell(3);
								var roomPopulation = tr.insertCell(4);
								var roomPrice = tr.insertCell(5);
								var roomDateString = tr.insertCell(6);
								var roomButton = tr.insertCell(7);
								var Updatabtn = document.createElement("I");
								var Delectbtn = document.createElement("I");
								tr.setAttribute("id","tr"+data[i].roomId);
								tr.setAttribute("name","tr");
	 				        	roomId.setAttribute("id","roomId"+data[i].roomId);
	 				        	roomImg.setAttribute("id","roomImg"+data[i].roomId);
	 				        	roomName.setAttribute("id","roomName"+data[i].roomId);
	 				        	roomSize.setAttribute("id","roomSize"+data[i].roomId);
	 				        	roomPopulation.setAttribute("id","roomPopulation"+data[i].roomId);
	 				        	roomPrice.setAttribute("id","roomPrice"+data[i].roomId);
	 				        	roomDateString.setAttribute("id","roomDateString"+data[i].roomId);
	 				        	roomButton.setAttribute("id","roomButton"+data[i].foodId);
	 				        	roomId.innerHTML=data[i].roomId;
	 				        	roomImg.innerHTML="<img height='100' width='80' src='<c:url value='/getRoomImg/"+data[i].roomId+"' />'>";
	 				        	roomName.innerHTML=data[i].roomName;
	 				        	roomSize.innerHTML=data[i].roomSize;
	 				        	roomPopulation.innerHTML=data[i].roomPopulation;
	 				        	roomPrice.innerHTML=data[i].roomPrice;
	 				        	roomDateString.innerHTML=data[i].roomDateString;
	 				        	$(Updatabtn).attr({
	 								"id":"updata"+data[i].roomId,
	 								"class":"fas fa-edit btn btn-link",
	 								"style":"font-size:25px;color:blue;",
	 								"data-toggle":"modal",
	 								"data-target":"#RoomModal",
	 								"onclick":"RoomUpdate('"+data[i].roomId+"','<c:url value='/getRoomImg/"+data[i].roomId+"' />','"+data[i].roomName+"','"+data[i].roomSize+","+data[i].roomPopulation+"','"+data[i].roomPrice+"')"
	 							});	
	 				        	$(Delectbtn).attr({
	 								"id":"delet"+data[i].roomId,
	 								"class":"fa fa-trash btn btn-link",
	 								"style":"font-size:25px;color:red",
	 								"onclick":"RoomDelete('"+data[i].roomName+"','"+data[i].roomId+"')"
	 							});
	 				        	roomButton.appendChild(Updatabtn);
	 				        	roomButton.appendChild(Delectbtn);
	 				            console.log(data);
	 				            console.log(data[i].foodDateString);
							}
				            
				        },error: function(data) 
				        {
				            console.log('無法送出');
				        }
				    });
			});
		</script>
	</body>
</html>