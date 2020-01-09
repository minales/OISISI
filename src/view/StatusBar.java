package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBar extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StatusBar() {
        super();
        super.setPreferredSize(new Dimension(100, 16));
        super.setBackground(Color.WHITE);
        super.setOpaque(isBackgroundSet());
        

	Timer timee = new javax.swing.Timer(1000, new ActionListener() {
		 
        @Override
        public void actionPerformed(ActionEvent e) {
            java.util.Date now = new java.util.Date();
            String ss = DateFormat.getDateTimeInstance().format(now);
            setMessage("Studentska sluzba" +"                                                                                                                                                                                                                                                                                                                    " + ss);

        }
    });
    timee.start();
	}

    public void setMessage(String message) {
        setText(" "+message);        
    }
}
