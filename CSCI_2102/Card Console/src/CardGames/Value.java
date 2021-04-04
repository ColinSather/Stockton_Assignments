package CardGames;

// This is a helper class provided to you. Its use is not required, but it may help you.

public class Value {

	String value;
	int count;
	
	public Value(String value) {
		this.value = value;
		count = 0;
	}
	
	public String toString() {
		return value;
	}
	
	public String getValue() {
		return value;
	}
	
	public int getCount() {
		return count;
	}
	
	public void increment() {
		count++;
	}
		
}
