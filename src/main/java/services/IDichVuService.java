package services;

import java.util.ArrayList;

import models.DichVuModel;

public interface IDichVuService {
	public void them(DichVuModel dichVuModel);
	public void sua(DichVuModel dichVuModel);
	public void updateListDichVuModel();
	public ArrayList<DichVuModel> getListDichVuModel();
}
