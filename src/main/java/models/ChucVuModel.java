package models;

public class ChucVuModel {
	private int stt;
	private int maChucVu;
	private String tenChucVu;
	public ChucVuModel(int stt, int maChucVu, String tenChucVu) {
		this.stt = stt;
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
	}
	public ChucVuModel() {
		
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
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
	@Override
	public String toString() {
		return "ChucVuModel [stt=" + stt + ", maChucVu=" + maChucVu + ", tenChucVu=" + tenChucVu + "]";
	}
	
	
}
