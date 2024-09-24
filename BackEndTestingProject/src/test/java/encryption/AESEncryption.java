package encryption;

import org.testng.annotations.Test;

public class AESEncryption {
	@Test
	public void sampleTest() throws Throwable {
	String privateKey="Ac03tEam@j!tu_#1";
	String data="{\"name\":\"Lakshmi\",\"id\":\"tp_01\"}";
	EncrpAndDecrytUtility ed=new EncrpAndDecrytUtility();
	String data1=ed.encrypt(data, privateKey);
	System.out.println(ed.encrypt(data, privateKey));
	
	System.out.println(ed.decrypt(data1, privateKey));
	}
	

}
