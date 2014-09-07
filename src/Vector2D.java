public class Vector2D {
	private static boolean isFirstInstance = false;
	private static Vector2D firstInstance = null;

	private Vector2D() {

	}

	public static Vector2D getInstance() {
		if (!isFirstInstance) {
			firstInstance = new Vector2D();
			isFirstInstance = true;
			return firstInstance;
		} else {

			return firstInstance;
		}
	}

	public double getVecvtorX(int x1, int x2, int y1, int y2) {

		double diff = (double) x2 - (double) x1;
		double norm = Math.sqrt(((double) (x1) - (double) (x2))
				* ((double) (x1) - (double) (x2)) + ((double) y1 - (double) y2)
				* ((double) y1 - (double) y2));

		return (double) diff / (double) norm;

	}

	public double getVecvtorY(int x1, int x2, int y1, int y2) {

		double diff = (double) y2 - (double) y1;
		double norm = Math.sqrt(((double) (x1) - (double) (x2))
				* ((double) (x1) - (double) (x2)) + ((double) y1 - (double) y2)
				* ((double) y1 - (double) y2));

		return (double) diff / (double) norm;

	}

	public double calcY(int x1, int y1, int x2, int y2, int x) {

		double slope = (double) (y2 - y1) / (double) (x2 - x1);
		double c = ((double) y1 - slope * (double) x1);

		return slope * (double) x + c;

	}

}
