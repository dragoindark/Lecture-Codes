import java.util.ArrayList;
import java.util.HashMap;

public class FarukBurakGurelLAB3SE30913012020 {

	public static void main(String[]args) {
		
	}
}

abstract class User{
	protected String name;
	protected String id; //primary key
	protected String type;
	protected ArrayList<User> network=new ArrayList<User>();
	protected ArrayList<String> recievedMessages=new ArrayList<String>();
	public String toString() {
		return "The user name is "+this.name+" user id is "+this.id+" user type is "+this.type+" user currently has "
				+this.network.size()+" amount of friends in their network";
	}
	public User(String name,String id) {
		this.name=name;
		this.id=id;
	}
	public void addNetwork(User userObject) {
		if(this.network.contains(userObject)) {
			System.out.println("The given user is already in the friend list");
		}else {
			this.network.add(userObject);		
		}
	}
	public void removeNetwork(User userObject) {
		if(this.network.contains(userObject)) {
			this.network.remove(userObject);
		}
	}
	public void removeNetworkID(String id) {
		boolean found=false;
		for(int i=0;i<this.network.size();i++) {
			if(this.network.get(i).getId().equalsIgnoreCase(id)) {
				System.out.println("Removing user with the id "+id);
				this.network.remove(i);
				found=true;
			}
		}
		if(found==false) {
			System.out.println("User not found");
		}
	}
	public ArrayList<User> getNetwork(){
		return this.network;
	}
	public ArrayList<String> getMessages(){
		return this.recievedMessages;
	}
	public void recieveMessage(String message) {
		System.out.println("The user information can be seen below");
		this.toString();
		System.out.println("Showing the recieved message");
		System.out.println(message);
		System.out.println("Adding message to the archive");
		this.recievedMessages.add(message);
	}
	public void showAllMessages() {
		System.out.println("The user information can be seen below");
		this.toString();
		System.out.println("Showing all of the recieved messages");
		for(int i=0;i<this.recievedMessages.size();i++) {
			System.out.println(this.recievedMessages.get(i));
		}
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setId(String id) {
		this.id=id;
	}
	public void setType(String type) {
		this.type=type;
	}
	public String getName() {
		return this.name;
	}
	public String getId() {
		return this.id;
	}
	public String getType() {
		return this.type;
	}
}

class Employer extends User{
	public Employer(String name, String id) {
		super(name, id);
		this.type="Employer";
	}
	
}

class Jobseeker extends User{
	public Jobseeker(String name, String id) {
		super(name, id);
		this.type="Jobseeker";
	}
	
}

abstract class SocialPlatform{
	protected ArrayList<User> userList=new ArrayList<User>();
	//I have moved object creation here,and they need to give 3 parameters
	//depending on the object class changes
	//userName and id will be kept inside the object
	//By moving the object creation and handling here
	//When a user is deleted from the arraylist
	//It will be also deallocated from the memory
	public void addUser(String userName,String id,String type) {
		if(type.equalsIgnoreCase("employer")) {
			userList.add(new Employer(userName,id));
		}else if(type.equalsIgnoreCase("jobseeker")) {
			userList.add(new Jobseeker(userName,id));
		}else {
			System.out.println("Illegal type");
		}
	}
	public void removeUser(String id) {
		boolean found=false;
		for(int i=0;i<this.userList.size();i++) {
			if(this.userList.get(i).getId().equalsIgnoreCase(id)) {
				System.out.println("Removing user with the id "+id);
				this.userList.remove(i);
				found=true;
			}
		}
		if(found==false) {
			System.out.println("User not found");
		}
	}
	public void sendMessage(String id,String message) {
		boolean found=false;
		for(int i=0;i<this.userList.size();i++) {
			if(this.userList.get(i).getId().equalsIgnoreCase(id)) {
				System.out.println("Sending message to the user with the id "+id);
				this.userList.get(i).recieveMessage(message);
				found=true;
			}
		}
		if(found==false) {
			System.out.println("User not found");
		}
	}
	public void broadcastMessage(String message) {
		for(int i=0;i<this.userList.size();i++) {
			System.out.println("Sending message to the user with the id of "+this.userList.get(i).getId());
			this.userList.get(i).recieveMessage(message);
		}
	}
	public void addNetwork(String id,String thisUserID) {
		User userDummy=null;
		for(int i=0;i<this.userList.size();i++) {
			if(this.userList.get(i).getId().equalsIgnoreCase(id)) {
				userDummy=this.userList.get(i);
			}
		}
		for(int i=0;i<this.userList.size();i++){
			if(this.userList.get(i).getId().equalsIgnoreCase(thisUserID)) {
				this.userList.get(i).addNetwork(userDummy);			
			}
		}
	}
	public void removeNetworkWithoutID(String fromThisUserID,String userWithThisID) {
		boolean found=false;
		int dummyIndex=-1;
		User dummyUser=null;
		for(int i=0;i<this.userList.size();i++) {
			if(this.userList.get(i).getId().equalsIgnoreCase(fromThisUserID)) {
				dummyIndex=i;
			}
		}
		for(int i=0;i<this.userList.size();i++) {
			if(this.userList.get(i).getId().equalsIgnoreCase(userWithThisID)) {
				System.out.println("Removing the user with the id "+userWithThisID);
				this.userList.get(dummyIndex).removeNetwork(this.userList.get(i));
			}
		}
	}
	public void removeNetwork(String fromThisUserID,String userWithThisID) {
		boolean found=false;
		for(int i=0;i<this.userList.size();i++) {
			if(this.userList.get(i).getId().equalsIgnoreCase(fromThisUserID)) {
				found=true;
				for(int k=0;k<this.userList.get(i).getNetwork().size();k++) {
					if(this.userList.get(i).getNetwork().get(k).getId().equalsIgnoreCase(userWithThisID)) {
						System.out.println("Removing the user with this ID "+userWithThisID);
						this.userList.get(i).getNetwork().get(k).removeNetworkID(userWithThisID);
					}
					
				}
			}
		}
		if(found==false) {
			System.out.println("User with the id "+fromThisUserID+" not found");
		}
	}
	
}

class Linkedin extends SocialPlatform{
	
}





























