package practice.responseValidation;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VerifyResponseTimeTest {
	@Test
	public void sample() {
		Response res = given().get("http://49.249.28.218:8091/projects");
		res.then().log().all();
		long timeTaken = res.time();
		long timeTakenSec = res.timeIn(TimeUnit.SECONDS);
		System.out.println(timeTaken+"   "+timeTakenSec);
		res.then().assertThat().time(Matchers.lessThan(2000L));
		res.then().assertThat().time(Matchers.greaterThan(200L));
		res.then().assertThat().time(Matchers.both(Matchers.lessThan(2000L)).and(Matchers.greaterThan(200L)));
	}

}
