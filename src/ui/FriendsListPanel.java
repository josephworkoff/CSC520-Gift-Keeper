package ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

import main.Main;
import model.Friend;
import model.Person;

public class FriendsListPanel extends JPanel{
	

	private static final long serialVersionUID = -4363268338775282017L;
	Person user;
	mainFrame frame;
	
	JLabel label;
	
	JButton backButton;
	JButton addFriendButton;	
	

	public FriendsListPanel(Person user, mainFrame MF) {
		super();
		
		this.user = user;
		this.frame = MF;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	    label = new JLabel(String.format("%s's Friends", user.getName()));
	    label.setAlignmentX(Component.CENTER_ALIGNMENT);
	    add(label);
	    
	    	    
	    backButton = new JButton("Main Menu");
	    backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                returnToMainMenu();
            }
        });
        add(backButton);

        
        
        addFriendButton = new JButton("Add New Friend");
        addFriendButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addFriendButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addFriend();
            }
        });
        add(addFriendButton);
        
        addFriendButtons(user);
	}
	
	
	private void addFriendButtons(Person user) {
        
        JButton button;
        
        for (Friend f: user.getFriends()) {
        	button = new JButton();
        	button.setText(f.getName());
        	button.setAlignmentX(Component.CENTER_ALIGNMENT);
        	button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    viewProfile(f);
                }
            });
        	
        	add(button);
        }
	}
	
	
	private void returnToMainMenu() {
		this.frame.replaceView(new MainMenuPanel(this.user, this.frame));
	}
	
	
	private void addFriend() {
		this.frame.replaceView(new AddFriendPanel(this.user, this.frame));
	}
	
	
	private void viewProfile(Friend friend) {
		this.frame.replaceView(new FriendProfilePanel(friend, this.frame));
		
	}
	
}
