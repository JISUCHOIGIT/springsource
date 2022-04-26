<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<div>
	<%-- 모든 요청은 컨트롤러로 가야 함 --%>
	<%-- requestMapping걸었던 주소를 걸어야함 / 컨트롤러 주소를 걸어줌 --%>
	<p><a href="/board/insert">board insert</a></p>
	<p><a href="/board/modify">board modify</a></p>
	<p><a href="/board/read">board read</a></p>
	<p><a href="/board/list">board list</a></p>
</div>
</body>
</html>
