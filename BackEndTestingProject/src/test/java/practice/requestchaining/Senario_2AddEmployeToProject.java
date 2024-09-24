package practice.requestchaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoUtility.EmployeePojo;
import pojoUtility.ProjectPojo;

public class Senario_2AddEmployeToProject {
	@Test
	public void sample() {
		//Add project ===>API-1
		Random rand=new Random();
		int x=rand.nextInt(1000);
		ProjectPojo pObj=new ProjectPojo("Lakshmi", "Created", 0, "Cane_"+x);
		Response res=given().contentType(ContentType.JSON).body(pObj).when()
				.post("http://49.249.28.218:8091/addProject");
		String projectName=res.jsonPath().get("projectName");
		res.then().assertThat().statusCode(201).log().all();


		//add employee to same project
		
		EmployeePojo emp=new EmployeePojo("Arcticet", "19/04/1996", "abc@gmail.com", "user_"+x, 18, "1234567890", projectName, "ROLE_EMPLOYEE","user_"+x);
given().contentType(ContentType.JSON).body(emp).when().post("http://49.249.28.218:8091/employees").then().log().all().assertThat().statusCode(201);

	}

}
