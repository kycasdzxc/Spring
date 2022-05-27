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
                    <h1 class="h3 text-gray-800 mb-4">Board Register Page</h1>
                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary float-left">DataTables Example</h6>
                        </div>
                        <div class="card-body">
                           <form method="post"">
							  <div class="form-group">
							    <label for="title">title</label>
							    <input type="text" class="form-control" placeholder="title" id="title" name="title">
							  </div>
							  <div class="form-group">
							    <label for="content">content</label>
							    <input type="text" class="form-control" placeholder="content" id="content" name="content">
							  </div>
							  <div class="form-group">
							    <label for="writer">writer</label>
							    <input type="text" class="form-control" placeholder="writer" id="writer" name="writer">
							  </div>

							  <div class="form-group">
							    <label for="attach" class="btn btn-success btn-sm">첨부</label>
							    <input type="file" class="form-control d-none" placeholder="attach" id="attach" name="attach" multiple>
							    <div></div>
							  </div>
							  <button type="submit" class="btn btn-primary">Submit</button>
							</form>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
				
            </div>
            <!-- End of Main Content -->
			<jsp:include page="../common/footer.jsp" />
			<script>
				$(function() {
					$("#attach").change(function() {
						var str = "";
						$(this.files).each(function() {
						str += "<p>" + this.name + "</p>";
						})
						$(this).next().html(str);
					});
				})
			</script>
			
            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->
            
 	<!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-warning" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>
        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->


    <!-- Bootstrap core JavaScript-->
    <script src="/resources/assets/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/assets/js/sb-admin-2.min.js"></script>
    <script>
    $(function() {
		var result ='${result}';
		check(result);
		function check(result) {
			if(!result || history.state) return;
		
			if(parseInt(result)>0){
				alert(result+"번 게시글이 작성되었습니다.");
			}
		}
		history.replaceState({}, null, null);
	})
    </script>
</body>
</html>