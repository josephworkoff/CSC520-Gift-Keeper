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

public class EditFriendPanel extends JPanel{

	Friend friend;
	mainFrame frame;
	
	JLabel label;
	JLabel errorLabel;
	JLabel nameLabel;
	JButton cancelButton;
	JButton submitButton;
	JButton deleteButton;
	JButton deleteConfirmButton;
	JTextField nameField;
	
	JPanel namePanel;
	
	public EditFriendPanel(Friend friend, mainFrame MF) {
		super();
		
		this.friend = friend;
		this.frame = MF;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		label = new JLabel(String.format("Editing %s", friend.getName()));		
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
		nameField.setText(friend.getName());
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
				submitFriendEdit();
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelFriendEdit();
            }
        });
		
		deleteButton = new JButton("Delete " + this.friend.getName());
		deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteFriend1();
			}
		});
		
		deleteConfirmButton = new JButton(String.format("Really Delete %s?", this.friend.getName()));
		deleteConfirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		deleteConfirmButton.setVisible(false);
		this.add(deleteConfirmButton);
		deleteConfirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteFriend2();
			}
		});
		
	}
	
	private void cancelFriendEdit() {
		this.frame.replaceView(new FriendProfilePanel(this.friend, this.frame));
	}
	
	private void submitFriendEdit() {
		
		String name = this.nameField.getText();
		if (name.equals("")) {
			this.errorLabel.setText("Please enter a name.");
			this.errorLabel.setVisible(true);
			return;
		}
		
		this.friend.setName(name);
		this.frame.replaceView(new FriendProfilePanel(this.friend, this.frame));
	}
	
	private void deleteFriend1() {
		this.deleteButton.setVisible(false);
		this.deleteConfirmButton.setVisible(true);
	}
	
	private void deleteFriend2() {
		Person user = this.friend.getPerson();
		
		user.removeFriend(friend);
		this.frame.replaceView(new FriendsListPanel(user, this.frame));
	}
	
}
