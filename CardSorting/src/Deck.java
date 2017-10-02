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

	public Deck() {
		topCard = DeckConstants.TOTAL_CARDS - 1;
		cards = new Card[DeckConstants.TOTAL_CARDS];
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
				result = result + "\t\t" + cards[i + j * topCard / DeckConstants.NUM_OF_SUITS];

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
		Card select = cards[randPos];
		Card[] smallDeck = new Card[topCard--];
		for (int i = topCard; i > randPos; i--) {
			smallDeck[i - 1] = cards[i];
		}
		for (int i = 0; i < randPos; i++) {
			smallDeck[i] = cards[i];
		}
		cards = smallDeck;

		return select;

	}

	public Deck[] deal(int numHands, int numPerHand) {
		Deck[] hands = new Deck[numHands];
		Deck dealer = this;
		for (int i = 0; i < numHands; i++) {
			Deck temp = new Deck();
			temp.cards = new Card[numPerHand];
			temp.sorted = false;
			for (int j = 0; j < numPerHand; j++) {
				temp.cards[j] = dealer.pick();
			}
			hands[i] = temp;
		}

		return hands;
	}

}
