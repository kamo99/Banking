import java.util.ArrayList;

class School {
	private final String name;
	private ArrayList<Student> students;
	ArrayList<Course> courses;

	public School(String name, ArrayList<Student> students, ArrayList<Course> courses) {
		this.name = name;
		this.students = students;
		this.courses = courses;
	}

	public School(String name, ArrayList<Student> students) {
		this(name, students, new ArrayList<Course>());
	}

	public School(String name) {
		this(name, new ArrayList<Student>());
	}

	public ArrayList<Student> students() {
		final ArrayList<Comparable> students = new ArrayList<Comparable>();
		for (int i = 0; i < this.students.size(); i++)
			students.add(this.students.get(i));
		SortAll.bubble(students);
		this.students = new ArrayList<Student>();
		for (int i = 0; i < students.size(); i++)
			this.students.add((Student) (students.get(i)));
		return this.students;
	}

	public Grade averageGrade() {
		double total = 0;
		for (int i = 0; i < this.students.size(); i++)
			total += this.students.get(i).averageGrade().numeric;
		return new Grade(total / this.students.size());
	}

	public void enroll(Student student) {
		this.students.add(student);
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public Student findBySurname(String surname) throws Exception {
		for (int i = 0, len = this.students.size(); i < len; i++)
			if (students.get(i).getSurname().equals(surname))
				return students.get(i);

		throw new Exception("No student found with surname " + surname);
	}

	public Student findBySSN(String ssn) throws Exception {
		for (int i = 0, len = this.students.size(); i < len; i++)
			if (students.get(i).getSSN().equals(ssn))
				return students.get(i);

		throw new Exception("No student found with SSN " + ssn);
	}

	public ArrayList<Student> studentsInGrade(int grade) {
		final ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i < this.students.size(); i++)
			if (this.students.get(i).getGrade() == grade)
				students.add(this.students.get(i));
		return students;
	}

	public int totalFailing() {
		int total = 0;
		for (int i = 0; i < this.students.size(); i++)
			total += this.students.get(i).averageGrade().isFailing() ? 1 : 0;
		return total;
	}

	public String toString() {
		return this.name;
	}
}
