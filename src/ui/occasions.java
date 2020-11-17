package ui;

import model.Friend;
import model.Occasion;
import utils.input;
import utils.util;

public class occasions {

	/**
	 * Adds a new Occasion to the Friend
	 * @param friend
	 */
	public static void createOccasionMenu(Friend friend) {
		String name;
		int month;
		int day;
		int hour;
		int minute;
		
		System.out.println("Add a new Occasion:");
		
		System.out.println("Enter Occasion Name:");
		name = input.input();
		
		//Month
		while(true) {
			System.out.println("");
			System.out.println("Enter Occasion Month (1 - 12):");
			month = input.inputInt();
			if (month > 12 || month < 1) {
				System.out.println("Invalid Selection.");
				continue;
			}
			break;
		}
		
		int maxDay = util.daysInMonth(month);
		
		//Day
		while(true) {
			System.out.println("");
			System.out.println(String.format("Enter Occasion Day (1 - %d):", maxDay));
			day = input.inputInt();
			if (day > maxDay || day < 1) {
				System.out.println("Invalid Selection.");
				continue;
			}
			break;
		}
		
		//Hour
		while(true) {
			System.out.println("");
			System.out.println("Enter Occasion Hour (0 - 23):");
			hour = input.inputInt();
			if (hour > 23 || hour < 0) {
				System.out.println("Invalid Selection.");
				continue;
			}
			break;
		}
		
		//Minute
		while(true) {
			System.out.println("");
			System.out.println("Enter Occasion Minute:");
			minute = input.inputInt();
			if (minute > 59 || minute < 0) {
				System.out.println("Invalid Selection.");
				continue;
			}
			break;
		}
		
		
		//Set Reminder for 7 days prior, at noon.
		int alertMonth;
		int alertDay;
		if (day < 7) {
			//Occasion is less than 7 days into the month.
			//Set month to the month prior
			if (month > 1) {
				//If January, alert month is December
				alertMonth = month - 1;
			}
			else {
				alertMonth = 12;
			}
			
			alertDay = util.daysInMonth(alertMonth) - (7 - day);
			
		}
		else {
			alertMonth = month;
			alertDay = day - 7;
		}
		
		int alertHour = 12;
		int alertMinute = 00;
		
		Occasion occasion = new Occasion(name, friend, month, day, hour, month, alertMonth, alertDay, alertHour, alertMinute);
		friend.addOccasion(occasion);
		
		System.out.println("");
		System.out.println("New Occasion Created.");
		System.out.println(occasion.getOccasion());
		System.out.println("You will be reminded of this occasion at " + occasion.getAlertTime());
		
	}
	
	
	/**
	 * Deletes an Occasion from its Friend
	 * @param occasion
	 */
	private static void deleteOccasion(Occasion occasion) {
		System.out.println("Are you sure you want to delete this Occasion?");
		System.out.println(occasion.getOccasion());
		
		System.out.println("Yes/No");
		String choice = input.input();
		
		if (choice.equalsIgnoreCase("yes")) {
			occasion.getFriend().removeOccasion(occasion);
			occasion.setFriend(null);
			
			System.out.println("Occasion Deleted.");
		}
		else {
			System.out.println("Canceled.");
		}
		
	}
	
	
	/**
	 * Edits an occasion's event month or alert month
	 * @param occasion
	 * @param alert - True if editing the alert time, false if occasion time.
	 */
	private static void changeMonth(Occasion occasion, boolean alert) {
		int in = 0;
		
		String str = (alert) ? "Occasion" : "Alert";
		String time = (alert) ? occasion.getAlertTime() : occasion.getTime();
				
		
		while (true) {
			System.out.println("");
			System.out.println( String.format("Editing %s Month (%s):", str, time) ) ;
			System.out.println("Enter new Month (1 - 12), or 0 to cancel:");
			in = input.inputInt();
						
			if (in == 0) {
				return;
			}
			else if (in > 12 || in < 0){
				System.out.println("Invalid Selection");
			}
			else {
				if (alert) {
					occasion.setAlertMonth(in);
					in = occasion.getAlertMonth();
				}
				else {
					occasion.setMonth(in);
					in = occasion.getMonth();
					
				}
				System.out.println(String.format("%s Month set to %d", str, in));
				return;
			}
		}
	}
	
	
	/**
	 * Edits an occasion's event day or alert day
	 * @param occasion
	 * @param alert - True if editing the alert time, false if occasion time.
	 */
	private static void changeDay(Occasion occasion, boolean alert) {
		int in = 0;
		
		String str = (alert) ? "Occasion" : "Alert";
		String time = (alert) ? occasion.getAlertTime() : occasion.getTime();
				
		
		int dayMax = util.daysInMonth(occasion.getMonth());
		
		while (true) {
			System.out.println("");
			System.out.println( String.format("Editing %s Day (%s) :", str, time) ) ;
			System.out.println(String.format("Enter new Day (1 - %d), or 0 to cancel:", dayMax));
			in = input.inputInt();
						
			if (in == 0) {
				return;
			}
			else if (in > dayMax || in < 1){
				System.out.println("Invalid Selection");
			}
			else {
				if (alert) {
					occasion.setAlertDay(in);
					in = occasion.getAlertDay();
				}
				else {
					occasion.setDay(in);
					in = occasion.getDay();
					
				}
				System.out.println(String.format("%s Day set to %d", str, in));
				return;
			}
		}
	}
	
	
	/**
	 * Edits an occasion's event hour or alert hour
	 * @param occasion
	 * @param alert - True if editing the alert time, false if occasion time.
	 */
	private static void changeHour(Occasion occasion, boolean alert) {
		int in = 0;
		
		String str = (alert) ? "Occasion" : "Alert";
		
		String time = (alert) ? occasion.getAlertTime() : occasion.getTime();
				
		
		while (true) {
			System.out.println("");
			System.out.println( String.format("Editing %s Hour (%s):", str, time) ) ;
			System.out.println("Enter new Month (0 - 23), or 24 to cancel:");
			in = input.inputInt();
						
			if (in == 24) {
				return;
			}
			else if (in > 23 || in < 0){
				System.out.println("Invalid Selection");
			}
			else {
				if (alert) {
					occasion.setAlertHour(in);
					in = occasion.getAlertHour();
				}
				else {
					occasion.setHour(in);
					in = occasion.getHour();
					
				}
				System.out.println(String.format("%s Hour set to %d", str, in));
				return;
			}
		}
	}
	
	
	/**
	 * Edits an occasion's event minute or alert minute
	 * @param occasion
	 * @param alert - True if editing the alert time, false if occasion time.
	 */
	private static void changeMinute(Occasion occasion, boolean alert) {
		int in = 0;
		
		String str = (alert) ? "Occasion" : "Alert";
		String time = (alert) ? occasion.getAlertTime() : occasion.getTime();
				
		System.out.println( String.format("Editing %s Minute (%s):", str, time) ) ;
		
		while (true) {
			System.out.println("");
			System.out.println("Enter new Minute (0 - 59), or 60 to cancel:");
			in = input.inputInt();
						
			if (in == 60) {
				return;
			}
			else if (in > 59 || in < 0){
				System.out.println("Invalid Selection");
			}
			else {
				if (alert) {
					occasion.setAlertMinute(in);
					in = occasion.getAlertMinute();
				}
				else {
					occasion.setMinute(in);
					in = occasion.getMinute();
					
				}
				System.out.println(String.format("%s Minute set to %d", str, in));
				return;
			}
		}
	}
	
	
	/**
	 * Displays options for editing an occasion's event time or alert time.
	 * @param occasion
	 * @param alert - True if editing the alert time, false if occasion time.
	 */
	private static void editOccasionTimeMenu(Occasion occasion, boolean alert) {
				
		String str = (alert) ? "Alert" : "Occasion";
		String time = (alert) ? occasion.getAlertTime() : occasion.getTime();
		
		int in;
		
		//Hour loop
		while (true) {
			System.out.println("");
			System.out.println(String.format("Editing %s Time (%s):", str, time));
			System.out.println("0: Cancel");
			System.out.println("1: Edit Month");
			System.out.println("2: Edit Day");
			System.out.println("3: Edit Hour");
			System.out.println("4: Edit Minute");
			
			in = input.inputInt();
						
			switch (in) {
				case 0:
					return;
				case 1: 
					changeMonth(occasion, alert);
					break;
				case 2: 
					changeDay(occasion, alert);
					break;
				case 3: 
					changeHour(occasion, alert);
					break;
				case 4: 
					changeMinute(occasion, alert);
					break;
			default:
				System.out.println("Invalid Selection");
				break;
			}
		}		
	}
	
	
	/**
	 * Edits an occasion's name
	 * @param occasion
	 */
	private static void editOccasionName(Occasion occasion) {
		System.out.println("Enter new name, or 'cancel'");
		
		String in = input.input();
		
		if (in.equalsIgnoreCase("cancel")) {
			System.out.println("Name unchanged.");
			return;
		}
		else {
			occasion.setName(in);
			System.out.println("Renamed to " + occasion.getName());
		}
	}
	
	
	
