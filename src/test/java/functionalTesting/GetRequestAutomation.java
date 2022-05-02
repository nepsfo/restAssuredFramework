package functionalTesting;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetRequestAutomation {

	@Test
	public void getRequestAutomation() {
		
		   RestAssured.baseURI = "https://reqres.in/api/users"; // base URI		  
		   Response response = RestAssured.given().param("page", "2").when().get();
		  
		   System.out.println("Response(XXX): "+response.getBody().asString()); 
		  System.out.println("getStatusCode: "+response.getStatusCode()); 
		  System.out.println("contentType: "+response.contentType()); 
		  System.out.println("Time: "+ response.getTime()); 
		  System.out.println("Cookies: "+response.getCookies());
		  
		  System.out.println(response.prettyPrint());
		  
		 		/*
		 * RestAssured.baseURI = "https://reqres.in/api/users"; // base URI
		 * RestAssured.given().param("page", 2) .when() .get() .then() .assertThat()
		 * .log() .all() .statusCode(200);
		 */		  
		 

	}
	
	
	@Test
	public void postAPIAutomation() {
		RestAssured.baseURI = "https://reqres.in/api/users"; // base URI	
		String json = "{\r\n"
				+ "    \"name\": \"Fun Doo Testers\",\r\n"
				+ "    \"job\": \"SDET\"\r\n"
				+ "}";
		System.out.println("+++++++++++++====");
		System.out.println(json);
		RestAssured
		.given()
		.body(json)
		.post()
		.then()
		.log()
		.all()
		.statusCode(201);
		
		
		 
	}

	// @Test
	public void WeatherMessageBody()
	{
		RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.contains("Hyderabad") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
	}
}
