class Robot {
	private double deltaX = 0, deltaY = 0;
	private Motor[] motors;
	private static int lateralSpeed = 30; // cm/millisecond moved at the top speed laterally

	// motor index => posiiton
	// 0 => front left
	// 1 => front right
	// 2 => back right
	// 3 => back left
	public Robot(Motor[] motors) {
		this.motors = motors;
	}

	public Robot() {
		this(makeMotors(4, 10));
	}

	public static Motor[] makeMotors(int n, int diameter) {
		Motor[] motors = new Motor[n];
		for (int i = 0; i < motors.length; i++)
			motors[i] = new Motor(diameter);
		return motors;
	}

	public double distanceTraveled() {
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	}

	public void forwards(double distance, int speed) throws Exception {
		speed = Math.abs(speed); // speed is a scalar, not a vector

		final double totalSpinsToMove = distance / this.motors[0].circumference();
		final double rpm = Motor.rpmGivenSpeed(speed);
		final double rpmsec = rpm / (60 * 1000); // revolutions per millisecond
		final double duration = totalSpinsToMove / rpmsec;

		for (Motor motor : this.motors)
			motor.setSpeed(speed);

		Thread.sleep((long) duration);

		this.deltaY += distance;
	}

	public void right(int duration) throws Exception {
		this.motors[0].setSpeed(-100);
		this.motors[1].setSpeed(-100);
		this.motors[2].setSpeed(100);
		this.motors[3].setSpeed(100);

		this.deltaX += duration * lateralSpeed;

		Thread.sleep(duration);

		freeze();
	}

	public void left(int duration) throws Exception {
		this.motors[0].setSpeed(100);
		this.motors[1].setSpeed(100);
		this.motors[2].setSpeed(-100);
		this.motors[3].setSpeed(-100);

		this.deltaX -= duration * lateralSpeed;

		Thread.sleep(duration);

		freeze();
	}

	public void freeze() {
		for (Motor motor : this.motors)
			motor.setSpeed(0);
	}

	public void resetPosition() {
		this.deltaX = 0;
		this.deltaY = 0;
	}

	public double[] coordinates() {
		double[] coords = new double[2];
		coords[0] = deltaX;
		coords[1] = deltaY;
		return coords;
	}
}
