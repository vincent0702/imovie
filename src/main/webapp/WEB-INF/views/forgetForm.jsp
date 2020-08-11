<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/login.css' type="text/css" />
	<style>
	.error{
	color:red;
	font-size:30px;
}
	.abc{
float:left;
}</style>
</head>
<body>

        <div class="container">
           
            <header>
                <h1>IMovie會員登入系統</h1>
				
            </header>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
							<form:form method="POST" modelAttribute="memberBean">
                                <h1>忘記密碼</h1> 
                                <p> 
                                    <label for="username" class="uname" > Email</label>
                                    <form:input path="email" id="email" name="email" required="required" type="text" placeholder="請輸入您的email"/>
                                </p>
                                <p> 
                                    <label for="tel" class="tel"> tel </label>
                                    <form:input  path="tel" id="tel" name="tel" required="required" type="text" placeholder="請輸入您的電話" /> 
                                </p>
                                
							<p class="signin button">
								<input type="submit" value="送出" />${error}
							</p>
							
                                <p class="change_link">
                                	<a href=<c:url value='/' /> class='abc'>回首頁</a>
									<a href="<c:url value='/_02_login/login' />" class="to_register"> 回到登入畫面 </a>
								</p>
                            </form:form>
                        </div>

						
                    </div>
                </div>  
            </section>
        </div>
</body>
</html>