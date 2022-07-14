package services;

import java.util.ArrayList;

import dao.DichVuDao;
import entities.DichVu;
import utils.IoCContainer;
import models.DichVuModel;
public class DichVuService implements IDichVuService{
	private IoCContainer ioCContainer = new IoCContainer();
	private ArrayList<DichVuModel> _listDichVuModels = new ArrayList<DichVuModel>();
	private DichVuDao _dichVuDao = (DichVuDao) ioCContainer.getBean(DichVuDao.class.toString());
//	private DichVuModel _dichVuModel = (DichVuModel) IoCContainer.getBean(DichVuModel.class.toString());;
	private int _stt = 0;

	public DichVu updateDataDichVuDependOnDichVuModel(DichVuModel dichVuModel) {
//		_dichVu = (DichVu) ioCContainer.getBean(DichVu.class.toString());
		DichVu dichVu = new DichVu();
		dichVu.setMaDichVu(dichVuModel.getMaDichVu());
		dichVu.setTenDichVu(dichVuModel.getTenDichVu());
		dichVu.setGiaNhap(dichVuModel.getGiaNhap());
		dichVu.setGiaban(dichVuModel.getGiaban());
		dichVu.setSoLuongTon(dichVuModel.getSoLuongTon());
		dichVu.setTrangThai(dichVuModel.getTrangThai());
		return dichVu;
	}

	public void them(DichVuModel dichVuModel) {
//		if(checkDichVuExisted(dichVuModel)) {
		DichVu dichVu =updateDataDichVuDependOnDichVuModel(dichVuModel);
		_dichVuDao.them(dichVu);
		dichVuModel.setStt(_stt);
		_listDichVuModels.add(dichVuModel);
		_stt++;
//		}
		
	}
	
//	public boolean checkDichVuExisted(DichVuModel dichVuModel){
//		for(int i = 0 ; i<_listDichVuModels.size() ; i++) {
//			if(_listDichVuModels.get(i).getTenDichVu().equals(dichVuModel.getTenDichVu())) {
//				System.out.println("da chay vao day");
//				int soLuongTon_old = _listDichVuModels.get(i).getSoLuongTon();
//				long giaNhap_old = _listDichVuModels.get(i).getGiaNhap();
//				
//				int soLuongTon_new = dichVuModel.getSoLuongTon();
//				long giaNhap_new = dichVuModel.getGiaNhap();
//				
//				long giaNhap_average = ((soLuongTon_old*giaNhap_old) + (soLuongTon_new*giaNhap_new))/(soLuongTon_old+soLuongTon_new);
//				dichVuModel.setGiaNhap(giaNhap_average);
//				dichVuModel.setSoLuongTon(soLuongTon_new+soLuongTon_old);
//				
//				int sttDichVu_old = _listDichVuModels.get(i).getStt();
//				_listDichVuModels.get(i).setSoLuongTon(0);
//				_listDichVuModels.get(i).setTrangThai("Không Hoạt Động");
//				
//				DichVu dichVu_old = updateDataDichVuDependOnDichVuModel(_listDichVuModels.get(i));
//				
//				DichVu dichVu_new = updateDataDichVuDependOnDichVuModel(dichVuModel);
// 				_dichVuDao.themDichVuDaTonTai(dichVu_old, dichVu_new);
// 				
// 				
// 				_listDichVuModels.remove(sttDichVu_old);
// 				dichVuModel.setStt(_stt);
// 				_listDichVuModels.add(dichVuModel);
// 				_listDichVuModels.add(dichVuModel);
// 				return false;
//			}
//		}
//
//		return true;
//	}

	public void sua(DichVuModel dichVuModel) {
		suaDichVu(dichVuModel);
		int stt = dichVuModel.getStt();
		_listDichVuModels.remove(stt);
		_listDichVuModels.add(stt, dichVuModel);
	}
	public void xoa(DichVuModel dichVuModel) {
		suaDichVu(dichVuModel);
		int stt = dichVuModel.getStt();
		_listDichVuModels.remove(stt);
		_stt = 0;
		for(int i =0; i<_listDichVuModels.size();i++) {
			_listDichVuModels.get(i).setStt(_stt);
			_stt++;
		}
	}
	
	public void suaDichVu(DichVuModel dichVuModel) {
		DichVu dichVu =updateDataDichVuDependOnDichVuModel(dichVuModel);
		_dichVuDao.sua(dichVu);
	}

	public void updateListDichVuModel() {
		_dichVuDao.updateListDichVu();;
		ArrayList<DichVu> listDichVu = _dichVuDao.getListDichVu();
		for (DichVu dichVu : listDichVu) {
			DichVuModel dichVuModel = new DichVuModel();
			dichVuModel.setStt(_stt);
			dichVuModel.setMaDichVu(dichVu.getMaDichVu());
			dichVuModel.setTenDichVu(dichVu.getTenDichVu());
			dichVuModel.setGiaNhap(dichVu.getGiaNhap());
			dichVuModel.setGiaban(dichVu.getGiaban());
			dichVuModel.setSoLuongTon(dichVu.getSoLuongTon());
			dichVuModel.setTrangThai(dichVu.getTrangThai());
			_listDichVuModels.add(dichVuModel);
			_stt++;
		}

	}

	public ArrayList<DichVuModel> getListDichVuModel() {
		return _listDichVuModels;
	}

}
