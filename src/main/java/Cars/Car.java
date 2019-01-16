package Cars;

import Components.Component;
import Components.Seat;

import java.util.ArrayList;

public abstract class Car {

    private String colour;
    private double price;
    private int topSpeed;
    private int seats;
    private double damage;
    private ArrayList<Component> components;

    public Car(String colour, double price, int topSpeed, ArrayList<Component> components) {
        this.colour = colour;
        this.price = price;
        this.topSpeed = topSpeed;
        this.components = components;
        this.seats = this.countSeats();
    }

    public String getColour() {
        return colour;
    }

    public double getPrice() {
        return price;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getSeats() {
        return seats;
    }

    public double getDamage() {
        return damage;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public int countSeats(){
        int result = 0;
        for (Component comp : this.components){
            if (comp instanceof Seat){
                result += 1;
            }
        }
        return result;
    }

    public void damage(double amount){
        this.damage += amount;
        this.price -= amount * 1.1;
    }

    public double repair(){
        double cost = this.damage;
        this.damage = 0;
        this.price += cost * 1.1;
        return cost;
    }
}
