import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BoxTests {
    //Tests if new box created successfully
    @Test
    public void testCreateNewObj() {
        Box testBox1 = new Box();
        Box testBox2 = new Box();
        assertNotEquals(testBox1, testBox2);
    }
    //Test if values in object are positive
    @Test
    public void testValidBoxValues() {
        assertThrows(IllegalArgumentException.class, () -> new Box().setLength(-1));
        assertThrows(IllegalArgumentException.class, () -> new Box().setHeight(0));
        assertThrows(IllegalArgumentException.class, () -> new Box().setWidth(-1.1));
    }
    //Tests correct volume
    @Test
    public void testGetVolume() {
        Box box = new Box();
        box.setLength(2.5);
        box.setWidth(3.0);
        box.setHeight(4.0);

        double expectedVolume = 30.0;

        assertEquals(expectedVolume, box.getVolume(), 0.01);
    }
    // Tests correct surface area
    @Test
    public void testGetSurfaceArea() {
        Box box = new Box();
        box.setLength(2.5);
        box.setWidth(3.0);
        box.setHeight(4.0);

        double expectedSurfaceArea = 59.00;
        assertEquals(expectedSurfaceArea, box.getSurfaceArea(), 0.01);
    }
}