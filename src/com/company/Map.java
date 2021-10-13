package com.company;

public class Map {
    public static Room currentRoom;
    public Map(int startRoom){

        Room room1 = new Room("Room1", "You are on an open area filled with grass. In the distance you see a house", null, null, null, null);
        Room room2 = new Room("Room2", "You make your way onto an open road", null, null, null, null);
        Room room3 = new Room("Room3", "You make your way into a large dark forrest", null, null, null, null);
        Room room4 = new Room("Room4", "You are in front of the house", null, null, null, null);
        Room room5 = new Room("Room5", "You are the basement of the house", null, null, null, null);
        Room room6 = new Room("Room6", "You are behind the house", null, null, null, null);
        Room room7 = new Room("Room7", "You make your way into a small room", null, null, null, null);
        Room room8 = new Room("Room8", "You are in the entrance of a small house", null, null, null, null);
        Room room9 = new Room("Room9", "You make your way into the houses biggest room", null, null, null, null);
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

        room1.setListOfItems(new MeleeWeapon("sword", "a short sword", 2));
        room1.setListOfItems(new Item("key", "A key to a small house"));
        room1.setListOfItems(new Food("apple", "A shiny apple", 2));
        room8.setListOfItems(new Food("can", "A can of food", 5));
        room9.setListOfItems(new Food("corncob", "a cooked corncob", 3));
        room4.setListOfItems(new MeleeWeapon("axe", "a rust axe",3));
        room8.setListOfItems(new RangedWeapon("musket", "a old musket" ,3 ,8));
        room2.setListOfItems(new Item("rock", "A little black shiny rock"));
        room3.setListOfItems(new Item("branch", "A small branch that has fallen down from a tree"));
        room5.setListOfItems(new Item("wine", "A tasty old wine from the ancient days"));
        room7.setListOfItems(new Item("can", "A can of Dehydrated Water"));
        room8.setListOfItems(new Item("coat", "A big fur coat"));
        room9.setListOfItems(new Item("Pen", "A used pen"));
        room9.setListOfItems(new Item("Doll", "A creepy looking doll, with giant eyes"));
        room9.setListOfItems(new Item("Knife", "A rusty knife"));
        room7.addEnemyToRoom(new Enemy("Ogre", "A big green ogre", 5, (new MeleeWeapon("Mace", "A wooden mace", 2))));
        room5.addEnemyToRoom(new Enemy("Gobli", "A tiny Gobli", 2 , (new MeleeWeapon("knife", "A tiny rysty knif", 1))));
        room2.addEnemyToRoom(new Enemy("Troll", "A Giant forstes troll", 8 , (new MeleeWeapon("club" , "A giant wooden club", 4))));

currentRoom = room1;

    };

};
