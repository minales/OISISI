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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javax.swing.SwingUtilities;
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
import controller.PredmetiActionListener;
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
	public static JPanel desno,glavniPanel;
	public static JScrollPane sp1;
	private static String rpPath;
	private static RadniProstor rp=new RadniProstor("probni");
	private static Locale l;
	static ResourceBundle r;
	public static ObjectOutputStream out;

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
		//serijalizacija
		JFileChooser directoryChooser = new JFileChooser();
		directoryChooser.setDialogTitle("Odabir radnog prostora");
		directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int fileChooserStatus = directoryChooser.showOpenDialog(glavniPanel);
		if(fileChooserStatus != JFileChooser.APPROVE_OPTION) {
			rpPath=directoryChooser.getSelectedFile().getAbsolutePath();
			File f = new File(rpPath + "\\setup.txt");
			System.exit(0);
		}
		String arp = directoryChooser.getSelectedFile().getPath();
		AktivniRadniProstor a = new AktivniRadniProstor(arp);
		System.out.println(arp);
		GlavniProzor.setRp(a.radniProstor);
		
		try
        {    
            //Saving of object in a file 
			File f = new File("data.txt");
            FileOutputStream file = new FileOutputStream(f); 
            System.out.println("Object has been serialized????"); 
            out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            for(int i=0;i< rp.profesori.size();i++) {

                out.writeObject(rp.profesori.get(i)); 
            }
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
		
		//
		glavniPanel = new JPanel();
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
	        
		/*if (tb1.isSelected()) {}
		else if (tb2.isSelected()) {*/
	    
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

		
		
        JScrollPane sp2 = new JScrollPane(table2, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp2.setPreferredSize(new Dimension(screen.width/2, 114));
        

		desno.add(sp2,c);
		
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
	public static void upDateDesno() {
		GlavniProzor mf=getInstance();
		GlavniProzor.desno.revalidate();
		GlavniProzor.desno.repaint();
	}
	public static void setDesno(JScrollPane f) {
		GlavniProzor mf=getInstance();
		GlavniProzor.desno.removeAll();
		GlavniProzor.desno.revalidate();
		GlavniProzor.desno.add(f);
		GlavniProzor.desno.revalidate();
		GlavniProzor.desno.repaint();
		/*GlavniProzor.glavniPanel.remove(desno);
		GlavniProzor.glavniPanel.add(desno,BorderLayout.CENTER);
		GlavniProzor.glavniPanel.repaint();
		GlavniProzor.glavniPanel.revalidate();
		SwingUtilities.updateComponentTreeUI(mf);*/
		/*mf.invalidate();
		mf.remove(desno);
		mf.add(desno);
		mf.validate();
		mf.repaint();*/
		//mf.setVisible(false); //you can't see me!
		//mf.dispose(); //Destroy the JFrame object
		/*JFrame dodaj= new JFrame();
		dodaj.setSize(466, 444);
		dodaj.setLocationRelativeTo(GlavniProzor.getInstance());
		dodaj.add(glavniPanel);
		dodaj.setVisible(true);
		System.out.println("pozvano setDesno");*/
	}
	public static void ocistiDesno() {
		getInstance();
		GlavniProzor.desno.removeAll();
		GlavniProzor.desno.revalidate();
		GlavniProzor.desno.repaint();
		System.out.println("pozvano ocistiDesno");
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
