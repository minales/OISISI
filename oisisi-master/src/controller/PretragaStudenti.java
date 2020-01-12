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

public class PretragaStudenti implements ActionListener{

	private TableRowSorter<TableModel> rowSorter=null;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String[] tokeni=ToolBar.u.getText().split("/");
		
		
		JTable table=StudentiActionListener.tables;
		
		if (tokeni.length==0) {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(),"Unesite kriterijum pretrake","error",JOptionPane.ERROR_MESSAGE);
		     
		  } else {
			  rowSorter = new TableRowSorter<>(StudentiActionListener.tables.getModel());
			  table.setRowSorter(rowSorter);
			  for(int s = 0; s < tokeni.length; s++) {
				  rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + tokeni[s]));
			  }
		  }
		
	}

	
}
