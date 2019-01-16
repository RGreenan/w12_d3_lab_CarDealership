package Cars;

import Components.Component;

import java.util.ArrayList;

public class DieselCar extends Car {
    private int milesPerGallon;

    public DieselCar(String colour, double price, int topSpeed, ArrayList<Component> components, int mpg) {
        super(colour, price, topSpeed, components);
        this.milesPerGallon = mpg;
    }

    public int getMilesPerGallon() {
        return milesPerGallon;
    }


}