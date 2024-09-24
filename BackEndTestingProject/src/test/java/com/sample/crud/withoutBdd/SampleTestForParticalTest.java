package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForParticalTest {
	@Test
	public void patchDataToServer() {
		
		//JSONObject jobj=new JSONObject();
		JSONObject jobj=new JSONObject();
		jobj.put("projectName", "pineapple_1000");
		RequestSpecification res = RestAssured.given();
		res.body(jobj.toJSONString());
		res.contentType(ContentType.JSON);
		Response resp = res.put("http://49.249.28.218:8091/project/NH_PROJ_659");
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
		
	}

}
