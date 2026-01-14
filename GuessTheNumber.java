import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            char playAgain;

            do {
                // Difficulty Selection
                System.out.println("\nSelect Difficulty Level:");
                System.out.println("1. Easy (1-50, 10 attempts)");
                System.out.println("2. Medium (1-100, 7 attempts)");
                System.out.println("3. Hard (1-500, 5 attempts)");

                int choice = scanner.nextInt();

                int maxNumber = 100;
                int maxAttempts = 7;

                switch (choice) {
                    case 1 -> {
                        maxNumber = 50;
                        maxAttempts = 10;
                    }
                    case 2 -> {
                        maxNumber = 100;
                        maxAttempts = 7;
                    }
                    case 3 -> {
                        maxNumber = 500;
                        maxAttempts = 5;
                    }
                    default -> System.out.println("Invalid choice! Defaulting to Medium.");
                }

                int targetNumber = random.nextInt(maxNumber) + 1;
                int attemptsUsed = 0;
                boolean isGuessed = false;

                System.out.println("\nGuess the number between 1 and " + maxNumber);

                // Game Loop
                while (attemptsUsed < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int guess = scanner.nextInt();
                    attemptsUsed++;

                    if (guess > targetNumber) {
                        System.out.println("Too HIGH!");
                    } else if (guess < targetNumber) {
                        System.out.println("Too LOW!");
                    } else {
                        System.out.println("🎉 Correct! You guessed the number.");
                        isGuessed = true;
                        break;
                    }
                }

                // Score Calculation
                int score;
                if (isGuessed) {
                    score = 100 - (attemptsUsed * 10);
                    if (score < 0)
                        score = 0;
                } else {
                    score = 0;
                }

                // Game Summary
                System.out.println("\n----- Game Over -----");
                System.out.println("Attempts used: " + attemptsUsed);
                System.out.println("Status: " + (isGuessed ? "WIN" : "LOSE"));
                System.out.println("Final Score: " + score);

                // Replay Option
                System.out.print("\nDo you want to play again? (Y/N): ");
                playAgain = scanner.next().toUpperCase().charAt(0);

            } while (playAgain == 'Y');

            System.out.println("\nThank you for playing!");
        }
    }
}
