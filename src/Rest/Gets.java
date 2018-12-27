package Rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import HelpfulClasses.Manager;


@Path("exchangerates/rates/{table}/{code}/{topCount}")
public class Gets 
{
	@GET
	@Produces(MediaType.TEXT_XML)
	public String RatesXML(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") String topCount)
	{
		String answer = new String (Manager.LookFor(table, code, topCount));
		return answer;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String RatesHTML(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") String topCount)
	{
		String answer = new String (Manager.LookFor(table, code, topCount));
		JSONObject xmlJSONObj = XML.toJSONObject(answer);
		return jsonToHtml(xmlJSONObj);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String RatesJSON(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") String topCount)
	{
		String answer = new String (Manager.LookFor(table, code, topCount));
		JSONObject xmlJSONObj = XML.toJSONObject(answer);
        String jsonPrettyPrintString = xmlJSONObj.toString();
		return jsonPrettyPrintString;
	}
	
	private String jsonToHtml( Object obj ) 
	{
	    StringBuilder html = new StringBuilder( );

	    try 
	    {
	        if (obj instanceof JSONObject) 
	        {
	            JSONObject jsonObject = (JSONObject)obj;
	            String[] keys = JSONObject.getNames( jsonObject );

	            html.append("<div class=\"json_object\">");

	            if (keys.length > 0) 
	            {
	                for (String key : keys) 
	                {
	                    // print the key and open a DIV
	                    html.append("<div><span class=\"json_key\">")
	                        .append(key).append("</span> : ");

	                    Object val = jsonObject.get(key);
	                    // recursive call
	                    html.append( jsonToHtml( val ) );
	                    // close the div
	                    html.append("</div>");
	                }
	            }

	            html.append("</div>");

	        } 
	        else if (obj instanceof JSONArray) 
	        {
	            JSONArray array = (JSONArray)obj;
	            for ( int i=0; i < array.length( ); i++) 
	            {
	                // recursive call
	                html.append( jsonToHtml( array.get(i) ) );                    
	            }
	        }
	        else 
	        {
	            // print the value
	            html.append( obj );
	        }                
	    }
	    catch (JSONException e) 
	    { 
	    	return e.getLocalizedMessage( ) ; 
	    }

	    return html.toString( );
	}
	
}
