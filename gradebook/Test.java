class Test {
	public static void main(String[] args) {
		final String indent = "    ";

		final School millburn = new School("Millburn High School");

		final Student joe = new Student("Joe Bob", "Sally", "123-45-6789", 12);
		final Student phil = new Student("Phil", "Cakulev", "222-33-4321", 11);
		final Student trevor = new Student("Trevor", "Stack", "262-33-8321", 12);

		millburn.enroll(joe);
		millburn.enroll(phil);
		millburn.enroll(trevor);

		final Course apcs = new Course("AP Computer Science");
		final Course calc = new Course("AP Calculus BC");
		final Course physics = new Course("AP Physics");
		final Course ice = new Course("Ice Melting");
		final Course paint = new Course("Paint Drying");
		final Course stamp = new Course("Stamp Licking");

		millburn.addCourse(apcs);

		joe.attend(apcs, 100);
		joe.attend(calc, 100);
		joe.attend(physics, 100);
		phil.attend(apcs, 45);
		phil.attend(calc, 51);
		phil.attend(physics, 37);
		trevor.attend(ice, 78);
		trevor.attend(paint, 82);
		trevor.attend(stamp, 90);

		System.out.println("Student stats:");
		System.out.println(indent + joe + " has an average grade of " + joe.averageGrade());
		System.out.println(indent + phil + " has an average grade of " + phil.averageGrade());
		System.out.println(indent + trevor + " has an average grade of " + trevor.averageGrade());

		System.out.println();
		System.out.println("School stats:");
		System.out.println(indent + millburn + " has an average grade of " + millburn.averageGrade());
		System.out.println(indent + millburn + " has " + millburn.totalFailing() + " failing students");
		for (int grade = 9; grade <= 12; grade++) {
			School year = new School("Grade " + grade, millburn.studentsInGrade(grade));
			System.out.println(
				indent + year + " has an average grade of " + year.averageGrade() + " and total of " + year.totalFailing() + " are failing"
			);
		}
	}
}
