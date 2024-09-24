package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForParticalTest {
	@Test
	public void patchDataToServer() {
		
		//JSONObject jobj=new JSONObject();
		JSONObject jobj=new JSONObject();
		jobj.put("projectName", "pineapple_1000");
		given()
		.contentType(ContentType.JSON)
		.body(jobj.toJSONString())
		.when()
		.patch("http://49.249.28.218:8091/project/NH_PROJ_674")
		.then()
		.assertThat().statusCode(200)
		.log().all()
;		

		
	}

}
