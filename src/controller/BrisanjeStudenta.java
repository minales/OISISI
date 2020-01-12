package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.GlavniProzor;
import view.SelectBar;

public class BrisanjeStudenta implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		try {
			int i=StudentiActionListener.tables.getSelectedRow();
			String imeStudenta=StudentiActionListener.tables.getValueAt(i, 0).toString();  //getModel().getValueAt(i,1).toString();
	
			for (int a=0; a<GlavniProzor.getRp().studenti.size(); a++) {
				if (GlavniProzor.getRp().studenti.get(a).getIme()==imeStudenta) {
					JOptionPane.showMessageDialog(GlavniProzor.getInstance(),"Nije nista selektovano.","error",JOptionPane.ERROR_MESSAGE);
					
			
				}
				else {
					int result = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete selektovani element?", 
							 "Delete",
							 JOptionPane.YES_NO_OPTION);
						if(result == JOptionPane.YES_OPTION) {
						GlavniProzor.getRp().studenti.remove(a);

						SelectBar.tb1.doClick();
						}
				}
				}
		}
		catch (Exception e)  {}
	}

}
