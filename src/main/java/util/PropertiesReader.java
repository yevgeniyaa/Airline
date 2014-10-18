package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PropertiesReader {
    private Properties properties = new Properties();

    public void loadProperty() {
        try {
            properties.load(new InputStreamReader(new FileInputStream(System.getProperty("user.dir") +
                    IPropertiesHolder.FILE_NAME_INPUT), "UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<List<String>> getProperties() {
        List<List<String>> listOfPlanes = new ArrayList<List<String>>();
        for (String key : properties.stringPropertyNames()) {
            try {
                listOfPlanes.add(readLine(key));
            } catch (IllegalArgumentException e) {
                System.err.println("[IllegalArgumentException]: Not enough arguments in " + key.toUpperCase() +
                        ". Plane will not be loaded");
            }
        }
        return listOfPlanes;
    }

    private ArrayList<String> readLine(String key) throws IllegalArgumentException {
        String value = properties.getProperty(key);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(key);
        String values[] = value.split(";");
        if (values.length < 4) {
            throw new IllegalArgumentException();
        }
        Collections.addAll(arrayList, values);
        return arrayList;
    }
}
