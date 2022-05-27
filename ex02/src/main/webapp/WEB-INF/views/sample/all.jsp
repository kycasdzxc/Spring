<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>data오전 11:40:48</title>
</head>
<body>
<h1>sample/all</h1>
<p><a href="member">member</a></p>
<p><a href="admin">admin</a></p>

<sec:authentication property="principal" var="p" />
<h2>principal : ${p}</h2>
<h2>principal : ${p == 'anonymousUser'}</h2>
<%-- <h2>principal.member : ${p.member}</h2> --%>
<sec:authorize access="isAnonymous()">
	<h3>비 로그인</h3>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<h3>로그인</h3>
	<sec:authorize access="hasRole('ROLE_ADMIN') and hasRole('ROLE_MEMBER')">
		<h3>관리자</h3>
	</sec:authorize>
</sec:authorize>
<sec:authorize access="isFullyAuthenticated()">
	<h3>remember-me가 아님</h3>
</sec:authorize>
</body>
</html>