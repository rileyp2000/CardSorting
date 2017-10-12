
public class DeckTester {

	public static void main(String[] args) {

		/**
		 * TESTS Card.compareTo(Card o) Card c1 = new Card(2, 13); Card c2 = new Card(2,
		 * 10); System.out.println(c1 + " " + c2); System.out.println(c1.compareTo(c2));
		 * 
		 * 
		 */

		/**
		 * TESTS sort Deck d1 = new Deck(); // Deck d2 = new Deck();
		 * 
		 * System.out.println(d1); d1.shuffle(); System.out.println(d1);
		 * d1.selectionSort(); System.out.println(d1);
		 * 
		 */

		Deck d1 = new Deck();
		System.out.println(d1);
		d1.shuffle();
		Deck[] warGame = d1.deal(2, 25);
		System.out.println(warGame[0]);
		System.out.println(warGame[1]);
		System.out.println(d1);

	}
}
