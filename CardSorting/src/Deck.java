/**
 * Represents a group of Card objects
 * 
 * @author srgib
 *
 */
public class Deck {
	private Card[] cards;
	private int topCard;// essentially cards.length
	private boolean sorted;

	public Deck() {
		cards = new Card[DeckConstants.NUM_OF_SUITS * DeckConstants.RANK_PER_SUIT];
		for (int i = 1; i < DeckConstants.NUM_OF_SUITS + 1; i++) {
			for (int j = 0; j < DeckConstants.RANK_PER_SUIT; i++)
				cards[i * j] = new Card(i, j);
		}

		sorted = true;
	}

	public Card getCard(int i) {
		return cards[i];
	}

	public void shuffle() {
		sorted = false;
		for (int i = cards.length; i > 0; i--) {
			Card[] dupl = cards;
			cards[i] = dupl[i - 1];
		}

	}

	@Override
	public String toString() {
	return 	
	}
}

}
