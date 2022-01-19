package day03;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="gunlukler")
public class deneme8 {
	
	@Id
	private int no;
    private String yazilar;
                                     //sadece id lerden join oluyor. emmedable ise class ın tamamını gömmek
   
    @OneToOne
    @JoinColumn(name="kisi_no")      //buraya istersen kisi_adi yaz yine id ile bağlanır sql de bağlantı sütun başlığı
    private deneme7 kisi;     //kisi_adi olur ama içerik id. çünkü id column un başına @id (unıque olan kısım) yazdık
     //id+ad+yas               //burda kisi_id yada kisiId almamız önemli değil ama sql koduyla da çalışabilmesi için,
                                    //sonradan verilen isim önemli
   


    public deneme8() {};
    
	public deneme8(int no, String yazilar) {
		this.no = no;
		this.yazilar = yazilar;
	
	
	}

	public int getId() {
		return no;
	}

	public void setId(int id) {
		this.no = id;
	}

	public String getYazilar() {
		return yazilar;
	}

	public void setYazilar(String yazilar) {
		this.yazilar = yazilar;
	}

	public deneme7 getKisi() {
		return kisi;
	}

	public void setKisi(deneme7 kisi) {//save classındaki setter buradan geliyor
		this.kisi = kisi;
	}

	@Override
	public String toString() {
		return "H2_Gunluk id=" + no + ", yazilar=" + yazilar + ", kişi=" + kisi ; //sql deki tabloda buraya (ogrenci objesi ekli old için)
		//ogrenci class ından id gelecek, şu id li şu ogr_id li şu yazılı öğrenci demiş oluyoruz
		//ama javada yazdırırsak, id, yazı, ogrenci (id,isim,not) gözükür
	}

		
}