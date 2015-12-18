import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Test {
	static final Scanner shell = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		final School millburn = new School("Millburn High School");

		final String filename = "students.txt";
		Scanner file = shell; // if we can't open the file, we read from the shell
		try {
			file = new Scanner(new File(filename));
			System.out.println("File has been read correctly");
		} catch (FileNotFoundException error) {
			System.out.println("Could not find the file " + filename + ". Exiting...");
			System.exit(1);
		}

		while (file.hasNext()) {
			String line = file.nextLine();
			if (line == null)
				break;
			else if (line.equals(""))
				continue;
			else
				line = line.replace("		", "	");

			String[] sections = line.split("\t");
			trim(sections);

			final String surname = sections[0];
			final String firstname = sections[1];
			final String ssn = sections[2];
			final Integer grade = Integer.parseInt(sections[3]);
			final String courseName = sections[4];
			final Integer courseGrade = Integer.parseInt(sections[5]);

			millburn.enroll(new Student(firstname, surname, ssn, grade));
			millburn.addCourse(new Course(courseName));

			final Student student = millburn.findBySSN(ssn);
			final Course course = millburn.findCourse(courseName);

			student.attend(course, courseGrade);
		}

		final String indent = "    ";
		System.out.println("Student stats:");
		System.out.println(indent + millburn + " has an average grade of " + millburn.averageGrade());
		System.out.println(indent + millburn.totalFailing() + " students are currently failing");

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

	public static String input(String message) {
		System.out.print(message);
		return shell.next();
	}

	public static void trim(String[] originals) {
		for (int i = 0; i < originals.length; i++)
			originals[i] = originals[i].trim();
	}
}
