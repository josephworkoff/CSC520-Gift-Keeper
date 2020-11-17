package ui;

import java.util.ArrayList;

import model.Gift;
import model.Occasion;
import utils.input;

public class gifts {
	
	
	
	
	/**
	 * Add a new gift to the passed occasion.
	 * @param occasion
	 */
	private static void addNewGift(Occasion occasion) {
		
		String name;
		String description;
		String url;
		
		System.out.println("Add a new Gift:");
		
		System.out.println("Enter Gift Name:");
		name = input.input();
		
		System.out.println("Enter Gift Description:");
		description = input.input();
		
		System.out.println("Enter Gift URL:");
		url = input.input();		
				
		Gift gift = new Gift(occasion, name, description, url);
		
		occasion.addGift(gift);
		
		System.out.println("New Gift Added.");
		System.out.println(gift.getName());
		System.out.println(gift.getDescription());
		System.out.println(gift.getURL());
		
	}
	
	
	/**
	 * Remove a specified gift.
	 * @param gift
	 */
	private static boolean deleteGift(Gift gift) {
		
		System.out.println(String.format("Are you sure you want to delete %s?", gift.getName() ));
		System.out.println("Yes/No");
		
		String in = input.input();
		
		if (in.equalsIgnoreCase("yes")) {
			gift.getOccasion().removeGift(gift);
			gift.setOccasion(null);
			
			System.out.println(String.format("%s removed.", gift.getName()));
			return true;
		}
		else {
			System.out.println("Canceled.");
			return false;
		}
		
	}
	
	
	/**
	 * Display information about a gift
	 * @param gift
	 */
	private static void giftProfile(Gift gift) {
		
		int choice;
		
		while (true) {
			System.out.println(String.format("Gift: %s", gift.getName()));
			System.out.println(gift.getDescription());
			System.out.println(gift.getURL());
			
			System.out.println("0 - Exit");
			System.out.println("1 - Remove Gift");
			
			choice = input.inputInt();
			
			switch (choice) {
			case 0:
				return;
			case 1:
				if (deleteGift(gift))
					return;
				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}
		}
	}
	
	
	/**
	 * Display information about an occasion's gift.
	 * @param occasion
	 */
	public static void giftMenu(Occasion occasion) {
		
		ArrayList<Gift> gifts;
		int giftCount;
		int i;
		int in;
		
		while (true) {
			System.out.println("Gifts for " + occasion.getName());
			
			gifts = occasion.getGifts();
			
			giftCount = (gifts == null) ? 0 : gifts.size();
			
			if (giftCount == 0) {
				System.out.println("You haven't added any gifts for " + occasion.getName());
			}
			else {
				i = 1;
				for (Gift g: gifts) {
					System.out.println(String.format("%d: %s", i, g.getName()));
					i++;
				}
			}
			
			System.out.println("0 - Return to Occasion");
			
			if (giftCount != 0) {
				System.out.println(String.format("1-%d - View Gift", giftCount));			
			}
			
			System.out.println(String.format("%d - Add new Gift", giftCount + 1));
			
			in = input.inputInt();
			
			if (in == 0) {
				return;
			}
			else if (in == giftCount + 1) {
				addNewGift(occasion);
			}
			else if (in > 0 && in <= giftCount) {
				giftProfile( gifts.get(in - 1) );
			}
			else {
				System.out.println("Invalid Selection");
			}

		}

	}
	
}
