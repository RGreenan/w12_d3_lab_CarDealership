package Entities;

import Cars.Car;
import Cars.DieselCar;

import java.util.ArrayList;

public class Dealership {


    private final String name;
    private double capital;
    private ArrayList<Car> cars;

    public Dealership(String name, double capital) {
        this.name = name;
        this.capital = capital;
        this.cars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getCapital() {
        return capital;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void addCapital(double cash) {
        this.capital += cash;
    }

    public void loseCapital(double cash) {
        this.capital -= cash;
    }

    public void addCar(Car newCar) {
        this.cars.add(newCar);
    }

    public Car removeCar(Car car){
        int index = this.cars.indexOf(car);
        Car soldCar = this.cars.remove(index);
        return soldCar;
    }

    public boolean affordCar(Car car) {
        return this.capital >= car.getPrice();
    }

    public void buyCar(Car newCar) {
        if (affordCar(newCar)) {
            this.capital -= newCar.getPrice();
            addCar(newCar);
        }
    }

    public void repairCar(DieselCar brokenCar) {
        if (brokenCar.getDamage() <= this.capital) {
            double cost = brokenCar.repair();
            this.capital -= cost;
        }
    }

    public void sellCar(DieselCar car, Customer customer) {
        if (customer.affordCar(car)) {
            customer.buyCar(removeCar(car));
            addCapital(car.getPrice());
        }
    }
}
