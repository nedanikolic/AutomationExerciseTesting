package utils;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileUtils {
    public static String createTestFile() throws IOException {

        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "\\testfile.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            FileWriter writer = new FileWriter(file);
            writer.write("This file was created automatically by Selenium test.");
            writer.close();
        }

        return filePath;
    }
}

