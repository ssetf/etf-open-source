package rs.ac.bg.etf.kdp.bi246;

public class TextMessage implements Message<String>
{
	String txtmsg;
	long id;
	long ttl;
	long timeSent;

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

}
