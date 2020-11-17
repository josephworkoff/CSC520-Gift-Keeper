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
import model.Occasion;
import model.Person;

public class OccasionProfilePanel extends JPanel{
	
	Occasion occasion;
	mainFrame frame;
	
	JLabel nameLabel;
	JLabel timeLabel;
	JLabel alertLabel;
	JButton backButton;
	JButton editButton;
	JButton alertButton;
	JButton giftsButton;
	
	public OccasionProfilePanel(Occasion occasion, mainFrame MF) {
		super();
		
		this.occasion = occasion;
		this.frame = MF;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		nameLabel = new JLabel(String.format("%s", occasion.getName()));		
		nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(nameLabel);
		
		timeLabel = new JLabel(String.format("%s", occasion.getTime()));		
		timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(timeLabel);
		
		alertLabel = new JLabel(String.format("Reminder set for %s", occasion.getAlertTime()));		
		alertLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(alertLabel);
		
		
		
		backButton = new JButton("Back to Occasions");
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(backButton);
		backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                returnToOccasionsList();
            }
        });
		
		
		editButton = new JButton("Edit this Occasion");
		editButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(editButton);
		editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editOccasion();
            }
        });
		
		alertButton = new JButton("Set Reminder Time");
		alertButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(alertButton);
		alertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				editAlert();
			}
		});
		
		
		giftsButton = new JButton("View Gifts");
		giftsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(giftsButton);
		giftsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                viewGifts();
            }
        });

	}
	
	private void returnToOccasionsList() {
		this.frame.replaceView(new OccasionsListPanel(this.occasion.getFriend(), this.frame));
	}
	
	private void editOccasion() {
		this.frame.replaceView(new OccasionEditPanel(this.occasion, this.frame));
	}
	
	private void editAlert() {
		this.frame.replaceView(new OccasionEditAlertPanel(this.occasion, this.frame));
	}
	
	private void viewGifts() {
		this.frame.replaceView(new GiftsListPanel(this.occasion, this.frame));
	}
	
}
