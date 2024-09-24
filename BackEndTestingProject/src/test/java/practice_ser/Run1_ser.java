package practice_ser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFS implements Serializable{
	String name;
	int level;
	int life;
	long score;
	public NFS(String name, int level, int life, long score) {
		super();
		this.name = name;
		this.level = level;
		this.life = life;
		this.score = score;
	}
	
}

public class Run1_ser {
	
	public static void main(String[] args) throws Throwable {
		NFS user1=new NFS("lakshmi",14,12,190000);
		FileOutputStream fos=new FileOutputStream("./f.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(user1);
		System.out.println("=====end=====");
		
	}

}
