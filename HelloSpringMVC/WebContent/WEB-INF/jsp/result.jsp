<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springmvc-form</title>
</head>
<body>
	<h1>提交的信息如下:</h1>
	
	<table>
		<tr>
			<td>名字:</td>
			<td>${name }</td>
		</tr>
		<tr>
			<td>年龄:</td>
			<td>${age }</td>
		</tr>
		<tr>
			<td>编号:</td>
			<td>${id }</td>
		</tr>
	</table>
</body>
</html>