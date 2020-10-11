public class deadTask extends genTask
{
  int dayDied;
  int monthDied;
  int yearDied;
  boolean completed;
  
  public deadTask(String name, int u, int t, boolean p, int m, int d, int y, boolean c)
  {
    super(name, u, t, p);
    dayDied = d;
    monthDied = m;
    yearDied = y;
    completed = c;
  }
  void setDayDied(int d)
  {
   dayDied = d;
  }
  int getDayDied()
  {
    return dayDied;
  }
  void setMonthDied(int m)
  {
    monthDied = m;
  }
  int getMonthDied()
  {
    return monthDied;
  }
  void setYearDied(int y)
  {
   yearDied = y;
  }
  int getYearDied()
  {
    return yearDied;
  }
  
  void setCompleted(boolean c)
  {
    completed = c;
    
  }
  boolean getCompleted()
  {
    return completed;
  }
}