import java.util.ArrayList;
import java.util.Collections;

public class Player extends CheckHand {

	private ArrayList<Card> hand;
	private double playerBalance;


	public Player() {
		hand = new ArrayList<>();
		playerBalance = 1000.0;

	}

	public void addCard(Card c) {
		hand.add(c);
	}


	public void newHand() {
		hand = new ArrayList<>();
	}



	public void winnings(double multipler,double bet) {
		playerBalance = playerBalance + (multipler * bet)-bet;
		System.out.println("You win: "+(multipler*bet));
	}

	public double getPlayerBalance() {
		return playerBalance;
	}

	public void redraw(int position, Card c) {
		hand.set(position, c);
	}

	public ArrayList<Card> getHand() {
		return hand;
	}


	public double checkHand() {
		double multiplier = 0.0;
		Collections.sort(hand);
		String checkedHand = "";

		if (checkRoyalFlush(hand)) {
			checkedHand = "royal flush!";
			multiplier = 250;
		} else if (checkStraightFlush(hand)) {
			checkedHand = "straight flush!";
			multiplier = 50;
		} else if (checkFourOfAKind(hand)) {
			checkedHand = "four of a kind!";
			multiplier = 25;
		} else if (checkFullHouse(hand)) {
			checkedHand = "full house!";
			multiplier = 6;
		} else if (checkFlush(hand)) {
			checkedHand = "flush!";
			multiplier = 5;
		} else if (checkStraight(hand)) {
			checkedHand = "straight!";
			multiplier = 4;
		} else if (checkThreeOfAKind(hand)) {
			checkedHand = "three of a kind!";
			multiplier = 3;
		} else if (checkTwoPair(hand)) {
			checkedHand = "two pair!";
			multiplier = 2;
		} else if (checkJJOrBetter(hand)) {
			checkedHand = "JJ or better";
			multiplier = 1;
		} else {

			System.out.println("You do not win, try again");
		}
		System.out.println("You have a " + checkedHand+ "  Multiplier is: " +multiplier);
		return multiplier;
	}


}
