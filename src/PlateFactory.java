import java.awt.Color;
import java.lang.reflect.InvocationTargetException;

public class PlateFactory {
	private static boolean isFirstInstance = false;
	private static PlateFactory firstInstance = null;

	private static String firstPlayer = "ClownOne.PNG";
	private static String secondPlayer = "ClownTwo.PNG";
	private static String redPlate = "PlateRed.PNG";
	private static String greenPlate = "PlateGreen.PNG";
	private static String bluePlate = "PlateBlue.PNG";

	private static String redCup = "CupRed.PNG";
	private static String greenCup = "CupGreen.PNG";
	private static String blueCup = "CupBlue.PNG";

	private static DynamicLoader dl1 = null, dl2 = null;

	private PlateFactory() {

	}

	public static PlateFactory getInstance() {
		if (!isFirstInstance) {
			firstInstance = new PlateFactory();
			isFirstInstance = true;
			return firstInstance;
		} else {
			return firstInstance;

		}

	}

	public Shape getPlate() {
		NumberGenerator randomizer = NumberGenerator.getInstance();
		int typeOfPlate = randomizer.plateOrCup();
		int randomColor = randomizer.randomPlateColor();
		int whichRailer = randomizer.randomRailer();

		if (dl1 == null)
			dl1 = new DynamicLoader("D:\\PlateOne.class");
		if (dl2 == null)
			dl2 = new DynamicLoader("D:\\PlateTwo.class");
		Shape newShape = null;
		if (typeOfPlate == 1) {

			if (randomColor == 1) {
				// newShape = new PlateOne(redPlate);
				try {
					newShape = (Shape) dl1.constructors[0]
							.newInstance(redPlate);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				newShape.setColor(Color.RED);

			} else if (randomColor == 2) {
				// newShape = new PlateOne(bluePlate);
				try {
					newShape = (Shape) dl1.constructors[0]
							.newInstance(bluePlate);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				newShape.setColor(Color.BLUE);

			} else {

				// newShape = new PlateOne(greenPlate);
				try {
					newShape = (Shape) dl1.constructors[0]
							.newInstance(greenPlate);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				newShape.setColor(Color.GREEN);

			}

		} else {

			if (randomColor == 1) {

				// newShape = new PlateTwo(redCup);
				try {
					newShape = (Shape) dl2.constructors[0].newInstance(redCup);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				newShape.setColor(Color.RED);
			} else if (randomColor == 2) {

				// newShape = new PlateTwo(blueCup);
				try {
					newShape = (Shape) dl2.constructors[0].newInstance(blueCup);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				newShape.setColor(Color.BLUE);
			} else {

				// newShape = new PlateTwo(greenCup);
				try {
					newShape = (Shape) dl2.constructors[0]
							.newInstance(greenCup);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				newShape.setColor(Color.GREEN);
			}

		}

		newShape.setRailer(whichRailer);
		return newShape;

	}

}
