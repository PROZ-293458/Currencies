package Rest;

public class Search 
{
	public static String LookFor(String table, String code, String topCount)
	{
		String answer;
		double[] rates;
		int check = Check.CheckArgs(table, code, topCount);
		switch (check)
		{
		case 1:
			return "Pick the right table! Tables can be: A, B, C.";
		case 2:
			return "Pick the right number of last currency rates! Number must be less then 94.";
		case 3:
			return "Pick the right code of currency!";
		}
		answer = ClientNBP.Answer(table, code, topCount);
		if ( table.equals("A") || table.equals("B") )
		{
			rates = Search.getNumbersAB(answer, code, topCount);
			answer = Double.toString(MeanCalculator.Mean(rates));
		}
		else
		{
			
		}
		
		return answer;
	}
	
	private static double[] getNumbersAB ( String answer, String code, String topCount )
	{
		double[] rates = new double[Integer.parseInt(topCount)];
		int start = answer.indexOf("\"mid\":") + 6;
		int difference = 189-123;
		for ( int i = 0 ; i < Integer.parseInt(topCount) ; i++ )
		{
			rates[i] = Double.parseDouble(answer.substring(start + i * difference, start + i * difference + 6));
		}
		return rates;
	}
	
	private static double[] getNumbersCBid( String answer, String code, String topCount )
	{
		double[] rates = new double[Integer.parseInt(topCount)];
		return new double[2];
	}
}
