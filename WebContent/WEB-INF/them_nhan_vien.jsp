<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ include file="/WEB-INF/header.jsp" %>



<div class="container">

<div style="text-align: center">
	<label style="font-size: 20px; margin-top: 15px;">QUẢN LÝ NHÂN VIÊN</label>
</div>
<div style="text-align: center">
	<label style="font-size: 15px;">THÊM NHÂN VIÊN</label>
</div>
<div class="container">
	<form action="usermanager?action=addUser" method="POST" class="form-horizontal" role="form" onsubmit="return validateForm()">
		<div class="row" style="margin-top: 20px;">
			<div class="col-sm-6">
				<div style="width: 80%;">
					<div class="form-group">
					 	 <label for="workerId">Mã nhân viên</label>
					 	 <p class="err" id="errMsgWorkerId"></p>
					  	<input type="text" class="form-control" id="workerId" name="userId" required="required">
					</div>
					<div class="form-group">
					  	<label for="fullname">Họ tên</label>
					  	<input type="text" class="form-control" id="fullname" name="fullname" required="required">
					</div>
					<div class="form-group">
					 	 <label for="dob">Ngày sinh</label>
					  	<input type="date" name="dob" id="inputDob" class="form-control" required="required">
					</div>
					<div class="form-group">
					  	<label for="gender">Giới tính</label>
					  	<select name="" id="gender" class="form-control" required="required">
					  	 	<option value="M">Nam</option>
					  	 	<option value="F">Nữ</option>
					  	 </select>
					</div>
				</div>
			</div>
			
			<div class="col-sm-6">
				<div style="width: 80%">
					<div class="form-group">
					 	 <label for="email">Tài khoản</label>
					  	<input type="email" class="form-control" id="email" name="email" required="required">
					</div>
					<div class="form-group">
					  	<label for="pwd">Mật khẩu</label>
					  	<input type="text" class="form-control" id="pwd" name="password" required="required">
					</div>
					<div class="form-group">
					 	 <label for="phoneNumber">Số điện thoại</label>
					 	 <p class="err" id="errMsgPhoneNumber"></p>
					  	<input type="text" class="form-control" id="phoneNumber" name="phoneNumber" required="required">
					</div>
					<div class="form-group">
					  	<label for="privilege">Quyền</label>
					  	<select name="privilege" id="privilege" class="form-control" required="required">
					  		<option value="admin">Admin</option>
					  		<option value="staff" selected>Nhân viên</option>
					  	</select>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2 col-sm-offset-2">
				<a href="usermanager" target="_main">			
					<button type="button" class=btn btn-default>Quay lại</button>
				</a>
			</div>
			<div class="col-sm-2 col-sm-offset-1">
				<button type="reset" class="btn btn-danger">Xóa ô đã nhập</button>
			</div>
			<div class="col-sm-5">
				<button type="submit" class="btn btn-success">Lưu</button>
			</div>
		</div>
	</form>
</div>

<script type="text/javascript">

function validateForm() {
	var workerId = document.getElementById("workerId").value;
	var phoneNumber = document.getElementById("phoneNumber").value;
	var reg_id = /^NV[0-9]+$/;
	var reg_phone = /^[0-9]+$/;
	
	if (reg_id.test(workerId) == false) {
		document.getElementById("errMsgWorkerId").innerHTML = "Sai định dạng mã nhân viên!";
	    return false; 	
	}
	else {
		document.getElementById("errMsgWorkerId").innerHTML = "";
	}
	
	if (reg_phone.test(phoneNumber) == false) {
		document.getElementById("errMsgPhoneNumber").innerHTML = "Sai định dạng số điện thoại!";
		return false;
	}
	else {
		document.getElementById("errMsgPhoneNumber").innerHTML = "";
	}
}

</script>
	 
</body>
</html>