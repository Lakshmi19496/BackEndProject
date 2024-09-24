package panCardMock;



import org.apache.commons.lang3.StringUtils;

import com.jayway.jsonpath.JsonPath;

import spark.Spark;


public class CreditCardMock {

	public static void main(String[] args) {
		Spark.port(8889);
		Spark.post("/credit-card",  (req,res)->{
			String card=JsonPath.read(req.body().toString(), "$.creditcard");
			String response="";
			if(StringUtils.equalsAny(card,"1234567890987","1234567891234")) {
				response="{\r\n"
						+ "\"status\":\"payment sucess\"\r\n"
						+ "}";
				res.status(200);

			}
			else
			{
				response="{\r\n"
						+ "\"status\":\"payment failed\"\r\n"
						+ "}";
				res.status(404);
			}
			res.type("application/json");
			return response;
		});
		System.out.println("=======running.....=====");
		
	}

}
