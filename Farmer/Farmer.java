package Farmer;

public class Farmer {
    private String name;

    public Farmer(String name){
        this.name = name;
    }
    public String getName(){
        if (name == null){name = "No Farmer Assigned";}
        return name;}

    public void setName(String name){this.name = name;} 
}
