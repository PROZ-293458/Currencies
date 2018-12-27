package MandUNM;

import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import XMLClasses.Informations;
import XMLClasses.Rate;
import XMLClasses.Rates;

public class MarshellerAndUnmarsheller 
{

	public static Rates Unmarshell(String xmlAnswer)
	{
		try
		{
			JAXBContext jContext = JAXBContext.newInstance(Rates.class, Rate.class);
			Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
		    StringReader reader = new StringReader(xmlAnswer);
		    Rates rates=(Rates) unmarshallerObj.unmarshal(reader);
			return rates;
		}
		catch ( Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static String Marshall( Informations informations)
	{
		
		try
		{
			File file = new File ("informations.txt");
		    JAXBContext jContext = JAXBContext.newInstance(Informations.class);
		    Marshaller marshallObj = jContext.createMarshaller();
		    marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    marshallObj.marshal(informations, file);
		    if ( file.exists() )
		    {
		    	String content = new String ( Files.readAllBytes( Paths.get("informations.txt") ) );
			    file.delete();
			    return content;
		    }
		    else
		    	return "<?xml version=\"1.0\"?>" + "<info>Some Errors with getting informations.</info>";
		    
		}
		catch ( Exception e)
		{
			e.printStackTrace();
		}
		return "<?xml version=\"1.0\"?>" + "<info>Error with packing informations.</info>";
	}
}
