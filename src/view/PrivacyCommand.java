package view;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrivacyCommand {
	private static Space space;

	public static void main(String[] args) {
		
		JPanel gamePanel = new JPanel(new GridBagLayout());

		JFrame frame = new JFrame("Privacy Command");
		frame.setContentPane(gamePanel);
		
		JButton btnGameInfo = new JButton("Game Info");
		btnGameInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clickMessage = new String();
				clickMessage = "Data leakage is everywhere! \n" +
				"In this game, the squares represent both critical data and redundant data.\n" +
						"We want to keep the critical, but scrub the redundant! \n" +
						"Try to destroy the redundant data while maintaining you critical data.\n" +
						"The larger the score the better! Negative means you have too much redundant data! \n \n" +
						"GOOD LUCK!";
						
				JOptionPane.showMessageDialog(gamePanel, clickMessage);
			}
		});
		GridBagConstraints gbc_btnGameInfo = new GridBagConstraints();
		gbc_btnGameInfo.insets = new Insets(0, 0, 5, 5);
		gbc_btnGameInfo.gridx = 0;
		gbc_btnGameInfo.gridy = 1;
		gamePanel.add(btnGameInfo, gbc_btnGameInfo);
		
		
		GridBagConstraints gbc_space = new GridBagConstraints();
		space = new Space();
		
		gbc_space.gridx = 0;
		gbc_space.gridy = 0;
		gbc_space.weightx = 0;
		gbc_space.weighty = 0;
		gbc_space.fill = GridBagConstraints.HORIZONTAL;
		gamePanel.add(space.getCritical(), gbc_space);
		
		gbc_space.gridx = 1;
		gbc_space.gridy = 0;
		gbc_space.weightx = 0;
		gbc_space.weighty = 0;
		gbc_space.fill = GridBagConstraints.HORIZONTAL;
		gamePanel.add(space.getRedundant(), gbc_space);
				
		gbc_space.gridx = 2;
		gbc_space.gridy = 0;
		gbc_space.weightx = 0;
		gbc_space.weighty = 0;
		gbc_space.fill = GridBagConstraints.HORIZONTAL;
		gamePanel.add(space.getTotal(), gbc_space);
								
				//		TODO: add labels for data leakage
				
//		gbc_space.gridx = 1;
//		gbc_space.gridy = 1;
//		gbc_space.weightx = 0;
//		gbc_space.weighty = 0;
//		gbc_space.fill = GridBagConstraints.HORIZONTAL;
//		gamePanel.add(space.getLegend(), gbc_space);
						
//		gbc_space.gridx = 2;
//		gbc_space.gridy = 1;
//		gbc_space.weightx = 0;
//		gbc_space.weighty = 0;
//		gbc_space.fill = GridBagConstraints.REMAINDER;
//		gamePanel.add(space.getLegendColors(), gbc_space);
										
		gbc_space.gridx = 0;
		gbc_space.gridy = 2;
		gbc_space.weightx = 1;
		gbc_space.weighty = 1;
		gbc_space.gridwidth = 3;
		gbc_space.fill = GridBagConstraints.BOTH;
		gamePanel.add(space, gbc_space);
				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
//		frame.setSize(512, 600);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		new Thread(space).start();

	}

	public Space getSpace() {
		return space;
	}
}


//TODO: include more attack vectors (meta data, etc)
//
//TODO: create documentation for project and "upfront" for game



