package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JMainWindow extends JFrame{
	
	
	
	private static final String ANIMATED_GALLERY = "Animated Gallery";
	private static final long serialVersionUID = 1L;
	public static final int SIZE_WIDHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2;
	public static final int SIZE_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2;
	public JPanelAllImage jPanelAllImage;
	public PrincipalPanel panel;
	public JButton btnPause;
	

	public JMainWindow(ActionListener listener) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(SIZE_WIDHT,SIZE_HEIGHT);
		setTitle(ANIMATED_GALLERY);
		setIconImage(new ImageIcon(getClass().getResource("/icon/icon.png")).getImage());


		CreateAnimation();

		jPanelAllImage = new JPanelAllImage();
		jPanelAllImage.setLayout(new FlowLayout());
		this.add(jPanelAllImage,BorderLayout.CENTER);

		btnPause = new JButton("Reset");
		btnPause.addActionListener(listener);
		btnPause.setActionCommand("Pause");
		this.add(btnPause, BorderLayout.SOUTH);
		
		
	}

	public void CreateAnimation() {
		panel = new PrincipalPanel();
		panel.setPreferredSize(new Dimension(getWidth(),30));
		add(panel,BorderLayout.NORTH);
		setVisible(true);
	}

	public void multyTarget(ImageIcon image) {
		jPanelAllImage.add(new JPanelImage(image));
		
	}

	public void clear() {
		jPanelAllImage.removeAll();
		jPanelAllImage.repaint();

	}
	
	public void visiblePanel() {
		remove(panel);
		setVisible(true);
	}


}
