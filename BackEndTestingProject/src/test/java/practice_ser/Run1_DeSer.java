package practice_ser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Run1_DeSer {
public static void main(String[] args) throws Throwable {
	FileInputStream fin=new FileInputStream("./f.txt");
	ObjectInputStream oin=new ObjectInputStream(fin);
	NFS nfs = (NFS)oin.readObject();//return of readObject() is Object so downcast to NFS
	System.out.println(nfs.name);
	System.out.println(nfs.level);
	System.out.println(nfs.life);
	System.out.println(nfs.score);
	
}
}
