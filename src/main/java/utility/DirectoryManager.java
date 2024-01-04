package utility;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DirectoryManager {

    public static void createDirectory(String folderPath) {
        try {
            Path folder = Paths.get(folderPath);
            if (!Files.exists(folder))
                Files.createDirectory(folder);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateFileName() {
        String timestamp = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            timestamp = now.format(formatter);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return timestamp;
    }
}
