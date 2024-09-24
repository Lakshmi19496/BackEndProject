package PostReqDiffTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReqUsingHashMap {
	@Test
	public void sample() {
		HashMap<String, Object> map=new HashMap<>();
		map.put("createdBy", "Lakshmi");
		map.put("status", "Created");
		map.put("teamSize", 0);
		map.put("projectName", "Insata+012345");
		
		given().contentType(ContentType.JSON).body(map).when()
		.post("http://49.249.28.218:8091/addProject").then().assertThat().statusCode(201).log().all();
	}

}
