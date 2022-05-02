package studentApiTest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostAPITest extends BaseTest{

	@Test
	public void validPostAPITest() {
		// from json-server - http://localhost:3000/
		// https://www.youtube.com/watch?v=bPKZup7-y6c&list=PLuqnSAN_m8K1sP5KeICTdtiMJyE4eZxSv&index=16
		// json-server --watch db.json   (TO START THE SERVER)
		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();
		
//		Response response = RestAssured.given().when().headers(header.defaultHeaders()).body(builder.postRequestBody()).when().post(APIPath.apiPath.CREATE_POST);		
		Response response = RestAssured.given().when().body(builder.postRequestBody()).when().post(APIPath.apiPath.CREATE_POST);	
		System.out.println(response.body().asString());
		System.out.println(response.getStatusCode());
	}
	
	@Test
	public void myPostTestLocal3000users() {
		Map<String, String> body = new HashMap<String, String>();
		body.put("id", "19");
		body.put("first_name", "Name19");
		body.put("subjectId", "1");
		
		Response response = RestAssured.given().
				when().
				body(body).
				when().
				post("/users");
		System.out.println(response.asPrettyString());
	}
}
