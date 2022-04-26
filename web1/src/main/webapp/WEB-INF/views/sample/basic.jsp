<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>basic</h1>
<div>
<%-- 
	경로를 시작할 때 /로 시작한다는 의미는
	http://localhost:9090/ 뒤에서 주소를 붙여나감
	
	/ 없이 시작하면 현재 주소에서 뒷부분만 변경한다는 의미
	
	현재주소 http://localhost:9090/sample/basic
	
	doA : http://localhost:9090/sample/doA
	
 --%>
	<%-- 모든 요청은 컨트롤러로 가야 함 --%>
	<%-- requestMapping걸었던 주소를 걸어야함 / 컨트롤러 주소를 걸어줌 --%>
	<p><a href="/">home</a></p> <!-- a href = get방식 -->
	<p><a href="doA">doA</a></p> <%-- /sample/doA --%>
	<p><a href="login">login</a></p> <%-- /sample/login --%>
	<p><a href="insert">insert</a></p> <%-- /sample/insert --%>
</div>
</body>
</html>