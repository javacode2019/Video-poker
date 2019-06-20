public class Card implements Comparable<Card> {

    private int suit;
    private int rank;

    public Card(int s, int r) {
        suit = s;
        rank = r;
    }

    public int compareTo(Card c) {
        int answer = 0;
        if (this.rank < c.rank) {
            answer = -1;
        } else if (this.rank > c.rank) {
            answer = 1;
        } else {
            if (this.suit < c.suit) {
                answer = -1;
            } else if (this.suit > c.suit) {
                answer = 1;
            }
        }
        return answer;
    }

    public String toString() {
        String cardSuit;
        String cardRank;

        switch (this.suit) {
            case 0:
                cardSuit = "♠";
                break;
            case 1:
                cardSuit = "♦";
                break;
            case 2:
                cardSuit = "♥";
                break;
            case 3:
                cardSuit = "♣";
                break;
            default:
                throw new IllegalArgumentException("Wrong suit!");
        }
        switch (this.rank) {
            case 0:
                cardRank = "A";
                break;
            case 1:
                cardRank = "2";
                break;
            case 2:
                cardRank = "3";
                break;
            case 3:
                cardRank = "4";
                break;
            case 4:
                cardRank = "5";
                break;
            case 5:
                cardRank = "6";
                break;
                case 6:
                cardRank = "7";
                break;
            case 7:
                cardRank = "8";
                break;
            case 8:
                cardRank = "9";
                break;
            case 9:
                cardRank = "10";
                break;
            case 10:
                cardRank = "J";
                break;
            case 11:
                cardRank = "Q";
                break;
            case 12:
                cardRank = "K";
                break;

            default:
                throw new IllegalArgumentException("Wrong rank!");
        }

        String description;
        description = cardRank + cardSuit;
        return description;
    }

    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }
}
