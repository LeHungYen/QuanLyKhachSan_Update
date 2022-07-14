package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.swing.JOptionPane;

import entities.ChucVu;

public class NhanVienModel {
	private int stt;
	private String maNV;
	private String tenNV;
	private String sdt;
	private String gioiTinh;
	private String email;
	private ChucVuModel chucVuModel;
	private int maChucVu;
	private String diaChi;
	private String ngaySinh;
	private String cmnd;
	private String matKhau;
	private String trangThai;
	public NhanVienModel(int stt, String maNV, String tenNV, String sdt, String gioiTinh, String email, ChucVuModel chucVuModel,
			int maChucVu, String diaChi, String ngaySinh, String cmnd, String matKhau, String trangThai) {
		this.stt = stt;
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.chucVuModel = chucVuModel;
		this.maChucVu = maChucVu;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.cmnd = cmnd;
		this.matKhau = matKhau;
		this.trangThai = trangThai;
	}
	public NhanVienModel() {
		
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
		
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ChucVuModel getChucVuModel() {
		return chucVuModel;
	}
	public void setChucVuModel(ChucVuModel chucVuModel) {
		this.chucVuModel = chucVuModel;
	}
	public int getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(int maChucVu) {
		this.maChucVu = maChucVu;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "NhanVienModel [stt=" + stt + ", maNV=" + maNV + ", tenNV=" + tenNV + ", sdt=" + sdt + ", gioiTinh="
				+ gioiTinh + ", email=" + email + ", chucVuModel=" + chucVuModel + ", maChucVu=" + maChucVu + ", diaChi=" + diaChi
				+ ", ngaySinh=" + ngaySinh + ", cmnd=" + cmnd + ", matKhau=" + matKhau + ", trangThai=" + trangThai
				+ "]";
	}
	
	
}
