package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Profesor;
import model.RadniProstor;
import view.GlavniProzor;

public class ProfesoriActionListener implements ActionListener {
	
	//private static GlavniProzor mf;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		RadniProstor rp=GlavniProzor.getRp();
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		
		Object datap[][] = new Object[100][11];
		for (int i=0; i<rp.profesori.size(); i++) {
			datap[i][0] =rp.profesori.get(i).getIme();
			datap[i][1] =rp.profesori.get(i).getPrezime();
			datap[i][2] =rp.profesori.get(i).getDatumRodjena();
			datap[i][3] =rp.profesori.get(i).getAdresaStanovanja();
			datap[i][4] =rp.profesori.get(i).getTelefon();
			datap[i][5] =rp.profesori.get(i).getEmail();
			datap[i][6] =rp.profesori.get(i).getAdresaKancelarije();
			datap[i][7] =rp.profesori.get(i).getBrojLicne();
			datap[i][8] =rp.profesori.get(i).getTitula();
			datap[i][9] =rp.profesori.get(i).getZvanje();
			rp.profesori.get(i);
			datap[i][10] =Profesor.getPredmeti();         
	}
		
	  
	        String[] columnNamesp = {"Ime", "Prezime","Datum rodjenja","Adresa stanovanja","Kontakt telefon",
	        		"E-mail adresa","Adresa kancelarije","Broj licne karte","Titula","Zvanje",
	        		"Spisak predmeta na kojima je profesor" }; 
	        JTable tablep = new JTable(datap, columnNamesp);
	        tablep.setGridColor(Color.BLACK);
	        
	        JScrollPane spp = new JScrollPane(tablep, 
	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        spp.setPreferredSize(new Dimension(screen.width/2, 336));
	        
	        GlavniProzor.setDesno(spp);
	        GlavniProzor.ocistiDesno(); 
	        //GlavniProzor.proba();
	        
	        
	        System.out.println("aaaaaaaaaa");
		
	}

}
