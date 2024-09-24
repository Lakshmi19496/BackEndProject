package practice_ser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;



class Project1 {


	private String projectName;


	private String projectStatus;


	private int teamsize;


	private List<String> teamMember;


	private ProjectManager projectManager;


	public Project1(String projextName, String projectStatus, int teamsize, List<String> teamMember,
			ProjectManager projectManager) {
		super();
		this.projectName = projextName;
		this.projectStatus = projectStatus;
		this.teamsize = teamsize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}
	public void setProjextName(String projextName) {
		this.projectName = projextName;
	}
	public String getProjextName() {
		return projectName;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public String getProjectStatus() {
		return projectStatus;
	}

	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}
	public int getTeamsize() {
		return teamsize;
	}

	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}
	public List<String> getTeamMember() {
		return teamMember;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}
	public ProjectManager getProjectManager() {
		return projectManager;
	}

}




class ProjectManager {


	private String name;


	private String id;


	public ProjectManager(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}

}






public class Run5_JacksonSer {

	public static void main(String[] args) throws Exception, DatabindException, IOException {
		List<String> al=new ArrayList<String>();
		al.add("stev");
		al.add("jhon");
		al.add("king");
		ProjectManager pM=new ProjectManager("sagar", "tp_01");
		Project1 pobj=new Project1("Lakshmi", "created", 10, al, pM);
		ObjectMapper objM=new ObjectMapper();
		objM.writeValue(new File("./Project1.json"), pobj);
	}

}
