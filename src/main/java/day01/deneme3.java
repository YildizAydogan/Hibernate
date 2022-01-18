package day01;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class deneme3 {

	public static void main(String[] args) {
		
		SessionFactory sf=	new Configuration().configure("hibernate.cfg.xml")
			                .addAnnotatedClass(deneme1.class).buildSessionFactory();
			
		Session session =sf.openSession();
		Transaction tx=session.beginTransaction();
		
		
	
		
		System.out.println(session.get(deneme1.class,4549)); 
		System.out.println(session.get(deneme1.class, 4552).getProdukt_Anzahl());
	    System.out.println(session.get(deneme1.class, 4550).getProdukt_Name());	
       
	    
	    
	    
	    tx.commit();		
		sf.close();
		session.close();
	   
	}

}
