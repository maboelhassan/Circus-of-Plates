import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HandleKeyBoard implements KeyListener {

	private View v;
	private Control controller;

	public HandleKeyBoard(View newView, Control newController) {

		v = newView;
		controller = newController;

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int id = e.getID();
		if (id != e.KEY_TYPED) {
			int keycode = e.getKeyCode();
			if (keycode == 39) {
				System.out.println("here");
				this.controller.leftArrowPressed();

			} else if (keycode == 37) {
				this.controller.rightArrowPressed();

			} else if (keycode == 65) {

				// A used as left for the second player

				this.controller.leftClickPressed();

			} else if (keycode == 68) {
				// D used as right fot the second player
				System.out.println("here");
				this.controller.rightClickPressed();

			} else if (keycode == 83) {
				String filename1 = "savePlayer1.bin";
				String filename2 = "savePlayer2.bin";
				Player p1 = v.getPlayerOne();
				Player p2 = v.getPlayerTwo();
				try {
					ObjectOutputStream os1 = new ObjectOutputStream(
							new FileOutputStream(filename1));
					ObjectOutputStream os2 = new ObjectOutputStream(
							new FileOutputStream(filename2));
					os1.writeObject(p1);
					os1.close();
					os2.writeObject(p2);
					os2.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Saved");
				// this is for S
			} else if (keycode == 76) {
				String filename1 = "savePlayer1.bin";
				String filename2 = "savePlayer2.bin";
				Player p1 = v.getPlayerOne();
				Player p2 = v.getPlayerTwo();
				try {
					ObjectInputStream is1 = new ObjectInputStream(
							new FileInputStream(filename1));
					ObjectInputStream is2 = new ObjectInputStream(
							new FileInputStream(filename2));
					try {
						p1 = (Player) is1.readObject();
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					is1.close();
					try {
						p2 = (Player) is2.readObject();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					is2.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Loaded");
				// this is for L
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
