import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Friend {
	private long id;
	private String firstName;
	private String lastName;
	private String nickName;
	private int noOfPosts;
	private int noOfFriends;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getNoOfPosts() {
		return noOfPosts;
	}

	public void setNoOfPosts(int noOfPosts) {
		this.noOfPosts = noOfPosts;
	}

	public int getNoOfFriends() {
		return noOfFriends;
	}

	public void setNoOfFriends(int noOfFriends) {
		this.noOfFriends = noOfFriends;
	}

	
	@Override
	public String toString() {
		return "Friend [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName
				+ ", noOfPosts=" + noOfPosts + ", noOfFriends=" + noOfFriends + "]";
	}

	public static void main(String[]args) throws IOException, ParseException {
		Friend vanshika=new Friend();
		
		vanshika.setFirstName("Vanshika");
		vanshika.setLastName("Rastogi");
		vanshika.setNickName("Vanshu");
		vanshika.setId(0);
		vanshika.setNoOfFriends(100);
		vanshika.setNoOfPosts(30);
		
		//Convert java object into jsonObject
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("id", vanshika.getId());
		jsonObject.put("FirstName", vanshika.getFirstName());
		jsonObject.put("LastName", vanshika.getLastName());
		jsonObject.put("NickName", vanshika.getNickName());
		jsonObject.put("NoOfFriends", vanshika.getNoOfFriends());
		jsonObject.put("NoOfPosts", vanshika.getNoOfPosts());
		
		System.out.println(vanshika);
		System.out.println(jsonObject);
		
		System.out.println("Starting of writing in File");
		System.out.println("**************************************************************");
		
		File file=new File("fb-friends.json");
		file.createNewFile();
		FileWriter fw=new FileWriter(file);
		fw.write(jsonObject.toString());
		fw.flush();
		fw.close();
		
		System.out.println("Completed File Writing");
		System.out.println("***************************************************************");
		System.out.println("****************Serialization Stopped+9****************************");
		System.out.println("****************Deserialization Start**************************");
		
		//---------------JSONParser--to read json data
		JSONParser jsonParser=new JSONParser();
		Object rawObject=jsonParser.parse(new FileReader("friend.json"));
		JSONObject loadedJSONObject=(JSONObject)rawObject;
		Long noOfPosts=(Long)loadedJSONObject.get("noOfPosts");
		System.out.println("NoOfPosts \t"+noOfPosts);
		System.out.println("Resulted JSON object is \n "+loadedJSONObject);
	}
}
