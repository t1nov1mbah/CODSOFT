package TASK_ONE_NUMBER_GUESSING_GAME;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;
    static int attempts = 1;
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int finalScore = 0;

        boolean playAgain;
        System.out.println("TASK 1 : Number Guessing Game "+"\nPlease Enter your Username");
        String userName = scanner.nextLine();
        System.out.println("Welcome "+userName+", to the Number Guessing Game!!!");

        do {
            int targetNumber = generateRandomNumber();
            playGame(targetNumber);
            playAgain = askToPlayAgain();
        } while (playAgain);

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    private static int generateRandomNumber() {
        return random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
    }

    private static void playGame(int targetNumber) {

        boolean isGuessed = false;


        System.out.println("RULES" + "\nI have generated a number between " + RANGE_MIN + " and " + RANGE_MAX + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

        while (attempts <= MAX_ATTEMPTS && !isGuessed) {
            int userGuess = AcceptUserGuess();
            attempts++;

            isGuessed = checkUserGuess(userGuess, targetNumber);
        }

        if (!isGuessed) {
            System.out.println("Sorry, you've used all your attempts. The number was " + targetNumber + ".");
        }
    }

    private static int AcceptUserGuess() {
        System.out.print("Attempt "+attempts+": Enter your guess: ");
        return scanner.nextInt();
    }

    private static boolean checkUserGuess(int userGuess, int targetNumber) {
        if (userGuess < RANGE_MIN || userGuess > RANGE_MAX) {
            System.out.println("Please guess a number between " + RANGE_MIN + " and " + RANGE_MAX + ".");
            return false;
        } else if (userGuess < targetNumber) {
            System.out.println("Too low! Try again.");
            return false;
        } else if (userGuess > targetNumber) {
            System.out.println("Too high! Try again.");
            return false;
        } else {
            System.out.println("Congratulations! You've guessed the number " + targetNumber + ".");
            return true;
        }
    }

    private static boolean askToPlayAgain() {
        System.out.print("Do you want to play again? (yes/no): ");
        return scanner.next().equalsIgnoreCase("yes");
    }
}
