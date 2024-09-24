package encryption;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UpdatePayTest {
	@Test
public void sampleTest() throws Throwable {
		
		String jBody="{ \"employee\": { \"empId\":\"NH_00102\", \"designation\": \"Tester\", \"dob\": \"dd/MM/yyyy\", \"email\": \"gopika@gmail.com\", \"empName\": \"Lakshmi\", \"experience\":4, \"mobileNo\": \"9801234567\", \"project\": \"bsnl_1740\", \"role\": \"string\", \"username\": “user_1740” }, \"basicPlusVda\": 0, \"hra\": 1000, \"insurance\": 1000, \"lta\": 0, \"lwf\": 0, \"netPay\": 0, \"payroll_id\": 1000, \"pf\": 10000, \"pt\": 1000, \"stat_bonus\": 1000, \"status\": “Active/Disabled” };";
		
				String privateKey="Ac03tEam@j!tu_#1";
				EncrpAndDecrytUtility ed=new EncrpAndDecrytUtility();
				String data=ed.encrypt(jBody, privateKey);
				System.out.println(data);
				Response res = given()
				.body(data)
				.when()
				.put("http://49.249.28.218:8091/payroll");
				res.then().log().all();
		//		String resbody = ed.decrypt(res.getBody().asString(), privateKey);
			//	System.out.println(resbody);
}
}
