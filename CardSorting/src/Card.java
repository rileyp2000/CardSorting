/**
 * 
 */

/**
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

	// TODO constructors (int, int), (String, String), (int, String), (String,int)

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
	 * @return
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
