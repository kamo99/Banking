class Grade {
	final double numeric;

	public static char letterGrade(double grade) throws Exception {
		if (grade < 0)
			throw new Exception("Grade is negative. This is impossible");
		else if (grade < 60)
			return 'F';
		else if (grade < 70)
			return 'D';
		else if (grade < 80)
			return 'C';
		else if (grade < 90)
			return 'B';
		else
			return 'A';
	}

	public boolean isFailing() {
		return numeric < 60;
	}

	public Grade(double numeric) {
		this.numeric = numeric;
	}

	public String toString() {
		try {
			return "" + letterGrade(this.numeric);
		} catch (Exception error) {
			return "FAILED TO CALCULATE GRADE";
		}
	}
}
