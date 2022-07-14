package utils;

import java.util.HashMap;
import java.util.Map;

import dao.ChucVuDao;
import dao.DichVuDao;
import dao.IChucVuDao;
import dao.IDichVuDao;
import dao.INhanVienDao;
import dao.NhanVienDao;
import entities.ChucVu;
import entities.DichVu;
import models.DichVuModel;
import services.ChucVuService;
import services.DichVuService;
import services.IChucVuService;
import services.IDichVuService;
import services.INhanVienService;
import services.NhanVienService;


public class IoCContainer {
	private static Map<String, Object> container;
	static {
		container = new HashMap<String, Object>();
	}

	public static Object getBean(String classNameSpace) {
		switch (classNameSpace) {
		case "class utils.Utilities":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			Utilities utilities = new Utilities();
			container.put(classNameSpace, utilities);
			return utilities;
		case "class utils.DB_Connection":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			DB_Connection db_Connection = new DB_Connection();
			container.put(classNameSpace, db_Connection);
			return db_Connection;
		case "class entities.DichVu":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			DichVu dichVu = new DichVu();
			container.put(classNameSpace, dichVu);
			return dichVu;
		case "class models.DichVuModel":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			DichVuModel dichVuModel = new DichVuModel();
			container.put(classNameSpace, dichVuModel);
			return dichVuModel;
		case "class dao.DichVuDao":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			IDichVuDao dichVuDao = new DichVuDao();
			container.put(classNameSpace, dichVuDao);
			return dichVuDao;
		case "class services.DichVuService":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			IDichVuService dichVuService = new DichVuService();
			container.put(classNameSpace, dichVuService);
			return dichVuService;
		case "class services.NhanVienService":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			INhanVienService nhanVienService = new NhanVienService();
			container.put(classNameSpace, nhanVienService);
			return nhanVienService;
		case "class dao.NhanVienDao":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			INhanVienDao nhanVienDao = new NhanVienDao();
			container.put(classNameSpace, nhanVienDao);
			return nhanVienDao;
		case "class dao.ChucVuDao":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			IChucVuDao chucVuDao = new ChucVuDao();
			container.put(classNameSpace, chucVuDao);
			return chucVuDao;
		case "class services.ChucVuService":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			IChucVuService chucVuService = new ChucVuService();
			container.put(classNameSpace, chucVuService);
			return chucVuService;
			
		
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(ChucVu.class);
	}
}
