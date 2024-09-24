package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {
	@Test
	public void putDataToServer() {
		JSONObject jobj=new JSONObject();
		jobj.put("projectName", "Apple_1000");
		
		given()
		.body(jobj.toJSONString())
		.contentType(ContentType.JSON)
		.when()
		.put("http://49.249.28.218:8091/project/NH_PROJ_674")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}
