public class PlateOnRailer implements PlateState {

	private Shape plate;
	private int speed = 3;
	private boolean adjusted = false;

	// by default

	public PlateOnRailer(Shape newplate) {

		this.adjusted = false;
		this.plate = newplate;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

		if (!adjusted) {

			// System.out.println("tthere");
			// System.out.println(plate.getRailer());
			if (plate.getRailer() == 1) {
				plate.setXposition(0);
				plate.setYposition(100);
			} else {
				plate.setXposition(1340);
				plate.setYposition(100);

			}

			adjusted = true;
		}

		if (plate.getRailer() == 1) {
			plate.moveX(speed);

			if (plate.getxPostion() > 200) {
				plate.setState(plate.getFreeState());

			}

		} else {

			plate.moveX(-1 * speed);

			if (plate.getxPostion() < 1150) {
				plate.setState(plate.getFreeState());
			}

		}

	}

	@Override
	public void setCurrentColor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMovementToPlayer(Player playerOne, Player playerTwo) {
		// TODO Auto-generated method stub

	}

}
