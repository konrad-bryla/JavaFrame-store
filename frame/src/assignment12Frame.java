//Konrad Bryla
//12/5/2018
//Assignment 12

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class assignment12Frame extends JFrame {
	static final double REG_IPAD = 429;
	static final double PRO_IPAD = 649;
	static final double IPHONE_REG = 699;
	static final double IPHONE_UPGRADE = 849;
	
	private JLabel storeName;
	private JLabel cityName;
	private JLabel iPadLabel;
	private JTextField iPadTextField;
	private JLabel iPhoneLabel;
	private JLabel iPhoneStored;
	private JCheckBox iPadUpgrade;
	private JCheckBox upgradeGB;
	private JButton phoneChange;
	private JButton calculateCost;
	
public assignment12Frame() {
		storeName = new JLabel("Apple Store");
		storeName.setHorizontalAlignment(SwingConstants.CENTER);
		storeName.setBackground(Color.CYAN);
		storeName.setOpaque(true);
		storeName.setFont(new Font("Ariel", Font.BOLD, 25));
		
		cityName = new JLabel("Chicago");
		cityName.setHorizontalAlignment(SwingConstants.CENTER);
		cityName.setBackground(Color.CYAN);
		cityName.setOpaque(true);
		cityName.setFont(new Font("Ariel", Font.BOLD, 25));
		
		iPadLabel = new JLabel("Number of iPads:");
		iPadLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		iPadLabel.setFont(new Font("Ariel", Font.BOLD, 15));
		
		iPadTextField = new JTextField();
		iPadTextField.addActionListener(new iPadTextFieldHandler());
		
		iPhoneLabel = new JLabel("How many iPhones:");
		iPhoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		iPhoneLabel.setFont(new Font("Ariel", Font.BOLD, 15));
		
		iPhoneStored = new JLabel("1");
		iPhoneStored.setHorizontalAlignment(SwingConstants.LEFT);
		
		iPadUpgrade = new JCheckBox("Upgrade to iPad Pro");
		iPadUpgrade.setFont(new Font("Ariel", Font.PLAIN, 15));
		iPadUpgrade.addActionListener(new iPadUpgradeCheckBoxHandler());
		
		upgradeGB = new JCheckBox("Upgrade to 256GB");
		upgradeGB.setFont(new Font("Ariel", Font.PLAIN, 15));
		upgradeGB.addActionListener(new upgradeGBCheckBoxHandler());
		
		phoneChange = new JButton("Change number of phones");
		phoneChange.setFont(new Font("Ariel", Font.PLAIN, 15));
		phoneChange.setBackground(Color.BLACK);
		phoneChange.setForeground(Color.WHITE);
		phoneChange.addActionListener(new changePhoneButtonHandler());
		
		calculateCost = new JButton("Calculate Cost");
		calculateCost.setFont(new Font("Ariel", Font.PLAIN, 15));
		calculateCost.setBackground(Color.BLACK);
		calculateCost.setForeground(Color.WHITE);
		calculateCost.addActionListener(new calculateCostButtonHandler());
		
	this.setSize(500, 500);
	this.setTitle("Konrad Bryla's Store of Apples");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container pane = this.getContentPane();
	pane.setLayout(new GridLayout(5,2));
	
	pane.add(storeName);
	pane.add(cityName);
	pane.add(iPadLabel);
	pane.add(iPadTextField);
	pane.add(iPhoneLabel);
	pane.add(iPhoneStored);
	pane.add(iPadUpgrade);
	pane.add(upgradeGB);
	pane.add(phoneChange);
	pane.add(calculateCost);
	this.setVisible(true);
	}

private class iPadTextFieldHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		double iPadNumber = 1;
		iPadNumber = Double.parseDouble(iPadLabel.getText());
	}
}
private class iPadUpgradeCheckBoxHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (iPadUpgrade.isSelected()) {
			iPadLabel.setForeground(Color.YELLOW);
			iPadLabel.setFont(new Font("Ariel", Font.BOLD, 15));
		}else {
			iPadLabel.setForeground(Color.BLACK);
			iPadLabel.setFont(new Font("Ariel", Font.PLAIN, 15));	
		}
	}
}
private class upgradeGBCheckBoxHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (upgradeGB.isSelected()) {
			
		}else {
			
		}
	}
}
private class changePhoneButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String newiPhone = JOptionPane.showInputDialog(phoneChange, "New number of iPhones:", null);
		if (newiPhone != null) {
			iPhoneStored.setText(newiPhone);
		}
	}
}
private class calculateCostButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		double iPadCost = 0;
		double iPadTotal;
		double iPhoneCost = 0;
		double iPhoneTotal;
		double totalCost;
		
		double numberOfIPads = Double.parseDouble(iPadTextField.getText());
		double numberOfIPhones = Double.parseDouble(iPhoneStored.getText());
		
		if(iPadUpgrade.isSelected() == false) {
			iPadCost = REG_IPAD;
		}else if(iPadUpgrade.isSelected() == true) {
			iPadCost = PRO_IPAD;
		}
		if(upgradeGB.isSelected() == false) {
			iPhoneCost = IPHONE_REG;
		}else if(upgradeGB.isSelected() == true) {
			iPhoneCost = IPHONE_UPGRADE;
		}
		
		iPadTotal = iPadCost * numberOfIPads;
		iPhoneTotal = iPhoneCost * numberOfIPhones;
		totalCost = iPadTotal + iPhoneTotal;
		
		String message = String.format("Konrads Apple Store\n\niPads Total: $%,.2f\niPhones Total: $%,.2f\n\nPurchase Total: $%,.2f", iPadTotal, iPhoneTotal, totalCost);
			JOptionPane.showMessageDialog(null, message, "Customer Bill", JOptionPane.INFORMATION_MESSAGE);
	}
}
}
