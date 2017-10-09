
public class DeckTester {

	public static void main(String[] args) {
		Deck d1 = new Deck();
		//System.out.println(d1 + "\n");
		//d1.shuffle();
		//System.out.println(d1);
		//Deck d2 = new Deck(false);
		Deck d2 = new Deck();
		//System.out.println(d2 + "\n\n");
		
		//Deck[] hands = d1.deal(3, 5);
		/*for(Deck d: hands)
			System.out.println(d);*/
		
		Deck[] hands = d1.deal(5, 11);
		for(Deck d: hands)
			System.out.println(d);		
		
		//System.out.println(d1.equals(d2));
		//System.out.println(d1.pick().compareTo(d2.pick()));
		
		//d1.shuffle();
		//d1.selectionSort();
		//System.out.println("Selection: \n" + d1);
		
		//d1.mergeSort();
		//System.out.println("Merge: \n" + d1);
			

	}

}
