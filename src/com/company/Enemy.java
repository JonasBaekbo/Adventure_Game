package com.company;

public class Enemy {
    private String name;
    private String description;
    private int healthPoints;
    private Weapon weapon;

    public Enemy(String name, String description, int healthPoints, Weapon weapon) {
        this.name = name;
        this.description = description;
        this.healthPoints = healthPoints;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void dropWeapon(){

    }
}
