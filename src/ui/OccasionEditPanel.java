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
import utils.util;

public class OccasionEditPanel extends JPanel{

	Occasion occasion;
	mainFrame frame;
	
	JLabel label;
	JLabel errorLabel;
	JLabel nameLabel;
	JLabel monthLabel;
	JLabel dayLabel;
	JLabel hourLabel;
	JLabel minuteLabel;
	JButton cancelButton;
	JButton submitButton;
	JButton deleteButton;
	JButton deleteConfirmButton;
	JTextField nameField;
	JTextField monthField;
	JTextField dayField;
	JTextField hourField;
	JTextField minuteField;
	
	JPanel namePanel;
	JPanel timePanel;

	
	public OccasionEditPanel(Occasion occasion, mainFrame MF) {
		super();
		
		this.occasion = occasion;
		this.frame = MF;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		label = new JLabel("Editing " + occasion.getName());		
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
		nameField.setText(this.occasion.getName());
		nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
		namePanel.add(nameField);
		
		namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(namePanel);
		
		
		
		
		timePanel = new JPanel();
		timePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		monthLabel = new JLabel("Month");		
		monthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(monthLabel);
		
		monthField = new JTextField(2);
		monthField.setText(Integer.toString(this.occasion.getMonth()));
		monthField.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(monthField);
		
		dayLabel = new JLabel("Day");		
		dayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(dayLabel);
		
		dayField = new JTextField(2);
		dayField.setText(Integer.toString(this.occasion.getDay()));
		dayField.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(dayField);
		
		hourLabel = new JLabel("Hour");		
		hourLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(hourLabel);
		
		hourField = new JTextField(2);
		hourField.setText(Integer.toString(this.occasion.getHour()));
		hourField.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(hourField);
		
		minuteLabel = new JLabel("Minute");		
		minuteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(minuteLabel);
		
		minuteField = new JTextField(2);
		minuteField.setText(Integer.toString(this.occasion.getMinute()));
		minuteField.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(minuteField);
		
		timePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(timePanel);
		
		
		
		
		submitButton = new JButton("Confirm");
		submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(submitButton);
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				editOccasion();
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelEditOccasion();
            }
        });
		
		deleteButton = new JButton("Delete " + this.occasion.getName());
		deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteOccasion1();
			}
		});
		
		deleteConfirmButton = new JButton(String.format("Really Delete %s?", this.occasion.getName()));
		deleteConfirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		deleteConfirmButton.setVisible(false);
		this.add(deleteConfirmButton);
		deleteConfirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteOccasion2();
			}
		});
		
	}
	
	
	private void cancelEditOccasion() {
		this.frame.replaceView(new OccasionProfilePanel(this.occasion, this.frame));
	}
	
	
	private void editOccasion() {
		
		String name = this.nameField.getText();
		
		if (name.equals("")) {
			this.errorLabel.setText("Please enter a name.");
			this.errorLabel.setVisible(true);
			return;
		}
		
		int month = util.castStringToInt(this.monthField.getText());
		
		if (month < 1 || month > 12) {
			this.monthField.setText("");
			this.errorLabel.setText("Invalid month");
			this.errorLabel.setVisible(true);
			return;
		}
		
		int day = util.castStringToInt(this.dayField.getText());
		
		if (day < 1 || day > util.daysInMonth(month)) {
			this.dayField.setText("");
			this.errorLabel.setText("Invalid day");
			this.errorLabel.setVisible(true);
			return;
		}
		
		int hour = util.castStringToInt(this.hourField.getText());
		
		if (hour < 0 || hour > 23) {
			this.hourField.setText("");
			this.errorLabel.setText("Invalid hour");
			this.errorLabel.setVisible(true);
			return;
		}
		
		int minute = util.castStringToInt(this.minuteField.getText());
		
		if (minute < 0 || minute > 59) {
			this.minuteField.setText("");
			this.errorLabel.setText("Invalid minute");
			this.errorLabel.setVisible(true);
			return;
		}
		
		
		this.occasion.setName(name);
		this.occasion.setMonth(month);
		this.occasion.setDay(day);
		this.occasion.setHour(hour);
		this.occasion.setMinute(minute);
				
		this.frame.replaceView(new OccasionProfilePanel(this.occasion, this.frame));
	}
	
	
	private void deleteOccasion1() {
		this.deleteButton.setVisible(false);
		this.deleteConfirmButton.setVisible(true);
	}
	
	private void deleteOccasion2() {
		Friend friend = this.occasion.getFriend();
		
		friend.removeOccasion(this.occasion);
		this.frame.replaceView(new OccasionsListPanel(friend, this.frame));
	}
	
	
}
