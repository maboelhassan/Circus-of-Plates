import java.util.Stack;
import java.util.Vector;

public class PlateFree implements PlateState {

	private Shape plate;
	private int xStart;
	private int yStart;
	private int xEnd;
	private int yEnd;
	private boolean adjusted = false;
	private int speed = 3;
	private int xlow = 0, xhi = 0;

	// by default

	public PlateFree(Shape newplate) {

		this.plate = newplate;
		adjusted = false;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

		if (!adjusted) {

			if (plate.getRailer() == 1) {

				xStart = 200;
				yStart = 100;
				plate.setXposition(xStart);
				plate.setYposition(yStart);

				int randomxend = NumberGenerator.getInstance()
						.randomPointFromRailerOne();

				xEnd = randomxend;
				yEnd = 645;

				xlow = Math.min(xStart, xEnd);
				xhi = Math.max(xStart, xEnd);

			} else {
				// System.out.println("got there");
				xStart = 1150;
				yStart = 100;
				plate.setXposition(xStart);
				plate.setYposition(yStart);
				int randomxend = NumberGenerator.getInstance()
						.randomPointFromRailerTwo();
				xEnd = randomxend;
				yEnd = 645;
				xlow = Math.min(xStart, xEnd);
				xhi = Math.max(xStart, xEnd);

			}
			adjusted = true;

		}

		// double movex = Vector2D.getInstance().getVecvtorX(xStart, xEnd,
		// yStart,
		// yEnd);
		// double movey = Vector2D.getInstance().getVecvtorY(xStart, xEnd,
		// yStart,
		// yEnd);
		//
		// plate.moveX(2 * ((int) (movex + 2.32)));
		// plate.moveY(2 * ((int) (movey + 2.75)));
		//
		// System.out.println((int) (movex + 1) * speed + " " + (int) (movey +
		// 1)
		// * speed + "  vector of motion");
		// //
		// System.out.println(plate.getxPostion() + "/// " +
		// plate.getyPostion());
		//
		// System.out.println(xEnd + " " + yEnd);

		if (xStart < xEnd) {
			xlow += speed;
			int cury = 0;
			if (xlow <= xhi) {
				// System.out.println("kk");
				cury = (int) Vector2D.getInstance().calcY(xStart, yStart, xEnd,
						yEnd, xlow);
			}

			// System.out.println(xlow + "ppp" + cury);
			plate.setXposition(xlow);
			plate.setYposition(cury);
		} else {
			xhi -= speed;
			int cury = 0;

			if (xlow <= xhi) {
				cury = (int) Vector2D.getInstance().calcY(xStart, yStart, xEnd,
						yEnd, xhi);
			}

			// System.out.println(xhi + "ppp" + cury);
			plate.setXposition(xhi);
			plate.setYposition(cury);

		}

		if (plate.getyPostion() > 600) {

			// System.out.println("got there 2nd time");
			plate.setState(plate.getPoolState());

		}

	}

