package ui;

import java.util.ArrayList;


import model.*;
import utils.*;


import java.awt.*;
import javax.swing.*;

import main.Main;

import java.awt.event.*;

public class FriendsMenu{

	
	
	/**
	 * Removes a friend from a user's list.
	 * @param friend
	 * @return True if successfully removed, otherwise false.
	 */
	private static boolean deleteFriend(Friend friend) {
		System.out.println("");
		System.out.println(String.format("Are you sure you want to delete %s?", friend.getName()));
		
		System.out.println("Yes/No");
		String choice = input.input();
		
		if (choice.equalsIgnoreCase("yes")) {
			friend.getPerson().removeFriend(friend);
			friend.setPerson(null);
			
			System.out.println(friend.getName() + " Deleted.");
			return true;
		}
		else {
			System.out.println("Canceled.");
			return false;
		}
		
	}
	
	
	/**
	 * Adds a Friend to the user's list
	 * @param user
	 */
	private static void addFriend(Person user) {
		
		System.out.println("");
		System.out.println("Adding a new Friend:");
		System.out.println("Enter Friend's Name:");
		
		String name = input.input();
		
		Friend friend = new Friend(name, user);
		user.addFriend(friend);
		
		System.out.println("Added " + name);
		
		friendProfile(friend);
	}
	
	

	/**
	 * Displays information about a Friend.
	 * @param friend
	 */
	private static void friendProfile(Friend friend) {
		System.out.println("Name:" + friend.getName());

		ArrayList<Occasion> occasions = friend.getOccasions();
		int occCount = occasions.size();
		
		int i;
		
		
		while (true) {
			System.out.println("");
			if (occasions == null || occCount == 0) {
				System.out.println(friend.getName() + " has no occasions listed.");
			}
			else {
				i = 1;
				//Display friend's occasions
				for (Occasion o: occasions){
					System.out.println(String.format("%d: %s", i, o.getOccasion() ));
					i++;
				}
			}
			
			//User options
			//Return
			System.out.println("0 - Return to Friends List");
			
			//View friend profile
			if (occCount != 0) {
				System.out.println(String.format("1 - %d: View Occasion", occasions.size() ) );
			}
			
			//Add new
			System.out.println(String.format("%d: Add new Occasion", occCount + 1 ) );
			
			//Delete friend
			System.out.println(String.format("%d: Delete %s", occCount + 2, friend.getName() ) );
			
			//Get input
			i = input.inputInt();

			//User Options
			
			//Exit
			if (i == 0){
				return;
			}
			
			//View occasion
			else if (i >= 1 && i <= occCount ){
				
				//Press 1 with 0 occasions
				if (occCount == 0) {
					ui.occasions.createOccasionMenu(friend);
				}
				//1 with >0 occasions
				else {
					ui.occasions.occasionProfile( occasions.get(i - 1) );
				}
			}
			
			//New Occasion for this friend
			else if (i == occasions.size() + 1) {
				ui.occasions.createOccasionMenu(friend);
			}
			
			//Delete Friend
			else if (i == occasions.size() + 2) {
				if (deleteFriend(friend)) {
					return;
				}
			}
			
			//Invalid
			else{
				System.out.println("Invalid selection");
			}		
		}
	}


	/**
	 * Lists the user's friends. 
	 * @param user
	 */
	public static void friendsmenu(Person user) {
		
		ArrayList<Friend> friends = user.getFriends();
		int friendCount = friends.size();
		int in;
		
		int i;
		
		//Input loop
		while (true) {
			System.out.println("");
			
			//No friends added
			if (friends == null || friendCount == 0) {
				System.out.println("You haven't added any Friends!");
			}
			else {
				//List all Friends
				System.out.println("Your Friends:");
				i = 1;
				for (Friend p: friends) {
					System.out.println(String.format("%d) %s", i, p.getName()));
					i++;
				}		
			}
			
			//User options
			//Return
			System.out.println("0 - Return to Main Menu");
			
			//View friend profile
			if (friendCount != 0) {
				System.out.println(String.format("1-%d - View Friend's Profile", friendCount));
			}
			
			//Add friend
			System.out.println(String.format("%d - Add new Friend", friendCount + 1));
			
			//Get input
			in = input.inputInt();
			
			//Return
			if (in == 0) {
				return;
			}
			
			//Check 1 specifically because it could be either
			else if(in == 1) {
				if (friendCount == 0) {
					addFriend(user);
				}
				else {
					friendProfile( friends.get(in - 1) );
				}
			}
			
			//Add Friend
			else if (in == friendCount + 1) {
				addFriend(user);
			}
			
			//View Profile
			else if (in > 0 && in <= friendCount) {
				friendProfile( friends.get(in - 1) );
			}
			
			//Invalid
			else {
				System.out.println("Invalid Selection");
			}
		}
	
	}
}
