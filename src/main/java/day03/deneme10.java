package day03;
import java.util.Arrays;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class deneme10 {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(deneme7.class)
				.addAnnotatedClass(deneme8.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
	
		Transaction tx = session.beginTransaction();
		
		 
		//1)id=101 olan kişinin bilgilerin get() metodu ile sorgulayalim.

//		deneme7 person = session.get(deneme7.class, 101);
//	System.out.println(person); //Kisi : kisiId=101, kisiAd=Mehmet Can, kisiYas=10
////				
//	System.out.println();
//	
////		//2)id=12 olan gunlugun bilgilerini getirelim.
//	deneme8 diary = session.get(deneme8.class, 12);
//		System.out.println(diary); //deneme8 [id=12, yazilar=Alinin Gunlugu, kisi=Kisi : kisiId=102, kisiAd=Ali Han, kisiYas=9]
////		                            //deneme8 class ından obje: toString de olanlar (id,yazılar)+ kisi (H1_Kisi class ından ) içindeki toStringler(id,ad,yas)
////		
//		

		deneme7 person = session.get(deneme7.class, 101);
	System.out.println(person); //Kisi : kisiId=101, kisiAd=Mehmet Can, kisiYas=10
//				
	System.out.println();
	
//		//2)id=12 olan gunlugun bilgilerini getirelim.
	 
		System.out.println(session.get(deneme8.class, 12)); //deneme8 [id=12, yazilar=Alinin Gunlugu, kisi=Kisi : kisiId=102, kisiAd=Ali Han, kisiYas=9]
//		                            //deneme8 class ından obje: toString de olanlar (id,yazılar)+ kisi (H1_Kisi class ından ) içindeki toStringler(id,ad,yas)

//		// SQL komutlari 
	    	String sql1 = "SELECT k.kisi_adi, g.yazilar, k.kisiYas "
					+ "FROM kisiler k INNER JOIN gunlukler g "
				+ "ON k.kisi_id = g.kisi_no";
//////		Object [] yazıyoruz (deneme7 yada deneme8 yazmıyoruz) ikisinden de veri var çünkü. ve object array i halinde yazdığımız için 
		//Arrays.toString(w) şeklinde run ettik
		
		List <Object[]> sonucListesi1 = session.createSQLQuery(sql1).getResultList();//sql1 i SQL de create edip sonuç listesini getiriyoruz
				for(Object [] w: sonucListesi1) {
			System.out.println("ilk"+Arrays.toString(w));
	}
////	
				System.out.println();
////		// HQL komutlari (Sadece Class ve degisken isimleri kullanimalidir. 
////		// Tablo tarafindaki isimlerdirmeler kullanilmaz)
	
				
				//**********3. SORUYU HİBERNATE İLE ÇÖZÜNÜZ*****************************
////		
//	//	4)Günlük tablosundan öğrenci adını, günlük adını ve kayıtların öğrenci yasını getir

//		
//		//YAVAŞ çalıştığı için tercih edilmez, her satır için ayrı sorgu yolluyor mysql e
////		for (int i = 12; i < 15; i++) {
////			System.out.println("jpa"+session.get(de.class, i));	
////		}
//		System.out.println();
//		
//		// save class ında JPA ile kolayca çağırdıklarımızı, alttakiler gibi sql ve hql'le de çağırabiliriz
//		System.out.println();
////		//3) Kisiler ve Gunlukler tablolarindaki ortak olan (one to one ile birebir bağladığımız) kayıtların,
////		// Kisi adi, gunluk yazisi(yazilar) ve kisi yası (kisiYas) bilgilerini sorgulayiniz.
////		
////		// SQL komutlari 
//	    	String sql1 = "SELECT k.kisi_adi, g.yazilar, k.kisiYas "
//					+ "FROM kisiler k INNER JOIN gunlukler g "
//				+ "ON k.kisi_id = g.kisi_no";
////////		Object yazıyoruz (deneme7 yada deneme8 yazmıyoruz) ikisinden de veri var çünkü
//		
//		
//		List <Object[]> sonucListesi1 = session.createSQLQuery(sql1).getResultList();//sql1 i SQL de create edip sonuç listesini getiriyoruz
//				for(Object [] w: sonucListesi1) {
//			System.out.println("ilk"+Arrays.toString(w));
//	}
//////	
//				System.out.println();
//////		// HQL komutlari (Sadece Class ve degisken isimleri kullanimalidir. 
//////		// Tablo tarafindaki isimlerdirmeler kullanilmaz)
//	
//				
//				//**********3. SORUYU HİBERNATE İLE ÇÖZÜNÜZ*****************************
//////		
////	//	4)Günlük tablosundan öğrenci adını, günlük adını ve kayıtların öğrenci yasını getir
////		
////		System.out.println();
////		System.out.println();
//////		
//////**********	 Hibernate ile ÇÖZÜNÜZ*******************
////		
//		System.out.println();
//////		
////		
////		//5) İki tablodaki kayıtlarin herseyini sorgulaylim.
//////burada select * ye gerek yok
//		String hql3 = "FROM H1_Kisi k  JOIN H2_Gunluk g "
//				    + "ON k.kisiId = g.kisi";
//		
//		List <Object []> sonucListesi3 = session.createQuery(hql3).getResultList();
//		sonucListesi3.forEach((x) -> System.out.println(Arrays.toString(x)));
////		
		tx.commit()	;
		session.close();
		sf.close();
	}

}
