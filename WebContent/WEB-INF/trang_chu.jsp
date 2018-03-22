<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.bean.User" %>
<%
	User user = (User) request.getAttribute("currentUser");
	boolean isStaff = ("staff".equalsIgnoreCase(user.getPrivilege())) ? true : false;
%>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lý phòng vé</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-1.12.3.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container-fluid">

		<!-- header -->
		<div class="row"
			style="text-align: center; background-color: #bdc3c7; height: 100px">
			<label style="font-size: 30px; padding: 30px;">HỆ THỐNG QUẢN
				LÝ PHÒNG BÁN VÉ MÁY BAY</label>
		</div>

		<div class="row">
			<nav class="navbar navbar-inverse">
				<div class="row">
					<div class="col-md-8">
						<div class="container-fluid">
							<div class="navbar-header">
								<a class="navbar-brand" href="#"><span
									class="glyphicon glyphicon-plane"></span></a>
							</div>
							<ul class="nav navbar-nav">
								<li class="active"><a href="trang_chu_splash.jsp" target="_main">Trang chủ</a></li>
								<li class="dropdown"><a class="dropdown-toggle"
									data-toggle="dropdown" href="#">Quản lý kinh doanh<span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<%
											if (isStaff) {
										%>
										<li><a href="ticketmanager?" target="_main">Quản lý bán vé</a></li>
										<%
											}
										%>

										<li><a href="reporter" target="_main">Tạo báo cáo</a></li>


									</ul></li>
									<% if(!isStaff) { %>
								<li><a href="usermanager" target="_main">Quản lý nhân viên</a></li>
								<% } %>
								<li><a href="customermanager" target="_main">Quản lý khách hàng</a></li>
							</ul>
						</div>
					</div>

					<div class="col-md-4"
						style="vertical-align: center; text-align: right">
						<label style="color: #FFFFFF; padding-top: 15px">Chào <%=user.getFullName()%>

							<span> <a href="login?action=logout"> [Đăng xuất] </span> </a> </span>

						</label>
					</div>

				</div>
			</nav>
		</div>
		<!-- main content -->
		<div class="row">
			<iframe src="" name="_main"
				style="border: none; width: 100%; height: 350px"> </iframe>
		</div>
		<!-- / main content -->
			<!-- footer -->
			
<%@ include file="/WEB-INF/footer.jsp"%>