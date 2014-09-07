import java.applet.Applet;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import javax.swing.JButton;

public class Game extends Applet implements Serializable {

	private Player playerOne;
	private Player playerTwo;
	private Control controller;
	private View GUI;

	private JButton button;

	private static boolean isFirstInstance = false;
	private static Game firstInstance = null;

	public static Game getInstance() {
		if (!isFirstInstance) {
			try {
				firstInstance = new Game();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			isFirstInstance = true;
			return firstInstance;
		} else {

			return firstInstance;
		}
	}

	public Game() throws FileNotFoundException, IOException {
		// this.init();
		this.setLayout(new GridLayout(1, 0));

		PlayerFactory createPlayer = PlayerFactory.getInstance();
		playerOne = createPlayer.getPlayer(0);
		playerTwo = createPlayer.getPlayer(1);
		controller = new Control();

		// button = new JButton("button");
		// this.add(button);
		GUI = new View(playerOne, playerTwo, controller);

		this.add(GUI);
		// this.init();

	}

	private Image i;
	private Graphics doubleG;

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

	public void init() {
		// Game c = Game.getInstance();
		this.setSize(1350, 650);
		// GUI.generate();
		try {
			(new Thread(new Th())).start();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public class Th implements Runnable {
		public Th() throws FileNotFoundException, IOException {

		}

		@Override
		public void run() {
			while (true) {

				ControlPlates.getInstance().updateAll(playerOne, playerTwo);
				GUI.repaint();

				try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
