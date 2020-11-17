package model;

import java.util.ArrayList;

public class Friend {

	private String name;
	private Person user;
    private ArrayList<Occasion> occasions;
    
    
    public Friend() {
    	this.name = "";
    	this.user = null;
    	
    	this.occasions = new ArrayList<Occasion>();
    }
    
    public Friend(String name, Person user) {
    	this.name = name;
    	this.user = user;
    	
    	this.occasions = new ArrayList<Occasion>();
    }

    public void setName(String name){this.name = name;}
    public void setPerson(Person user){this.user = user;}
    public void setOccasions(ArrayList<Occasion> occasions){this.occasions = occasions;}

    public String getName(){return this.name;}
    public Person getPerson(){return this.user;}
    public ArrayList<Occasion> getOccasions(){return this.occasions;}

    
    public void addOccasion(Occasion occasion){
        this.occasions.add(occasion);
    }

    public void removeOccasion(Occasion occasion){
        this.occasions.remove(occasion);
    }


	
}
