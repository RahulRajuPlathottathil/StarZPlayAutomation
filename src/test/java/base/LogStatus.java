package base;

import DataProviders.ExpectedValues;
import com.aventstack.extentreports.Status;
import pojo.Page;
import utility.PropertyReader;

import java.util.List;

public class LogStatus {

    public static void verify(String Field, String Expected, String Actual) {
        String message = String.format("<label>Expected : %s<label></br> <label>Actual : %s</label> %s</label></br>", Expected, Actual);
        Status status;
        System.out.println("*******************"+PropertyReader.getProperty("isPassReportEnabled"));
        if (Expected.equals(Actual)) {
            status = Status.PASS;
            if(PropertyReader.getProperty("isPassReportEnabled").trim().equals("true")) {
                BaseTest.test.log(status, message);
            }
        }
        else {
            status = Status.FAIL;

            BaseTest.test.log(status, message);
        }


    }

    public static void Verfiy(String Field, int Expected, int Actual) {
        System.out.println("*******************"+PropertyReader.getProperty("isPassReportEnabled"));
        String message = String.format("<b>Field Validation - %s<b> </br><label>Allowed Values : %s<label></br> <label>Actual : %s</label></br>", Field, Expected, Actual);
        Status status;
        if (Expected == Actual) {
            status = Status.PASS;
            if(PropertyReader.getProperty("isPassReportEnabled").trim().equals("true")){
                System.out.println("Logger---");
                BaseTest.test.log(status, message);}
        }
        else {
            status = Status.FAIL;

            BaseTest.test.log(status, message);
        }
    }

    public static void Verify(String Field, List<String> Expected, List<String> Actual) {
        System.out.println("*******************"+PropertyReader.getProperty("isPassReportEnabled"));
        String message = String.format("<b>Field Validation - %s<b> </br><label>Allowed Values : %s<label></br> <label>Actual : %s</label></br>", Field, Expected, Actual);
        Status status;
        if (Actual.containsAll(Expected)) {
            status = Status.PASS;
            if(PropertyReader.getProperty("isPassReportEnabled").trim().equals("true"))
                BaseTest.test.log(status, message);
        }
        else {
            status = Status.FAIL;

            BaseTest.test.log(status, message);
        }
    }

    public static void Verify(String Field, long Expected, long Actual) {
        System.out.println("*******************"+PropertyReader.getProperty("isPassReportEnabled"));
        String message = String.format("<b>Field Validation - %s<b> </br><label>Allowed Values : %s<label></br> <label>Actual : %s</label></br>", Field, Expected, Actual);
        Status status;
        if (Expected == Actual) {
            status = Status.PASS;
            if(PropertyReader.getProperty("isPassReportEnabled").trim().equals("true"))
                BaseTest.test.log(status, message);
        }
        else {
            status = Status.FAIL;

            BaseTest.test.log(status, message);
        }
    }

    public static void VerifyActalGreaterThanOrEqualsExpected(String Field, int Expected, int Actual) {
        System.out.println("*******************"+PropertyReader.getProperty("isPassReportEnabled"));
        String message = String.format("<b>Field Validation - %s<b> </br><label>Allowed Values : %s<label></br> <label>Actual : %s</label></br>", Field, Expected, Actual);
        Status status;
        if (Expected <= Actual) {
            status = Status.PASS;
            if(PropertyReader.getProperty("isPassReportEnabled").trim().equals("true"))
                BaseTest.test.log(status, message);
        }
        else {
            status = Status.FAIL;

            BaseTest.test.log(status, message);
        }
    }

    public static void Verify(String Field, List<Integer> Expected, int Actual) {
        String message = String.format("<b>Field Validation - %s<b> </br><label>Allowed Values : %s<label></br> <label>Actual : %s</label></br>", Field, Expected, Actual);
        Status status;
        if (Expected.contains(Actual)) {
            status = Status.PASS;
            if(PropertyReader.getProperty("isPassReportEnabled").trim().equals("true"))
            BaseTest.test.log(status, message);
        }
        else {
            status = Status.FAIL;
            BaseTest.test.log(status, message);
        }


    }

    public static void Verify(String Field, List<String> actual, String expected) {
        String message = String.format("<b>Field Validation - %s<b> </br><label>Allowed Values : %s<label></br> <label>Actual : %s</label></br>", Field, expected, actual);
        Status status;
        if (actual.contains(expected)) {
            status = Status.PASS;
            if(PropertyReader.getProperty("isPassReportEnabled").trim().equals("true")) {
                BaseTest.test.log(status, message);
            }
        }
        else {
            status = Status.FAIL;
            BaseTest.test.log(status, message);
        }


    }

    public static void verifyProgramType(int programType, Page.Title title) {


        if (programType == 2) {
            Verfiy("Program Type ", 2, programType);
            if (title.getContinueWatching().getProgress().getPercentage() <= 1.0) {
                if(PropertyReader.getProperty("isPassReportEnabled").trim().equals("true"))
                BaseTest.test.log(Status.PASS, "Progress:" + title.getContinueWatching().getProgress().getPercentage());
            } else {
                BaseTest.test.log(Status.FAIL, "");

            }

        } else {
            Verify("Program Type : ", ExpectedValues.programTypes, programType);
        }


    }

    public static void VerifyContentOwnership(String Field,List<String> actual){
        Status status = ExpectedValues.contentOwnership.containsAll(actual)?Status.PASS:Status.FAIL;
        String message = String.format("<b>Field Validation - %s<b> </br><label>Allowed Values : %s<label></br> <label>Actual : %s</label></br>", Field, ExpectedValues.contentOwnership, actual);
        if(status.equals(Status.PASS)) {
            if( PropertyReader.getProperty("isPassReportEnabled").trim().equals("true"))
            BaseTest.test.log(Status.PASS, message);
        }
        else
        BaseTest.test.log(status,message);
    }
    public static void VerifySubsciption(String Field,List<String> actual){
        Status status = ExpectedValues.subscription.containsAll(actual)?Status.PASS:Status.FAIL;
        String message = String.format("<b>Field Validation - %s<b> </br><label>Allowed Values : %s<label></br> <label>Actual : %s</label></br>", Field, ExpectedValues.subscription, actual);
        if(status.equals(Status.PASS)) {
            if( PropertyReader.getProperty("isPassReportEnabled").trim().equals("true"))
                BaseTest.test.log(Status.PASS, message);
        }
        else
            BaseTest.test.log(status,message);
    }
    public static void VerifyCountryRights(String Field,List<String> actual){
        Status status = ExpectedValues.countryRights.containsAll(actual)?Status.PASS:Status.FAIL;
        String message = String.format("<b>Field Validation - %s<b> </br><label>Allowed Values : %s<label></br> <label>Actual : %s</label></br>", Field, ExpectedValues.countryRights, actual);
        if(status.equals(Status.PASS)) {
            if( PropertyReader.getProperty("isPassReportEnabled").trim().equals("true"))
                BaseTest.test.log(Status.PASS, message);
        }
        else
            BaseTest.test.log(status,message);
    }
}

