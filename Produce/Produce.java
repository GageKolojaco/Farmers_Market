package Produce;
public abstract class Produce {
    private String name;
    private double unitPrice;

    public Produce(String name, double unitPrice){ //Constructor
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName(){return name;} //Getters and setters

    public double getPrice(){return unitPrice;}

    public void setPrice(double unitPrice){this.unitPrice = unitPrice;}
    
}
