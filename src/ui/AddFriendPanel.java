package ui;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Main;
import model.Friend;
import model.Occasion;
import model.Person;

public class AddFriendPanel extends JPanel{

	Person user;
	mainFrame frame;
	
	JLabel label;
	JLabel errorLabel;
	JLabel nameLabel;
	JButton cancelButton;
	JButton submitButton;
	JTextField nameField;
	
	JPanel namePanel;
	
	public AddFriendPanel(Person user, mainFrame MF) {
		super();
		
		this.user = user;
		this.frame = MF;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		label = new JLabel("Add a new Friend");		
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(label);
		
		errorLabel = new JLabel("");		
		errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(errorLabel);
		errorLabel.setVisible(false);
		
		namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		nameLabel = new JLabel("Name");		
		nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		namePanel.add(nameLabel);
		
		nameField = new JTextField(20);
		nameField.setText("");
		nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
		namePanel.add(nameField);
		
		namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(namePanel);
		
		submitButton = new JButton("Confirm");
		submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(submitButton);
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addNewFriend();
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelNewFriend();
            }
        });
		
		
	}
	
	
	private void cancelNewFriend() {
		this.frame.replaceView(new FriendsListPanel(this.user, this.frame));
	}
	
	
	private void addNewFriend() {
		
		String name = this.nameField.getText();
		
		if (name.equals("")) {
			this.errorLabel.setText("Please enter a name.");
			this.errorLabel.setVisible(true);
			return;
		}
		
		Friend friend = new Friend(this.nameField.getText(), this.user);
		user.addFriend(friend);
		
		this.frame.replaceView(new FriendsListPanel(this.user, this.frame));
	}
	

	
}
