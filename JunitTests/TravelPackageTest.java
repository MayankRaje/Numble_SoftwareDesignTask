import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TravelPackageTest {
    private TravelPackage travelPackage;
    private Destination destination;
    private Activity activity;
    private Passenger passenger;

    @BeforeEach
    public void setUp() {
        travelPackage = new TravelPackage("Delhi", 10);
        destination = new Destination("Chennai");
        activity = new Activity("Riding", 100, 20);
        passenger = new Passenger("Rohan", 12345, PassengerType.goldPassenger, 100);
    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("Delhi", travelPackage.getName());
    }

    @Test
    public void testGetPassengerCapacity() {
        Assertions.assertEquals(10, travelPackage.getPassengerCapacity());
    }

    @Test
    public void testgetItinerary() {
        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(new Destination("Delhi"));
        travelPackage.setItinerary(itinerary);
        Assertions.assertEquals(itinerary, travelPackage.getItinerary());
    }

    @Test
    public void testsetItinerary() {
        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(new Destination("Rohan"));
        itinerary.add(new Destination("Delhi"));
        travelPackage.setItinerary(itinerary);
        Assertions.assertEquals(2, travelPackage.getItinerary().size());
    }

    @Test
    public void testgetPassengers() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("First", 1, PassengerType.goldPassenger, 100));
        for(Passenger passenger:passengers) {
            travelPackage.addPassenger(passenger);
        }
        Assertions.assertEquals(1, travelPackage.getPassengers().size());
    }

    @Test
    public void testAddDestination() {
        travelPackage.addDestination(destination);
        Assertions.assertEquals(1, travelPackage.getItinerary().size());
    }

    @Test
    public void testAddPassenger() {
        travelPackage.addPassenger(passenger);
        Assertions.assertEquals(1, travelPackage.getPassengers().size());
    }

    @Test
    public void testPrintItinerary() {
        // Add destinations and activities to the travel package
        destination.setName("Delhi");
        activity.setName("pune");
        activity.setDescription("Mountain");
        activity.setCost(70);
        activity.setCapacity(90);
        destination.getActivities().add(activity);
        travelPackage.addDestination(destination);
        travelPackage.printItinerary();
    }

    @Test
    public void testActivitySignup_Successful() {
        travelPackage.addDestination(destination);
        destination.addActivity(activity);
        travelPackage.addPassenger(passenger);
        travelPackage.activitySignup(passenger, activity);
        List<Activity> signedUpActivities = passenger.getSignedUpActivities();
        Assertions.assertTrue(signedUpActivities.contains(activity));
        Assertions.assertEquals(199, passenger.getBalance());
        Assertions.assertEquals(19, activity.getFinalCapacity());
    }



    @Test
    public void testActivitySignup_CapacityFull() {
        travelPackage.addDestination(destination);
        destination.addActivity(activity);
        Passenger passenger_temp = new Passenger("Passenger_temp", 9456, PassengerType.standardPassenger, 887878);
        for (int i = 1; i <= 15; i++) {
            Passenger passenger = new Passenger("Passenger " + i, i, PassengerType.standardPassenger, 870);
            travelPackage.addPassenger(passenger);
        }
        travelPackage.activitySignup(passenger_temp, activity);
        Assertions.assertEquals(887977, passenger_temp.getBalance());
        Assertions.assertEquals(19, activity.getFinalCapacity());
    }

}
