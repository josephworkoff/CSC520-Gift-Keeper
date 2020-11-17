package ui;

import model.Person;

public class login {



	public static void loginMenu() {
		
		System.out.println("Enter your username, or 'cancel' : ");

		String in;

		while (true){
			in = input.input();

			if (in.toLowerCase() == 'cancel'){
				return;
			}
			else if ( !( db.lookup(in) ) ){
				System.out.println("User does not exist.");
			}
			else{
				System.out.println("Logged in as " + in);
			}

		}
		

	}

	public static void createAccountMenu() {
		
	}




	public static void accountMenu() {
		int choice;
		
		while (true){
	
			System.out.println("0: Login");
			System.out.println("1: Create Account");
	
			choice = input.inputInt();
	
			switch (choice) {
				case 0:
					loginMenu();
					return;
				case 1:
					createAccountMenu();
					break;
			
				default:
					System.out.println("Invalid Choice");
					break;
			}
	
		}
	}
}
