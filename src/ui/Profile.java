package ui;

import model.*;

import utils.*;

public class Profile {
	
	/**
	 * Changes the user's password.
	 * Prompts for old password, new password, and new password confirmation.
	 * @param user - Logged in user
	 */
	public static void changePassword(Person user) {
		String in;
		String newPass;
		
		System.out.println(user.getPassword());
		
		//loop until current password correctly entered or canceled.
		while (true) {
			System.out.println("Enter your old password, or 'cancel':");
			in = input.input();
			//Canceled
			if (in.toLowerCase() == "cancel") {
				System.out.println("Canceled.");
				return;
			}
			//Incorrect password
			else if (in != user.getPassword()) {
				System.out.println("Incorrect Password.");				
			}
			//Correct password, break loop
			else {
				break;
			}
		}
		

		//loop until new password entered and confirmed.
		while (true) {
			System.out.println("Enter new password, or 'cancel'");
			newPass = input.input();
			
			//Canceled
			if (newPass.toLowerCase() == "cancel") {
				System.out.println("Canceled.");
				return;
			}
			//Confirm new password
			else {
				System.out.println("Confirm new password, or 'cancel'");
				in = input.input();
				
				//Canceled
				if (in.toLowerCase() == "cancel") {
					System.out.println("Canceled.");
					return;
				}
				//Wrong pass
				else if (in != newPass) {
					System.out.println("Passwords do not match.");
				}
				//Confirmed, update
				else {
					user.setPassword(newPass);
					System.out.println("Password updated.");
				}
			}
		}	
	}
	
	
	/**
	 * Displays user's profile options.
	 * @param user - Logged in user
	 */
	public static void profileMenu(Person user) {
		
		while (true) {
			System.out.println(user.getName() + "'s Profile");
			System.out.println("0: Return to main menu");
			System.out.println("1: Change your Password");
			
			int choice = input.inputInt();
			
			switch(choice) {
				case 0:
					return;
				case 1:
					changePassword(user);
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
			
		}
		
		
	}
}
