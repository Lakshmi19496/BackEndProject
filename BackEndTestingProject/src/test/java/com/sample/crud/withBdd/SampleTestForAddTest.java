package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForAddTest {
	@Test
	public void postDataToServer() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Lakshmi");
		jobj.put("status", "Created");
		jobj.put("teamSize", 0);
		jobj.put("projectName", "Insata+0123");
		
		given().contentType(ContentType.JSON).body(jobj.toJSONString()).when()
		.post("http://49.249.28.218:8091/addProject").then().assertThat().statusCode(201).log().all();
		
		
	}

}
