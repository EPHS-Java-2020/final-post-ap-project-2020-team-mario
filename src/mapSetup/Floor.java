package mapSetup;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Floor {
	
	private ImageIcon ii;
	private Image image;
	
	public Floor() {
		ii = new ImageIcon("src/Drawings/FLoor.png");
		image = ii.getImage();
	}
	
	public Image getFloor() {
		return image;
	}

}
