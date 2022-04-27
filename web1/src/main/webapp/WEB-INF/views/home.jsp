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
	age : <%=request.getParameter("age") %>
</div>
<div>
	<!-- el로 값을 가져옴 영역객체로 담거나 session,request로 담음 -->
	<!-- session 객체에 담는 방식 (1회성) / 계속 페이지마다 유지하지는 않음 (입력성공,입력실패 등의 작업에서 사용)-->
	num : ${num} 
</div>
<div>
	<%-- 모든 요청은 컨트롤러로 가야 함 --%>
	<%-- requestMapping걸었던 주소를 걸어야함 / 컨트롤러 주소를 걸어줌 --%>
	<p><a href="/calc/add">add</a></p>
</div>
</body>
</html>
