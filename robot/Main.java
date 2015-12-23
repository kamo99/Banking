class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("Robot is now moving");
		Robot mujambot = new Robot();
		mujambot.forwards(100, 100);
		mujambot.right(1000);
		System.out.println(mujambot.coordinates()[0] + ", " + mujambot.coordinates()[1]);
	}
}
