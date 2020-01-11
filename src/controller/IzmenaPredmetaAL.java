package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import model.Predmet;
import model.Profesor;
import view.GlavniProzor;

public class IzmenaPredmetaAL implements ActionListener{

		Profesor p;
		Predmet predmet=null;
		
		public IzmenaPredmetaAL() {
			//this.predmet=p;
		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			 int i=PredmetiActionListener.tablePredmeti.getSelectedRow();
			String imePredmeta=PredmetiActionListener.tablePredmeti.getValueAt(i, 0).toString();  //getModel().getValueAt(i,1).toString();
			System.out.println(imePredmeta + "ovde sam");
			for (int a=0; a<GlavniProzor.getRp().predmeti.size(); a++) {
				if (GlavniProzor.getRp().predmeti.get(a).getNaziv()==imePredmeta) {
				predmet=GlavniProzor.getRp().predmeti.get(a);
				System.out.println(predmet.getNaziv() + "uspesno");
				}
				else predmet=null;
			}
		}
		catch (Exception e) {}
		
		
		if (predmet == null) {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(),"Nije nista selektovano.","error",JOptionPane.ERROR_MESSAGE);
		}
		else {
			JFrame dodaj= new JFrame();
			dodaj.setSize(466, 444);
			dodaj.setLocationRelativeTo(GlavniProzor.getInstance());
			SpringLayout layout = new SpringLayout();
			dodaj.setLayout(layout);
			
			JTextField naziv,sifra,profesor,godina;
			JLabel nazivl,sifral,profesorl,godinal,semestarl;
			JButton ok,cnc;
			JComboBox<String> semestar;
			
			nazivl=new JLabel("naziv:");
			sifral=new JLabel("sifra:");
			profesorl=new JLabel("profesor:");
			semestarl=new JLabel("semestar:");
			godinal=new JLabel("godina slusanja:");
			
			naziv=new JTextField();
			sifra=new JTextField();
			profesor=new JTextField();
			godina=new JTextField();
			
			String s[] = { "I", "II", "III", "IV", "V" , "VI", "VII", "VIII"};
			semestar=new JComboBox<>(s);
			
			naziv.setPreferredSize( new Dimension( 316, 26 ) );
			sifra.setPreferredSize( new Dimension( 316, 26 ) );
			profesor.setPreferredSize( new Dimension( 316, 26 ) );
			godina.setPreferredSize( new Dimension( 316, 26 ) );
			semestar.setPreferredSize( new Dimension( 196, 26 ) );
			
			layout.putConstraint(SpringLayout.WEST, nazivl,
	                20,
	                SpringLayout.WEST, dodaj);
			layout.putConstraint(SpringLayout.NORTH, nazivl,
	                20,
	                SpringLayout.NORTH, dodaj);
			layout.putConstraint(SpringLayout.WEST, sifral,
	                20,
	                SpringLayout.WEST, dodaj);
			layout.putConstraint(SpringLayout.NORTH, sifral,
	                60,
	                SpringLayout.NORTH, dodaj);
			layout.putConstraint(SpringLayout.WEST, profesorl,
	                20,
	                SpringLayout.WEST, dodaj);
			layout.putConstraint(SpringLayout.NORTH, profesorl,
	                100,
	                SpringLayout.NORTH, dodaj);
			layout.putConstraint(SpringLayout.WEST, semestarl,
	                20,
	                SpringLayout.WEST, dodaj);
			layout.putConstraint(SpringLayout.NORTH, semestarl,
	                140,
	                SpringLayout.NORTH, dodaj);
			layout.putConstraint(SpringLayout.WEST, godinal,
	                20,
	                SpringLayout.WEST, dodaj);
			layout.putConstraint(SpringLayout.NORTH, godinal,
	                180,
	                SpringLayout.NORTH, dodaj);
			//pozicije text polja
			layout.putConstraint(SpringLayout.WEST, naziv,
	                96,
	                SpringLayout.EAST, dodaj);
			layout.putConstraint(SpringLayout.NORTH, naziv,
			                20,
			                SpringLayout.NORTH, dodaj);
			layout.putConstraint(SpringLayout.WEST, sifra,
					96,
			        SpringLayout.EAST, dodaj);
			layout.putConstraint(SpringLayout.NORTH, sifra,
			        60,
			        SpringLayout.NORTH, dodaj);
			layout.putConstraint(SpringLayout.WEST, profesor,
					96,
			        SpringLayout.EAST, dodaj);
			layout.putConstraint(SpringLayout.NORTH, profesor,
			        100,
			        SpringLayout.NORTH, dodaj);
			layout.putConstraint(SpringLayout.WEST, semestar,
			        96,
			        SpringLayout.EAST, dodaj);
			layout.putConstraint(SpringLayout.NORTH, semestar,
			        140,
			        SpringLayout.NORTH, dodaj);
			layout.putConstraint(SpringLayout.WEST, godina,
					96,
			        SpringLayout.EAST, dodaj);
			layout.putConstraint(SpringLayout.NORTH, godina,
			        180,
			        SpringLayout.NORTH, dodaj);
			
			ok=new JButton("OK");
			cnc=new JButton ("Cancel");
			
			layout.putConstraint(SpringLayout.WEST, cnc,
					20,
			        SpringLayout.EAST, dodaj);
			layout.putConstraint(SpringLayout.NORTH, cnc,
			        386,
			        SpringLayout.NORTH, dodaj);
			layout.putConstraint(SpringLayout.WEST, ok,
					366,
			        SpringLayout.EAST, dodaj);
			layout.putConstraint(SpringLayout.NORTH, ok,
			        386,
			        SpringLayout.NORTH, dodaj);
			
			dodaj.add(nazivl);
			naziv.setText(predmet.getNaziv());
			dodaj.add(naziv);
			dodaj.add(sifral);
			sifra.setText(predmet.getS());
			dodaj.add(sifra);
			dodaj.add(profesorl);
			profesor.setText(predmet.getProfesor().getIme());
			dodaj.add(profesor);
			dodaj.add(godinal);
			godina.setText(predmet.getGodinaStudija());
			dodaj.add(godina);
			dodaj.add(semestarl);
			String b=predmet.getSemestar().toString();
			int a = 0;
			if (b.equals("I")) { a=0;} 
			else if(b.equals("II")) { a=1;} 
			else if(b.equals("III")) { a=2;} 
			else if(b.equals("IV")) { a=3;} 
			else if(b.equals("V")) { a=4;} 
			else if(b.equals("VI")) { a=5;} 
			else if(b.equals("VII")) { a=6;} 
			else if(b.equals("VIII")) { a=7;} 
			semestar.setSelectedIndex(a);
			dodaj.add(semestar);
			dodaj.add(ok);
			dodaj.add(cnc);
			
			dodaj.setVisible(true);
			dodaj.setDefaultCloseOperation(1);
			
			cnc.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					dodaj.dispose();
					
				}
				
			});
			ok.addActionListener(new ActionListener() {
		
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					predmet.setNaziv(naziv.getText());
					predmet.getProfesor().setIme(profesor.getText());
					predmet.setGodinaStudija(godina.getText());
					predmet.setS(sifra.getText());
					predmet.setSemestar(semestar.getSelectedItem().toString());
					
					
					dodaj.dispose();
				}
				
			});
		}
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
