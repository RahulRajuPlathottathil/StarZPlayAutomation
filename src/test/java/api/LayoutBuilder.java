package api;
import DataLogics.ImageLogic;
import base.BaseTest;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import pojo.LayoutModel.Layout;
import utility.DirectoryLookUP;
import utility.PropertyReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class LayoutBuilder {
    private RequestSpecification requestSpecification;

    public static LayoutBuilder given() {
        return new LayoutBuilder();
    }

    public LayoutBuilder setBaserURI() {
        RestAssured.baseURI = PropertyReader.getBaseURI();//"https://sp-new-api.aws.playco.com/api/v1.1/";
        requestSpecification=RestAssured.given();

        return this;
    }

    public LayoutBuilder setHeaders(Hashtable<String, String> data) {

        Map<String,String> headers = new HashMap<>();
        headers.put("content-type",data.get("content-type"));
        headers.put("x-profiletype",data.get("x-profiletype"));
        headers.put("x-geo-country",data.get("x-geo-country"));
        this.requestSpecification.headers(headers);
        return this;
    }

    public LayoutBuilder setQueryParameter(Hashtable<String,String> data) {
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("lang",data.get("lang"));
        queryParams.put("platform",data.get("platform"));
        queryParams.put("origin",data.get("origin"));
        queryParams.put("parentalControl",data.get("parentalControl"));
        queryParams.put("version",data.get("version"));
        queryParams.put("x-geo-country",data.get("x-geo-country"));
        queryParams.put("profileType",data.get("x-profiletype"));
        this.requestSpecification.queryParams(queryParams);
        ImageLogic.setPlatform(data.get("platform"));
        ImageLogic.setVersion(data.get("version"));
        ImageLogic.setOrigin(data.get("origin"));
        return this;

    }

    public Layout getLayout(String endPoint) throws IOException {
        Response response=requestSpecification.get(endPoint);
        Layout layout =response.then().extract().response().as(Layout.class);
        String filePath= DirectoryLookUP.RESPONSE_FILE +"//layout.txt";
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(response.asString());
            bufferedWriter.flush();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(layout.getxToken());
        System.out.println(layout.getxQuery());
        if(response.getStatusCode()!=200 || (layout.getxToken().length()==0) || layout.getTotal()==0)
        BaseTest.test.log(Status.FAIL,"Layout call is not successfully");
        Assert.assertEquals(response.getStatusCode(),200,"Status Code");
        Assert.assertTrue(layout.getxToken().length()>0,"Tocken Maching ");
        Assert.assertTrue(layout.getTotal()>0,"Layout Total");
        return layout;
    }

}
