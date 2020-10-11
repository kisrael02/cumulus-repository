public class genTask extends intialTask
{
	int time;
	Boolean possible;
	public genTask(String name, int u, int t, Boolean p)
	{
		super(name, u);
		taskName = name;
		urgency = u;
		time = t;
		possible = p;
	}

	int getTime()
	{
		return time;
	}
	void setTime(int t)
	{
		time = t;
	}

	boolean getPossible()
	{
		return possible;
	}
	void setPossible(boolean p)
	{
		possible = p;
	}
}