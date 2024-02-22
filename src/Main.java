public class Main {
    public static void main(String[] args) {

        Destination destination1 = new Destination("Mumbai");
        Destination destination2 = new Destination("pune");
        Destination destination3 = new Destination("Lucknow");

        Activity activity1 = new Activity("Mountains", 90, 35);
        activity1.setDescription("Mountain climbing");
        activity1.setFinalCapacity(0);

        Activity activity2 = new Activity("Swimming", 95, 25);
        activity2.setDescription("Swimming challenge");
        activity2.setFinalCapacity(0);

        Activity activity3 = new Activity("Zoo", 105, 45);
        activity2.setDescription("Zoological park");
        activity2.setFinalCapacity(1);

        destination1.addActivity(activity1);
        destination2.addActivity(activity2);
        destination3.addActivity(activity3);

        Passenger passenger1 = new Passenger("Rahul", 1285, PassengerType.standardPasssenger, 500);
        Passenger passenger2 = new Passenger("Rohit", 3658, PassengerType.goldPassenger, 1000);
        Passenger passenger3 = new Passenger("Abhi", 1598, PassengerType.standardPasssenger, 500);

        TravelPackage travelPackage = new TravelPackage("Mountain climbing", 25);
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);
        travelPackage.addDestination(destination3);
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.addPassenger(passenger3);
        travelPackage.activitySignup(passenger1, activity1);
        travelPackage.activitySignup(passenger2, activity1);
        travelPackage.activitySignup(passenger2, activity1);
        travelPackage.activitySignup(passenger3, activity1);

        travelPackage.printItinerary();

        travelPackage.printPassengerList();

        travelPackage.printPassengerDetail(passenger1);
        travelPackage.printPassengerDetail(passenger2);
        travelPackage.printPassengerDetail(passenger3);

        travelPackage.printAllActivities();
    }
}