<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script src='https://kit.fontawesome.com/a076d05399.js'></script>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>菜單維護</title>
<style type="text/css">
#AddFood{    
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
		$('#AddFood').click(function(){//開啟新增食物表單
			$("#upfoodId").val("");
			$("#foodName").val("");
			$("#foodPrice").val("");
			$("input[type='radio']").prop("checked",false);
			$("#foodImgUp").attr("src", "");
			$("#foodImgUp").hide();
			$("#productImage").val("");
			$("#Header").html("新增食物");
			$("#AddFood_modal").show();
			$("#UpFood").hide();
		});
		$('#productImage').change(function() {//圖片預覽
			  var file = $('#productImage')[0].files[0];
			  var reader = new FileReader;
			  reader.onload = function(e) {
			    $('#foodImgUp').attr('src', e.target.result);
			    $("#foodImgUp").show();
			  };
			  reader.readAsDataURL(file);
			});
	})
	
	function AddFoodAjax() {//新增食物AJAX送出
		var xhr = new XMLHttpRequest();
		var form = document.getElementById('UpdataFoodBean');  
		var formData = new FormData(form);
		var table = document.getElementById("FoodTable");
		var tr = table.insertRow(1);
		var foodId = tr.insertCell(0);
		var foodImg = tr.insertCell(1);
		var foodName = tr.insertCell(2);
		var foodType = tr.insertCell(3);
		var foodPrice = tr.insertCell(4);
		var foodDateString = tr.insertCell(5);
		var button = tr.insertCell(6);
		var Updatabtn = document.createElement("I");
		var Delectbtn = document.createElement("I");
		$.ajax({//AJAX開始
		        url : "<c:url value='AddFood' />",
		        type : "POST",
		        data : formData,
		        contentType: false,
		        cache: false,
		        processData: false,
		        success : function(data) 
		        {
		        	tr.setAttribute("id","tr"+data[0].foodId);
		        	foodId.setAttribute("id","foodId"+data[0].foodId);
		        	foodImg.setAttribute("id","foodImg"+data[0].foodId);
		        	foodName.setAttribute("id","foodName"+data[0].foodId);
		        	foodType.setAttribute("id","foodType"+data[0].foodId);
		        	foodPrice.setAttribute("id","foodPrice"+data[0].foodId);
		        	foodDateString.setAttribute("id","foodDateString"+data[0].foodId);
		        	button.setAttribute("id","button"+data[0].foodId);
		        	foodId.innerHTML=data[0].foodId;
		        	foodImg.innerHTML="<img height='100' width='80' src='<c:url value='/getFoodImg/"+data[0].foodId+"' />'>";
		        	foodName.innerHTML=data[0].foodName;
		        	foodType.innerHTML=data[0].foodType;
		        	foodPrice.innerHTML=data[0].foodPrice;
		        	foodDateString.innerHTML=data[0].foodDateString;
		        	$(Updatabtn).attr({
						"id":"updata"+data[0].foodId,
						"class":"fas fa-edit btn btn-link",
						"style":"font-size:25px;color:blue;",
						"data-toggle":"modal",
						"data-target":"#FoodModal",
						"onclick":"FoodUpdate('"+data[0].foodId+"','<c:url value='/getFoodImg/"+data[0].foodId+"' />','"+data[0].foodName+"','"+data[0].foodType+"','"+data[0].foodPrice+"')"
					});
		        	$(Delectbtn).attr({
						"id":"delet"+data[0].foodId,
						"class":"fa fa-trash btn btn-link",
						"style":"font-size:25px;color:red",
						"onclick":"FoodDelete('"+data[0].foodName+"','"+data[0].foodId+"')"
					});
		        	button.appendChild(Updatabtn);
		        	button.appendChild(Delectbtn);
		            console.log(data);
		            console.log(data[0].foodDateString);
		            
		        },error: function(data) 
		        {
		            console.log('無法送出');
		        }
		    });
	}
	function FoodUpdate(foodId,foodImg,foodName,foodType,foodPrice) {//開啟修改食物表單
		$("#foodName").val(foodName);
		$("#foodPrice").val(foodPrice);
		$("#upfoodId").val(foodId);
		$("input[type='radio']").prop("checked",false);
		$("input[type='radio'][value='"+foodType+"']").prop("checked",true);
		$("#foodImgUp").attr("src", foodImg);
		$("#foodImgUp").show();
		$("#productImage").val("");
		$("#Header").html("修改食物");
		$("#UpFood").show();
		$("#AddFood_modal").hide();
	}
	function UpFoodAjax() {//修改食物AJAX送出表單
		var form = document.getElementById('UpdataFoodBean');  
		var formData = new FormData(form);
		var xhrimg = new XMLHttpRequest();
		$.ajax({//AJAX開始
	        url : "<c:url value='UpFood' />",
	        type : "POST",
	        data : formData,
	        contentType: false,
	        cache: false,
	        processData: false,
	        success : function(data) 
	        {
	        	var Id = data[0].foodId;
	        	$("#foodName"+Id).html(data[0].foodName);
	        	$("#foodType"+Id).html(data[0].foodType);
	        	$("#foodPrice"+Id).html(data[0].foodPrice);
	        	$("#foodDateString"+Id).html(data[0].foodDateString);
	        	$("#foodImg"+Id).html("<img height='100' width='80' src='<c:url value='getFoodImg/"+data[0].foodId+"' />'>");	        	
	        },error: function(data) 
	        {
	            console.log('無法送出');
	        }
	    });
		xhrimg.open("GET", "<c:url value='getFoodImg/"+$("#upfoodId").val()+"' />", true);
		xhrimg.send();
	}
	function FoodDelete(Name,Id) {//刪除食物AJAX
		if (confirm("確定刪除此項食物資料(食物:"+Name+")?") ) {
			var xhr = new XMLHttpRequest();
			xhr.open("POST", "<c:url value='FoodDelete?FoodId="+Id+"' />", true);
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send();
			$("#tr"+Id).remove();
		} else {
		}
	}
