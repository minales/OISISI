package model;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


public class Profesor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ime;
	private String prezime;
	private int datumRodjena;
	private String adresaStanovanja;
	private int telefon;
	private String email;
	private String adresaKancelarije;
	private int brojLicne;
	private String titula;
	private String zvanje;
	private ImageIcon ikonica;
	private static List<Predmet> predmeti;
	private RadniProstor radniProstor;
	public static final int MAX_VELICINA_IKONICE = 64;
	
	public Profesor (String ime,String prezime,int dr,int licna,int telefon,String mail,String kancelarija,String stanovanje,String titula,String zvanje){
		//this.radniProstor = radniProstor;
		this.setIme(ime);
		this.setAdresaStanovanja(stanovanje);
		this.setPrezime(prezime);
		this.setDatumRodjena(dr);
		this.setTelefon(telefon);
		this.setEmail(mail);
		this.setAdresaKancelarije(kancelarija);
		this.setBrojLicne(licna);
		this.setTitula(titula);
		this.setZvanje(zvanje);
		/*ImageIcon imageIcon = new ImageIcon("slike/komp1.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		ikonica=new ImageIcon(newimg);*/
		//ikonica = null;
		//lblIkonica.setIcon(icon);
		setPredmeti(new ArrayList<>());
	}
	public Profesor (String ime,String prezime,int l){
		this.setIme(ime);
		this.setBrojLicne(l);
		this.setPrezime(prezime);
		/*ImageIcon imageIcon = new ImageIcon("slike/komp1.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		ikonica=new ImageIcon(newimg);*/
		//ikonica = null;
		//lblIkonica.setIcon(icon);
	}
	
	public Profesor (){
		
	}

	public Profesor (String i){
		ime=i;
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

		public int getIndexOfChild(ImenovanaKolekcija kolekcija) {
			return getPredmeti().indexOf(kolekcija);
			
		}

		
		public RadniProstor getRadniProstor() {
			return radniProstor;
		}
		public String getIme() {
			return ime;
		}
		public void setIme(String ime) {
			this.ime = ime;
		}
		public String getPrezime() {
			return prezime;
		}
		public void setPrezime(String prezime) {
			this.prezime = prezime;
		}
		public int getDatumRodjena() {
			return datumRodjena;
		}
		public void setDatumRodjena(int datumRodjena) {
			this.datumRodjena = datumRodjena;
		}
		public String getAdresaStanovanja() {
			return adresaStanovanja;
		}
		public void setAdresaStanovanja(String adresaStanovanja) {
			this.adresaStanovanja = adresaStanovanja;
		}
		public int getTelefon() {
			return telefon;
		}
		public void setTelefon(int telefon) {
			this.telefon = telefon;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAdresaKancelarije() {
			return adresaKancelarije;
		}
		public void setAdresaKancelarije(String adresaKancelarije) {
			this.adresaKancelarije = adresaKancelarije;
		}
		public int getBrojLicne() {
			return brojLicne;
		}
		public void setBrojLicne(int brojLicne) {
			this.brojLicne = brojLicne;
		}
		public String getTitula() {
			return titula;
		}
		public void setTitula(String titula) {
			this.titula = titula;
		}
		public String getZvanje() {
			return zvanje;
		}
		public void setZvanje(String zvanje) {
			this.zvanje = zvanje;
		}
		public static List<Predmet> getPredmeti() {
			return predmeti;
		}
		public static void setPredmeti(List<Predmet> predmeti) {
			Profesor.predmeti = predmeti;
		}

	
}
