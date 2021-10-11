package com.company;

public class Item {
    protected final String itemName;
    protected final String itemDescription;

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
