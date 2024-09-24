package PostReqDiffTypes;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReqUsingJsonFile {

	@Test
	public void sample() {
		File f=new File("./pro1.json");

		given().contentType(ContentType.JSON).body(f).when()
		.post("http://49.249.28.218:8091/addProject").then().assertThat().statusCode(201).log().all();



	}

}
