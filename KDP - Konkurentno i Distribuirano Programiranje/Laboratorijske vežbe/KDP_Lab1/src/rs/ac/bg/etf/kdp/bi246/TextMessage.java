package rs.ac.bg.etf.kdp.bi246;

public class TextMessage implements Message<String>
{
	String txtmsg;
	long id;

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

}
