package presenters;

import models.ProcessManager;
import views.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;

public class Presenter implements ActionListener {

    private Window window;
    private ProcessManager processManager;

    public Presenter() {
        this.window = new Window(this);
        processManager = new ProcessManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Event.valueOf(e.getActionCommand())){
            case SHOW_LOAD -> showLoadDialog();
        }
    }

    private void showLoadDialog() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(null);
        if(option == JFileChooser.APPROVE_OPTION){
            SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    Future<HashMap<Integer, String>> futureCsv = processManager.processFile(fileChooser.getSelectedFile().getPath());
                    int count = 0;
                    while(!futureCsv.isDone()) {
                        Thread.sleep(10);
                        publish(++count);
                    }
                    window.addNewFileReport(futureCsv.get());
                    return null;
                }

                @Override
                protected void process(List<Integer> chunks) {
                    super.process(chunks);
                    try {
                        window.addProgress(chunks.get(0), fileChooser.getSelectedFile().getName());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                protected void done() {
                    super.done();
                    window.changeCardToFinished(fileChooser.getSelectedFile().getName());
                }
            };
            worker.execute();
        }
    }

     public static void main(String[] args) {
        SwingUtilities.invokeLater(Presenter::new);
    }
}
