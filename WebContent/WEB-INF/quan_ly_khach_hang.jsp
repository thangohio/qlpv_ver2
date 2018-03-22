<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/header.jsp"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="model.bean.Customer"%>

<%
	ArrayList<Customer> customers = (ArrayList<Customer>) request.getAttribute("customerList");
%>
<%
	User currentUser = (User) session.getAttribute("currentUser");
	boolean isStaff = ("staff".equalsIgnoreCase(currentUser.getPrivilege())) ? true : false;
%>

<div style="text-align: center">
	<label style="font-size: 20px; margin: 15px">QUẢN LÝ KHÁCH HÀNG</label>
</div>

<div class="row">
<p class="err" id="alertCheckInputTimKiemTheoSelect"></p>
	<div class="col-sm-2">
		<%
			if (isStaff) {
		%>
		<a href="customermanager?action=redirAddCustomer" target="_main">
			<button type="button" class="btn btn-success" name="themNhanVien">Thêm
				khách hàng</button>
		</a>
		<%
			}
		%>
	</div>
	<form method="POST" name="searchForm"
		action="customermanager?action=search" onsubmit="return checkLookFor()">
		<div class="col-sm-2" style="text-align: right">
			<p style="margin-top: 6px">Tìm kiếm theo</p>
		</div>
		<div class="col-sm-3">
			<select name="searchBy" id="inputSearchBy" class="form-control"
				required="required">
				<option value="customerId" selected>Mã khách hàng</option>
				<option value="fullName">Họ tên</option>
				<option value="phoneNumber">Số điện thoại</option>
				<option value="email">Email</option>
			</select>
		</div>

		<div class="col-sm-3" style="align-content: right;">
			<span style="align-content: center"><input type="search"
				name="searchContent" id="inputSearchContent" class="form-control">
			</span>
		</div>
		<div class="col-sm-2">
			<button type="submit" class="btn btn-success">Tìm</button>
		</div>
</div>
</form>
<div class="table-responsive" style="margin-top: 20px">
	<table style="width: 100%"
		class="table table-bordered table-hover table-striped">
		<tr color="green">
			<td>STT</td>
			<td>Mã khách</td>
			<td>Họ tên</td>
			<td>Ngày sinh</td>
			<td>Giới tính</td>
			<td>CMND</td>
			<td>Hộ chiếu</td>
			<td>Email</td>
			<td>Số điện thoại</td>

			<%
				if (isStaff) {
			%>
			<td colspan="2">Thao tác</td>
			<%
				}
			%>
		</tr>

		<%
			int i = 1;
			if (isStaff) {
				for (Customer c : customers) {
		%>
		<tr>
			<form method="POST" action="customermanager?action=updateOrDelete">
				<td><%=i%></td>
				<td><input type="hidden" name="customerId" id="inputCustomerId"
					value="<%=c.getId()%>"> <%=c.getId()%></td>
				<td><input type="text" name="fullname" id="inputFullname"
					class="form-control" value="<%=c.getFullName()%>"
					required="required"></td>
				<td><input type="date" name="dob" id="inputDob"
					class="form-control" value="<%=c.getDob()%>" required="required">
				</td>
				<td style="width: 90px;"><select name="gender" id="inputGender" class="form-control"
					required="required" select>
						<option value="M" <%if (c.isMale()) {%> selected <%}%>>Nam</option>
						<option value="F" <%if (!c.isMale()) {%> selected <%}%>>Nữ</option>
				</select></td>
				<td><input type="text" name="personId"
					class="form-control" value="<%=c.getPersonId()%>"
					required="required"></td>
				<td><input type="text" name="passport"
				class="form-control" value="<%=c.getPassport()%>"
				required="required"></td>
				<td><input type="email" name="email" id="inputEmail"
					class="form-control" value="<%=c.getEmail()%>"
					required="required"></td>
				<td><input type="text" name="phoneNumber" id="inputPhoneNumber"
					class="form-control" value="<%=c.getPhoneNumber()%>"></td>
				<td>
					<button type="submit" class="btn btn-primary" name="actionDetail"
						value="update">Lưu</button>
				</td>
				<td>
					<button type="submit" class="btn btn-danger" name="actionDetail"
						value="delete">Xóa</button>
				</td>
			</form>
		</tr>
		<%
			i++;
				}
			} else {
				for (Customer c : customers) {
		%>
		<tr>
			<td><%=i%></td>
			<td><%=c.getId()%></td>
			<td><%=c.getFullName()%></td>
			<td><%=c.getDob().toString()%></td>
			<td><%=(c.isMale()) ? "Nam" : "Nữ"%></td>
			<td><%=c.getEmail()%></td>
			<td><%=c.getPhoneNumber()%></td>
		</tr>
		<%
			i++;
				}
			}
		%>
	</table>
