public class Activity {
    private String name;
    private String description;
    private int cost;
    private int capacity;
    private int finalCapacity;
    public Activity(String name, int cost, int capacity) {
        this.name = name;
        this.cost = cost;
        this.capacity = capacity;
        this.finalCapacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFinalCapacity() {
        return finalCapacity;
    }

    public void setFinalCapacity(int finalCapacity) {
        this.finalCapacity = finalCapacity;
    }

    public boolean isCapacityFull() {
        return (finalCapacity == 0);
    }
}
