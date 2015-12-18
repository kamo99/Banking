import java.util.ArrayList;
import java.util.Collections;

class SortAll {
	public static Comparable[] bubble(Comparable[] comparables) {
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true; // assume that it is sorted until proven otherwise
			for (int i = 0; i < comparables.length - 1; i++) {
				if (comparables[i].compareTo(comparables[i+1]) > 0) {
					Comparable aux = comparables[i];
					comparables[i] = comparables[i+1];
					comparables[i+1] = aux;
					isSorted = false;
				}
			}
		}
		return comparables;
	}

	public static ArrayList<Comparable> bubble(ArrayList<Comparable> comparables) {
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true; // assume that it is sorted until proven otherwise
			for (int i = 0; i < comparables.size() - 1; i++) {
				if (comparables.get(i).compareTo(comparables.get(i+1)) > 0) {
					Collections.swap(comparables, i, i + 1);
				}
			}
		}
		return comparables;
	}
}
