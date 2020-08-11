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
	<h1>新增電影測試</h1>
<!-- 	enctype='multipart/form-data' -->
		<form:form method='POST' modelAttribute="movieBean" enctype='multipart/form-data'>
			<table>
				<tr>
					<td>電影名稱：</td>
					<td>
						<form:input id="movieName" path="movieName" type='text' />
					</td>
				</tr>
				<tr>
					<td>電影名稱(英文)：</td>
					<td><form:input id="movieEName" path="movieEName" type='text' /></td>
				</tr>
				<tr>
					<td>電影說明：</td>
					<td>
<%-- 						<form:input id="movieNote" path="movieNote" type='textarea' /> --%>
						<form:textarea id="movieNote" path="movieNote" />
					</td>
				</tr>
				<tr>
					<td>電影長度：</td>
					<td><form:input id="movieLength" path="movieLength" type='number' /></td>
				</tr>
				<tr>
					<td>電影類型：</td>
					<td>
<%-- 						<form:select path="movieGenre1"> --%>
<%-- 							<form:option value="請選擇電影類型"/> --%>
<%-- 							<form:options items="${GenreList}"/> --%>
<%-- 						</form:select> --%>
						<form:checkboxes items="${GenreList}" path="movieGenre1"/>	
					</td>
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
					<td align="center"><input type="button" value="修改/刪除 測試" onclick="javascript:location.href='Movie'"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>