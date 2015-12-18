import java.util.ArrayList;

class School {
	private ArrayList<Student> students;
	ArrayList<Course> courses;

	public School() {
		this.students = new ArrayList<Student>();
		this.courses = new ArrayList<Course>();
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
}
