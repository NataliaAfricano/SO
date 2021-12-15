package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JMainWindow extends JFrame{
	
	
	
	private static final String ANIMATED_GALLERY = "Animated Gallery";
	private static final long serialVersionUID = 1L;
	public static final int SIZE_WIDHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2;
	public static final int SIZE_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2;
	public JPanelAllImage jPanelAllImage;
	public PrincipalPanel panel;
	

	public JMainWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(SIZE_WIDHT,SIZE_HEIGHT);
		setTitle(ANIMATED_GALLERY);
		setIconImage(new ImageIcon(getClass().getResource("/icon/icon.png")).getImage());
	
		
		panel = new PrincipalPanel();
		panel.setPreferredSize(new Dimension(getWidth(),30));
		add(panel,BorderLayout.NORTH);
		setVisible(true);
	
		jPanelAllImage = new JPanelAllImage();
		jPanelAllImage.setLayout(new FlowLayout());
		this.add(jPanelAllImage,BorderLayout.CENTER);
		
		
	}
	
	public void multyTarget(ImageIcon image) {
		jPanelAllImage.add(new JPanelImage(image));
		
	}
	
	public void visiblePanel() {
		remove(panel);
		setVisible(true);
	}

}
