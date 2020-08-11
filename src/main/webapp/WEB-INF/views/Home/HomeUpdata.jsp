<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Insert title here</title>
<style type="text/css">
h1 {
	text-align: center;
	font-size: 60px;
}

h2 {
	text-align: center;
	color: blue font-size: 60px;
}
</style>
</head>
<script type="text/javascript">
//圖片
$(document).ready(function() {
	$('#productImage').change(function() {//圖片預覽
		  var file = $('#productImage')[0].files[0];
		  var reader = new FileReader;
		  reader.onload = function(e) {
		    $('#homeImgUp').attr('src', e.target.result);
		    $("#homeImgUp").show();
		  };
		  reader.readAsDataURL(file);
		});
})
function HomeDelete(Name,Id) {
	if (confirm("確定刪除此項圖片資料(電影:"+Name+")?") ) {
		document.forms[0].action="HomeDelete?HomeId="+Id+"";
		document.forms[0].method="POST";
		document.forms[0].submit(); 
	} else {
	}
}
function HomeUpdate(homeId,homeImg,homeName) {	
   $("#updata").hide();
   $("input[name='homeName']").val(homeName);
   $("#homeImgUp").attr("src", ''+homeImg+'');
   $("input[name='homeId']").val(homeId);
   $("#updata").show();
}
function HomeIn() {	
	   $("#homeIn").hide();
	   $("#homeIn").show();
	}
function UpdataCancel() {
	$("#updata").hide();
}
//預告
function HomeVdDelete(Name,Id) {
	if (confirm("確定刪除此項圖片資料(電影:"+Name+")?") ) {
		document.forms[0].action="HomeVdDelete?HomeId="+Id+"";
		document.forms[0].method="POST";
		document.forms[0].submit(); 
	} else {
	}
}
function HomeVdUpdate(homeId,homeImg,homeName) {	
   $("#updata").hide();
   $("input[name='homeName']").val(homeName);
   $("#homeVedioUp").attr("src", ''+homeImg+'');
   $("input[name='homeId']").val(homeId);
   $("#updata").show();
}
function HomeVdIn() {	
	   $("#homeVdIn").hide();
	   $("#homeVdIn").show();
	}
function UpdataCancel() {
	$("#updata").hide();
}
</script>

