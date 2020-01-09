package view;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Profesor;
import model.Node;
import model.Predmet;
import model.RadniProstor;
import model.Student;

public class TreeRendered extends DefaultTreeCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8652394700428406234L;

	public TreeRendered() {

		// TODO Auto-generated constructor stub
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		if (value instanceof DefaultMutableTreeNode) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
			Object o = node.getUserObject();
			// do ovoga ne bi trebalo da dodje, ako je stablo pazljivo kreirano
			if (o == null) {
				return this;
			}
			
			if (o instanceof Profesor) {
				Profesor komp = (Profesor) o;
				setText(komp.getIme());
				if (komp.getIkonica() != null) {
					setIcon(komp.getIkonica());
				} else {
					ImageIcon imageIcon = new ImageIcon("slike/ws.png"); // load the image to a imageIcon
					Image image = imageIcon.getImage(); // transform it 
					Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
					setIcon(new ImageIcon(newimg));
				}
			} else if (o instanceof Predmet) {
				Predmet p = (Predmet) o;
				setText(p.getNaziv());
				if (p.getIkonica() != null) {
					setIcon(p.getIkonica());
				} else {
					//setIcon(new ImageIcon("images/klasa1.png"));
				}
			}
			else if (o instanceof RadniProstor) {
				RadniProstor p = (RadniProstor) o;
				setText(p.getIme());
				if (p.getIkonica() != null) {
					setIcon(p.getIkonica());
				} else {
					ImageIcon imageIcon = new ImageIcon("slike/home.png"); // load the image to a imageIcon
					Image image = imageIcon.getImage(); // transform it 
					Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
					setIcon(new ImageIcon(newimg));
				}
			}
			else if (o instanceof Student) {
				Student p = (Student) o;
				setText(p.getNaziv());
					ImageIcon imageIcon = new ImageIcon("slike/par.png"); // load the image to a imageIcon
					Image image = imageIcon.getImage(); // transform it 
					Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
					setIcon(new ImageIcon(newimg));
				
			}

			

		}
		

		return this;
	}

}
