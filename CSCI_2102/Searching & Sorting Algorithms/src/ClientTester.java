import java.util.ArrayList;
import java.util.Collections;

public class ClientTester {

	public static void main(String[] args) {
		
		ArrayList<Client> clients = new ArrayList<>();
		
		clients.add(new Client("Spyro","Roubos"));
		clients.add(new Client("Demetrios","Roubos"));
		clients.add(new Client("Olex","Roubos"));
		
		for (Client client : clients) {
			System.out.println(client.getID() + ": " + client);
		}
		
		Collections.sort(clients);
		System.out.println();
		
		for (Client client : clients) {
			System.out.println(client.getID() + ": " + client);
		}

	}

}
