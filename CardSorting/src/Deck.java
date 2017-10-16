/**
 * Represents a group of Card objects
 * 
 * @author Sean Gibbons
 *
 */

public class Deck {
	private Card[] cards;
	private int topCard;// keeps track of the card currently in the last position
	private boolean sorted;
	private static Card[] temp;

	/**
	 * The no-args constructor which will automatically make a standard 52 card Deck
	 */
	public Deck() {
		resetDeck();
	}

	/**
	 * Constructor with one arg which creates and then shuffles the Deck
	 */

	public Deck(boolean sort) {
		this.resetDeck();
		if (!sort)
			this.shuffle();
	}

	public Deck(Deck o) {

	}

	/**
	 * Creates a standard 52 card deck
	 */
	public void resetDeck() {
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

	/**
	 * A simple check of whether the object is sorted
	 * 
	 * @return whether the object is sorted
	 */
	public boolean getSorted() {

		return sorted;
	}

	/**
	 * Returns the array of Cards
	 * 
	 * @return the array of Cards
	 */
	public Card[] getCards() {
		return cards;
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
			int randomPos = (int) (Math.random() * topCard);
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
				for (int j = DeckConstants.RANK_PER_SUIT; j < topCard - 1; j += DeckConstants.RANK_PER_SUIT) {
					result = result + "\t" + cards[i + j];
				}

				result = result + "\n";
			}
		}

		else
			for (int i = 0; i < topCard; i++) { // else prints in one column
				result = result + cards[i] + "\n";

			}

		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Deck) {
			Deck t1 = this;
			t1.selectionSort();
			;
			Deck t2 = (Deck) o;
			t2.selectionSort();
			// Sorts the decks to be compared to ensure decks are equal even if not in the
			// same order
			return t1.toString().equals((t2).toString());
		} else
			return false;

	}

	/**
	 * Selects a Card from a random position in the deck and removes it, collapsing
	 * the Deck around the new empty space
	 * 
	 * @return the randomly chosen Card
	 */
	public Card pick() {
		return removeCard((int) (Math.random() * topCard));

	}

	/**
	 * A helper method which removes a Card from a given position and collapses the
	 * Deck around the new empty space, used in pick() and deal()
	 * 
	 * @param pos
	 *            the position of the card to be removed in the current deck
	 * @return the Card that has been removed
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

	/********************************************************
	 * SELECTION SORT
	 ********************************************************/

	/**
	 * Sorts the array of Cards using the selectionSort algorithm
	 */
	public void selectionSort() {
		sorted = true;
		for (int n = topCard; n > 0; n--) {
			for (int i = 0; i < n; i++) {
				if (cards[i].compareTo(cards[n]) < 0) {
					Card aTemp = cards[i];
					cards[i] = cards[n];
					cards[n] = aTemp;
				}
			}

		}
	}

	/**************************************************
	 * MERGE SORT
	 **************************************************/
	/**
	 * Sorts the cards of a given Deck using the mergeSort algorithm
	 * 
	 */

	public static void mergeSort(Deck d1) {
		int n = d1.cards.length;
		temp = new Card[d1.getTopCard() + 1];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = d1.cards[i];
		}
		recursiveSort(temp, 0, n - 1);
		d1.cards = temp;
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

	private static void merge(Card arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		Card first[] = new Card[n1];
		Card second[] = new Card[n2];

		for (int i = 0; i < n1; ++i)
			first[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			second[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (first[i].compareTo(second[j]) == -1) {
				arr[k] = first[i];
				i++;
			} else {
				arr[k] = second[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = first[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = second[j];
			j++;
			k++;
		}
	}

	// Sorts a[0], ..., a[a.length-1] in ascending order
	// using the Mergesort algorithm.
	public static void sort(double[] a) {
		int n = a.length;
		temp = new double[n];
		recursiveSort(a, 0, n - 1);
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
	private static void recursiveSort(Card[] a, int from, int to) {
		if (to - from < 2) // Base case: 1 or 2 elements
		{
			if (to > from && a[to] < a[from]) {
				// swap a[to] and a[from]
				double aTemp = a[to];
				a[to] = a[from];
				a[from] = aTemp;
			}
		} else // Recursive case
		{
			int middle = (from + to) / 2;
			recursiveSort(a, from, middle);
			recursiveSort(a, middle + 1, to);
			merge(a, from, middle, to);
		}
	}

	// Merges a[from] ... a[middle] and a[middle+1] ... a[to]
	// into one sorted array a[from] ... a[to]
	private static void merge(double[] a, int from, int middle, int to) {
		int i = from, j = middle + 1, k = from;

		// While both arrays have elements left unprocessed:
		while (i <= middle && j <= to) {
			if (a[i] < a[j]) {
				temp[k] = a[i]; // Or simply temp[k] = a[i++];
				i++;
			} else {
				temp[k] = a[j];
				j++;
			}
			k++;
		}

		// Copy the tail of the first half, if any, into temp:
		while (i <= middle) {
			temp[k] = a[i]; // Or simply temp[k++] = a[i++]
			i++;
			k++;
		}

		// Copy the tail of the second half, if any, into temp:
		while (j <= to) {
			temp[k] = a[j]; // Or simply temp[k++] = a[j++]
			j++;
			k++;
		}

		// Copy temp back into a
		for (k = from; k <= to; k++)
			a[k] = temp[k];
	}

}
