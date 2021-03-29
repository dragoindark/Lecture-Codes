
public class Main {

	public static void main(String[] args) {
		SocialPlatform linkedin=new Linkedin();
		
		linkedin.addUser("Burak","123", "Employer");
		linkedin.addUser("Ahmet","456", "Jobseeker");
		linkedin.addNetwork("123","456");
		linkedin.broadcastMessage("Hello world");
		linkedin.removeNetwork("123", "456");

	}

}
