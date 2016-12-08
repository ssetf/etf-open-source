package rs.ac.bg.etf.kdp.bi246;

public interface Message<T> extends Priority
{
	public void setBody(T body);
	public T getBody();
	public void setId(long id);
	public long getId();
	public long getTTL();
	public void setTTL(long ttl);
	public long getTimeSent();
	public void setTimeSent(long timeSent);
}
