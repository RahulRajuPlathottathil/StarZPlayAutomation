package api;

import java.io.BufferedWriter;

import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;




import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Page;
import utility.DirectoryLookUP;
import utility.PropertyReader;


public class ModuleRequestBuilder {
	private RequestSpecification requestSpecification;
	String page;

	public static ModuleRequestBuilder given() {
		return new ModuleRequestBuilder();
	}

	public ModuleRequestBuilder setBaserURI() {
		RestAssured.baseURI = "https://sp-new-api.aws.playco.com/api/v1.1/";
		requestSpecification = RestAssured.given();
		return this;
	}

	public ModuleRequestBuilder setHeaders(Hashtable<String, String> data) {

		Map<String, String> headers = new HashMap<>();
		headers.put("content-type", "application/json");
		headers.put("x-profiletype", data.get("x-profiletype"));
		headers.put("x-geo-country", data.get("x-geo-country"));
		//headers.put("client-type", data.get("client-type"));
		headers.put("x-query", data.get("x-query"));
		headers.put("x-token", data.get("x-token"));
		this.requestSpecification.headers(headers);
		return this;

	}

	public ModuleRequestBuilder setQueryParameter(Hashtable<String, String> data) {
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("platform", data.get("platform"));
		queryParams.put("origin", data.get("origin"));
		queryParams.put("x-geo-country", data.get("x-geo-country"));
		queryParams.put("version", data.get("version"));
		queryParams.put("profileType", data.get("x-profiletype"));
		queryParams.put("modules", data.get("modules"));
		this.page = data.get("page");
		this.requestSpecification.queryParams(queryParams);
		return this;

	}

	public List<Page> getModules() throws IOException {
		requestSpecification.log().all();
		Response response = requestSpecification.get("modules/" + this.page + "/" + PropertyReader.getSessionID());//getGuid

		String filePath = DirectoryLookUP.RESPONSE_FILE +"/Response_module.txt";
		try (FileWriter fileWriter = new FileWriter(filePath);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

			// Write content to the text file
			bufferedWriter.write(response.asString());
			bufferedWriter.flush();
			fileWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(response.asPrettyString());

		List<Page> module = (List<Page>) response.then().extract().response().jsonPath().getList("", Page.class);
		return module;
	}

}
