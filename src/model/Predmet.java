package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Predmet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String naziv;
	private String sifra;
	private String semestar;
	private ImageIcon ikonica;
	private Profesor profesor;
	private static List<Student> studenti;
	private String godinaStudija;
	public static final int MAX_VELICINA_IKONICE = 64;
	
	public Predmet (String naziv,String o, Profesor k, String v, String g) {
		this.naziv = naziv;
		this.setProfesor(k);
		this.sifra=o;
		//this.ikonica=i;
		this.semestar=v;
		studenti= new ArrayList<>();
		this.godinaStudija=g;
	}
	
	public String getNaziv(){
		return naziv;
		}
	public void setNaziv(String naziv) {
		if (naziv == null) {
			throw new NullPointerException();
		}
		this.naziv = naziv;
	}
	public void setSemestar(String naziv) {
		if (naziv == null) {
			throw new NullPointerException();
		}
		this.semestar = naziv;
	}
	public String getS(){
		return sifra;
		}
	public void setS(String naziv) {
		if (naziv == null) {
			throw new NullPointerException();
		}
		this.sifra = naziv;
	}
	public String getSemestar(){
		return semestar;
		}
	
	
	public ImageIcon getIkonica() {
		return ikonica;
	}

	public void setIkonica(ImageIcon ikonica) {
		if (ikonica != null) {
			if (ikonica.getIconHeight() > MAX_VELICINA_IKONICE || ikonica.getIconWidth() > MAX_VELICINA_IKONICE) {
				throw new IllegalArgumentException(" "
						+ MAX_VELICINA_IKONICE + " piksela");

			}
		}
		this.ikonica = ikonica;
	}
	
	 public void dodajStudenta(Student par) {
			studenti.add(par);
	   }
	 public static List<Student> getStudenti() {
			return studenti;
	   }
	   
	   public static void obrisiStudenta(Student par) {
			studenti.remove(par);
		}
	   
		
		public int getIndexOfChild(ImenovanaKolekcija kolekcija) {
			
			return studenti.indexOf(kolekcija);
		}

		public String getGodinaStudija() {
			return godinaStudija;
		}

		public void setGodinaStudija(String godinaStudija) {
			this.godinaStudija = godinaStudija;
		}

		public Profesor getProfesor() {
			return profesor;
		}

		public void setProfesor(Profesor profesor) {
			this.profesor = profesor;
		}

}
