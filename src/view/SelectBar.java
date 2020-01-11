package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import controller.ProfesoriActionListener;

public class SelectBar extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final JToggleButton tb1,tb2,tb3;
	
	public SelectBar() {
		
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		
		JPanel select=new JPanel(new FlowLayout());
		select.setPreferredSize(new Dimension(screen.width, 40));
		select.setBackground(new Color(226,255,253));
		
		tb1 = new JToggleButton("Studenti");
		tb2 = new JToggleButton("Profesori");
		tb3 = new JToggleButton("Predmeti");
		tb1.setPreferredSize(new Dimension(140, 34));
		tb2.setPreferredSize(new Dimension(140, 34));
		tb3.setPreferredSize(new Dimension(140, 34));
		select.add(tb1);
		select.add(tb2);
		select.add(tb3);
		
		ProfesoriActionListener pa=new ProfesoriActionListener();
		tb2.addActionListener(pa);
		
		select.setSize(screen.width, 40);
		add(select);
	}
	
	

}
