<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp"%>

<%@ page import="java.util.ArrayList"%>

<% ArrayList<User> users = new ArrayList<User>(); 
	users = (ArrayList<User>) request.getAttribute("userList");
%>
<div style="text-align: center">
	<label style="font-size: 20px; margin: 15px">QUẢN LÝ NHÂN VIÊN</label>

	<div class="row">
		<p class="err" id="alertCheckInputTimKiemTheoSelect"></p>
		<div class="col-sm-2">
			<a href="usermanager?action=redirAddUsers" target="_main">
				<button type="button" class="btn btn-success" name="themNhanVien">Thêm
					nhân viên</button>
			</a>
		</div>
		<form method="post" action="usermanager?action=search" onsubmit="return checkLookFor()">
			<div class="col-sm-2" style="text-align: right">
				<p style="margin-top: 6px">Tìm kiếm theo</p>
			</div>
			<div class="col-sm-3">
				<select name="searchBy" id="inputSearchBy" class="form-control"
					required="required">
					<option value="userId">Mã nhân viên</option>
					<option value="fullName">Họ tên</option>
					<option value="phoneNumber">Số điện thoại</option>
					<option value="email">Email</option>
				</select>
			</div>

			<div class="col-sm-3" style="align-content: right;">
				<span style="align-content: center"><input type="search"
					name="searchContent" id="inputSearchContent" class="form-control" required="required">
				</span>
			</div>
			<div class="col-sm-2">
				<button type="submit" class="btn btn-success" >Tìm</button>
			</div>
	</div>
	</form>
	<div class="table-responsive" style="margin-top: 20px">
		<table style="width: 100%"
			class="table table-bordered table-hover table-striped">
			<tr color="green">
				<td>STT</td>
				<td>Mã nhân viên</td>
				<td>Họ tên</td>
				<td>Ngày sinh</td>
				<td>Giới tính</td>
				<td>Tài khoản</td>
				<td>Số điện thoại</td>
				<td>Quyền</td>
				<td colspan="2">Thao tác</td>
			</tr>

			<% 	int i = 1; 
					for (User u : users) { %>
			<tr>
				<form method="POST" action="usermanager?action=updateOrDelete"  onsubmit="return checkUpdate()">
				<td><%= i %></td>
				<td><input type="hidden" name="userId" value="<%= u.getId() %>"><%= u.getId() %>
				</td>
				<td><input type="text" name="fullname" id="inputFullname"
					class="form-control" value="<%= u.getFullName() %>"
					required="required"></td>
				<td><input type="date" name="dob" id="inputDob"
					class="form-control" value="<%= u.getDob() %>" required="required">
				</td>
				<td><select name="gender" id="inputGender" class="form-control"
					required="required">
						<option value="M" <% if (u.isMale()){%> selected <%} %>>Nam</option>
						<option value="F" <% if (!u.isMale()) {%> selected <%} %>>Nữ</option>
				</select></td>
				<td><input type="email" name="email" id="inputEmail"
					class="form-control" value="<%= u.getEmail() %>"
					required="required"></td>
				<td><input type="phoneNumber" name="phoneNumber"
					id="inputPhoneNumber" class="form-control"
					value="<%= u.getPhoneNumber() %>" required="required"></td>
				<td>
					<% boolean isAdmin = ("admin".equals(u.getPrivilege())) ? true : false; %>
					<select name="privilege" id="inputPrivilegeSelect"
					class="form-control" required="required">
						<option value="admin" <% if(isAdmin) { %> selected <%} %>>Admin</option>
						<option value="staff" <% if(!isAdmin) {%> selected <%} %>>Nhân
							viên</option>
				</select>
				</td>
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
					} %>
		</table>
	</div>
</div>
</div>

