package practice.responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class VerifyResponseBodyTest {
	
	@Test
	public void sample() {
		Response res=given().get("http://49.249.28.218:8091/projects-paginated");
		res.then().log().all();
	res.then().assertThat().body("numberOfElements", Matchers.equalTo(20));
	//res.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_838"));
	res.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
	res.then().assertThat().time(Matchers.lessThan(3000l));
	int value=res.jsonPath().get("numberOfElements");
	String name=res.jsonPath().get("content[0].projectId");
	boolean res1=res.jsonPath().get("pageable.sort.unsorted");
	
	ArrayList<String> a=res.jsonPath().get("content.projectName");
	System.out.println(value+"  "+name+"  "+res1);
	System.out.println(a);
	
	
	}

}
