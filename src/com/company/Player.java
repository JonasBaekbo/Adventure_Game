package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Player {
    Scanner userInput = new Scanner(System.in);
    private Room currentRoom;
    private ArrayList<Item> playerInventory = new ArrayList<>();


    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
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
                    if (this.currentRoom.getListOfItems() == null || this.currentRoom.getListOfItems().size() == 0 ){
                        System.out.println("There is no items in this room");
                    }else{
                        System.out.println("List of items in the room:\n" + this.currentRoom.getListOfItems());

                    }
                }

                case "help" -> System.out.println("List of commands:\n\"go\": Use this and type a direction you want to go in(north, south, east, west) - Example: go north\n\"look\": Writes the description of the current room you are in.\n\"exit\": Exits the game. Use this when you want to end your game. It does'nt save your progress");
                case "exit" -> System.exit(0);
            }
            if (userDirection.length() > 4){
            String takeOrDropCommand = userDirection.substring(0,4);
            String takenorDroppedItem = userDirection.substring(5);
            switch (takeOrDropCommand){
                case "take" -> takeItem(this.currentRoom.findItem(takenorDroppedItem));
            }

            }
        }
    }
    public void takeItem(Item takenItem){
        playerInventory.add(takenItem);
        this.currentRoom.dropItem(takenItem.getItemName());
        System.out.println(playerInventory);
    }
}
