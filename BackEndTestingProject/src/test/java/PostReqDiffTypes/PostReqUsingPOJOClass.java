package PostReqDiffTypes;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import pojoUtility.ProjectPojo;

public class PostReqUsingPOJOClass {
	@Test
	public void sample() {
		Random rand=new Random();
		int x=rand.nextInt(1000);
		ProjectPojo pObj=new ProjectPojo("Lakshmi", "Created", 0, "Cane_"+x);
		given().config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type"))).contentType(ContentType.JSON).body(pObj).when()
		.post("http://49.249.28.218:8091/addProject").then().assertThat().statusCode(201).log().all();
		
	}

}
