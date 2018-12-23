package Rest;

public class Check 
{
	static public int CheckArgs( String table, String code, String topCount)
	{
		boolean flag = false;
		String[] pickedTable;
		String[] tableA = { "THB", "USD", "AUD", "HKD", "CAD", "NZD", "SGD", "EUR", "HUF", "CHF", "GBP",
							"UAH", "JPY", "CZK", "DKK", "ISK", "NOK", "SEK", "HRK", "RON", "BGN", "TRY",
							"ILS", "CLP", "PHP", "MXN", "ZAR", "BRL", "MYR", "RUB", "IDR", "INR", "KRW",
							"CNY", "XDR"};
		String[] tableB = {	"AFN", "MGA", "PAB", "ETB", "VES", "BOB", "CRC", "SVD", "NIO", "GMD", "MKD",
							"DZD", "BHD", "IQD", "JOD", "KWD", "LYD", "RSD", "TND", "MAD", "AED", "STN", 
							"BSD", "BBD", "BZD", "BND", "FJD", "GYD", "JMD", "LRD", "NAD", "SRD", "TTD",
							"XCD", "SBD", "VND", "AMD", "CVE", "AWG", "BIF", "XOF", "XAF", "XPF", "DJF",
							"GNF", "KMF", "CDF", "RWF", "EGP", "GIP", "LBP", "SSP", "SDG", "SYP", "GHS",
							"HTG", "PYG", "ANG", "PGK", "LAK", "MWK", "ZMW", "AOA", "MMK", "GEL", "MDL",
							"ALL", "HNL", "SLL", "SSL", "SZL", "LSL", "AZN", "MZN", "NGN", "ERN", "TWD",
							"TMT", "MRU", "TOP", "MOP", "ARS", "DOP", "COP", "CUP", "UYU", "BWP", "GTQ",
							"IRR", "YER", "QAR", "OMR", "SAR", "KHR", "BYN", "LKR", "MVR", "MUR", "NPR",
							"PKR", "SCR", "PEN", "KGS", "TJS", "UZS", "KES", "SOS", "TZS", "UGX", "BDT",
							"WST", "KZT", "MNT", "VUV", "BAM"};
		String[] tableC = { "USD", "AUD", "CAD", "EUR", "HUF", "CHF", "GBP", "JPY", "CZK", "DKK", "NOK",
							"SEK", "XDR"};
		
		
		// checking tables
		if ( table.equals("A") )
			pickedTable = tableA;
		else if ( table.equals("B") )
			pickedTable = tableB;
		else if (table.equals("C") )
			pickedTable = tableC;
		else
			return 1;
		
		// checking topCount
		if ( Integer.parseInt(topCount) >= 93 )
			return 2;
		
		// checking code
		for ( String codesTable : pickedTable )
		{
			if ( codesTable.equals(code) )
				flag = true;
		}
		if ( flag )
			return 0;
		else
			return 3;
	}
	
	
}
