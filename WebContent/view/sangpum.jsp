<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상품자료뽀ㅃ끼ㅃ끼ㅗㅃ끼ㅗㅃ끼뽂삐꼬삐꼬삐꼬삒삐고삐
<table border="1">
	<tr><th>코드</th><th>상</th><th>수</th><th>단</th></tr>
	<c:forEach var="v" items="${data }">
	<tr>
		<td>${v.code }</td>
		<td>${v.sang }</td>
		<td>${v.su }</td>
		<td>${v.dan }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>