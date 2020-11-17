package model;

import java.util.ArrayList;

public class Occasion {
	private String name;
	private Friend friend;
	
    private int month;  
    private int day;
    private int hour;
    private int minute;
    
    private int alertMonth;
    private int alertDay;
    private int alertHour;
    private int alertMinute;
    
    private ArrayList<Gift> gifts;
    
    public Occasion(String name, Friend friend, int month, int day, int hour, int minute, int alertMonth, int alertDay, int alertHour, int alertMinute){
    	this.name           = name;
    	this.friend 		= friend;
    	
    	this.month          = month;
        this.day            = day;
        this.hour 			= hour;
        this.minute 		= hour;
        
    	this.alertMonth     = alertMonth;
        this.alertDay       = alertDay;
        this.alertMinute    = alertMinute;
        
        this.gifts          = new ArrayList<Gift>();        
    }
    
    public String getName(){						return this.name;}
    public Friend getFriend() {						return this.friend;}
    public int getMonth(){							return this.month;}
    public int getDay(){							return this.day;}
    public int getHour(){							return this.hour;}
    public int getMinute(){							return this.minute;}
    public int getAlertMonth(){						return this.alertMonth;}
    public int getAlertDay(){						return this.alertDay;}
    public int getAlertHour(){						return this.alertHour;}
    public int getAlertMinute(){					return this.alertMinute;}
   
    public ArrayList<Gift> getGifts(){				return this.gifts;}
    
    public void setName(String name){				this.name = name;}
    public void setFriend(Friend friend){			this.friend = friend;}
    public void setMonth(int month){				this.month = month;}
    public void setDay(int day){					this.day = day;}
    public void setHour(int hour){					this.hour = hour;}
    public void setMinute(int minute){				this.minute = minute;}
    public void setAlertMonth(int month){			this.alertMonth = month;}
    public void setAlertDay(int day){				this.alertDay = day;}
    public void setAlertHour(int hour){				this.alertHour = hour;}
    public void setAlertMinute(int minute){			this.alertMinute = minute;}
    
    public void setGifts(ArrayList<Gift> gifts){	this.gifts = gifts;}
    
    public String getOccasion() {
        return String.format("%s: %s", this.name, this.getAlertTime());
    }    
    
    
    public String getTime() {
    	return String.format("%02d/%02d %02d:%02d", this.month, this.day, this.hour, this.minute);
    }    
    
    public String getAlertTime() {
    	return String.format("%02d/%02d %02d:%02d", this.alertMonth, this.alertDay, this.alertHour, this.alertMinute);
    }    

    
    public void addGift(Gift gift){
    	
    	if (this.gifts == null) {
    		this.gifts = new ArrayList<Gift>();
    	}
    	
        if ( !(this.gifts.contains(gift) ) ){
            this.gifts.add(gift);
        }
    }

    public void removeGift(Gift gift){
        if ( this.gifts.contains(gift) ){
            this.gifts.remove(gift);
        }
    }



}
