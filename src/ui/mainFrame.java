package ui;

import javax.swing.*;
import main.Main;
import utils.*;
import model.Person;

public class mainFrame extends JFrame{


	private static final long serialVersionUID = -7789507607773718567L;
	
	JLabel label;
	JButton friendsList;
	
	Person user;
	
	JPanel activeView;
	
	
	public mainFrame(Person user) {
		super("Gift Keeper");
		
		this.user = user;
	
		this.activeView = new JPanel();
		add(activeView);		
	    replaceView(new MainMenuPanel(this.user, this));

	}
	
	
	public void replaceView(JPanel view) {
		remove(this.activeView);
		this.activeView = view;
		this.activeView.setSize(Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
		this.activeView.setVisible(true);
		
		add(this.activeView);
	
		this.repaint();
		this.revalidate();	
		
	}
	
	public void friendsList() {
		this.add(new FriendsListPanel(this.user, this));
	}
	
	
	public static void mainMenu(Person user) {
				
		System.out.println("Gift Keeper: ");
		
		boolean exit = false;
		int choice = 0;
		String in = "";
		
		while (!exit) {
			System.out.println("1 - View Your Friends.");
			//System.out.println("[2] - View Your Profile.");
			
			choice = input.inputInt();
			
			switch (choice){
				case 1:
					FriendsMenu.friendsmenu(user);
					break;
				//case 2:
					//Profile.profileMenu(user);
					
					//break;
					
			default:
				System.out.println("Invalid Input");
				break;
				
			}
		}
	}
	
}
