package view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controller.BrisanjePredmetaAl;
import controller.BrisanjeProfesoraAl;
import controller.DodavanjePredmetaAL;
import controller.IzmenaPredmetaAL;
import controller.PredmetiActionListener;
import model.Predmet;


public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JMenuItem k,p,par,ppar,k1,p1,par1,ppar1,k2,p2,par2,ppar2;
	public JMenuItem n;
	public JMenuItem ed;
	public JMenuItem de;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(226, 255, 253));
		g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

	}

	public MenuBar() {

		//JMenu sel = new JMenu("Selektovano");
		JMenu novo = new JMenu("Novo");
		JMenu edit = new JMenu("Editovanje");
		JMenu del = new JMenu("Brisanje");
		
		n=new JMenuItem("Novo",KeyEvent.VK_N);
		ed=new JMenuItem("Editovanje",KeyEvent.VK_E);
		de=new JMenuItem("Brisanje",KeyEvent.VK_B);

		k = new JMenuItem("Profesor");
		p = new JMenuItem("Predmet");
		par = new JMenuItem("Student");
		
		k1 = new JMenuItem("Profesor");
		p1 = new JMenuItem("Predmet");
		par1 = new JMenuItem("Student");
		
		k2 = new JMenuItem("Profesor");
		p2 = new JMenuItem("Predmet");
		par2 = new JMenuItem("Student");
		
		n.setMnemonic(KeyEvent.VK_N);
		ed.setMnemonic(KeyEvent.VK_E);
		de.setMnemonic(KeyEvent.VK_B);
		
		/*sel.add(n);
		sel.add(ed);
		sel.add(de);*/
		
		
		IzmenaPredmetaAL izmeni=new IzmenaPredmetaAL();
		p1.addActionListener(izmeni);
		DodavanjePredmetaAL dodavanje=new DodavanjePredmetaAL();
		p.addActionListener(dodavanje);
		BrisanjePredmetaAl obrisi=new BrisanjePredmetaAl();
		p2.addActionListener(obrisi);
		BrisanjeProfesoraAl bp=new BrisanjeProfesoraAl();
		k2.addActionListener(bp);
		
		novo.add(k);
		novo.add(p);
		novo.add(par);
		
		edit.add(k1);
		edit.add(p1);
		edit.add(par1);
		
		del.add(k2);
		del.add(p2);
		del.add(par2);

		//add(sel);
		add(novo);
		add(edit);
		add(del);

		JMenuItem help=new JMenu("help");
		JMenuItem viz = new JMenuItem("Online pomoc");
		JMenuItem obj = new JMenuItem("Detalji");
		viz.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e) {
		    	
		    	try {
		    	    Desktop.getDesktop().browse(new URL("https://google.com").toURI());
		    	} catch (Exception e1) {}
		    }
		});
		obj.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	String text = ".\n";

				JOptionPane.showMessageDialog(null,text , "Pomoc pri korišcenju aplikacije", JOptionPane.INFORMATION_MESSAGE);
	                
		    }
		});
		help.add(obj);
		help.add(viz);
		add(Box.createGlue());
		
		add(help);
	}

}
