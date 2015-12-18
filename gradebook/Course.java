import java.util.HashMap;
import java.util.Calendar;

class Course {
	private String name;
	private HashMap<Student, Integer> students;

	public Course(String name) {
		this.name = name;
		this.students = new HashMap<Student, Integer>();
	}

	public void enroll(Student student, Integer grade) {
		this.students.put(student, grade);
	}

	public void setGrade(Student student, Integer grade) throws Exception {
		if (!this.students.containsKey(student))
			throw new Exception(student + " isn't enrolled in " + this + " so their grade can't be set");
		else
			this.students.put(student, grade);
	}

	public Integer grade(Student student) throws Exception {
		if (this.students.containsKey(student))
			return this.students.get(student);
		else
			throw new Exception(student.toString());
	}

	public Double averageGrade() {
		double total = 0;
		for (Object grade : this.students.values().toArray()) {
			total += (Integer) grade;
		}
		return total / this.students.size();
	}

	public String toString() {
		return name;
	}
}
