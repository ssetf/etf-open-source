package rs.ac.bg.etf.kdp.bi246;

public interface Priority extends Comparable<Priority>
{
	public static final long LOW_PRIORITY = 0;
	public static final long HIGH_PRIORITY = 1000;

	public void setPriority(long priority);

	public long getPriority();
}
