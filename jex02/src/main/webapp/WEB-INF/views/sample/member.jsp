<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>data오전 11:40:23</title>
</head>
<body>
<h1>sample/member</h1>
<p><a href="all">all</a></p>
<p><a href="admin">admin</a></p>
<form action="/logout" method="post">
<security:csrfInput/>
<button>logout</button>
</form>
</body>
</html>