package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import model.Profesor;
import model.RadniProstor;
import view.GlavniProzor;

public class ProfesoriActionListener implements ActionListener {
	
	//private static GlavniProzor mf;
	public static JTable tablep;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		RadniProstor rp=GlavniProzor.getRp();
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		
		Object datap[][] = new Object[100][11];
		JLabel spisak=new JLabel("Spisak studenata");
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
			
			datap[i][10] =spisak;
			
			String [] week = null;
			Profesor p=rp.profesori.get(i);
			
			MouseListener sl=new MouseListener() {


				@Override
				public void mouseClicked(MouseEvent arg0) {
					JFrame dodaj= new JFrame();
					dodaj.setSize(466, 444);
					dodaj.setLocationRelativeTo(GlavniProzor.getInstance());
					for (int ii=0; ii<p.getPredmeti().size(); ii++) {
					week[ii]= p.getPredmeti().get(ii).getNaziv();
					}
	          
			        JList b= new JList(week);
			        dodaj.add(b);
			        dodaj.setVisible(true);
					
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			};
			spisak.addMouseListener(sl);
			//datap[i][10] =Profesor.getPredmeti();         
	}
		
	  
	        String[] columnNamesp = {"Ime", "Prezime","Datum rodjenja","Adresa stanovanja","Kontakt telefon",
	        		"E-mail adresa","Adresa kancelarije","Broj licne karte","Titula","Zvanje",
	        		"Spisak predmeta na kojima je profesor" }; 
	        tablep = new JTable(datap, columnNamesp);
	        tablep.setGridColor(Color.BLACK);
	        
	        JScrollPane spp = new JScrollPane(tablep, 
	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        spp.setPreferredSize(new Dimension(screen.width/2, 336));
	        
	        GlavniProzor.setDesno(spp);
	        //GlavniProzor.ocistiDesno(); 
	        //GlavniProzor.proba();
	        GlavniProzor mf=GlavniProzor.getInstance();
	        mf.select.add(new JButton("aaaaaaaaaaaaa"));
	        mf.revalidate();
	        mf.repaint();
	        
	        System.out.println("aaaaaaaaaa");
		
	}

}
