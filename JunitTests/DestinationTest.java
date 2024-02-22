import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class DestinationTest {
    private Destination destination;
    private Activity activity;

    @BeforeEach
    public void setUp() {
        destination = new Destination("pune");
        activity = new Activity("sleeping", 999, 101);
    }

    @Test
    public void testGetName() {
        destination.setName("Mountain");
        Assertions.assertEquals("Mountain", destination.getName());
    }

    @Test
    public void testSetName() {
        destination.setName("Mountain");
        Assertions.assertEquals("Mountain", destination.getName());
    }

    @Test
    public void testGetActivities() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Sleeping", 100, 10));
        destination.setActivities(activities);
        Assertions.assertEquals(1, destination.getActivities().size());
    }

    @Test
    public void testSetActivities() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Sleeping", 100, 90));
        destination.setActivities(activities);
        Assertions.assertEquals(1, destination.getActivities().size());
    }

    @Test
    public void testAddActivity() {
        destination.addActivity(activity);
        Assertions.assertTrue(destination.getActivities().contains(activity));
    }
}
