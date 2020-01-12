package controller;


import model.ImenovanaKolekcija;
import model.Predmet;
import model.RadniProstor;
import model.Student;
import model.Profesor;

public class KomandaDodavanja implements Command {

	private ImenovanaKolekcija imenovanaKolekcija;
	
	public  KomandaDodavanja(ImenovanaKolekcija imenovanaKolekcija) {
		this.imenovanaKolekcija = imenovanaKolekcija;
	}
	
	@Override
	public void execute() {
		if (imenovanaKolekcija instanceof RadniProstor) {
			
		}else if(imenovanaKolekcija instanceof Profesor) {
			Profesor k = (Profesor)imenovanaKolekcija;
			k.getRadniProstor().dodajProfesora(k);
		}else if(imenovanaKolekcija instanceof Predmet) {
			Predmet p = (Predmet)imenovanaKolekcija;
			p.getProfesor().dodajPredmet(p);
		}else if(imenovanaKolekcija instanceof Student) {
			Student pa = (Student)imenovanaKolekcija;
			pa.getPredmet().dodajStudenta(pa);
		}
		
	}

	@Override
	public void unexecute() {
if (imenovanaKolekcija instanceof RadniProstor) {
			
		}else if(imenovanaKolekcija instanceof Profesor) {
			Profesor k = (Profesor)imenovanaKolekcija;
			k.getRadniProstor().obrisiProfesora(k);
		}else if(imenovanaKolekcija instanceof Predmet) {
			Predmet p = (Predmet)imenovanaKolekcija;
			p.getProfesor().obrisiPredmet(p);
		}else if(imenovanaKolekcija instanceof Student) {
			Student pa = (Student)imenovanaKolekcija;
			pa.getPredmet().obrisiStudenta(pa);
		}
		
	}

	@Override
	public String getDescription() {
		
		return "Ubacen element " + imenovanaKolekcija.getIme() ;
	}

}