<script type="text/javascript">
	 function checkFormatPhoneNumberUpdate(){
		  phoneNumber = document.getElementById("inputPhoneNumber");
			 var letters = /^[0-9]+$/; 
			 if(phoneNumber.value.match(letters))  
			 {  
			 return true;  
			 }  
			 else  
			 {  
				 
					 return false;  
			 }  
	 }
	  function checkFormatWorkerId(){
		     
			 var letters = /^[N-N][V-V][0-9]+$/; 
			 inputSearchContent = document.getElementById("inputSearchContent");
			 workerId = document.getElementById("inputSearchContent");
			 if(workerId.value.match(letters))  
			 {  
			 return true;  
			 }  
			 else  
			 {  
				
					 return false;  
			 }  
		}
	  
	  function checkFormatFullname(){
		  inputSearchContent = document.getElementById("inputSearchContent");
			 var letters = /^[ - a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$/; 
			 fullname = document.getElementById("inputSearchContent");
			 if(fullname.value.match(letters))  
			 {  
			 return true;  
			 }  
			 else  
			 {  
				 
					 return false;  
			 }  
	  }
	  
	  function checkFormatEmail() {
		  var inputEmail = document.getElementById("inputEmail").value;
		  var reg_mail = /^[A-Za-z0-9]+([_\.\-]?[A-Za-z0-9])*@[A-Za-z0-9]+([\.\-]?[A-Za-z0-9]+)*(\.[A-Za-z]+)+$/;
		  if (reg_mail.test(reg_mail) == false) {
			  return false;
		  }
	  }
	  
	  function checkFormatPhoneNumber(){
		  inputSearchContent = document.getElementById("inputSearchContent");
			 var letters = /^[0-9]+$/; 
			 phoneNumber = document.getElementById("inputSearchContent");
			 if(phoneNumber.value.match(letters))  
			 {  
			 return true;  
			 }  
			 else  
			 {  
					 return false;  
			 }  
		}
	function checkLookFor(){
		 
		 alertCheckInputTimKiemTheoSelect = document.getElementById("alertCheckInputTimKiemTheoSelect");
		 inputTimKiemTheoSelect = document.getElementById("inputSearchBy");
		 inputSearchContent = document.getElementById("inputSearchContent");
		 
		 alertCheckInputTimKiemTheoSelect.innerHTML = "";
	      
	      
	      if ( inputSearchContent.value == ""){
	    	  alertCheckInputTimKiemTheoSelect.innerHTML = "Cụm từ tìm kiếm không được để trống";
	    	  return false;
	      }	    	
	      
	      if ( inputTimKiemTheoSelect.value == "userId"&&inputSearchContent.value.length > 4){
	    	  alertCheckInputTimKiemTheoSelect.innerHTML = "Độ dà mã nhân viên không quá 4 ký tự";
	    	  return false;
	      }
	      if ( inputTimKiemTheoSelect.value == "fullName"&&inputSearchContent.value.length > 40){
	    	  alertCheckInputTimKiemTheoSelect.innerHTML = "Độ dài họ tên nhân viên không quá 40 ký tự";
	    	  return false;
	      }
	      if ( inputTimKiemTheoSelect.value == "phoneNumber"&&inputSearchContent.value.length > 13){
	    	  alertCheckInputTimKiemTheoSelect.innerHTML = "Số điện thoại không quá 13 ký tự";
	    	  return false;
	      }
	      if ( inputTimKiemTheoSelect.value == "phoneNumber"&& checkFormatPhoneNumber() == false){
	    	  alertCheckInputTimKiemTheoSelect.innerHTML =  "Nhập không đúng định dạng số điện thoại.";
	    	  return false;
	      }
	      if ( inputTimKiemTheoSelect.value == "fullName"&& checkFormatFullname() == false){
	    	  alertCheckInputTimKiemTheoSelect.innerHTML = "Họ tên nhập vào không đúng định dạng";
	    	  return false;
	      }
	      if ( inputTimKiemTheoSelect.value == "userId"&&  checkFormatWorkerId() == false){
	    	  alertCheckInputTimKiemTheoSelect.innerHTML = "Nhập không đúng định dạng mã nhân viên";
	    	  return false;
	      }
	}
	
	function checkUpdate(){
		 alertCheckInputTimKiemTheoSelect = document.getElementById("alertCheckInputTimKiemTheoSelect");
		
		
		 
		 alertCheckInputTimKiemTheoSelect.innerHTML = "";
		 
		  fullname = document.getElementById("fullname");
		  
		  email = document.getElementById("email");
		 
		  phoneNumber = document.getElementById("inputPhoneNumber");
		  
		 if(phoneNumber.value == ""){
			  alertCheckInputTimKiemTheoSelect.innerHTML =  "Số điện thoại nhân viên không được để trống";
			  return false;
		 }
		  if (checkFormatPhoneNumberUpdate() == false){
			  alertCheckInputTimKiemTheoSelect.innerHTML =  "Số điện thoại nhân viên không đúng định dạng";
		  return false;
		  
	}
	}
	</script>
</body>
</html>