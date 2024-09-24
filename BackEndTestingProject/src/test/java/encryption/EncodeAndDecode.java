package encryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class EncodeAndDecode {
	@Test
	public void sampleTest() {
		String encodeData=new String(Base64.getEncoder().encode("rmgyantra:rmgy@9999".getBytes()));
		System.out.println(encodeData);
		
		String decodeData=new String(Base64.getDecoder().decode("cm1neWFudHJhOnJtZ3lAOTk5OQ==".getBytes()));
		System.out.println(decodeData);
		
	}
}
