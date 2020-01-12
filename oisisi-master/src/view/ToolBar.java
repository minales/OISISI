package view;

import java.awt.Color;
import java.awt.Event;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Observable;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import controller.BrisanjePredmetaAl;
import controller.BrisanjeProfesoraAl;
import controller.DodavanjePredmetaAL;
import controller.DodavanjeStudentaActionListener;
import controller.IzmenaPredmetaAL;
import controller.IzmenaStudenta;
import controller.PretragaStudenti;
import controller.SearchPredmetiAl;
import controller.SearchProfesori;
import model.RoundButton;
/*
import controller.EditAction;
import controller.KreirajActionListener;
import controller.NovoActionListener;
import controller.RemoveNodeAction;
*/
public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton n, r,e,d,p;
	public static JTextField u;
	

	public ToolBar() {

		
		KeyStroke keyadd = KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK); 
		Action performAdd = new AbstractAction() {  
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		         System.out.println("add");
		    }
		}; 
		n = new JButton(performAdd);
		n.getActionMap().put("performAdd", performAdd);
		n.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyadd, "performAdd"); 
		
		KeyStroke keyEdit = KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK); 
		Action performEdit = new AbstractAction() {  
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		         System.out.println("Edit");
		    }
		}; 
		e = new JButton(performEdit);
		e.getActionMap().put("performEdit", performEdit);
		e.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyEdit, "performEdit");
		
		
		KeyStroke keyDelete = KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK); 
		Action performDelete = new AbstractAction() {  
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		         System.out.println("Delete");
		    }
		}; 
		d = new JButton(performDelete);
		d.getActionMap().put("performDelete", performDelete);
		d.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyDelete, "performDelete");
		
		KeyStroke keySearch = KeyStroke.getKeyStroke(KeyEvent.VK_W, Event.CTRL_MASK); 
		Action performSearch = new AbstractAction() {  
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		         System.out.println("Search");
		    }
		}; 
		p = new JButton(performSearch);
		p.getActionMap().put("performSearch", performSearch);
		p.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keySearch, "performSearch");
		
		KeyStroke keyaddSubject = KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK); 
		Action performAddSubject = new AbstractAction() {  
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		         System.out.println("addSubject");
		    }
		}; 
		r = new JButton(performAddSubject);
		r.getActionMap().put("performAddSubject", performAddSubject);
		r.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyaddSubject, "performAddSubject"); 
		
		ImageIcon imageIcon = new ImageIcon("slike/add.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(34, 34,  java.awt.Image.SCALE_SMOOTH); 
		n.setIcon(new ImageIcon(newimg));
		ImageIcon ii = new ImageIcon("slike/edit.jpg"); // load the image to a imageIcon
		Image i = ii.getImage(); // transform it 
		Image ni = i.getScaledInstance(34, 34,  java.awt.Image.SCALE_SMOOTH); 
		e.setIcon(new ImageIcon(ni));
		ImageIcon ii1 = new ImageIcon("slike/delete.png"); // load the image to a imageIcon
		Image i1 = ii1.getImage(); // transform it 
		Image ni1 = i1.getScaledInstance(34, 34,  java.awt.Image.SCALE_SMOOTH); 
		d.setIcon(new ImageIcon(ni1));
		ImageIcon aa = new ImageIcon("slike/predmet.png"); // load the image to a imageIcon
		Image a = aa.getImage(); // transform it 
		Image na = a.getScaledInstance(34, 34,  java.awt.Image.SCALE_SMOOTH); 
		r.setIcon(new ImageIcon(na));
		//n.setBackground(new Color(226, 255, 253));
		//r.setBackground(new Color(226, 255, 253));
		//p.setBackground(new Color(226, 255, 253));
		//e.setBackground(new Color(226, 255, 253));
		//d.setBackground(new Color(226, 255, 253));
		//n.setIcon(new ImageIcon("slike/komp.png"));
		n.setToolTipText("Add new student");
		e.setToolTipText("Edit");
		d.setToolTipText("Delete");
		p.setToolTipText("Search");
		r.setToolTipText("New Subject");
		
		add(n);
		add(e);
		add(d);
		add(p);
		add(r);
		
		add(Box.createGlue());
		u= new JTextField(6);
		ImageIcon imageIcon2 = new ImageIcon("slike/search.png"); // load the image to a imageIcon
		Image image2 = imageIcon2.getImage(); // transform it 
		Image newimg2 = image2.getScaledInstance(34, 34,  java.awt.Image.SCALE_SMOOTH); 
		p.setIcon(new ImageIcon(newimg2));
		u.setToolTipText("Enter text");
		add(u);
		add(p);
		
		DodavanjeStudentaActionListener dal = new DodavanjeStudentaActionListener();
		n.addActionListener(dal);
		DodavanjePredmetaAL np=new DodavanjePredmetaAL();
		r.addActionListener(np);
		
		SearchPredmetiAl sp=new SearchPredmetiAl();
		p.addActionListener(sp);
		PretragaStudenti pretragaS=new PretragaStudenti();
		p.addActionListener(pretragaS);
		
		IzmenaPredmetaAL izmeni=new IzmenaPredmetaAL();
		e.addActionListener(izmeni);
		
	//	IzmenaStudenta izmenaS = new IzmenaStudenta();
	//	e.addActionListener(izmenaS);
		
		BrisanjePredmetaAl obrisi=new BrisanjePredmetaAl();
		d.addActionListener(obrisi);
		SearchProfesori bp=new SearchProfesori();
		p.addActionListener(bp);
		

		setFloatable(true);
		setBackground(new Color(238, 213, 242));

	}	

}
