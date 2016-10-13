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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Choice;

public class PrivacyCommand {

	private static Space space;
	
	private static JCheckBox chckbxGoogleAccount; 
	private static String label_google = new String("Google");
	private static event e;
	private static JLabel lblDoYouHave;
	
	
	public class event implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (chckbxGoogleAccount.isSelected()) {
				lblDoYouHave.setText("This is awful!");
				
				//chckbxGoogleAccount.setText("changed");
			} else {
				lblDoYouHave.setText(label_google);
				}
		}
	} //end of event

	public static void main(String[] args) {
		
		GridBagLayout gbl_gamePanel = new GridBagLayout();
		gbl_gamePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		JPanel gamePanel = new JPanel(gbl_gamePanel);

		JFrame frame = new JFrame("Privacy Command");
		frame.setContentPane(gamePanel);
		
		

		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblSettings = new GridBagConstraints();
		gbc_lblSettings.insets = new Insets(0, 0, 5, 0);
		gbc_lblSettings.gridx = 3;
		gbc_lblSettings.gridy = 0;
		gamePanel.add(lblSettings, gbc_lblSettings);
		
		JButton btnGameInfo = new JButton("Game Info");
		btnGameInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clickMessage = new String();
				clickMessage = "Welcome to the internet! \n" +
				"It's a great place, but data leakage is everywhere! \n\n" +
						"In this game, the squares represent both critical data and redundant data.\n" +
						"We want to keep the critical, but scrub the redundant! \n" +
						"By clicking, try to destroy the redundant data while maintaining you critical data.\n \n" +
						"Check the box next to online service to see how your private data is affected \n" +
						"See how the different privacy tools can help preserve your privacy by checking their boxes. \n\n" +
						"Higher scores are better! Negative means you have too much redundant data! \n\n" +
						"GOOD LUCK! And safe browsing :)";
						
				JOptionPane.showMessageDialog(gamePanel, clickMessage);
			}
		});
		GridBagConstraints gbc_btnGameInfo = new GridBagConstraints();
		gbc_btnGameInfo.insets = new Insets(0, 0, 5, 0);
		gbc_btnGameInfo.gridx = 3;
		gbc_btnGameInfo.gridy = 1;
		gamePanel.add(btnGameInfo, gbc_btnGameInfo);
		
		
		GridBagConstraints gbc_space = new GridBagConstraints();
		gbc_space.insets = new Insets(0, 0, 0, 5);
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
		gbc_space.gridy = 1;
		gbc_space.weightx = 1;
		gbc_space.weighty = 1;
		gbc_space.gridheight = 15;
		gbc_space.gridwidth = 3;
		gbc_space.fill = GridBagConstraints.BOTH;
		gamePanel.add(space, gbc_space);
		
		JLabel labelSpace1 = new JLabel("   ");
		GridBagConstraints gbc_labelSpace1 = new GridBagConstraints();
		gbc_labelSpace1.insets = new Insets(0, 0, 5, 0);
		gbc_labelSpace1.gridx = 3;
		gbc_labelSpace1.gridy = 2;
		gamePanel.add(labelSpace1, gbc_labelSpace1);
		
//		JLabel lblDoYouHave = new JLabel("The effect of using:");
		lblDoYouHave = new JLabel("The effect of using:");
		GridBagConstraints gbc_lblDoYouHave = new GridBagConstraints();
		gbc_lblDoYouHave.insets = new Insets(0, 0, 5, 0);
		gbc_lblDoYouHave.gridx = 3;
		gbc_lblDoYouHave.gridy = 3;
		gamePanel.add(lblDoYouHave, gbc_lblDoYouHave);
		
		//Checkbox: google
//		JCheckBox chckbxGoogleAccount = new JCheckBox("Google");
		
		chckbxGoogleAccount = new JCheckBox(label_google);
		
