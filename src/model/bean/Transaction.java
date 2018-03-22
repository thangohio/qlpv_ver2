package model.bean;

import java.util.Date;

public class Transaction {
	private long maGiaoDich;
	private String maVe;
	private String maKhachHang;
	private String maNhanVien;
	private Date ngayBan;
	
	public Transaction(long magd, String mave, String maKh, String maNv, Date ngayBan2)
	{
		this.maGiaoDich = magd;
		this.maVe = mave;
		this.maKhachHang = maKh;
		this.maNhanVien = maNv;
		this.ngayBan = ngayBan2;		
	}
	
	public void setMaGiaoDich(long input)
	{
		this.maGiaoDich = input;
	}
	
	public long getMaGiaoDich()
	{
		return this.maGiaoDich;
	}
	
	public void setMaVe(String input)
	{
		this.maVe = input;
	}
	
	public String getMaVe()
	{
		return this.maVe;
	}
	
	public void setMaKhachHang(String input)
	{
		this.maKhachHang = input;
	}
	
	public String getMaKhachHang()
	{
		return this.maKhachHang;
	}
	
	public void setMaNhanVien(String input)
	{
		this.maNhanVien = input;
	}
	
	public String getMaNhanVien()
	{
		return this.maNhanVien;
	}
	
	public void setNgayBan(Date input)
	{
		this.ngayBan = input;
	}
	
	public Date getNgayBan()
	{
		return this.ngayBan;
	}
}
