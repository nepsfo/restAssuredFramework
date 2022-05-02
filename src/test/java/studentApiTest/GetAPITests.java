package studentApiTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAPITests extends BaseTest{
	
	@Test
	public void getAPITest() {
		// from json-server - http://localhost:3000/
		// https://www.youtube.com/watch?v=bPKZup7-y6c&list=PLuqnSAN_m8K1sP5KeICTdtiMJyE4eZxSv&index=16
		// json-server --watch db.json   (TO START THE SERVER)
		
		//RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_POSTS).then().log().all().statusCode(400);

		HeaderConfigs hc = new HeaderConfigs();
		
		test.log(LogStatus.INFO, "My test is starting...");
		// {{{{ Starting Get method }}}}
		// Response response = RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_POSTS);
		// http://localhost:3000/users/
		Response response = RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_USERS);
//		test.log(LogStatus.INFO, response.getBody().asString());
//		test.log(LogStatus.INFO, "My status code is "+ response.getStatusCode());
//		test.log(LogStatus.INFO, "Response Time is "+response.getTime());

		// System.out.println(response.getBody().asString());
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getCookies());
//		System.out.println(response.getTime());
		
		
		  JSONArray array = new JSONArray(response.getBody().asString()); 
		  for(int i=0; i< array.length(); i++) { 
			  //System.out.println(i+" : "+ array.get(i));
			  JSONObject obj = array.getJSONObject(i); 
			  test.log(LogStatus.INFO,"Validated values are "+obj.get("last_name"));
			  System.out.println("last_name: **: "+obj.get("last_name"));
		  }
		 
		
		APIVerification.responseCodeValidation(response, 200);
		APIVerification.responseTimeValidation(response);
		APIVerification.responseKeyValidation(response, "title");
		
		test.log(LogStatus.INFO, "My test is pass....");
		test.log(LogStatus.INFO, "My test is end...");
	}
	
	//my test to check some function
	@Test
	public void printResponseinArrayAndJsonObject() {
		// {{{{ Starting Get method }}}}
		Response response = RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_POSTS);
		System.out.println("Call disectResponse");
		APIVerification.disectResponse(response);
	}
	
	
	@Test
	public void getAPITest1() {
		//RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_POSTS).then().log().all().statusCode(400);

		Response response = RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_POSTS);
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getCookies());
		System.out.println(response.getTime());
		
		JSONArray array = new JSONArray(response.getBody().asString());
		for(int i=0; i< array.length(); i++) {
			//System.out.println(i+" : "+ array.get(i));
			JSONObject obj = array.getJSONObject(i);
			System.out.println(obj.get("title"));
		
		}
		
	}
	
	@Test 
	public void bearerTokenAuthorizationHeader() throws IOException {
		URL url = new URL("https://reqbin.com/echo/get/json");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Bearer {token}");

		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();
	}

}
