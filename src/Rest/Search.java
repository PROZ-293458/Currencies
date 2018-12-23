package Rest;

public class Search 
{
	public static String LookFor(String table, String code, String topCount)
	{
		String answer = new String("halo");
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
		
		return answer;
	}
}
