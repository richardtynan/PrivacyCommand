package view;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

public class Blast {

	private int lifetime;
	private JLabel[][] labels;
	private int grid;
	private int blastRadius;
	private Point p;

	public Blast(JLabel[][] labels, JLabel label, int lifetime, int grid, int blastRadius) {
		this.labels = labels;
		this.lifetime = lifetime;
		this.grid = grid;
		this.blastRadius = blastRadius;
		p = new Point(0, 0);
		for (int i = 0; i < grid; i++) {
			for (int j = 0; j < grid; j++) {
				if (label == labels[i][j]) {
					p = new Point(i, j);
				}
			}
		}
	}

	public void blast() {
		for (int i = 0; i < grid; i++) {
			for (int j = 0; j < grid; j++) {
				Point q = new Point(i, j);
				if (p.distance(q) < blastRadius) {
					labels[i][j].setBackground(Color.RED);
				}
			}
		}
		lifetime--;
	}

	public void reset() {
		for (int i = 0; i < grid; i++) {
			for (int j = 0; j < grid; j++) {
				Point q = new Point(i, j);
				if (p.distance(q) < blastRadius) {
					labels[i][j].setBackground(Color.LIGHT_GRAY);
				}
			}
		}
	}

	public Point getLoc() {
		return p;
	}

	public boolean getFinish() {
		return lifetime == 0;
	}
}
