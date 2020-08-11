<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>帳號清單</title>
</head>
<body class="bg-theme bg-theme1">

		<c:set var="funcName" value="MemberList" scope="session"/>
		<div id="wrapper">
			<jsp:include page="../Manager/Manager.jsp" />
			<div class="content-wrapper">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12 col-lg-12">
							<div class="card">
								<div class="card-body" align="center">
								<h1 style="display:inline">會員清單</h1>
								<div class="table-responsive">
<!-- 								搜尋：<input id="AAA" type="search" class="BBB"  placeholder="請輸入關鍵字"> -->
									<table id="MemberTable" class="order-table table" >
										<thead>
										<tr>
											<th>會員圖片</th>
											<th>會員帳號</th>
											<th>會員名稱</th>
<!-- 											<th>會員性別</th> -->
<!-- 											<th>會員年齡</th> -->
											<th>會員Email</th>
											<th>聯絡電話</th>
											<th>註冊時間</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="member" items="${member}">
										<tr>
											<td>
											<img height='100' width='80' src='${pageContext.request.contextPath}/_00_init/getMemberImage?id=${member.value.memberId}'>
											</td>
											<td>${member.value.memberId}</td>
											<td>${member.value.name}</td>
<%-- 											<td>${member.value.gender}</td> --%>
<%-- 											<td>${member.value.birth}</td> --%>
											<td>${member.value.email}</td>
											<td>${member.value.tel}</td>
											<td>${member.value.registerTime}</td>
										</tr>
										</c:forEach>
										</tbody>
									</table>
			
			</div></div></div></div></div></div></div>
		</div>
		<script>
(function(document) {
	  'use strict';

	  // 建立 LightTableFilter
	  var LightTableFilter = (function(Arr) {

	    var _input;

	    // 資料輸入事件處理函數
	    function _onInputEvent(e) {
	      _input = e.target;
	      var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
	      Arr.forEach.call(tables, function(table) {
	        Arr.forEach.call(table.tBodies, function(tbody) {
	          Arr.forEach.call(tbody.rows, _filter);
	        });
	      });
	    }

	    // 資料篩選函數，顯示包含關鍵字的列，其餘隱藏
	    function _filter(row) {
	      var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
	      row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
	    }

	    return {
	      // 初始化函數
	      init: function() {
	        var inputs = document.getElementsByClassName('form-control');
	        //var inputs = document.getElementById("form-control");
	        Arr.forEach.call(inputs, function(input) {
	          input.oninput = _onInputEvent;
	        });
	      }
	    };
	  })(Array.prototype);

	  // 網頁載入完成後，啟動 LightTableFilter
	  document.addEventListener('readystatechange', function() {
	    if (document.readyState === 'complete') {
	      LightTableFilter.init();
	    }
	  });

	})(document);
</script>
</body>
</html>