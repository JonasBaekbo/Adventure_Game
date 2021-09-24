package com.company;

import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
	// write your code here
        Scanner userInput = new Scanner(System.in);
        Room room1 = new Room("Room1", "You are in a house", null, Room, null, room2);
        Room room2 = new Room("Room2", "You are in a house", null, null, room3, room1);
        Room room3 = new Room("Room3", "You are in a house", null, room6, null, room2);
        Room room4 = new Room("Room4", "You are in a house", room1, room7, null, null);
        Room room5 = new Room("Room5", "You are in a house", null, room2, null, room4);
        Room room6 = new Room("Room6", "You are in a house", null, room2, null, room4);
        Room room7 = new Room("Room7", "You are in a house", null, room2, null, room4);
        Room room8 = new Room("Room8", "You are in a house", null, room2, null, room4);
        Room room9 = new Room("Room9", "You are in a house", null, room2, null, room4);
        Room currentRoom;

        currentRoom = room1;
        String userDirection = userInput.nextLine();
        switch (userDirection) {
            case "north", "go north", "n" -> System.out.println("Going north");
            case "south", "go south", "s" -> System.out.println("Going south");
            case "east", "go east", "e" -> System.out.println("Going east");
            case "west", "go west", "w" -> System.out.println("Going west");
            case "look" -> System.out.println(currentRoom);
        }


    }
}
