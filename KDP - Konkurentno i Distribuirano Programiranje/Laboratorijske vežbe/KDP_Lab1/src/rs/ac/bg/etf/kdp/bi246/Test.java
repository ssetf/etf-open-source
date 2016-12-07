package rs.ac.bg.etf.kdp.bi246;

public class Test
{

	public static void main(String[] args)
	{
		ListMessageBox buffer = new ListMessageBox(2);
		new Put(buffer);
		new Get(buffer);
	}

}
