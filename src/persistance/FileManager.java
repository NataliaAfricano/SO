package persistance;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

import javax.imageio.ImageIO;

public class FileManager {

    private static final String PATH_IMAGES = "./images/";
    private static final String PATH_RESULT = "./imageOut/";
    private ArrayList<File> completeCopyFile;
    private boolean complete;

    public FileManager() {
        completeCopyFile = new ArrayList<>();
        complete = false;
    }

    public String[] readFiles() {
        File folder = new File(PATH_IMAGES);
        return folder.list();

    }

    public void viewImage() {
        String[] images = readFiles();
        try {
            deleteFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String image : images) {
            try {
                viewImage(new File(PATH_IMAGES + image));
                Thread.sleep(10);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void viewImage(File path) throws IOException {
        BufferedImage image = ImageIO.read(path);
        // Crear directorio "imageOut" si no existe
        File dir = new File(PATH_RESULT);
        if (!dir.exists()) {
            dir.mkdir();
        }
        ImageIO.write(image, "png", new File(PATH_RESULT + path.getName()));
        try {
            completeCopyFile.add(new File(PATH_RESULT + path.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        completeCopyFile.sort(Comparator.comparingLong(File::length));

    }

    public File obtainImage() {
        System.out.println("" + completeCopyFile);
        if (0 < completeCopyFile.size()) {
            File aux = completeCopyFile.remove(0);
            return aux;
        } else {
            return null;
        }
    }

    public void deleteFiles() throws IOException {
        Files.walk(Paths.get(PATH_RESULT)).map(Path::toFile).forEach(File::delete);
    }


}
