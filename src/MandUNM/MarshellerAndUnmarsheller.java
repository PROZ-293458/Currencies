package MandUNM;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;

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
			String answer = new String();
		    JAXBContext jContext = JAXBContext.newInstance(Informations.class);
		    Marshaller marshallObj = jContext.createMarshaller();
		    //setting the property to show xml format output
		    marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    //calling the marshall method
		    //marshallObj.mars
		    return null;
	}
}