<body class="bg-theme bg-theme1">
	<c:set var="funcName" value="Home" scope="session" />
	<div id="wrapper">
		<jsp:include page="../Manager/Manager.jsp" />
		<div class="clearfix"></div>
		<div class="content-wrapper">
			<div class="container-fluid">
				<div id='c3' class="clearfix">
					<div class="row">
						<div class="col-12 col-lg-12">
							<div class="card">
								<div class="card-header">
									<h1>熱門電影維護</h1>
									<input type="button" value="新增" data-toggle="modal"
										data-target="#HomeModal" onclick="HomeIn()">
									<form id="form1" name="form1" method="post" action="">
										<div class="table-responsive">
											<table
												class="table align-items-center table-flush table-borderless">
												<thead>
													<tr>
														<th>圖片</th>
														<th>影片名稱</th>
														<th>修改/刪除</th>
													</tr>
												</thead>
												<c:forEach var="home" items="${homeImg}">
													<tr>
														<td><img height='100' width='80'
															src='<c:url value="/getHomeImg/${home.homeId}" />'>
														</td>
														<td>${home.homeName}</td>
														<td><input name="homeId" type="hidden" id="homeId"
															value="${home.homeId}" /> <input type="button"
															value="修改" data-toggle="modal" data-target="#HomeModalUp"
															id="updata${home.homeId}"
															onclick="HomeUpdate('${home.homeId}','<c:url value="/getHomeImg/${home.homeId}" />','${home.homeName}')">
															<input type="button" value="刪除" id="delet${home.homeId}"
															onclick="HomeDelete('${home.homeName}',${home.homeId})">
														</td>
													</tr>
												</c:forEach>
											</table>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="overlay toggle-menu"></div>
			</div>
		</div>
		<form method='POST' action="HomeUp" enctype='multipart/form-data'>
			<div class="modal" id="HomeModalUp">
				<div class="modal-dialog">
					<div class="modal-content"
						style="background-image: url(assets/images/bg-themes/1.png);">
						Modal (開啟)
						<table id="updata" style="display: none">
							<tr>
								<td>圖片名稱：</td>
								<td><input id="homeName" path="homeName" name="homeName"
									type='text' /></td>
							</tr>
							<tr>
								<td>選擇圖片：</td>
								<td><img id="homeImgUp" height='100' width='80' src="">
									<input name="productImage" path="productImage" type='file' /></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="hidden"
									id="homeId" path="homeId" name="homeId" /> <input
									type="submit" name="intor" value="修改"> <input
									type="button" onclick="UpdataCancel()" value="取消"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</form>
		<form method='POST' action="HomeIn" enctype='multipart/form-data'>
			<div class="modal" id="HomeModal">
				<div class="modal-dialog">
					<div class="modal-content"
						style="background-image: url(assets/images/bg-themes/1.png);">
						Modal (開啟)
						<table id='homeIn' style="display: none">
							<tr>
								<td>圖片名稱：</td>
								<td><input id="homeName" path="homeName" name="homeName"
									type='text' /></td>
							</tr>
							<tr>
								<td>選擇圖片：</td>
								<td><input id="productImage" name="productImage"
									path="productImage" type='file' /></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="hidden"
									id="homeId" path="homeId" name="homeId" /> <input
									type="submit" name="intor" value="新增"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</form>
		<div class="content-wrapper">
			<div class="container-fluid">
				<div id='c3' class="clearfix">
					<div class="row">
						<div class="col-12 col-lg-12">
							<div class="card">
								<div class="card-header">
									<h1>預告片維護</h1>
									<input type="button" value="新增" data-toggle="modal"
										data-target="#HomeModalVd" onclick="HomeVdIn()">
									<form id="form1" name="form1" method="post" action="">
										<div class="table-responsive">
											<table
												class="table align-items-center table-flush table-borderless">
												<thead>
													<tr>
														<th>影片</th>
														<th>影片名稱</th>
														<th>刪除</th>
													</tr>
												</thead>
												<c:forEach var="home" items="${homeVedio}">
													<tr>
														<td><video height='100' width='100'
																src='<c:url value="/getHomeVd/${home.homeId}" />'></td>
														<td>${home.homeName}</td>
														<td>
<!-- 														<input name="homeId" type="hidden" id="homeId" -->
<%-- 															value="${home.homeId}" /> <input type="button" --%>
<!-- 															value="修改" data-toggle="modal" -->
<%-- 															data-target="#HomeModalVdUp" id="updata${home.homeId}" --%>
<%-- 															onclick="HomeVdUpdate('${home.homeId}',<c:url value="/getHomeVd/${home.homeId}" />','${home.homeName}')"> --%>
															<input type="button" value="刪除" id="delet${home.homeId}"
															onclick="HomeVdDelete('${home.homeName}',${home.homeId})">
														</td>
													</tr>
												</c:forEach>
											</table>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="overlay toggle-menu"></div>
			</div>
		</div>
		<form method='POST' action="HomeVdIn" enctype='multipart/form-data'>
			<div class="modal" id="HomeModalVd">
				<div class="modal-dialog">
					<div class="modal-content"
						style="background-image: url(assets/images/bg-themes/1.png);">

						<table id='homeVdIn' style="display: none">
							<tr>
								<td>影片名稱：</td>
								<td><input id="homeName" path="homeName" name="homeName"
									type='text' /></td>
							</tr>
							<tr>
								<td>選擇影片：</td>
								<td><input id="productImage" path="productImage"
									name="productImage" type='file' /></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="hidden"
									id="homeId" path="homeId" name="homeId" /> <input
									type="submit" name="intor" value="新增"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>

</html>