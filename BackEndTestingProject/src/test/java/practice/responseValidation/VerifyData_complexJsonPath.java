package practice.responseValidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import  io.restassured.response.Response;

public class VerifyData_complexJsonPath {

	@Test
	public void sampleTest() {
		Response res=given().get("http://49.249.28.218:8091/projects-paginated");
		res.then().log().all();

		List<String> names = JsonPath.read(res.asString(),"content[*].projectId");
		System.out.println(names);
		for (String string : names) {
			System.out.println(string);
		}
		System.out.println();
		List<String> list1 = JsonPath.read(res.asString(), ".content[*].[?(@.projectName=='GreenAPPLE_4064')].projectId");
		String actData=list1.get(0);
		Assert.assertEquals(actData, "NH_PROJ_979");
	}


}
