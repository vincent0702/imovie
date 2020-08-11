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
	<h1>新增包廂測試</h1>
<!-- 	enctype='multipart/form-data' -->
		<form:form method='POST' modelAttribute="roomBean" enctype='multipart/form-data'>
			<table>
				<tr>
					<td>包廂名字：</td>
					<td>
						<form:input id="roomName" path="roomName" type='text' />
					</td>
				</tr>
				<tr>
					<td>包廂大小：</td>
					<td><form:input id="roomSize" path="roomSize" type='text' /></td>
				</tr>
				<tr>
					<td>包廂說明：</td>
					<td><form:input id="roomNote" path="roomNote" type='text' /></td>
				</tr>
				<tr>
					<td>包廂價錢：</td>
					<td><form:input id="roomPrice" path="roomPrice" type='number' /></td>
				</tr>
				<tr>
					<td>選擇圖片：</td>
					<td>
						<form:input id="productImage" path="productImage" type='file' />
					</td>
					
<!-- 					<td>選擇圖片：</td> -->
<!-- 					<td><input type="file" name="roomImg"></td> -->
				</tr>
				<tr>
					<td align="center"><input type="submit" name="intor" value="送出"></td>
					<td align="center"><input type="button" value="修改/刪除 測試" onclick="javascript:location.href='Room'"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>