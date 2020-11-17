package ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Friend;
import model.Occasion;
import model.Person;

public class OccasionsListPanel extends JPanel {
	
	Friend friend;
	mainFrame frame;
	
	JLabel label;
	
	JButton backButton;
	JButton addOccasionButton;
	

	public OccasionsListPanel(Friend friend, mainFrame MF) {
		super();
		
		this.friend = friend;
		this.frame = MF;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	    label = new JLabel(String.format("%s's Occasions", friend.getName()));
	    label.setAlignmentX(Component.CENTER_ALIGNMENT);
	    add(label);
	    
	    	    
	    backButton = new JButton("Return to Profile");
	    backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                returnToFriend();
            }
        });
        add(backButton);

        
        
        addOccasionButton = new JButton("Add New Occasion");
        addOccasionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addOccasionButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addOccasion();
            }
        });
        add(addOccasionButton);
        
        addOccasionButtons(friend);
	}
	
	
	private void addOccasionButtons(Friend friend) {
        
        JButton button;
        
        for (Occasion o: friend.getOccasions()) {
        	button = new JButton();
        	button.setText(o.getName());
        	button.setAlignmentX(Component.CENTER_ALIGNMENT);
        	button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    viewOccasion(o);
                }
            });
        	
        	add(button);
        }
	}
	
	
	private void returnToFriend() {
		this.frame.replaceView(new FriendProfilePanel(this.friend, this.frame));
	}
	
	private void addOccasion() {
		this.frame.replaceView(new AddOccasionPanel(this.friend, this.frame));
	}
	
	private void viewOccasion(Occasion occasion) {
		this.frame.replaceView(new OccasionProfilePanel(occasion, this.frame));
	}
	

}
