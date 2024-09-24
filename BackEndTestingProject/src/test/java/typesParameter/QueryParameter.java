package typesParameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryParameter {
	@Test
	public void sampleTest() {
		given()
		.queryParam("teamSize", 0)
		.log().all()
		.when()
		.get("http://49.249.28.218:8091/project")
		.then().log().all();
	}

}
