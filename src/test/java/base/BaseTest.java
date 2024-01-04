package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utility.DirectoryLookUP;
import utility.DirectoryManager;
import utility.ExtentReportManager;

public class BaseTest {
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentTest childTest;
    static int count=0;
    public static String  methodName;
    @BeforeSuite
    public void setUp() {
     setOutDirs();
     extent = ExtentReportManager.creteInstance();
    }
    @AfterSuite

    public void Done() {
      //  extent.flush();
    }


     public void setOutDirs(){
        DirectoryManager.createDirectory(DirectoryLookUP.EXTENT_REPORT);
        DirectoryManager.createDirectory(DirectoryLookUP.LOGS);
        DirectoryManager.createDirectory(DirectoryLookUP.RESPONSE_FILE);
    }
}
