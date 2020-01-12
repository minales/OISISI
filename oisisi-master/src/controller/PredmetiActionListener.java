package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.RadniProstor;
import view.GlavniProzor;

public class PredmetiActionListener  implements ActionListener {
	
	public static JTable tablePredmeti;
	public static JScrollPane sp;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		RadniProstor rp=GlavniProzor.getRp();
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		
		Object data1[][] = new Object[100][11];
		for (int i=0; i<rp.predmeti.size(); i++) {
			data1[i][0] =rp.predmeti.get(i).getNaziv();
			data1[i][1] =rp.predmeti.get(i).getS();
			data1[i][2] =rp.predmeti.get(i).getProfesor().getIme();
			data1[i][3] =rp.predmeti.get(i).getSemestar();
			data1[i][4] =rp.predmeti.get(i).getGodinaStudija();
			
		         
	}
		
	  
	        String[] columnNames1 = {"Ime", "Sifra","Profesor","Semestar","Gopdina studija" }; 
	        tablePredmeti = new JTable(data1, columnNames1);
	        tablePredmeti.setGridColor(Color.BLACK);
	        tablePredmeti.setRowSelectionAllowed(true);
	        tablePredmeti.setAutoCreateRowSorter(true);//sortiranje rastuce-opadajuce
	        
	        sp = new JScrollPane(tablePredmeti, 
	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        sp.setPreferredSize(new Dimension(screen.width/2, 336));
	        sp.setMinimumSize(new Dimension(screen.width/2, 336));
	        
	        GlavniProzor.setDesno(sp);
		
	}

}
