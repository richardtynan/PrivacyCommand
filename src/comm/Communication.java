package comm;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

public abstract class Communication {

	protected int type;
	protected int x, y;
	protected JLabel[][] labels;
	protected int grid;
	protected boolean finish;

	public Communication(JLabel[][] labels, int grid, int type) {
		this.grid = grid;
		this.finish = false;
		this.type = type;
		this.labels = labels;
		this.x = grid / 2;
		this.y = grid / 2;
		if (type == 0) {
			x--;
			y--;
		} else if (type == 4) {
			x++;
			y++;
		} else if (type == 6) {
			x--;
			y++;
		} else if (type == 2) {
			x++;
			y--;
		} else if (type == 7) {
			x--;
		} else if (type == 3) {
			x++;
		} else if (type == 1) {
			y--;
		} else if (type == 5) {
			y++;
		}
	}
	
	public int newType() {
		int newType = 0;
		int newDir = (int) (Math.random() * 2);
		if (type == 1 || type == 5) {
			if (newDir == 0) {
				newType = 7;
			} else {
				newType = 3;
			}
		} else if (type == 7 || type == 3) {
			if (newDir == 0) {
				newType = 5;
			} else {
				newType = 1;
			}
		} else if (type == 0 || type == 4) {
			if (newDir == 0) {
				newType = 6;
			} else {
				newType = 2;
			}
		} else if (type == 6 || type == 2) {
			if (newDir == 0) {
				newType = 0;
			} else {
				newType = 4;
			}
		}
		return newType;
	}

	public void move() {
		if (type == 0) {
			if (x > 0 && y > 0) {
				labels[x][y].setBackground(Color.LIGHT_GRAY);
				x--;
				y--;
				labels[x][y].setBackground(getColor());
			} else
				finish = true;
		} else if (type == 4) {
			if (x < grid - 1 && y < grid - 1) {
				labels[x][y].setBackground(Color.LIGHT_GRAY);
				x++;
				y++;
				labels[x][y].setBackground(getColor());
			} else
				finish = true;
		} else if (type == 6) {
			if (x > 0 && y < grid - 1) {
				labels[x][y].setBackground(Color.LIGHT_GRAY);
				x--;
				y++;
				labels[x][y].setBackground(getColor());
			} else
				finish = true;
		} else if (type == 2) {
			if (x < grid - 1 && y > 0) {
				labels[x][y].setBackground(Color.LIGHT_GRAY);
				x++;
				y--;
				labels[x][y].setBackground(getColor());
			} else
				finish = true;
		} else if (type == 7) {
			if (x > 0) {
				labels[x][y].setBackground(Color.LIGHT_GRAY);
				x--;
				labels[x][y].setBackground(getColor());
			} else
				finish = true;
		} else if (type == 3) {
			if (x < grid - 1) {
				labels[x][y].setBackground(Color.LIGHT_GRAY);
				x++;
				labels[x][y].setBackground(getColor());
			} else
				finish = true;
		} else if (type == 1) {
			if (y > 0) {
				labels[x][y].setBackground(Color.LIGHT_GRAY);
				y--;
				labels[x][y].setBackground(getColor());
			} else
				finish = true;
		} else if (type == 5) {
			if (y < grid - 1) {
				labels[x][y].setBackground(Color.LIGHT_GRAY);
				y++;
				labels[x][y].setBackground(getColor());
			} else
				finish = true;
		}
	}

	public Point getLoc() {
		return new Point(x, y);
	}

	public boolean getFinish() {
		return this.finish;
	}

	public void clear() {
		labels[x][y].setBackground(Color.LIGHT_GRAY);
	}

	public abstract Communication spawn();

	public abstract Color getColor();
	
	public abstract boolean isRedundant();

}
