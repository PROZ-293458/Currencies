package XMLClasses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlType;

@XmlRootElement ( name = "Information")
//@XmlType(propOrder = { "Name", "Code", "Table", "Dates", "MeanMid", "MeanBid", "MeanAsk"})
public class Informations 
{
	private String Name;
	private String Code;
	private String Table;
	private String Dates;
	private String MeanMid;
	private String MeanBid;
	private String MeanAsk;
	
	@XmlElement ( name = "Name")
	public String getName() 
	{
		return Name;
	}
	public void setName(String name) 
	{
		Name = name;
	}
	
	@XmlElement ( name = "Code")
	public String getCode() 
	{
		return Code;
	}
	public void setCode(String code) 
	{
		Code = code;
	}
	
	@XmlElement ( name = "Table")
	public String getTable() 
	{
		return Table;
	}
	public void setTable(String table) 
	{
		Table = table;
	}
	
	@XmlElement ( name = "Dates")
	public String getDates() 
	{
		return Dates;
	}
	public void setDates(String dates) 
	{
		Dates = dates;
	}
	
	@XmlElement ( name = "Mid")
	public String getMeanMid() 
	{
		return MeanMid;
	}
	public void setMeanMid(String meanMid) 
	{
		MeanMid = meanMid;
	}
	
	@XmlElement ( name = "Bid")
	public String getMeanBid() 
	{
		return MeanBid;
	}
	public void setMeanBid(String meanBid) 
	{
		MeanBid = meanBid;
	}
	
	@XmlElement ( name = "Ask")
	public String getMeanAsk() 
	{
		return MeanAsk;
	}
	public void setMeanAsk(String meanAsk) 
	{
		MeanAsk = meanAsk;
	}
}
