package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class Player {
    Scanner userInput = new Scanner(System.in);
    private Room currentRoom;
    private int playerHealth;
    private ArrayList<Item> playerInventory = new ArrayList<>();
enum eatableFood {
    MINUSHEALTH,
    PLUSHEALTH,
    NONEATABLE
}

    public Player(Room currentRoom, int health) {
        this.currentRoom = currentRoom;
        this.playerHealth = health;
        while (true)

        {
            String userDirection = userInput.nextLine();
            switch (userDirection) {
                case "north", "go north", "n" -> {
                    if (this.currentRoom.getNorth() == null) {
                        System.out.println("You cant go that way. Try going another direction");
                    } else {
                       this. currentRoom = this.currentRoom.getNorth();
                        System.out.println("Going north");
                        System.out.println(this.currentRoom);

                    }
                }
                case "south", "go south", "s" -> {
                    if (this.currentRoom.getSouth() == null) {
                        System.out.println("You cant go that way. Try going another direction");
                    } else {
                       this. currentRoom = this.currentRoom.getSouth();
                        System.out.println("Going south");
                        System.out.println(this.currentRoom);

                    }
                }
                case "east", "go east", "e" -> {
                    if (this.currentRoom.getEast() == null) {
                        System.out.println("You cant go that way. Try going another direction");
                    } else {
                        this.currentRoom = this.currentRoom.getEast();
                        System.out.println("Going east");
                        System.out.println(this.currentRoom);

                    }
                }
                case "west", "go west", "w" -> {
                    if (this.currentRoom.getWest() == null) {
                        System.out.println("You cant go that way. Try going another direction");
                    } else {
                        this.currentRoom = this.currentRoom.getWest();
                        System.out.println("Going west");
                        System.out.println(this.currentRoom);

                    }
                }
                case "look" -> {
                    System.out.println(this.currentRoom);
                    if (this.currentRoom.getListOfItems() == null || Objects.equals(this.currentRoom.getListOfItems(), "")){
                        System.out.println("There is no items in this room");
                    }else{
                        System.out.println("List of items in the room:\n" + this.currentRoom.getListOfItems());

                    }
                }
                case "health" ->{
                    if (this.playerHealth == 50){
                        System.out.printf("Health: %s\nYou feel replenished and ready to embark on your adventure!", showPlayerHealth());
                    }else if (this.playerHealth <=49 && this.playerHealth >= 21){
                        System.out.printf("Health: %s\nYou feel a bit exhausted!", showPlayerHealth());
                    }else if (this.playerHealth <= 20 && this.playerHealth >= 11){
                        System.out.printf("Health: %s\nYou feel tired! You should think about eating something!", showPlayerHealth());
                    }else if(this.playerHealth <= 10){
                        System.out.printf("Health: %s\nYou are hurt! You need to eat to feel better!", showPlayerHealth());
                    }
                }

                case "help" -> System.out.println("List of commands:\n\"go\": Use this and type a direction you want to go in(north, south, east, west) - Example: go north\n\"look\": Writes the description of the current room you are in.\n\"take\": Picks up an item in a room - Example: take itemname\n\"drop\": Drops an item in a room - Example: drop itemname\n\"inventory\": Displays the inventory\n\"exit\": Exits the game. Use this when you want to end your game. It does'nt save your progress");
                case "exit" -> System.exit(0);
            }
            if (playerInventory.isEmpty()) {
                switch (userDirection) {
                    case "inventory" -> System.out.println("You don't have any items in your inventory");

                }
            }else {
                switch (userDirection) {
                case "inventory" -> System.out.println("Player Inventory:\n" + getListOfItems());

                }

            }
            if (userDirection.length() > 4){
            String takeOrDropCommand = userDirection.substring(0,4);
            String takenorDroppedItem = userDirection.substring(4);
            switch (takeOrDropCommand){
                case "take" -> takeItem(this.currentRoom.findItem(takenorDroppedItem));
                case "drop" -> dropItem(playerInventory.get(0));
                case "eat " -> eatFood(takenorDroppedItem);
            }
                for (Item element : playerInventory){
                    if (element.equals(this.currentRoom.findItem(takenorDroppedItem))){
                        switch (takeOrDropCommand){
                            case "drop" -> {dropItem(element);}
                        }
                    }
                }
            }
        }
    }

    private void eatFood(String eatenItem) {
Item found = this.currentRoom.findItem(eatenItem);
        System.out.println(found.getClass());

    }

    private int showPlayerHealth() {
        return this.playerHealth;
    }

    public void takeItem(Item takenItem){
        playerInventory.add(takenItem);
        this.currentRoom.dropItem(takenItem.getItemName());
        System.out.println("You take " + takenItem);
    }
    public void dropItem(Item takenItem){
        this.currentRoom.setListOfItems(takenItem.getItemName(), takenItem.getItemDescription());
        playerInventory.remove(takenItem);
        System.out.println("You drop: " + takenItem);
    }
    public String getListOfItems() {
        StringBuilder sb = new StringBuilder();
        for (Item s : playerInventory)
        {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
