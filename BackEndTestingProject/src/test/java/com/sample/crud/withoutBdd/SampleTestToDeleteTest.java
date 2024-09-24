package com.sample.crud.withoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestToDeleteTest {
	@Test
	public void deleteTest() {
		Response res = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_659");
		res.then().log().all();
	}

}
