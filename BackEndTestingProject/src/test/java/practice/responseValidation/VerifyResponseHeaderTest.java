package practice.responseValidation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VerifyResponseHeaderTest {
	@Test
	public void sample() {
	Response res = given().get("http://49.249.28.218:8091/projects");
	res.then().log().all();
		res.then().assertThat().statusCode(200);
	
		res.then().assertThat().header("Transfer-Encoding", "chunked");
		res.then().statusLine("HTTP/1.1 200 ");
		res.then().contentType(ContentType.JSON);
		
	}

}
