package ui;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;
import model.Friend;
import model.Gift;
import model.Occasion;
import model.Person;

public class GiftProfilePanel extends JPanel{
	
	Gift gift;
	mainFrame frame;
	
	JLabel nameLabel;
	JLabel descriptionLabel;
	JLabel urlLabel;
	JButton backButton;
	JButton editButton;
	
	public GiftProfilePanel(Gift gift, mainFrame MF) {
		super();
		
		this.gift = gift;
		this.frame = MF;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		nameLabel = new JLabel(String.format("%s", gift.getName()));		
		nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(nameLabel);
		
		descriptionLabel = new JLabel(String.format("%s", gift.getDescription()));		
		descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(descriptionLabel);
		
		urlLabel = new JLabel(String.format("%s", gift.getURL()));		
		urlLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(urlLabel);
		
		
		
		backButton = new JButton("Back to Occasion");
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(backButton);
		backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                returnToOccasion();
            }
        });
		
		
		editButton = new JButton("Edit this Gift");
		editButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(editButton);
		editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editGift();
            }
        });
		

	}
	
	private void returnToOccasion() {
		this.frame.replaceView(new OccasionProfilePanel(this.gift.getOccasion(), this.frame));
	}
	
	private void editGift() {
		this.frame.replaceView(new GiftEditPanel(this.gift, this.frame));
	}
		
}
