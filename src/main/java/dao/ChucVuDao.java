package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.ChucVu;
import utils.DB_Connection;

public class ChucVuDao implements IChucVuDao{
private static ArrayList<ChucVu> _listChucVus = new ArrayList<ChucVu>();
	
	public void them(ChucVu chucVu) {
		Session session = new DB_Connection().getSession(ChucVu.class);
		session.beginTransaction();
		session.save(chucVu);
		session.getTransaction().commit();
		session.close();
	}

	public void sua(ChucVu chucVu) {
		Session session = new DB_Connection().getSession(ChucVu.class);
		session.beginTransaction();
		session.update(chucVu);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListChucVu() {
		Session session = new DB_Connection().getSession(ChucVu.class);
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from chucVu");
		query.addEntity(ChucVu.class);
		_listChucVus = (ArrayList<ChucVu>) query.list();
		session.getTransaction().commit();
		session.close();
		
	}

	public ArrayList<ChucVu> getListChucVu() {
		return _listChucVus;
	}
	
//	public static void main(String[] args) {
//		ChucVu chucVu = new ChucVu(1, "Quản lý");
//		ChucVuDao chucVuDao = new ChucVuDao();
//		chucVuDao.them(chucVu);
//		
//	
//	}

}
