<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/header.jsp"%>
<!-- header -->
	<div class="row"
			style="text-align: center; background-color: #bdc3c7; height: 100px">
			<label style="font-size: 30px; padding: 30px;">HỆ THỐNG QUẢN
				LÝ PHÒNG BÁN VÉ MÁY BAY</label>
		</div>
<script type="text/javascript">

function validateForm() {
	var x = document.forms["myForm"]["email"].value;
	var y = document.forms["myForm"]["password"].value;
	var reg_mail = /^[A-Za-z0-9]+([_\.\-]?[A-Za-z0-9])*@[A-Za-z0-9]+([\.\-]?[A-Za-z0-9]+)*(\.[A-Za-z]+)+$/;
	
	if (reg_mail.test(x) == false) {
		{
			document.getElementById("message").style.color = "red";
			document.getElementById("message").innerHTML ='Email nhập chưa đúng định dạng';}		
	    return false; 	
}
}

</script>
<div class="container" style="width: 40%; padding-top: 50px">
	<form action="login" name="myForm" method="POST" role="form" onsubmit="return validateForm()">
		<h5 id="message"></h5><br><br>
		<legend>Đăng nhập</legend>

		<div class="form-group">
			<label for="email">Email</label>
			 <input type="text" required="true"
				class="form-control" id="email" placeholder="User ID" name="email" maxlength="40">
		</div>
		<div class="form-group">
			<label for="password">Mật khẩu</label> <input type="password" required="true"
				class="form-control" id="password" placeholder="" name="password" maxlength="20"><br>
		</div>		
		<div align="right">
			<button type="reset" class="btn btn-default" style="margin-right: 15px">Xóa</button>
			<button type="submit" class="btn btn-success">Đăng nhập</button>
			<input type="hidden" name="loginPressed" value="yes">			
		</div>
	</form>


</div>

<%@ include file="/WEB-INF/footer.jsp"%>
