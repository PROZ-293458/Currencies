package Rest;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;

import javax.ws.rs.client.Client;

public class ClientNBP 
{
	static public String Answer(String table, String code, String topCount)
	{
		String url = new String("http://api.nbp.pl/api/exchangerates/rates/" + table + "/" + code + "/last/" + topCount + "/");
		//utworzenie obiektu klasy Client
		Client client = ClientBuilder.newClient();
		// konstruowanie adresu URI
		// URI uri = UriBuilder.fromUri("http://localhost:8080/atj").queryParam("idx", "12345").build();
		URI uri = URI.create(url);
		//reprezentacja zasobu
		
		WebTarget webTarget = client.target(uri);
		//wywo³anie ¿¹dania i odebranie odpowiedzi
		String response = webTarget.request().accept(MediaType.TEXT_PLAIN).get(Response.class).toString();
		String plainAnswer = webTarget.request().accept(MediaType.TEXT_PLAIN).get(String.class);
		if ( response.contains("OK") )
			return plainAnswer;
		else
			return "Cannot get a answer from nbp.";
	}
}
