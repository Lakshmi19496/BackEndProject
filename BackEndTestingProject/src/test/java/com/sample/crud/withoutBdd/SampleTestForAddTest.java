package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForAddTest {
	@Test
	public void postDataToServer() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Lakshmi");
		jobj.put("status", "Created");
		jobj.put("teamSize", 0);
		jobj.put("projectName", "Insata+0960");
		
		RequestSpecification re = RestAssured.given();
		re.contentType(ContentType.JSON);
		re.body(jobj.toJSONString());// here josn object is in key and value pair so we have convert into jsonstring it is mandatory before passing into body
		Response resp=re.post("http://49.249.28.218:8091/addProject");
		resp.then().log().all();
		resp.then().assertThat().statusCode(201);
		System.out.println("===============");
		resp.prettyPeek();
		System.out.println("===============");
		resp.prettyPrint();
		
		
	}

}
