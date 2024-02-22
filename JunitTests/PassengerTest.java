import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PassengerTest {
    private Passenger goldPassenger;
    private Passenger premiumPassenger;

    @BeforeEach
    public void setUp() {
        goldPassenger = new Passenger("Rohan", 12345, PassengerType.goldPassenger, 10);
        premiumPassenger = new Passenger("Rahul", 15, PassengerType.standardPasssenger, 0);

    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("Rohan", goldPassenger.getName());
    }

    @Test
    public void testSetName() {
        goldPassenger.setName("Jane Smith");
        Assertions.assertEquals("Jane Smith", goldPassenger.getName());
    }

    @Test
    public void testGetNumber() {
        Assertions.assertEquals(12345, goldPassenger.getNumber());
    }

    @Test
    public void testSetNumber() {
        goldPassenger.setNumber(67890);
        Assertions.assertEquals(67890, goldPassenger.getNumber());
    }

    @Test
    public void testGetType() {
        Assertions.assertEquals(PassengerType.goldPassenger, goldPassenger.getType());
    }

    @Test
    public void testSetType() {
        goldPassenger.setType(PassengerType.standardPassenger);
        Assertions.assertEquals(PassengerType.standardPassenger, goldPassenger.getType());
    }

    @Test
    public void testGetBalance() {
        Assertions.assertEquals(10, goldPassenger.getBalance());
    }

    @Test
    public void testSetBalance() {
        goldPassenger.setBalance(200);
        Assertions.assertEquals(200, goldPassenger.getBalance());
    }

    @Test
    public void testUpdateBalance() {
        goldPassenger.setBalance(200);
        goldPassenger.updateBalance(-10);
        Assertions.assertEquals(190, goldPassenger.getBalance());
    }

    @Test
    public void testisBalanceExceededTrueGold() {
        goldPassenger.setBalance(200);
        int price = 1000;

        Assertions.assertTrue(goldPassenger.isBalanceExceeded(price));
    }
    @Test
    public void testisBalanceExceededFalseGold() {
        goldPassenger.setBalance(180);
        int price = 200;

        Assertions.assertFalse(goldPassenger.isBalanceExceeded(price));
    }

    @Test
    public void testisBalanceExceededTrueStandard() {
        goldPassenger.setBalance(200);
        int price = 1000;
        Assertions.assertTrue(goldPassenger.isBalanceExceeded(price));
    }
    @Test
    public void testisBalanceExceededFalseStandard() {
        goldPassenger.setBalance(200);
        int price = 200;
        Assertions.assertFalse(goldPassenger.isBalanceExceeded(price));
    }

    @Test
    public void testisBalanceExceededFalsePremium() {
        int price = 1000;
        Assertions.assertTrue(goldPassenger.isBalanceExceeded(price));
    }

    @Test
    public void testGetSignedUpActivities() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Sleeping", 1000, 99));
        for(Activity activity:activities) {
            goldPassenger.addActivity(activity);
        }
        Assertions.assertEquals(1, goldPassenger.getSignedUpActivities().size());
    }

}

