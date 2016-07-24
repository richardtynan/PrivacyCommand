package view;

import java.awt.Color;

import javax.swing.JLabel;

public class SpaceElement extends JLabel {

	public void setBackground(Color bg) {
		Color old = super.getBackground();
		if (old != null) {
			if (!old.equals(bg)) {
				super.setBackground(bg);
			}
		} else {
			super.setBackground(bg);
		}
	}
	
	

}
