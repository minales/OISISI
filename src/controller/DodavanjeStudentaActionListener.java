package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.*;
import model.Predmet;
import model.Profesor;
import model.SStatus;
import model.Student;
import view.GlavniProzor;
import view.SelectBar;

public class DodavanjeStudentaActionListener implements ActionListener {

	Student stud;
	SStatus ss= SStatus.S;
	String po= null; 
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		JFrame f= new JFrame("Dodavanje novog studenta");
		f.setSize(466, 444);
		f.setLocationRelativeTo(GlavniProzor.getInstance());
		SpringLayout layout = new SpringLayout();
		f.setLayout(layout);
		f.setVisible(true);
		
		
		JLabel ime, prezime, datum, adresa, telefon, indeks, semestar;
		JTextField imeTf, prezimeTf, datumTf, adresaTf, telefonTf, indeksTf;
		JButton potvrda, odustanak;
		
		JComboBox semestarCB;
		semestar=new JLabel("Godina:");		
		String s[] = { "1", "2", "3", "4"};
		semestarCB=new JComboBox(s);
		
		JRadioButton budzet = new JRadioButton("Budzet");
		
		JRadioButton samf = new JRadioButton("Samofinansiranje");
		 
		ButtonGroup g=new ButtonGroup(); 
		 g.add(budzet);
		 g.add(samf);
		 
		 budzet.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	
			            ss= SStatus.B;
			        

		        }
		    });
		 
	
		ime=new JLabel("Ime:");
		prezime=new JLabel("Prezime:");
		datum=new JLabel("Datum roðenja:");
		adresa=new JLabel("Adresa");
		telefon=new JLabel("Broj telefona:");
		indeks=new JLabel("Broj indeksa:");
		
		imeTf=new JTextField();
		prezimeTf=new JTextField();
		datumTf=new JTextField();
		adresaTf=new JTextField();
		telefonTf=new JTextField();
		indeksTf=new JTextField();
		
		potvrda = new JButton ("Potvrda");
		odustanak = new JButton ("Odustanak");
		
		imeTf.setPreferredSize( new Dimension( 316, 26 ) );
		prezimeTf.setPreferredSize( new Dimension( 316, 26 ) );
		datumTf.setPreferredSize( new Dimension( 316, 26 ) );
		adresaTf.setPreferredSize( new Dimension( 316, 26 ) );
		telefonTf.setPreferredSize( new Dimension( 316, 26 ) );
		indeksTf.setPreferredSize( new Dimension( 316, 26 ) );
		semestarCB.setPreferredSize( new Dimension( 316, 26 ) );
		
		
		
		layout.putConstraint(SpringLayout.WEST, ime, 20, SpringLayout.WEST, f);
		layout.putConstraint(SpringLayout.NORTH, ime, 20, SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, prezime, 20, SpringLayout.WEST, f);
		layout.putConstraint(SpringLayout.NORTH, prezime, 60, SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, datum, 20, SpringLayout.WEST, f);
		layout.putConstraint(SpringLayout.NORTH, datum, 100, SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, adresa, 20, SpringLayout.WEST, f);
		layout.putConstraint(SpringLayout.NORTH, adresa, 140, SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, telefon, 20, SpringLayout.WEST, f);
		layout.putConstraint(SpringLayout.NORTH, telefon, 180, SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, indeks, 20, SpringLayout.WEST, f);
		layout.putConstraint(SpringLayout.NORTH, indeks, 220, SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, semestar, 20, SpringLayout.WEST, f);
		layout.putConstraint(SpringLayout.NORTH, semestar, 260, SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, budzet, 20, SpringLayout.WEST, f);
		layout.putConstraint(SpringLayout.NORTH, budzet, 300, SpringLayout.NORTH, f);

		layout.putConstraint(SpringLayout.WEST, imeTf, 96,SpringLayout.EAST, f);
		layout.putConstraint(SpringLayout.NORTH, imeTf, 20,SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, prezimeTf, 96,SpringLayout.EAST, f);
		layout.putConstraint(SpringLayout.NORTH, prezimeTf, 60,SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, datumTf, 96,SpringLayout.EAST, f);
		layout.putConstraint(SpringLayout.NORTH, datumTf, 100,SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, adresaTf, 96,SpringLayout.EAST, f);
		layout.putConstraint(SpringLayout.NORTH, adresaTf, 140,SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, telefonTf, 96,SpringLayout.EAST, f);
		layout.putConstraint(SpringLayout.NORTH, telefonTf, 180,SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, indeksTf, 96,SpringLayout.EAST, f);
		layout.putConstraint(SpringLayout.NORTH, indeksTf, 220,SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, semestarCB, 96,SpringLayout.EAST, f);
		layout.putConstraint(SpringLayout.NORTH, semestarCB, 260,SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, samf, 96,SpringLayout.EAST, f);
		layout.putConstraint(SpringLayout.NORTH, samf, 300,SpringLayout.NORTH, f);

		layout.putConstraint(SpringLayout.WEST, odustanak,20, SpringLayout.EAST, f);
		layout.putConstraint(SpringLayout.NORTH, odustanak,386,SpringLayout.NORTH, f);
		layout.putConstraint(SpringLayout.WEST, potvrda,366, SpringLayout.EAST, f);
		layout.putConstraint(SpringLayout.NORTH, potvrda, 386, SpringLayout.NORTH, f);
		
		f.add(ime);
		f.add(imeTf);
		f.add(prezime);
		f.add(prezimeTf);
		f.add(datum);
		f.add(datumTf);
		f.add(adresa);
		f.add(adresaTf);
		f.add(telefon);
		f.add(telefonTf);
		f.add(indeks);
		f.add(indeksTf);
		f.add(semestar);
		f.add(semestarCB);
		f.add(budzet);
		f.add(samf);
	
		f.add(odustanak);
		f.add(potvrda);
		
		f.setDefaultCloseOperation(1);
	
		
		
		odustanak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				
			}
			
		});
		
		AbstractAction buttonPressed = new AbstractAction(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (int i=0;i<GlavniProzor.getRp().studenti.size();i++) {
						stud=GlavniProzor.getRp().studenti.get(i);
						System.out.println("dodao" + GlavniProzor.getRp().studenti.get(i).getIme());
					
					
				}
				if(stud==null) {
					
					stud=new Student(indeksTf.getText());
					GlavniProzor.getRp().studenti.add(stud);
					
				}
				
				GlavniProzor.getRp().studenti.add(
						new Student(indeksTf.getText(), imeTf.getText(), prezimeTf.getText(), semestarCB.getSelectedItem().toString(), ss, po));
				
				f.dispose();

				SelectBar.tb1.doClick();
			}
		};
		
		potvrda.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER,0), "Enter_pressed");
		potvrda.getActionMap().put("Enter_pressed", buttonPressed);
		potvrda.addActionListener(buttonPressed);
			
	}
	
	private static void validateInput(JTextField field)
	  {
	    String text = field.getText();
	    if (text==null)
	    {
	      field.setText("Wrong input");
	      field.setCaretColor(Color.RED);
	    }
	  }
	

}
