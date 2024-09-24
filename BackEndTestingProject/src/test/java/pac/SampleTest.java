package pac;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class SampleTest {
	@Test
	public void sampleGetRequest() {
			get("https://reqres.in/api/users?page=2").then().log().all();// gives complete response
			
			
			 //Response res = RestAssured.get("https://reqres.in/api/users?page=2");
			 //System.out.println(res.prettyPrint());//gives only payload of response
		
	}
}
