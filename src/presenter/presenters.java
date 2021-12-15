package presenter;

import java.io.File;

import javax.swing.ImageIcon;

import persistance.FileManager;
import view.JMainWindow;

public class presenters implements Runnable{
	
	private  FileManager fileManager;
	private JMainWindow jMainWindow;
	
	public presenters() {
		fileManager = new FileManager();
		jMainWindow = new JMainWindow();
		viewImage();
		
	}
	
	private void viewImage() {
		fileManager.viewImage();
		Thread hilo = new Thread(this);
		hilo.start();
		
	}
	
	@Override
	public void run() {
		while (true) {
			File aux = fileManager.obtainImage();
			if(aux != null) {
				jMainWindow.multyTarget(new ImageIcon(aux.getPath()));
			}else {
				break;
			}
		}
		jMainWindow.visiblePanel();
	}

	public static void main(String[] args) {
		new presenters();
	}
}


