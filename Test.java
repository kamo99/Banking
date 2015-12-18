import java.util.ArrayList;

class Test {
	public static void main(String[] args) {
		ArrayList<Integer> ages = new ArrayList<Integer>();
		ages.add(1);
		ages.add(34);
		ages.add(2);
		ages.add(1);
		ages.add(1);
		ages.add(2);

		System.out.println(SortAll.totalDuplicates(ages));
	}
}
