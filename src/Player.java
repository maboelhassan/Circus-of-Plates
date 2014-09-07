import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Stack;

import javax.imageio.ImageIO;

public class Player {

	private transient Image playerImage;
	private int xPostion;
	private int speed = 10;
	private int heightLeft;
	private int heightRight;
	/*
	 * the default motion will be as shown .... further it may be needed to
	 * increase or decrease the speed as a feature of the game . any way . for
	 * now the speed is hard coded here in the source code ..
	 */
	/*
	 * this postion will be in the range from 0 to 1250 to be suitable to the
	 * size of the panel which has a width of 1350 . also it should be noted
	 * that the size of the player is 100 X 100 .
	 */

	private int score = 0;
	private Stack<Shape> stk1;
	private Stack<Shape> stk2;
	private String imageURl;
	private int verticalSize = 100;
	private int horizontalSize = 100;

	public Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = View.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			System.out.println("An error occured - " + e.getMessage());
		}
		return tempImage;
	}

	public Player(String url, int _xPosition) {
		playerImage = getImage(url);
		xPostion = _xPosition;
		heightLeft = 0;
		heightRight = 0;
		stk1 = new Stack<Shape>();
		stk2 = new Stack<Shape>();
		this.score = 0;

	}

	public Image getImage() {
		return playerImage;
	}

	public void moveRight() {

		if (xPostion > 0) {

			for (Shape s : stk1) {
				s.moveWithPlayerLeft(this.speed);

			}
			for (Shape s : stk2) {
				s.moveWithPlayerLeft(this.speed);
			}

			xPostion -= speed;

		}
	}

	public void moveLeft() {

		if (xPostion < 1250) {

			for (Shape s : stk1) {

				s.moveWithPlayerRight(this.speed);
			}
			for (Shape s : stk2) {
				s.moveWithPlayerRight(this.speed);
			}

			xPostion += speed;
		}

	}

	public void move() {

	}

	public Stack<Shape> getPlatesOfstk1() {
		return stk1;
	}

	public Stack<Shape> getPlatesOfstk2() {
		return stk2;
	}

	public int getxPostion() {
		return xPostion;
	}

	public int getHeightLeft() {
		return this.heightLeft;
	}

	public int getHeightRight() {
		return this.heightRight;
	}

	public void pushInLeft(Shape s) {
		this.stk1.push(s);
	}

	public void pushInright(Shape s) {
		this.stk2.push(s);
	}

	public void setHeightLeft(int h) {
		this.heightLeft = h;
	}

	public void setHeightRight(int h) {
		this.heightRight = h;
	}

	public Stack<Shape> getStackLeft() {
		return stk1;
	}

	public Stack<Shape> getStackRight() {
		return stk2;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int newScore) {
		this.score = newScore;
	}

}
