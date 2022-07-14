package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dao.ChucVuDao;

@Entity (name = "chucVu")
@Table (name = "ChucVu")
public class ChucVu {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int maChucVu;
	private String tenChucVu;
	 @OneToMany(fetch = FetchType.LAZY, targetEntity=NhanVien.class)
	  private Set<NhanVien> listNhanVien = new HashSet<NhanVien>();
	public ChucVu(int maChucVu, String tenChucVu, Set<NhanVien> listNhanVien) {
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
		this.listNhanVien = listNhanVien;
	}
	public ChucVu() {
	}
	public int getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(int maChucVu) {
		this.maChucVu = maChucVu;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	public Set<NhanVien> getNhanVien() {
		return listNhanVien;
	}
	public void setListNhanVien(Set<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}
	@Override
	public String toString() {
		return "ChucVu [maChucVu=" + maChucVu + ", tenChucVu=" + tenChucVu + ", listEmployee=" + listNhanVien + "]";
	}
	
	public static void main(String[] args) {
		ChucVuDao chucVuDao = new ChucVuDao();
		ChucVu chucVu = new ChucVu(0, "Employee", new HashSet<NhanVien>());
		chucVuDao.them(chucVu);
	}
	
}
