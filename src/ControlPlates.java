import java.util.ArrayList;

public class ControlPlates {

	private static boolean isFirstInstance = false;
	private static ControlPlates firstInstance = null;
	public ArrayList<Shape> inService;
	private long time1 = 0;
	private long time2 = 0;

	private ControlPlates() {
		inService = new ArrayList<Shape>();
		time1 = System.currentTimeMillis();
	}

	public static ControlPlates getInstance() {
		if (!isFirstInstance) {
			firstInstance = new ControlPlates();
			isFirstInstance = true;
			return firstInstance;
		} else {

			return firstInstance;
		}
	}

	public void updateAll(Player p1, Player p2) {

		for (int i = 0; i < inService.size(); i++) {
			//
			// inService.get(i).getCurrentState().move();
			//
			// if (inService.get(i).getCurrentState()
			// .equals(inService.get(i).getPoolState())) {
			// inService.remove(i);
			//
			// }

			Shape s = inService.get(i);

			if (s.getCurrentState().equals(s.getFreeState())) {
				

				s.getCurrentState().handleMovementToPlayer(p1, p2);
				s.getCurrentState().move();
			} else if (s.getCurrentState().equals(s.getRailerState()))
				s.getCurrentState().move();
			else if (s.getCurrentState().equals(s.getPlayerState())) {
				inService.remove(i);
			} else {
				inService.remove(i);
			}

		}

		time2 = System.currentTimeMillis();

		if (time2 - time1 >= 500) {
			Shape newShape = PlatePool.getInstance().releaseReusablePlate();
			inService.add(newShape);
			time1 = time2;
		}

	}
}
