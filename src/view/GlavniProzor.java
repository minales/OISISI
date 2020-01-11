package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import model.AktivniRadniProstor;
import model.Node;
import model.Profesor;
import model.RadniProstor;
import App.App;
import controller.ProfesoriActionListener;
import view.TreeRendered;


public class GlavniProzor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ToolBar toolBar;
	public MenuBar menuBar;
	public StatusBar statusBar;
	public SelectBar select;
	
	private JSplitPane splitPane;
	private static JTree tree;
	private static DefaultTreeModel treeModel;
	private Node root;

	private static GlavniProzor instance;
	public static JPanel desno;
	public static JScrollPane sp1;
	private static String rpPath;
	private static RadniProstor rp=new RadniProstor("probni");
	private static Locale l;
	static ResourceBundle r;

	static {
		instance = new GlavniProzor();
	}

	public GlavniProzor() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screen.width/4*3, screen.height/4*3);
		setLocation(screen.width/2-this.getSize().width/2, screen.height/2-this.getSize().height/2);
		setTitle("StudentskaSluzba");

		setLocationRelativeTo(null);
		
		JPanel glavniPanel = new JPanel();
		glavniPanel.setLayout(new BorderLayout());
		
		

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		menuBar = new MenuBar();
		toolBar = new ToolBar();
		statusBar = new StatusBar();
		select= new SelectBar();
		
		
		panel.add(menuBar, BorderLayout.NORTH);
		panel.add(toolBar, BorderLayout.CENTER);
		panel.add(select,BorderLayout.SOUTH);
		
		desno=new JPanel(new GridBagLayout());
		desno.setBackground(new Color(255,247,253));
		
		GridBagConstraints c = new GridBagConstraints();
		
		String[][] data = { 
	        }; 
	  
	    String[] columnNames = {  }; 
	    JTable table = new JTable(data, columnNames);
	        
		/*if (tb1.isSelected()) {}
		else if (tb2.isSelected()) {*/
	    JPanel profesoriPanel=new JPanel();
	    
			Object data1[][] = new Object[100][11];
			for (int i=0; i<rp.profesori.size(); i++) {
				data1[i][0] =rp.profesori.get(i).getIme();
				data1[i][1] =rp.profesori.get(i).getPrezime();
				data1[i][2] =rp.profesori.get(i).getDatumRodjena();
				data1[i][3] =rp.profesori.get(i).getAdresaStanovanja();
				data1[i][4] =rp.profesori.get(i).getTelefon();
				data1[i][5] =rp.profesori.get(i).getEmail();
				data1[i][6] =rp.profesori.get(i).getAdresaKancelarije();
				data1[i][7] =rp.profesori.get(i).getBrojLicne();
				data1[i][8] =rp.profesori.get(i).getTitula();
				data1[i][9] =rp.profesori.get(i).getZvanje();
				rp.profesori.get(i);
				data1[i][10] =Profesor.getPredmeti();
				
			         
		}
			
		  
		        String[] columnNames1 = {"Ime", "Prezime","Datum rodjenja","Adresa stanovanja","Kontakt telefon",
		        		"E-mail adresa","Adresa kancelarije","Broj licne karte","Titula","Zvanje",
		        		"Spisak predmeta na kojima je profesor" }; 
		        JTable table1 = new JTable(data1, columnNames1);
		        table1.setGridColor(Color.BLACK);
		        profesoriPanel.add(new JScrollPane(table1));
		  
		//}
		//else if (tb3.isSelected()) {}
		//else {
			String[][] data2 = { 
		            { "", "" }, 
		            { "", "" } 
		        }; 
		  
		        String[] columnNames2 = { "Ime", "Prezime", }; 
		   JTable table2 = new JTable(data2, columnNames2);
		  
		//}
 
        /*table.setRowHeight(26);
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
        	columnModel.getColumn(i).setMaxWidth(140);
        }
        */

		
	   JScrollPane sp = new JScrollPane(table, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setPreferredSize(new Dimension(screen.width/2, 114));
        c.ipady = 400;      //make this component tall
        c.ipadx=960;
        c.gridx = 0;
        c.gridy = 4;
		
		sp1 = new JScrollPane(table1, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp1.setPreferredSize(new Dimension(screen.width/2, 114));
        JScrollPane sp2 = new JScrollPane(table2, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp2.setPreferredSize(new Dimension(screen.width/2, 114));
        

		desno.add(sp1,c);
		
		
		glavniPanel.add(panel, BorderLayout.NORTH);
		glavniPanel.add(getDesno(),BorderLayout.CENTER);
		glavniPanel.add(statusBar, BorderLayout.SOUTH);
		
		add(glavniPanel);

	}

	
	public static void setLocale (String lang, String country)
	{
		l = new Locale(lang, country);
		r = ResourceBundle.getBundle("gui.drugi_jezik/jezik", l);
	}

	public static GlavniProzor getInstance() {
		return instance;
	}
	public DefaultTreeModel getModel() {
		return treeModel;
	}
	private JPanel getDesno() {
		return desno;
	}
	public static void setDesno(JScrollPane f) {
		getInstance();
		GlavniProzor.desno.removeAll();
		GlavniProzor.desno.revalidate();
		GlavniProzor.desno.repaint();
		GlavniProzor.desno.add(f);
		GlavniProzor.desno.revalidate();
	}
	public static void ocistiDesno() {
		getInstance();
		GlavniProzor.desno.removeAll();
		GlavniProzor.desno.revalidate();
		GlavniProzor.desno.repaint();
	}

	public static RadniProstor getRp() {
		return rp;
	}

	public static void setRp(RadniProstor rp) {
		GlavniProzor.rp = rp;
	}
	public static String getRpPath() {
		return rpPath;
	}

}
