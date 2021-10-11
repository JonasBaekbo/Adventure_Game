package com.company;

public class Food extends Item {
    private String name;
    private String description;
    private int healthPoints;

    public Food(String itemName, String itemDescription, int healthPoints) {
        super(itemName, itemDescription);
        this.healthPoints = healthPoints;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }
<<<<<<< HEAD
=======
 @Override
    public String toString() {
        return super.toString() + "Food{" +
                "healthPoints=" + healthPoints +
                '}';
    }
>>>>>>> origin/main
}
