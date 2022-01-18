package day02;

import javax.persistence.Embeddable;

@Embeddable // sen tablocuksun ama ayri bir tablo gibi degilde, isime yarayacagin zaman
			// kullanacagim bir tablocuksun
public class deneme4 {

	private String winter;
	private String sommer;

	public deneme4() {
		
	}

	public deneme4(String winter, String sommer) {
	
		this.winter = winter;
		this.sommer = sommer;
	}

	public String getWinter() {
		return winter;
	}

	public void setWinter(String winter) {
		this.winter = winter;
	}

	public String getSommer() {
		return sommer;
	}

	public void setSommer(String sommer) {
		this.sommer = sommer;
	}

	@Override
	public String toString() {
		return "deneme4 [winter=" + winter + ", sommer=" + sommer + "]";
	}

}