	/**
	 * Displays options for editing a single occasion
	 * @param occasion
	 */
	private static void editOccasionMenu(Occasion occasion) {
		
		int choice;
		
		while(true) {
			
			System.out.println("");
			System.out.println("0: Cancel Edit");
			System.out.println("1: Edit Name");
			System.out.println("2: Edit Occasion Time");
			System.out.println("3: Edit Alert Time");
			System.out.println("4: Delete this Occasion");
			
			choice = input.inputInt();
			
			switch (choice) {
				
				case 0:
					return;
				case 1:
					editOccasionName(occasion);
					break;
				case 2:
					editOccasionTimeMenu(occasion, false);
					break;
				case 3:
					editOccasionTimeMenu(occasion, true);
					break;
				case 4:
					deleteOccasion(occasion);
					return;
			
				default:
					System.out.println("Invalid Selection");
			}
			
		}
		
	}
	
	/**
	 * Displays information and options about a single occasion
	 * @param occasion
	 */
	public static void occasionProfile(Occasion occasion) {
		
		
		int choice;
		while(true) {
			System.out.println("");
			System.out.println(occasion.getName());
			System.out.println(String.format("Occurs: %s", occasion.getTime()));
			
			System.out.println("");
			System.out.println("0: Return to Friend");
			System.out.println("1: Edit this occasion");
			System.out.println("2: View your gifts for this occasion");
			System.out.println("3: Delete this occasion");
			choice = input.inputInt();
			
			switch (choice) {
				
				case 0:
					return;
				case 1:
					editOccasionMenu(occasion);
					break;
				case 2:
					gifts.giftMenu(occasion);
					break;
				case 3:
					deleteOccasion(occasion);
					break;
			
			default:
				System.out.println("Invalid Selection");
			
			}
			
		}
		
	}
	
}
