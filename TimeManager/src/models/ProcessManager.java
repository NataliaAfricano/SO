package models;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProcessManager {

    private ExecutorService executor;

    public ProcessManager(){
        executor = Executors.newFixedThreadPool(3);
    }

    public Future<HashMap<Integer, String>> processFile(String file){
        CsvService service = new CsvService(file);
        return executor.submit(service);
    }
}
