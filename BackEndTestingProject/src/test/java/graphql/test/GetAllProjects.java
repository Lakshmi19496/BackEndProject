package graphql.test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoUtility.ProjectPojo;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class GetAllProjects {
	@Test
	public void sample() {
		String str="{ getAllProjects{ projectId projectName status } }";
		given().body(str).contentType(ContentType.JSON)
		.when().post("http://49.249.28.218:8091/getAll")
		.then().log().all();

	}
	@Test
	public void sample1() {
		String str="{ findEmployees(projectId:\"NH_PROJ_975\"){ empId empName mobileNo email dob experience username designation role project } }";
		given().body(str).contentType(ContentType.JSON)
		.when().post("http://49.249.28.218:8091/getEmployeesByProjectId-graphql")
		.then().log().all();

	}
	
	
	@Test 
	public void update() {
		ProjectPojo obj=new ProjectPojo("lakshmi", "Created", 0, "proddatur"+new Random().nextInt(1000));
	String str="mutation { addProject( projectName: \"Dharmavaram\", teamSize: 0, createdBy: \"lakshmi\", createdOn: \"2024-9-30\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
	Response res = given().body(str).contentType(ContentType.JSON)
		.when().post("http://49.249.28.218:8091/addProject-graphql");
		res.then().log().all();
		
		
		
	}
	@Test
	public void sample3() {
		
		String str1="mutation{ updateProject( projectId: \"NH_PROJ_3036\" projectName: \"Updated Project Name\", teamSize: 0, createdBy: \"Ravi\", createdOn: \"2024-10-12\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
			given().body(str1).contentType(ContentType.JSON)
			.when().post("http://49.249.28.218:8091/updateProject-graphql")
			.then().log().all();
	}
	
}
