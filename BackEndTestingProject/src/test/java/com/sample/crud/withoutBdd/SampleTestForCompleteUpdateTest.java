package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {
	@Test
	public void putDataToServer() {
		JSONObject jobj=new JSONObject();
		jobj.put("projectName", "Apple_1000");
		RequestSpecification res = RestAssured.given();
		res.body(jobj.toJSONString());
		res.contentType(ContentType.JSON);
		Response resp = res.put("http://49.249.28.218:8091/project/NH_PROJ_659");
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
	//	System.out.println("===============");
	//	resp.prettyPeek();
		
		
	}

}
