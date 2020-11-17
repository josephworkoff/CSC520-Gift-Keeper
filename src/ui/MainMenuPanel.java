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
import model.Person;

public class MainMenuPanel extends JPanel {

	Person user;
	mainFrame frame;
	
	JLabel label;
	
	JButton backButton;
	JButton friendsListButton;
	
	public MainMenuPanel(Person user, mainFrame MF) {
		super();
		
		this.user = user;
		this.frame = MF;
		
	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	    label = new JLabel(user.getName());
	    add(label);
	    label.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    
	    friendsListButton = new JButton("View Friends");
	    friendsListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(friendsListButton);
        
        friendsListButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                friendsList();
                
            }
        });
	}
	
	private void friendsList() {
		this.frame.replaceView(new FriendsListPanel(this.user, frame));
	}
	
}
