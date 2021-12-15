package views;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class WorkCard extends JLabel {

    private static Icon icon;
    private static Icon iconStop;

    static {
        try {
            icon = new ImageIcon(new URL("https://icons8.com/preloaders/preloaders/1487/%E2%80%8B%E2%80%8BIphone-spinner-1.gif"));
            iconStop = new ImageIcon(new URL("https://cdn1.iconfinder.com/data/icons/sport-fitness-vol-2/512/03-marathon-running-race-finish-256.png"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public WorkCard(String time, String id) throws MalformedURLException {
        setIcon(icon);
        setPreferredSize(new Dimension(200,200));
        setText("Time:" + time);
        setName(id);
    }

    public void setTime(int time){
        setText("Time:" + time);
    }

    public void setStopIcon() {
        setIcon(iconStop);
    }
}
