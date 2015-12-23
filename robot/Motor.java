class Motor {
	private int speed;
	private double diameter;

	public Motor(double diameter) {
		this.diameter = diameter;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return this.speed;
	}

	public static double rpmGivenSpeed(int speed) {
		// assume that there exists a linear relationship
		final double ratio = 1.5;
		return speed * ratio;
	}

	public double rpm() {
		return rpmGivenSpeed(this.speed);
	}

	public double circumference() {
		return Math.PI * this.diameter;
	}
}
