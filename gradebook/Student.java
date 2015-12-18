import java.util.ArrayList;

class Student implements Comparable<Student> {
	private String firstname, surname;
	private String ssn; // SSN is a String because you never do mathematics on it
	private int grade;
	private ArrayList<Course> courses;

	public Student(String firstname, String surname, String ssn, int grade) {
		this.firstname = firstname;
		this.surname = surname;
		this.ssn = ssn;
		this.grade = grade;
		this.courses = new ArrayList<Course>();
	}

	public void attend(Course course, int grade) {
		this.courses.add(course);
		course.enroll(this, grade);
	}

	public String getSurname() {
		return this.surname;
	}

	public String getSSN() {
		return this.ssn;
	}

	public Grade averageGrade() {
		double total = 0;
		for (Object attendedCourse : this.courses.toArray()) {
			try {
				total += ((Course) attendedCourse).grade(this);
			} catch (Exception error) {
				System.out.println("THIS SHOULD NEVER HAPPEN");
			}
		}
		return new Grade(total / this.courses.size());
	}

	public int getGrade() {return grade;}

	public int compareTo(Student other) {
		return (int) ((other).averageGrade().numeric - this.averageGrade().numeric);
	}

	public String toString() {
		return this.firstname + " " + this.surname;
	}
}
