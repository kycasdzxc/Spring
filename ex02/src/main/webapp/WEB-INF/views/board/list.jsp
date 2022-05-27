<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <jsp:include page="../common/head.jsp"></jsp:include>
</head>

<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
			<jsp:include page="../common/nav.jsp"/>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 text-gray-800 mb-4">Board List Page</h1>
                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary float-left">DataTables Example</h6>
                            <a class="btn btn-primary float-right" href="register${page.cri.params}">글 작성</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
										<th>bno</th>
										<th>title</th>
										<th>writer</th>
										<th>regDate</th>
										<th>updateDate</th>
									</tr>
                                    </thead>
									<c:forEach items="${boards}" var="b">
										<tr>
											<td>${b.bno}</td>
											<td><a href="get${page.cri.params}&bno=${b.bno}">${b.title}</a><span class="small"> [${b.replyCnt}]</span></td>
											<td>${b.writer}</td>
											<td><fmt:formatDate value="${b.regDate}" pattern="yyyy-MM-dd"/></td>
											<td>${b.updateDate}</td>
										</tr>
									</c:forEach>
                                    
                                    <tbody>
                                    </tbody>
                                </table>
                                <ul class="pagination justify-content-center">
                                <c:if test="${page.prev}">
                                <li class="page-item"><a class="page-link" href="list?${page.cri.paramsWithoutPageNum}&pageNum=${page.start-1}">prev</a></li>
                                </c:if>
								<c:forEach begin="${page.start}" end="${page.end}" var="p">
									<li class="page-item ${page.cri.pageNum == p ? 'active' : '' }"><a class="page-link" href="list${page.cri.paramsWithoutPageNum}&pageNum=${p}">${p}</a></li>
								</c:forEach>
								<c:if test="${page.next}">
								<li class="page-item"><a class="page-link" href="list${page.cri.paramsWithoutPageNum}&pageNum=${page.end+1}">next</a></li>
								</c:if>
								</ul>
								
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
			<jsp:include page="../common/footer.jsp" />
        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <script>
    $(function() {
	var result ='${result}';
	check(result);
	function check(result) {
		if(!result || history.state) return;
	
		if(parseInt(result)>0){
			alert(result+"번 게시글이 작성되었습니다.");
		}
		else {
			alert(result + " 처리가 완료되었습니다.");
		}
	}
	history.replaceState({},null,null);
})
    </script>
</body>
</html>