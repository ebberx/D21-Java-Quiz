package com.company;

import java.util.Random;
import java.util.Scanner;

class Player {
    public String name;
    public int score;

    public Player() {
        name = "";
        score = 0;
    }
}

public class Main {

    public static String[] questions;
    public static boolean[] answers;
    public static Player[] players;

    public static void main(String[] args) {
        LoadQuestionsAndAnswers();

        Scanner sc = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the Java Quiz!");

        // Ask for number of players
        int playerCount = 2;
        while(true) {
            System.out.println("Please choose number of players (2-4): ");
            while(!sc.hasNextInt()) {
                sc.next();
            }
            playerCount = sc.nextInt();
            if(playerCount >= 2 && playerCount <= 4) {
                System.out.println("You have chosen " + playerCount + " players!");
                players = new Player[playerCount];
                for(int i = 0; i < playerCount; i++) {
                    players[i] = new Player();
                }
                break;
            }
        }

        System.out.println("\nStarting game...!\n");

        // Game loop
        for(int i = 0; i < playerCount * 4; i++) {
            // Print which players turn it is
            int playerTurn = ((i)%playerCount)+1;
            System.out.println("Player " + playerTurn + "'s turn!");

            // Generate random number between 0 - 10
            Random random = new Random();
            int j = random.nextInt(10);

            // Print question
            System.out.println(questions[j]);

            // Get true/false answer
            boolean answer;
            while(true) {
                int answerInt = GetTrueOrFalse();
                if(answerInt == 1) {
                    answer = true;
                    break;
                }
                else if (answerInt == 0) {
                    answer = false;
                    break;
                }
            }

            // Print if correct or not
            if(answers[j] == answer) {
                System.out.println("That was correct!\n");
                players[playerTurn-1].score++;
            }
            else {
                System.out.println("That was wrong!\n");
            }
        }

        // Display scores
        System.out.println("Scores are as follows: ");
        for(int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i+1) + " score: " + players[i].score);
        }

    }

    public static void LoadQuestionsAndAnswers() {
        // Load in questions
        questions = new String[10];
        answers = new boolean[10];

        questions[0] = "Is the int data type 8 bytes in size?";
        answers[0] = false;
        questions[1] = "Is 'bool' a data type?";
        answers[1] = false;
        questions[2] = "Is Java a C-like language?";
        answers[2] = true;
        questions[3] = "Does Java have a limited number of libraries?";
        answers[3] = false;
        questions[4] = "Is ArrayList and Arrays the same thing?";
        answers[4] = false;
        questions[5] = "Is main the default entry point of a java program?";
        answers[5] = true;
        questions[6] = "Can you have more than one parameter in an if statement?";
        answers[6] = true;
        questions[7] = "Does a boolean have more than two values?";
        answers[7] = false;
        questions[8] = "Is there a difference between Java and C?";
        answers[8] = true;
        questions[9] = "Is Java a business language?";
        answers[9] = false;
    }

    public static int GetTrueOrFalse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("y|yes|true or n|no|false: ");
        String input = sc.next();
        if(input.equalsIgnoreCase("false") || input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
            return 0;
        }
        if(input.equalsIgnoreCase("true") || input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
            return 1;
        }
        return -1;
    }
}
