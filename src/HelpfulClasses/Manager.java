package HelpfulClasses;

import Rest.ClientNBP;
import XMLClasses.Informations;
import XMLClasses.Rates;

public class Manager 
{
	public static String LookFor(String table, String code, String topCount)
	{
		Rates answer;
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
		if ( answer != null )
		{
			Informations informations = new Informations();
			informations.setCode(answer.getCode());
			informations.setName(answer.getName());
			informations.setTable(answer.getTable());
			informations.setDates(answer.getRates().get(answer.getRates().size()-1).getEffectiveDate() + " - " + answer.getRates().get(0).getEffectiveDate());
			if ( answer.getMidMean() > 0 )
				informations.setMeanMid(Double.toString(answer.getMidMean()));
			else
				informations.setMeanMid("Mid's mean not found");
			if ( answer.getAskMean() > 0 )
				informations.setMeanAsk(Double.toString(answer.getAskMean()));
			else
				informations.setMeanAsk("Ask's mean not found");
			if ( answer.getBidMean() > 0 )
				informations.setMeanBid(Double.toString(answer.getBidMean()));
			else
				informations.setMeanBid("Bid's mean not found");
			return null;
			
		}
		else
		{
			return "Cannot get answer from NBP.";
		}
	}
}
