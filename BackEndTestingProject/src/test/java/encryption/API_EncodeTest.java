package encryption;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class API_EncodeTest {
	@Test
	public void sampleTest() {
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		//.auth().basic(null, null)
		//.auth().digest(null, null)
		//.auth().oauth2(null)
		
		.log().all()
		.when()
		.get("http://49.249.28.218:8091/projects")
		.then()
		.log().all();
	}

}
