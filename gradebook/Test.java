class Test {
	public static void main(String[] args) {
		final Student abhinav = new Student("Abhinav Madahar");
		final Student anand = new Student("Anand Tyagi");
		final Student mohar = new Student("Mohar Kalra");

		final Course apcs = new Course("AP Computer Science");
		abhinav.attend(apcs, 93);
		anand.attend(apcs, 95);
		mohar.attend(apcs, 96);

		System.out.println(apcs.averageGrade());
		System.out.println(abhinav);
		System.out.println(anand);
		System.out.println(mohar);

		try {
			System.out.println(Grade.letterGrade(apcs.grade(abhinav)));
		} catch (Exception error) {
			System.out.println(error);
		}
	}
}
