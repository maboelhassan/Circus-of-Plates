import java.util.ArrayList;

public class PlatePool {

	private static PlatePool firstInstance = null;
	private static boolean isFirstInstance = false;
	private static int poolSize = 30; // by default
	private static ArrayList<Shape> allShapes;

	private PlatePool() {

	}

	public static PlatePool getInstance() {

		if (!isFirstInstance) {
			firstInstance = new PlatePool();
			isFirstInstance = true;
			allShapes = new ArrayList<Shape>();
			return firstInstance;
		} else {

			return firstInstance;
		}

	}

	public void setMaxPoolSize(int n) {
		poolSize = n;

	}

	public void getReusablePlate(Shape newShape) {
		allShapes.add(newShape);

	}

	public Shape releaseReusablePlate() {

		if (allShapes.size() == 0) {
			Shape newShape = PlateFactory.getInstance().getPlate();
			allShapes.add(newShape);
		}

		Shape newShape = allShapes.get(0);
		allShapes.remove(0);

		if (newShape.getRailer() == 1) {

			newShape.setXposition(0);
			newShape.setYposition(200);
		} else {

			newShape.setXposition(1325);
			newShape.setYposition(200);
		}

		newShape.setState(newShape.getRailerState());
		return newShape;

	}

}
