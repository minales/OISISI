package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Student extends ImenovanaKolekcija{
	private String naziv;
	private String vrednost;
	private Predmet pr;
	private RadniProstor radniProstor;
	public static List<Profesor> pp;
	
	public Student (String naziv, Predmet p,String v) {
		this.naziv=naziv;
		pp= new ArrayList<>();
		this.vrednost=v;
		this.pr=p;
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

}
