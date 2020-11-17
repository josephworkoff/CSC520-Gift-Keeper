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
import model.Gift;
import model.Occasion;
import model.Person;

public class GiftEditPanel extends JPanel{

	Gift gift;
	mainFrame frame;
	
	JLabel label;
	JLabel errorLabel;
	JLabel nameLabel;
	JLabel descriptionLabel;
	JLabel urlLabel;
	JButton cancelButton;
	JButton submitButton;
	JButton deleteButton;
	JButton deleteConfirmButton;
	JTextField nameField;
	JTextField descriptionField;
	JTextField urlField;
	
	JPanel namePanel;
	JPanel descriptionPanel;
	JPanel urlPanel;
	
	public GiftEditPanel(Gift gift, mainFrame MF) {
		super();
		
		this.gift = gift;
		this.frame = MF;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		label = new JLabel("Editing Gift " + gift.getName());		
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
		nameField.setText(gift.getName());
		nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
		namePanel.add(nameField);
		
		namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(namePanel);
		
		
		
		descriptionPanel = new JPanel();
		descriptionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		descriptionLabel = new JLabel("Description");		
		descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		descriptionPanel.add(descriptionLabel);
		
		descriptionField = new JTextField(20);
		descriptionField.setText(gift.getDescription());
		descriptionField.setAlignmentX(Component.CENTER_ALIGNMENT);
		descriptionPanel.add(descriptionField);
		
		descriptionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(descriptionPanel);
		
		
		
		
		
		urlPanel = new JPanel();
		urlPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		urlLabel = new JLabel("URL");		
		urlLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		urlPanel.add(urlLabel);
		
		urlField = new JTextField(20);
		urlField.setText(gift.getURL());
		urlField.setAlignmentX(Component.CENTER_ALIGNMENT);
		urlPanel.add(urlField);
		
		urlPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(urlPanel);
		
		
		
		submitButton = new JButton("Confirm");
		submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(submitButton);
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				editGift();
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelEditGift();
            }
        });
		
		deleteButton = new JButton("Delete " + this.gift.getName());
		deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteGift1();
			}
		});
		
		deleteConfirmButton = new JButton(String.format("Really Delete %s?", this.gift.getName()));
		deleteConfirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		deleteConfirmButton.setVisible(false);
		this.add(deleteConfirmButton);
		deleteConfirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteGift2();
			}
		});
	}
	
	
	private void cancelEditGift() {
		this.frame.replaceView(new GiftProfilePanel(this.gift, this.frame));
	}
	

	private void editGift() {
		
		String name = this.nameField.getText();
		
		if (name.equals("")) {
			this.errorLabel.setText("Please enter a name.");
			this.errorLabel.setVisible(true);
			return;
		}
		
		String description = this.descriptionField.getText();
		
		if (description.equals("")) {
			this.errorLabel.setText("Please enter a Description.");
			this.errorLabel.setVisible(true);
			return;
		}
		
		String url = this.urlField.getText();
		
		
		this.gift.setName(name);
		this.gift.setDescription(description);
		this.gift.setURL(url);
		

		this.frame.replaceView(new GiftProfilePanel(this.gift, this.frame));
	}
	
	
	

	private void deleteGift1() {
		this.deleteButton.setVisible(false);
		this.deleteConfirmButton.setVisible(true);
	}
	
	private void deleteGift2() {
		Occasion occasion = this.gift.getOccasion();
		
		occasion.removeGift(this.gift);
		this.frame.replaceView(new GiftsListPanel(occasion, this.frame));
	}
}
