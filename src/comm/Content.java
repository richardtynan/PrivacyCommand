package comm;

import java.awt.Color;

import javax.swing.JLabel;

public class Content extends Communication {

	public Content(JLabel[][] labels, int grid, int type) {
		super(labels, grid, type);
	}

	public Color getColor() {
		return Color.BLUE;
	}
	
	public Communication spawn() {
		return new RedundantContent(labels, grid, newType(), x, y);
	}

	public boolean isRedundant() {
		return false;
	}

}