</div>
</div>

<script type="text/javascript">
	function checkFormatPhoneNumberUpdate() {
		phoneNumber = document.getElementById("inputPhoneNumber");
		var letters = /^[0-9]+$/;
		if (phoneNumber.value.match(letters)) {
			return true;
		} else {

			return false;
		}
	}
	function checkFormatCusId() {

		var letters = /^KH[0-9]+$/;
		inputSearchContent = document.getElementById("inputSearchContent");
		workerId = document.getElementById("inputSearchContent");
		if (workerId.value.match(letters)) {
			return true;
		} else {

			return false;
		}
	}

	function checkFormatFullname() {
		inputSearchContent = document.getElementById("inputSearchContent");
		var letters = /^[ - a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$/;
		fullname = document.getElementById("inputSearchContent");
		if (fullname.value.match(letters)) {
			return true;
		} else {

			return false;
		}
	}
	
	 function checkFormatEmail(str) { 
		  var reg_mail = /^[A-Za-z0-9]+([_\.\-]?[A-Za-z0-9])*@[A-Za-z0-9]+([\.\-]?[A-Za-z0-9]+)*(\.[A-Za-z]+)+$/;
		  if (reg_mail.test(str) == false) {
			  return false;
		  }
	  }
	
	function checkFormatPhoneNumber() {
		inputSearchContent = document.getElementById("inputSearchContent");
		var letters = /^[0-9]+$/;
		phoneNumber = document.getElementById("inputSearchContent");
		if (phoneNumber.value.match(letters)) {
			return true;
		} else {
			return false;
		}
	}
	function checkLookFor() {

		alertCheckInputTimKiemTheoSelect = document
				.getElementById("alertCheckInputTimKiemTheoSelect");
		inputTimKiemTheoSelect = document.getElementById("inputSearchBy");
		inputSearchContent = document.getElementById("inputSearchContent");

		alertCheckInputTimKiemTheoSelect.innerHTML = "";

		if (inputSearchContent.value == "") {
			alertCheckInputTimKiemTheoSelect.innerHTML = "Cụm từ tìm kiếm không được để trống";
			return false;
		}

		if (inputTimKiemTheoSelect.value == "customerId"
				&& inputSearchContent.value.length > 4) {
			alertCheckInputTimKiemTheoSelect.innerHTML = "Độ dà mã khách hàng không quá 4 ký tự";
			return false;
		}
		if (inputTimKiemTheoSelect.value == "fullName"
				&& inputSearchContent.value.length > 40) {
			alertCheckInputTimKiemTheoSelect.innerHTML = "Độ dài họ tên khách hàng không quá 40 ký tự";
			return false;
		}
		if (inputTimKiemTheoSelect.value == "phoneNumber"
				&& inputSearchContent.value.length > 13) {
			alertCheckInputTimKiemTheoSelect.innerHTML = "Số điện thoại không quá 13 ký tự";
			return false;
		}
		if (inputTimKiemTheoSelect.value == "phoneNumber"
				&& checkFormatPhoneNumber() == false) {
			alertCheckInputTimKiemTheoSelect.innerHTML = "Nhập không đúng định dạng số điện thoại.";
			return false;
		}
		if (inputTimKiemTheoSelect.value == "fullName"
				&& checkFormatFullname() == false) {
			alertCheckInputTimKiemTheoSelect.innerHTML = "Họ tên nhập vào không đúng định dạng";
			return false;
		}
		if (inputTimKiemTheoSelect.value == "customerId"
				&& checkFormatWorkerId() == false) {
			alertCheckInputTimKiemTheoSelect.innerHTML = "Nhập không đúng định dạng mã khách hàng";
			return false;
		}
		
		if (inputTimKiemTheoSelect.value == "email" && checkFormatEmail(inputSearchContent.value) == false) {
			alertCheckInputTimKiemTheoSelect.innerHTML = "Nhập không đúng định dạng email";
			return false;
		}
	}

	function checkUpdate() {
		alertCheckInputTimKiemTheoSelect = document
				.getElementById("alertCheckInputTimKiemTheoSelect");

		alertCheckInputTimKiemTheoSelect.innerHTML = "";

		fullname = document.getElementById("inputFullname");

		email = document.getElementById("inputEmail");

		phoneNumber = document.getElementById("inputPhoneNumber");

		if (phoneNumber.value == "") {
			alertCheckInputTimKiemTheoSelect.innerHTML = "Số điện thoại khách hàng không được để trống";
			return false;
		}
		if (checkFormatPhoneNumberUpdate() == false) {
			alertCheckInputTimKiemTheoSelect.innerHTML = "Số điện thoại khách hàng không đúng định dạng";
			return false;

		}
	}
</script>

</body>
</html>
