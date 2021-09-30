package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Item item;
    private ArrayList<Item> listOfItems;
    public Room(String name, String description, Room north, Room south, Room east, Room west, Item[] items) {
        this.name = name;
        this.description = description;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.listOfItems = new ArrayList<>();
        for (Item value : items) {
            if (value != null) {
                this.setListOfItems(value.getItemName(), value.getItemDescription());
            } else {
                listOfItems = null;
            }
        }
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setListOfItems(String itemName, String itemDescription) {
        if (itemName != null && itemDescription != null){
        Item item = new Item(itemName, itemDescription);
        String[] things = {item.toString()};
        listOfItems.add(item);

        }

    }

    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }

    public void takeItem(Item pickedUpItem){

    }
    public void dropItem(String droppedItem){
    listOfItems.remove(findItem(droppedItem));
    }
    public Item findItem(String pickedUpItem) {
        for (int i = 0; i < listOfItems.size(); i++) {
            if (pickedUpItem.equals(listOfItems.get(i).getItemName())){
                return listOfItems.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "You are in the room " + name + ". " + description;
    }
}
