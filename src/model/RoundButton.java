package model;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class RoundButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoundButton(String label) {
		super(label);

		setBackground(Color.lightGray);
		setFocusable(false);

		Dimension size = getPreferredSize();
		size.width = 74;
		size.height = 34;// Math.max(size.width, size.height);
		setPreferredSize(size);

		setContentAreaFilled(false);
	}

	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(new Color(234, 255, 254));
		} else {
			g.setColor(getBackground());
		}
		g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(new Color(220, 197, 224));
		g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
	}

	Shape shape;

	public boolean contains(int x, int y) {

		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}
}
