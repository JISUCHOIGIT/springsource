<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- action을 아무것도 주지 않으면 현재 경로  http://localhost:9090/sample/login -->
<form action="" method="post">
	<div>
		<%-- 	이름을 지정하지 않았을 때

		<input type="text" name="num1" id="num1" size="5" value="${numDTO.num1}"/> + <!-- ${numDTO.num1} el -->
		<input type="text" name="num2" id="num2" size="5" value="${numDTO.num2}"/> = --%>
		
		<input type="text" name="num1" id="num1" size="5" value="${dto.num1}"/> + <!-- addcontroller @modelAttribute("dto") 지정 = dto.num1 -->
		<input type="text" name="num2" id="num2" size="5" value="${dto.num2}"/> =
		<input type="text" name="result" id="result" size="5" value="${result}"/>
		<button type="submit">전송</button>
	</div>
</form>
</body>
</html>