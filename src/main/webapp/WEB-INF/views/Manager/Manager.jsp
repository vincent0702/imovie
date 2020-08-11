<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<head>
		<meta charset="UTF-8">
		<title>後端</title>
		<meta charset="utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
		<meta name="description" content=""/>
		<meta name="author" content=""/>
		<!-- loader-->
		<link href="assets/css/pace.min.css" rel="stylesheet"/>
		<script src="assets/js/pace.min.js"></script>
		<!--favicon-->
		<link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">
		<!-- simplebar CSS-->
		<link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>
		<!-- Bootstrap core CSS-->
		<link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
		<!-- animate CSS-->
		<link href="assets/css/animate.css" rel="stylesheet" type="text/css"/>
		<!-- Icons CSS-->
		<link href="assets/css/icons.css" rel="stylesheet" type="text/css"/>
		<!-- Sidebar CSS-->
		<link href="assets/css/sidebar-menu.css" rel="stylesheet"/>
		<!-- Custom Style-->
		<link href="assets/css/app-style.css" rel="stylesheet"/>
		
	</head>
		<!-- Start wrapper-->
<!-- 		 <div id="wrapper"> -->
		 
		  <!--Start sidebar-wrapper-->
		   <div id="sidebar-wrapper" data-simplebar="" data-simplebar-auto-hide="true">
		     <div class="brand-logo">
		      <a href="Manager">
		       <img src="assets/images/logo-icon.png" class="logo-icon" alt="logo icon">
		       <h5 class="logo-text">Imovie後端控制台</h5>
		     </a>
		   </div>
		   <ul class="sidebar-menu do-nicescrol">
		      <li class="sidebar-header" style="font-size: 20px">管理項目</li>
		      <c:if test="${ funcName == 'index' }">
			  		<li class="active">
				        <a>
				          <i style="font-size: 20px" class="zmdi zmdi-view-dashboard"></i> <span style="font-size: 20px">首頁</span>
				        </a>
				    </li>
			   </c:if>
			  <c:if test="${ funcName != 'index' }">
			  		<li>
				        <a href="Manager">
				          <i style="font-size: 20px" class="zmdi zmdi-view-dashboard"></i> <span style="font-size: 20px">首頁</span>
				        </a>
				    </li>
			   </c:if>
			   <c:if test="${ funcName == 'Home' }">
			  		<li class="active">
				        <a>
				          <i class="zmdi zmdi-invert-colors" style="font-size: 20px"></i> <span style="font-size: 20px">前端首頁維護</span>
				        </a>
				    </li>
			   </c:if>
			  <c:if test="${ funcName != 'Home' }">
			  		<li>
				        <a href="Home">
				          <i class="zmdi zmdi-invert-colors" style="font-size: 20px"></i> <span style="font-size: 20px">前端首頁維護</span>
				        </a>
				    </li>
			   </c:if>
			  <c:if test="${ funcName == 'Room' }">
			  		<li class="active">
				        <a>
				          <i class="zmdi zmdi-format-list-bulleted" style="font-size: 20px"></i> <span style="font-size: 20px">前端包廂維護</span>
				        </a>
				    </li>
			   </c:if>
			  <c:if test="${ funcName != 'Room' }">
			  		<li>
				        <a href="Room">
				          <i class="zmdi zmdi-format-list-bulleted" style="font-size: 20px"></i> <span style="font-size: 20px">前端包廂維護</span>
				        </a>
				    </li>
			   </c:if>
			  <c:if test="${ funcName == 'Movie' }">
			  		<li class="active">
				        <a>
				          <i class="zmdi zmdi-grid" style="font-size: 20px"></i> <span style="font-size: 20px">前端電影維護</span>
				        </a>
				    </li>
			  </c:if>
			  <c:if test="${ funcName != 'Movie' }">
			  		<li>
				        <a href="Movie">
				          <i class="zmdi zmdi-grid" style="font-size: 20px"></i> <span style="font-size: 20px">前端電影維護</span>
				        </a>
				    </li>
			  </c:if>
			  <c:if test="${ funcName == 'Food' }">
			  		<li class="active">
				        <a>
				          <i class="zmdi zmdi-calendar-check" style="font-size: 20px"></i> <span style="font-size: 20px">前端菜單維護</span>
				        </a>
				    </li>
			   </c:if>
			  <c:if test="${ funcName != 'Food' }">
			  		<li>
				        <a href="Food">
				          <i class="zmdi zmdi-calendar-check" style="font-size: 20px"></i> <span style="font-size: 20px">前端菜單維護</span>
				        </a>
				    </li>
			   </c:if>
		      
		
