
public class DeckTester {

	public static void main(String[] args) {

		Deck d1 = new Deck();
		// Deck d2 = new Deck();

		System.out.println(d1);
		for (int i = 0; i < 5; i++)
			System.out.println(d1.pick());
		System.out.println();
		System.out.println(d1);

		Deck[] war = d1.deal(2, 26);
		System.out.println(war[0]);

		/*
		 * System.out.println(d1.equals(d2)); d1.shuffle(); System.out.println();
		 * System.out.println(); System.out.println(d1);
		 * System.out.println(d1.equals(d2));
		 */

	}
}
