
/**
 * Card class as part of Assignment 2
 * 
 * @author gibbonss
 *
 */
public class Card {
	private int rank;
	private String suit;

	/**
	 * Default constructor creates Ace of Spades
	 */
	public Card() {
		rank = 1;
		suit = "Spades";
	}

	// TODO write comments for constructors
	
	public Card(int suit, int rank) {
		switch (suit) {
		case 0:
			this.suit = "CLUBS";
			break;
		case 1:
			this.suit = "DIAMONDS";
			break;
		case 2:
			this.suit = "HEARTS";
			break;
		case 3:
			this.suit = "SPADES";
			break;
		default:
			this.suit = "SPADES";
			break;
		}
		this.rank = rank;

	}

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

	public Card(int suit, String rank) {

		switch (suit) {
		case 0:
			this.suit = "CLUBS";
			break;
		case 1:
			this.suit = "DIAMONDS";
			break;
		case 2:
			this.suit = "HEARTS";
			break;
		case 3:
			this.suit = "SPADES";
			break;
		default:
			this.suit = "SPADES";
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


	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;

	}

	
	
	//TODO write comments for getters and setters
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * @return
	 */
	public String getRankStr() {
		switch (getRank()) {
		case 1:
			return "Ace";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		case 10:
			return "Ten";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
		default:
			return "Ace";
		}
	}

	/**
	 * Converts the Suit to an integer value
	 * 
	 * @return The int value to the Suit
	 */
	public int getSuitInt() {
		switch (getSuit().toUpperCase()) {
		case "CLUBS":
			return 0;
		case "DIAMONDS":
			return 1;
		case "HEARTS":
			return 2;
		case "SPADES":
			return 3;
		default:
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getRankStr() + " of " + getSuit();
	}

}
