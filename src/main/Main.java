package main;

import ui.*;
import model.*;

import javax.swing.*;


public class Main {
	
	
	public static final int WINDOW_HEIGHT = 400;
	public static final int WINDOW_WIDTH = 600;
	
	

	public static void main(String[] args) {

		Person user = new Person("TestUser", "pass123");

		Friend friend;
		Occasion occasion;
		Gift gift;
		
		
		//initialize sample friends, occasions, gifts
		for (int i = 0; i < 5; i++) {
			friend = new Friend("Friend" + i, user);

			for (int j = 0; j < 5; j++){
				occasion = new Occasion("Occasion" + j, friend, 1, 1, 12, 30, 1, 1, 12, 0);

				for (int k = 0; k < 5; k++){
					gift = new Gift(occasion, "Gift" + k, "A test gift.", "www.google.com");
					
					occasion.addGift(gift);
				}

				friend.addOccasion(occasion);
			}

			user.addFriend(friend);
		}

		
		
		JFrame mainFrame = new mainFrame(user); 
		
		mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        
		//ui.mainFrame.mainMenu(user);
		
	}

}
