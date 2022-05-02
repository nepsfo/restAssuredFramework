

package baseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import utils.ExtentReportListner;
import utils.FileandEnv;

@Listeners(ExtentReportListner.class)
public class BaseTest extends ExtentReportListner {
	@BeforeClass
	public void utilsTest() {
		// from json-server - http://localhost:3000/
		// https://www.youtube.com/watch?v=bPKZup7-y6c&list=PLuqnSAN_m8K1sP5KeICTdtiMJyE4eZxSv&index=16
		// json-server --watch db.json   (TO START THE SERVER)
		RestAssured.baseURI = "http://localhost:3000/";

	}

}
