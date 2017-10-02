
public class DeckTester {

	public static void main(String[] args) {

		Deck d1 = new Deck();
		// Deck d2 = new Deck();

		System.out.println(d1);

		Deck[] warGame = d1.deal(2, d1.getTopCard()/2);
		System.out.println(warGame[0]);
		/*
		 * System.out.println(d1.equals(d2)); d1.shuffle(); System.out.println();
		 * System.out.println(); System.out.println(d1);
		 * System.out.println(d1.equals(d2));
		 */

	}
}
