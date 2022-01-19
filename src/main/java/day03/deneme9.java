package day03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class deneme9 {

	public static void main(String[] args) {

		// günlük bilgilerini oluşturduk
		deneme8 gunluk1 = new deneme8(11, "Mehmet'in Gunlugu");
		deneme8 gunluk2 = new deneme8(12, "Alinin Gunlugu");
		deneme8 gunluk3 = new deneme8(13, "Tayyarın Gunlugu");
		deneme8 gunluk4 = new deneme8(14, "Osman ın Gunlugu");

		// kisi bilgilerini oluşturdum . kisiler tablosunu doldurdum
		deneme7 kisi1 = new deneme7(101, "Mehmet Can", 10);// insert into
		deneme7 kisi2 = new deneme7(102, "Ali Han", 9);
		deneme7 kisi3 = new deneme7(103, "Tayyar Tan", 11);
//günlüklere sahip atanması

		gunluk1.setKisi(kisi1);
		gunluk2.setKisi(kisi2);
		gunluk3.setKisi(kisi3);

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(deneme7.class)
				.addAnnotatedClass(deneme8.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

// gunluklerin ve kisilerin veritabanına kaydedilmesi
		session.save(gunluk1);
		session.save(gunluk2);
		session.save(gunluk3);
		session.save(gunluk4);
		session.save(kisi1);
		session.save(kisi2);
		session.save(kisi3);

//		

		tx.commit();
		session.close();
		sf.close();

	}

}