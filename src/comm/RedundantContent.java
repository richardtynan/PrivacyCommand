package comm;

import java.awt.Color;

import javax.swing.JLabel;

public class RedundantContent extends Content {

	public RedundantContent(JLabel[][] labels, int grid, int type, int x, int y) {
		super(labels, grid, type);
		this.x = x;
		this.y = y;
	}

	public Color getColor() {
		return Color.YELLOW;
	}
	
	public boolean isRedundant() {
		return true;
	}

}
