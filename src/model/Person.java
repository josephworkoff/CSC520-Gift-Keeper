package model;

import java.util.ArrayList;

public class Person {
	private String name;
    private String password;
    
    private ArrayList<Friend> friends;
    private ArrayList<Occasion> occasions;

    public Person(){
        this.name = null;
        this.password = null;
        this.friends = new ArrayList<Friend>();
        this.occasions = new ArrayList<Occasion>();
    }

    public Person(String name){
    	this.name = name;
    	this.password = null;
    	this.friends = new ArrayList<Friend>();
    	this.occasions = new ArrayList<Occasion>();
    }
    
    public Person(String name, String password){
        this.name = name;
        this.password = password;
        this.friends = new ArrayList<Friend>();
        this.occasions = new ArrayList<Occasion>();
    }


    public String getName()                  {return this.name;}
    public String getPassword()              {return this.password;}
    public ArrayList<Friend> getFriends()    {return this.friends;}
    public ArrayList<Occasion> getOccasions(){return this.occasions;}

    public void setName(String name)         {this.name = name;}
    public void setPassword(String password) {this.password = password;}

    public void addFriend(Friend friend) {
        if (!this.friends.contains(friend))
            this.friends.add(friend);
    }

    public void removeFriend(Friend friend) {
        if (this.friends != null && this.friends.contains(friend))
            this.friends.remove(friend);
    }

    public void login(){

        return;
    }

    public void logout(){
        return;
    }
}
