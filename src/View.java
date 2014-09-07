import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class View extends Applet {

	private Image i;
	private Graphics doubleG;
	private Player playerOne;
	private Player playerTwo;
	private Control controller;
	private Shape me;
	private ControlPlates plateController;
	private Image backGround;

	public View(Player playerone, Player playertwo, Control newController)
			throws FileNotFoundException, IOException {

		playerOne = playerone;
		playerTwo = playertwo;
		controller = newController;
		controller.setView(this);
		HandleKeyBoard key = new HandleKeyBoard(this, controller);
		HandleKeyBoard key2 = new HandleKeyBoard(this, controller);

		this.addKeyListener(key);
		// this.addKeyListener(key2);
		this.addMouseListener(new HandleMouse(this, controller));
		me = PlatePool.getInstance().releaseReusablePlate();
		plateController = ControlPlates.getInstance();
		backGround = getImage("background.jpg");

		// (new Thread(new Th())).start();
	}

	public void movePlayerOneLeft() {
		playerOne.moveLeft();

	}

	public void movePlayerTwoLeft() {

		playerTwo.moveLeft();
	}

	public void movePlayerOneRight() {

		playerOne.moveRight();
	}

	public void movePlayerTwoRight() {

		playerTwo.moveRight();
	}

	public void paint(Graphics g) {

		// System.out.println(view.playerOne.getxPostion());
		this.setSize(1350, 650);
		// g.drawRect(0, 0, 100, 100);

		g.clearRect(0, 0, 1350, 650);

		// g.drawImage(backGround, 0, 0, 1350, 650, this);

		g.drawImage(playerOne.getImage(), playerOne.getxPostion(), 550, 100,
				100, this);

		g.drawImage(playerTwo.getImage(), playerTwo.getxPostion(), 550, 100,

		100, this);

		g.drawLine(0, 110, 200, 110);

		g.drawLine(0, 130, 200, 130);
		g.drawLine(1350, 110, 1150, 110);
		g.drawLine(1350, 130, 1150, 130);

		if (playerOne.getHeightLeft() >= 400
				|| playerOne.getHeightRight() >= 400
				|| playerTwo.getHeightLeft() >= 400
				|| playerTwo.getHeightRight() >= 400) {
			JOptionPane.showMessageDialog(null, "score of player1 = "
					+ playerOne.getScore() + " vs score pf player2 = "
					+ playerTwo.getScore(), "End of Game",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}

		for (int i = 0; i < playerOne.getPlatesOfstk1().size(); i++) {
			playerOne.getPlatesOfstk1().get(i).draw(g, this);
		}

		for (int i = 0; i < playerOne.getStackRight().size(); i++) {
			// System.out.println("kk");
			playerOne.getStackRight().get(i).draw(g, this);
		}

		for (int i = 0; i < playerTwo.getPlatesOfstk1().size(); i++) {
			playerTwo.getPlatesOfstk1().get(i).draw(g, this);
		}

		for (int i = 0; i < playerTwo.getStackRight().size(); i++) {
			// System.out.println("kk");
			playerTwo.getStackRight().get(i).draw(g, this);
		}

		for (int i = 0; i < ControlPlates.getInstance().inService.size(); i++) {

			ControlPlates.getInstance().inService.get(i).draw(g, this);

		}

		//
		// g.drawRect(300, 540, 25, 10);
		// g.drawRect(370, 540, 25, 10);
		//
		// g.drawRect(1100, 540, 25, 10);
		// g.drawRect(1170, 540, 25, 10);
		//
		// g.drawRect(-50, 550, 100, 100);

		// me.draw(getGraphics(), this);

	}

	@Override
	public void update(Graphics g) {
		if (i == null) {
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
		}

		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);

		doubleG.setColor(getForeground());
		paint(doubleG);

		g.drawImage(i, 0, 0, this);
	}

	public void repaint() {

		// me.getCurrentState().move();

		this.paint(getGraphics());
		this.update(getGraphics());

	}

	public void init() {
		System.out.println("run");
	}

	//
	// @Override
	// public void update(Graphics g) {
	// if (i == null) {
	// i = createImage(this.getSize().width, this.getSize().height);
	// doubleG = i.getGraphics();
	// }
	// }

	// public void generate() {
	//
	// int x = 3;
	// while (x-- > 0) {
	// ControlPlates.getInstance().updateAll();
	// this.repaint();
	// }
	//
	// }

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

	public Player getPlayerOne() {
		return this.playerOne;
	}

	public Player getPlayerTwo() {
		return this.playerTwo;
	}

}
