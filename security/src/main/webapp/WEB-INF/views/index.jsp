<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/index.css" />
</head>
<body>
<div class="container center-contents">
	<div class="row">
		<h1 class="title display-5">메인 페이지</h1>
	</div>
	
	<!-- 로그인 정보가 없다면 로그인 메뉴 보여주기 -->
	<div class="links">
		<sec:authorize access="!isAuthenticated()">
			<div class="link">
				<a href="/member/register">회원가입</a>
			</div>
		</sec:authorize>

		<sec:authorize access="!isAuthenticated()">
			<div class="link">
				<a href="/login">로그인</a>
			</div>
		</sec:authorize>

		<!-- 로그인 정보가 있는 경우 나머지 메뉴 보여주기 -->
		
		<sec:authorize access="isAuthenticated()">
			<div class="link">
				<a href="/user-page">유저 페이지</a>
			</div>
		</sec:authorize>
		
		
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal" var="info"/>
				<c:if test="${info.username=='admin'}">
					<!-- 인증값이 ROLE_ADMIN 확인 -->
			<div class="link">
				<a href="/admin-page">관리자 페이지</a>
			</div>
			</c:if>
		</sec:authorize>
		
		
		<div class="link">
			<form action="/logout" method="post"> <!-- post방식으로 csrf 토큰 넣기  -->
				<button class="btn btn-info" type="submit">로그아웃</button>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
		</div>
	</div>
</div>
</body>
</html>





