package practice.requestchaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoUtility.ProjectPojo;

public class Scenario_1DeleteProject {
	@Test
	public void sample() {
		//Add project ===>API-1
		Random rand=new Random();
		int x=rand.nextInt(1000);
		ProjectPojo pObj=new ProjectPojo("Lakshmi", "Created", 0, "Cane_"+x);
		Response res=given().contentType(ContentType.JSON).body(pObj).when()
		.post("http://49.249.28.218:8091/addProject");
		String projectId=res.jsonPath().get("projectId");
		res.then().assertThat().statusCode(201).log().all();
		
		//delete project====>API-2
		given().delete("http://49.249.28.218:8091/project/"+projectId)
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
	}


}
