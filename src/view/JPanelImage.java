package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelImage extends JPanel{

	
	private static final long serialVersionUID = 1L;
	
	JLabel image;
	private static final int WIDTH = 200;
	private static final int HEIGTH = 200;
	
	
	public JPanelImage(ImageIcon image) {
		ImageIcon img2=new ImageIcon(image.getImage().getScaledInstance(WIDTH, HEIGTH, Image.SCALE_SMOOTH));
		this.image = new JLabel(img2);
		this.image.setPreferredSize(new Dimension(WIDTH,HEIGTH));
		setBackground(Color.BLACK);
		this.add(this.image);
		
		
	}
}
