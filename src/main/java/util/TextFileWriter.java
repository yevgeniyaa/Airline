package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter {
    public static void writeToFile(String text, boolean isNeedToBeCleanedAtFirst) {
        File file = new File(System.getProperty("user.dir") + IPropertiesHolder.FILE_NAME_OUTPUT);
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            System.err.println("Error occurred during file creating");
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, !isNeedToBeCleanedAtFirst));
            bufferedWriter.write(text);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error occurred during writing to file");
        }
    }

    public static void writeToFile(String text) {
        writeToFile(text, false);
    }
}
