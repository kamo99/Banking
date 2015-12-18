class Test {
	public static void main(String[] args) {
		final School millburn = new School();

		millburn.enroll(new Student("Abhinav", "Madahar", "3752395723", 11));
		millburn.enroll(new Student("Anand", "Tyagi", "2305872334", 11));
		millburn.enroll(new Student("Mohar", "Kalra", "358723572", 11));

		final Course apcs = new Course("AP Computer Science");

		millburn.addCourse(apcs);
	}
}
