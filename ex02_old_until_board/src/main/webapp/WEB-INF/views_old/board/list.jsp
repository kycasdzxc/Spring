<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
})

</script>
</head>
<body>
	<h1>List Page</h1>
	<a href="register${page.cri.params}">글 작성</a>
	<form>
		<input type="hidden" name="pageNum" value="1">
		<input type="hidden" name="amount" value="${page.cri.amount}">
		<select name="type">
			<option value="T" ${page.cri.type == 'T' ? 'selected' : ''}>제목</option>
			<option value="C" ${page.cri.type == 'C' ? 'selected' : ''}>내용</option>
			<option value="W" ${page.cri.type == 'W' ? 'selected' : ''}>작성자</option>
			<option value="TC" ${page.cri.type == 'TC' ? 'selected' : ''}>제목 + 내용</option>
			<option value="CW" ${page.cri.type == 'CW' ? 'selected' : ''}>내용 + 작성자</option>
			<option value="WT" ${page.cri.type == 'WT' ? 'selected' : ''}>제목 + 작성자</option>
			<option value="TWC" ${page.cri.type == 'TWC' ? 'selected' : ''}>제목 + 내용 + 작성자</option>
		</select>
		<%-- <label><input type="checkbox" name="typeArr" value="T" ${fn:contains(page.cri.type, 'T') ? 'checked' : ''}>제목</label>
		<label><input type="checkbox" name="typeArr" value="C" ${fn:contains(page.cri.type, 'C') ? 'checked' : ''}>내용</label>
		<label><input type="checkbox" name="typeArr" value="W" ${fn:contains(page.cri.type, 'W') ? 'checked' : ''}>작성자</label> --%>
		<input name="keyword" value="${page.cri.keyword}">
		<button>검색</button>
	</form>
	<table border="1">
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
			<td><a href="get${page.cri.params}&bno=${b.bno}">${b.title}</a></td>
			<td>${b.writer}</td>
			<td>${b.regDate}</td>
			<td>${b.updateDate}</td>
		</tr>
		</c:forEach>
	</table>
	<ul class="pagination justify-content-center">
	<c:if test="${page.prev}">
		<li class="page-item"><a class="page-link" href="list${page.cri.paramWithoutPageNum}&pageNum=${page.start-1}">prev</a></li>
	</c:if>
	<c:forEach begin="${page.start}" end="${page.end}" var="p">
		<li class="page-item ${page.cri.pageNum == p ? 'active' : ''}"><a class="page-link" href="list${page.cri.paramWithoutPageNum}&pageNum=${p}">${p}</a></li>
	</c:forEach>
	<c:if test="${page.next}">
		<li class="page-item"><a class="page-link" href="list${page.cri.paramWithoutPageNum}&pageNum=${page.end+1}">next</a></li>
	</c:if>
	</ul>
</body>
</html>