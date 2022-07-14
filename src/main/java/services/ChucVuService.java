package services;

import java.util.ArrayList;

import dao.ChucVuDao;
import dao.NhanVienDao;
import entities.ChucVu;
import entities.NhanVien;
import models.ChucVuModel;
import models.NhanVienModel;
import utils.IoCContainer;

public class ChucVuService implements IChucVuService{
	private IoCContainer ioCContainer = new IoCContainer();
	private ArrayList<ChucVuModel> _listChucVuModels = new ArrayList<ChucVuModel>();
	private ChucVuDao _chucVuDao = (ChucVuDao) ioCContainer.getBean(ChucVuDao.class.toString());
	private ChucVu _chucVu;
	private ChucVuModel _chucVuModel = (ChucVuModel) IoCContainer.getBean(ChucVuModel.class.toString());;
	private int _stt = 0;

	public static ChucVu updateDataChucVuDependOnChucVuModel(ChucVuModel chucVuModel) {
		ChucVu chucVu = new ChucVu();
		chucVu.setMaChucVu(chucVuModel.getMaChucVu());
		chucVu.setTenChucVu(chucVuModel.getTenChucVu());
		return chucVu;
	}

	public void them(ChucVuModel chucVuModel) {
		_chucVu = updateDataChucVuDependOnChucVuModel(chucVuModel);
		_chucVuDao.them(_chucVu);
		chucVuModel.setStt(_stt);
		_listChucVuModels.add(_stt, chucVuModel);
		_stt++;
	}

	public void sua(ChucVuModel chucVuModel) {
		_chucVu = updateDataChucVuDependOnChucVuModel(chucVuModel);
		_chucVuDao.sua(_chucVu);
		int stt = chucVuModel.getStt();
		_listChucVuModels.remove(stt);
		_listChucVuModels.add(stt, chucVuModel);
	}
	
	public void updateListChucVuModel() {
		_chucVuDao.updateListChucVu();
		ArrayList<ChucVu> listChucVu = _chucVuDao.getListChucVu();
		for (ChucVu chucVu : listChucVu) {
			_chucVuModel = new ChucVuModel();
			_chucVuModel.setStt(_stt);
			_chucVuModel.setMaChucVu(chucVu.getMaChucVu());
			_chucVuModel.setTenChucVu(chucVu.getTenChucVu());
			_listChucVuModels.add(_chucVuModel);
			_stt++;
		}

	}

	public ArrayList<ChucVuModel> getListChucVuModel() {
		return _listChucVuModels;
	}

}
