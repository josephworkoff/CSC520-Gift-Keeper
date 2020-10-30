class Occasion {

    private String name;
    private int day;
    private String month;  
    
    public Occasion(int d, String m, String n) {
        day = d;
        month = m;
        name = n;
    }
    
    public int getDay() {
        return day;
    }
    
    public String getMonth() {
       return month;
    }
    
    public String getName() {
        return name;
    }
    
    public String getOccasion() {
        String s = month + ", " + day;
        return s;
    }    

};

