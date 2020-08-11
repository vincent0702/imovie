<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=on">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v4.0.1">
<script src="https://www.w3schools.com/lib/w3.js"></script>
<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/carousel/">

<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/main.css' type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/index.css' type="text/css" />
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery.min.js"></script>
</head>

<body>
	<c:set var='debug' value='true' scope='application' />
	<header class='c-header'>
		<div class='c-header__pcInner'>
			<h1 class='c-header__logo'>
				<img src="img/imovieLogo.svg" alt="logo">
			</h1>
			<nav class='c-header__nav'>
				<ul>
					<li class="c-header__nav__about" data-nav='index'><a
						href="<c:url value='/' />" id='js-header-about'>首頁</a>
						<div class='c-header__nav__about__bottom'>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
						</div></li>
					<li class='c-header__nav__event' data-nav='room'><a
						href='room?type=roomall'>包廂</a>
						<div class='c-header__nav__event__bottom'>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
						</div></li>
					<li class='c-header__nav__goods' data-nav='movie'><a
						href="movie?type=movieall">電影</a>
						<div class='c-header__nav__goods__bottom'>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
						</div></li>
					<li class='c-header__nav__magazine' data-nav='menu'><a
						href='menu?type=foodall'>菜單</a>
						<div class='c-header__nav__magazine__bottom'>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
							<div class='c-header__nav__event__bottom__dots'></div>
						</div></li>

<!-- 					<li class=c-header__nav__news data-nav=test><a -->
<!-- 						href='Manager'>TSET</a> -->
<!-- 						<div class=c-header__nav__news__bottom> -->
<!-- 							<div class=c-header__nav__news__bottom__dots></div> -->
<!-- 							<div class=c-header__nav__news__bottom__dots></div> -->
<!-- 							<div class=c-header__nav__news__bottom__dots></div> -->
<!-- 							<div class=c-header__nav__news__bottom__dots></div> -->
<!-- 							<div class=c-header__nav__news__bottom__dots></div> -->
<!-- 							<div class=c-header__nav__news__bottom__dots></div> -->
<!-- 							<div class=c-header__nav__news__bottom__dots></div> -->
<!-- 						</div></li>	 -->
					<c:if test="${!empty LoginOK}">					
						<li class=c-header__nav__issue data-nav=issue><a href="testCart">購物車</a>
						<div class='c-header__nav__issue__bottom'>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
						</div></li>
						</c:if>
					<c:if test="${!empty LoginOK}">					
						<li class=c-header__nav__issue data-nav=issue><a href='<c:url value='_01_register/mem/${LoginOK.pkey}' />'>${LoginOK.name}的個人資料</a>
						<div class='c-header__nav__issue__bottom'>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
						</div></li>
						</c:if>
						<c:if test="${!empty LoginOK}">					
						<li class=c-header__nav__issue data-nav=issue><a href='allmyorder' />我的歷史訂單</a>
						<div class='c-header__nav__issue__bottom'>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
							<div class='c-header__nav__issue__bottom__dots'></div>
						</div></li>
						</c:if>
				</ul>
			</nav>
		<c:if test="${empty LoginOK}">
			<div class=c-header__contact>
				<div class=c-header__contact__inner>
					<a href='<c:url value='_02_login/login' />' class="c-header__contact__btn js-contact-toggle"> <span
						class=c-header__contact__btn__icon> <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
	 viewBox="0 0 112.26 112.26" style="enable-background:new 0 0 112.26 112.26;" xml:space="preserve" fill="white">
<g>
	<circle cx="56.133" cy="29.608" r="29.608"/>
	<path d="M73.043,63.368c-5.045,2.71-10.797,4.266-16.911,4.312c-6.114-0.046-11.87-1.602-16.914-4.312
		c-10.413,9.325-26.29,19.712-26.29,48.892h42.92h0.564h42.92C99.334,83.08,83.458,72.693,73.043,63.368z"/>
