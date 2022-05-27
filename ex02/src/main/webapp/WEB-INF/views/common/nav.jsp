<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

	<!-- Topbar -->
	<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
	
		<!-- Topbar Search -->
		<c:if test="${not empty page.cri}">
			<form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search" action="/board/list">
				<div class="input-group">
					<input type="hidden" name="pageNum" value="1">
					<input type="hidden" name="amount" value="${page.cri.amount}">
					<select name="type" class="form-control mr-2">
						<option value="T" ${page.cri.type == 'T' ? 'selected' : ''}>제목</option>
						<option value="C" ${page.cri.type == 'C' ? 'selected' : ''}>내용</option>
						<option value="W" ${page.cri.type == 'W' ? 'selected' : ''}>작성자</option>
						<option value="TC" ${page.cri.type == 'TC' ? 'selected' : ''}>제목 + 내용</option>
						<option value="CW" ${page.cri.type == 'CW' ? 'selected' : ''}>내용 + 작성자</option>
						<option value="WT" ${page.cri.type == 'WT' ? 'selected' : ''}>제목 + 작성자</option>
						<option value="TCW" ${page.cri.type == 'TCW' ? 'selected' : ''}>제목 + 내용 +작성자</option>
					</select> 
					<input type="text" name="keyword" class="form-control bg-light border-0 small" placeholder="Search for..."
							aria-label="Search" aria-describedby="basic-addon2" value="${page.cri.keyword}">
					<div class="input-group-append">
						<button class="btn btn-primary" >
							<i class="fas fa-search fa-sm"></i>
						</button>
					</div>
				</div>
			</form>
		</c:if>
		
		<!-- Topbar Navbar -->
		<ul class="navbar-nav ml-auto">
			<!-- Nav Item - Search Dropdown (Visible Only XS) -->
			<li class="nav-item dropdown no-arrow d-sm-none">
				<a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-search fa-fw"></i>
				</a>
				<!-- Dropdown - Messages -->
				<div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
						aria-labelledby="searchDropdown">
					<form class="form-inline mr-auto w-100 navbar-search">
						<div class="input-group">
							<input type="text" class="form-control bg-light border-0 small"
									placeholder="Search for..." aria-label="Search"
									aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary" type="button">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>
				</div>
			</li>
		
			<!-- Nav Item - User Information -->
			<li class="nav-item dropdown no-arrow">
				<sec:authorize access="isAnonymous()">
					<a href="/member/login" class="text-secondary small">로그인</a>
					<a href="/member/join" class="text-secondary small">회원가입</a>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
				<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<span class="mr-2 d-none d-lg-inline text-gray-600 small"><sec:authentication property="principal.member.username"/></span>
					<img class="img-profile rounded-circle" src="/resources/assets/img/undraw_profile.svg">
				</a>
				<!-- Dropdown - User Information -->
				<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
						aria-labelledby="userDropdown">
				<a class="dropdown-item" href="/member/mypage">
					<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
					마이페이지
				</a>
				<div class="dropdown-divider"></div>
					<form action="/logout" method="post" onsubmit="return confirm('로그아웃하시겠습니까?')">
						<button class="dropdown-item">
							<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
							Logout
						</button>
						<sec:csrfInput/>
					</form>
				</div>
				</sec:authorize>
			</li>
		</ul>
	</nav>
	<!-- End of Topbar -->