package utility;

import javax.print.attribute.standard.MediaSizeName;

public class DirectoryLookUP {
    public static final String ROOT_DIR =System.getProperty("user.dir");
    public static final String EXTENT_REPORT= ROOT_DIR+"/src/test/resources/ExtentReports";
    public static final String LOGS= ROOT_DIR+"/src/test/resources/Logs";
    public static final String RESPONSE_FILE= ROOT_DIR+"/src/test/resources/Response";
    public static final String PROPERTY_FILE= ROOT_DIR+"/src/test/resources/Properties/config.properties";

    public static final String TEST_RUNNER =ROOT_DIR+"/src/test/resources/Data/TestRunner.xlsx";

    public static void main(String[] args) {
        DirectoryManager.createDirectory(EXTENT_REPORT);
        DirectoryManager.createDirectory(LOGS);
        DirectoryManager.createDirectory(RESPONSE_FILE);
    }
}
