package practice.requestchaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoUtility.ShopperLoginPojo;

public class Scenario_4ShopperLogin {
	@Test
	public void sample() {
		ShopperLoginPojo slp=new ShopperLoginPojo("satrasala.nagalakshmi@gmail.com", "Lakshmi@123", "SHOPPER");
		
		Response res=given().contentType(ContentType.JSON).body(slp).when()
				.post("https://www.shoppersstack.com/shopping/users/login");
		res.then().log().all()
		.assertThat().statusCode(200);
		
	}

}
