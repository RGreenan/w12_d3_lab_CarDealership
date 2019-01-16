import Components.MaterialType;
import Components.Seat;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SeatTest {

    private Seat seat;

    @Before
    public void setUp() {
        this.seat = new Seat("DFS", "The Comfy One", MaterialType.LEATHER);
    }

    @Test
    public void canGetMaterialType() {
        assertEquals(MaterialType.LEATHER, seat.getMaterial());
    }
}
