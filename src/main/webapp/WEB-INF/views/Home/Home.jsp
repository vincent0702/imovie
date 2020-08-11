<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	
		<h1>新增首頁圖片</h1>
		<jsp:include page="../Manager/Manager.jsp" />
		<form:form method='POST' modelAttribute="homeBean"
			enctype='multipart/form-data'>
			<table style='border: 1px solid; padding-top: 10px;'>
				<tr>
					<td>圖片名稱：</td>
					<td><form:input path="homeName" type='text' /></td>
				</tr>
				<tr>
					<td>選擇圖片：</td>
					<td><form:input path="productImage" type='file' /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" name="intor"
						value="送出"></td>
					<td align="center"><input type="button" value="修改/刪除 測試"
						onclick="javascript:location.href='Home'"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>