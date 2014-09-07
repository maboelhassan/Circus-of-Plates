public class Control {

	private View myView;

	public Control() {
		// TODO Auto-generated constructor stub

	}

	public void setView(View newView) {
		myView = newView;
	}

	/*
	 * we can make the user choose which method to move his player (advanced
	 * stuff) /
	 */
	// player 1 uses keyboard
	public void rightArrowPressed() {
		myView.movePlayerOneRight();
		myView.repaint();

	}

	public void leftArrowPressed() {
		myView.movePlayerOneLeft();
		myView.repaint();
	}

	// player 2 uses mouse
	public void rightClickPressed() {

		myView.movePlayerTwoRight();
		myView.repaint();
	}

	public void leftClickPressed() {
		myView.movePlayerTwoLeft();
		myView.repaint();

	}
	// alot of other similar methods of communication between the MODEL and the
	// View
}
