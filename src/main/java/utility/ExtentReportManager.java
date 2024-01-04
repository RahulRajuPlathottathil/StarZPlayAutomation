package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportManager {
    public static ExtentReports extent;

    public static ExtentReports creteInstance(){
        if(extent==null){
            String reportPath=DirectoryLookUP.EXTENT_REPORT+"//ExtentReport_"+DirectoryManager.generateFileName()+".html";
            ExtentHtmlReporter sparkStatus = new ExtentHtmlReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(sparkStatus);


        }
        return  extent;
    }

    public static void main(String[] args) {
        creteInstance();
    }
}
