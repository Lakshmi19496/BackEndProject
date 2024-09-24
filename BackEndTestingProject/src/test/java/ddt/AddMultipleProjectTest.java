package ddt;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Iterator;

public class AddMultipleProjectTest {
	@Test(dataProvider = "getData")
	public void sampleTest(String pName,String status) {
		//String pName="uber";
		//String status="Created";
		String data="{\r\n"
				+ "  \"createdBy\": \"Lakshmi\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		given().contentType(ContentType.JSON)
		.body(data)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.log().all();
	}
	@DataProvider
	public Object[][] getData() throws Throwable {
		
		ExcelUtility eu=new ExcelUtility();
		
		int rowCount=eu.getRowCount("Sheet1");
		int cellCount=eu.getCellCount("Sheet1", 1);
		Object[][] obj=new Object[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				obj[i-1][j]=eu.getDataFromExcelFile("Sheet1", i, j);
				
			}
		}
		return obj;
		
	}

}
