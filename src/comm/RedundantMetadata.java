package comm;

import java.awt.Color;

import javax.swing.JLabel;

public class RedundantMetadata extends Metadata {

	public RedundantMetadata(JLabel[][] labels, int grid, int type, int x, int y) {
		super(labels, grid, type);
		this.x = x;
		this.y = y;
	}
	
	public Color getColor() {
		return Color.ORANGE;
	}

	public boolean isRedundant() {
		return true;
	}
}
