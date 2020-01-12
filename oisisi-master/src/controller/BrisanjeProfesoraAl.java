package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.GlavniProzor;
import view.SelectBar;

public class BrisanjeProfesoraAl implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			 int i=ProfesoriActionListener.tablep.getSelectedRow();
			String imeProfesora=ProfesoriActionListener.tablep.getValueAt(i, 0).toString();  //getModel().getValueAt(i,1).toString();
	
			for (int a=0; a<GlavniProzor.getRp().profesori.size(); a++) {
				if (GlavniProzor.getRp().profesori.get(a).getIme()==imeProfesora) {
				
					int result = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete selektovani element?", 
							 "Delete",
							 JOptionPane.YES_NO_OPTION);
						if(result == JOptionPane.YES_OPTION) {
						GlavniProzor.getRp().profesori.remove(a);

						SelectBar.tb2.doClick();
						}
						
				}
				else
					JOptionPane.showMessageDialog(GlavniProzor.getInstance(),"Nije nista selektovano.","error",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch (Exception e) {}
	}
		


		/*Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		PredmetiActionListener.tablePredmeti.revalidate();
		PredmetiActionListener.tablePredmeti.updateUI();
		PredmetiActionListener.tablePredmeti.repaint();
		JScrollPane sp = new JScrollPane(PredmetiActionListener.tablePredmeti, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setPreferredSize(new Dimension(screen.width/2, 336));
		GlavniProzor.setDesno(sp);*/
		
		
	}
