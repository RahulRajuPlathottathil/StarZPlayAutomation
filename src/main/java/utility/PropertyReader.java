package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

    public static String getProperty(String propertyName) {
        Properties properties = new Properties();
        String prop = null;

        try (FileInputStream input = new FileInputStream(DirectoryLookUP.PROPERTY_FILE)) {
            properties.load(input);
            prop = properties.getProperty(propertyName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String getENV() {
        return getProperty("env");
    }

    public static String getBaseURI() {
        return getProperty(getENV().trim()).trim();
    }

    public static String getSessionID() {
        return getProperty("sessionAuth").trim();
    }
    public static void main(String[] args) {
        System.out.println(getSessionID());
        System.out.println(getBaseURI());
    }

}