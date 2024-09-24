package typesParameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class FormParameter {
	@Test
	public void sampleTest() {
		given()
		.formParam("teamSize", 0)
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/project")
		.then().log().all().assertThat().statusCode(200);
	}

}
