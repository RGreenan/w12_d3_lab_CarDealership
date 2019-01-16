package Entities;

import Cars.Car;

import java.util.ArrayList;

public class Customer {
    private final String name;
    private double money;
    private ArrayList<Car> cars;

    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
        this.cars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void addCar(Car newCar) {
        this.cars.add(newCar);
    }

    public boolean affordCar(Car car) {
        return this.money >= car.getPrice();
    }

    public void buyCar(Car newCar) {
        if (affordCar(newCar)) {
            this.money -= newCar.getPrice();
            addCar(newCar);
        }
    }
}
