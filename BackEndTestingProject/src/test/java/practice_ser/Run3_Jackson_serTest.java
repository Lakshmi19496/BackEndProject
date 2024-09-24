package practice_ser;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(
		value= {"createdBy","projectName","status","teamsize"}
		)

@JsonIgnoreProperties(
		value= {"teamsize"})
class Project{
	private String projectName;
	@JsonProperty(value="created By")
	private String createdBy;
	//@JsonProperty(value="team Size")
	private int teamsize;
	private String status;
	public Project() {}
	public Project(String projectName, String createdBy, int teamsize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamsize = teamsize;
		this.status = status;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getTeamsize() {
		return teamsize;
	}
	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}

public class Run3_Jackson_serTest {
	@Test
	public void sample() throws IOException, DatabindException, IOException {
		Project pro=new Project("Orange","lakshmi",10,"created");
		ObjectMapper objM=new ObjectMapper();
		objM.writeValue(new File("./project.json"), pro);

	}

}
