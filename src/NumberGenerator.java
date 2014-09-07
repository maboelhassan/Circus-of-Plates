public class NumberGenerator {

	private static boolean isFirstInstance = false;
	private static NumberGenerator firstInstance = null;

	private int randomIndex[] = { 0, 100, 200, 300, 400, 500, 600, 700, 800,
			900, 1000, 1100, 1200, 1290 };

	private NumberGenerator() {

	}

	public static NumberGenerator getInstance() {
		if (!isFirstInstance) {
			firstInstance = new NumberGenerator();
			isFirstInstance = true;
			return firstInstance;
		} else {

			return firstInstance;
		}
	}

	public int randomPlateColor() {

		int max = 3;
		int min = 1;

		int range = Math.abs(max - min) + 1;

		return (int) (Math.random() * range) + min;

	}

	public int randomPlateCreationPostion() {

		return 0;

	}

	public int randomRailer() {

		int max = 2;
		int min = 1;

		int range = Math.abs(max - min) + 1;

		return (int) (Math.random() * range) + min;

	}

	public int plateOrCup() {

		int max = 2;
		int min = 1;

		int range = Math.abs(max - min) + 1;

		return (int) (Math.random() * range) + min;
	}

	public int randomPointFromRailerOne() {

		int max = 13;
		int min = 0;

		int range = Math.abs(max - min) + 1;

		return randomIndex[(int) (Math.random() * range) + min];

		// int max = 100;
		// int min = 0;
		//
		// int range = Math.abs(max - min) + 1;
		//
		// return (int) (Math.random() * range) + min;

	}

	public int randomPointFromRailerTwo() {

		int max = 13;
		int min = 0;

		int range = Math.abs(max - min) + 1;

		return randomIndex[(int) (Math.random() * range) + min];

		//
		// int max = 1290;
		// int min = 0;
		//
		// int range = Math.abs(max - min) + 1;
		//
		// return (int) (Math.random() * range) + min;

	}

	public static void main(String args[]) {

		for (int i = 0; i < 50; i++) {

			System.out.println(NumberGenerator.getInstance()
					.randomPointFromRailerTwo());

		}

	}

}
