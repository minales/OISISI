package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import view.GlavniProzor;
import view.ToolBar;

public class SearchPredmetiAl implements ActionListener {
	private String naziv,sifra,profesor,semestar,godina;
	private TableRowSorter<TableModel> rowSorter=null;


	@Override
	public void actionPerformed(ActionEvent arg0) {
		String[] tokeni=ToolBar.u.getText().split("/");
		
		
		JTable table=PredmetiActionListener.tablePredmeti;
		
		if (tokeni.length==0) {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(),"Unesite kriterijum pretrake","error",JOptionPane.ERROR_MESSAGE);
		     
		  } else {
			  rowSorter = new TableRowSorter<>(PredmetiActionListener.tablePredmeti.getModel());
			  table.setRowSorter(rowSorter);
			  for(int s = 0; s < tokeni.length; s++) {
				  rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + tokeni[s]));
			  }
		  }
		
		
	}

}

/* for(int i = 0;i< table.getRowCount() ; i++){
       for(int j = 0; j < table.getColumnCount(); j++){
       	for(int s = 0; s < tokeni.length; s++){
       		if(table.getModel().getValueAt(i, j).equals(tokeni[s])){
	                System.out.println(table.getModel().getValueAt(i, j));
       	}
           
           }
       }
   }*/
