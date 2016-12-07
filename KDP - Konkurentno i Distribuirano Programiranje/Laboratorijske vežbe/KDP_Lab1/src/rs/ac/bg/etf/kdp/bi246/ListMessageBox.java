package rs.ac.bg.etf.kdp.bi246;

import java.util.LinkedList;
import java.util.List;

public class ListMessageBox<T> implements MessageBox<T>
{

	private List<Message<T>> buffer;
	int cap;

	public ListMessageBox(int cap)
	{
		super();
		this.cap = cap;
		this.buffer = new LinkedList<>();
	}

	@Override
	public synchronized void send(Message<T> msg, Priority prior, long timeToLive)
	{
		while (buffer.size() == cap)
		{
			try
			{
				wait();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		notifyAll();
		buffer.add(msg);
	}

	@Override
	public synchronized Message<T> receive(long timeToWait, Status status)
	{
		Message<T> msg = null;
		while (buffer.size() == 0)
		{
			try
			{
				wait();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		msg = buffer.remove(0);
		notifyAll();
		return msg;
	}
}
