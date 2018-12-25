package XMLClasses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Rate")
public class Rate
{
	private String no;
	private String effectiveDate;
	private double mid;
	private double bid;
	private double ask;
	
	public Rate()
	{
		
	}
	
	public Rate(String no, String effectiveDate, double mid, double bid, double ask) 
	{
		this.no = no;
		this.effectiveDate = effectiveDate;
		this.mid = mid;
		this.bid = bid;
		this.ask = ask;
	}
	
	@XmlElement ( name = "No")
	public String getNo() 
	{
		return no;
	}
	
	public void setNo(String no) 
	{
		this.no = no;
	}
	
	@XmlElement ( name = "EffectiveDate")
	public String getEffectiveDate()
	{
		return effectiveDate;
	}
	
	public void setEffectiveDate(String effectiveDate)
	{
		this.effectiveDate = effectiveDate;
	}
	
	
	@XmlElement ( name = "Mid")
	public double getMid()
	{
		return mid;
	}
	
	public void setMid(double mid)
	{
		this.mid = mid;
	}

	@XmlElement ( name = "Bid")
	public double getBid() 
	{
		return bid;
	}
	
	public void setBid(double bid)
	{
		this.bid = bid;
	}
	
	@XmlElement ( name = "Ask")
	public double getAsk()
	{
		return ask;
	}
	
	public void setAsk(double ask)
	{
		this.ask = ask;
	}
	

}
