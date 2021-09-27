package com.company;

import java.util.Scanner;

import static com.company.Map.currentRoom;

public class Adventure {

    public static void main(String[] args) {
	// write your code here
        Scanner userInput = new Scanner(System.in);
        Map map = new Map(1);

        System.out.println("Welcome to the adventure game!\nIn this game you .. .\nUse the command \"help\" for instructions on how to play the game" );
        System.out.println(currentRoom);
        while (true) {
            String userDirection = userInput.nextLine();
            switch (userDirection) {
                case "north", "go north", "n" -> {
                    if (currentRoom.getNorth() == null){
                        System.out.println("You cant go that way. Try going another direction");
                    }else{
                        currentRoom = currentRoom.getNorth();
                    System.out.println("Going north");
                    System.out.println(currentRoom);

                    }
                }
                case "south", "go south", "s" -> {
                    if (currentRoom.getSouth() == null) {
                        System.out.println("You cant go that way. Try going another direction");
                    } else {
                        currentRoom = currentRoom.getSouth();
                        System.out.println("Going south");
                        System.out.println(currentRoom);

                    }
                }
                case "east", "go east", "e" -> {
                    if (currentRoom.getEast() == null) {
                        System.out.println("You cant go that way. Try going another direction");
                    } else {
                        currentRoom = currentRoom.getEast();
                        System.out.println("Going east");
                        System.out.println(currentRoom);

                    }
                }
                case "west", "go west", "w" -> {
                    if (currentRoom.getWest() == null) {
                        System.out.println("You cant go that way. Try going another direction");
                    } else {
                        currentRoom = currentRoom.getWest();
                        System.out.println("Going west");
                        System.out.println(currentRoom);

                    }
                }
                case "look" -> System.out.println(currentRoom);
                case "help" -> System.out.println("List of commands:\n\"go\": Use this and type a direction you want to go in(north, south, east, west) - Example: go north\n\"look\": Writes the description of the current room you are in.\n\"exit\": Exits the game. Use this when you want to end your game. It does'nt save your progress");
                case "exit" -> System.exit(0);
            }
        }

    }
}
