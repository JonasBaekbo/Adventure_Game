package com.company;

public class rangedWeapons extends Weapon{
    private int ammo;


    public rangedWeapons(String itemName, String itemDescription, int damage, int ammo){
        super(itemName,itemDescription,damage);
        this.ammo = ammo;

    }
    public int getAmmo() {
        return this.ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }


    @Override
    public String toString() {
        return getItemDescription() + " damage "+ getDamage() + " ammo count " + getAmmo();

    }
}
