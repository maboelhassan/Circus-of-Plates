import java.applet.Applet;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Trial extends Applet {

	// private Applet myapp;
	//
	// public trial() {
	// this.setLayout(new FlowLayout());
	// this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	// this.setSize(500, 500);
	// // this.add(new JButton("mohamed"));
	// myapp = new Applet();
	// myapp.setSize(400, 400);
	//
	// myapp.setBackground(Color.white);
	//
	// this.add(myapp);
	// this.setVisible(true);
	//
	// }

	public Trial(){
		
	}
	
	public void paint(Graphics g) {
		this.setSize(650, 1350);
		g.drawRect(0, 0, 100, 100);

	}

	public void repaint() {

	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		trial me = new trial();
//
//	}

}
