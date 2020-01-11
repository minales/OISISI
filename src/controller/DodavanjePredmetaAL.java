package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import model.Predmet;
import model.Profesor;
import view.GlavniProzor;

public class DodavanjePredmetaAL implements ActionListener{
	Profesor p;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame dodaj= new JFrame();
		dodaj.setSize(466, 444);
		dodaj.setLocationRelativeTo(GlavniProzor.getInstance());
		SpringLayout layout = new SpringLayout();
		dodaj.setLayout(layout);
		
		JTextField naziv,sifra,profesor,godina;
		JLabel nazivl,sifral,profesorl,godinal,semestarl;
		JButton ok,cnc;
		JComboBox semestar;
		
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
		semestar=new JComboBox(s);
		
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
		dodaj.add(naziv);
		dodaj.add(sifral);
		dodaj.add(sifra);
		dodaj.add(profesorl);
		dodaj.add(profesor);
		dodaj.add(godinal);
		dodaj.add(godina);
		dodaj.add(semestarl);
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
				for (int i=0;i<GlavniProzor.getRp().profesori.size();i++) {
					if (GlavniProzor.getRp().profesori.get(i).getIme().equals(naziv.getText())) {
						p=GlavniProzor.getRp().profesori.get(i);
						System.out.println("dodao" + GlavniProzor.getRp().profesori.get(i).getIme());
					}
					else
						//pogresan profesor//dodavanje profesora
						break;
				}
				if(p==null) {
					
					p=new Profesor(profesor.getText());
					GlavniProzor.getRp().profesori.add(p);
					System.out.println("dodao" + p.getIme());
				}
				
				GlavniProzor.getRp().predmeti.add(
						new Predmet(naziv.getText(),sifra.getText()
								,p,godina.getText(),semestar.getSelectedItem().toString()));
				
				for(int i=0; i<GlavniProzor.getRp().predmeti.size();i++) {
					System.out.println("predmet:" + GlavniProzor.getRp().predmeti.get(i).getNaziv());
				}
				dodaj.dispose();
			}
			
		});
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
