package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;

import persistance.FileManager;
import view.JMainWindow;

public class presenters implements Runnable, ActionListener {

    private FileManager fileManager;
    private JMainWindow jMainWindow;
    private boolean pause;

    public presenters() {
        fileManager = new FileManager();
        jMainWindow = new JMainWindow(this);
        viewImage();

    }

    public static void main(String[] args) {
        new presenters();
    }

    private void viewImage() {
        fileManager.viewImage();
        Thread hilo = new Thread(this);
        hilo.start();

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            File aux = fileManager.obtainImage();
            if (aux != null) {
                jMainWindow.multyTarget(new ImageIcon(aux.getPath()));
            } else {
                break;
            }
        }
        jMainWindow.visiblePanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Pause")) {
            jMainWindow.clear();
            jMainWindow.CreateAnimation();
            viewImage();
        }
    }
}


