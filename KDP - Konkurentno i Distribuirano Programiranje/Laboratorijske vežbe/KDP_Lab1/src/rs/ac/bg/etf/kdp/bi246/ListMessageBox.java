package rs.ac.bg.etf.kdp.bi246;

import java.util.Collections;
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
	public synchronized void send(Message<T> msg, long timeToLive)
	{
		update();
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
		msg.setTTL(timeToLive);
		msg.setTimeSent(System.currentTimeMillis());
		buffer.add(msg);
		Collections.sort(buffer);
	}

	@Override
	public synchronized Message<T> receive(long timeToWait, Status status)
	{
		update();
		Message<T> msg = null;
		long requestTime = System.currentTimeMillis();
		while (buffer.size() == 0)
		{
			try
			{
				long currTime = System.currentTimeMillis();
				if ((currTime - requestTime) > timeToWait && timeToWait != 0)
				{
					status.setStatus(1);
					return null;
					
				}
				long waitFor = (timeToWait + requestTime) - currTime;
				if (waitFor > 0)
					wait(waitFor);
				else
					wait();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		msg = buffer.remove(0);
		notifyAll();
		status.setStatus(0);
		return msg;
	}

	@Override
	public void update()
	{
		for (Message<T> msg : buffer)
		{
			long currTime = System.currentTimeMillis();
			if ((currTime - msg.getTimeSent()) > msg.getTTL() && msg.getTTL() != 0)
			{
				buffer.remove(msg);
			}
		}
	}
}
