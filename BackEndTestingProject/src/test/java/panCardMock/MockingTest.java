package panCardMock;

import org.mockito.Mockito;

class panCard{
	//business logic
	public  String isvalid(String panCard) {
		//in proper shema what ever data u pass it will say it is valid pancard
		//but as per mocking they will give dummy data we have to use same data that is rule in mocking
		//when ever i devlop stub we have give mock data i.e synthethic data that act like real data
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true) {
			return "valid PanCard";
		}
		else
			return "in-valid PanCard";
	}
	//stub
	public static panCard getMockObject() {
		//Mockito is class useing this we are adding mock data
		//if we want to use mck data then we call this method,it will retun obj of PANcard,useing that object we call isvalid()
		panCard mocObj = Mockito.mock(panCard.class);
		//using when() we are providing dummy data i.e mock data
		Mockito.when(mocObj.isvalid("ABCDE1234A")).thenReturn("Valid PanCard");
		Mockito.when(mocObj.isvalid("ABCDE1234C")).thenReturn("Valid PanCard");
		Mockito.when(mocObj.isvalid("ABCDE1234z")).thenReturn("In-Valid PanCard");
		
		return mocObj;
		
	}
}
 
public class MockingTest {

	public static void main(String[] args) {
		//System.out.println(panCard.isvalid("ABCBH1987n"));
		panCard obj = panCard.getMockObject();
		System.out.println(obj.isvalid("ABCDE1234z"));
		

	}

}
