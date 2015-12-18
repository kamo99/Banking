import java.util.ArrayList;

class Student {
	private String name;
	private ArrayList<Course> courses;

	public Student(String name) {
		this.name = name;
		this.courses = new ArrayList<Course>();
	}

	public void attend(Course course, int grade) {
		this.courses.add(course);
		course.enroll(this, grade);
	}

	public String toString() {
		return this.name;
	}
}
