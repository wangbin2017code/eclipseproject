<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Landing Page</title>
</head>
<body>
	<h2>Spring Landing Page</h2>
	<p>点击下面的按钮获得一个简单的HTML页面</p>
	
	<form:form method="GET" action="pageUrl">
		<table>
			<tr>
				<td>
					<input type="submit" value="获取HTML页面">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>