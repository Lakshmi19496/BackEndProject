package com.sample.crud.withBdd;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class SampleTestForReadTest {
	@Test
	public void getDataFromServer() {
	given().cookie("username","lakshmi","hi").log().all()
	.get("http://49.249.28.218:8091/projects")
	.then()
	   .assertThat().statusCode(200)
	   .log().all();
	
	
	
	}

}
