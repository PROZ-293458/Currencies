package HelpfulClasses;

import MandUNM.MarshellerAndUnmarsheller;
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
			return "<?xml version=\"1.0\"?>" + "<info>Pick the right table! Tables can be: A, B, C.</info>";
		case 2:
			return "<?xml version=\"1.0\"?>" + "<info>Pick the right number of last currency rates! Number must be less then 94.</info>";
		case 3:
			return "<?xml version=\"1.0\"?>" + "<info>Pick the right code of currency!</info>";
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
				informations.setMeanMid("No informations");
			if ( answer.getAskMean() > 0 )
				informations.setMeanAsk(Double.toString(answer.getAskMean()));
			else
				informations.setMeanAsk("No informations");
			if ( answer.getBidMean() > 0 )
				informations.setMeanBid(Double.toString(answer.getBidMean()));
			else
				informations.setMeanBid("No informations");
			return MarshellerAndUnmarsheller.Marshall(informations);
			
		}
		else
		{
			return "<?xml version=\"1.0\"?>" + "<info>Cannot get answer from NBP.</info>";
		}
	}
}