<!-- 		      <li> -->
<!-- 		        <a href="MemberList"> -->
<!-- 		          <i class="zmdi zmdi-face"></i> <span>客戶清單維護</span> -->
<!-- 		        </a> -->
<!-- 		      </li> -->
			  <c:if test="${ funcName == 'MemberList' }">
			  		<li class="active">
				        <a>
				          	<i class="zmdi zmdi-lock" style="font-size: 20px"></i> <span style="font-size: 20px">會員資料維護</span>
				        </a>
				    </li>
			   </c:if>
			  <c:if test="${ funcName != 'MemberList' }">
			  		<li>
				        <a href="MemberList">
				          	<i class="zmdi zmdi-lock" style="font-size: 20px"></i> <span style="font-size: 20px">會員資料維護</span>
				        </a>
				    </li>
			   </c:if>
		      
		
<!-- 		       <li> -->
<!-- 		        <a href="login.html" target="_blank"> -->
<!-- 		          <i class="zmdi zmdi-account-circle"></i> <span>Registration</span> -->
<!-- 		        </a> -->
<!-- 		      </li> -->
		    </ul>  
		   </div>
		   <!--End sidebar-wrapper-->
		
		<!--Start topbar header-->
		<header class="topbar-nav">
		 <nav class="navbar navbar-expand fixed-top">
		  <ul class="navbar-nav mr-auto align-items-center">
		    <li class="nav-item">
		      <a class="nav-link toggle-menu" href="javascript:void();">
		       <i id="wdithChane" onclick="wdithChane()" class="icon-menu menu-icon"></i>
		     </a>
		    </li>
		    <li class="nav-item">
		      <form class="search-bar">
		        <input id="Search" type="text" class="form-control" placeholder="Enter keywords" data-table="order-table">
		         <a href="javascript:void();"><i class="icon-magnifier"></i></a>
		      </form>
		    </li>
		  </ul>
		     
		  <ul class="navbar-nav align-items-center right-nav-link">
		    <li class="nav-item">
		      <a class="nav-link dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown" href="#">
		        <span class="user-profile"><img src="https://via.placeholder.com/110x110" class="img-circle" alt="user avatar"></span>
		      </a>
		      <ul class="dropdown-menu dropdown-menu-right">
		       <li class="dropdown-item user-details">
		        <a href="javaScript:void();">
		           <div class="media">
		             <div class="avatar"><img class="align-self-start mr-3" src="https://via.placeholder.com/110x110" alt="user avatar"></div>
		            <div class="media-body">
		            <h6 class="mt-2 user-title">Sarajhon Mccoy</h6>
		            <p class="user-subtitle">mccoy@example.com</p>
		            </div>
		           </div>
		          </a>
		        </li>
		        <li class="dropdown-divider"></li>
		        <li class="dropdown-item"><i class="icon-envelope mr-2"></i> Inbox</li>
		        <li class="dropdown-divider"></li>
		        <li class="dropdown-item"><i class="icon-wallet mr-2"></i> Account</li>
		        <li class="dropdown-divider"></li>
		        <li class="dropdown-item"><i class="icon-settings mr-2"></i> Setting</li>
		        <li class="dropdown-divider"></li>
		        <li class="dropdown-item"><i class="icon-power mr-2"></i> Logout</li>
		      </ul>
		    </li>
		  </ul>
		</nav>
		</header>
		   <div class="right-sidebar">
		    <div class="switcher-icon">
		      <i class="zmdi zmdi-settings zmdi-hc-spin"></i>
		    </div>
		    <div class="right-sidebar-content">
		      <p class="mb-0">Gaussion Texture</p>
		      <hr>
		      <ul class="switcher">
		        <li id="theme1"></li>
		        <li id="theme2"></li>
		        <li id="theme3"></li>
		        <li id="theme4"></li>
		        <li id="theme5"></li>
		        <li id="theme6"></li>
		      </ul>
		
		      <p class="mb-0">Gradient Background</p>
		      <hr>
		      
		      <ul class="switcher">
		        <li id="theme7"></li>
		        <li id="theme8"></li>
		        <li id="theme9"></li>
		        <li id="theme10"></li>
		        <li id="theme11"></li>
		        <li id="theme12"></li>
				<li id="theme13"></li>
		        <li id="theme14"></li>
		        <li id="theme15"></li>
		      </ul>
		      
		     </div>
		   </div>
		  <!--end color switcher-->
		   
<!-- 		  </div> -->
		  <!--End wrapper-->
		
		  <!-- Bootstrap core JavaScript-->
		  <script src="assets/js/jquery.min.js"></script>
		  <script src="assets/js/popper.min.js"></script>
		  <script src="assets/js/bootstrap.min.js"></script>
			
		 <!-- simplebar js -->
		  <script src="assets/plugins/simplebar/js/simplebar.js"></script>
		  <!-- sidebar-menu js -->
		  <script src="assets/js/sidebar-menu.js"></script>
		  <!-- loader scripts -->
		  <script src="assets/js/jquery.loading-indicator.js"></script>
		  <!-- Custom scripts -->
		  <script src="assets/js/app-script.js"></script>
		  <!-- Chart js -->
		  
		  <script src="assets/plugins/Chart.js/Chart.min.js"></script>
		 
		  <!-- Index js -->
<!-- 		  <script src="assets/js/index.js"></script> -->