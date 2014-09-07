import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class PlateTwo extends Shape {

	public PlateTwo(String url) {
		plateIsFree = new PlateFree(this);
		plateIsWithPlayer = new PlateWithplayer(this);
		plateIsInRailer = new PlateOnRailer(this);
		plateIsInPool = new PlateInPool(this);

		this.shapeImage = getImage(url);
		currentState = plateIsInPool;
		this.height = 15;

	}

	public void draw(Graphics g, ImageObserver observer) {
		if (this.getCurrentState() != this.getPoolState())
			g.drawImage(shapeImage, getxPostion(), getyPostion(), 25, 10,
					observer);

	}

}
