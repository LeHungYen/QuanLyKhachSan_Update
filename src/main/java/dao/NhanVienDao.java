package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.ChucVu;
import entities.NhanVien;
import utils.DB_Connection;
import utils.IoCContainer;

public class NhanVienDao implements INhanVienDao{
	private static ArrayList<NhanVien> _listNhanViens = new ArrayList<NhanVien>();
	private int maxID;
	public void them(NhanVien nhanVien) {
		Session session = new DB_Connection().getSession(NhanVien.class);
		session.beginTransaction();
		session.save(nhanVien);
		session.getTransaction().commit();
		session.close();
	}

	public void sua(NhanVien nhanVien) {
		Session session = new DB_Connection().getSession(NhanVien.class);
		session.beginTransaction();
		session.update(nhanVien);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateListNhanVien() {
		Session session = new DB_Connection().getSession(NhanVien.class);
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from nhanVien where trangThai = 'Hoạt động'");
		query.addEntity(NhanVien.class);
		_listNhanViens = (ArrayList<NhanVien>) query.list();
		session.getTransaction().commit();
		session.close();
		getMaxID(_listNhanViens);
	}
	
	public void getMaxID(ArrayList<NhanVien> listNhanVien) {
		if(listNhanVien.size()==0) {
			maxID =1;
		}else {
			maxID = utils.Utilities.splitIdFromIdByNameAndId(_listNhanViens.get(_listNhanViens.size()-1).getMaNV()+"");
			maxID++;
		}
	}

	public ArrayList<NhanVien> getListNhanVien() {
		return _listNhanViens;
	}
	
	public int getMaxID() {
		return maxID;
	}


}
