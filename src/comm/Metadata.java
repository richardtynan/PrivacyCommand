package comm;

import java.awt.Color;

import javax.swing.JLabel;

public class Metadata extends Communication {

	public Metadata(JLabel[][] labels, int grid, int type) {
		super(labels, grid, type);
	}
	
	public Color getColor() {
		return Color.GREEN;
	}

	public Communication spawn() {
		return new RedundantMetadata(labels, grid, newType(), x, y);
	}
	
	public boolean isRedundant() {
		return false;
	}

}