</script>
<body class="bg-theme bg-theme1">
<c:set var="funcName" value="Food" scope="session"/>
<div id="wrapper">
<jsp:include page="../Manager/Manager.jsp" />
<div class="content-wrapper">
    <div class="container-fluid">
	<div class="row">
	 <div class="col-12 col-lg-12">
	   <div class="card">
		<div class="card-body" align="center">
		<h1 style="display:inline">菜單維護</h1>
		<div data-toggle="modal" data-target="#FoodModal" id="AddFood" class="btn btn-link">			
			<img style="color:blue;" src="assets/images/add_icon/add-icon-green.png" class="logo-icon" alt="logo icon"/>新增菜單			
		</div>
	    <div class="table-responsive">
<!-- 		<div data-toggle="modal" data-target="#FoodModal" id="AddFood" align="right"> -->
<!-- 		   	<a href="javascript:void();"><i class="material-icons" style="font-size:30px;color:blue;">add_box新增菜單</i></a> -->
<!-- 			<input type="button" value="返回測試選項" onclick="javascript:location.href='/DanielTest'"> -->
<!-- 		</div> -->
		
		<table id="FoodTable" class="table align-items-center" style="font-size:20px;">
			<tr style="font-size:20px;" class="thead-dark">
				<th>FoodID</th>
				<th>圖片</th>
				<th>食物名稱</th>
				<th>食物類型</th>
				<th>食物價錢</th>
				<th>最後更新時間</th>
				<th>&ensp;修改&ensp;&emsp;刪除</th>				
			</tr>
			<c:forEach var="food"  items="${foodMap}">
				<tr id="tr${food.value.foodId}">
					<td id="foodId${food.value.foodId}">${food.value.foodId}</td>
					<td id="foodImg${food.value.foodId}">
						<img height='100' width='80' src='<c:url value="/getFoodImg/${food.value.foodId}" />'>
					</td>
					<td id="foodName${food.value.foodId}">${food.value.foodName}</td>
					<td id="foodType${food.value.foodId}">${food.value.foodType}</td>
					<td id="foodPrice${food.value.foodId}">${food.value.foodPrice}</td>
					<td id="foodDateString${food.value.foodId}">${food.value.foodDateString}</td>
					<td id="button${food.value.foodId}">
						<input name="foodId" type="hidden" id="foodId" value="${food.value.foodId}" />
						<i id="updata${food.value.foodId}" class="fas fa-edit btn btn-link" style="font-size:25px;color:blue;" data-toggle="modal" data-target="#FoodModal" onclick="FoodUpdate('${food.value.foodId}','<c:url value="/getFoodImg/${food.value.foodId}" />','${food.value.foodName}','${food.value.foodType}','${food.value.foodPrice}')"></i>
						<i id="delet${food.value.foodId}" class="fa fa-trash btn btn-link" onclick="FoodDelete('${food.value.foodName}',${food.value.foodId})" style="font-size:25px;color:red"></i>						
					</td>
				</tr>
			</c:forEach>
		</table>
		<form:form id="UpdataFoodBean" method='POST' modelAttribute="foodBean" enctype='multipart/form-data'>
		<div class="modal" id="FoodModal" >
		    <div class="modal-dialog">
			    <div class="modal-content" style="background-image: url(assets/images/bg-themes/5.png); "><!-- Modal (開啟) -->
			    	<!-- Modal Header (標頭)-->
			      	<div class="modal-header">
				        <h1 id="Header" class="modal-title" id="modal_title">新增食物</h1>
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        </div>
			        <!-- Modal body (內容形式)-->
			        <div class="modal-body font_size" align="left">
			        	<div class="form-group">
				            <label for="recipient-name" class="col-form-label" style="font-size: 20px">食物名稱</label>
							<form:input style="font-size: 20px" id="foodName" path="foodName" name="foodName" type='text' class="form-control" />
				         </div>
			        	<div class="form-group">
				            <label for="recipient-name" class="col-form-label" style="font-size: 20px">食物類型</label><br>
				            <c:forEach var="GenreList" items="${Genre}">
					           <div class="form-check-inline">
								  <label class="form-check-label" style="font-size: 20px">
								  		<form:radiobutton class="form-check-input" id="foodType" path="foodType" value="${GenreList}" />${GenreList}	
								  </label>
								</div>
				       		</c:forEach>
				         </div>
			        	<div class="form-group">
				            <label for="recipient-name" class="col-form-label" style="font-size: 20px">食物價錢</label>
							<form:input style="font-size: 20px" type="number" id="foodPrice" path="foodPrice" name="foodPrice" class="form-control" />
				         </div>
			        	<div class="form-group">
				            <label class="btn btn-info" style="font-size: 20px">
								<form:input id="productImage" path="productImage" type='file' style="display:none;" />
								<i class="fa fa-photo"></i> 上傳圖片
							</label>
							<img id="foodImgUp" height='100' width='80' src="">
				         </div>
			        </div>
			        <!-- Modal footer (結尾)-->
			        <div class="modal-footer">
			        	<form:input name="upfoodId" type="hidden" id="upfoodId" path="foodId" />
						<input style="font-size: 20px" type="button" id="UpFood" class="btn btn-primary" data-dismiss="modal" onclick="UpFoodAjax()" value="修改" />
						<input style="font-size: 20px" type="button" id="AddFood_modal" class="btn btn-primary" data-dismiss="modal" value="新增" onclick="AddFoodAjax()" />
						<input style="font-size: 20px" type="button" class="btn btn-danger" data-dismiss="modal" value="取消">					
			        </div>
			    
			    </div>
		    </div>
		</div>
		</form:form>
	</div></div>
	</div></div></div></div></div></div>
</body>
</html>