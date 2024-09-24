package practice.requestchaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OauthToken {
	@Test
	public void sample() {
		//API-1 getAuth 
		Response res= given()
				.formParam("client_id", "ninza-client")
				.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
				.formParam("grant_type", "client_credentials")
				.when()
				.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		res.then()
		.log().all();
		String token=res.jsonPath().get("access_token");


		//API-2 get projects info
		given().auth().oauth2(token)
	.get("http://49.249.28.218:8091/projects").then().log().all();

	}

}
