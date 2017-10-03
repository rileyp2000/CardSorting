
public class DeckTester {

	public static void main(String[] args) {

		/**
		 * TESTS Card.compareTo(Card o) Card c1 = new Card(2, 13); Card c2 = new Card(2,
		 * 10); System.out.println(c1 + " " + c2); System.out.println(c1.compareTo(c2));
		 * 
		 * 
		 */

		/** TESTS sort */
		Deck d1 = new Deck(); // Deck d2 = new Deck();

		System.out.println(d1);
		d1.shuffle();
		System.out.println(d1);
		d1.mergeSort();
		System.out.println(d1);
		/****
		 * TESTS .deal() Deck[] warGame = d1.deal(2, d1.getTopCard()/2);
		 * System.out.println(warGame[0]); /* System.out.println(d1.equals(d2));
		 * d1.shuffle(); System.out.println(); System.out.println();
		 * System.out.println(d1); System.out.println(d1.equals(d2));
		 */

	}
}
