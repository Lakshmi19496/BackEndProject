package typesParameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class ParamParameter {
	@Test
	public void sample() {
		given()
		.param("projectId", "NH_PROJ_966")
		.log().all()
		.when()
		.get("http://49.249.28.218:8091/project/")
		.then().log().all();
	}

}
