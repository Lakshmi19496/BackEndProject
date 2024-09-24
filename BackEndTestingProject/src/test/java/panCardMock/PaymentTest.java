package panCardMock;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PaymentTest {
	//mocking server acts as real payment appln but it is not
	//it is going hit mocking server and get response from mocking server
	//using Spark we created mocking solution using gson we reading data from request and providing response
	//once project is converted to jar file it is called mocking server
	//these kinf of mockig solutions are used anywhere in ecommerce application
	@Test
	public void sampleTest() {
		JSONObject body=new JSONObject();
		body.put("creditcard", "1234567891236");
		body.put("cvv", "456");
		body.put("cardName", "Lakshmi");
		
		given()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.post("http://localhost:8889/credit-card")
		.then()
		.log().all();
		
	}

}
