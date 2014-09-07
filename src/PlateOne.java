import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.URL;

public class PlateOne extends Shape {

	public PlateOne(String url) {
		plateIsFree = new PlateFree(this);
		plateIsWithPlayer = new PlateWithplayer(this);
		plateIsInRailer = new PlateOnRailer(this);
		plateIsInPool = new PlateInPool(this);

		this.shapeImage = getImage(url);
		currentState = plateIsInPool;
		this.height = 10;

	}

	public void draw(Graphics g, ImageObserver observer) {

		if (this.getCurrentState() != this.getPoolState())
			g.drawImage(shapeImage, getxPostion(), getyPostion(), 25, 10,
					observer);

	}


}
