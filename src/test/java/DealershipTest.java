import Cars.DieselCar;
import Components.Component;
import Components.Engine;
import Components.MaterialType;
import Components.Seat;
import Entities.Customer;
import Entities.Dealership;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DealershipTest {


    private Customer customer;
    private DieselCar cheapCar;
    private DieselCar priceyCar;
    private Engine engine1;
    private Seat seat1;
    private Engine engine2;
    private Seat seat2;
    private DieselCar sillyCar;
    private ArrayList<Component> cheapBits;
    private ArrayList<Component> niceBits;
    private Dealership dealership;


    @Before
    public void setUp() {
        this.customer = new Customer("Fella", 50_000.0);

        engine1 = new Engine("Dyson", "Blast", 1.8);
        engine2 = new Engine("Dyson", "Frozen", 3.0);
        seat1 = new Seat("DFS", "Crap", MaterialType.PLEATHER);
        seat2 = new Seat("Ray's Palace", "Gorg", MaterialType.LEATHER);
        cheapBits = new ArrayList<>();
        niceBits = new ArrayList<>();
        cheapBits.add(engine1);
        cheapBits.add(seat1);
        niceBits.add(engine2);
        niceBits.add(seat2);

        cheapCar = new DieselCar("Yellow", 20_000.0, 120, cheapBits, 30);
        priceyCar = new DieselCar("Black", 60_000.0, 180, niceBits, 50);
        sillyCar = new DieselCar("Black", 500_000.0, 180, niceBits, 50);

        dealership = new Dealership("Ray's Racers", 200_000.0);
    }

    @Test
    public void hasName() {
        assertEquals("Ray's Racers", dealership.getName());
    }

    @Test
    public void hasCapital() {
        assertEquals(200_000.0, dealership.getCapital(), 0.001);
    }

    @Test
    public void startsWithNoCars() {
        assertEquals(0, dealership.getCars().size());
    }

    @Test
    public void canBuyCar() {
        dealership.buyCar(priceyCar);
        assertEquals(priceyCar, dealership.getCars().get(0));
    }

    @Test
    public void cantBuyUnaffordableCar() {
        dealership.buyCar(sillyCar);
        assertEquals(0, dealership.getCars().size());
    }

    @Test
    public void canRepairCar() {
        dealership.buyCar(priceyCar);
        priceyCar.damage(10_000.0);
        assertEquals(49_000.0, dealership.getCars().get(0).getPrice(), 0.001);
        dealership.repairCar(priceyCar);
        assertEquals(130_000.0, dealership.getCapital(), 0.001);
        assertEquals(60_000.0, dealership.getCars().get(0).getPrice(), 0.001);

    }

    @Test
    public void canSellToCustomer() {
        dealership.buyCar(cheapCar);
        dealership.sellCar(cheapCar, customer);
        assertEquals(0, dealership.getCars().size());
        assertEquals(1, customer.getCars().size());

    }
}
