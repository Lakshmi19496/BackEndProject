package PostReqDiffTypes;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostmanRequestUsingJsonObj {
	@Test
	public void sample() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Lakshmi");
		jobj.put("status", "Created");
		jobj.put("teamSize", 0);
		jobj.put("projectName", "Insata+01234");
		
		given().contentType(ContentType.JSON).body(jobj.toJSONString()).when()
		.post("http://49.249.28.218:8091/addProject").then().assertThat().statusCode(201).log().all();
	}

}
