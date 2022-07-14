package dao;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entities.DichVu;
import utils.DB_Connection;

public class DichVuDao implements IDichVuDao{
	
	private static ArrayList<DichVu> _listDichVus = new ArrayList<DichVu>();
	
	public void them(DichVu dichVu) {
		Session session = new DB_Connection().getSession(DichVu.class);
		session.beginTransaction();
		session.save(dichVu);
		session.getTransaction().commit();
		session.close();
	}
	
	public void themDichVuDaTonTai(DichVu dichVu_old , DichVu dichVu_new) {
		Session session = new DB_Connection().getSession(DichVu.class);
		session.beginTransaction();
		session.save(dichVu_new);
		session.update(dichVu_old);
		session.getTransaction().commit();
		session.close();
	}
	
	public void sua(DichVu dichVu) {
		Session session = new DB_Connection().getSession(DichVu.class);
		session.beginTransaction();
		session.update(dichVu);
		session.getTransaction().commit();
		session.close();
	}

	public void updateListDichVu() {
		Session session = new DB_Connection().getSession(DichVu.class);
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from dichVu where trangThai ='Hoạt Động'");
		query.addEntity(DichVu.class);
		_listDichVus = (ArrayList<DichVu>) query.list();
		session.getTransaction().commit();
		session.close();

	}

	public ArrayList<DichVu> getListDichVu() {
		return _listDichVus;
	}
	
	
}


