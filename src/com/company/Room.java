package com.company;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Item item;
    private ArrayList<Item> listOfItems;
    private Enemy enemy;
    public Room(String name, String description, Room north, Room south, Room east, Room west) {
        this.name = name;
        this.description = description;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.listOfItems = new ArrayList<>();
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

    public void setListOfItems(Item item) {
        this.listOfItems.add(item);

        }

    public String getListOfItems() {
        if (listOfItems == null){
            return null;
        }else{
        StringBuilder sb = new StringBuilder();
        for (Item s : listOfItems)
        {
            sb.append(s);
            sb.append("\t");
        }
        return sb.toString();

        }
    }

    public void dropItemFromRoom(String droppedItem){
        for (int i = 0; i < this.listOfItems.size(); i++) {
            if (this.listOfItems.get(i).getItemName().equals(droppedItem)) {
                this.listOfItems.remove(i);
            }
        }
    }
    public Item findItem(String pickedUpItem) {
        for (Item listOfItem : this.listOfItems) {
            if (pickedUpItem.equals(listOfItem.getItemName())) {
                return listOfItem;
            }
        }
        return null;
    }


    public void damageEnemy(int damage) {
        this.enemy.decreaseHealthPoints(damage);
    }
    public void addEnemyToRoom(Enemy enemy){
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }


    public void removeEnemyFromRoom() {
        setListOfItems(this.enemy.getWeapon());
        this.enemy = null;
    }
    @Override
    public String toString() {
        return "You are in the room " + name + ". " + description;
    }
}
