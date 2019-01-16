import Cars.DieselCar;
import Components.Component;
import Components.Engine;
import Components.MaterialType;
import Components.Seat;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DieselCarTest {

    DieselCar dieselCar;
    Engine engine;
    Seat seat1;
    Seat seat2;
    Seat seat3;
    ArrayList<Component> componentList;

    @Before
    public void before() {
        seat1 = new Seat("DFS", "Comfy", MaterialType.PLEATHER);
        seat2 = new Seat("DFS", "Comfy", MaterialType.PLEATHER);
        seat3 = new Seat("DFS", "Comfy", MaterialType.PLEATHER);
        engine = new Engine("Dyson", "SuperBlast 3000", 2.0);
        componentList = new ArrayList<>();
        componentList.add(seat1);
        componentList.add(seat2);
        componentList.add(seat3);
        componentList.add(engine);
        dieselCar = new DieselCar("Lellow", 30000.0, 150, componentList, 40);
    }

    @Test
    public void hasColour() {
        assertEquals("Lellow", dieselCar.getColour());
    }

    @Test
    public void hasPrice() {
        assertEquals(30000.0, dieselCar.getPrice(), 0.001);
    }

    @Test
    public void hasTopSpeed() {
        assertEquals(150, dieselCar.getTopSpeed());
    }

    @Test
    public void hasSeats() {
        assertEquals(3, dieselCar.getSeats());
    }

    @Test
    public void hasNoDamage() {
        assertEquals(0, dieselCar.getDamage(), 0.001);
    }

    @Test
    public void hasComponents() {
        assertEquals(componentList, dieselCar.getComponents());
    }

    @Test
    public void hasMPG() {
        assertEquals(40, dieselCar.getMilesPerGallon());
    }

    @Test
    public void canBeDamaged() {
        dieselCar.damage(5000.0);
        assertEquals(5000.0, dieselCar.getDamage(), 0.001);
        assertEquals(24500.0, dieselCar.getPrice(), 0.001);
    }

    @Test
    public void canBeRepaired() {
        dieselCar.damage(5000.0);
        assertEquals(5000.0, dieselCar.getDamage(), 0.001);
        assertEquals(24500.0, dieselCar.getPrice(), 0.001);
        dieselCar.repair();
        assertEquals(0.0, dieselCar.getDamage(), 0.001);
        assertEquals(30000.0, dieselCar.getPrice(), 0.001);
    }
}
