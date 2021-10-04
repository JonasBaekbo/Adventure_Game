package com.company;

import java.util.ArrayList;

public class Item extends ArrayList<Item> {
    private final String itemName;
    private final String itemDescription;

    public Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }


    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }



    @Override
    public String toString() {
        return  getItemDescription();
    }
}
