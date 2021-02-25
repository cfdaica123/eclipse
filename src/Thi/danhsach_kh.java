package Thi;

import java.sql.Date;

public class danhsach_kh {
	private String ma_kh;
	private String ten_kh;
	private String ngaysinh;
	private String gioitinh;
	private String diachi;
	private String sdt_kh;
	
	public danhsach_kh(String ma_kh, String ten_kh, String ngaysinh, String gioitinh, String diachi, String sdt_kh) {
		this.ma_kh = ma_kh;
		this.ten_kh = ten_kh;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.sdt_kh = sdt_kh;
	}

	public danhsach_kh() {
	}

	public String getMa_kh() {
		return ma_kh;
	}

	public void setMa_kh(String ma_kh) {
		this.ma_kh = ma_kh;
	}

	public String getTen_kh() {
		return ten_kh;
	}

	public void setTen_kh(String ten_kh) {
		this.ten_kh = ten_kh;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt_kh() {
		return sdt_kh;
	}

	public void setSdt_kh(String sdt_kh) {
		this.sdt_kh = sdt_kh;
	}
	
	
	
}
