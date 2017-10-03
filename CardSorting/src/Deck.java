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
	private Card[] temp;

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

	public boolean isSorted() {

		return sorted;
	}

	public Card getCard(int i) {
		return cards[i];
	}

	public int getTopCard() {
		return topCard;

	}

	public void shuffle() {
		sorted = false;
		for (int i = DeckConstants.TOTAL_CARDS - 1; i > 0; i--) {
			int randomPos = (int) (Math.random() * DeckConstants.TOTAL_CARDS - 1) + 1;
			Card temp = cards[i];
			cards[i] = cards[randomPos];
			cards[randomPos] = temp;
		}

	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < topCard / DeckConstants.NUM_OF_SUITS + 1; i++) {
			result = result + cards[i];
			for (int j = 1; j < topCard / DeckConstants.RANK_PER_SUIT + 1; j++) {
				result = result + "\t\t" + cards[i + (j * topCard / DeckConstants.NUM_OF_SUITS)];

			}
			result = result + "\n";
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

	public Card pick() {
		int randPos = (int) (Math.random() * topCard);
		Card select = removeCard(randPos);
		return select;

	}

	public Card removeCard(int pos) {
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

	public void mergeSort() {
		mSort(cards);
		sorted = true;
	}

	private void mSort(Card[] c) {
		int n = c.length;
		temp = new Card[n];
		recursiveSort(c, 0, n - 1);
	}

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
