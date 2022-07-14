package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DB_Connection {
	public static Session getSession(Configuration configuration) {
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		return session;
	}
	
	public static Session getSession(Class name) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(name);
		Session session = getSession(configuration);
		return session;
	}
	public static Session getSession(Class name , Class name1) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(name).addAnnotatedClass(name1);
		Session session = getSession(configuration);
		return session;
	}
	public static Session getSession(Class name , Class name1 ,Class name2) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(name).addAnnotatedClass(name1).addAnnotatedClass(name2);
		Session session = getSession(configuration);
		return session;
	}
	public static Session getSession(Class name, Class name1 , Class name2 , Class name3) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(name).addAnnotatedClass(name1).addAnnotatedClass(name2).addAnnotatedClass(name3);
		Session session = getSession(configuration);
		return session;
	}
}
