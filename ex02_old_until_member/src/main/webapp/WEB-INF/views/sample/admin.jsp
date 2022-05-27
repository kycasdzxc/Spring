<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>data오전 11:40:38</title>
</head>
<body>
<h1>sample/admin</h1>
<p><a href="all">all</a></p>
<p><a href="member">member</a></p>
<form action="/logout" method="post">
<security:csrfInput/>
<button>logout</button>
<hr>
<security:authentication property="principal" var="p" />
<hr>
${p}
<hr>
${p.username}
<hr>
${p.password}
<hr>
${p.enabled}
<hr>
${p.authorities}
<hr>
${p.member}
<hr>
<security:authentication property="principal.member.username"/>
<hr>
</form>
</body>
</html>