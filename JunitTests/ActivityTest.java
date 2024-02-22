import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActivityTest {
    private Activity activity;


    public void setUp() {
        activity = new Activity("Filler", 100, 20);
    }

    @Test
    public void testGetName() {
        activity.setName("Mountain");
        Assertions.assertEquals("Mountain", activity.getName());
    }

    @Test
    public void testSetName() {
        activity.setName("Mountain");
        Assertions.assertEquals("Mountain", activity.getName());
    }

    @Test
    public void testGetDescription() {
        activity.setDescription("Swimming");
        Assertions.assertEquals("Swimming", activity.getDescription());
    }

    @Test
    public void testSetDescription() {
        activity.setDescription("Swimming");
        Assertions.assertEquals("Swimming", activity.getDescription());
    }

    @Test
    public void testGetPrice() {
        activity.setCost(50);
        Assertions.assertEquals(50, activity.getCost());
    }

    @Test
    public void testSetPrice() {
        activity.setCost(50);
        Assertions.assertEquals(50, activity.getCost());
    }

    @Test
    public void testGetCapacity() {
        activity.setCapacity(10);
        Assertions.assertEquals(10, activity.getCapacity());
    }

    @Test
    public void testSetCapacity() {
        activity.setCapacity(10);
        Assertions.assertEquals(10, activity.getCapacity());
    }

    @Test
    public void testGetCurrentCapacity() {
        activity.setFinalCapacity(5);
        Assertions.assertEquals(5, activity.getFinalCapacity());
    }

    @Test
    public void testSetCurrentCapacity() {
        activity.setFinalCapacity(5);
        Assertions.assertEquals(5, activity.getFinalCapacity());
    }
    @Test
    public void testisCapacityFull() {
        activity.setFinalCapacity(0);
        activity.setCapacity(5);
        Assertions.assertTrue(activity.isCapacityFull());
    }

}
