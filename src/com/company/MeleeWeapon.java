package com.company;

public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String itemName, String itemDescription, int damage) {
        super(itemName, itemDescription, damage);
    }

    @Override
    public String toString() {
        return getItemDescription() + " weapon damage "+ getDamage();

    }


}