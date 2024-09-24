package practice_ser;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run4_Jackson_DeserTest {
	@Test
	public void sample() throws Exception, Throwable, IOException {
		ObjectMapper objM=new ObjectMapper();
		Project pro=objM.readValue(new File("./project.json"), Project.class);
		
		System.out.println(pro.getCreatedBy());
		
		System.out.println(pro.getProjectName());
		System.out.println(pro.getStatus());
		System.out.println(pro.getTeamsize());
		
	}

}
