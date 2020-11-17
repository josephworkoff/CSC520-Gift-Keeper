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

public class OccasionEditAlertPanel extends JPanel{

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

	
	public OccasionEditAlertPanel(Occasion occasion, mainFrame MF) {
		super();
		
		this.occasion = occasion;
		this.frame = MF;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		label = new JLabel("Setting Reminder for " + occasion.getName());		
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(label);
		
		errorLabel = new JLabel("");		
		errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(errorLabel);
		errorLabel.setVisible(false);
		
		
		
		timePanel = new JPanel();
		timePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		monthLabel = new JLabel("Month");		
		monthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(monthLabel);
		
		monthField = new JTextField(2);
		monthField.setText(Integer.toString(this.occasion.getAlertMonth()));
		monthField.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(monthField);
		
		dayLabel = new JLabel("Day");		
		dayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(dayLabel);
		
		dayField = new JTextField(2);
		dayField.setText(Integer.toString(this.occasion.getAlertDay()));
		dayField.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(dayField);
		
		hourLabel = new JLabel("Hour");		
		hourLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(hourLabel);
		
		hourField = new JTextField(2);
		hourField.setText(Integer.toString(this.occasion.getAlertHour()));
		hourField.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(hourField);
		
		minuteLabel = new JLabel("Minute");		
		minuteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		timePanel.add(minuteLabel);
		
		minuteField = new JTextField(2);
		minuteField.setText(Integer.toString(this.occasion.getAlertMinute()));
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
				editOccasionAlert();
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelEditOccasionAlert();
            }
        });
				
	}
	
	
	private void cancelEditOccasionAlert() {
		this.frame.replaceView(new OccasionProfilePanel(this.occasion, this.frame));
	}
	
	
	private void editOccasionAlert() {
				
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
		
		
		this.occasion.setAlertMonth(month);
		this.occasion.setAlertDay(day);
		this.occasion.setAlertHour(hour);
		this.occasion.setAlertMinute(minute);
				
		this.frame.replaceView(new OccasionProfilePanel(this.occasion, this.frame));
	}
	

	
	

	
}
