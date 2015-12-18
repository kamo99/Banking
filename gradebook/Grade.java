class Grade {
	public static char letterGrade(int grade) throws Exception {
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
}
