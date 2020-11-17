package ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Friend;

public class FriendProfilePanel extends JPanel{
	
	private static final long serialVersionUID = 6994081093798920977L;
	Friend friend;
	mainFrame frame;
	
	JLabel label;
	JButton backButton;
	JButton editButton;
	JButton occasionsButton;
	
	public FriendProfilePanel(Friend friend, mainFrame MF) {
		super();
		
		this.friend = friend;
		this.frame = MF;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		label = new JLabel(String.format("%s", friend.getName()));		
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(label);
		
		backButton = new JButton("Friends List");
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(backButton);
		backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                returnToFriendsList();
            }
        });
		
		
		editButton = new JButton("Edit " + friend.getName());
		editButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(editButton);
		editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editFriend();
            }
        });
		
		
		occasionsButton = new JButton(String.format("View %s's Occasions", friend.getName()));
		occasionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(occasionsButton);
		occasionsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                viewOccasions();
            }
        });

	}
	
	private void returnToFriendsList() {
		this.frame.replaceView(new FriendsListPanel(this.friend.getPerson(), this.frame));
	}
	
	private void editFriend() {
		this.frame.replaceView(new EditFriendPanel(this.friend, this.frame));
	}
	
	private void viewOccasions() {
		this.frame.replaceView(new OccasionsListPanel(this.friend, this.frame));
	}
	
	
}

