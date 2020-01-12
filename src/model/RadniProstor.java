package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


public class RadniProstor extends ImenovanaKolekcija {
	
   public List<Profesor> profesori;
   public List<Student> studenti;
   public List<Predmet> predmeti;
   private ImageIcon ikonica;
   public String ime;
   public static final int MAX_VELICINA_IKONICE = 14;
 
   
   public RadniProstor(String ime){
	   this.ime = ime;
	   profesori = new ArrayList<>();
	   predmeti =new ArrayList<>();
   }
   public List<Profesor> getProfesori() {
	   return profesori;
   }
   public List<Predmet> getPredmeti() {
	   return predmeti;
   }
   public List<Student> getStudenti() {
	   return studenti;
   }
   
   public void dodajProfesora(Profesor k){
	   profesori.add(k);
	   changedSet();
	   notifyObservers();
   }
   
   public void obrisiProfesora(Profesor k){
	   profesori.remove(k);
	   changedSet();
	   notifyObservers();
   }
   
   public void insert(int index, Profesor k) {
	   profesori.add(index, k);
	   changedSet();
	   notifyObservers();
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


	@Override
	public int getChildCount() {
		return profesori.size();
	}
	
	public String getIme(){
		return ime;
	}
	@Override
	public ImenovanaKolekcija getChild(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getIndexOfChild(ImenovanaKolekcija kolekcija) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}