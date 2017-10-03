
import java.util.Comparator;

/**
 * Used to compare two Card objects
 * 
 * @author Sean Gibbons
 *
 */
public class RankComparator implements Comparator<Card> {
	// describes the order the cards are to be sorted
	private boolean ascending;

	public RankComparator() {
		ascending = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Card o1, Card o2) {
		int difference = o1.getRank() - o2.getRank();
		if (ascending)
			return difference;
		else
			return -1 * difference;
	}

	/**
	 * @param o1
	 * @param o2
	 * @return
	 */
	public boolean equals(Card o1, Card o2) {
		return this.compare(o1, o2) == 0;
	}

	public void setAscending() {
		ascending = true;
	}

	public void setDescending() {
		ascending = false;
	}

}
