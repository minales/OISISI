package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import com.jtattoo.plaf.smart.SmartLookAndFeel;

//import controller.Controller;
import model.AktivniRadniProstor;
import model.Profesor;
import model.RadniProstor;
import view.GlavniProzor;
import com.jtattoo.plaf.smart.SmartLookAndFeel;

public class App {
	public static AktivniRadniProstor a;
	public static JRadioButton srp,eng;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
	        
			 Properties props = new Properties();
	            
	            props.put("logoString", "Sluzba"); 
	            props.put("licenseKey", "INSERT YOUR LICENSE KEY HERE");
	            
	            props.put("selectionBackgroundColor", "255 237 251"); 
	            //props.put("selectionBackgroundColor", "255 247 253");
	            props.put("menuSelectionBackgroundColor", "226 255 253"); 
	            
	            props.put("controlColor", "255 247 253");
	            props.put("controlColorLight", "255 247 253");
	            props.put("controlColorDark", "226 255 253"); 

	            props.put("buttonColor", "226 255 253");
	            props.put("buttonForegroundColor", "53 5 61");
	            props.put("buttonColorLight", "255 247 253");
	            props.put("buttonColorDark", "255 247 253");

	            props.put("rolloverColor", "255 247 253"); 
	            props.put("rolloverColorLight", "255 247 253"); 
	            props.put("rolloverColorDark", "226 255 253"); 

	            props.put("windowTitleForegroundColor", "255 247 253");
	            props.put("windowTitleBackgroundColor", "255 247 253"); 
	            props.put("windowTitleColorLight", "255 247 253"); 
	            props.put("windowTitleColorDark", "238 213 242"); 
	            props.put("windowBorderColor", "255 247 253");
	            props.put("logoString", "Sluzba");
	            
	            props.put("foregroundColor", "53 5 61");
	            props.put("backgroundColor", "255 237 246");
	            props.put("backgroundPattern", "on");
	            props.put("inputForegroundColor", "53 5 61");
	            props.put("inputBackgroundColor", "255 247 253");
	            props.put("frameColor", "226 255 253");
	            props.put("gridColor", "226 255 253");
	            props.put("focusColor", "226 255 253");
	            props.put("windowIconRolloverColor", "226 255 253");
	            props.put("windowInactiveTitleColor", "226 255 253");
	            props.put("menuForegroundColor", "53 5 61");
	            props.put("menuBackgroundColor", "255 247 253");
	            props.put("menuSelectionBackgroundColor", "234 255 254");
	            props.put("menuColorLight", "255 247 253");
	            props.put("menuSelectionForegroundColor", "53 5 61");
	            props.put("toolbarDecorated","on");
	            //props.put("toolbarForegroundColor", "238 213 242");
	            props.put("toolbarBackgroundColor","238 213 242");
	           // props.put("tabAreaBackgroundColor", "255 247 253");
	            props.put("desktopColor", "255 247 253");
	            
	            // set your theme
	            SmartLookAndFeel.setCurrentTheme(props);
			 
	            
	    		
			 UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
	    } 
	    catch (Exception e) {
	       System.out.println("Look and feel error");
	    }
		 
		 UIManager.put("Panel.background", new Color(249, 237, 246));
		 
		 //Profesor p=new Profesor("Petar","Peric",2,3,4,"puskinova","bulevar","a","a","d");
	 	 //GlavniProzor.getRp().profesori.add(p);
		 
		 //GlavniProzor glavniProzor = new GlavniProzor();
				 
	 	 GlavniProzor.getInstance().setVisible(true);
	 	 
	 	 

	}

}