</g>
</svg>
					</span> <span class='c-header__contact__btn__txtOpen'>
					<span class="c-header__contact__btn__txtOpen_login">登入</span>
							/
					 <span class="c-header__contact__btn__txtOpen_registered">註冊</span>
				  </span>
						<div class='c-header__contact__btn__line1'></div>
						<div class='c-header__contact__btn__line2'></div>
					</a>
					<svg id='contactBtn.svg' xmlns='http://www.w3.org/2000/svg'
						width='126.04' height='67.5' viewBox="0 0 126.04 67.5">
                    <defs>
                        <style>
.contact-frame-200 {
	fill-rule: evenodd;
	opacity: 0.3;
	fill-opacity: 0
}

.contact-frame-200 {
	fill: #fff;
	stroke: #fff;
	stroke-width: 1px
}
</style>
                    </defs>
                    <path id='out_line' class='contact-frame-200'
							d='M1204.34,37.81l5.16-5.022h114.87l5,5.022v24.1l-5,5.021H1209.34l-5-5.021V37.81Z'
							transform='translate(-1203.84)'></path>
                </svg>
				</div>
			</div>
			</c:if>
					<c:if test="${!empty LoginOK}">
			<div class=c-header__contact>
				<div class=c-header__contact__inner>
					<a href='<c:url value='_02_login/logout' />' class="c-header__contact__btn js-contact-toggle"> <span
						class=c-header__contact__btn__icon> <svg version=1.1
								id=Capa_1 xmlns=http://www.w3.org/2000/svg
								xmlns:xlink=http://www.w3.org/1999/xlink x=0px y=0px
								viewBox="-49 262 14 11.3"
								style="enable-background: new -49 262 14 11.3;width:100%;height:100%""
								xml:space=preserve>
                            <path fill=#FFFFFF
									d=M-35,271.6v-7.8c0-0.2-0.1-0.5-0.1-0.7l-3.8,4.3l3.9,4.6C-35,271.9-35,271.7-35,271.6z>
                            </path>
                            <path fill=#FFFFFF
									d=M-47.2,262c-0.2,0-0.4,0-0.5,0.1l5.4,6c0.2,0.2,0.4,0.2,0.6,0l5.4-6c-0.2-0.1-0.3-0.1-0.5-0.1H-47.2z>
                            </path>
                            <path fill=#FFFFFF
									d="M-35.9,273.1l-4-4.8l-1.1,1.2c-0.3,0.3-0.6,0.4-0.9,0.4c-0.4,0-0.7-0.2-0.9-0.4l-1-1.1l-4,4.8
	c0.2,0.1,0.4,0.2,0.6,0.2h10.8C-36.4,273.3-36.1,273.2-35.9,273.1z"></path>
                            <path fill=#FFFFFF
									d=M-49,263.8v7.7c0,0.2,0,0.4,0.1,0.6l3.9-4.6l-3.8-4.3C-48.9,263.4-49,263.6-49,263.8z>
                            </path>
                        </svg>
					</span> <span class='c-header__contact__btn__txtOpen'>登出</span>
						<div class='c-header__contact__btn__line1'></div>
						<div class='c-header__contact__btn__line2'></div>
					</a>
					<svg id='contactBtn.svg' xmlns='http://www.w3.org/2000/svg'
						width='126.04' height='67.5' viewBox="0 0 126.04 67.5">
                    <defs>
                        <style>
.contact-frame-200 {
	fill-rule: evenodd;
	opacity: 0.3;
	fill-opacity: 0
}

.contact-frame-200 {
	fill: #fff;
	stroke: #fff;
	stroke-width: 1px
}
</style>
                    </defs>
                    <path id='out_line' class='contact-frame-200'
							d='M1204.34,37.81l5.16-5.022h114.87l5,5.022v24.1l-5,5.021H1209.34l-5-5.021V37.81Z'
							transform='translate(-1203.84)'></path>
                </svg>
				</div>
			</div>
			</c:if>
		</div>
	</header>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script>
	</script>
	<script src="js/bootstrap.bundle.js"></script>

	<script type="text/javascript">
	var path =location.pathname !== '/ImovieS/'? location.pathname.replace("/ImovieS/",""):'index';
	$('li').removeClass("is-current"); 
	$(`li[data-nav=${'${path}'}]`).addClass("is-current"); 
	</script>


</body>
</html>