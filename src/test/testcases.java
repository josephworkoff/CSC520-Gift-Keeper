package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Friend;
import model.Occasion;
import model.Person;
import model.Gift;

class testcases {
	
	
	@Test
	void userTest() {
		try {
			
			Person user = new Person("UserName", "Password");

			assertEquals(user.getName(), "UserName");
			assertEquals(user.getPassword(), "Password");
			
			assert(user.getFriends() != null);
			assert(user.getFriends().size() == 0);
			

		}
		catch (Exception ex) {
			fail("Failed New User Test" + ex.getMessage());			
		}
	}

	
	@Test
	void addFriendTest() {
		try {
			
			Person user = new Person("UserName", "Password");
			
			
			assert(user.getFriends() != null);
			
		
			Friend friend = new Friend();
			friend.setName("Test Friend");
			
			user.addFriend(friend);
			
			
			assertEquals(user.getFriends().size(), 1);
			assertEquals(user.getFriends().get(0), friend);
			assertEquals(user.getFriends().get(0).getName(), "Test Friend");
			
		}
		catch (Exception ex) {
			fail("Failed New Friend Test" + ex.getMessage());			
		}
	}
	
	
	@Test
	void addOccasionTest() {
		
		try {
			
			Friend friend = new Friend();
			friend.setName("Test Friend");
		
			
			Occasion occasion = new Occasion(
					"Test Occasion", friend, 1, 1, 12, 0,
					1, 1, 11, 0);
			
			friend.addOccasion(occasion);
			
			
			assertEquals(friend.getOccasions().size(), 1);
			assertEquals(friend.getOccasions().get(0), occasion);
			assertEquals(friend.getOccasions().get(0).getName(), "Test Occasion");
			assertEquals(friend.getOccasions().get(0).getFriend(), friend);
			
				
		}
		catch (Exception ex) {
			fail("Failed New Occasion Test" + ex.getMessage());			
		}
		
	}
	
	
	
	@Test
	void giftTest() {
		try {
			
			Person user = new Person("UserName", "Password");
			
			
			Friend friend = new Friend();
			friend.setName("Test Friend");
			
			user.addFriend(friend);
			
			
			Occasion occasion = new Occasion(
					"Test Occasion", friend, 1, 1, 12, 0,
					1, 1, 11, 0);
			
			friend.addOccasion(occasion);
			
			Gift gift = new Gift();
			gift.setName("Test Gift");
			gift.setDescription("This is a test gift.");
			gift.setURL("https://www.google.com");
			
			occasion.addGift(gift);
			
			assertEquals(occasion.getGifts().size(), 1);
			assertEquals(occasion.getGifts().get(0), gift);
			assertEquals(occasion.getGifts().get(0).getName(), "Test Gift");
			assertEquals(occasion.getGifts().get(0).getDescription(), "This is a test gift.");
			assertEquals(occasion.getGifts().get(0).getURL(), "https://www.google.com");
			

			
		}
		catch (Exception ex) {
			fail("Failed New Gift Test" + ex.getMessage());			
		}
	}
	

}
