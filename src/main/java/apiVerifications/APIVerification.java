package apiVerifications;

import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.ExtentReportListner;
import io.restassured.response.Response;


public class APIVerification extends ExtentReportListner{

	public static void responseCodeValidation(Response response, int statusCode) {
		try {
			Assert.assertEquals(statusCode, response.getStatusCode());
			test.log(LogStatus.PASS, "Successfully validated status code, status code is :: "+response.getStatusCode());
			
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			test.log(LogStatus.FAIL, "Expected status code is :: " + statusCode +", instead of getting :: "+ response.getStatusCode());
			
		} catch ( Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
		
		
	}
	
	/**
	 * @param response
	 * @param key
	 */
	public static void responseKeyValidation(Response response, String key) {
		try {
			JSONArray array = new JSONArray(response.getBody().asString());
			for(int i=0; i< array.length(); i++) {
				//System.out.println(i+" : "+ array.get(i));
				JSONObject obj = array.getJSONObject(i);
				test.log(LogStatus.PASS, "Validated values are "+obj.get(key));
				//System.out.println(obj.get("title"));
			}
			
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getMessage());
		}
	}
	
	public static void responseTimeValidation(Response response) {
		try {
			long time = response.time();
			test.log(LogStatus.INFO, "Api response time is :: "+ time);
		} catch (Exception e){
			//TODO: handle exception
		}
	}
	/*
	 * public static void responseKeyValidationfromArray(Response response, String
	 * key) { try { JSONArray array = new JSONArray(response.getBody().asString());
	 * for(int i=0; i<array.length();i++) { JSONObject obj = array.getJSONObject(i);
	 * test.log(LogStatus.PASS, "Validetd values are  " + obj.get(key));
	 * 
	 * } } catch (Exception e) { test.log(LogStatus.FAIL, e.fillInStackTrace()); } }
	 */
	
	/**
	 * My function to check 
	 * - jsonarray from response
	 * - jsonobject from jsonarray-response
	 * @param response - is provided when the method is called
	 */
	public static void disectResponse(Response response) {
		JSONArray jsArray = new JSONArray(response.body().asString());
		JSONObject jsObj=null;
		System.out.println("JSONArray");
		for (Object object : jsArray) {
			System.out.print(object +", ");
		}
		System.out.println("\nJSONObject");
		for(int i=0; i<jsArray.length(); i++) {
			jsObj = jsArray.getJSONObject(i);
			System.out.println(jsObj);
		}
		System.out.println(jsObj.get("author"));
	}
}
