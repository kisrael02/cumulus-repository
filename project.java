


import java.util.ArrayList;
public class project extends genTask
{

	ArrayList<genTask> subTasks = new ArrayList<genTask>();
	String taskName;
	int urgency;
	public project(String name, int u, int time, boolean possible, ArrayList<genTask> t)
	{
		super(name, u, time, possible);
		taskName = name;
		urgency = u;
		subTasks = t;
	}
	void setSubtasks(ArrayList<genTask> t)
	{
		subTasks = t;
	}
	ArrayList<genTask> getSubtasks()
	{
		return subTasks;
	}

	void addSubTask(genTask t)
	{
		ArrayList<genTask> subTaskList = new ArrayList<genTask>();
		subTaskList.add(t);
		setSubtasks(subTaskList);
	}
}
