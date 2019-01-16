import Components.Engine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EngineTest {

    private Engine engine;

    @Before
    public void setUp() {
        engine = new Engine("Dyson", "SuperBlast 3000", 1.8);
    }

    @Test
    public void hasMake() {
        assertEquals("Dyson", engine.getMake());
    }

    @Test
    public void hasModel() {
        assertEquals("SuperBlast 3000", engine.getModel());
    }

    @Test
    public void hasCapacityInLitre() {
        assertEquals(1.8, engine.getCapacity(), 0.01);
    }


}
