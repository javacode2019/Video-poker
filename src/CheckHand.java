import java.util.ArrayList;

public class CheckHand {

     boolean checkRoyalFlush(ArrayList<Card> hand) {
        boolean royalFlush = false;
        if ((hand.get(0).getSuit() == hand.get(1).getSuit()) && (hand.get(1).getSuit() == hand.get(2).getSuit())
                && (hand.get(2).getSuit() == hand.get(3).getSuit()) && (hand.get(3).getSuit() == hand.get(4).getSuit())
                && (hand.get(0).getRank() == 0) && (hand.get(1).getRank() == 9) && (hand.get(2).getRank() == 10)
                && (hand.get(3).getRank() == 11) && (hand.get(4).getRank() == 12)) {
            royalFlush = true;
        }
        return royalFlush;
    }

    public boolean checkStraightFlush(ArrayList<Card> hand) {
        boolean straightFlush = false;
        if ((hand.get(0).getSuit() == hand.get(1).getSuit()) && // for ace low
                (hand.get(1).getSuit() == hand.get(2).getSuit()) && (hand.get(2).getSuit() == hand.get(3).getSuit())
                && (hand.get(3).getSuit() == hand.get(4).getSuit()) && // suits match
                (hand.get(0).getRank() == (hand.get(1).getRank() - 1))
                && (hand.get(1).getRank() == (hand.get(2).getRank() - 1))
                && (hand.get(2).getRank() == (hand.get(3).getRank() - 1))
                && (hand.get(3).getRank() == (hand.get(4).getRank() - 1))) { // sequence
            straightFlush = true;
        }
        if ((hand.get(0).getSuit() == hand.get(1).getSuit()) && // for ace high
                (hand.get(1).getSuit() == hand.get(2).getSuit()) && (hand.get(2).getSuit() == hand.get(3).getSuit())
                && (hand.get(3).getSuit() == hand.get(4).getSuit()) && // suits match
                (hand.get(1).getRank() == (hand.get(2).getRank() - 1))
                && (hand.get(2).getRank() == (hand.get(3).getRank() - 1))
                && (hand.get(3).getRank() == (hand.get(4).getRank() - 1))
                && (hand.get(4).getRank() == (hand.get(0).getRank() - 1))) {// sequence
            straightFlush = true;
        }
        return straightFlush;
    }

    public boolean checkFourOfAKind(ArrayList<Card> hand) {
        boolean fourOfAKind = false;
        if (((hand.get(0).getRank() == hand.get(1).getRank()) && // (xxxx y)
                (hand.get(1).getRank() == hand.get(2).getRank()) && (hand.get(2).getRank() == hand.get(3).getRank()))
                || ((hand.get(1).getRank() == hand.get(2).getRank()) && // (y xxxx)
                (hand.get(2).getRank() == hand.get(3).getRank())
                && (hand.get(3).getRank() == hand.get(4).getRank()))) {
            fourOfAKind = true;
        }
        return fourOfAKind;
    }

    public boolean checkFullHouse(ArrayList<Card> hand) {
        boolean fullHouse = false;
        if (((hand.get(0).getRank() == hand.get(1).getRank()) && // (xxx yy)
                (hand.get(1).getRank() == hand.get(2).getRank()) && (hand.get(3).getRank() == hand.get(4).getRank()))
                || ((hand.get(0).getRank() == hand.get(1).getRank()) && // (yy xxx)
                (hand.get(2).getRank() == hand.get(3).getRank())
                && (hand.get(3).getRank() == hand.get(4).getRank()))) {
            fullHouse = true;
        }
        return fullHouse;
    }

    public boolean checkFlush(ArrayList<Card> hand) {
        boolean flush = false;
        if ((hand.get(0).getSuit() == hand.get(1).getSuit()) && (hand.get(1).getSuit() == hand.get(2).getSuit())
                && (hand.get(2).getSuit() == hand.get(3).getSuit())
                && (hand.get(3).getSuit() == hand.get(4).getSuit())) {
            flush = true;
        }
        return flush;
    }

    public boolean checkStraight(ArrayList<Card> hand) {
        boolean straight = false;
        if ((hand.get(0).getRank() == (hand.get(1).getRank() - 1)) && // normal
                (hand.get(1).getRank() == (hand.get(2).getRank() - 1))
                && (hand.get(2).getRank() == (hand.get(3).getRank() - 1))
                && (hand.get(3).getRank() == (hand.get(4).getRank() - 1))) {
            straight = true;
        }
        if ((hand.get(1).getRank() == (hand.get(2).getRank() - 1)) && // ace high
                (hand.get(2).getRank() == (hand.get(3).getRank() - 1))
                && (hand.get(3).getRank() == (hand.get(4).getRank() - 1))
                && (hand.get(4).getRank() == (hand.get(0).getRank() - 1))) {
            straight = true;
        }
        return straight;
    }

    public boolean checkThreeOfAKind(ArrayList<Card> hand) {
        boolean threeOfAKind = false;
        if (((hand.get(0).getRank() == hand.get(1).getRank()) && // (rrr x y)
                (hand.get(1).getRank() == hand.get(2).getRank()))
                || ((hand.get(1).getRank() == hand.get(2).getRank()) && // (x rrr y)
                (hand.get(2).getRank() == hand.get(3).getRank()))
                || ((hand.get(2).getRank() == hand.get(3).getRank()) && // (x y rrr)
                (hand.get(3).getRank() == hand.get(4).getRank()))) {
            threeOfAKind = true;
        }
        return threeOfAKind;
    }

    public boolean checkTwoPair(ArrayList<Card> hand) {
        boolean twoPair = false;
        if (((hand.get(1).getRank() == hand.get(2).getRank()) && // (r xx yy)
                (hand.get(3).getRank() == hand.get(4).getRank()))
                || ((hand.get(0).getRank() == hand.get(1).getRank()) && // (xx r yy)
                (hand.get(3).getRank() == hand.get(4).getRank()))
                || ((hand.get(0).getRank() == hand.get(1).getRank()) && // (xx yy r)
                (hand.get(2).getRank() == hand.get(3).getRank()))) {
            twoPair = true;
        }
        return twoPair;
    }

    public boolean checkJJOrBetter(ArrayList<Card> hand) {
        boolean JJ = false;
        if((hand.get(0).getRank() ==0  ||hand.get(0).getRank() > 10 ||
        hand.get(1).getRank() ==0  ||hand.get(1).getRank() > 10 ||
                hand.get(2).getRank() ==0  ||hand.get(2).getRank() > 10 ||
                hand.get(3).getRank() ==0  ||hand.get(3).getRank() > 10)) {
            if ((hand.get(0).getRank() == hand.get(1).getRank()) || // (xx abc)
                    (hand.get(1).getRank() == hand.get(2).getRank()) || // (a xx bc)
                    (hand.get(2).getRank() == hand.get(3).getRank()) || // (ab xx c)
                    (hand.get(3).getRank() == hand.get(4).getRank())) { // (abc xx)
                JJ = true;
            }
        }
        return JJ;
    }
}
