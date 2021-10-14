package com.company;

import java.util.Scanner;

import static com.company.Map.currentRoom;

public class Adventure {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Map map = new Map(1);
        System.out.println("Welcome to the The house!\nIn this game you wil work your way through different rooms.\nUse the command \"help\" for instructions on how to play the game" );
        System.out.println(currentRoom);
        if (currentRoom.getEnemy() != null){
            System.out.println("There might be something in here with you!");
        }
        Player player = new Player(currentRoom, 10);

    }
}
