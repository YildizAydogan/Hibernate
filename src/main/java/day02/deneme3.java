package day02;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Produckt")
public class deneme3 {

	@Id
	private int Id;
	private String Name;
	private int Anzahl;
	private deneme4 Jahreszeiten;

	public deneme3() {

	}

	public deneme3(int id, String name, int anzahl, deneme4 jahreszeiten) {
		super();
		Id = id;
		Name = name;
		Anzahl = anzahl;
		Jahreszeiten = jahreszeiten;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAnzahl() {
		return Anzahl;
	}

	public void setAnzahl(int anzahl) {
		Anzahl = anzahl;
	}

	public deneme4 getJahreszeiten() {
		return Jahreszeiten;
	}

	public void setJahreszeiten(deneme4 jahreszeiten) {
		Jahreszeiten = jahreszeiten;
	}

	@Override
	public String toString() {
		return "deneme3 [Id=" + Id + ", Name=" + Name + ", Anzahl=" + Anzahl + ", Jahreszeiten=" + Jahreszeiten + "]";
	}

	
}