//		e = event;
		
		chckbxGoogleAccount.addItemListener(e);
		
		
		chckbxGoogleAccount.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxGoogleAccount = new GridBagConstraints();
		gbc_chckbxGoogleAccount.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxGoogleAccount.gridx = 3;
		gbc_chckbxGoogleAccount.gridy = 4;
		gamePanel.add(chckbxGoogleAccount, gbc_chckbxGoogleAccount);
		
//		private class HandlerClass implements ItemListener{
//			public void itemStateChanged(ItemEvent event){
//				if (chckbxGoogleAccount.isSelected() {
//					chckbxGoogleAccount.setToolTipText("You did it);
//				}			
//			}
//		}
//		
//		HandlerClass handler = new HandlerClass(); 
//		chckbxGoogleAccount.addItemListener(handlerl);
		

		//Checkbox: Facebook
		JCheckBox chckbxFacebookAccount = new JCheckBox("Facebook");
		GridBagConstraints gbc_chckbxFacebookAccount = new GridBagConstraints();
		gbc_chckbxFacebookAccount.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxFacebookAccount.gridx = 3;
		gbc_chckbxFacebookAccount.gridy = 5;
		gamePanel.add(chckbxFacebookAccount, gbc_chckbxFacebookAccount);
		
		JCheckBox chckbxThirdpartyCookies = new JCheckBox("Third-party cookies");
		GridBagConstraints gbc_chckbxThirdpartyCookies = new GridBagConstraints();
		gbc_chckbxThirdpartyCookies.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxThirdpartyCookies.gridx = 3;
		gbc_chckbxThirdpartyCookies.gridy = 6;
		gamePanel.add(chckbxThirdpartyCookies, gbc_chckbxThirdpartyCookies);
		
		JLabel labelSpace2 = new JLabel("       ");
		GridBagConstraints gbc_labelSpace2 = new GridBagConstraints();
		gbc_labelSpace2.insets = new Insets(0, 0, 5, 0);
		gbc_labelSpace2.gridx = 3;
		gbc_labelSpace2.gridy = 7;
		gamePanel.add(labelSpace2, gbc_labelSpace2);
		
		JLabel lblPrivacyTools = new JLabel("Privacy tools:");
		GridBagConstraints gbc_lblPrivacyTools = new GridBagConstraints();
		gbc_lblPrivacyTools.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrivacyTools.gridx = 3;
		gbc_lblPrivacyTools.gridy = 8;
		gamePanel.add(lblPrivacyTools, gbc_lblPrivacyTools);
		
		JCheckBox chckbxVpn = new JCheckBox("VPN");
		GridBagConstraints gbc_chckbxVpn = new GridBagConstraints();
		gbc_chckbxVpn.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxVpn.gridx = 3;
		gbc_chckbxVpn.gridy = 9;
		gamePanel.add(chckbxVpn, gbc_chckbxVpn);
		
		JCheckBox chckbxTor = new JCheckBox("Tor");
		GridBagConstraints gbc_chckbxTor = new GridBagConstraints();
		gbc_chckbxTor.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxTor.gridx = 3;
		gbc_chckbxTor.gridy = 10;
		gamePanel.add(chckbxTor, gbc_chckbxTor);
		
		JCheckBox chckbxDuckduckgo = new JCheckBox("DuckDuckGo");
		GridBagConstraints gbc_chckbxDuckduckgo = new GridBagConstraints();
		gbc_chckbxDuckduckgo.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxDuckduckgo.gridx = 3;
		gbc_chckbxDuckduckgo.gridy = 11;
		gamePanel.add(chckbxDuckduckgo, gbc_chckbxDuckduckgo);
				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
//		frame.setSize(512, 600);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		new Thread(space).start();
		
	} //end of main
	

	
	
	

	public Space getSpace() {
		return space;
	}
	
	
	
}


//TODO: include more attack vectors (meta data, etc)
//
//TODO: create documentation for project and "upfront" for game



