package day02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class deneme5 {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(deneme3.class)
				.buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		deneme4 frucht1 = new deneme4("nein", "ja");

		deneme3 produkt1 = new deneme3(4553, "Birne", 5, frucht1);
		session.save(produkt1);
		session.save(new deneme3(4554, "Granatapfel", 8, new deneme4("ja", "nein")));

		// fetch islemi
		System.out.println("1 Frucht : " + session.get(deneme3.class, 4554));

		// delete islemi
		session.delete(session.get(deneme3.class, 4553));

		// update islemi
		session.get(deneme3.class, 4554).setName("Orange");
		;

		tx.commit();
		session.close();
		sf.close();

	}

}
