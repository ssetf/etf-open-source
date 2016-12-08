package rs.ac.bg.etf.kdp.bi246;

public interface MessageBox<T>
{
	public void send(Message<T> msg, long timeToLive);
	public Message<T> receive(long timeToWait, Status status);
	public void update();
}
