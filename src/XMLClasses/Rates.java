package XMLClasses;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement ( name = "ExchangeRatesSeries")
public class Rates 
{
	private String name;
	private String code;
	private String table;
	private List<Rate> rates = new ArrayList<Rate>();
	
	public Rates()
	{
		
	}
	
	
	public Rates(String name, String code, String table, List<Rate> rates) 
	{
		this.name = name;
		this.code = code;
		this.table = table;
		this.rates = rates;
	}

	@XmlElement (name = "Currency")
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	@XmlElement ( name = "Code")
	public String getCode() 
	{
		return code;
	}

	public void setCode(String code) 
	{
		this.code = code;
	}

	@XmlElement ( name = "Table")
	public String getTable() 
	{
		return table;
	}

	public void setTable(String table) 
	{
		this.table = table;
	}

	@XmlElementWrapper ( name = "Rates" )
	@XmlElement ( name = "Rate")
	public List<Rate> getRates() 
	{
		return rates;
	}

	public void setRates(List<Rate> rates) 
	{
		this.rates = rates;
	}

	public Double getMidMean()
	{
		double mean = 0;
		for ( Rate x: rates)
		{
			mean+= x.getMid();
		}
		mean /= rates.size();
		if ( mean > 0)
			return mean;
		else
			return 0.0;
	}

	public Double getBidMean()
	{
		double mean = 0;
		for ( Rate x: rates)
		{
			mean+= x.getBid();
		}
		mean /= rates.size();
		if ( mean > 0)
			return mean;
		else
			return 0.0;
	}
	
	public Double getAskMean()
	{
		double mean = 0;
		for ( Rate x: rates)
		{
			mean+= x.getAsk();
		}
		mean /= rates.size();
		if ( mean > 0)
			return mean;
		else
			return 0.0;
	}

}
