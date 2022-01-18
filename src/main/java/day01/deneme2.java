package day01;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class deneme2 {

	public static void main(String[] args) {
		// 1---- Yazdigimiz hibernate.cfg den tum bilgileri alsin diye configuration
		// olusturucam
		// Configuration i da org.hibernate den import edilecek unutma

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(deneme1.class);
		SessionFactory sf = con.buildSessionFactory(); // fabrika acip alan insa ediyorum
		Session session = sf.openSession(); // alani actik ve bolumlerini olusturmak icin yapmaliyim

		Transaction tx = session.beginTransaction();
		deneme1 d1 = new deneme1(4549, "Wassermelon", 1);
		session.save(d1);
		session.save(new deneme1(4550, "Zitrone", 3));
		session.save(new deneme1(4551, "Heidelbeeren", 4));
		session.save(new deneme1(4552, "Banane", 10));

		tx.commit();
		sf.close();
		session.close();
	}

}
