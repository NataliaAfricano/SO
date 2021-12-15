package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class PrincipalPanel extends JPanel{

	
	private static final long serialVersionUID = 1L;
	public static final int SIZE_WIDHT = (int) JMainWindow.SIZE_WIDHT/2;
	public static final int SIZE_HEIGHT = (int) JMainWindow.SIZE_HEIGHT/2;
	private int x1 = this.getWidth()/2 ;
	private int y1 = this.getHeight()/2;
	private static final int SIZE = 30;
	private boolean condition;
	
	
	public PrincipalPanel() {
		setMinimumSize(getMaximumSize());
		starAnimation();
	}
	
	
	public void conditionAnimation(boolean condition) {
		this.condition = condition;

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Random r = new Random();
		Color randomColor = new Color( r.nextInt(256), r.nextInt(256), r.nextInt(256) );
		g.setColor(randomColor);
		g.fillOval(x1, y1, SIZE, SIZE);
	        
	}
	public void starAnimation() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (condition != true) {
					while(x1/2 < SIZE_WIDHT/2) {
						x1 ++;
						repaint();
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					x1= SIZE_WIDHT/4;
					repaint();
				}
				
			}
		}).start();
	}
}
