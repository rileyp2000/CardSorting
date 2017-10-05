/**
 * Represents a group of Card objects
 * 
 * @author Sean Gibbons
 *
 */
/**
 * @author gibbonss
 *
 */
/**
 * @author gibbonss
 *
 */
public class Deck {
	private Card[] cards;
	private int topCard;// keeps track of the card currently in the last position
	private boolean sorted;
	private Card[] temp;

	/**
	 * The no-args constructor which will automatically make a standard 52 card Deck
	 */
	public Deck() {
		cards = new Card[DeckConstants.TOTAL_CARDS];
		topCard = cards.length - 1;
		int r = 1;
		int s = 0;
		for (int i = 0; i < DeckConstants.TOTAL_CARDS; i++) {
			cards[i] = new Card(s, r);
			r++;
			if (r > DeckConstants.RANK_PER_SUIT) {
				r = 1;
				s++;
			}
		}
		sorted = true;

	}

	public Deck(boolean sort) {
		new Deck();
		if (!sort) {
			this.shuffle();
		}

	}

	/**
	 * A simple check of whether the object is sorted
	 * 
	 * @return whether the object is sorted
	 */
	public boolean isSorted() {

		return sorted;
	}

	/**
	 * The topCard is the card at the last position in the cards array, equal to
	 * cards.length-1
	 * 
	 * @return the current topCard
	 */
	public int getTopCard() {
		return topCard;

	}

	/**
	 * Randomly shuffles the cards in the deck
	 */
	public void shuffle() {
		sorted = false;
		for (int i = topCard - 1; i > 0; i--) {
			int randomPos = (int) (Math.random() * topCard) + 1;
			Card temp = cards[i];
			cards[i] = cards[randomPos];
			cards[randomPos] = temp;
		}

	}

	@Override
	public String toString() {

		String result = "";

		if (topCard == DeckConstants.TOTAL_CARDS - 1) { // Prints in four columns if the Deck is full
			for (int i = 0; i < topCard / DeckConstants.NUM_OF_SUITS + 1; i++) {
				result = result + cards[i];
				for (int j = 0; j < topCard; j += DeckConstants.RANK_PER_SUIT) {
					result = result + "\t" + cards[i + j];
				}

				result = result + "\n";
			}
		}

		else
			for (Card c : cards) { // else prints in one column
				result = result + c + "\n";

			}

		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Deck) {
			return this.toString().equals(((Deck) o).toString());
		} else
			return false;

	}

	/**
	 * Selects a Card from a random position in the deck and removes it
	 * 
	 * @return the randomly chosen Card
	 */
	public Card pick() {
		return removeCard((int) (Math.random() * topCard));

	}

	/**
	 * A helper method which removes a Card from a given position, used in pick()
	 * and deal()
	 * 
	 * @param pos
	 *            the position of the card to be removed in the current deck
	 * @return
	 */
	private Card removeCard(int pos) {
		Card select = cards[pos];
		Card[] smallDeck = new Card[topCard--];
		for (int i = topCard; i > pos; i--) {
			smallDeck[i - 1] = cards[i];
		}
		for (int i = 0; i < pos; i++) {
			smallDeck[i] = cards[i];
		}
		cards = smallDeck;
		return select;
	}

	/**
	 * A method which deals cards from the top of the deck into a given number of
	 * hands
	 * 
	 * @param numHands
	 *            the number of hands to be dealt
	 * @param numPerHand
	 *            the number of cards per hand to be dealt
	 * @return an Array of Decks, each with a specific number of cards per hand
	 */
	public Deck[] deal(int numHands, int numPerHand) {
		Deck[] hands = new Deck[numHands];
		for (int i = 0; i < numHands; i++) {
			Deck temp = new Deck();
			temp.cards = new Card[numPerHand];
			temp.sorted = false;
			for (int j = 0; j < numPerHand; j++) {
				temp.cards[j] = this.removeCard(topCard);
			}
			hands[i] = temp;
			hands[i].topCard = temp.cards.length - 1;
		}

		return hands;
	}

	/***********************************************************
	 * SELECTION SORT
	 ************/

	/**
	 * Sorts the array of Cards using the selectionSort algorithm
	 */
	public void selectionSort() {
		sSort(cards);
		sorted = true;
	}

	/**
	 * A sorting algorithm that sorts the cards in ascending order. Created with
	 * help from "Java Methods: Object-Oriented Programming and Data Structures, 3rd
	 * AP Edition"
	 * 
	 * 
	 * @param c
	 *            the array of cards to be sorted
	 */
	public void sSort(Card[] c) {
		for (int n = c.length; n > 1; n--) {
			int iMax = 0;
			for (int i = 1; i < n; i++) {
				if (c[i].compareTo(c[iMax]) == -1)
					iMax = i;
			}
			Card aTemp = c[iMax];
			c[iMax] = c[n - 1];
			c[n - 1] = aTemp;

		}
	}

	/**************************************************
	 * MERGE SORT
	 ************************/
	/**
	 * Sorts the cards using the mergeSort algorithm
	 */
	public void mergeSort() {
		mSort(cards);
		sorted = true;
	}

	/**
	 * A sorting algorithm that sorts the cards in ascending order. Created with
	 * help from "Java Methods: Object-Oriented Programming and Data Structures, 3rd
	 * AP Edition"
	 * 
	 * 
	 * @param c
	 *            the array of cards to be sorted
	 */
	private void mSort(Card[] c) {
		int n = c.length;
		temp = new Card[n];
		recursiveSort(c, 0, n - 1);
	}

	/**
	 * A recursive method which divides the array into smaller arrays until they are
	 * either 1 or 2 elements in length. These elements are swapped as appropriate
	 * and then merged back into the larger whole.
	 * 
	 * @param c
	 *            the array of cards to be sorted
	 * @param start
	 *            the position of the first card to be sorted
	 * @param end
	 *            the position of the last card to be sorted
	 */
	private void recursiveSort(Card[] c, int start, int end) {
		if (end - start < 2) {
			if (end > start && c[end].compareTo(c[start]) == -1) {

				Card t = c[end];
				c[end] = c[start];
				c[start] = t;
			}
		} else {
			int middle = (start + end) / 2;
			recursiveSort(c, start, middle);
			recursiveSort(c, middle + 1, end);
			merge(c, start, middle, end);
		}
	}

	/**
	 * A method that combines the elements of an array back together into ascending
	 * order
	 * 
	 * @param c
	 *            the array of cards to be sorted
	 * @param start
	 *            the position of the first card to be sorted
	 * @param middle
	 *            the position of the middle of the array of cards
	 * @param end
	 *            the position of the last card
	 */
	private void merge(Card[] c, int start, int middle, int end) {
		int i = start;
		int j = middle + 1;
		int k = start;

		while (i <= middle && j <= end) {
			if (c[i].compareTo(c[j]) == -1) {
				temp[k] = c[i++];
			} else {
				temp[k] = c[j++];
			}
			k++;
		}

		while (i <= middle) {
			temp[k++] = c[i++];
		}

		while (j <= end) {
			temp[k++] = c[j++];
		}

		for (k = start; k <= end; k++)
			c[k] = temp[k];
	}
}
