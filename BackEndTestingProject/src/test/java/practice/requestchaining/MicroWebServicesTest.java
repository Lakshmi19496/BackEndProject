package practice.requestchaining;

import java.io.File;
import java.util.LinkedHashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoUtility.PaymentPojo;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class MicroWebServicesTest {
	@Test
	public void sample() {
		//Authoirsation POST Request to generate token
		System.out.println("=======AUTH======");
		JSONObject jobj=new JSONObject();
		jobj.put("access_key", "access_key_pKx7rWVgVpbXQvq2");
		jobj.put("access_secret", "access_secret_DX3w55VKAkXbx7aB");

		Response res = given()
				.contentType(ContentType.JSON)
				.body(jobj)
				.when()
				.post("https://api.nimbbl.tech/api/v3/generate-token");
		res.then().log().all()
		.assertThat().statusLine("HTTP/1.1 200 OK")
		.assertThat().statusCode(200);
		String token=res.jsonPath().get("token");
		System.out.println(token);
		
		
		//Create an order POST Request
		System.out.println("=======Order======");
		File f=new File("./nimbbl_order.json");
		Response res1 = given()
				.header("Authorization", "Bearer " + token)
				.contentType(ContentType.JSON)
				.body(f)
				.when()
				.post("https://api.nimbbl.tech/api/v3/create-order");
		res1.then().log().all()
		.assertThat().statusCode(201)
		.assertThat().statusLine("HTTP/1.1 201 Created");
		String orderId=res1.jsonPath().get("order_id");
		String userToken=res1.jsonPath().get("user.token");
		
		
		//Initiate Payment POST request
		System.out.println("=======Payment========");
		LinkedHashMap<String, String> initiatepaymetHeader=new LinkedHashMap<String, String>();
		initiatepaymetHeader.put("Authorization", "Bearer "+token);
		initiatepaymetHeader.put("x-nimbble-user-token", userToken);
		String data="{\r\n"
				+ "  \"order_id\": \""+orderId+"\",\r\n"
				+ "  \"callback_url\": \"https://mangoseller.awesome/transaction-response\",\r\n"
				+ "  \"payment_mode_code\": \"net_banking\",\r\n"
				+ "  \"bank_code\": \"axis"
				+ "}";
		Response res3 = given()
				.headers(initiatepaymetHeader)
				.body(data)
				.contentType(ContentType.JSON)
				
				.when()
				.post("https://api.nimbbl.tech/api/v3/create-order");
		res3.then().log().all();




	}

}
