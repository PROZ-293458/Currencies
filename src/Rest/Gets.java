package Rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import HelpfulClasses.Manager;


@Path("exchangerates/rates")
public class Gets 
{
	@GET
	@Path("{table}/{code}/{topCount}")
	public String Rates(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") String topCount)
	{
		String answer = new String (Manager.LookFor(table, code, topCount));
		
		return answer;
	}
	
}
