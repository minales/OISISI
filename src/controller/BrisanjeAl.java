package controller;

import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import view.GlavniProzor;

public class BrisanjeAl implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			 int i=PredmetiActionListener.tablePredmeti.getSelectedRow();
			String imePredmeta=PredmetiActionListener.tablePredmeti.getValueAt(i, 0).toString();  //getModel().getValueAt(i,1).toString();
	
			for (int a=0; a<GlavniProzor.getRp().predmeti.size(); a++) {
				if (GlavniProzor.getRp().predmeti.get(a).getNaziv()==imePredmeta) {
				
					int result = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete selektovani element?", 
							 "Delete",
							 JOptionPane.YES_NO_OPTION);
						if(result == JOptionPane.YES_OPTION) {
						GlavniProzor.getRp().predmeti.remove(a);
						}
						
				}
				else
					JOptionPane.showMessageDialog(GlavniProzor.getInstance(),"Nije nista selektovano.","error",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch (Exception e) {}
		


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

}
