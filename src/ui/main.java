package ui;

import utils.*;
import model.Person;

public class main {
	
	public static void mainMenu(Person user) {
				
		System.out.println("Gift Keeper: ");
		
		boolean exit = false;
		int choice = 0;
		String in = "";
		
		while (!exit) {
			System.out.println("[1] - View Your Friends.");
			//System.out.println("[2] - View Your Profile.");
			
			choice = input.inputInt();
			
			switch (choice){
				case 1:
					Friends.friendsMenu(user);
					break;
				case 2:
					Profile.profileMenu(user);
					
					break;
					
			default:
				System.out.println("Invalid Input");
				break;
				
			}
		}
	}
	
}
