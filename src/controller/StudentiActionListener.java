package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Profesor;
import model.RadniProstor;
import model.Student;
import view.GlavniProzor;

public class StudentiActionListener implements ActionListener {

public static JTable tables;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		RadniProstor rp=GlavniProzor.getRp();
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		
		Object datas[][] = new Object[100][20];
		for (int i=0; i<rp.studenti.size(); i++) {
			datas[i][0] =rp.studenti.get(i).getBrojIndeksa();
			datas[i][1] =rp.studenti.get(i).getIme();
			datas[i][2] =rp.studenti.get(i).getPrezime();
			datas[i][3] =rp.studenti.get(i).getTrenutnaGodinaStudija();
			datas[i][4] =rp.studenti.get(i).getStatus();
			datas[i][5] =rp.studenti.get(i).getAdresa();
			datas[i][6] =rp.studenti.get(i).getDatumRodj();
			datas[i][7] =rp.studenti.get(i).getDatumUpisa();
			datas[i][8] =rp.studenti.get(i).getEmail();
			datas[i][9] =rp.studenti.get(i).getKontakt();
			datas[i][10] =rp.studenti.get(i).getProsecnaOcena();
				
			rp.studenti.get(i);
			
	}
	
		   String[] columnNamesp = {"Indeks", "Ime","Prezime","Godina","Status",
	        		"Ocena" }; 
	        tables = new JTable(datas, columnNamesp);
	        tables.setGridColor(Color.BLACK);
	        
	        tables.setRowSelectionAllowed(true);
	        tables.setAutoCreateRowSorter(true);//sortiranje rastuce-opadajuce
	        
	        
	        JScrollPane sps = new JScrollPane(tables, 
	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        sps.setPreferredSize(new Dimension(screen.width/2, 336));
		       
	        GlavniProzor.setDesno(sps);
	     
	     
		
	}
	
	
}
