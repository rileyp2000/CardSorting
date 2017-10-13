import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DeckTester {

	public static void main(String[] args) {
		PrintWriter out = outputFile("output.txt");

		// Tests the two d1 constructors
		Deck d1 = new Deck();
		Deck d2 = new Deck(false);
		out.println("Two Decks have been created, d1 and d2");
		out.println("d1 should be sorted: ");
		out.println(d1);
		out.println("d2 should be random: ");
		out.println(d2);

		out.println();
		out.println();

		// Tests mergeSort
		out.println("Now testing mergeSort on d2");
		d2.mergeSort();
		out.println("d2 should now be sorted: ");
		out.println(d2);

		out.println();
		out.println();

		// Tests selectionSort
		out.println("Now testing selectionSort on d1");
		d1.shuffle();
		out.println("d1 should now be random: ");
		out.println(d1);
		d1.selectionSort();
		out.println("d1 should now be sorted: ");
		out.println(d1);

		out.println();
		out.println();

		// Tests pick
		out.println("Now testing pick on d1");
		out.println(d1.pick());
		out.println(d1.pick());
		out.println(d1.pick());

		out.println();
		out.println();

		// Tests deal as well as other methods with the smaller decks made from deal
		out.println("Now testing deal on d1");
		d1.resetDeck();
		d1.shuffle();
		Deck[] warGame = d1.deal(2, 25);
		out.println("Now dealing two hands of 25 cards each");
		out.println(warGame[0]);
		out.println(warGame[1]);
		out.println("Here are the remaining cards in d1 ");
		out.println(d1);

		// Tests mergeSort and selectionSort on the smaller deal hands
		out.println("Here is the first hand sorted using mergeSort");
		warGame[0].mergeSort();
		out.println(warGame[0]);

		out.println();
		out.println("Here is the second hand sorted using selectionSort");
		warGame[1].selectionSort();
		out.println(warGame[1]);

		out.close();
	}

	/**
	 * Creates a file of the given name (used to create an output)
	 * 
	 * @param fName
	 *            The name of the file to be created
	 * @return A PrintWriter of the same name as fName which can be manipulated and
	 *         then saved
	 */
	public static PrintWriter outputFile(String fName) {
		File fileName = new File(fName);

		PrintWriter output = null;

		try {
			output = new PrintWriter(fileName);
		} catch (FileNotFoundException ex) {
			System.out.print("Cannot open " + fName);
			return null;

		}

		return output;
	}
}
