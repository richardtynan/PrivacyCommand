package view;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame {

	public static void main(String[] args) {
		JPanel gamePanel = new JPanel(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		Space space = new Space();

		g.gridx = 0;
		g.gridy = 0;
		g.weightx = 0;
		g.weighty = 0;
		g.fill = GridBagConstraints.HORIZONTAL;
		gamePanel.add(space.getCritical(), g);

		g.gridx = 1;
		g.gridy = 0;
		g.weightx = 0;
		g.weighty = 0;
		g.fill = GridBagConstraints.HORIZONTAL;
		gamePanel.add(space.getRedundant(), g);

		g.gridx = 2;
		g.gridy = 0;
		g.weightx = 0;
		g.weighty = 0;
		g.fill = GridBagConstraints.HORIZONTAL;
		gamePanel.add(space.getTotal(), g);

		g.gridx = 0;
		g.gridy = 1;
		g.weightx = 1;
		g.weighty = 1;
		g.gridwidth = 3;
		g.fill = GridBagConstraints.BOTH;
		gamePanel.add(space, g);

		JFrame frame = new JFrame("Privacy Command");
		frame.setContentPane(gamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.pack();
		frame.setVisible(true);

		new Thread(space).start();

	}

}
