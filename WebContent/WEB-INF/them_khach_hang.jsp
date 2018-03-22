<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ include file="/WEB-INF/header.jsp" %>
<div class="container">
	<div style="text-align: center">
		<label style="font-size: 20px; margin-top: 15px;">QUẢN LÝ KHÁCH HÀNG</label>
	</div>
	<div style="text-align: center">
		<label style="font-size: 15px;">THÊM KHÁCH HÀNG</label>
	</div>

	<form action="customermanager?action=add_customer" method="POST" class="form-horizontal" role="form" onsubmit="return validateForm()">
		<div class="row" style="margin-top: 20px;">
			<div class="col-sm-6">
				<div style="width: 80%;">
					<div class="form-group">
					 	 <label for="customerId">Mã khách hàng</label>
					 	 <p class="err" id="errMsgCusId"></p>
					  	<input type="text" class="form-control" id="inputCustomerId" name="customerId">
					</div>
					<div class="form-group">
					  	<label for="fullname">Họ tên</label>
					  	<input type="text" class="form-control" id="fullname" name="fullname">
					</div>
					<div class="form-group">
					 	 <label for="dob">Ngày sinh</label>
					  	<input type="date" name="dob" id="inputDob" class="form-control" required="required">
					</div>
					<div class="form-group">
					  	<label for="gender">Giới tính</label>
					  	<select name="gender" id="inputGender" class="form-control" required="required">
							<option value="M" selected>Nam</option>
							<option value="F">Nữ</option>	
						</select>
					</div>
				</div>
			</div>
			
			<div class="col-sm-6">
				<div style="width: 80%">
					<div class="form-group">
					 	 <label for="personId">CMND</label>
					  	<input type="text" class="form-control" id="personId" name="personId">
					</div>
					<div class="form-group">
					 	 <label for="passport">Hộ chiếu</label>
					  	<input type="text" class="form-control" id="passport" name="passport">
					</div>
					<div class="form-group">
					 	 <label for="email">Email</label>
					  	<input type="email" class="form-control" id="inputEmail" name="email">
					</div>					
					<div class="form-group">
					 	 <label for="phoneNumber">Số điện thoại</label>
					 	 <p class="err" id="errMsgPhoneNumber"></p>
					  	<input type="text" class="form-control" id="inputPhoneNumber" name="phoneNumber">
					</div>

				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2 col-sm-offset-2">
				<a href="customermanager">
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
</div>

<script type="text/javascript">

function validateForm() {
	var workerId = document.getElementById("inputCustomerId").value;
	var phoneNumber = document.getElementById("inputPhoneNumber").value;
	var reg_id = /^KH[0-9]+$/;
	var reg_phone = /^[0-9]+$/;
	
	if (reg_id.test(workerId) == false) {
		document.getElementById("errMsgCusId").innerHTML = "Sai định dạng mã khách hàng!";
	    return false; 	
	}
	else {
		document.getElementById("errMsgCusId").innerHTML = "";
	}
	
	if (reg_phone.test(phoneNumber) == false) {
		document.getElementById("errMsgPhoneNumber").innerHTML = "Sai định dạng số điện thoại!";
		return false;
	}
	else {
		document.getElementById("errMsgCusId").innerHTML = "";
	}
}

</script>
</body>
</html>