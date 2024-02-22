import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
   private String name;
   private int passengerCapacity;
   private List<Destination> itinerary;
   private List<Passenger> passengers;

   public TravelPackage(String name, int passengerCapacity) {
      this.name = name;
      this.passengerCapacity = passengerCapacity;
      this.itinerary = new ArrayList<>();
      this.passengers = new ArrayList<>();
   }

   public String getName() {
      return this.name;
   }

   public int getPassengerCapacity() {
      return this.passengerCapacity;
   }

   public List<Destination> getItinerary() {
      return this.itinerary;
   }

   public void setItinerary(List<Destination> itineraries) {
      this.itinerary = itineraries;
   }

   public List<Passenger> getPassengers() {
      return this.passengers;
   }

   public void addDestination(Destination destination) {
      this.itinerary.add(destination);
   }

   public void addPassenger(Passenger passenger) {
      if(passengerCapacity-->0)
      {
         passengers.add(passenger);
      }
   }

   public void printItinerary() {
      System.out.println("Travel Itinerary for " + this.name + ":");
      for (Destination destination : this.itinerary) {
         System.out.println("Destination: " + destination.getName());
         List<Activity> activities = destination.getActivities();
         for (Activity activity : activities) {
            System.out.println("Activity: " + activity.getName());
            System.out.println("Description: " + activity.getDescription());
            System.out.println("Price: " + activity.getCost());
            System.out.println("Capacity: " + activity.getCapacity());
         }
         System.out.println("-------------------------");
      }
   }

   public void printPassengerList() {
      System.out.println("Passenger List" + name + ":");
      System.out.println("Passenger Capacity: " + passengerCapacity);
      System.out.println("Number of Passengers" + passengers.size());
      for (Passenger passenger : passengers) {
         System.out.println("Name: " + passenger.getName());
         System.out.println("Number: " + passenger.getNumber());
         System.out.println("-------------------------");
      }
   }

   public void printPassengerDetail(Passenger passenger) {
      System.out.println("Passenger Details" + passenger.getName());
      System.out.println("name: " + passenger.getName());
      System.out.println("number: " + passenger.getNumber());
      if (passenger.getType() != PassengerType.standardPasssenger) {
         System.out.println("balance: " + passenger.getBalance());
      }
      List<Activity> signedUpActivities = passenger.getSignedUpActivities();
      if (signedUpActivities.size() > 0) {
         System.out.println("Activities");
         for (Activity activity : signedUpActivities) {
            System.out.println("Activity: " + activity.getName());
            Destination destination = this.getActivityDestination(activity);
            System.out.println("destination: " + destination.getName());
            if (passenger.getType() != PassengerType.standardPasssenger) {
               System.out.println("pay: " + this.calculatePaidPrice(activity, passenger.getType()));

            }
         }
      } else {
         System.out.println("no Activities");
      }
   }
   public void activitySignup(Passenger passenger, Activity activity) {
      int activityPrice = activity.getCost();
      if(!(passenger.isBalanceExceeded(activityPrice))&&!(activity.isCapacityFull()))
      {
         passenger.addActivity(activity);
         passenger.updateBalance(activityPrice-1);
         activity.setFinalCapacity(activity.getFinalCapacity()-1);
      }
   }

   private Destination getActivityDestination(Activity activity) {
      for (Destination destination1 : itinerary) {
         if (destination1.getActivities().contains(activity)) {
            return destination1;
         }
      }
      return null;
   }

   private int calculatePaidPrice(Activity activity, PassengerType passengerType) {
      int activityCost = activity.getCost();
      if (passengerType.equals(PassengerType.goldPassenger)) {
         double discountCost = activityCost * (1-0.1);
         int payAmount = (int) discountCost;
         return payAmount;
      }
      return activityCost;
   }

   public void printAllActivities() {
      System.out.println("Activities " + name);
      for (Destination destination : itinerary) {
         System.out.println("destination: " + destination.getName());
         List<Activity> activities = destination.getActivities();
         for (Activity activity : activities) {
            if (activity.getFinalCapacity() < activity.getCapacity()) {
               int availableSpaces = activity.getCapacity() - activity.getFinalCapacity();
               System.out.println("Activity: " + activity.getName());
               System.out.println("description: " + activity.getDescription());
               System.out.println("cost: " + activity.getCost());
               System.out.println("spaces: " + availableSpaces);
               System.out.println("-------------------------");
            }
         }
      }
   }
}
