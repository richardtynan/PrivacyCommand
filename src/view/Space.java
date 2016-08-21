package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import comm.Communication;
import comm.Content;
import comm.Metadata;

public class Space extends JPanel implements MouseInputListener, Runnable {

	private int grid = 127;
	private int sleep = 100;

	private int contentGenPeriod = 20;
	private int metadataGenPeriod = 7;
	private int spawnPeriod = 5;
	private int spawnAmount = 2;

	private int blastRadius = 5;
	private int blastLen = 5;
	
	private SpaceElement[][] labels;
	private Vector<Communication> contents;
	private Vector<Blast> blasts;

	private JLabel critical;
	private int criticalNumGen;
	private int criticalNumRec;

	private JLabel redundant;
	private int redundantNumGen;
	private int redundantNumRec;
	
	private JLabel legendTitle;
	private JLabel legendColors;

	private JLabel total;
	
	private String label_crit = "Critical (blue+green):";
	private String label_red = "Redundant (orange+yellow):";
	
	public Space() {
		this.setLayout(new GridLayout(grid, grid));
		this.setOpaque(true);
		labels = new SpaceElement[grid][grid];
		for (int i = 0; i < grid; i++) {
			for (int j = 0; j < grid; j++) {
				SpaceElement label = new SpaceElement();
				label.setOpaque(true);
				label.addMouseListener(this);
				if (i == (grid / 2) && j == (grid / 2)) {
					label.setBackground(Color.BLACK);
				} else {
					label.setBackground(Color.LIGHT_GRAY);
				}
				labels[i][j] = label;
				this.add(label);
			}
		}
		contents = new Vector<>();
		blasts = new Vector<>();
		this.critical = new JLabel(label_crit);
		this.critical.setOpaque(true);
		this.redundant = new JLabel(label_red);
		this.redundant.setOpaque(true);
		this.total = new JLabel("Total : ");
		this.total.setOpaque(true);
		this.legendTitle = new JLabel("Legend:");
		this.legendTitle.setOpaque(true);
//		this.legend = new JLabel("Comm:");
//		this.legend.setOpaque(true);
		this.legendColors = new JLabel("Content: blue| Meta: green| Content2: yellow | Meta2: cyan");
		this.legendColors.setOpaque(true);
		this.criticalNumGen = 0;
		this.criticalNumRec = 0;
		this.redundantNumGen = 0;
		this.redundantNumRec = 0;
	}

	public void run() {
		int contentGen = 0;
		int metadataGen = 0;
		int spawn = 0;

		int type = 0;
		while (true) {
			for (int i = 0; i < contents.size(); i++) {
				if (contents.elementAt(i).getFinish() == true) {
					if (contents.elementAt(i).isRedundant()) {
						redundantNumRec++;
					} else {
						criticalNumRec++;
					}
					contents.elementAt(i).clear();
					contents.removeElementAt(i);
					i--;
				}
			}
			if (contentGen == 0) {
				type = (int) (Math.random() * 8);
				contents.addElement(new Metadata(labels, grid, type));
				criticalNumGen++;
			} else if (contentGen == 2) {
				contents.addElement(new Content(labels, grid, type));
				criticalNumGen++;
			} else if (contentGen == 4) {
				contents.addElement(new Metadata(labels, grid, type));
				criticalNumGen++;
			}
			if (contentGen == contentGenPeriod) {
				contentGen = 0;
			} else {
				contentGen++;
			}
			if (metadataGen == 0) {
				contents.addElement(new Metadata(labels, grid, type));
				criticalNumGen++;
			}
			if (metadataGen == metadataGenPeriod) {
				metadataGen = 0;
			} else {
				metadataGen++;
			}
			for (int i = 0; i < blasts.size(); i++) {
				if (blasts.elementAt(i).getFinish() == true) {
					blasts.elementAt(i).reset();
					blasts.removeElementAt(i);
					i--;
				} else
					blasts.elementAt(i).blast();
			}
			for (int i = 0; i < contents.size(); i++) {
				for (int j = 0; j < blasts.size(); j++) {
					if (contents.elementAt(i).getLoc().distance(blasts.elementAt(j).getLoc()) < blastRadius) {
						contents.removeElementAt(i);
						i--;
						j = blasts.size();
					}
				}
			}
			for (int i = 0; i < spawnAmount; i++) {
				int randSpawn = (int) (Math.random() * contents.size());
				if (randSpawn < contents.size() && spawn == 0) {
					contents.addElement(contents.elementAt(randSpawn).spawn());
					redundantNumGen++;
				}
			}
			if (spawn == spawnPeriod) {
				spawn = 0;
			} else {
				spawn++;
			}
			for (int i = 0; i < contents.size(); i++) {
				contents.elementAt(i).move();
			}
			labels[grid / 2][grid / 2].setBackground(Color.BLACK);
			int crit = (int) (((double) criticalNumRec / (double) criticalNumGen) * 100.0);
			int red = (int) (((double) redundantNumRec / (double) redundantNumGen) * 100.0);
			int tot = (int) (((double) crit / (double) red) * 100.0);
			this.critical.setText(label_crit + crit + " ");
			this.redundant.setText(label_red  + red + " ");
			this.total.setText("Total : " + (tot - 100) + " ");
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		blasts.addElement(new Blast(labels, (JLabel) e.getSource(), blastLen, grid, blastRadius));
	}

	public JLabel getCritical() {
		return critical;
	}

	public JLabel getRedundant() {
		return redundant;
	}

	public JLabel getTotal() {
		return total;
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}

	public Component getLegend() {
		return legendTitle;
	}

	public Component getLegendColors() {
		return legendColors;
	}
}
