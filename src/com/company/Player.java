package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Player {
    Scanner userInput = new Scanner(System.in);
    private Room currentRoom;
    private int playerHealth;
    private ArrayList<Item> playerInventory = new ArrayList<>();
    private Weapon equippedWeapon;


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
                        if (this.currentRoom.getEnemy() != null){
                            System.out.println("There might be something in here with you!");
                        }

                    }
                }
                case "south", "go south", "s" -> {
                    if (this.currentRoom.getSouth() == null) {
                        System.out.println("You cant go that way. Try going another direction");
                    } else {
                       this. currentRoom = this.currentRoom.getSouth();
                        System.out.println("Going south");
                        System.out.println(this.currentRoom);
                        if (this.currentRoom.getEnemy() != null){
                            System.out.println("There might be something in here with you!");
                        }

                    }
                }
                case "east", "go east", "e" -> {
                    if (this.currentRoom.getEast() == null) {
                        System.out.println("You cant go that way. Try going another direction");
                    } else {
                        this.currentRoom = this.currentRoom.getEast();
                        System.out.println("Going east");
                        System.out.println(this.currentRoom);
                        if (this.currentRoom.getEnemy() != null){
                            System.out.println("There might be something in here with you!");
                        }

                    }
                }
                case "west", "go west", "w" -> {
                    if (this.currentRoom.getWest() == null) {
                        System.out.println("You cant go that way. Try going another direction");
                    } else {
                        this.currentRoom = this.currentRoom.getWest();
                        System.out.println("Going west");
                        System.out.println(this.currentRoom);
                        if (this.currentRoom.getEnemy() != null){
                            System.out.println("There might be something in here with you!");
                        }

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
                case "attack" -> {
                    if (this.currentRoom.getEnemy() == null){
                        System.out.println("There is no enemy to attack!");
                    } else{
                    attack();
                }}

                case "help" -> System.out.println("List of commands:\n\"go\": Use this and type a direction you want to go in(north, south, east, west) - Example: go north\n" +
                        "\"look\": Writes the description of the current room you are in.\n\"" +
                        "take\": Picks up an item in a room - Example: take itemname\n\"" +
                        "drop\": Drops an item in a room - Example: drop itemname\n" +
                        "\"inventory\": Displays the inventory\n" +
                        "\"eat\": Eats food in either the current room or in the inventory - Usage: eat itemname\n" +
                        "\"equip\": Equips a weapon that has been picked up - Example: equip itemname\n" +
                        "\"show\": Displays the current equipped weapon\n" +
                        "\"attack\": Attacks an enemy if there is one in the current room\n" +
                        "\"exit\": Exits the game. Use this when you want to end your game. It does'nt save your progress");
                case "exit" -> {
                    System.out.println("Thank you for playing \"The House\"!\nHope you had fun!\nThe game will now end itself");
                    System.exit(0);}

                case "show" -> {
                    if (equippedWeapon == null) {
                        System.out.println("You have no weapons equipped!");
                    } else {
                        System.out.println("You have " + showEquippedWeapon() + " equiped");

                    }
                }
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
                case "take" -> takeItem(this.currentRoom.findItem(takenorDroppedItem.substring(1)));
                case "eat " -> eatFood(takenorDroppedItem);
                case "drop" -> dropItem(getPlayerItem(takenorDroppedItem));
                case "equi" -> equipWeapon(getPlayerItem(takenorDroppedItem.substring(1)));
                }
            }

        }
    }

    private void eatFood(String eatenItem) {
        Item foundinRoom = this.currentRoom.findItem(eatenItem);
        Item foundInInv = getPlayerItem(" " + eatenItem);
            if (foundinRoom != null){
                if (foundinRoom instanceof Food){
                    int healthPoints = (((Food) foundinRoom).getHealthPoints());
                    playerHealth += healthPoints;
                    this.currentRoom.dropItemFromRoom(foundinRoom.getItemName());
                    System.out.println("You have eaten " + foundinRoom + "\n(Added " + healthPoints + " healthpoints)");

                }
            }else if (playerInventory.contains(foundInInv)){
                if (foundInInv instanceof Food){
                    int healthPoints = (((Food) foundInInv).getHealthPoints());
                    playerHealth += healthPoints;
                    //this.currentRoom.dropItemFromRoom(foundInInv);
                    System.out.println("You have eaten " + foundInInv + "\n(Added " + healthPoints + " healthpoints)");

                }
            }
    }
    private void equipWeapon(Item equipedItem){
        if (equipedItem == null){
            System.out.println("you dont have that in your inventory");
        }else if (equipedItem instanceof Weapon) {
            if (equippedWeapon != null) {
                equippedWeapon = (Weapon) equipedItem;
                System.out.println("you equip " + equipedItem);
            }else{
                equippedWeapon = (Weapon) equipedItem;
                playerInventory.remove(equipedItem);
                System.out.println("you equip " + equipedItem);
            }
        }else{
            System.out.println(equipedItem.getItemName() + " is not a weapon");
        }
    }
    public String showEquippedWeapon(){
        return this.equippedWeapon.getItemName();
    }

    public void attack(){
        if (equippedWeapon instanceof MeleeWeapon){
        int damage = getDamage();
        this.currentRoom.damageEnemy(damage);
            System.out.println("You deal " + damage + " damage with your " + equippedWeapon.getItemName());
            System.out.println("The " + this.currentRoom.getEnemy().getName() + " has " + this.currentRoom.getEnemy().getHealthPoints() + " HP left");
            this.decreaseHealthPoints(this.currentRoom.getEnemy().getWeapon().getDamage());
            System.out.println("You take "  + this.currentRoom.getEnemy().getWeapon().getDamage() + " from the " + this.currentRoom.getEnemy().getName() + "'s " + this.currentRoom.getEnemy().getWeapon().getItemName());
            System.out.println("You have " + this.playerHealth + " HP left");
        }else if (equippedWeapon instanceof RangedWeapon){
            int damage = getDamage();
            if (((RangedWeapon) equippedWeapon).getAmmo() <= 0){
                System.out.println("You don't have any ammo in this weapon");
                this.decreaseHealthPoints(this.currentRoom.getEnemy().getWeapon().getDamage());
            }else if (((RangedWeapon) equippedWeapon).getAmmo() >= 0){
            ((RangedWeapon) equippedWeapon).setAmmo(-1);
            this.currentRoom.damageEnemy(damage);
                System.out.println("You deal " + damage + " damage with your " + equippedWeapon.getItemName());
                System.out.println("You have " + ((RangedWeapon) equippedWeapon).getAmmo() + "left in your weapon");
                System.out.println("The " + this.currentRoom.getEnemy().getName() + " has " + this.currentRoom.getEnemy().getHealthPoints() + " HP left");
                this.decreaseHealthPoints(this.currentRoom.getEnemy().getWeapon().getDamage());
                System.out.println("You take "  + this.currentRoom.getEnemy().getWeapon().getDamage() + " from the " + this.currentRoom.getEnemy().getName() + "'s " + this.currentRoom.getEnemy().getWeapon().getItemName());
                System.out.println("You have " + this.playerHealth + " HP left");

            }
        }
        if (this.playerHealth <= 0){
            System.out.println("You are dead!");
            System.exit(0);
        }
        if (this.currentRoom.getEnemy().getHealthPoints() <= 0){
            System.out.println("You have killed the " + this.currentRoom.getEnemy().getName());
            this.currentRoom.removeEnemyFromRoom();
        }
    }

    private void decreaseHealthPoints(int damage) {
        this.playerHealth -= damage;
    }

    private int getDamage() {
        int damage = equippedWeapon.getDamage();
        return damage;
    }


    private int showPlayerHealth() {
        return this.playerHealth;
    }

    public void takeItem(Item takenItem){
        if (takenItem == null){
            System.out.println("There is no such item");
        }else{
        playerInventory.add(takenItem);
        this.currentRoom.dropItemFromRoom(takenItem.getItemName());
        System.out.println("You take " + takenItem);

        }
    }
    public void dropItem(Item takenItem){
        this.currentRoom.setListOfItems(takenItem);
        playerInventory.remove(takenItem);
        System.out.println("You drop " + takenItem);
    }
    public Item getPlayerItem(String name) {
        for (Item listOfItem : this.playerInventory) {
            if (name.equals(" " + listOfItem.getItemName())) {
                return listOfItem;
            }
        }
        return null;
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
