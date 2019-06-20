import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {

    private Player player;
    private Deck cards;
    private boolean testHandConstructor;
    private Scanner scanner = new Scanner(System.in);

    public Game(String[] testHand) {
        player = new Player();
        cards = new Deck();
        testHandConstructor = true;
        for (int i = 0; i < 5; i++) {
            String suit = testHand[i].substring(0, 1);
            int suitValue;
            String rank = testHand[i].substring(1);

            switch (suit) {
                case "c":
                    suitValue = 0;
                    break;
                case "d":
                    suitValue = 1;
                    break;
                case "h":
                    suitValue = 2;
                    break;
                default:
                    suitValue = 3;
                    break;
            }

            int rankValue = Integer.parseInt(rank);
            Card card = new Card(suitValue, rankValue);
            player.addCard(card);
        }
    }

    public Game() {
        player = new Player();
        cards = new Deck();
        testHandConstructor = false;
    }

    public void play() {
        if (!testHandConstructor) {
            System.out.println("Welcome to video poker game!");
            int playerChoice = resolveChoice();

            while (playerChoice == 1) { // while they do want to play...

                System.out.println("You have " + player.getPlayerBalance() + " tokens in your bankroll.");
                System.out.println("Enter bet amount, You can bet between 1 and " + player.getPlayerBalance() + " tokens:");

                double betAmount = bet();
                for (int j = 0; j < 5; j++) { // deal card into player's hand 5x
                    player.addCard(cards.deal());
                }

                ArrayList<Card> hand = player.getHand();
                Collections.sort(hand);
                System.out.println("Your hand is: " + hand);
                askRedraw();
                Collections.sort(hand);
                System.out.println("Your hand is now: " + hand);
                double multiplier = player.checkHand();
                if (multiplier >-1) {
                    player.winnings(multiplier, betAmount);
                }
                System.out.println("Your bankroll now has " + player.getPlayerBalance() + " tokens.");
                System.out.println("Thanks for playing! Do you want to play " + "again? (Enter 1 for yes, 0 for no)");
                playerChoice = resolveChoice();
                if (playerChoice == 1) {
                    player.newHand();
                }
            }
        } else {
            player.checkHand();
        }
    }

    private void askRedraw() {
        for (int i = 0; i < 5; i++) {
            int cardNumber = i + 1;
            System.out.println("Do you want to change card " + cardNumber + "? " + "(Enter 1 for yes, 0 for no)");
            int redrawAnswer = resolveChoice();
            if (redrawAnswer == 1) { // if they want to redraw this card...
                player.redraw(i, cards.deal());
            }
        }
    }

    private int resolveChoice() {
        System.out.println("Enter 1 for yes, 0 for no");
        while (true) {
            String choice = scanner.next();
            try {
                int value = Integer.parseInt(choice);
                if (value == 0 || value == 1) {
                    return value;
                } else {
                    System.out.println("Please enter 1 or 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong enter, try again");
                System.out.println("Do you want to play? " + "(Enter 1 for yes, 0 for no)");
            }
        }
    }

    private double bet() {
        while (true) {
            String input = scanner.next();
            double betAmount;
            try {
                betAmount = Double.parseDouble(input);
                double b = player.getPlayerBalance();
                if (betAmount > b || betAmount <= 0) {
                    System.out.println("Wrong enter, try again");
                    System.out.println("Enter bet amount, You can bet between 1 and " + player.getPlayerBalance() + " tokens:");
                } else {
                    return betAmount;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong enter, try again");
                System.out.println("Enter bet amount, You can bet between 1 and " + player.getPlayerBalance() + " tokens:");
            }
        }
    }
}
