package rs.ac.bg.etf.kdp.bi246;

public class TextMessage implements Message<String>
{
	String txtmsg;
	long id;
	long ttl;
	long timeSent;
	long prior;

	@Override
	public void setBody(String body)
	{
		txtmsg = body;
		id = 0;
	}

	@Override
	public String getBody()
	{
		return txtmsg;
	}

	@Override
	public void setId(long id)
	{
		this.id = id;
	}

	@Override
	public long getId()
	{
		return id;
	}

	@Override
	public long getTTL()
	{
		return ttl;
	}

	@Override
	public void setTTL(long ttl)
	{
		this.ttl = ttl;
	}

	@Override
	public long getTimeSent()
	{

		return timeSent;
	}

	@Override
	public void setTimeSent(long timeSent)
	{
		this.timeSent = timeSent;

	}

	@Override
	public void setPriority(long priority)
	{
		prior = priority;
	}

	@Override
	public int compareTo(Priority o)
	{
		if (prior < o.getPriority())
			return -1;
		else if (prior == o.getPriority())
			return 0;
		else
			return 1;
	}

	@Override
	public long getPriority()
	{
		return prior;
	}

}
