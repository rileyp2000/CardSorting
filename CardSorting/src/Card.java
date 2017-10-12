
/**
 * Card class as part of Assignment 2
 * 
 * @author Sean Gibbons
 *
 */
public class Card implements Comparable<Card> {
	private int rank;
	private String suit;

	/**
	 * Default constructor creates Ace of Spades
	 */
	public Card() {
		rank = 1;
		suit = "Spades";
	}

	/**
	 * Constructor for int suit and int rank
	 * 
	 * @param suit
	 *            an int which, when fed into a switch statement, is converted into
	 *            the appropriate suit
	 * @param rank
	 *            an int which will become the rank
	 */
	public Card(int suit, int rank) {
		switch (suit) {
		case 0:
			this.suit = "CLUBS   ";
			break;
		case 1:
			this.suit = "DIAMONDS";
			break;
		case 2:
			this.suit = "HEARTS  ";
			break;
		case 3:
			this.suit = "SPADES  ";
			break;
		default:
			this.suit = "SPADES  ";
			break;
		}
		this.rank = rank;

	}

	/**
	 * Constructor for String suit and String rank
	 * 
	 * @param suit
	 *            a String which will become the Card's suit
	 * @param rank
	 *            a String which will be converted into the appropriate int and
	 *            assigned to the rank field
	 */
	public Card(String suit, String rank) {
		this.suit = suit.toUpperCase();
		rank = rank.toUpperCase();
		switch (rank) {
		case "ACE":
			this.rank = 1;
			break;
		case "TWO":
			this.rank = 2;
			break;
		case "THREE":
			this.rank = 3;
			break;
		case "FOUR":
			this.rank = 4;
			break;
		case "FIVE":
			this.rank = 5;
			break;
		case "SIX":
			this.rank = 6;
			break;
		case "SEVEN":
			this.rank = 7;
			break;
		case "EIGHT":
			this.rank = 8;
			break;
		case "NINE":
			this.rank = 9;
			break;
		case "TEN":
			this.rank = 10;
			break;
		case "JACK":
			this.rank = 11;
			break;
		case "QUEEN":
			this.rank = 12;
			break;
		case "KING":
			this.rank = 13;
			break;
		default:
			this.rank = 0;
			break;
		}

	}

	/**
	 * Constructor for int suit and String rank
	 * 
	 * @param suit
	 *            an int which, when fed into a switch statement, is converted into
	 *            the appropriate suit
	 * @param rank
	 *            a String which will be converted into the appropriate int and
	 *            assigned to the rank field
	 */
	public Card(int suit, String rank) {

		switch (suit) {
		case 0:
			this.suit = "CLUBS   ";
			break;
		case 1:
			this.suit = "DIAMONDS";
			break;
		case 2:
			this.suit = "HEARTS  ";
			break;
		case 3:
			this.suit = "SPADES  ";
			break;
		default:
			this.suit = "SPADES  ";
			break;
		}

		rank = rank.toUpperCase();
		switch (rank) {
		case "ACE":
			this.rank = 1;
			break;
		case "TWO":
			this.rank = 2;
			break;
		case "THREE":
			this.rank = 3;
			break;
		case "FOUR":
			this.rank = 4;
			break;
		case "FIVE":
			this.rank = 5;
			break;
		case "SIX":
			this.rank = 6;
			break;
		case "SEVEN":
			this.rank = 7;
			break;
		case "EIGHT":
			this.rank = 8;
			break;
		case "NINE":
			this.rank = 9;
			break;
		case "TEN":
			this.rank = 10;
			break;
		case "JACK":
			this.rank = 11;
			break;
		case "QUEEN":
			this.rank = 12;
			break;
		case "KING":
			this.rank = 13;
			break;
		default:
			this.rank = 0;
			break;
		}
	}

	/**
	 * Constructor for String suit and int rank
	 * 
	 * @param suit
	 *            a String which is to be the Card's suit
	 * @param rank
	 *            an int which is to be the Card's rank
	 */
	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;

	}

	/**
	 * Returns the rank
	 * 
	 * @return the int value of rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Returns the suit
	 * 
	 * @return the suit as a String
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * Converts the int rank to the appropriate String
	 * 
	 * @return the String counterpart to the rank
	 */
	public String getRankStr() {
		switch (getRank()) {
		case 1:
			return "Ace  ";
		case 2:
			return "Two  ";
		case 3:
			return "Three";
		case 4:
			return "Four ";
		case 5:
			return "Five ";
		case 6:
			return "Six  ";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine ";
		case 10:
			return "Ten  ";
		case 11:
			return "Jack ";
		case 12:
			return "Queen";
		case 13:
			return "King ";
		default:
			return "Ace  ";
		}
	}

	/**
	 * Converts the Suit to an integer value
	 * 
	 * @return The int value to the Suit
	 */
	public int getSuitInt() {
		switch (getSuit().toUpperCase()) {
		case "CLUBS   ":
			return 0;
		case "DIAMONDS":
			return 1;
		case "HEARTS  ":
			return 2;
		case "SPADES  ":
			return 3;
		default:
			return 0;
		}
	}

	@Override
	public String toString() {
		return getRankStr() + " of " + getSuit();
	}

	@Override
	public int compareTo(Card o) {
		if (getSuitInt() - o.getSuitInt() == 0)
			return (int) Math.signum(rank - o.rank);
		else
			return (int) Math.signum(getSuitInt() - o.getSuitInt());
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Card))
			return false;
		else
			return this.compareTo((Card) o) == 0;

	}

}
