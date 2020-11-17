package utils;
import java.util.Scanner;

public class input {
	
	/**
	 * Gets input string from user.
	 * Casts input to int.
	 * @return int - User input
	 */
	public static int inputInt() {
		Scanner in = new Scanner(System.in);
		
		int num;
		String input;
		
		while (true) {
			
			System.out.print(">>> ");
			
			input = in.nextLine();
			
			try {
				num = Integer.parseInt(input);
				return num;
			}
			catch (NumberFormatException e){
				System.out.println("Invalid Input");
			}
		}
		
	}
	
	
	/**
	 * Gets input String from user.
	 * @return String - User input
	 */
	public static String input() {
		Scanner in = new Scanner(System.in);
		System.out.print(">>> ");
		return in.nextLine();
	}
	
}
