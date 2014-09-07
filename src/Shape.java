import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.URL;

public class Shape {
	protected int xPostion;
	protected int yPostion;
	protected transient Image shapeImage;
	protected int railer;

	protected int height = 0;
	protected PlateState currentState;
	protected PlateState plateIsFree;
	protected PlateState plateIsWithPlayer;
	protected PlateState plateIsInPool;
	protected PlateState plateIsInRailer;

	private Color color;

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

	public void setRailer(int _railer) {
		railer = _railer;
	}

	public int getRailer() {
		return this.railer;
	}

	public int getxPostion() {
		return xPostion;

	}

	public int getyPostion() {
		return yPostion;
	}

	public void moveX(int move) {

		if (xPostion + move > 1320)
			xPostion = 1320;

		else if (xPostion + move < 0)
			xPostion = 0;

		else
			xPostion += move;

	}

	public void moveY(int move) {
		if (yPostion + move > 620)
			yPostion = 620;

		else if (yPostion + move < 0)
			yPostion = 0;

		else
			yPostion += move;
	}

	public void setState(PlateState newPlateState) {
		currentState = newPlateState;

	}

	public PlateState getCurrentState() {

		return currentState;
	}

	public PlateState getPoolState() {
		return plateIsInPool;

	}

	public PlateState getFreeState() {
		return plateIsFree;

	}

	public PlateState getPlayerState() {
		return plateIsWithPlayer;

	}

	public PlateState getRailerState() {
		return plateIsInRailer;

	}

	public void setXposition(int x) {
		xPostion = x;
	}

	public void setYposition(int y) {
		yPostion = y;
	}

	public void draw(Graphics g, ImageObserver observer) {

	}

	public int getPlateHeight() {
		return this.height;
	}

	public void moveWithPlayerLeft(int speed) {

		this.xPostion -= speed;

	}

	public void moveWithPlayerRight(int speed) {

		this.xPostion += speed;

	}

	public void setColor(Color c) {
		this.color = c;
	}

	public Color getColor() {
		return this.color;
	}

}
