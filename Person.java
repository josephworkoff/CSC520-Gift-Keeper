import java.util.ArrayList;

public class Person {
    private String name;
    private String password;
    
    private ArrayList<Person> friends;
    private ArrayList<Occasion> occasions;

    public Person(){
        this.name = null;
        this.password = null;
        this.friends = null;
        this.occasions = null;
    }

    public Person(String name, String password){
        this.name = name;
        this.password = password;
        this.friends = new ArrayList<Person>();
        this.occasions = new ArrayList<Occasion>();
    }


    public String getName()                  {return this.name;}
    public String getPassword()              {return this.password;}
    public ArrayList<Person> getFriends()    {return this.friends;}
    public ArrayList<Occasion> getOccasions(){return this.occasions;}

    public void setName(String name)         {this.name = name;}
    public void setPassword(String password) {this.password = password;}

    public void addFriend(Person friend) {
        if (!this.friends.contains(friend))
            this.friends.add(friend);
    }

    public void removeFriend(Person friend) {
        if (this.friends.contains(friend))
            this.friends.remove(friend);
    }

    public void addOccasion(Occasion occasion){
        this.occasions.add(occasion);
    }

    public void removeOccasion(Occasion occasion){
        this.occasions.remove(occasion);
    }

    public void login(){
        return;
    }

    public void logout(){
        return;
    }


}