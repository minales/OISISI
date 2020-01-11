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

public class SearchProfesori implements ActionListener{
	private TableRowSorter<TableModel> rowSorter=null;


	public void actionPerformed(ActionEvent arg0) {
		String[] tokeni=ToolBar.u.getText().split("/");
		
		
		JTable table=ProfesoriActionListener.tablep;
		
		if (tokeni.length==0) {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(),"Unesite kriterijum pretrake","error",JOptionPane.ERROR_MESSAGE);
		     
		  } else {
			  rowSorter = new TableRowSorter<>(ProfesoriActionListener.tablep.getModel());
			  table.setRowSorter(rowSorter);
			  for(int s = 0; s < tokeni.length; s++) {
				  rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + tokeni[s]));
			  }
		  }
		
		
	}

}
