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
	<h1>新增食物測試</h1>
<!-- 	enctype='multipart/form-data' -->
		<form:form method='POST' modelAttribute="foodBean" enctype='multipart/form-data'>
			<table>
				<tr>
					<td>食物名稱：</td>
					<td>
						<form:input path="foodName" type='text' />
					</td>
				</tr>
				<tr>
					<td>食物類型：</td>
					<td>
						<form:checkboxes items="${Genre}" path="foodType"/>	
					</td>
				</tr>
				<tr>
					<td>食物價錢：</td>
					<td><form:input path="foodPrice" type='number' /></td>
				</tr>
				<tr>
					<td>選擇圖片：</td>
					<td>
						<form:input path="productImage" type='file' />
					</td>
				</tr>
				<tr>
					<td align="center"><input type="submit" name="intor" value="送出"></td>
					<td align="center"><input type="button" value="修改/刪除 測試" onclick="javascript:location.href='Food'"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>