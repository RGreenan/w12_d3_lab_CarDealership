import Cars.DieselCar;
import Components.Component;
import Components.Engine;
import Components.MaterialType;
import Components.Seat;
import Entities.Customer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;
    private DieselCar cheapCar;
    private DieselCar priceyCar;
    private Engine engine1;
    private Seat seat1;
    private Engine engine2;
    private Seat seat2;
    private ArrayList<Component> cheapBits;
    private ArrayList<Component> niceBits;


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
    }

    @Test
    public void hasName() {
        assertEquals("Fella", customer.getName());
    }

    @Test
    public void hasMoney() {
        assertEquals(50_000.0, customer.getMoney(), 0.001);
    }

    @Test
    public void startsWithNoCars() {
        assertEquals(0, customer.getCars().size());
    }

    @Test
    public void canBuyAffordableCar() {
        customer.buyCar(cheapCar);
        assertEquals(30_000.0, customer.getMoney(), 0.001);
        assertEquals(cheapCar, customer.getCars().get(0));
    }

    @Test
    public void cantBuyUnaffordableCar() {
        customer.buyCar(priceyCar);
        assertEquals(50_000.0, customer.getMoney(), 0.001);
        assertEquals(0, customer.getCars().size());
    }
}
