package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Student extends ImenovanaKolekcija{
	
	private String ime;
	private String prezime;
	private String datumRodj;
	private String adresa;
	private String kontakt;
	private String email;
	private String brojIndeksa;
	private String datumUpisa;
	private String trenutnaGodinaStudija;
	private SStatus status;
	private String prosecnaOcena;
	private static List<Predmet> predmeti;
	private String naziv;
	private String vrednost;
	private Predmet pr;
	private RadniProstor radniProstor;
	public static List<Profesor> pp;
	
	public Student( String ime, String prezime, String datumRodj, String adresa, String kontakt, String email, String brojIndeksa, String datumUpisa,String trenutnaGodinaStudija, SStatus status,String prosecnaOcena,String predmeti,String naziv) {
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setDatumRodj(datumRodj);
		this.setAdresa(adresa);
		this.setKontakt(kontakt);
		this.setEmail(email);
		this.setBrojIndeksa(brojIndeksa);
		this.setDatumUpisa(datumUpisa);
		this.setTrenutnaGodinaStudija(trenutnaGodinaStudija);
		this.setStatus(status);
		this.setProsecnaOcena(prosecnaOcena);
		setPredmeti(new ArrayList<>());
		
	}
	
	public Student (String naziv, Predmet p,String v) {
		this.naziv=naziv;
		pp= new ArrayList<>();
		this.vrednost=v;
	
		predmeti=new ArrayList<>();
	}
	
	public Student (String brojIndeksa, String ime, String prezime, String tgs, SStatus status, String ocena ) {
		this.brojIndeksa=brojIndeksa;
		this.ime=ime;
		this.prezime=prezime;
		this.trenutnaGodinaStudija=tgs;
		this.status=status;
		this.prosecnaOcena=ocena;
	}
	

	
	public Student() {
		
	}
	
	public Student(String i) {
		brojIndeksa=i;
	}
	
	public String getNaziv(){
		return naziv;
		}
	public void setV(String naziv) {
		if (naziv == null) {
			throw new NullPointerException();
		}
		this.vrednost = naziv;
	}
	public String getV(){
		return vrednost;
		}
	public void setNaziv(String naziv) {
		if (naziv == null) {
			throw new NullPointerException();
		}
		this.naziv = naziv;
	}
	
	 public static void dodajPPar(Profesor ppar) {
			pp.add(ppar);
	   }
	 public static List<Profesor> getPPar() {
		 	return pp;
	   }
	   
	   public void obrisiPar(Profesor ppar) {
			this.pp.remove(ppar);
			changedSet();
			notifyObservers();
		}
	   
	   public Predmet getPredmet() {
		   return pr;
	   }
	   
	   public void insert(int index, Profesor ppar) {
		   pp.add(index, ppar);
		   changedSet();
		   notifyObservers();
	   }


	   @Override
		public ImenovanaKolekcija getChild(int index) {
			return null;
			//return p.get(index);
		}

		@Override
		public int getChildCount() {
			
			return pp.size();
		}
		
		@Override
		public int getIndexOfChild(ImenovanaKolekcija kolekcija) {
			
			return pp.indexOf(kolekcija);
		}

		public RadniProstor getRadniProstor() {
			return radniProstor;
		}

		public void setRadniProstor(RadniProstor radniProstor) {
			this.radniProstor = radniProstor;
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

		public String getDatumRodj() {
			return datumRodj;
		}

		public void setDatumRodj(String datumRodj) {
			this.datumRodj = datumRodj;
		}

		public String getAdresa() {
			return adresa;
		}

		public void setAdresa(String adresa) {
			this.adresa = adresa;
		}

		public String getKontakt() {
			return kontakt;
		}

		public void setKontakt(String kontakt) {
			this.kontakt = kontakt;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getBrojIndeksa() {
			return brojIndeksa;
		}

		public void setBrojIndeksa(String brojIndeksa) {
			this.brojIndeksa = brojIndeksa;
		}

		public String getDatumUpisa() {
			return datumUpisa;
		}

		public void setDatumUpisa(String datumUpisa) {
			this.datumUpisa = datumUpisa;
		}

		public String getTrenutnaGodinaStudija() {
			return trenutnaGodinaStudija;
		}

		public void setTrenutnaGodinaStudija(String trenutnaGodinaStudija) {
			this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		}

		public SStatus getStatus() {
			return status;
		}

		public void setStatus(SStatus status) {
			this.status = status;
		}

		public String getProsecnaOcena() {
			return prosecnaOcena;
		}

		public void setProsecnaOcena(String prosecnaOcena) {
			this.prosecnaOcena = prosecnaOcena;
		}

		public static List<Predmet> getPredmeti() {
			return predmeti;
		}
		public static void setPredmeti(List<Predmet> predmeti) {
			Student.predmeti = predmeti;
		}

		public String getVrednost() {
			return vrednost;
		}

		public void setVrednost(String vrednost) {
			this.vrednost = vrednost;
		}

		
}
