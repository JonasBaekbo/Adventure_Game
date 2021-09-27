package com.company;

public class Map {
    public static Room currentRoom;
    private Room startroom;
    public Map(int startRoom){
        Room room1 = new Room("Room1", "You are in a house", null, null, null, null);
        Room room2 = new Room("Room2", "You are in a house", null, null, null, null);
        Room room3 = new Room("Room3", "You are in a house", null, null, null, null);
        Room room4 = new Room("Room4", "You are in a house", null, null, null, null);
        Room room5 = new Room("Room5", "You are in a house", null, null, null, null);
        Room room6 = new Room("Room6", "You are in a house", null, null, null, null);
        Room room7 = new Room("Room7", "You are in a house", null, null, null, null);
        Room room8 = new Room("Room8", "You are in a house", null, null, null, null);
        Room room9 = new Room("Room9", "You are in a house", null, null, null, null);
        room1.setSouth(room4);
        room1.setEast(room2);
        room2.setEast(room3);
        room2.setWest(room1);
        room3.setSouth(room6);
        room3.setWest(room2);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room7.setNorth(room4);
        room7.setEast(room8);
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);
        room9.setNorth(room6);
        room9.setWest(room8);
        if (startRoom == 1){
            this.startroom = room1;
            currentRoom = room1;
        }

    };

};
