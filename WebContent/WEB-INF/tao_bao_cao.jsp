<%@ include file="/WEB-INF/header.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="text-align: center">
	<label style="font-size: 20px; margin: 15px">TẠO BÁO CÁO DOANH
		THU</label>
</div>

<form action="" method="POST" class="form-inline" role="form">
	<div class="row">
		<div class="col-md-6" style="text-align: right">
			<div class="form-group">
				Tạo từ ngày <input type="date" name="formDatePicker"
					id="inputFormDatePicker" class="form-control" value=""
					required="required" title="">
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				Tạo tới ngày <input type="date" name="toDatePicker"
					id="inputFormDatePicker" class="form-control" value=""
					required="required" title="">
			</div>
		</div>
	</div>

	<div class="row" style="margin-top: 5px">
		<div class="col-md-6" style="text-align: right">
			<div class="form-group">
				Báo cáo theo <select class="form-control" id="sel1"
					name="reportField">
					<option value="supplier">Nhà cung cấp</option>
					<option value="customer">Khách hàng</option>
					<option value="staff">Nhân viên bán hàng</option>
				</select>

			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<span class="input-group-btn">
					<button type="submit" class="btn btn-success btn-block">Tạo
						báo cáo</button>
				</span>
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group">
				<span class="input-group-btn">
					<button type="submit" class="btn btn-success btn-block">In
						báo cáo</button>
				</span>
			</div>
		</div>

	</div>
</form>

<!-- bang -->
<hr>

<table class="table table-bordered table-hover">
	<thead>
		<tr class="bg-primary">
			<!-- tùy thuộc vào "báo cáo theo" -->
			<th>Nhà cung cấp</th>
			<th>Tổng số vé bán</th>
			<th>Tổng tiền đã mua vé</th>
			<th>Tổng tiền bán</th>
			<th>Hoa hồng</th>
			<th>Lợi nhuận</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Vietnam Airline</td>
			<td>200</td>
			<td>10000000</td>
			<td>20000000</td>
			<td>2342</td>
			<td>1234200</td>
		</tr>
	</tbody>
</table>
</div>
</body>
</html>