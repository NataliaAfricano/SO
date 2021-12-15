package views;

import presenters.Event;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Window extends JFrame {

    public static final String[] COLUMN_IDENTIFIERS = {"Row", "Errors"};
    private JPanel panelCenter;
    private JPanel panelStatus;

    public Window(ActionListener listener) {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("CSV");
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menu = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem itemLoad = new JMenuItem("Load");
        itemLoad.addActionListener(listener);
        itemLoad.setActionCommand(Event.SHOW_LOAD.name());
        menu.add(menuFile);
        menuFile.add(itemLoad);
        setJMenuBar(menu);

        panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        add(panelCenter, BorderLayout.CENTER);

        panelStatus = new JPanel();
        add(panelStatus, BorderLayout.PAGE_END);

        setVisible(true);
    }

    public void addNewFileReport(HashMap<Integer, String> errors){
        JPanel panelCard = new JPanel();
        panelCard.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(COLUMN_IDENTIFIERS);
        errors.forEach((key, value) -> model.addRow(new Object[]{key, value}));
        JTable table = new JTable(model);
        panelCard.add(new JScrollPane(table));
        panelCenter.add(panelCard);
        panelCenter.repaint();
        panelCenter.revalidate();
    }

    public void addProgress(int time, String name) throws MalformedURLException {
        Component [] components = panelStatus.getComponents();
        for (Component component : components) {
            WorkCard lb = (WorkCard) component;
            if ((lb.getName()).equals(name)){
                lb.setTime(time);
                return;
            }
        }
        panelStatus.add(new WorkCard(String.valueOf(time), name));
        panelStatus.repaint();
        panelStatus.revalidate();
    }

    public void changeCardToFinished(String name) {
        Component [] components = panelStatus.getComponents();
        for (Component component : components) {
            WorkCard lb = (WorkCard) component;
            if ((lb.getName()).equals(name)){
                lb.setStopIcon();
                return;
            }
        }
    }
}
