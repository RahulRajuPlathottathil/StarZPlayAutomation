package testCases;


import DataProviders.DataProviderHelper;
import api.LayoutBuilder;
import api.ModuleRequestBuilder;
import api.World;
import base.BaseTest;
import base.ExtractDataFromResponse;
import org.testng.annotations.Test;
import pojo.LayoutModel.Layout;
import pojo.Page;
import utility.PropertyReader;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

public class TestHere extends BaseTest {
    String methodName;

    @Test(dataProvider = "StarzPlayDataProvider", dataProviderClass = DataProviderHelper.class)
    public void TestCall(Hashtable<String, String> table) throws IOException {

        this.methodName = table.get("TestCase");
        test = extent.createTest(methodName, "Sample test description");
        System.out.println(table.get("RunMode"));
        Layout layout = LayoutBuilder.given().setBaserURI().setHeaders(table).setQueryParameter(table)
                .getLayout("layout/" + table.get("page") + "/" + PropertyReader.getSessionID());
        table.put("x-query", layout.getxQuery());
        table.put("x-token", layout.getxToken());
        List<Page> res = ModuleRequestBuilder.given().setBaserURI().setHeaders(table).setQueryParameter(table)
                .getModules();

        World.setLayout(layout);
        World.setMovie(res);

        ExtractDataFromResponse.apiScrambler();
    }

}
