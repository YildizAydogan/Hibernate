package day01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

// HIBERNATE ICIN TABLO TANIMLAMASININ YAPILMASI 
		//tablo oluşturabilmek için içerik hazırlama )alttakiler)
		//POJO: Plain Old Java Object									
		//1) Private degiskenler tanimlanir.
		//2) constructor olusturulur.
		//3) Getter ve Setter metotlar tanimlanir.
		//4) toString() metodu ile nesne yazdirilabilir hale getirilir.
	


@Entity  // sen tablesin demek icin bunu yapmaliyim
@Table(name = "depo")
public class deneme1{
    @Id                              //Primary key yaptim
	private int belegId;
    private String produkt_Name;    
    @Column(name = "produkt_Menge") // sutunun sql deki adi degisti
    private int produkt_Anzahl;
    @Transient                      // sql de gorunmez artik ama eclipsede kullanabiliriz tabiki
    private double summe;
   
     //1-------Unutmadan bos bir construcktor olusturalimki illaki ise yarar
    public deneme1() {
    	
    	
    }
   
        
     //2---------Bundan sonra artik source dan fielsli construcktor yapiyoruz-------- 
	public deneme1(int belegId, String produkt_Name, int produkt_Anzahl) {
	//	super(); olusan superi de siliyorum
		this.belegId = belegId;
		this.produkt_Name = produkt_Name;
		this.produkt_Anzahl = produkt_Anzahl;
		
		
			
	}
    //3------Getter-Setterlarda olustu

	public int getBelegId() {
		return belegId;
	}


	public void setBelegId(int belegId) {
		this.belegId = belegId;
	}


	public String getProdukt_Name() {
		return produkt_Name;
	}


	public void setProdukt_Name(String produkt_Name) {
		this.produkt_Name = produkt_Name;
	}


	public int getProdukt_Anzahl() {
		return produkt_Anzahl;
	}


	public void setProdukt_Anzahl(int produkt_Anzahl) {
		this.produkt_Anzahl = produkt_Anzahl;
	}

    //4---------toString de yapmaliyimki yazdirmak icin, ekranda gorebilmek icin bu da sart
	@Override
	public String toString() {
		return "deneme1 [belegId=" + belegId + ", produkt_Name=" + produkt_Name + ", produkt_Anzahl=" + produkt_Anzahl
				+ "]";
	}
	
	
	
}
