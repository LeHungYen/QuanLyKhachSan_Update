package dao;

import java.util.ArrayList;

import entities.DichVu;

public interface IDichVuDao {
	public void them(DichVu dichVu);
	public void sua(DichVu dichVu);
	public void updateListDichVu();
	public ArrayList<DichVu> getListDichVu();
}
