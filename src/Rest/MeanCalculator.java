package Rest;

public class MeanCalculator 
{

	static public double Mean( double[] rates)
	{
		double sum = 0;
		for ( double x : rates )
			sum += x;
		return sum/ rates.length ;
	}
}
