package model;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import controller.PredmetiActionListener;
import view.GlavniProzor;
import view.SelectBar;


public class ButtonPredmet extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, MouseListener {

	private static final long serialVersionUID = 1493557968025874237L;

	private JTable table;
	
	private JButton renderButton;
	private JButton editorButton;
	
	private boolean isEditorActive = false;
	
	public ButtonPredmet(JTable table, int column) {
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);
		
		this.renderButton = new JButton("Prikazi");
		this.editorButton = new JButton("Prikazi");
	
		this.editorButton.addActionListener(new ActionListener() {
			public Predmet p;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				//lista profesora na predmetu
				JFrame spisak=new JFrame("spisak");
				spisak.setSize(466, 444);
				spisak.setLocationRelativeTo(GlavniProzor.getInstance());
				spisak.setLayout(new BorderLayout());
				
				p = null;
				int idR=PredmetiActionListener.tablePredmeti.getSelectedRow();
				String predmetIme = PredmetiActionListener.tablePredmeti.getValueAt(idR, 0).toString();
				for(int i=0;i<GlavniProzor.getRp().predmeti.size();i++) {
					if(GlavniProzor.getRp().predmeti.get(i).getNaziv().equals(predmetIme)) {
						p=GlavniProzor.getRp().predmeti.get(i);
					}
				}
				String[] profesoriNaPredmetu=new String[1];
				//za svakog profesora na predmetu, dodaj string
				profesoriNaPredmetu[0]=p.getProfesor().getIme();
				JList s=new JList(profesoriNaPredmetu);
				JButton dodaj=new JButton ("Dodaj profesora");
				JButton obrisi=new JButton ("Ukloni Profeosra");
				JButton cnc=new JButton ("Otkazi");
				
				cnc.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						spisak.dispose();
						
					}
				});
				
				obrisi.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String imeSelektovanogProfesora=null;
						try {
						imeSelektovanogProfesora=s.getSelectedValue().toString();
						p.UkloniProfesoraSaPredmeta(p.getProfesor());
						
						int result = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete selektovani element?", 
								 "Delete",
								 JOptionPane.YES_NO_OPTION);
							if(result == JOptionPane.YES_OPTION) {
							spisak.dispose();
							SelectBar.tb3.doClick();
							}
						}
						catch (Exception e) {
							JOptionPane.showMessageDialog(GlavniProzor.getInstance(),"Nije nista selektovano.","error",JOptionPane.ERROR_MESSAGE);
						}
	
					}
				});
				
				JPanel dugmici=new JPanel();
				spisak.add(s,BorderLayout.CENTER);
				dugmici.add(cnc);
				dugmici.add(obrisi);
				dugmici.add(dodaj);
				spisak.add(dugmici,BorderLayout.SOUTH);
				spisak.setVisible(true);
				
			}
		});
		
		this.isEditorActive = false;
	}
	
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return this.editorButton;
	}


	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return this.renderButton;
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if (table.isEditing() && table.getCellEditor() == this) {
			this.isEditorActive = true;
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		if (isEditorActive && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	

}

