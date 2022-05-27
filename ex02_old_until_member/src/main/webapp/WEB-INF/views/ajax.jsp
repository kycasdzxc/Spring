<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>data오후 12:34:39</title>
<script src="/resources/assets/vendor/jquery/jquery.min.js"></script>
<script>
$(function() {
	$("#btnAjaxText").on("click", function() {
		console.log("call text")
		$.ajax("/sample/getText").done(function(result) {
			console.log(result)
		});
	});
	$("#btnAjaxSample").on("click", function() {
		console.log("call sample")
		/* $.ajax("/sample/getSample").done(function(result) {
			console.log(result)
		}); */
		$.ajax({
			url : "/sample/getSample",
			dataType : "json",
			success : function(result) {
				console.log(result)
			}
		})
	});
})
</script>
</head>
<body>
	<button id="btnAjaxText">ajax text call</button>
	<button id="btnAjaxSample">ajax sample call</button>
</body>
</html>