	public void handleMovementToPlayer(Player playerOne, Player playerTwo) {

		int xplate = plate.getxPostion();
		int yplate = plate.getyPostion();

		int xplayer1 = playerOne.getxPostion();
		int xplayer2 = playerTwo.getxPostion();
		// System.out.println(xplayer2);
		// System.out.println(playerTwo.getxPostion());
		// System.out.println("ss" + playerTwo.getStackLeft().size());

		if (xplate >= xplayer1 - 10 && xplate <= xplayer1 + 30) {

			int x = 650 - (yplate + playerOne.getHeightLeft()
					- plate.getPlateHeight() - 100);

			// System.out.println(x);

			if (x >= 200 && x <= 300) {

				plate.setYposition(650 - (plate.getPlateHeight()
						+ playerOne.getHeightLeft() + 100));
				plate.setXposition(playerOne.getxPostion());
				plate.setState(plate.getPlayerState());
				playerOne.pushInLeft(plate);
				int newh = playerOne.getHeightLeft() + plate.getPlateHeight();
				playerOne.setHeightLeft(newh);

				if (playerOne.getStackLeft().size() >= 3) {

					Shape s1 = playerOne.getStackLeft().pop();
					Shape s2 = playerOne.getPlatesOfstk1().pop();
					Shape s3 = playerOne.getPlatesOfstk1().pop();

					if (s1.getColor().equals(s2.getColor())
							&& s2.getColor().equals(s3.getColor())) {

						int newH = playerOne.getHeightLeft()
								- (s1.getPlateHeight() + s2.getPlateHeight() + s3
										.getPlateHeight());

						playerOne.setHeightLeft(newH);

						playerOne.setScore(playerOne.getScore() + 1);
						PlatePool.getInstance().getReusablePlate(s3);
						PlatePool.getInstance().getReusablePlate(s2);
						PlatePool.getInstance().getReusablePlate(s1);

					} else {
						playerOne.getStackLeft().push(s3);
						playerOne.getStackLeft().push(s2);
						playerOne.getStackLeft().push(s1);
					}

				}

			}

		}

		else if (xplate >= xplayer1 + 65 && xplate <= xplayer1 + 110) {
			int x = 650 - (yplate + playerOne.getHeightRight()
					- plate.getPlateHeight() - 100);

			if (x >= 200 && x <= 300) {
				plate.setYposition(650 - (plate.getPlateHeight()
						+ playerOne.getHeightRight() + 100));
				plate.setState(plate.getPlayerState());
				plate.setXposition(playerOne.getxPostion() + 65);
				playerOne.pushInright(plate);

				int newh = playerOne.getHeightRight() + plate.getPlateHeight();
				playerOne.setHeightRight(newh);

				if (playerOne.getStackRight().size() >= 3) {

					Shape s1 = playerOne.getStackRight().pop();
					Shape s2 = playerOne.getStackRight().pop();
					Shape s3 = playerOne.getStackRight().pop();

					if (s1.getColor().equals(s2.getColor())
							&& s2.getColor().equals(s3.getColor())) {

						int newH = playerOne.getHeightRight()
								- (s1.getPlateHeight() + s2.getPlateHeight() + s3
										.getPlateHeight());

						playerOne.setHeightRight(newH);

						playerOne.setScore(playerOne.getScore() + 1);
						PlatePool.getInstance().getReusablePlate(s3);
						PlatePool.getInstance().getReusablePlate(s2);
						PlatePool.getInstance().getReusablePlate(s1);

					} else {
						playerOne.getStackRight().push(s3);
						playerOne.getStackRight().push(s2);
						playerOne.getStackRight().push(s1);
					}

				}

			}
		}

		else if (xplate >= xplayer2 - 10 && xplate <= xplayer2 + 30) {

			int x = 650 - (yplate + playerTwo.getHeightLeft()
					- plate.getPlateHeight() - 100);

			// System.out.println(x);

			if (x >= 200 && x <= 300) {

				plate.setYposition(650 - (plate.getPlateHeight()
						+ playerTwo.getHeightLeft() + 100));
				plate.setXposition(playerTwo.getxPostion());
				plate.setState(plate.getPlayerState());
				playerTwo.pushInLeft(plate);
				int newh = playerTwo.getHeightLeft() + plate.getPlateHeight();
				playerTwo.setHeightLeft(newh);

				if (playerTwo.getStackLeft().size() >= 3) {

					Shape s1 = playerTwo.getStackLeft().pop();
					Shape s2 = playerTwo.getPlatesOfstk1().pop();
					Shape s3 = playerTwo.getPlatesOfstk1().pop();

					if (s1.getColor().equals(s2.getColor())
							&& s2.getColor().equals(s3.getColor())) {

						int newH = playerTwo.getHeightLeft()
								- (s1.getPlateHeight() + s2.getPlateHeight() + s3
										.getPlateHeight());

						playerTwo.setHeightLeft(newH);

						playerTwo.setScore(playerTwo.getScore() + 1);
						PlatePool.getInstance().getReusablePlate(s3);
						PlatePool.getInstance().getReusablePlate(s2);
						PlatePool.getInstance().getReusablePlate(s1);

					} else {
						playerTwo.getStackLeft().push(s3);
						playerTwo.getStackLeft().push(s2);
						playerTwo.getStackLeft().push(s1);
					}

				}

			}

		}

		else if (xplate >= xplayer2 + 65 && xplate <= xplayer2 + 110) {
			int x = 650 - (yplate + playerTwo.getHeightRight()
					- plate.getPlateHeight() - 100);

			if (x >= 200 && x <= 300) {
				plate.setYposition(650 - (plate.getPlateHeight()
						+ playerTwo.getHeightRight() + 100));
				plate.setState(plate.getPlayerState());
				plate.setXposition(playerTwo.getxPostion() + 65);
				playerTwo.pushInright(plate);

				int newh = playerTwo.getHeightRight() + plate.getPlateHeight();
				playerTwo.setHeightRight(newh);

				if (playerTwo.getStackRight().size() >= 3) {

					Shape s1 = playerTwo.getStackRight().pop();
					Shape s2 = playerTwo.getStackRight().pop();
					Shape s3 = playerTwo.getStackRight().pop();

					if (s1.getColor().equals(s2.getColor())
							&& s2.getColor().equals(s3.getColor())) {

						int newH = playerTwo.getHeightRight()
								- (s1.getPlateHeight() + s2.getPlateHeight() + s3
										.getPlateHeight());

						playerTwo.setHeightRight(newH);

						playerTwo.setScore(playerTwo.getScore() + 1);
						PlatePool.getInstance().getReusablePlate(s3);
						PlatePool.getInstance().getReusablePlate(s2);
						PlatePool.getInstance().getReusablePlate(s1);

					} else {
						playerTwo.getStackRight().push(s3);
						playerTwo.getStackRight().push(s2);
						playerTwo.getStackRight().push(s1);
					}

				}

			}
		}

	}

	@Override
	public void setCurrentColor() {
		// TODO Auto-generated method stub

	}

	public void setStartPoint(int x, int y) {
		xStart = x;
		yStart = y;
	}

	public void setEndPoint(int x, int y) {
		xEnd = x;
		yEnd = y;
	}

}
