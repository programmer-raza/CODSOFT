/*
 * Number_Game.java
 * A simple Java program for a number guessing game.
 * The user has to guess a randomly generated number between 1 and 100.
 * The game tracks the number of attempts and the final score.
 */

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Number_Game {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);   //Scanner class for user input
        Random rand = new Random();  //Radom class for generating random number

        final int maxWrongAnswers = 5;

        int playAgain = 1; //variable for playing game again

        while (playAgain == 1) // while playagain remain = 1 , game continues
        {

            int wrongAnswers = 0;
            int score = 0;
            int randomNumber = rand.nextInt(100) + 1;
            System.out.println("\n=== Number Guessing Game ===\n");
            while (wrongAnswers < maxWrongAnswers)//while the wrongAnswers less than maxWrong the game continues
            {

                System.out.println("\nAttempts left : " + (maxWrongAnswers - wrongAnswers));
                System.out.println("Guess a number between 1 and 100: ");
//here the program checks for any non integer input , if found will through an exception
                try {

                    int userGuess = input.nextInt();

                    if (randomNumber == userGuess) {
                        System.out.println("\nCorrect guess! You're a winner!");
                        score++;
                        randomNumber = rand.nextInt(100) + 1;

                    } else {
                        if (userGuess < randomNumber) {
                            System.out.println("Your guess is too low. Try again.");

                        } else {
                            System.out.println("Your guess is too high. Try again.");

                        }
                        wrongAnswers++;

                    }

                } catch (InputMismatchException e) {
                    wrongAnswers++;
                    if (wrongAnswers != maxWrongAnswers) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }

                    input.next();  // Clear the invalid input from the scanner
                }
            }

            System.out.println("\n \t\t\t\tGame Over!\nThe correct number was: "
                    + randomNumber + "\nYour Final Score: " + score);

            boolean validEntry = false;
            while (!validEntry) {
                System.out.println("Press 1 to play again or 0 to quit: ");
                //here program checks for valid input , if not found throws exception
                try {
                    int userInput = input.nextInt();
                    if (userInput == 0 || userInput == 1) {
                        playAgain = userInput;
                        validEntry = true;
                    } else {
                        System.out.println("Invalid input. Please enter 1 to play again or 0 to quit.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter 1 to play again or 0 to quit.");
                    input.next();
                }
            }
        }

        System.out.println("\nThank you for playing!");
        input.close();
    }
}
