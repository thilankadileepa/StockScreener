package org.sixtynine.stock;

import org.hibernate.Session;
import org.sixtynine.stock.dao.User;
import org.sixtynine.stock.util.HibernateUtil;


/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		User user = new User();

		user.setId(1);
		user.setUserName("Thilanka");

		session.save(user);
		session.getTransaction().commit();

	}
}
