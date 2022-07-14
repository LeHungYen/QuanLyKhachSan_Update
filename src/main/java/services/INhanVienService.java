package services;

import java.util.ArrayList;

import models.NhanVienModel;

public interface INhanVienService {
	public void them(NhanVienModel nhanVienModel);
	public void sua(NhanVienModel nhanVienModel);
	public void updateListNhanVienModel();
	public ArrayList<NhanVienModel> getListNhanVienModel();
}
