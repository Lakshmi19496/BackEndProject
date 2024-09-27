package graphql.test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllProjects {
	@Test
public void sample() {
		String str="{ getAllProjects{ projectId projectName status } }";
		given().body(str).contentType(ContentType.JSON)
		.when().post("http://49.249.28.218:8091/getAll")
		.then().log().all();
	
}
}
