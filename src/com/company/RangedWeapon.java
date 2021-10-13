package com.company;

public class RangedWeapon extends Weapon{
    private int ammo;


    public RangedWeapon(String itemName, String itemDescription, int damage, int ammo){
        super(itemName,itemDescription,damage);
        this.ammo = ammo;

    }
    public int getAmmo() {
        return this.ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo -= ammo;
    }


    @Override
    public String toString() {
        return getItemDescription() + " damage "+ getDamage() + " ammo count " + getAmmo();

    }
}
