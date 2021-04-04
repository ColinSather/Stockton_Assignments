
public class Client implements Comparable {
	
	private int id;
	
	private static int lastID = 100;
	
	private String firstName;
	private String lastName;
	
	public Client(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		id = lastID++;
	}
	
	public int compareTo(Object otherObject) {
		String thisName = getName();
		Client otherClient = (Client) otherObject;
		return thisName.compareTo(otherClient.getName());
	}
	
	private String getName() {
		return lastName + ", " + firstName;
	}
	
	public String toString() {
		return getName();
	}
	
	public int getID() {
		return id;
	}

}
