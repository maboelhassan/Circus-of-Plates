public class PlateInPool implements PlateState {

	private Shape plate;

	public PlateInPool(Shape newplate) {

		this.plate = newplate;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

		PlatePool.getInstance().getReusablePlate(plate);

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
