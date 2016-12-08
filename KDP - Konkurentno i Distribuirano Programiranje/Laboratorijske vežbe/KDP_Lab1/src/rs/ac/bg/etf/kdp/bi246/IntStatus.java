package rs.ac.bg.etf.kdp.bi246;

public class IntStatus implements Status
{
	private int status;
	private static final String[] messages = {"Message received","Time to Wait Excedeed"};
	@Override
	public void setStatus(int status)
	{
		this.status = status;
	}

	@Override
	public int getStatus()
	{
		return status;
	}

	@Override
	public String getMessage()
	{
		return messages[getStatus()];
	}

}
