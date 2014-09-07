import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

public class HandleMouse implements MouseListener {

	private View v;
	private Control controller;

	public HandleMouse(View newView, Control newController) {

		v = newView;
		controller = newController;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		if (SwingUtilities.isLeftMouseButton(e)) {

			this.controller.rightClickPressed();

		} else if (SwingUtilities.isRightMouseButton(e)) {
			this.controller.leftClickPressed();

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
