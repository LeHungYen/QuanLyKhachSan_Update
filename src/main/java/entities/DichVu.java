package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "dichVu")
@Table (name = "DichVu")
public class DichVu {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int maDichVu;
	private String tenDichVu;
	private long giaNhap;
	private long giaban;
	private int soLuongTon;
	private String trangThai;
	
	
	public DichVu(int maDichVu, String tenDichVu, long giaNhap, long giaban, int soLuongTon, String trangThai) {
		this.tenDichVu = tenDichVu;
		this.giaNhap = giaNhap;
		this.giaban = giaban;
		this.soLuongTon = soLuongTon;
		this.trangThai = trangThai;
	}
	public DichVu() {
		
	}
	public int getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(int maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public long getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(long giaNhap) {
		this.giaNhap = giaNhap;
	}
	public long getGiaban() {
		return giaban;
	}
	public void setGiaban(long giaban) {
		this.giaban = giaban;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", giaNhap=" + giaNhap + ", giaban="
				+ giaban + ", soLuongTon=" + soLuongTon + ", trangThai=" + trangThai + "]";
	}
	
	
}
