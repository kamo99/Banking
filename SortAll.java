import java.util.ArrayList;

class SortAll {
	// by default, it sorts least to greatest
	// to make it greatest to least, pass in direction as a negative number
	public static Comparable[] bubble(Comparable[] comparables, int direction) {
		direction = direction / Math.abs(direction);
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true; // assume that it is sorted until proven otherwise
			for (int i = 0; i < comparables.length - 1; i++) {
				if (comparables[i].compareTo(comparables[i+1]) * direction > 0) {
					Comparable aux = comparables[i];
					comparables[i] = comparables[i+1];
					comparables[i+1] = aux;
					isSorted = false;
				}
			}
		}
		return comparables;
	}

	public static Comparable[] bubble(Comparable[] comparables) {
		return bubble(comparables, 1);
	}

	public static ArrayList<ArrayList> groupDuplicates(ArrayList original) {
		ArrayList remaining = new ArrayList(original);
		ArrayList<ArrayList> groups = new ArrayList();
		while (remaining.size() > 0) {
			ArrayList group = new ArrayList();
			Object key = remaining.get(0);
			ArrayList<Integer> used = new ArrayList<Integer>();

			for (int i = 0; i < remaining.size(); i++) {
				if (key.equals(remaining.get(i))) {
					group.add(remaining.get(i));
					used.add(i);
				}
			}
			groups.add(group);

			for (int i = 0; i < used.size() + 1; i++) {
				try {
					remaining.remove(key);
				} catch (Exception error) {}
			}
		}
		return groups;
	}
}
