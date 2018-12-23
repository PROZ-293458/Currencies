package Rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("exchangerates/rates")
public class Gets 
{
	@GET
	@Path("{table}/{code}/{topCount}")
	public String sayTable(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") String topCount)
	{
		String answer = new String (Search.LookFor(table, code, topCount));
		return answer;
	}
	
}
