public class PlayerFactory {

	private static String firstPlayer = "ClownOne.png";
	private static String secondPlayer = "ClownTwo.png";
	private static String redPlate = "PlateRed.png";
	private static String greenPlate = "PlateGreen.png";
	private static String bluePlate = "PlateBlue.png";

	private static String redCup = "CupRed.png";
	private static String greenCup = "CupGreen.png";
	private static String blueCup = "CupBlue.png";

	private static boolean isFirstInstance = false;
	private static PlayerFactory firstInstance = null;

	private PlayerFactory() {

	}

	public static PlayerFactory getInstance() {
		if (!isFirstInstance) {
			firstInstance = new PlayerFactory();
			isFirstInstance = true;
			return firstInstance;
		} else {
			return firstInstance;

		}

	}

	public Player getPlayer(int choose) {

		if (choose == 0) {
			Player first = new Player(firstPlayer, 300);
			return first;

		} else {
			Player second = new Player(secondPlayer, 1100);
			return second;

		}

	}

}
