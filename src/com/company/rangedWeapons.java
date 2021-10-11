package com.company;

public class rangedWeapons extends Weapon{
    private int ammo;


    public rangedWeapons(String itemName, String itemDescription, int damage, int ammo){
        super(itemName,itemDescription,damage);

    }
    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }


    @Override
    public String toString() {
        return getItemName();

    }
}
