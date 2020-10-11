// urgency: 0 = default, 1 = nonurgent/somedaylist 2 = urgent/follow up, 3 = urgent next action
// time: 0 = default, 1 = 2 minutes or less, 2 = more than 2 minutes
public class intialTask
{
	String taskName;
	int urgency;

	public intialTask (String name, int u)
	{
		urgency= u;
		taskName = name;
	}
	void setTaskName(String name)
	{
		taskName = name;
	}
	String getTaskName()
	{
		return taskName;
	}

	void setUrgency(int u)
	{
		urgency = u;
	}
	int getUrgency()
	{

		return urgency;
	}
}






