package model;

public class Gift {

    String name;
    String description;
    String url;
    
    Occasion occasion;

    public Gift() {
    	this.name = "";
        this.description = "";
        this.url = "";
        
        this.occasion = null;
    }

    public Gift(Occasion occasion, String name, String description, String url){
        this.name = name;
        this.description = description;
        this.url = url;
        this.occasion = occasion;
    }

    public void setName(String name){this.name = name;}
    public void setDescription(String description){this.description = description;}
    public void setURL(String url){this.url = url;}
    public void setOccasion(Occasion occasion){this.occasion = occasion;}

    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public String getURL(){return this.url;}
    public Occasion getOccasion(){return this.occasion;}



}
