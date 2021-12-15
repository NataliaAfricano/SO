package models;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

public class CsvService implements Callable<HashMap<Integer, String>> {

    private final String filePath;
    
    public CsvService(String filePath){
        this.filePath = filePath;
    }

    @Override
    public HashMap<Integer, String> call() throws Exception {
        HashMap<Integer, String> errors = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        int row = 0;
        for (String line : lines) {
            Thread.sleep(10);
            String [] fields = line.split(",");
            int column = 0;
            String result = "";
            for (String field : fields) {
                if(field.isEmpty() || field.isBlank()){
                    result += column + ",";
                }
                column++;
            }
            if(!result.isEmpty() && !result.isBlank()){
                errors.put(row, result.substring(0, result.length() - 1));
            }
            row++;
        }
        return errors;
    }
}
