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
import model.Gift;
import model.Occasion;
import model.Person;

public class GiftsListPanel extends JPanel {
	
	Occasion occasion;
	mainFrame frame;
	
	JLabel label;
	
	JButton backButton;
	JButton addGiftButton;
	
	

	public GiftsListPanel(Occasion occasion, mainFrame MF) {
		super();
		
		this.occasion = occasion;
		this.frame = MF;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	    label = new JLabel(String.format("%s's Occasions", occasion.getName()));
	    label.setAlignmentX(Component.CENTER_ALIGNMENT);
	    add(label);
	    
	    	    
	    backButton = new JButton("Return to Occasion");
	    backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                returnToOccasion();
            }
        });
        add(backButton);

        
        
        addGiftButton = new JButton("Add New Gift");
        addGiftButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addGiftButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addGift();
            }
        });
        add(addGiftButton);
        
        addGiftButtons(occasion);
	}
	
	
	private void addGiftButtons(Occasion occasion) {
        
        JButton button;
        
        for (Gift g: occasion.getGifts()) {
        	button = new JButton();
        	button.setText(g.getName());
        	button.setAlignmentX(Component.CENTER_ALIGNMENT);
        	button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    viewGift(g);
                }
            });
        	
        	add(button);
        }
	}
	
	
	private void returnToOccasion() {
		this.frame.replaceView(new OccasionProfilePanel(this.occasion, this.frame));
	}
	
	private void addGift() {
		this.frame.replaceView(new AddGiftPanel(this.occasion, this.frame));
	}
	
	private void viewGift(Gift gift) {
		this.frame.replaceView(new GiftProfilePanel(gift, this.frame));
	}
		

}
