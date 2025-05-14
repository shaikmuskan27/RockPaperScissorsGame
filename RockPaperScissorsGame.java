
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
        // Initialize a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        // Initialize a random number generator for the computer's choice
        Random random = new Random();
        // Array of possible choices for the game
        String[] choices = { "rock", "paper", "scissors" };
        // Variable to store the number of rounds
        int rounds = 3;
        // Variables to store the scores
        int playerScore = 0;
        int computerScore = 0;

        System.out.println("Welcome to Rock, Paper, Scissors!");

        // Game loop for multiple rounds
        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round + ":");
            // Get the player's choice
            String playerChoice = getPlayerChoice(scanner, choices);
            if (playerChoice == null) {
                System.out.println("Invalid input. Please try again. ");
                round--;
                continue;
            }

            // Generate the computer's choice randomly
            int computerIndex = random.nextInt(choices.length);
            String computerChoice = choices[computerIndex];

            // Display the choices
            System.out.println("You chose: " + playerChoice);
            System.out.println("The computer chose: " + computerChoice);

            // Determine the winner of the round
            String roundResult = determineWinner(playerChoice, computerChoice);
            System.out.println(roundResult);

            // Update the scores
            if (roundResult.contains("You win")) {
                playerScore++;
            } else if (roundResult.contains("Computer wins")) {
                computerScore++;
            }
            // Display the scores
            System.out.println("Score: Player " + playerScore + " - Computer " + computerScore);
        }
        // Determine the overall winner
        displayOverallWinner(playerScore, computerScore);
        // Close the scanner
        scanner.close();
    }

    public static String getPlayerChoice(Scanner scanner, String[] choices) {
        System.out.print("Enter your choice (rock, paper, or scissors): ");
        String playerChoice = scanner.nextLine().trim().toLowerCase();
        // Input validation: Check if the choice is valid
        for (String validChoice : choices) {
            if (validChoice.equals(playerChoice)) {
                return playerChoice;
            }
        }
        return null; // Return null for invalid input
    }

    public static String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "You win this round!";
        } else {
            return "Computer wins this round!";
        }
    }

    public static void displayOverallWinner(int playerScore, int computerScore) {
        System.out.println("\nGame Over!");
        if (playerScore > computerScore) {
            System.out.println("Congratulations! You win the game!");
        } else if (computerScore > playerScore) {
            System.out.println("Sorry, the computer wins the game!");
        } else {
            System.out.println("It's a tie game!");
        }
    }
}
