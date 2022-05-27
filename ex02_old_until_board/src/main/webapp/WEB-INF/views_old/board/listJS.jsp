<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>data오후 12:10:23</title>
<link rel="shortcut icon" href="/resources/favicon.ico" type="image/x-icon">
<link rel="icon" href="/resources/favicon.ico" type="image/x-icon">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
/* $(documemt).ready(function() {
	
})

$().ready(function() {
	
}) 다 같은 코드임 */

$(function() {
	var result = '${result}'; // datatype
	check(result);
	function check(result) {
		if(!result || history.state) return;		
		
		if(parseInt(result) > 0) {
			alert(result + "번 게시글이 작성되었습니다.");
		}
	}
	history.replaceState({}, null, null);
	
	$(".pagenation a").click(function() {
		event.preventDefault();
		
		$("#actionForm")
		.attr("action", "list")
			.find("[name='pageNum']").val($(this).attr("href"))
		.end().submit();
	})
	
	$(".tbl-board-list a").click(function() {
		event.preventDefault();
		/* var bno = $(this).attr("href");
		$("#actionForm")
		.attr("action", "get")
		.html(function(i, origin) {
			if($(this).children("[name='bno']").val()) {
				$(this).find("[name='bno']").val(bno);
				return $(this).html();
			}
			else {
				return origin + "<input type='hidden' name='bno' value='" + bno + "'>"
			}
		})
		.submit(); */
		
		// simple
		location.href = 'get?' + $("#actionForm").serialize() + "&bno=" + $(this).attr("href");
	})
})

</script>
</head>
<body>
	<h1>List Page (JS Ver)</h1>
	<a href="register">글 작성</a>
	<table border="1" class="tbl-board-list">
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>writer</th>
			<th>regDate</th>
			<th>updateDate</th>
		</tr>
		<c:forEach items="${boards}" var="b">
		<tr>
			<td>${b.bno}</td>
			<td><a href="${b.bno}">${b.title}</a></td>
			<td>${b.writer}</td>
			<td>${b.regDate}</td>
			<td>${b.updateDate}</td>
		</tr>
		</c:forEach>
	</table>
	<form id="actionForm">
		<input type="hidden" name="pageNum" value="${page.cri.pageNum}">
		<input type="hidden" name="amount" value="${page.cri.amount}">
	</form>
	<div class="pagenation">
		<c:if test="${page.prev}">
			<a href="${page.start-1}">prev</a>
		</c:if>
		<c:forEach begin="${page.start}" end="${page.end}" var="p">
			<a href="${p}">${p}</a>
		</c:forEach>
		<c:if test="${page.next}">
			<a href="${page.end+1}">next</a>
		</c:if>
	</div>
</body>
</html>