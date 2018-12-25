package MandUNM;

import java.io.File;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringReader;

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
			ObjectOutputStream os = new ObjectOutputStream();
		    JAXBContext jContext = JAXBContext.newInstance(Informations.class);
		    Marshaller marshallObj = jContext.createMarshaller();
		    return "Null";
		    /*marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    marshallObj.marshal(informations, os);
		    return os.toString();*/
		}
		catch ( Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
